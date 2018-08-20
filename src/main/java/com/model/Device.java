package com.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Created by Nir.
 */
@AllArgsConstructor
@ToString
public class Device {
    String value;
    Type type;

    public enum Type {
        SMS, EMAIL
    }
}
