package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.Module;

/**
 * Deletes a module identified using its index from the address book.
 */
public class DeleteModuleCommand extends Command {

    public static final String COMMAND_WORD = "deleteModule";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes a module from the list\n"
            + "Parameters: "
            + PREFIX_MODULE + "MODULE";

    public static final String MESSAGE_SUCCESS = "Deleted module: %s";

    public static final String MESSAGE_NO_MODULE_FOUND = "The module list is currently empty!";

    private Index targetIndex;

    /**
     * Creates an DeleteModuleCommand to add the specified {@code Person}
     */
    public DeleteModuleCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Module> lastShownList = model.getModuleList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(MESSAGE_NO_MODULE_FOUND);
        }

        Module toDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteModule(toDelete);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toDelete));
    }
}
