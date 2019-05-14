package com.ljr.study.main;

public class ItemArguments<T1, T2, T3> {
    public T1 first;
    public T2 second;
    public T3 third;

    public ItemArguments(T1 t1, T2 t2) {
        this(t1, t2, null);
    }

    public ItemArguments(T1 t1, T2 t2, T3 t3) {
        first = t1;
        second = t2;
        third = t3;
    }
}
