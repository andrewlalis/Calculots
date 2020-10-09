package nl.gyrobian.calculots;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(iconImage);
        primaryStage.show();
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
}
