package com.ljr.study.utils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
    Category mCategory;

    @Before
    public void setup(){
        mCategory = new Category();
    }
    @Test
    public void sum() throws Exception {
        int a = 0, b= 0;
        Assert.assertTrue(a == mCategory.sum(a, b));
    }

    @Test
    public void substract() throws Exception {
    }

    @Test
    public void divide() throws Exception {
        int a = 0;
        Assert.assertTrue(mCategory != null);
    }

    @Test
    public void multiply() throws Exception {
    }

}