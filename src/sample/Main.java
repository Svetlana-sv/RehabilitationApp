package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @FXML
    private Button registration = new Button();
    @FXML
    private Button authorization = new Button();
    @FXML
    private TextField log = new TextField();
    @FXML
    private TextField pass = new TextField();
    public String login;
    public String password;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("App");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public static void startFromEtc() throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxml = new FXMLLoader(Registration.class.getResource("main.fxml"));
        Parent root = (Parent) fxml.load();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("App");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void clickOnAuthorization(ActionEvent event) throws Exception {
        login = log.getText().trim();
        password = pass.getText().trim();
        validateForm(login,password);
        if (Db.authorization(login, password)) {
            Stage stage = (Stage) authorization.getScene().getWindow();
            stage.close();
            Menu.start();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение!");
            alert.setHeaderText(null);
            alert.setContentText("Вы ввели неверный логин или пароль.\nПовторите попытку!");
            alert.showAndWait();
        }
    }

    @FXML
    private void clickOnRegistration(ActionEvent event) throws Exception {
        Stage stage = (Stage) registration.getScene().getWindow();
        stage.close();
        Registration.start();
    }
    private void validateForm(String login,String password) throws Exception {
        if (!login.equals("") && !password.equals("")){
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
