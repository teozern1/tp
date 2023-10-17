package seedu.address.model.tutorial;

import java.util.ArrayList;
import java.util.Objects;

import seedu.address.model.module.Module;
import seedu.address.model.person.Person;
import seedu.address.model.tutorial.exceptions.StudentExistException;

/**
 * Placeholder comment.
 */
public class Tutorial {
    /* Fields */
    private Module module;
    private String tutName;
    private String time;
    private ArrayList<Person> stuList = new ArrayList<>();
    private int population = stuList.size();

    /* Constructors */

    /**
     * Placeholder comment.
     * @param module
     * @param tutName
     * @param time
     */
    public Tutorial(Module module, String tutName, String time) {
        this.module = module;
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

    /**
     * Placeholder comment.
     * @param newName
     * @return
     */
    public String editName(String newName) {
        this.tutName = newName;
        return newName;
    }

    /**
     * Placeholder comment.
     * @param newTime
     * @return
     */
    public String editTime(String newTime) {
        this.time = newTime;
        return newTime;
    }

    public String getModuleName() {
        return module.getModuleCode();
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tutorial tutorial = (Tutorial) o;
        return Objects.equals(module, tutorial.module) && Objects.equals(tutName, tutorial.tutName);
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer("");
        res.append(module.getModuleCode() + " ");
        res.append(this.getTutName() + " ");
        res.append(this.getTime() + " ");
        Person p;
        for (int i = 0; i < population; i++) {
            p = stuList.get(i);
            res.append(p.toString() + "\n");
        }
        return res.toString();
    }

    /**
     * Placeholder comment.
     * @param otherTutorial
     * @return
     */
    public boolean isSameTutorial(Tutorial otherTutorial) {
        if (otherTutorial == this) {
            return true;
        }

        return this.module.equals(otherTutorial.module) && this.tutName.equals(otherTutorial.tutName);
    }
}
