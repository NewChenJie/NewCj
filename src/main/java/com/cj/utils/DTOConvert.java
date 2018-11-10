package com.cj.utils;

public interface DTOConvert<S,T> {
    T convert(S s);
}
