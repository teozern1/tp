package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

import seedu.address.model.module.Module;

public class ModuleBox extends UiPart<Region> {

    private static final String FXML = "ModuleBox.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public Module module;

    @FXML
    private HBox modulePane;
    
    public ModuleBox() {
        super(FXML);
        // TODO: placeholder text, implement logic!
        this.module = new Module("CS2100");
    }
}
