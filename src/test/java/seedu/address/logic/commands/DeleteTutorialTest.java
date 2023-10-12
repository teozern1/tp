package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.Module;
import seedu.address.model.tutorial.Tutorial;

public class DeleteTutorialTest {
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
}
