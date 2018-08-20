package com.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Created by Nir.
 */
@AllArgsConstructor
@ToString
public class BasicAccount {
    long userId;
    String username;
    String firstName;
    String lastName;
}
