package com.guerra.pvsimple.controller;

import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {


    public ImageView img;
    @Value("${app.version}")
    private String appVersion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //load imagen from absolute path
        img.setImage(new javafx.scene.image.Image("file:///home/jaasiel/Descargas/demo.png"));

    }

}
