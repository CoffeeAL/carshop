package com.loiko.alex.converter;

/**
 * @author Alexey Loiko
 * @project carshop
 */

@FunctionalInterface
public interface Converter<T, R> {

    R convert(T object);
}