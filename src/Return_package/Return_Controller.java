package Return_package;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Return_Controller {
    @FXML
    private Label returnpkg_lbl;

    @FXML
    private AnchorPane Returnpkg_anchor;

    @FXML
    private TextField returnaddress_txt;

    @FXML
    private Label returntoken_lbl;

    @FXML
    private TextField returntoken_txt;

    @FXML
    private Button returnpkg_btn;

    @FXML
    public void Return(ActionEvent event) throws IOException {
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Return_package/Thanks.fxml"));
		Returnpkg_anchor.getChildren().setAll(pane);
    }
}
