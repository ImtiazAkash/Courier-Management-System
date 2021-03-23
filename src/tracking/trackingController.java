package tracking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class trackingController {
    @FXML
    private AnchorPane track1Anchor;

    @FXML
    private AnchorPane track2Anchor;
    
    @FXML
    private Text productID_lbl;

    @FXML
    private TextField productID_txt;

    @FXML
    private Button Track_btn;

    @FXML
    private Label textf1;

    @FXML
    private Label textf2;

    @FXML
    private Label textf3;

    @FXML
    private Label textf4;

    @FXML
    private Label date1;

    @FXML
    private Label textf1_sta;

    @FXML
    private Label textf2_sta;

    @FXML
    private Label textf3_sta;

    @FXML
    private Label textf4_sta;

    @FXML
    private Label date2;

    Connection con;
    PreparedStatement pst, pst2;
    ResultSet rs, rs2;

    @FXML
    public void track(ActionEvent event) throws IOException {
        String token = productID_txt.getText();

        try {
            if (token.equals("")) {
                JOptionPane.showMessageDialog(null, "Token Field Cannot Be Empty");
            } else {
                Class.forName("com.mysql.jdbc.Driver");
                con =  DriverManager.getConnection("jdbc:mysql://localhost/courier_db", "root", "");

                //finding product
                pst =  con.prepareStatement("select token_no from users_info where token_no =? ");
                pst.setString(1, token);

                rs = pst.executeQuery();
                if(rs.next()) {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/tracking/Traking2.fxml"));
		            track1Anchor.getChildren().setAll(pane);
                } else {
                    JOptionPane.showMessageDialog(null, "Product Not found!");
                }
            }
        } catch (ClassNotFoundException e) {
            //TODO: handle exception
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();

        }
    }
}
