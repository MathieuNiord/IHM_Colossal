import controller.HomeController;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        // le menu
        FXMLLoader homeLoader = new FXMLLoader();
        homeLoader.setLocation(this.getClass().getResource("view/home.fxml"));
        Parent homeRoot = homeLoader.load();
        HomeController homeController = homeLoader.getController();

        // le menu
        FXMLLoader mainLoader = new FXMLLoader();
        mainLoader.setLocation(this.getClass().getResource("view/main.fxml"));
        Parent mainRoot = mainLoader.load();
        MainController mainController = mainLoader.getController();

        /*
        Font myFont24 = Font.loadFont(getClass().getResourceAsStream("rainyhearts.ttf"), 24);
        Font myFont48 = Font.loadFont(getClass().getResourceAsStream("rainyhearts.ttf"), 48);
        c.monTitre.setFont(myFont48);
        c.label_Script.setFont(myFont24);
         */
        Stage mainStage = new Stage();
        mainStage.setScene(new Scene(homeRoot,1260,700));
        mainStage.setResizable(false);
        mainStage.showAndWait();

        primaryStage.setScene(new Scene(mainRoot));
        primaryStage.setResizable(false);
        primaryStage.show();





    }


    public static void main(String[] args) {
        launch(args);
    }
}
