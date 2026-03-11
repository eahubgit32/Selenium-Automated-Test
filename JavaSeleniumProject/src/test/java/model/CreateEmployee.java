package model;

public class CreateEmployee {

    private String name;
    private String durationWorked;
    private String email;
    private String salary;
    private String role;
    private String age;

    public CreateEmployee(String name, String durationWorked, String email, String salary, String role, String age) {
        this.name = name;
        this.durationWorked = durationWorked;
        this.email = email;
        this.salary = salary;
        this.role = role;
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public String getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getDurationWorked() {
        return durationWorked;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDurationWorked(String durationWorked) {
        this.durationWorked = durationWorked;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
