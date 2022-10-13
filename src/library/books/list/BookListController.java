package library.books.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.entities.Book;

import java.net.URL;
import java.util.ResourceBundle;

public class BookListController implements Initializable {
    public TableView<Book> tbBook;
    public TableColumn<Book,Integer> tdId;
    public TableColumn<Book,String> tdName;
    public TableColumn<Book,String> tdAuthor;
    public TableColumn<Book,Integer> tdQty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Book,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Book,String>("name"));
        tdAuthor.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Book,Integer>("qty"));
        ObservableList<Book> ls = FXCollections.observableArrayList();
        ls.add(new Book(1, "tri do thai", "Abc", 10));
        ls.add(new Book(2, "tri ", "Ac", 11));
        tbBook.setItems(ls);

    }
}
