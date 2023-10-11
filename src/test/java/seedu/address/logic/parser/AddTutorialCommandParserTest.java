package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddTutorialCommand;
import seedu.address.model.module.Module;
import seedu.address.model.tutorial.Tutorial;

public class AddTutorialCommandParserTest {
    private AddTutorialCommandParser parser = new AddTutorialCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                AddTutorialCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsAddTutorialCommand() {
        Module testModule = new Module("CS1000");
        AddTutorialCommand expectedTutorialCommand =
                new AddTutorialCommand(new Tutorial(testModule, "test name", "test time"));
        assertParseSuccess(parser, " m/CS1000 tn/test name tt/test time", expectedTutorialCommand);
    }
}
