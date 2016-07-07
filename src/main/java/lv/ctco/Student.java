package lv.ctco;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Student {


    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Assignment> assignments = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> list) {
        this.assignments = list;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
}