package com.service;

import com.model.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Nir.
 */
public class UserService {

    private ApplicationService applicationService = new ApplicationService();
    private BillingService billingService = new BillingService();


    public Mono<User> getUser(Long id) {
        return Mono.zip(objects -> new User(
                        (BasicAccount) objects[0],
                        (Devices) objects[1],
                        (BillingAccount) objects[2],
                        (AppAccount) objects[3]),
                getBasicAccount(id),
                getDevices(id),
                billingService.getUserBillingAccount(id),
                applicationService.getUserApplicationAccount(id)
        );
    }

    private Mono<Devices> getDevices(Long id) {
        Mono<List<Device>> defer = Mono.defer(() -> Mono.just(
                Arrays.asList(new Device(UUID.randomUUID().toString(), Device.Type.EMAIL),
                        new Device(UUID.randomUUID().toString(), Device.Type.SMS))
        ).subscribeOn(Schedulers.elastic()));
        return Mono.zip(objects -> new Devices((List<Device>) objects[0]), defer);
    }

    private Mono<BasicAccount> getBasicAccount(Long userId) {
        return Mono
                .defer(() -> Mono.just(new BasicAccount(userId,
                        "username_" + userId,
                        "first_name_" + userId,
                        "last_name_" + userId))
                        .subscribeOn(Schedulers.elastic()));
    }
}
