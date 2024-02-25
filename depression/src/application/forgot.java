package application;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class forgot implements Initializable {
@FXML
private TextField mail_field;
@FXML
private PasswordField pass_field;
@FXML
Label MAIL_MSG;
@FXML
Label APPROVED_MSG;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	public void forgot_fx(ActionEvent event) throws IOException{
		String mail = mail_field.getText();
		String pass = pass_field.getText();
	switch(Methode.forgot(mail,pass,"C://Users//DELL//eclipse-workspace//depression//src//application//user.json")) {
	case 1 :
		MAIL_MSG.setText("");
		APPROVED_MSG.setText("Succesfull");
		break;
		default:
			MAIL_MSG.setText("Email Not Found");
			APPROVED_MSG.setText("");	
			break;
	};
	}

}
