package edu.sda.javaadvanced.threads.counter;

public class ThreadCounter extends Thread{
    private Counter counter;

    public ThreadCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.performCountdown();
    }
}
