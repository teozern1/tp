package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.MODULE_CS2100;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Name;
import seedu.address.model.tag.Tag;

/**
 * Contains integration tests (interaction with the Model) and unit tests for SearchCommand.
 */
public class SearchCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_searchByName() {
        Name nameToSearch = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased()).getName();
        List<Name> nameList = new ArrayList<>(Arrays.asList(nameToSearch));
        List<Tag> moduleList = new ArrayList<>();

        expectedModel.updateFilteredPersonList(person -> person.getName().equals(nameToSearch));
        assertCommandSuccess(new SearchCommand(nameList, moduleList), model,
                SearchCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_searchByModule() {
        Tag module = new Tag(MODULE_CS2100);
        List<Name> nameList = new ArrayList<>();
        List<Tag> moduleList = new ArrayList<>(Arrays.asList(module));

        expectedModel.updateFilteredPersonList(person -> person.getTags().contains(module));
        assertCommandSuccess(new SearchCommand(nameList, moduleList), model,
                SearchCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
