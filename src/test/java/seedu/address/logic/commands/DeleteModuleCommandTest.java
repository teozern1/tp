package seedu.address.logic.commands;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalModules.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.Module;
import seedu.address.model.tutorial.Tutorial;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code DeleteModuleCommand}.
 */
public class DeleteModuleCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validModuleList_success() {
        Module moduleToDelete = model.getModuleList().get(INDEX_FIRST_PERSON.getZeroBased());
        DeleteModuleCommand deleteModuleCommand = new DeleteModuleCommand(INDEX_FIRST_PERSON);

        String expectedMessage = String.format(DeleteModuleCommand.MESSAGE_SUCCESS, moduleToDelete);

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.deleteModule(moduleToDelete);

        assertCommandSuccess(deleteModuleCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_validModuleListWithTutorials_success() {
        Module module = model.getModuleList().get(INDEX_FIRST_PERSON.getZeroBased());
        Tutorial tutorialOne = new Tutorial(module, "T12", "Mon 2pm");
        Tutorial tutorialTwo = new Tutorial(module, "T13", "Mon 4pm");

        model.addTutorial(tutorialOne);
        model.addTutorial(tutorialTwo);
        assertTrue(model.getTutorialList().size() == 2);

        model.deleteModule(module);
        assertTrue(model.getTutorialList().size() == 0);
    }

    @Test
    public void execute_invalidIndexList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getModuleList().size() + 1);
        DeleteModuleCommand deleteModuleCommand = new DeleteModuleCommand(outOfBoundIndex);

        assertCommandFailure(deleteModuleCommand, model, "The module list is currently empty!");
    }

    @Test
    public void equals() {
        DeleteModuleCommand deleteFirst = new DeleteModuleCommand(INDEX_FIRST_PERSON);
        DeleteModuleCommand deleteSecond = new DeleteModuleCommand(INDEX_SECOND_PERSON);

        // same object -> returns true
        assertTrue(deleteFirst.equals(deleteFirst));

        // same values -> returns true
        DeleteModuleCommand deleteFirstCopy = new DeleteModuleCommand(INDEX_FIRST_PERSON);
        assertTrue(deleteFirst.equals(deleteFirstCopy));

        // different types -> returns false
        assertFalse(deleteFirst.equals(1));

        // null -> returns false
        assertFalse(deleteFirst.equals(null));

        // different person -> returns false
        assertFalse(deleteFirst.equals(deleteSecond));
    }
}
