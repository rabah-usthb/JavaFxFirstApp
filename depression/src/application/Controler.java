package application;
import java.io.IOException;





import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Controler {
    private Stage stage;
    private Parent root;
    private Scene scene;
	
   
    
    @FXML
    TextField name_field;
    @FXML
    TextField pass_field;
    @FXML
    Label ERROR_MSG;

    public void switch_signup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/rous/Sign_Up.fxml"));
        scene = new Scene(root);
        String css = this.getClass().getResource("/rous/application.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("SIGN UP");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    
    public void forgot(ActionEvent event) throws IOException{
    	  root = FXMLLoader.load(getClass().getResource("/rous/forgot.fxml"));
          scene = new Scene(root);
          String css = this.getClass().getResource("/rous/application.css").toExternalForm();
          scene.getStylesheets().add(css);
          stage = new Stage();
          stage.setTitle("FORGOT PASSWORD");
          stage.setResizable(false);
          stage.setScene(scene);
          stage.show();
    	
    }
    
    
	public void login_fx(ActionEvent event) throws IOException{
		String name = name_field.getText();
		String pass = pass_field.getText();
		ERROR_MSG.setText("");
	switch(Methode.log_in(name,pass,"C://Users//DELL//eclipse-workspace//depression//src//application//user.json")) {
	case 0:
		ERROR_MSG.setText("Not Found");
		break;
	case -1:
		ERROR_MSG.setText("Wrong Password");
		break;
	case 1:
		ERROR_MSG.setText("Welcome Back "+name);
		Methode.switchSuggestion(event);
		break;
	}
	}
}
