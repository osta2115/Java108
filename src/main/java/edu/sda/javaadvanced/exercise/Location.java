package edu.sda.javaadvanced.exercise;

public enum Location {

    SEA("m", "morze", "sea"),
    LAKE("j", "jezioro", "lake"),
    LAND("l", "lad", "land");

    private String shortName;
    private String plName;
    private String engName;

    Location(String shortName, String plName, String engName) {
        this.shortName = shortName;
        this.plName = plName;
        this.engName = engName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getPlName() {
        return plName;
    }

    public String getEngName() {
        return engName;
    }

    public static Location findByShortName(String shortName) {
        for (Location location : Location.values()) {
            if (shortName.equalsIgnoreCase(location.shortName)){
                return location;
            }
        }
        return null;
    }
}
