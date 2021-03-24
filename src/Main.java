import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("view/main.fxml"));
        Parent root = loader.load();

        MainController c = loader.getController();
        /*
        Font myFont24 = Font.loadFont(getClass().getResourceAsStream("rainyhearts.ttf"), 24);
        Font myFont48 = Font.loadFont(getClass().getResourceAsStream("rainyhearts.ttf"), 48);
        c.monTitre.setFont(myFont48);
        c.label_Script.setFont(myFont24);
         */
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
