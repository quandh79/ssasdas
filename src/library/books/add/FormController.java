package library.books.add;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import library.Main;

import java.awt.*;
import java.awt.event.ActionEvent;

public class FormController {

    public TextField txtId;
    public TextField txtName;
    public  TextField txtAuthor;
    public TextField txtQty;


    public void submit(){
        try {
            int id = Integer.parseInt(txtId.getText());
            int qty = Integer.parseInt(txtQty.getText());
            if (id<0 || txtName.getText().isEmpty() ||
            txtAuthor.getText().isEmpty() || qty < 0){
                throw new Exception("Vui long nhap du lieu");
            }

        } catch (Exception e) {

        }


    }


    public void goToList(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("/library/list/Book.fxml"));
        Scene listScene = new Scene(listPage,800,600);

        Main.rootStage.setTitle("Danh sach");
        Main.rootStage.setScene(listScene);
    }
}
