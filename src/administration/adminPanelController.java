package administration;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class adminPanelController {
    @FXML
    private AnchorPane AdminPane;

    @FXML
    private Button ParcelInfo;

    @FXML
    private Button ReturnInfo;

    @FXML
    private AnchorPane emptypane;

    @FXML
    public void Parcel(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/administration/ParcelInfo.fxml"));
	    emptypane.getChildren().setAll(pane);
    }

    @FXML
    public void Return(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/administration/ReturnInfo.fxml"));
	    emptypane.getChildren().setAll(pane);
    }
}
