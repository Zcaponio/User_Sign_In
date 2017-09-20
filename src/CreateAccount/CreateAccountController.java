package CreateAccount;

import home.HomePageController;
import home.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import javax.swing.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class CreateAccountController {
    @FXML
    PasswordField newPassword;
    @FXML
    PasswordField confirmPassword;
    @FXML
    TextField username;
    @FXML
    TextField email;
    @FXML
    Button browse;

    HomePageController hompage = new HomePageController();
    ArrayList<User> userList = new ArrayList<User>();
    User newuser = new User();

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public void browseDir(){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null){
            newuser.setPhoto(selectedFile);
        }else{
            System.out.println("none selected");
        }
    }

    public void createAccount() throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);


        String password = newPassword.getText();
        String newEmail = email.getText();

        if (!password.matches(".*[a-z]+.*")) {
            alert.setContentText("must contain lower case letter");
            alert.showAndWait();
        }
        else if(!password.matches(".*[A-Z]+.*")) {
            alert.setContentText("Must contain capital letter");
            alert.showAndWait();
        }
        else if(!password.matches(".*[\\d]+.*")) {
            alert.setContentText("Must contain a digit letter");
            alert.showAndWait();
        }
        else if(!password.matches(".*[^\\w]+.*")) {
            alert.setContentText("Must contain a Special Charachter");
            alert.showAndWait();
        }
        else if (!password.equals(confirmPassword.getText())) {

        }else if(!newEmail.matches(".+[\\@].+[\\.].+")) {
            alert.setContentText("Wrong email format");
            alert.showAndWait();
        }else if(!password.equals(confirmPassword.getText())) {
            alert.setContentText("Passwords dont match");
            alert.showAndWait();
        }else{
            User newuser = new User(username.getText(), confirmPassword.getText(), email.getText());
            userList.add(newuser);
            hompage.openSignUpPage();


            System.out.println(newuser.getPhoto());


        }
    }
}
