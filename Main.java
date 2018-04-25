package com.company;

import java.util.LinkedList;

public class Main {
    public static LinkedList<Integer> list = new LinkedList<>();
    public static final int MAX = 15;

    public static void main(String[] args) {
        final Object condProd = new Object();
        final Object condCons = new Object();
        Producator producator = new Producator(condProd, condCons);
        Consumator consumator = new Consumator(condProd, condCons);

        producator.start();
        consumator.start();


    }
}


