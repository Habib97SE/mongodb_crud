import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class Database_Handling
{
    private MongoClient client;
    private MongoDatabase database;

    public Database_Handling (String databaseName, String databaseUrl)
    {
        String database_Url;
        if (databaseUrl == null || databaseUrl.equals(""))
            database_Url = "mongodb://localhost:27017";
        else
            database_Url = databaseUrl;
        if (databaseName == null || databaseName.equals(""))
            throw new IllegalArgumentException("Database name cannot be null or empty");
        try
        {
            client = MongoClients.create(database_Url);
            database = client.getDatabase(databaseName);
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Document ConvertToDocument (Employee employee)
    {
        Document doc = new Document();
        doc.put("name", employee.getName());
        doc.put("age", employee.getAge());
        doc.put("address", employee.getAddress());
        doc.put("employeeID", employee.getEmployeeID());
        return doc;
    }

    public Document ConvertToDocument (Customer customer)
    {
        Document doc = new Document();
        doc.put("name", customer.getName());
        doc.put("age", customer.getAge());
        doc.put("address", customer.getAddress());
        doc.put("customerID", customer.getCustomerID());
        return doc;
    }

    public boolean insertEmployee (Employee employee)
    {
        try
        {
            Document doc = ConvertToDocument(employee);
            database.getCollection("Employee").insertOne(doc);
            return true;
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean insertCustomer (Customer customer)
    {
        try
        {
            Document doc = ConvertToDocument(customer);
            database.getCollection("Customer").insertOne(doc);
            return true;
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public Employee readEmployee (String name)
    {
        try
        {
            Document doc = database.getCollection("Employee").find(new Document("name", name)).first();
            Employee employee = new Employee();
            assert doc != null;
            employee.setName(doc.getString("name"));
            employee.setAge(doc.getInteger("age"));
            employee.setAddress(doc.getString("address"));
            employee.setEmployeeID(doc.getString("employeeID"));
            return employee;
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Employee> readAllEmployees ()
    {
        try
        {
            ArrayList<Employee> employees = new ArrayList<>();
            for (Document doc : database.getCollection("Employee").find())
            {
                Employee employee = new Employee();
                employee.setName(doc.getString("name"));
                employee.setAge(doc.getInteger("age"));
                employee.setAddress(doc.getString("address"));
                employee.setEmployeeID(doc.getString("employeeID"));
                employees.add(employee);
            }
            return employees;
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Customer> readAllCustomers ()
    {
        try
        {
            ArrayList<Customer> customers = new ArrayList<>();
            for (Document doc : database.getCollection("Customer").find())
            {
                Customer customer = new Customer();
                customer.setName(doc.getString("name"));
                customer.setAge(doc.getInteger("age"));
                customer.setAddress(doc.getString("address"));
                customer.setCustomerID(doc.getString("customerID"));
                customers.add(customer);
            }
            return customers;
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Customer readCustomer (String name)
    {
        try
        {
            Document doc = database.getCollection("Customer").find(new Document("name", name)).first();
            Customer customer = new Customer();
            assert doc != null;
            customer.setName(doc.getString("name"));
            customer.setAge(doc.getInteger("age"));
            customer.setAddress(doc.getString("address"));
            customer.setCustomerID(doc.getString("customerID"));
            return customer;
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }


    public boolean updateEmployee (String name, Employee employee)
    {
        try
        {
            Document doc = ConvertToDocument(employee);
            database.getCollection("Employee").updateOne(new Document("name", name), new Document("$set", doc));
            return true;
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean updateCustomer (String name, Customer customer)
    {
        try
        {
            Document doc = ConvertToDocument(customer);
            database.getCollection("Customer").updateOne(new Document("name", name), new Document("$set", doc));
            return true;
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteEmployee (Employee employee)
    {
        try
        {
            database.getCollection("Employee").deleteOne(new Document("employeeID", employee.getEmployeeID()));
            return true;
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteCustomer (Customer customer)
    {
        try
        {
            database.getCollection("Customer").deleteOne(new Document("customerID", customer.getCustomerID()));
            return true;
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }


}
