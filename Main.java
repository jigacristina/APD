package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    static Semaphore producator = new Semaphore(1);
    static Semaphore consumator = new Semaphore(0);
    static List<Integer> list = new ArrayList<Integer>();


    public static void main(String[] args) {
        Producator producator = new Producator(list);

        Consumator consumator = new Consumator(list);

        producator.start();
        consumator.start();
    }
}


