package com.github.lj128.spring.cloud.demo.gateway;

import org.junit.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by liujia on  13:40
 */
public class GatewayTest {
    @Test
    public void testReactor(){
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6);
        Mono<Integer> mono = Mono.just(1);

        Integer[] arr = {1,2,3,4,5,6};
        Flux<Integer> flux1 = Flux.fromArray(arr);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Flux<Integer> flux2 = Flux.fromIterable(list);

        Flux<Integer> flux3 = Flux.from(flux);

        Flux<Integer> flux4 = Flux.fromStream(Stream.of(1, 2, 3, 4, 5, 6));

        Flux<Integer> flux5 = Flux.fromStream(Stream.of(1, 2, 3, 4, 5, 6, 7));

        flux.subscribe();
        System.out.println("*******************");

        flux1.subscribe(System.out::println);
        System.out.println("*******************");

        flux2.subscribe(System.out::println,System.err::println);
        System.out.println("*******************");

        flux3.subscribe(System.out::println,System.err::println,() -> System.out.println("complete"));
        System.out.println("*******************");

        flux4.subscribe(System.out::println,System.err::println,
                () -> System.out.println("complete"),
                subscription -> subscription.request(3));
        System.out.println("*******************");

        flux5.subscribe(new DemoSubscriber());
        System.out.println("*******************");
        System.out.println("ZonedDateTime.now() = " + ZonedDateTime.now());
    }


    @Test
    public void testReactor2() throws InterruptedException {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6);

        flux.map(i -> {
            System.out.println(Thread.currentThread().getName()+"-map1==>"+i);
            return i * 3;
        }).publishOn(Schedulers.elastic()).map(
                i -> {
                    System.out.println(Thread.currentThread().getName()+"-map2==>"+i);
                    return i / 3;
                }
        ).subscribeOn(Schedulers.parallel())
                .subscribe(i -> System.out.println(Thread.currentThread().getName()+"-" + i));

        Thread.sleep(10000);
    }

    class DemoSubscriber extends BaseSubscriber<Integer> {
        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            System.out.println("Subscribe");
            subscription.request(4);
        }

        @Override
        protected void hookOnNext(Integer value) {
            if(value == 4){
                //背压，通知数据源，不要发送数据了
                cancel();
            }
            System.out.println(value);
            request(1);
        }
    }
}
