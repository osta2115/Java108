package edu.sda.javaadvanced.innerClasses;

public class CommonCar {

    private String name;

    public CommonCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Wewnetrzna klasa Engine
     *
     * Klasa wewnetrzna ma dostep do wszystkich pol i metod klasy zewnetrznej
     */

    class Engine {
        private String engineType;
        private int enginePower;


        public Engine(String engineType, int enginePower) {
            this.engineType = engineType;
            this.enginePower = enginePower;
        }

        public String getEngineInfo() {
            return new StringBuilder("Silnik ")
                    .append(engineType)
                    .append(" o mocy ")
                    .append(enginePower)
                    .toString();
        }

        public String getAllCarInfo() {
            return new StringBuilder("Samochod ")
                    .append(name)
                    .append(" z silnikiem ")
                    .append(engineType)
                    .append(" o mocy ")
                    .append(enginePower)
                    .toString();
        }
    }
}
