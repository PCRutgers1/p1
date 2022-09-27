public enum Location {
    BRIDGEWATER("Bridgewater, 08807, Somerset County"),
    EDISON("Edison, 08837, Middlesex County"),
    FRANKLIN("Franklin, 08873, Somerset County"),
    PISCATAWAY("Piscataway, 08854, Middlesex County"),
    SOMERVILLE("Somerville, 08876, Somerset County");

    private final String location;

    private Location(String location){
        this.location = location;
    }

    public String getLocation(){
        return this.location;
    }


} //define the 5 gym locations; refer to Lecture Note #2