package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.Module;
import seedu.address.model.person.Person;
import seedu.address.model.tutorial.Tutorial;
import seedu.address.testutil.PersonBuilder;

public class AddToTutorialCommandTest {
    /* Note to Bingxi: This test was made to cover the part I told you I would do: adding module when adding tutorial.
    Tests not involving addition of modules, such as when there are invalid inputs, have intentionally been omitted. */
    @Test
    public void execute_validArgs_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Module testModule = new Module("CS1000");
        Tutorial testTutorial = new Tutorial(testModule, "test tutorial name", "Mon 6pm");
        model.addModule(testModule);
        model.addTutorial(testTutorial);

        Person personWithModuleAndTutorial = new PersonBuilder(model.getAddressBook().getPersonList().get(0))
                .withModules(testModule).withTutorials(testTutorial).build();
        AddToTutorialCommand addToTutorialCommand = new AddToTutorialCommand(INDEX_FIRST_PERSON, testTutorial);
        String expectedMessage = String.format(AddToTutorialCommand.MESSAGE_SUCCESS,
                Messages.format(personWithModuleAndTutorial));
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.addModule(testModule);
        expectedModel.addTutorial(testTutorial);
        expectedModel.setPerson(model.getFilteredPersonList().get(0), personWithModuleAndTutorial);

        assertCommandSuccess(addToTutorialCommand, model, expectedMessage, expectedModel);
    }
}
