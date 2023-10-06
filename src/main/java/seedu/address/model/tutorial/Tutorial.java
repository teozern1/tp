package seedu.address.model.tutorial;

import seedu.address.model.person.Person;

import java.util.ArrayList;
import java.util.Objects;

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
    public Person addStudent(Person p) throws Exception {
        if (stuList.contains(p)) {
            throw new Exception();
        }
        stuList.add(p);
        return p;
    }

    public Person removeStudent(int index) throws Exception {
        if (index >= population) {
            throw new Exception();
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
