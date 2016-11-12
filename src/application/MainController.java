/**
 * Sample Skeleton for "simple.fxml" Controller Class
 * Use copy/paste to copy paste this code into your favorite IDE
 **/

package application;

import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main.Type;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TableView;


public class MainController
    implements Initializable {

    @FXML
    private ChoiceBox CPchoice, Quickchoice, Mainchoice;
    @FXML
    private TableView table;
    @FXML
    private Button removeButton, addButton;
    @FXML
    private TextField messageBoard;
    
    public void setTypeValues(ObservableList<Main.Type> types){
    	Quickchoice.setItems(types);
    	Mainchoice.setItems(types);
    }
    
    public void setCPValues(ObservableList<Integer> cps){
    	CPchoice.setItems(cps);
    }

    public int getCP(){
    	return (Integer) CPchoice.getSelectionModel().getSelectedItem();
    }
    
    public Main.Type getQuick(){
    	return (Type) Quickchoice.getSelectionModel().getSelectedItem();
    }
    
    public Main.Type getMain(){
    	return (Type) Mainchoice.getSelectionModel().getSelectedItem();
    }
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert CPchoice != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert Quickchoice != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert Mainchoice != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert table != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert removeButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert addButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert messageBoard != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

    }

}