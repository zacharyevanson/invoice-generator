public class Driver {
    private String name;
    private String location;
    private int ordLoad;
    
    public Driver(String name, String location, int ordLoad) {
        this.name = name;
        this.location = location;
        this.ordLoad = ordLoad;
    }

    // return methods for driver class attributes that are used in Algorithm class
    public String getLocation() { return location; }
    public int getOrdLoad() { return ordLoad; }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setordLoad(int ordLoad) { this.ordLoad = ordLoad; }
}
