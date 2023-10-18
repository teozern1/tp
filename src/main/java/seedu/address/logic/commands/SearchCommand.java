package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.model.Model;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

/**
 * Searches for all persons in the address book that fit the given parameters.
 */
public class SearchCommand extends Command {
    public static final String COMMAND_WORD = "search";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds user based on given module. ";
    public static final String MESSAGE_SUCCESS = "Found the following people.";

    private final Name personNameToSearch;
    private final Tag moduleTagToSearch;
    /**
     * Creates an SearchByModuleCommand to add the specified {@code Person}
     */
    public SearchCommand(Name personName, Tag module) {
        personNameToSearch = personName;
        moduleTagToSearch = module;
    }

    private Predicate<Person> getPersonPredicateFromModule() {
        return (person -> (personNameToSearch == null || personNameToSearch.equals(person.getName()))
                && (moduleTagToSearch == null || person.getTags().contains(moduleTagToSearch)));
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(getPersonPredicateFromModule());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
