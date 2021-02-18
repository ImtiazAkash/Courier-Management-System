package Send_Parcel;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class send_parcel {
    
    @FXML
    private AnchorPane ChoiceAnchor;

    @FXML
    private Label choice_lbl;

    @FXML
    private Button opt_retail;

    @FXML
    private Button opt_corporate;

    @FXML
	public void Retailer(ActionEvent event) throws IOException {
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Send_Parcel/send_package.fxml"));
		ChoiceAnchor.getChildren().setAll(pane);
    }

    @FXML
	public void Corporate(ActionEvent event) throws IOException {
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Send_Parcel/send_package.fxml"));
		ChoiceAnchor.getChildren().setAll(pane);
    }
}
