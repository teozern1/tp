package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddTutorialCommand;
import seedu.address.logic.commands.DeleteTutorialCommand;
import seedu.address.model.module.Module;
import seedu.address.model.tutorial.Tutorial;

public class DeleteTutorialCommandParserTest {
    private DeleteTutorialCommandParser parser = new DeleteTutorialCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteTutorialCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsAddTutorialCommand() {
        assertParseSuccess(parser, "1", new DeleteTutorialCommand(INDEX_FIRST_PERSON));
    }
}
