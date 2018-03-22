package com.company;

import java.util.List;

public class Consumator extends Thread {

    List<Integer> list;

    public Consumator(List<Integer> list) {
        this.list = list;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Main.consumator.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("Se consuma=" + list.get(i));

            Main.producator.release();
        }
    }
}

