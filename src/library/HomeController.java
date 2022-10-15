package library;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.awt.event.ActionEvent;
import java.util.Objects;

import static javafx.fxml.FXMLLoader.load;

public class HomeController {
    public void goToBookList(javafx.event.ActionEvent actionEvent) throws Exception{
        Parent listBook = load(getClass().getResource("books/list/Book.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }

    public void goToStudentList(javafx.event.ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("/library/students/list/list.fxml"));
        Scene listScene = new Scene(listPage,800,600);

        Main.rootStage.setTitle("Thanh vien");
        Main.rootStage.setScene(listScene);
    }


}





