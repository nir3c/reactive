package com.service;

import com.model.BillingAccount;
import org.apache.commons.lang.RandomStringUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Created by Nir.
 */
class BillingService {

    private Random random = new Random();

    Mono<BillingAccount> getUserBillingAccount(Long id) {
        return Mono.defer(
                () -> Mono.just(new BillingAccount(RandomStringUtils.randomAlphabetic(10),
                        random.nextInt(5555), LocalDateTime.now().plusDays(random.nextInt(5555))))
                        .subscribeOn(Schedulers.elastic())
        );
    }
}
