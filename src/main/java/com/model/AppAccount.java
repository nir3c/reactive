package com.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by Nir.
 */
@AllArgsConstructor
@ToString
public class AppAccount {

    LocalDateTime registrationDate;
    LocalDateTime lastAppUpdate;
    String version;
    String appToken;

}
