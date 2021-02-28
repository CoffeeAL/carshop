package com.loiko.alex.common;

import java.io.Serializable;

public interface BaseEntity<T extends Serializable> {

    T getId();
}