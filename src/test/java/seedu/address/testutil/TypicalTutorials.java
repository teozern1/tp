package seedu.address.testutil;

import seedu.address.model.module.Module;
import seedu.address.model.tutorial.Tutorial;

/**
 * A utility class containing a list of {@code Tutorial} objects to be used in tests.
 */
public class TypicalTutorials {
    /* TypicalModules is not used here because it wasn't available at time of writing. Feel free to replace w/
    a typicalModule later. */
    public static final Module TESTMODULE_CS1000 = new Module("CS1000");
    public static final Module TESTMODULE_CS2000 = new Module("CS2000");
    public static final Tutorial TUTORIAL_CS1000_TUT1_MON9PM =
            new Tutorial(TESTMODULE_CS1000, "TUT1", "Mon 9pm");
    public static final Tutorial TUTORIAL_CS1000_TUT2_TUE9PM =
            new Tutorial(TESTMODULE_CS1000, "TUT2", "Tue 9pm");
}
