package com.company;

public class Producator extends Thread {
    private final Object condProd;
    private final Object condCons;

    public Producator(Object condProd, Object condCons) {
        this.condProd = condProd;
        this.condCons = condCons;
    }

    public void run() {
        int p = 0;

        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (condProd) {
                if (Main.list.size() ==Main.MAX) {
                    try {
                        condProd.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Main.list.add(p);
                System.out.println("Produce: " + p) ;
                p++;
            }
            synchronized (condCons) {
                condCons.notify();
            }
        }
    }

}

