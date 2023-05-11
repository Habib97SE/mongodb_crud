import com.mongodb.client.MongoClients;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main
{
    public static final String DB_NAME = "CompanyCrud";
    public static final String CONNECTION_STRING = "mongodb://localhost:27017";

    public static Database_Handling db = new Database_Handling(DB_NAME, CONNECTION_STRING);



    public static void readAll (String collectionName)
    {
        System.out.println("Reading all " + collectionName + "s");
        System.out.println("====================================");
        if(collectionName.equals("Employee"))
        {
            ArrayList<Employee> employees = db.readAllEmployees();
            for (Employee employee : employees)
                System.out.println(employee.toString());
        }
        else if(collectionName.equals("Customer"))
        {
            ArrayList<Customer> customers = db.readAllCustomers();
            for (Customer customer : customers)
                System.out.println(customer.toString());
        }
        else
            System.out.println("Invalid input");
        System.out.println("====================================");
    }

    public static void main (String[] args)
    {
        Employee employee1 = new Employee("John", 25, "Street 1", "123");
        Employee employee2 = new Employee("Jane", 30, "Street 2", "456");
        Employee employee3 = new Employee("Jack", 35, "Street 3", "789");

        Customer customer1 = new Customer("Adam", 25, "Street 3", "123123");
        Customer customer2 = new Customer("Eva", 30, "Street 4", "456456");
        Customer customer3 = new Customer("Lilith", 35, "Street 5", "789789");

        db.insertEmployee(employee1);
        db.insertEmployee(employee2);
        db.insertEmployee(employee3);

        db.insertCustomer(customer1);
        db.insertCustomer(customer2);
        db.insertCustomer(customer3);

        // Read all employees
        readAll("Employee");

        // Read all customers
        readAll("Customer");

        // update employee2
        String oldName = employee2.getName();
        employee2.setName("Jane Doe");
        employee2.setAge(40);
        db.updateEmployee(oldName, employee2);

        // update customer2
        oldName = customer2.getName();
        customer2.setName("Eva Doe");
        customer2.setAge(40);
        db.updateCustomer(oldName, customer2);

        // read all employees
        readAll("Employee");

        // read all customers
        readAll("Customer");


        // delete employee3
        db.deleteEmployee(employee3);

        // delete customer3
        db.deleteCustomer(customer3);


        readAll("Employee");
        readAll("Customer");



    }
}
// Nästa vecka Fre. DEADLINE för grupparbetet