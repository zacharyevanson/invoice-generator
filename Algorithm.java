import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;

public class Algorithm {
    public static void main(String[] args) {
        Customer customer = createCustomer();
        Restaurant restaurant = createRestaurant();
        writeInvoice(customer, restaurant);
        assignDriver(restaurant, customer);
    }

    private static Customer createCustomer() {
        return new Customer(1234, "Zach Evanson", "9876543210", "42 Appleseed Close, Gardens", 
        "Cape Town", "evansonzach@gmail.com");
    }

    private static Restaurant createRestaurant() {
        int[] numOrders = {1, 2};
        HashMap<String, Float> orders = new HashMap<String, Float>() {{
            put("Chicken Burger with Chips", 124.99f);
            put("Greek Salad", 89.99f);
        }};
        return new Restaurant("Egghead", "Cape Town", "0123456789", numOrders, orders, 
        "Extra bacon please!");
    }

    private static void writeInvoice(Customer customer, Restaurant restaurant) {
        // file path to either create or update order.txt file
        String filePath = "Files/invoice.txt";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath))) {
            br.write("Order Number: " + customer.getOrdNum() + "\n");
            br.write("Customer Name: " + customer.getName() + "\n");
            br.write("Contact Number: " + customer.getContNum() + "\n");
            br.write("City: " + customer.getCity() + "\n");
            br.write("Email: " + customer.getEmail() + "\n\n");

            br.write("You have ordered the following from " + restaurant.getName() + " in " + restaurant.getLocation() + ":\n\n");
            int index = 0; // Index to track the quantity in numOrders and match indices of numOrders and orders
            for (Map.Entry<String, Float> entry : restaurant.getOrders().entrySet()) {
                if (index < restaurant.getNumOrders().length) {
                    br.write(restaurant.getNumOrders()[index] + " x " + entry.getKey() + " (R" + entry.getValue() + ")\n");
                    index++;
                }
            }
            br.write("\nSpecial Request: " + restaurant.getSpecialReq() + "\n\n");
            br.write("Total Cost: R" + restaurant.getTotalCost() + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void assignDriver(Restaurant restaurant, Customer customer) {
        // intializing the DriverSelector object and reading drivers from drivers.txt file
        DriverSelector driverSelector = new DriverSelector();
        driverSelector.readDriversFromFile("Files/driver-info.txt");
        // running getBestDriver to determine the best driver based on location and order number
        Driver driver = driverSelector.getBestDriver(restaurant.getLocation());
        String filePath = "Files/invoice.txt";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath, true))) {
            if (driver == null) {
                br.write("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
                return;
            }
            br.write(driver.getName() + " is nearest to the restaurant and will be delivering your order at:\n\n");
            br.write(customer.getAddress() + "\n\n");

            br.write("If you need to contact the restaurant, their number is " + restaurant.getContNum() + ".\n\n");
    // catching IOException if file is not found
        } catch (IOException e) {
        e.printStackTrace();
        }
    }   
}