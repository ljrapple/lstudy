package com.ljr.study.adapter;

public class ItemIdGenerator {

    private static int sId;

    public static int getUniqueId() {
        return sId++;
    }
}
