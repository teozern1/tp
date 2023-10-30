package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL_TIME;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.Module;
import seedu.address.model.tutorial.Tutorial;

/**
 * Adds a module to the address book.
 */
public class AddTutorialCommand extends Command {
    public static final String COMMAND_WORD = "addTutorial";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a tutorial to the list\n"
            + "Parameters: "
            + PREFIX_MODULE + "MODULE "
            + PREFIX_TUTORIAL_NAME + "TUTORIAL_NAME "
            + PREFIX_TUTORIAL_TIME + "TUTORIAL_TIME(e.g. Mon 2PM)";

    public static final String MESSAGE_SUCCESS = "New tutorial added: %s";

    public static final String MESSAGE_DUPLICATE_TUTORIAL = "This tutorial already exists in the address book";

    private final Tutorial toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddTutorialCommand(Tutorial tutorial) {
        requireNonNull(tutorial);
        toAdd = tutorial;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.hasModule(new Module(toAdd.getModuleName()))) {
            throw new CommandException(Messages.MESSAGE_INVALID_MODULE);
        }

        if (model.hasTutorial(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_TUTORIAL);
        }

        model.addTutorial(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddTutorialCommand)) {
            return false;
        }

        AddTutorialCommand otherAddTutorialCommand = (AddTutorialCommand) other;
        return toAdd.equals(otherAddTutorialCommand.toAdd);
    }
}
