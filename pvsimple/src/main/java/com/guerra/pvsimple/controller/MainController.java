package com.guerra.pvsimple.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {

    @Value("${app.version}")
    private String appVersion;

    @FXML
    private Label lblVersion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblVersion.setText(appVersion);
    }

}
