package com.company;

public class Consumator extends Thread {
    private final Object condProd;
    private final Object condCons;


    public Consumator(Object condProd, Object condCons) {
        this.condProd = condProd;
        this.condCons = condCons;
    }

    public void run() {
        int c = 0;

        while (true) {
            synchronized (condCons) {
                if (Main.list.isEmpty()){
                    try {
                        condCons.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            synchronized (condProd){
                c = Main.list.removeFirst();
                condProd.notify();
            }
            System.out.println("Consuma :" + c);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

