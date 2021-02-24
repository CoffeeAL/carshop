package com.loiko.alex.baseentity;

import java.io.Serializable;

public interface BaseEntity<T extends Serializable> {

    T getId();
}