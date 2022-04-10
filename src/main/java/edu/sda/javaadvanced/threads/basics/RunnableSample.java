package edu.sda.javaadvanced.threads.basics;

import static edu.sda.javaadvanced.threads.ThreadColor.ANSI_RED;

public class RunnableSample implements Runnable{

    @Override
    public void run() {
        System.out.println(ANSI_RED + "RunnaleSample class working");
    }
}
