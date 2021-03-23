package administration;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class returninfoController implements Initializable{
    
    @FXML
    private AnchorPane return_info_anchor;

    @FXML
    private TableView<Modeltable2> return_info;

    @FXML
    private TableColumn<Modeltable2, String> return_token;

    @FXML
    private TableColumn<Modeltable2, String> return_pickup;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    ObservableList<Modeltable2> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/courier_db", "root", "");

            pst = con.prepareStatement("select token_no, Pickup_point from returned_product");

            rs = pst.executeQuery();
            while(rs.next()) {
                oblist.add(new Modeltable2(rs.getString("token_no"), rs.getString("Pickup_point")));
            }


        } catch (ClassNotFoundException e) {
            //TODO: handle exception
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return_token.setCellValueFactory(new PropertyValueFactory<>("token"));
        return_pickup.setCellValueFactory(new PropertyValueFactory<>("pickup"));

        return_info.setItems(oblist);


    }
}
