import java.util.HashMap;

public class Restaurant {
    private String name;
    private String location;
    private String contNum;
    private int[] numOrders;
    private HashMap<String, Float> orders = new HashMap<String, Float>();
    private String specialReq;

    public Restaurant(String name, String location, String contNum, int[] numOrders, HashMap<String, Float> orders, String specialReq) {
        this.name = name;
        this.location = location;
        this.contNum = contNum;
        setOrders(orders);
        setNumOrders(numOrders);
        this.specialReq = specialReq;
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getContNum() { return contNum; }
    public int[] getNumOrders() { return numOrders; }
    public HashMap<String, Float> getOrders() { return orders; }
    public String getSpecialReq() { return specialReq; }

    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setNumOrders(int[] numOrders) {
        if (numOrders == null) {
            throw new IllegalArgumentException("The number of orders cannot be null.");
        }
        for (int order : numOrders) {
            if (order < 0) {
                throw new IllegalArgumentException("Order quantities cannot be negative.");
            }
        }
        if (numOrders.length != orders.size()) {
            throw new IllegalArgumentException("The number of orders must match the orders array");
        }
        this.numOrders = numOrders;
    }
    public void setOrders(HashMap<String, Float> orders) {
        if (orders == null) {
            throw new IllegalArgumentException("The ordered items cannot be null.");
        }
        for (HashMap.Entry<String, Float> entry : orders.entrySet()) {
            if (entry.getKey() == null) {
                throw new IllegalArgumentException("The ordered item does not exist.");
            }
            if (entry.getValue() == null) {
                throw new IllegalArgumentException("The price does not exist for this item.");
            }
        }
        this.orders = orders;
    }
    public void setSpecialReq(String specialReq) { this.specialReq = specialReq; }

    // defining a total cost method for the restaurant class by adding all the values in the orders hashmap
    public float getTotalCost() {
        float totalCost = 0;
        int index = 0;
        for (Float value: orders.values()) {
            if (index<numOrders.length) {
                totalCost += value*numOrders[index];
                index++;
            }
        }
        return totalCost;
    }
}
