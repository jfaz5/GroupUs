package us.group.client.ui.gui;

import javafx.stage.Stage;
import us.group.client.ui.UserInterface;
import us.group.client.types.UserInterfaceType;

public class GraphicalUserInterface extends UserInterface {
    private GraphicalUserInterfaceHelper guiHelper;

    public GraphicalUserInterface() {
        this.guiHelper = new GraphicalUserInterfaceHelper();
    }

    public UserInterfaceType getUIType() {
        return UserInterfaceType.GUI;
    }

    public void start(Stage primaryStage) {
        this.guiHelper.start(primaryStage);
    }

}
