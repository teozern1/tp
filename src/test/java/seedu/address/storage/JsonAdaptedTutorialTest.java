package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import seedu.address.model.module.Module;
import seedu.address.model.tutorial.Tutorial;

public class JsonAdaptedTutorialTest {

    @Test
    public void toModelType_validModuleDetails_returnsModule() throws Exception {
        Module CS2030S = new Module("CS2030S");
        Tutorial T12 = new Tutorial(CS2030S, "T12", "Mon 6pm");
        JsonAdaptedTutorial tutorial = new JsonAdaptedTutorial(T12);
        assertEquals(T12, tutorial.toModelType());
    }
}
