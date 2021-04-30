import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.classes.MyStage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MyStage myStage = new MyStage("../fxml/home.fxml");
        myStage.setTitle("Colossal Caveman Adventure");
        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
