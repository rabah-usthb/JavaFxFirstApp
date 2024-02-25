package application;
import java.io.*;






import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Methode {
public static void Sign_up(String file_path,Person user) throws IOException {
	
	FileReader reader = new FileReader(file_path);
	Gson gson = new Gson();
    TypeToken<ArrayList<Person>> typetoken = new TypeToken<ArrayList<Person>>() {};
    ArrayList<Person> users = gson.fromJson(reader,typetoken.getType());
    if(users==null) {
    	users = new ArrayList<Person>();
    }
	users.add(user);
	String jsonString = gson.toJson(users);
	
	FileWriter file = new FileWriter(file_path,false);
	file.write(jsonString);
	
	file.close();

}

public static int user_exist(String name,String email , String file_path) throws IOException{
	FileReader reader = new FileReader(file_path);
	Gson gson = new Gson();
    TypeToken<ArrayList<Person>> typetoken = new TypeToken<ArrayList<Person>>() {};
    ArrayList<Person> users = gson.fromJson(reader,typetoken.getType());
    if(users==null) {return 0;}
    else {
    int b = 0;
    for (Person user : users) {
       if(user.name.equals(name)) {
    	 b = 1;
    	 break;
       }
       if(user.email.equals(email)) {
    	   b = -1;
    	   break;
       }
       if(user.email.equals(email) && user.name.equals(name) ) {
    	   b = 2;
    	   break;
       }
    }
    
    return b;
    }
}


public static int log_in(String name,String password , String file_path) throws IOException{
	FileReader reader = new FileReader(file_path);
	Gson gson = new Gson();
    TypeToken<ArrayList<Person>> typetoken = new TypeToken<ArrayList<Person>>() {};
    ArrayList<Person> users = gson.fromJson(reader,typetoken.getType());
    int b = 0;
    for (Person user : users) {
       if(user.name.equals(name)) {
    	  if(!user.password.equals(password)) {
    		  System.out.println(name+" this isn't your password");
    		 b = -1;
    	  }
    	  else {
    		  b = 1;
    		  break;
    	  }
       }
       
    }
    
 return b;
 
}
public static int forgot(String mail , String pass , String file_path) throws IOException {
	FileReader reader = new FileReader(file_path);
	Gson gson = new Gson();
    TypeToken<ArrayList<Person>> typetoken = new TypeToken<ArrayList<Person>>() {};
    ArrayList<Person> users = gson.fromJson(reader,typetoken.getType());
    int b = 0;
    for(Person user : users) {
    	if(user.email.equals(mail)) {
    		user.password = pass;
    		b = 1;
    		break;
    	}
    }
    if(b == 1) {
    	
    	String jsonString = gson.toJson(users);
    	
    	FileWriter file = new FileWriter(file_path,false);
    	file.write(jsonString);
    	file.close();
    }
    
  return b;
	
}

public static void switchSuggestion(ActionEvent event) throws IOException {
    Stage stage;
    Parent root;
    Scene scene;

    root = FXMLLoader.load(Methode.class.getResource("/rous/suggestion.fxml")); // Replace YourClassName with the actual name of your class
    scene = new Scene(root);
    String css = Methode.class.getResource("/rous/Suggestion.css").toExternalForm(); // Replace YourClassName with the actual name of your class
    scene.getStylesheets().add(css);
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setTitle("Suggestion");
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();
}

}
