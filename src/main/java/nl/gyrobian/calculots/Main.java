package nl.gyrobian.calculots;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import nl.gyrobian.calculots.model.CalculatorCanvas;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

/**
 * The main entry point for the application.
 */
public class Main extends Application {
    private final Properties properties;

    public Main() {
        this.properties = this.getMainProperties();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        final ClassLoader classLoader = this.getClass().getClassLoader();
        Image iconImage = new Image(Objects.requireNonNull(classLoader.getResourceAsStream(this.properties.getProperty("application.icon"))));
        URL mainWindowLayout = Objects.requireNonNull(classLoader.getResource(this.properties.getProperty("application.layouts.main")));

        FXMLLoader loader = new FXMLLoader();
        loader.setClassLoader(classLoader);
        loader.setLocation(mainWindowLayout);
        Parent root = loader.load();

        primaryStage.setTitle(this.properties.getProperty("application.name") + " v" + this.properties.getProperty("application.version"));
        primaryStage.setWidth(Double.parseDouble(this.properties.getProperty("application.default_width")));
        primaryStage.setHeight(Double.parseDouble(this.properties.getProperty("application.default_height")));
        CalculatorCanvas calculatorCanvas = new CalculatorCanvas();
        calculatorCanvas.setPrefHeight(20000);
        calculatorCanvas.setPrefWidth(20000);
        VBox mainVbox = new VBox(this.buildMenuBar(), calculatorCanvas);
        mainVbox.setFillWidth(true);
        Scene scene = new Scene(mainVbox);
        scene.getStylesheets().add("javafx/main_window.css");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(iconImage);
        primaryStage.show();
        calculatorCanvas.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @return The main properties of the application, as found in main.properties.
     */
    private Properties getMainProperties() {
        final Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("main.properties"));
        } catch (IOException e) {
            System.err.println("Could not load properties from main.properties.");
        }
        return properties;
    }

    private MenuBar buildMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> {
            System.exit(0);
        });
        fileMenu.getItems().add(exitItem);

        menuBar.getMenus().add(fileMenu);
        return menuBar;
    }
}
