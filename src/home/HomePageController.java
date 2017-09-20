package home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class HomePageController {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label invalid;



    String cusername = "zack";
    String cpass = "caponio";

    public void handelSignIn(){

    }
    public void openSignUpPage()throws Exception{

        Stage createSignUpPage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        createSignUpPage.setTitle("Sign Up");
        createSignUpPage.setScene(new Scene(root, 300,275));
        createSignUpPage.show();
    }
    public void openSignedInPage() throws Exception{
        if(username.getText().equalsIgnoreCase(cusername) && password.getText().equals(cpass)) {
            Stage createSignedInPage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("SignedInPage.fxml"));
            createSignedInPage.setTitle("website");
            createSignedInPage.setScene(new Scene(root, 300, 275));
            createSignedInPage.show();
        }else{
            invalid.setVisible(true);
        }
    }

}
