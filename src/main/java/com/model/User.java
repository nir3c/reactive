package com.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Created by Nir.
 */
@AllArgsConstructor
@ToString
public class User {
    BasicAccount basicAccount;
    Devices devices;
    BillingAccount billingAccount;
    AppAccount appAccount;
}
