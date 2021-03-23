package Return_package;

import java.io.IOException;


import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    Connection con;
    PreparedStatement pst, pst2;
    ResultSet rs, rs2;

    @FXML
    public void Return(ActionEvent event) throws IOException {
      String token = returntoken_txt.getText();
      String pickup = returnaddress_txt.getText();

      try {
        if (token.equals("")) {
          JOptionPane.showMessageDialog(null, "Token Field Cannot Be Empty");
      } else {
        Class.forName("com.mysql.jdbc.Driver");
        con =  DriverManager.getConnection("jdbc:mysql://localhost/courier_db", "root", "");

        //finding product
        pst =  con.prepareStatement("select token_no from users_info where token_no =? ");
        pst.setString(1, token);

        //adding the product that has been returned
        pst2 = con.prepareStatement("insert into returned_product(token_no, Pickup_point) values(?,?)");
        pst2.setString(1, token);
        pst2.setString(2, pickup);

        rs=pst.executeQuery();
        int status = pst2.executeUpdate();

        if(rs.next() && status==1) {
          JOptionPane.showMessageDialog(null, "Thank You For Using Our Service!");
        } else {
          JOptionPane.showMessageDialog(null, "Product Not Found!");
        }
      }
      } catch (ClassNotFoundException e) {
        //TODO: handle exception
        e.printStackTrace();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
}
