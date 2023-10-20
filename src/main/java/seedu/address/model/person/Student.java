package seedu.address.model.person;

import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Student in the address book.
 */
public class Student extends Person {
    /**
     * Every field must be present and not null.
     */
    public Student(Name name, Phone phone, Email email, Address address, Set<Tag> tags, StudentNumber studentNumber) {
        super(name, phone, email, address, tags, studentNumber);
    }
}
