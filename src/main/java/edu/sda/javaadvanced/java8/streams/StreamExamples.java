package edu.sda.javaadvanced.java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        /**
         * DTO czyli Data Transfer Object, czyli "wycinek obiektu utworzony w celu przeslania go do innej czesci aplikacji lub poza np do drukarki"
         * lub "zlozenie wycinkow roznych obiektow zeby wyslac je do innej czesci aplikacj lub poza (np. przez siec)"
         *
         */

        class HumanDTO {
            String name;
            String surname;

            public HumanDTO(String name, String surname) {
                this.name = name;
                this.surname = surname;
            }

            public String humanSummary() {
                return  new StringBuilder("DTO: name= ").append(name)
                        .append(" , surname=").append(surname)
                        .toString();
            }
        }

        List<Human> people = new ArrayList<>();
        people.add(new Human("Jan","Kowalski", 22));
        people.add(new Human("Marek","Kowalski", 33));
        people.add(new Human("Pawel","Kowalski", 44));
        people.add(new Human("Marian","Nowak", 15));
        people.add(new Human("Pawel","Wiewior", 55));
        people.add(new Human("Anna","Kowal", 25));

        Set<Human> peopleSet = new HashSet<>();
        peopleSet.add(new Human("Agniszka", "Zawilska", 25));
        peopleSet.add(new Human("Renata", "Zajac", 33));
        peopleSet.add(new Human("Marta", "Rolecka", 57));
        peopleSet.add(new Human("Zofia", "Papciuch", 44));
        peopleSet.add(new Human("Edyta", "Jachimczak", 38));

        /**
         * StreamApi - strumienie w Javie
         *
         * Strumien sluzy do przetwarzania grupy obiektow (albo np. linii pliku, czy komunikatow sieciowych)
         * Strumien mozna utworzyc: z kolekcji, tablicy, pliku, polaczenia z siecia, ...
         * Strumien mozna przeksztalcac
         * Strumien musi sie jakos zakonczyc, czyli z wynikiem jego dzialania musimy cos zrobic
         *
         * Sa 3 rodzaje dostepnych operacji na strumieniu:
         * 1. Tworzace strumien
         *      - stream() - z kolekcji, np. z listy
         *      - of() - z wypisanych elementow
         * 2. Posrednie (modyfikujace)
         *      - filter - odfiltruje obiekty w strumieniu wedlug zadanego warunku
         *      - limit - zawezi strumien do wskazanej ilosci elementow
         *      - map - przeksztalcenie obiektow w strumieniu na inne obiekty
         *      - distinct - usuwa duplikaty
         *      - flatmap - splaszczenie strumienia ze strumiania kolekcji do strumienia elementow kolekcji
         *      - sorted - sortowanie po zdefiniowanym komparatorze (zewnetrznym albo wewnetrzynym)
         * 3. Konczace strumien
         *      - forEach - nic nie zwraca - wykonuje akcje ktora do niej wpiszemy
         *      - collect - zbiera elementy strumienia do okreslonego typu wynikowego (lista, set, int, map, ...)
         *      - reduce - zamienia strumien elementow w jeden wynik (jakis, jakiegos typu)
         */
        System.out.println("Pierwszy strumyk, wypisanie info na temat ludzi z listy");
        people.stream()
                .forEach(someHuman -> someHuman.printHumanInfo());
        grubaKrecha();
        System.out.println("Wypiszemy samych kowalskich");
        people.stream()
                .filter(humanToCheck -> "Kowalski".equalsIgnoreCase(humanToCheck.getSurName()))
                .forEach(onlyKowalski -> onlyKowalski.printHumanInfo());
        grubaKrecha();
        System.out.println("Wypiszemy pierwsze dwie osoby z listy");
        people.stream()
                .limit(2)

                /**
                 * Operator :: czyli method reference
                 * mozna uzyc we wszystkich miejscach gdzie da sie uzyc lambdy, a jednoczesnie nie ma watpliwosci odnosnie
                 * dopasaowania parametrow we wskazanej metodziee, czyli mozemy zamienic:
                 *
                 *  human -> human.printHumanInfo() NA Human::printHumanInfo
                 *
                 *  bo na wejsciu do forEach mamy strumien obiektow Humani na kazdym z tych obiektow da sie wywolac
                 *  printUserInfo
                 *
                 *  =========
                 *
                 *  nie da sie uzyc jesli mamy obiekt ale potrzebujemy go przeksztalcic, np. wywolac metode obiektu
                 *  wewnatrz innej metody, chociazby nie da sie przerobic na:
                 *      .forEach(human -> System.out.println(human.getHumanInfo()));
                 */

                .forEach(Human::printHumanInfo);
                //.forEach(human -> System.out.println(human.getHumanInfo()));
                //.forEach(System.out::println);
        grubaKrecha();
        System.out.println("Kolejnosc operacji ma znaczenie");
        people.stream()
                .filter(human -> "Pawel".equalsIgnoreCase(human.getName()))
                .limit(1)
                .forEach(Human::printHumanInfo);
        System.out.println("-------------------------------");
        people.stream()
                .limit(1)
                .filter(human -> "Pawel".equalsIgnoreCase(human.getName()))
                .forEach(Human::printHumanInfo);
        grubaKrecha();
        System.out.println("Strumien ludzi zamienimy na strumien imion i wypiszemy imiona");
        people.stream()
                .map(Human::getName)
                //.map(human -> human.getName()) <- to samo co wyzej
                .forEach(System.out::println);
        grubaKrecha();
        System.out.println("Strumien ludzi zamienimy na strumien imion i je wypiszemy ale bez powtorzen");
        people.stream()
                .map(Human::getName)
                .distinct()
                .forEach(System.out::println);
        grubaKrecha();
        System.out.println("Z listy ludzi wygenerujemy liste HumanDTO");
        List<HumanDTO> dtosList = people.stream()
                .map(human -> new HumanDTO(human.getName(), human.getSurName()))
                .collect(Collectors.toList());
        dtosList.forEach(dto -> System.out.println(dto.humanSummary()));
        grubaKrecha();
        System.out.println("Laczenie dwoch streamow");
        List<Human> humanConcat = Stream.of(people,peopleSet)
                //na wyjsciu of mamy strumien dwuelementowy "lista ludzi, set ludzi"
                .flatMap(coll -> coll.stream())
                //na wyjsciu flatMap mamy strumien n-elementowy "ludzi" wyciagnietych z listy iseta
                .collect(Collectors.toList());
        //forEach jest motoda ktora moze dzialac na strumieniu, ale tez na elementach kolekcji
        humanConcat.forEach(Human::printHumanInfo);
        grubaKrecha();
        System.out.println("Mozna nalozyc kilka filtow");
        humanConcat.stream()
                .filter(human -> human.getAge() > 25)
                .filter(human -> human.getAge() < 48)
                .forEach(Human::printHumanInfo);
        grubaKrecha();
        System.out.println("Posortujmy ludzi na wydruk");
        humanConcat.stream()
                .sorted()
                .forEach(Human::printHumanInfo);
        grubaKrecha();
        System.out.println("Possortuj ludzi komparatorem zewnetrznym");
        humanConcat.stream()
                .sorted(new HumanComparedByName())
                .forEach(Human::printHumanInfo);
        grubaKrecha();
        System.out.println("Wyliczymy sume lat wszystkich ludzi");
        int sumAge = humanConcat.stream()
                .map(Human::getAge) // ze strumienia ludzi robimy strumien Int

                /**
                 * reduce:
                 * okreslamy wartosc poczatkowa (u nas 0)
                 * piszemy lambde, ktora definiuje jak postepowac z kolejnymi elementami strumienia
                 */

                .reduce(0, (aktualnyWynik, kolejnyElementStrumienia) -> aktualnyWynik + kolejnyElementStrumienia);
        System.out.println("Wyliczona suma lat: " + sumAge);
        grubaKrecha();
        System.out.println("Zbierzmy wszystkie nazwiska do jednego stringa");
        String surnamesConcat = humanConcat.stream()
                .map(Human::getSurName)
                .collect(Collectors.joining());
        System.out.println(surnamesConcat);
        System.out.println("Jak wyzej, ale z rozdzieleniem przecinkami i spacjami");
        surnamesConcat = humanConcat.stream()
                .map(Human::getSurName)
                .collect(Collectors.joining(", "));
        System.out.println(surnamesConcat);
        System.out.println("Jak wyzej, ale z okresleniem poczatku i konca napisu");
        surnamesConcat = humanConcat.stream()
                .map(Human::getSurName)
                .collect(Collectors.joining(", ","{","}"));
        System.out.println(surnamesConcat);
        System.out.println("Wersja hardcore");
        surnamesConcat = humanConcat.stream()
                .map(Human::getSurName)
                .collect(Collectors.joining("}, {","[{","}]"));
        System.out.println(surnamesConcat);
        grubaKrecha();
        System.out.println("Przechodzimy z listy na set");
        Set<Human> peopleResultSet = people
                .stream()
                .collect(Collectors.toSet());
        grubaKrecha();
        System.out.println("Zrobimy z naszej listy mape, gdzie zgrupujemy ludzi po nazwisku");
        Map<String, List<Human>> peopleBySurnames = humanConcat.stream()
                .collect(Collectors.groupingBy(Human::getSurName, Collectors.toList()));
        printMap(peopleBySurnames);
        grubaKrecha();
        System.out.println("Mapa wiek - czlowiek");
