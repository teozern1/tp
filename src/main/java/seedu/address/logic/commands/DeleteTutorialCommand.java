package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.tutorial.Tutorial;

/**
 * Deletes a tutorial identified using its index from the address book.
 */
public class DeleteTutorialCommand extends Command {

    public static final String COMMAND_WORD = "deleteTutorial";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes a tutorial from the list\n"
            + "Parameters: INDEX";

    public static final String MESSAGE_SUCCESS = "Deleted tutorial: %s";

    public static final String MESSAGE_NO_TUTORIAL_FOUND = "Tutorial not found.";

    private Index targetIndex;

    /**
     * Creates an DeleteTutorialCommand to add the specified {@code Person}
     */
    public DeleteTutorialCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        requireNonNull(targetIndex);
        List<Tutorial> lastShownList = model.getTutorialList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(MESSAGE_NO_TUTORIAL_FOUND);
        }

        Tutorial toDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteTutorial(toDelete);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toDelete));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteTutorialCommand)) {
            return false;
        }

        DeleteTutorialCommand otherDeleteTutorialCommand = (DeleteTutorialCommand) other;
        return targetIndex.equals(otherDeleteTutorialCommand.targetIndex);
    }
}
