package application;


import java.io.IOException;



import java.net.URL;

import java.util.ResourceBundle;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Gender_box implements Initializable{
	private Stage stage;
	private Parent root; 
	private Scene scene;
	String input = "C://Users//DELL//eclipse-workspace//depression//src//application//user.json";
	
	
	
@FXML
private ComboBox<String> gender_box;
@FXML
private TextField name_field;
@FXML
private TextField age_field;
@FXML
private TextField mail_field;
@FXML
private PasswordField pass_field;
@FXML
Label NAME_MSG;
@FXML
Label MAIL_MSG;
@FXML
Label APPROVED_MSG;



public void switch_login(ActionEvent event) throws IOException {
	root = FXMLLoader.load(getClass().getResource("/rous/Login.fxml"));
	scene = new Scene(root);
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	String css = this.getClass().getResource("/rous/application.css").toExternalForm();
	scene.getStylesheets().add(css);
	stage.setTitle("LOGIN");
	stage.setResizable(false);
	stage.setScene(scene);
	stage.show();
}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	 String[] gender = {"male","female"};
	ObservableList<String> genderList = FXCollections.observableArrayList(gender); 
	gender_box.setItems(genderList);
	 
	
}

public void sign_fx(ActionEvent event) throws IOException{
	String name = name_field.getText();
	String mail = mail_field.getText();
	String pass = pass_field.getText();
	String gen = gender_box.getValue();
	String input = age_field.getText();
	int age = Integer.parseInt(input);
	Person user = new Person(age,name,mail,pass,gen);
	switch(Methode.user_exist(name, mail, "C://Users//DELL//eclipse-workspace//depression//src//application//user.json")) {
	case 0:
	APPROVED_MSG.setText("Succesfull");
	MAIL_MSG.setText("");
	NAME_MSG.setText("");
	Methode.Sign_up("C://Users//DELL//eclipse-workspace//depression//src//application//user.json", user);
    Methode.switchSuggestion(event);
	break;
	case 1:
		APPROVED_MSG.setText("");
		MAIL_MSG.setText("");
		NAME_MSG.setText("Name Already used");
		break;
	case -1:
		APPROVED_MSG.setText("");
		NAME_MSG.setText("");
		MAIL_MSG.setText("Email Already used");
		break;
	case 2:
		APPROVED_MSG.setText("");
		MAIL_MSG.setText("Email Already used");
		NAME_MSG.setText("Name Already used");
		break;
	}
	}


   


   


}
