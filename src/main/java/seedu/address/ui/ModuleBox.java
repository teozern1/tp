package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import seedu.address.model.module.Module;

public class ModuleBox extends UiPart<Region> {

    private static final String FXML = "ModuleBox.fxml";

    public Module module;

    @FXML
    private HBox modulePane;

    @FXML
    private Text modulesTaken;
    
    public ModuleBox() {
        super(FXML);
        modulesTaken.setText("Modules taken: CS2100");
        modulesTaken.setStroke(Color.WHITE);
    }
}
