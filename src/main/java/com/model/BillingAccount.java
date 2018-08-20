package com.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by Nir.
 */
@AllArgsConstructor
@ToString
public class BillingAccount {
    String bankAccount;
    long credit;
    LocalDateTime nextChargeTime;
}
