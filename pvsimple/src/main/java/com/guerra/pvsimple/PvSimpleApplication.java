package com.guerra.pvsimple;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Log
public class PvSimpleApplication extends Application {

    public static ConfigurableApplicationContext contextSpring;
    private String appName;
    private String appVersion;
    private FXMLLoader loader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        initApp();
        cargarFXML();
        cargarEscenaEn(primaryStage);

    }

    private void initApp() {
        contextSpring = SpringApplication.run(PvSimpleApplication.class);
        appName = contextSpring.getEnvironment().getProperty("app.name");
        appVersion = contextSpring.getEnvironment().getProperty("app.version");
    }

    private void cargarFXML() {
        loader = new FXMLLoader(getClass().getResource("/view/main.fxml"));
        loader.setControllerFactory(contextSpring::getBean);
    }

    private void cargarEscenaEn(Stage primaryStage) throws Exception {
        Scene scene = new Scene(loader.load());

        //primaryStage.setMaximized(true);
        primaryStage.setTitle(appName + " v" + appVersion);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1024);
        primaryStage.setMinHeight(640);
        primaryStage.show();
    }
}
