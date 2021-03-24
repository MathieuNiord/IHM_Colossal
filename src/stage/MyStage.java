package stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyStage extends Stage{
    public MyStage(String path) {
        super();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource(path));
            Parent root = loader.load();
            this.setScene(new Scene(root));
            this.setResizable(false);
        }
       catch (Exception ignored){}
    }
}
