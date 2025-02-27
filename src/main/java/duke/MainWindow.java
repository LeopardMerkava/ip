package duke;

import duke.gui.DukeDialogBox;
import duke.gui.UserDialogBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 * Taken / adapted from Seedu JavaFX Tutorial Part4
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }


    public void setDuke(Duke d) {
        duke = d;
        greeting();
    }

    /**
     * Creates a dialog box with Duke's greeting and picture and
     * then appends them to the dialog container.
     */

    private void greeting() {
        assert userImage.getClass() != null;
        assert dukeImage.getClass() != null;
        dialogContainer.getChildren().addAll(
               DukeDialogBox.getDukeDialog(duke.greet(), dukeImage)
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing
     * Duke's reply and then appends them to the dialog container.
     * Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                UserDialogBox.getUserDialog(input, userImage),
                DukeDialogBox.getDukeDialog(response, dukeImage)
        );
        userInput.clear();
    }
}
