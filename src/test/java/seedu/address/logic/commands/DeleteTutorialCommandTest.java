package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.Module;
import seedu.address.model.tutorial.Tutorial;

public class DeleteTutorialCommandTest {
    @Test
    public void execute_outOfBoundsIndex_errorMessage() {
        /* Needs Jackson's addressBook fix (so addressBook copies also copies modules) to work, not taking it from
        from his fork in order to not interfere with RepoSense contribution.
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Module testModule = new Module("CS1000");
        model.addModule(testModule);
        Tutorial testTutorial = new Tutorial(testModule, "test name", "test time");
        model.addTutorial(testTutorial);
        DeleteTutorialCommand deleteTutorialCommand = new DeleteTutorialCommand(Index.fromOneBased(999));

        assertCommandFailure(deleteTutorialCommand, model, DeleteTutorialCommand.MESSAGE_NO_TUTORIAL_FOUND);
        */
    }

    @Test
    public void execute_validModule_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Module testModule = new Module("CS1000");
        model.addModule(testModule);
        Tutorial testTutorial = new Tutorial(testModule, "test name", "test time");
        model.addTutorial(testTutorial);
        DeleteTutorialCommand deleteTutorialCommand = new DeleteTutorialCommand(INDEX_FIRST_PERSON);

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.addModule(testModule);

        assertCommandSuccess(deleteTutorialCommand, model,
                String.format(DeleteTutorialCommand.MESSAGE_SUCCESS, testTutorial), expectedModel);
    }

    @Test
    public void equals() {
        DeleteTutorialCommand deleteTutorialCommand = new DeleteTutorialCommand(INDEX_FIRST_PERSON);
        DeleteTutorialCommand deleteSecondTutorialCommand = new DeleteTutorialCommand(INDEX_SECOND_PERSON);

        // same object -> returns true
        assertTrue(deleteTutorialCommand.equals(deleteTutorialCommand));

        // same values -> returns true
        DeleteTutorialCommand deleteTutorialCommandCopy = new DeleteTutorialCommand(INDEX_FIRST_PERSON);
        assertTrue(deleteTutorialCommand.equals(deleteTutorialCommandCopy));

        // different types -> returns false
        assertFalse(deleteTutorialCommand.equals(1));

        // null -> returns false
        assertFalse(deleteTutorialCommand.equals(null));

        // different person -> returns false
        assertFalse(deleteTutorialCommand.equals(deleteSecondTutorialCommand));
    }
}
