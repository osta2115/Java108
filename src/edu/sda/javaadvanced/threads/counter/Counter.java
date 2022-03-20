package edu.sda.javaadvanced.threads.counter;

import static edu.sda.javaadvanced.threads.ThreadColor.*;

public class Counter {
    private int i;

    public void performCountdown() {
        String color;
        String name = Thread.currentThread().getName();
        switch (name){
            case "one":
                color = ANSI_CYAN;
                break;
            case "two":
                color = ANSI_PURPLE;
                break;
            default:
                color = ANSI_BLUE;
        }

        /**
         * synchronized mozemy tez nalozyc blok kodu
         */
        synchronized (this) {
            doRealCounting(color);
        }
    }

    /**
     * Slowo kluczowe synchronized powoduje, ze jak watek zacznie juz wykonywac kawalek kodu opisany "synchronized"
     * to ma go skonczyc. System nie pozwoli na przerwanie dzialania tego kodu i "oddanie go" innemu watkowi
     */
    //private synchronized void doRealCounting(String color)
    private void doRealCounting(String color) {
        for (i = 10; i > 0; i--) {
            //gdzies tu nastepuje zatrzymanie watku i uruchomienie (wznowienie) drugiego
            System.out.println(color + Thread.currentThread().getName() + " i=" + i);
        }
    }
}
