package us.group.client.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.stage.Screen;
import java.io.InputStream;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Orientation;
import javafx.scene.image.ImageView;
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
        VBox secondVerticalBox = new VBox(10); // Filler
        VBox thirdVerticalBox = new VBox(10);
        VBox fourthVerticalBox = new VBox(10); // Filler

        // Line separators
        Separator firstSeparator = new Separator(Orientation.HORIZONTAL);
        Separator secondSeparator = new Separator(Orientation.VERTICAL);
        Separator thirdSeparator = new Separator(Orientation.VERTICAL);
        Separator fourthSeparator = new Separator(Orientation.HORIZONTAL);

        // Set line heights
        int windowHeight = getWindowHeight();
        secondSeparator.setStyle("-fx-height: " + windowHeight + "px; -fx-min-height: " + windowHeight + "px;");
        thirdSeparator.setStyle("-fx-height: " + windowHeight + "px; -fx-min-height: " + windowHeight + "px;");

        // Object for loading resources
        ClassLoader classLoader = getClass().getClassLoader();

        // Create home button for left sidebar
        InputStream homeIconStream = classLoader.getResourceAsStream("img/home_icon.png");
        Image homeIconImage = new Image(homeIconStream);
        Button homeButton = createLeftSidebarButton(homeIconImage, "Home");

        // Create add server button for left sidebar
        InputStream plusIconStream = classLoader.getResourceAsStream("img/plus_icon.png");
        Image plusIconImage = new Image(plusIconStream);
        Button addServerButton = createLeftSidebarButton(plusIconImage, "Add a Server");

        // Create explore button for left sidebar
        InputStream magnifyingGlassIconStream = classLoader.getResourceAsStream("img/magnifying_glass_icon.png");
        Image magnifyingGlassIconImage = new Image(magnifyingGlassIconStream);
        Button exploreButton = createLeftSidebarButton(magnifyingGlassIconImage, "Explore Public Servers");

        // Add components to left sidebar
        ObservableList firstVerticalBoxList = firstVerticalBox.getChildren();
        firstVerticalBoxList.add(secondVerticalBox);
        firstVerticalBoxList.add(homeButton);
        firstVerticalBoxList.add(firstSeparator);
        firstVerticalBoxList.add(addServerButton);
        firstVerticalBoxList.add(exploreButton);

        // Create conversation text field
        TextField conversationTextField = new TextField();
        conversationTextField.setMinWidth(200);
        conversationTextField.setPromptText("Find or start a conversation");

        // Create friends button
        InputStream waveIconStream = classLoader.getResourceAsStream("img/wave_icon.png");
        Image waveIconImage = new Image(waveIconStream);
        ImageView waveIconView = new ImageView(waveIconImage);
        waveIconView.setFitWidth(35);
        waveIconView.setFitHeight(35);
        Button friendsButton = new Button();
        friendsButton.setGraphic(waveIconView);
        friendsButton.setText("Friends");
        friendsButton.setMinWidth(200);
        friendsButton.setMinHeight(35);
        friendsButton.setAlignment(Pos.BASELINE_LEFT);
        friendsButton.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 15.0));
        friendsButton.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

        // Add components to second left sidebar
        ObservableList thirdVerticalBoxList = thirdVerticalBox.getChildren();
        thirdVerticalBoxList.add(fourthVerticalBox);
        thirdVerticalBoxList.add(conversationTextField);
        thirdVerticalBoxList.add(fourthSeparator);
        thirdVerticalBoxList.add(friendsButton);

        // Horizontal boxes for left side of screen
        HBox firstHorizontalBox = new HBox(10);
        HBox secondHorizontalBox = new HBox(10);

        // Add components to horizontal layout
        ObservableList firstHorizontalBoxList = firstHorizontalBox.getChildren();
        firstHorizontalBoxList.add(secondHorizontalBox);
        firstHorizontalBoxList.add(firstVerticalBox);
        firstHorizontalBoxList.add(secondSeparator);
        firstHorizontalBoxList.add(thirdVerticalBox);
        firstHorizontalBoxList.add(thirdSeparator);

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
