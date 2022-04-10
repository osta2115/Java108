package edu.sda.javaadvanced.io.classic;

import java.io.*;
import java.util.Scanner;

public class ReadWriteFile {

    /**
     * FileWriter i FileReader zapisuja / odczytuja znak po znaku co jes ok dla malych plikow, ale dla duzych juz nie,
     * bo powoduje duza ilosc zadan zapisu / odczytu, a nawet przy dzisiejszej technologii SSD odczyt i zapis dysku
     * dlugo trwa
     */

    public void simpleWriteToFile(String fileName) {
        System.out.println("Trying to write some content to " + fileName);
        //try-with-resources
        try (FileWriter writer = new FileWriter(fileName)){
            writer.write("Sample line one \n");
            writer.write("Sample line two \n");
            writer.write("Sample line three \n");
        }catch (IOException e) {
            System.out.println("Error when writing to file");
            e.printStackTrace();
        }
    }

    public void simpleReadFromFile(String fileName) {
        System.out.println("Trying to read content from " + fileName + "\n");

        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            System.out.println("\n Odczyt zakonczony");
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.println("Some error when reading file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String firstFile = "FirstFile.txt";
        ReadWriteFile readWriteFile = new ReadWriteFile();
        readWriteFile.simpleWriteToFile(firstFile);
        System.out.println("===========================");
        readWriteFile.simpleReadFromFile(firstFile);

        String anotherFileName = "SecondFile.txt";
        readWriteFile.writeWithBuffer(anotherFileName);
        System.out.println("===========================");
        readWriteFile.readWithBuffer(anotherFileName);

    }

    /**
     * Odczyt i zapis pliku z buforawaniem, czyli pomiedzy programem ktory nam dziala, a plikiem na ktorym wykonujemy
     * operacje jest "bufor pamieciowy" do ktorego trafia zawartosc, ktora ma byc finalnie zapisana do pliku badz z niego
     * odczytama. Po zakonczeniu czytania / pisania lub po przepelnieniu bufora nastepuje odczyt / zapis.
     * Jesli bylo to po przepelnieniu to operacja jest powtarzana z nowa zawartoscia.
     */

    public void writeWithBuffer(String fileName) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("Sample line one \n");
            writer.write("Sample line two \n");
            writer.write("Sample line three \n");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readWithBuffer(String fileName) {
        String input;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Trying to read with buffer from " + fileName);
            while ((input = reader.readLine()) != null){
                System.out.println(input);
            }
            System.out.println("Odczyt zakonczony");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
