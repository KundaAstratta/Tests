package springboot;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 20)
    private String name;

    private int age;
    // standard getters and setters, constructors

    public Employee() {
    }

    public Employee(Long id, @Size(min = 3, max = 20) String name, int age) {
        this.id = id;
        this.name = name;
        this.age=age;
    }

    public Employee( @Size(min = 3, max = 20) String name, int age) {
        this.name = name;
        this.age=age;
    }

    public Employee( @Size(min = 3, max = 20) String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}