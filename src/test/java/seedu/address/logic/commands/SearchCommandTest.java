package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MODULE_CS2100;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MODULE_CS2101;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_GROUP_TG01;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TUTORIAL_GROUP_TG02;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.Module;
import seedu.address.model.person.Name;
import seedu.address.model.tag.Tag;
import seedu.address.model.tutorial.Tutorial;

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
        List<Name> nameList = new ArrayList<>(Collections.singletonList(nameToSearch));
        List<Module> moduleList = new ArrayList<>();
        List<Tutorial> tutorialList = new ArrayList<>();
        List<Tag> tagList = new ArrayList<>();
        expectedModel.updateFilteredPersonList(person -> person.getName().equals(nameToSearch));
        assertCommandSuccess(new SearchCommand(nameList, moduleList, tutorialList, tagList), model,
                SearchCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_searchByModule() {
        Module module = new Module(VALID_MODULE_CS2100);
        List<Name> nameList = new ArrayList<>();
        List<Module> moduleList = new ArrayList<>(List.of(module));
        List<Tutorial> tutorialList = new ArrayList<>();
        List<Tag> tagList = new ArrayList<>();
        expectedModel.updateFilteredPersonList(person -> person.getModules().contains(module));
        assertCommandSuccess(new SearchCommand(nameList, moduleList, tutorialList, tagList), model,
                SearchCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_searchByTutorial() {
        Module modCS2100 = new Module(VALID_MODULE_CS2100);
        Tutorial tutTG01 = new Tutorial(modCS2100, VALID_TUTORIAL_GROUP_TG01);
        List<Name> nameList = new ArrayList<>();
        List<Module> moduleList = new ArrayList<>();
        List<Tutorial> tutorialList = new ArrayList<>(List.of(tutTG01));
        List<Tag> tagList = new ArrayList<>();
        expectedModel.updateFilteredPersonList(person -> person.getTutorials().contains(tutTG01));
        assertCommandSuccess(new SearchCommand(nameList, moduleList, tutorialList, tagList), model,
                SearchCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void equals() {
        List<Name> amyNameList = new ArrayList<>(List.of(new Name(VALID_NAME_AMY)));
        List<Name> bobNameList = new ArrayList<>(List.of(new Name(VALID_NAME_BOB)));

        Module modCS2100 = new Module(VALID_MODULE_CS2100);
        Module modCS2101 = new Module(VALID_MODULE_CS2101);

        List<Module> cs2100ModuleList = new ArrayList<>(List.of(modCS2100));
        List<Module> cs2101ModuleList = new ArrayList<>(List.of(modCS2101));

        Tutorial tutTG01 = new Tutorial(modCS2100, VALID_TUTORIAL_GROUP_TG01);
        Tutorial tutTG02 = new Tutorial(modCS2100, VALID_TUTORIAL_GROUP_TG02);

        List<Tutorial> tutorialListTG01 = new ArrayList<>(List.of(tutTG01));
        List<Tutorial> tutorialListTG02 = new ArrayList<>(List.of(tutTG02));

        List<Tag> tags = new ArrayList<>();

        SearchCommand baseSearchCommand = new SearchCommand(amyNameList, cs2100ModuleList, tutorialListTG01, tags);
        SearchCommand baseSearchCommandAlt = new SearchCommand(amyNameList, cs2100ModuleList, tutorialListTG01, tags);
        SearchCommand diffNameSearchCommand = new SearchCommand(bobNameList, cs2100ModuleList, tutorialListTG01, tags);
        SearchCommand diffModSearchCommand = new SearchCommand(amyNameList, cs2101ModuleList, tutorialListTG01, tags);
        SearchCommand diffTutSearchCommand = new SearchCommand(amyNameList, cs2100ModuleList, tutorialListTG02, tags);

        // same object -> returns true
        assertTrue(baseSearchCommand.equals(baseSearchCommand));

        // same values -> returns true
        assertTrue(baseSearchCommand.equals(baseSearchCommandAlt));

        // different types -> returns false
        assertFalse(baseSearchCommand.equals(1));

        // null -> returns false
        assertFalse(baseSearchCommand.equals(null));

        // different name or mod
        assertFalse(baseSearchCommand.equals(diffNameSearchCommand));
        assertFalse(baseSearchCommand.equals(diffModSearchCommand));
        assertFalse(baseSearchCommand.equals(diffTutSearchCommand));
    }
}
