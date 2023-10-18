package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.List;
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
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds people with the given conditions "
            + "Parameters: CONDITION1, CONDITION2, ..."
            + "[" + PREFIX_NAME + "NAME] OR [" + PREFIX_MODULE + "MODULE] \n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_MODULE + "CS1000 ";
    public static final String MESSAGE_SUCCESS = "Found the following people.";

    private final List<Name> personNameToSearch;
    private final List<Tag> moduleTagToSearch;
    /**
     * Creates an SearchByModuleCommand to add the specified {@code Person}
     */
    public SearchCommand(List<Name> personName, List<Tag> module) {
        personNameToSearch = personName;
        moduleTagToSearch = module;
    }

    private Predicate<Person> getPersonPredicateFromModule() {
        return (person -> personNameToSearch.stream()
                .allMatch(name -> person.getName().equals(name)) &&
        moduleTagToSearch.stream()
                .allMatch(moduleTag -> person.getTags().contains(moduleTag)));
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(getPersonPredicateFromModule());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
