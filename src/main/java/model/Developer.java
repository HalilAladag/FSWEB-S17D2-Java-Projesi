package model;

public class Developer {

    private int id;
    private String name;
    private double salary;
    private experience experience;


    public enum experience{
        JUNIOR,
        MID,
        SENIOR;
    }

    public Developer(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.experience = experience;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Developer.experience getExperience() {
        return experience;
    }

    public void setExperience(Developer.experience experience) {
        this.experience = experience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
