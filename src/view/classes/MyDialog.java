package view.classes;

import javafx.stage.Modality;
import javafx.stage.StageStyle;
import stage.MyStage;

public class MyDialog extends MyStage {

    public MyDialog(String path) {
        super(path);
        initStyle(StageStyle.TRANSPARENT);
        initModality(Modality.APPLICATION_MODAL);
    }
}
