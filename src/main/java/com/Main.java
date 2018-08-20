package com;

import com.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nir.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        UserService userService = new UserService();

        List<Long> longs = Arrays.asList(1L, 2L, 3L, 4L);

        Flux.fromIterable(longs)
                .flatMap(userService::getUser)
                .subscribeOn(Schedulers.elastic())
                .subscribe(System.out::println);


        Thread.sleep(10000000L);


    }
}
