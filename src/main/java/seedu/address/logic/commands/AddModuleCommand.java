package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;
import seedu.address.model.module.Module;

public class AddModuleCommand extends Command {

    public static final String COMMAND_WORD = "addModule";

    public static final String MESSAGE_DUPLICATE_MODULE= "This module already exists in the address book";

    private Module toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddModuleCommand(Module module) {
        requireNonNull(module);
        toAdd = module;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        model.addModule(toAdd);

        return new CommandResult("SUCCESS!");
    }
}
