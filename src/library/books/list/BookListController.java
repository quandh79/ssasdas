package library.books.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Main;
import library.entities.Book;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BookListController implements Initializable {
    public TableView<Book> tbBook;
    public TableColumn<Book,Integer> tdId;
    public TableColumn<Book,String> tdName;
    public TableColumn<Book,String> tdAuthor;
    public TableColumn<Book,Integer> tdQty;


    public final static String connecttionString = "jdbc:mysql://localhost:3306/t2203e";
    public final static String user = "root";
    public final static  String pwd = ""; // xampp: "", mamp: "root"

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Book,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Book,String>("name"));
        tdAuthor.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Book,Integer>("qty"));
        ObservableList<Book> ls = FXCollections.observableArrayList();
       // lay data from database

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(connecttionString,user,pwd);
            Statement statement = c.createStatement();
            String sql_txt = "select * from books";
            ResultSet rs = statement.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");
                Book b = new Book(id, name, author,qty);
                ls.add(b);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbBook.setItems(ls);
        }



    }

    public void back(javafx.event.ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("/library/home.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook, 800, 600));
    }
}
