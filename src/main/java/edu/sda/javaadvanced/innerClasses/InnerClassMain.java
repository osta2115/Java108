package edu.sda.javaadvanced.innerClasses;

public class InnerClassMain {

    public static void main(String[] args) {
        //najpierw tworzymy obiekt zewnetrzny
        CommonCar commonCar = new CommonCar("BMW");

        //Obiekt wewnetrzny
        CommonCar.Engine engine = commonCar.new Engine("Diesel", 150);

        System.out.println(engine.getEngineInfo());
        System.out.println("====================");
        System.out.println(engine.getAllCarInfo());
        System.out.println("====================");
        System.out.println(commonCar.getName());
    }
}
