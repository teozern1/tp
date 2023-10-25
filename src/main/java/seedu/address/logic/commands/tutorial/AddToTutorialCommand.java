package seedu.address.logic.commands.tutorial;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_NAME;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.Module;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.StudentNumber;
import seedu.address.model.tag.Tag;
import seedu.address.model.tutorial.Tutorial;

/**
 * Edits the details of an existing person in the address book.
 */
public class AddToTutorialCommand extends Command {

    public static final String COMMAND_WORD = "addToTutorial";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a user to a given tutorial "
            + "Parameters:"
            + "INDEX (must be a positive integer)"
            + "[" + PREFIX_MODULE + "MODULE_NAME]"
            + "[" + PREFIX_TUTORIAL_NAME + "TUTORIAL_NAME]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_MODULE + "CS2103T "
            + PREFIX_TUTORIAL_NAME + "T11 ";

    public static final String MESSAGE_SUCCESS = "Edited Person: %1$s";

    private final Index index;

    private final Tutorial tutorialToAddTo;

    /**
     * @param index of the person in the filtered person list to add tag to
     * @param tutorialToAddTo the target tutorial to add the person
     */
    public AddToTutorialCommand(Index index, Tutorial tutorialToAddTo) {
        requireNonNull(index);
        requireNonNull(tutorialToAddTo);
        this.index = index;
        this.tutorialToAddTo = tutorialToAddTo;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        if (!model.hasTutorial(tutorialToAddTo)) {
            throw new CommandException(Messages.MESSAGE_INVALID_TUTORIAL);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        Person editedPerson = createEditedPerson(personToEdit);

        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(editedPerson)));
    }

    /**
     * Creates and returns a {@code Person} with the details of {@code personToEdit}
     * edited with {@code editPersonDescriptor}.
     */
    private Person createEditedPerson(Person personToEdit) {
        assert personToEdit != null;

        Name updatedName = personToEdit.getName();
        Phone updatedPhone = personToEdit.getPhone();
        Email updatedEmail = personToEdit.getEmail();
        Address updatedAddress = personToEdit.getAddress();
        Set<Tag> updatedTags = personToEdit.getTags();
        Set<Module> updatedModules = personToEdit.getModules();
        Set<Tutorial> updatedTutorials = new HashSet<>(personToEdit.getTutorials());
        updatedTutorials.add(tutorialToAddTo);
        StudentNumber updatedStudentNumber = personToEdit.getStudentNumber();
        Telegram updatedTelegram = personToEdit.getTelegram();

        return new Person(updatedName, updatedPhone, updatedEmail, updatedAddress, updatedTags, updatedModules,
                updatedTutorials, updatedStudentNumber, updatedTelegram);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof seedu.address.logic.commands.tutorial.AddToTutorialCommand)) {
            return false;
        }

        AddToTutorialCommand otherCommand = (AddToTutorialCommand) other;

        return this.tutorialToAddTo.equals(otherCommand.tutorialToAddTo)
                && this.index.equals(otherCommand.index);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("index", index)
                .add("tutorialName", tutorialToAddTo)
                .toString();
    }

}
