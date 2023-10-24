package seedu.address.model.module;

import org.junit.jupiter.api.Test;
import seedu.address.model.module.exceptions.DuplicateModuleException;
import seedu.address.model.module.exceptions.ModuleNotFoundException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

public class UniqueModuleListTest {
    private final UniqueModuleList uniqueModuleList = new UniqueModuleList();

    @Test
    public void add_duplicateTutorial_throwsDuplicateModuleException() {
        Module module = new Module("CS2100");
        uniqueModuleList.add(module);
        assertThrows(DuplicateModuleException.class, () -> uniqueModuleList.add(module));
    }

    @Test
    public void remove_moduleDoesNotExist_throwsModuleNotFoundException() {
        Module module = new Module("CS2100");
        assertThrows(ModuleNotFoundException.class, () -> uniqueModuleList.remove(module));
    }
    @Test
    public void equals() {
        UniqueModuleList test = new UniqueModuleList();

        assertTrue(test.equals(test));
        assertFalse(test.equals(1));
        assertFalse(test.equals(null));
    }
}
