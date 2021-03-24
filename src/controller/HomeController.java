package controller;

public class HomeController implements Initializable{

    @FXML
    private void button_playAction(){
        // ouverture du main
        Stage main = (Stage) Main.mainPage;
        main.show();

        // on ferme la page home
        Stage stage = (Stage) button_play.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void button_creditAction(){
        // ouverture du main
        Stage main = (Stage) Main.CreditPage;
        main.show();

        // on ferme la page home
        Stage stage = (Stage) button_credit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void button_quitAction(){
        // on ferme la page home
        Stage stage = (Stage) button_quit.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //permet de quitter le jeu
        button_play.setOnAction(event -> { button_playAction();});

        button_credit.setOnAction(event -> { button_creditAction(); });

        button_quit.setOnAction(event -> { button_quitAction(); });
    }
}
