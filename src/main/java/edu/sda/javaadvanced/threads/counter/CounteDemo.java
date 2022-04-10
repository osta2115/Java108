package edu.sda.javaadvanced.threads.counter;

public class CounteDemo {

    public static void main(String[] args) {
        Counter counter = new Counter();

        /**
         * Counter symbolizuje wspolny zasob
         */

        ThreadCounter threadCounter1 = new ThreadCounter(counter);
        ThreadCounter threadCounter2 = new ThreadCounter(counter);

        threadCounter1.setName(ThreadName.THREAD_ONE.getName());
        threadCounter2.setName(ThreadName.THREAD_TWO.getName());

        threadCounter1.start();
        threadCounter2.start();
    }
}
