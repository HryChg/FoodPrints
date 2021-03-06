package com.inhostudios.visionapitester.GUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;


public class Main extends Application {
    Stage window;
    FXMLLoader loader;
    Controller controller;
    Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        System.out.println(getClass());
        System.out.println(getClass().getPackage());

//        URL location = getClass().getResource("apple.jpg");
//        System.out.println(location);

//        // PATH HAS TO BE REAL PATH, NOT RELATIVE PATH
        String path = "/Users/harrychuang/Developer/PocketDoc/FoodPrints/src/main/java/com/inhostudios/visionapitester/GUI/MainFrame.fxml";
        URL location = new File(path).toURI().toURL();

        loader = new FXMLLoader(location);
        root = loader.load();
        controller = loader.getController();
        window.setTitle("FoodPrint: Zero Food Waste Recipe");
        window.setScene(new Scene(root, 1440, 900));
        window.show();


        // when use close the window, the database is updated with new records
        window.setOnCloseRequest(e -> {
            e.consume();
            System.out.println("Window Closed");
            controller.exitProcedure();
            window.close();
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}