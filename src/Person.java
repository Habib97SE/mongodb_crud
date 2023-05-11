public class Person
{
    private String name;
    private int age;
    private String address;

    public Person (String name, int age, String address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person (Person person)
    {
        this.name = person.name;
        this.age = person.age;
        this.address = person.address;
    }

    public Person ()
    {
        this.name = "";
        this.age = 0;
        this.address = "";
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public int getAge ()
    {
        return age;
    }

    public void setAge (int age)
    {
        this.age = age;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    @Override
    public boolean equals (Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && address.equals(person.address);
    }

    @Override
    public String toString ()
    {
        return String.format("Name: %s, Age: %d, Address: %s", name, age, address);
    }
}
