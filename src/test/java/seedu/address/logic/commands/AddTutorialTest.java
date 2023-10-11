package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.Module;
import seedu.address.model.tutorial.Tutorial;

public class AddTutorialTest {
    @Test
    public void execute_validModule_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Module testModule = new Module("CS1000");
        model.addModule(testModule);
        Tutorial testTutorial = new Tutorial(testModule, "test name", "test time");

        AddTutorialCommand addTutorialCommand = new AddTutorialCommand(testTutorial);

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.addModule(testModule);
        expectedModel.addTutorial(testTutorial);

        assertCommandSuccess(addTutorialCommand, model,
                String.format(AddTutorialCommand.MESSAGE_SUCCESS, testTutorial), expectedModel);
    }
}
