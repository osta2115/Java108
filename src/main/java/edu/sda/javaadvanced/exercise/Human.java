package edu.sda.javaadvanced.exercise;

public abstract class Human implements Sailor{

    private String name;
    private String lastName;

    private Gender gender;
    private Location location;


    public Human(String name, String lastName, Gender gender) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public Location getLocation() {
        return location;
    }

    public Location adjustLocation(String newLocationShortName){
        //TODO add setting new location
        Location foundLocation = Location.findByShortName(newLocationShortName);
        if (foundLocation != null){
            System.out.println("Lokalizacja znaleziona, ustawiam na: " + foundLocation.getPlName());
            location = foundLocation;
        }
        return  location;
    }

    @Override
    public String sail() {
        //ENUM mozna sprawdzac przez == bo sie nie zmieniaja nam obiekty
        if (location == Location.LAND) {
            throw new LackOfWaterException(location.getPlName());
        }
        return "Sailing over " + location.getEngName();
    }
}
