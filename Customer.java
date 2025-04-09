public class Customer {
    private int ordNum;
    private String name;
    private String contNum;
    private String address;
    private String city;
    private String email;
    
    public Customer(int ordNum, String name, String contNum, String address, String city, String email) {
        this.ordNum = ordNum;
        this.name = name;
        this.contNum = contNum;
        this.address = address;
        this.city = city;
        setEmail(email);
    }

    public int getOrdNum() { return ordNum; }
    public void setOrdNum(int ordNum) { this.ordNum = ordNum; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContNum() { return contNum; }
    public void setContNum(String contNum) { this.contNum = contNum; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        this.email = email;
    }

}
