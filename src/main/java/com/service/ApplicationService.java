package com.service;

import com.model.AppAccount;
import org.apache.commons.lang.RandomStringUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Nir.
 */
class ApplicationService {

    private Random random = new Random();
    private List<String> versions = Arrays.asList("1.0.0", "1.0.1", "1.1.0", "2.0.0");

    Mono<AppAccount> getUserApplicationAccount(Long id) {
        return Mono.defer(
                () -> Mono.just(new AppAccount(LocalDateTime.now().minusDays(random.nextInt(10)),
                        LocalDateTime.now().minusHours(random.nextInt(10)),
                        versions.get(random.nextInt(versions.size())),
                        RandomStringUtils.random(20))
                ).subscribeOn(Schedulers.elastic())
        );

    }
}
