package seedu.address.testutil;

import seedu.address.model.module.Module;

/**
 * Creates a {@code ModuleBuilder} with the default details.
 */
public class ModuleBuilder {
    public static String MODULE_CODE;

    /**
     * Creates a {@code ModuleBuilder} with the default details.
     */
    public ModuleBuilder() {
        MODULE_CODE = "CS2100";
    }

    public ModuleBuilder(Module module) {
        MODULE_CODE = module.getModuleCode();
    }

    public Module build() {
        return new Module(MODULE_CODE);
    }

    public Module build(String moduleCode) {
        return new Module(moduleCode);
    }
}
