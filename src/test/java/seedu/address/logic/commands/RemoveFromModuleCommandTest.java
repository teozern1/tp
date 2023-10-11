package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.Module;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.PersonBuilder;

public class RemoveFromModuleCommandTest {
    @Test
    public void execute_indexTooBig_errorMessage() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

        assertCommandFailure(new RemoveFromModuleCommand(Index.fromZeroBased(999),
                new Module("CS1000")), model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }
    @Test
    public void execute_moduleNotFound_errorMessage() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

        assertCommandFailure(new RemoveFromModuleCommand(INDEX_FIRST_PERSON, new Module("CS1000")), model,
                Messages.MESSAGE_INVALID_MODULE);
    }

    @Test
    public void execute_validIndexAndModule_success() {
        // delayed due to requiring a way to put modules into models.
    }

    @Test
    public void equals() {
        Module test1 = new Module("CS1000");
        Module test2 = new Module("CS2000");
        RemoveFromModuleCommand removeFromModuleCommand = new RemoveFromModuleCommand(INDEX_FIRST_PERSON,
                test1);
        RemoveFromModuleCommand removeFromModuleSecondCommand = new RemoveFromModuleCommand(INDEX_SECOND_PERSON,
                test2);

        // same object -> returns true
        assertTrue(removeFromModuleCommand.equals(removeFromModuleCommand));

        // same values -> returns true
        RemoveFromModuleCommand addToModuleCommandCopy = new RemoveFromModuleCommand(INDEX_FIRST_PERSON,
                test1);
        assertTrue(removeFromModuleCommand.equals(addToModuleCommandCopy));

        // different types -> returns false
        assertFalse(removeFromModuleCommand.equals(1));

        // null -> returns false
        assertFalse(removeFromModuleCommand.equals(null));

        // different person -> returns false
        assertFalse(removeFromModuleCommand.equals(removeFromModuleSecondCommand));
    }

    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        RemoveFromModuleCommand removeFromModuleCommand = new RemoveFromModuleCommand(INDEX_FIRST_PERSON,
                new Module("CS1000"));
        String expected = RemoveFromModuleCommand.class.getCanonicalName() + "{index=" + targetIndex + "}";
        assertEquals(expected, removeFromModuleCommand.toString());
    }
}
