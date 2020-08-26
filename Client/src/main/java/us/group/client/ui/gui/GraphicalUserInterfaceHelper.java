package us.group.client.ui.gui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.stage.Screen;
import java.io.InputStream;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.control.Separator;
import javafx.application.Application;
import javafx.collections.ObservableList;

public class GraphicalUserInterfaceHelper extends Application {
    
    /**
     * Creates a button to be displayed on the left sidebar.
     *
     * @param icon The image to be displayed on the button.
     * @param tooltipMessage The tooltip message to be displayed on mouse hover.
     * @return Button The created button.
     */

    private Button createLeftSidebarButton(Image icon, String tooltipMessage) {
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(30);
        iconView.setFitHeight(30);

        Button button = new Button();
        button.setGraphic(iconView);
        button.setTooltip(new Tooltip(tooltipMessage));

        button.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 60px; " +
                        "-fx-min-height: 60px; " +
                        "-fx-max-width: 60px; " +
                        "-fx-border-color: black; " +
                        "-fx-border-radius: 5em; " +
                        "-fx-border-width: 2px; " +
                        "-fx-max-height: 60px;"
        );

        return button;
    }

    /**
     * Returns the display window height.
     *
     * @return int Window height.
     */

    private int getWindowHeight() {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        return (int)Math.ceil(bounds.getHeight());
    }

    @Override
    public void start(Stage primaryStage) {
        // Vertical boxes for left side of screen
        VBox firstVerticalBox = new VBox(10);
        VBox secondVerticalBox = new VBox(10);

        // Separators for left side of screen
        Separator firstSeparator = new Separator(Orientation.HORIZONTAL);
        Separator secondSeparator = new Separator(Orientation.VERTICAL);
        int windowHeight = getWindowHeight();
        secondSeparator.setStyle("-fx-height: " + windowHeight + "px; -fx-min-height: " + windowHeight + "px;");

        // Object for loading resources
        ClassLoader classLoader = getClass().getClassLoader();

        // Create home button for left side of screen
        InputStream homeIconStream = classLoader.getResourceAsStream("img/home_icon.png");
        Image homeIconImage = new Image(homeIconStream);
        Button homeButton = createLeftSidebarButton(homeIconImage, "Home");

        // Create add server button for left side of screen
        InputStream plusIconStream = classLoader.getResourceAsStream("img/plus_icon.png");
        Image plusIconImage = new Image(plusIconStream);
        Button addServerButton = createLeftSidebarButton(plusIconImage, "Add a Server");

        // Add components to left sidebar
        ObservableList firstVerticalBoxList = firstVerticalBox.getChildren();
        firstVerticalBoxList.add(secondVerticalBox);
        firstVerticalBoxList.add(homeButton);
        firstVerticalBoxList.add(firstSeparator);
        firstVerticalBoxList.add(addServerButton);

        // Horizontal boxes for left side of screen
        HBox firstHorizontalBox = new HBox(10);
        HBox secondHorizontalBox = new HBox(10);

        // Add components to horizontal layout
        ObservableList firstHorizontalBoxList = firstHorizontalBox.getChildren();
        firstHorizontalBoxList.add(secondHorizontalBox);
        firstHorizontalBoxList.add(firstVerticalBox);
        firstHorizontalBoxList.add(secondSeparator);

        // Add horizontal layout to group
        Group root = new Group();
        ObservableList rootList = root.getChildren();
        rootList.add(firstHorizontalBox);

        // Add group to scene
        Scene scene = new Scene(root);

        // Add scene to stage and display window
        primaryStage.setScene(scene);
        primaryStage.setTitle("GroupUs");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
