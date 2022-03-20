package edu.sda.javaadvanced.threads.basics;

import static edu.sda.javaadvanced.threads.ThreadColor.ANSI_BLUE;

public class SeparateThread extends Thread{


    /**
     * Jak definiujemy klase rozszerzajaca Thread to koniecznie nalezy w tej klasei nadpisac metode run(),
     * ktora odpowiada za wykonanie zadan, ktore maja sie znalezc w osobny watku
     */

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Separate thread is running");
        System.out.println(ANSI_BLUE + "Thread name: " + currentThread().getName());

        try {
            sleep(4000);
            System.out.println(ANSI_BLUE + currentThread().getName() + " slept enough");
        } catch (InterruptedException e){
            System.out.println(ANSI_BLUE + currentThread().getName() + "INTERRUPTED");
        }
    }
}
