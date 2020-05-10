package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class Menu {
    @FXML
    private Button indicators = new Button();
    @FXML
    private Button nutrition = new Button();
    @FXML
    private Button exercise = new Button();
    @FXML
    private Button rehabilitation_program = new Button();
    @FXML
    private Button settings = new Button();
    @FXML
    private Button exit = new Button();

    public static void start() throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxml = new FXMLLoader(Registration.class.getResource("menu.fxml"));
        Parent root = (Parent) fxml.load();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Меню");
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void exit(ActionEvent event) throws Exception{
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
        Main.startFromEtc();
    }
}
