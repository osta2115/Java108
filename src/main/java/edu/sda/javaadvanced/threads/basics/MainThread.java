package edu.sda.javaadvanced.threads.basics;

import static edu.sda.javaadvanced.threads.ThreadColor.*;

public class MainThread {

    public static void main(String[] args) {

        /**
         * Kolejnosc wykonywania watkow nie jest tozsama z kolejnoascia ich wywolan w kodzie, CZYLI to ze w pierwszej
         * linii utowrzymy i uruchomimy nowy watek, nie oznacza, ze zacznie sie on wykonywac od razu, ani ze wykona sie
         * przed kolejnymi liniami watku glownego
         */

        System.out.println(ANSI_PURPLE + "MAIN thread in action");

        /**
         * Kod nowego watku jest umieszczany w metodzie run(), ALE aby wystartowac nowy watek wywolamy metode start(),
         * BO jesli wywolamy metode run() to nowy watek sie wcale nie stworzy tylko program zadziala "linia po linii"
         * w ramach jednego watku
         * start() - startuje nowy watek i dziala rownolegle do glownego
         * run() - wywoluje sie watek w watku glownym
         */

        SeparateThread separateThread = new SeparateThread();
        separateThread.setName("=== Osobny watek ===");
        separateThread.start();
        //separateThread.run();

        /**
         * Jesli korzystawm z interfejsu Runnable to wywolanie w osobny watku nalezy opakowac w klase Thread (albo
         * klase ktora rozszerza Thread)
         */

        Thread runnableSample = new Thread(new RunnableSample());
        runnableSample.start();

        // RunnableSample runnableSample = new RunnableSample(); - nie wywola osobnego watku, nie ma dostepnej metody start()

        /**
         * Watek wywolujemy na klasie anonimowej wtedy kiedy chcemy zrobic na zasadzie "uruchom i zapomnij"
         * i nie zamierzamy sprawdzac tego osobnego watku
         */

        new Thread(){
            public void run() {
                System.out.println(ANSI_GREEN + "Anonymous class working as well");
            }
        }.start();

        /**
         * Mozna tymczasowo / jednorazowo nadpisac klase np. RunnableSample i na tej "jednorazowce" tez odpalic watek
         */

        runnableSample = new Thread(new RunnableSample(){
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "Overwritten RunnableSample");

                /**
                 * Laczenie watkow metoda join() - bedziemy czekac az ten dolaczony skonczy robote
                 */
                try {
                    separateThread.join();
                    System.out.println(ANSI_CYAN + "SeparateThread FINISHED, overwritten RunnableSamples contiunes");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_CYAN + "Overwritten RunnableSample iterrupted");
                }
            }
        });
        runnableSample.start();

        //przerwanie sleepa w SeparateThread
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //separateThread.interrupt();
        //runnableSample.interrupt();

        System.out.println(ANSI_PURPLE + "End of MAIN thread");
    }
}
