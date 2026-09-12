package viewController;

import controller.TallerController;
import app.App;

public class TallerViewController {

    //Vincular App
    App app;
    public void setApp(App app) {
        this.app = app;
    }

    //Vincular controller
    TallerController tallerController;
    public void setTallerController(TallerController tallerController) {
        this.tallerController = tallerController;
    }



}
