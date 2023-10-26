package seedu.address.model.tutorial;

import java.util.Objects;

import seedu.address.model.module.Module;

/**
 * Represents a Tutorial in the address book.
 */
public class Tutorial {
    /* Fields */
    private Module module;
    private String tutName;
    private String time;

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

    public String getModuleName() {
        return module.getModuleCode();
    }

    public String getTutName() {
        return tutName;
    }

    public String getTime() {
        return time;
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
        return res.toString();
    }
}
