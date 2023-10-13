package seedu.address.model.person;

import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Professor in the address book.
 */
public class Professor extends Person {
    /**
     * Every field must be present and not null.
     */
    public Professor(Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        super(name, phone, email, address, tags);
    }
}
