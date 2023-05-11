public class Customer extends Person
{
    private String customerID;

    public Customer(String name, int age, String address, String customerID)
    {
        super(name, age, address);
        this.customerID = customerID;
    }

    public Customer(Customer customer)
    {
        super(customer);
        this.customerID = customer.customerID;
    }

    public Customer()
    {
        super();
        this.customerID = "";
    }

    public String getCustomerID ()
    {
        return customerID;
    }

    public void setCustomerID (String customerID)
    {
        this.customerID = customerID;
    }

    @Override
    public boolean equals (Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return customerID.equals(customer.customerID);
    }

    @Override
    public String toString ()
    {
        return "Customer{" + "name=" + getName() + ", age=" + getAge() + ", address=" + getAddress() + ", customerID=" + customerID + '}';
    }
}
