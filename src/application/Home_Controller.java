package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Home_Controller {

    @FXML
    private AnchorPane MainAnchor;

    @FXML
    private Label home_label;

    @FXML
    private ImageView home_icon;

    @FXML
    private AnchorPane HomeAnchor;

    @FXML
    private ImageView return_pkg;

    @FXML
    private ImageView pkg_send;

    @FXML
    private ImageView track_pkg;

    @FXML
    private Label pkg_send_lbl;

    @FXML
    private Label return_pkg_lbl;

    @FXML
    private Label track_pkg_lbl;

    @FXML
	public void Send_Package(MouseEvent event) throws IOException {
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Send_Parcel/send_package.fxml"));
		HomeAnchor.getChildren().setAll(pane);
    }

}

