package service;

import model.Customer;
import java.util.*;

public class CustomerService {

    public static Map<String, Customer> mapOfCustomer = new HashMap<String, Customer>();

    public static void addCustomer(String email, String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName, email);
        mapOfCustomer.put(customer.getEmail(), customer);
    }

    public static Customer getCustomer(String customerEmail) {
        return mapOfCustomer.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers() {
        return mapOfCustomer.values();
    }
}
