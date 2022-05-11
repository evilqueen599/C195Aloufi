package controllers;

import database.UsersDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField userNameTxt;

    @FXML
    private PasswordField passTxt;

    @FXML
    private Label userLabel;

    @FXML
    private Label passLabel;

    @FXML
    private Label timeZoneLabel;

    @FXML
    private Label currentTimeZoneLabel;

    @FXML
    private SplitMenuButton languageMenu;

    @FXML
    private MenuItem frenchLangSelection;

    @FXML
    private MenuItem englishLangSelection;

    @FXML
    private Button loginBtn;

    @FXML
    private Button resetBtn;

    @FXML
    private Button exitBtn;

    private ResourceBundle resourceBundle;


    public void handleLogin(ActionEvent actionEvent) throws IOException {
        usernamePresent(userNameTxt.getText());
        passwordPresent(passTxt.getText());

        try {
            boolean validLogon = UsersDAO.validLogin(userNameTxt.getText(), passTxt.getText());

            if (validLogon) {
                loginSuccess();

                try {
                    Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                    Parent scene = FXMLLoader.load(getClass().getResource("/mainScreen.FXML"));
                    stage.setTitle("Appointment Management System");
                    stage.setScene(new Scene(scene));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {

                loginFailed();

                if (Locale.getDefault().getLanguage().equals("fr") || Locale.getDefault().getLanguage().equals("en")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle(resourceBundle.getString("loginError"));
                    alert.setHeaderText(resourceBundle.getString("incorrect"));
                    alert.setContentText(resourceBundle.getString("tryAgain"));
                    alert.showAndWait();
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private void usernamePresent(String username) {
        if (username.isEmpty()) {
            if (Locale.getDefault().getLanguage().equals("fr") || Locale.getDefault().getLanguage().equals("en")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(resourceBundle.getString("loginError"));
                alert.setHeaderText("noUser");
                alert.setContentText("tryAgain");
                alert.showAndWait();
            }
        }
    }

    private void passwordPresent(String password) {
        if (password.isEmpty()) {
            if (Locale.getDefault().getLanguage().equals("fr") || Locale.getDefault().getLanguage().equals("en")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(resourceBundle.getString("loginError"));
                alert.setHeaderText("noPassword");
                alert.setContentText("tryAgain");
                alert.showAndWait();
            }
        }
    }

    private void loginSuccess() {

    }

    private void loginFailed() {

    }

    public void handleReset(ActionEvent actionEvent) {
        userNameTxt.setText("");
        passTxt.setText("");
    }

    public void handleExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (Locale.getDefault().getLanguage().equals("fr") || Locale.getDefault().getLanguage().equals("en")) {
            ResourceBundle resource = ResourceBundle.getBundle("Language/French", Locale.getDefault());
            userLabel.setText(resource.getString("username"));
            passLabel.setText(resource.getString("password"));
            timeZoneLabel.setText(resource.getString("timezone"));
            currentTimeZoneLabel.setText(String.valueOf(ZoneId.systemDefault()));
            languageMenu.setText(resource.getString("language"));
            englishLangSelection.setText(resource.getString("english"));
            frenchLangSelection.setText(resource.getString("french"));
            loginBtn.setText(resource.getString("login"));
            resetBtn.setText(resource.getString("reset"));
            exitBtn.setText(resource.getString("exit"));
        }
    }

    public void handleEnglish(ActionEvent actionEvent) {
        ResourceBundle  resource = ResourceBundle.getBundle("Language/English");
        userLabel.setText(resource.getString("username"));
        passLabel.setText(resource.getString("password"));
        timeZoneLabel.setText(resource.getString("timezone"));
        languageMenu.setText(resource.getString("language"));
        englishLangSelection.setText(resource.getString("english"));
        frenchLangSelection.setText(resource.getString("french"));
        loginBtn.setText(resource.getString("login"));
        resetBtn.setText(resource.getString("reset"));
        exitBtn.setText(resource.getString("exit"));

    }

    public void handleFrench(ActionEvent actionEvent) {
        ResourceBundle  resource = ResourceBundle.getBundle("Language/French", Locale.getDefault());
        userLabel.setText(resource.getString("username"));
        passLabel.setText(resource.getString("password"));
        timeZoneLabel.setText(resource.getString("timezone"));
        languageMenu.setText(resource.getString("language"));
        englishLangSelection.setText(resource.getString("english"));
        frenchLangSelection.setText(resource.getString("french"));
        loginBtn.setText(resource.getString("login"));
        resetBtn.setText(resource.getString("reset"));
        exitBtn.setText(resource.getString("exit"));
    }

    public void handleEnglish(ActionEvent actionEvent) {
        ResourceBundle  resource = ResourceBundle.getBundle("Properties/English");
        userLabel.setText(resource.getString("username"));
        passLabel.setText(resource.getString("password"));
        timeZoneLabel.setText(resource.getString("timezone"));
        languageMenu.setText(resource.getString("language"));
        englishLangSelection.setText(resource.getString("english"));
        frenchLangSelection.setText(resource.getString("french"));
        loginBtn.setText(resource.getString("login"));
        resetBtn.setText(resource.getString("reset"));
        exitBtn.setText(resource.getString("exit"));

    }

    public void handleFrench(ActionEvent actionEvent) {
        ResourceBundle  resource = ResourceBundle.getBundle("Properties/French");
        userLabel.setText(resource.getString("username"));
        passLabel.setText(resource.getString("password"));
        timeZoneLabel.setText(resource.getString("timezone"));
        languageMenu.setText(resource.getString("language"));
        englishLangSelection.setText(resource.getString("english"));
        frenchLangSelection.setText(resource.getString("french"));
        loginBtn.setText(resource.getString("login"));
        resetBtn.setText(resource.getString("reset"));
        exitBtn.setText(resource.getString("exit"));
    }
}
