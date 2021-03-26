import javafx.application.Application;
import javafx.stage.Stage;
import stage.MyStage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MyStage myStage = new MyStage("../view/home.fxml");
        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
