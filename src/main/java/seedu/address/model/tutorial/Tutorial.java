package seedu.address.model.tutorial;

import java.util.ArrayList;
import java.util.Objects;

import seedu.address.model.person.Person;
import seedu.address.model.tutorial.exceptions.StudentExistException;

public class Tutorial {
    /* Fields */
    private String moduleName;
    private String tutName;
    private String time;
    private ArrayList<Person> stuList = new ArrayList<>();
    private int population = stuList.size();

    /* Constructors */
    public Tutorial(String moduleName, String tutName, String time) {
        this.moduleName = moduleName;
        this.tutName = tutName;
        this.time = time;
    }

    /* Methods */

    /**
     * Add a new student to current tutorial’s student list.
     * @param newStu the new student to be added
     * @return the newStu
     * @throws NullPointerException if newStu is null
     * @throws StudentExistException if newStu is already in the tutorial
     */
    public Person addStudent(Person newStu) {
        if (newStu == null) {
            throw new NullPointerException();
        } else if (stuList.contains(newStu)) {
            throw new StudentExistException();
        }

        stuList.add(newStu);
        return newStu;
    }

    /**
     * Remove a student from current tutorial's student list
     * @param index the index of the student
     * @return the removed student
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public Person removeStudent(int index) throws IndexOutOfBoundsException {
        if (index >= population) {
            throw new IndexOutOfBoundsException();
        }

        Person removedStu = stuList.remove(index);
        return removedStu;
    }

    public String editName(String newName) {
        this.tutName = newName;
        return newName;
    }

    public String editTime(String newTime) {
        this.time = newTime;
        return newTime;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getTutName() {
        return tutName;
    }

    public String getTime() {
        return time;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutorial tutorial = (Tutorial) o;
        return Objects.equals(moduleName, tutorial.moduleName) && Objects.equals(tutName, tutorial.tutName);
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer("");
        Person p;
        for (int i = 0; i < population; i++) {
            p = stuList.get(i);
            res.append(p.toString() + "\n");
        }
        return res.toString();
    }
}