//        Map<Integer, Human> humanByAge = humanConcat.stream()
//                .collect(Collectors.toMap(each -> each.getAge(), each -> each));
//        for (Integer age : humanByAge.keySet()){
//            System.out.println(age);
//            System.out.println(humanByAge.get(age).getHumanInfo());
//        }
        grubaKrecha();
        System.out.println("Wyswietlimy najstarszego ludzia");
        Optional <Integer> maxAge = humanConcat.stream()
                .map(Human::getAge)
                .max(Integer::compareTo);
        System.out.println("Mamy optionala trzeba sprawdzic czy ma co wyswietlic");
        if (maxAge.isPresent()){
            System.out.println("Max age: " + maxAge.get());
        }
        grubaKrecha();
        System.out.println("Jesli chcemy dostac liste a brak pasujace to mozemy zwrocic pusta liste");
        List<Human> nowaki = peopleBySurnames.entrySet().stream()
                .filter(stringListEntry -> stringListEntry.getKey().equalsIgnoreCase("Walczak"))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseGet(() -> Collections.EMPTY_LIST);
        nowaki.forEach(Human::printHumanInfo);
    }

    private static void printMap(Map<String, List<Human>> map) {
        System.out.println("Drukujemy zawartosc listy");
        for (String key : map.keySet()){
           System.out.println("\n" + key);
           System.out.println(map.get(key));
       }
    }

    private static void grubaKrecha() {
        System.out.println("=========================");
        System.out.println("=========================");
    }
}
