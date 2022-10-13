package library;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.awt.event.ActionEvent;

public class HomeController {
    public void goToBookList(javafx.event.ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("books/list/Book.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }

    public void goToStudentList(javafx.event.ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("students/list/sutdentlist.fxml"));
        Main.rootStage.setTitle("Students");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }




}
