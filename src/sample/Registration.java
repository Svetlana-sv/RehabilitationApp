package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;


public class Registration {
    @FXML
    public TextField surname;
    @FXML
    private TextField namereg;
    @FXML
    private TextField middle_name_reg;
    @FXML
    private TextField polis_reg;
    @FXML
    private TextField login_reg;
    @FXML
    private PasswordField password_reg;
    @FXML
    private PasswordField password_confirm;
    @FXML
    private Button reg;

    private String name;
    private String surename;
    private String middle_name;
    private String polis;
    private String login;
    private String password;

    public static void start() throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxml = new FXMLLoader(Registration.class.getResource("registration.fxml"));
        Parent root = (Parent) fxml.load();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(root,600,600));
        stage.show();
    }
    @FXML
    public void registration(ActionEvent event) throws Exception{
        login = login_reg.getText();
        password = password_reg.getText();
        name=namereg.getText();
        surename=surname.getText();
        middle_name=middle_name_reg.getText();
        polis=polis_reg.getText();
        validateForm(login, password);
    }
    private void validateForm(String login,String password) throws Exception {
        if (!login.equals("") && !password.equals("")){
            Db.registration(name,surename,middle_name,polis,login, password);
            Stage stage = (Stage) reg.getScene().getWindow();
            stage.close();
            Main.startFromEtc();
        }else{
            System.out.println("Login is empty!");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение!");
            alert.setHeaderText(null);
            alert.setContentText("Вы ввели неверный логин или пароль.\nПовторите попытку!");
            alert.showAndWait();
        }
    }
}
