package Send_Parcel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SendPackage_Controller {
    @FXML
    private AnchorPane sendpackage_anchor;

    @FXML
    private AnchorPane MainAnchor;

    @FXML
    private Label sendpackage_lbl;

    @FXML
    private TextField pickup_txt;

    @FXML
    private Label pickup_lbl;

    @FXML
    private Label delivery_lbl;

    @FXML
    private TextField delivery_txt;

    @FXML
    private Label package_weight_lbl;

    @FXML
    private TextField package_weight_txt;

    @FXML
    private Button next_btn;

    @FXML
    private AnchorPane Book_anchor;

    @FXML
    private Label price_lbl;

    @FXML
    private Label token_lbl;

    @FXML
    private Button Book_btn;

    @FXML
    private Label showprice_lbl;

    @FXML
    private Label showtoken_lbl;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public static char[] passgen() {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[12];
  
        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));
     
        for(int i = 4; i< 12 ; i++) {
           password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }

    @FXML
	public void next(ActionEvent event) throws IOException {

        String pickup = pickup_txt.getText();
        String delivery = delivery_txt.getText();
        String weight = package_weight_txt.getText();
        char[] token = passgen();
        String token_id = String.valueOf(token);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/courier_db", "root", "");

            pst = con.prepareStatement("insert into users_info(Pickup_point, Destination_point, Weight, token_no)values(?,?,?,?)");
            pst.setString(1, pickup);
            pst.setString(2, delivery);
            pst.setString(3, weight);
            pst.setString(4, token_id);

            int status = pst.executeUpdate();

            if (pickup.equals("") || delivery.equals("") || weight.equals("")) {
                JOptionPane.showMessageDialog(null, "TextField Cannot Be Empty");
            } else if(status == 1){
                //JOptionPane.showMessageDialog(null, "Record Added");
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/Send_Parcel/Book.fxml"));
                sendpackage_anchor.getChildren().setAll(pane);
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
    
    }
}
