package seedu.address.model.assignment;

import seedu.address.commons.util.ToStringBuilder;
import java.util.Objects;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents a Assignment in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Assignment {
    // Identity fields
    private final Title title;

    /**
     * Every field must be present and not null.
     */
    public Assignment(Title title) {
        requireAllNonNull(title);
        this.title = title;
    }

    public Title getTitle() {
        return title;
    }

    public boolean isSameAssignment(Assignment otherAssignment) {
        if (otherAssignment == this) {
            return true;
        }

        return otherAssignment != null
                && otherAssignment.getTitle().equals(getTitle());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Assignment)) {
            return false;
        }

        Assignment otherAssignment = (Assignment) other;
        return title.equals(otherAssignment.title);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("title", title)
                .toString();
    }
}
