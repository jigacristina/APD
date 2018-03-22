package com.company;

import java.util.List;

public class Producator extends Thread {

    List<Integer> list;

    public Producator(List<Integer> list) {
        this.list = list;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Main.producator.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Se produce=" + i);
            list.add(i);
            Main.consumator.release();
        }
    }
}
