public class Employee extends Person
{
    private String employeeID;

    public Employee (String name, int age, String address, String employeeID)
    {
        super(name, age, address);
        this.employeeID = employeeID;
    }

    public Employee (Employee employee)
    {
        super(employee);
        this.employeeID = employee.employeeID;
    }

    public Employee ()
    {
        super();
        this.employeeID = "";
    }

    public String getEmployeeID ()
    {
        return employeeID;
    }

    public void setEmployeeID (String employeeID)
    {
        this.employeeID = employeeID;
    }

    @Override
    public boolean equals (Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return employeeID.equals(employee.employeeID);
    }

    @Override
    public String toString ()
    {
        return "Employee{" + "name=" + getName() + ", age=" + getAge() + ", address=" + getAddress() + ", employeeID=" + employeeID + '}';
    }
}
