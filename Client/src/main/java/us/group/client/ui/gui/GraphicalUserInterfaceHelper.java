package us.group.client.ui.gui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.geometry.Pos;
import javafx.stage.Screen;
import java.io.InputStream;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.shape.Ellipse;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.collections.ObservableList;

public class GraphicalUserInterfaceHelper extends Application {

    /**
     * Creates a button to be displayed on the left sidebar.
     *
     * @param icon The image to be displayed on the button.
     * @param tooltipMessage The tooltip message to be displayed on mouse hover.
     * @return The created button.
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
     * @return Window height.
     */

    private int getWindowHeight() {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        return (int)Math.ceil(bounds.getHeight());
    }

    /**
     * Creates direct message placeholders to display for when the user does not
     * have any open conversations.
     *
     * @param numPlaceholders The number of placeholders to create.
     * @return Direct message placeholders.
     */

    private VBox createDirectMessagePlaceholders(int numPlaceholders) {
        VBox dmPlaceholders = new VBox(10);
        int currentGrayscale = 255 - numPlaceholders * 5;
        ObservableList dmPlaceholdersList = dmPlaceholders.getChildren();

        for (int i = 0; i < numPlaceholders; i++) {
            Circle c = new Circle(25);
            Ellipse e = new Ellipse(70, 25);

            Color color = Color.rgb(currentGrayscale, currentGrayscale, currentGrayscale);
            c.setFill(color);
            e.setFill(color);
            currentGrayscale += 5;

            HBox horizontalBox = new HBox(5);
            ObservableList horizontalBoxList = horizontalBox.getChildren();
            horizontalBoxList.add(c);
            horizontalBoxList.add(new HBox(5));
            horizontalBoxList.add(e);

            dmPlaceholdersList.add(horizontalBox);
        }

        return dmPlaceholders;
    }

    /**
     * Calculates the number of direct message placeholders to display for when
     * the user does not have any open conversations.
     *
     * @return Number of direct message placeholders.
     */

    private int calculateNumPlaceholders() {
        int shapeHeight = 25;
        int windowHeight = getWindowHeight();
        int numPlaceholders = (int)Math.round((0.18 * windowHeight) / shapeHeight);
        return numPlaceholders;
    }

    @Override
    public void start(Stage primaryStage) {
        // Vertical boxes for left side of screen
        VBox firstVerticalBox = new VBox(10);
        VBox secondVerticalBox = new VBox(10);

        // Line separators
        Separator firstSeparator = new Separator(Orientation.HORIZONTAL);
        Separator secondSeparator = new Separator(Orientation.VERTICAL);
        Separator thirdSeparator = new Separator(Orientation.VERTICAL);
        Separator fourthSeparator = new Separator(Orientation.HORIZONTAL);
        Separator fifthSeparator = new Separator(Orientation.VERTICAL);
        Separator sixthSeparator = new Separator(Orientation.VERTICAL);
        Separator seventhSeparator = new Separator(Orientation.HORIZONTAL);

        // Set vertical line heights
        int lineHeight = getWindowHeight() - 100;
        secondSeparator.setStyle("-fx-height: " + lineHeight + "px; -fx-min-height: " + lineHeight + "px;");
        thirdSeparator.setStyle("-fx-height: " + lineHeight + "px; -fx-min-height: " + lineHeight + "px;");
        fifthSeparator.setStyle("-fx-height: 100px; -fx-min-height: 100px;");
        sixthSeparator.setStyle("-fx-height: 100px; -fx-min-height: 100px;");

        // Set horizontal line width
        seventhSeparator.setStyle("-fx-width: 200px; -fx-min-width: 200px;");

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
        firstVerticalBoxList.add(new VBox(10));
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
        friendsButton.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16.0));
        friendsButton.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

        // Create direct messages label
        Label directMessagesLabel = new Label("Direct Messages");
        directMessagesLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 15.0));

        // Create "Create DM" button
        ImageView plusIconView = new ImageView(plusIconImage);
        plusIconView.setFitWidth(10);
        plusIconView.setFitHeight(10);
        Button createDMButton = new Button();
        createDMButton.setGraphic(plusIconView);
        createDMButton.setMaxWidth(10);
        createDMButton.setMaxHeight(10);
        createDMButton.setTooltip(new Tooltip("Create DM"));
        createDMButton.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

        // Create direct messages horizontal box
        HBox directMessagesBox = new HBox(10);
        ObservableList directMessagesBoxList = directMessagesBox.getChildren();
        directMessagesBoxList.add(directMessagesLabel);
        directMessagesBoxList.add(new HBox(10));
        directMessagesBoxList.add(new HBox(10));
        directMessagesBoxList.add(new HBox(10));
        directMessagesBoxList.add(new HBox(10));
        directMessagesBoxList.add(new HBox(10));
        directMessagesBoxList.add(createDMButton);

        // Add components to second left sidebar
        ObservableList secondVerticalBoxList = secondVerticalBox.getChildren();
        secondVerticalBoxList.add(new VBox(10));
        secondVerticalBoxList.add(conversationTextField);
        secondVerticalBoxList.add(fourthSeparator);
        secondVerticalBoxList.add(friendsButton);
        secondVerticalBoxList.add(new VBox(10));
        secondVerticalBoxList.add(directMessagesBox);
        secondVerticalBoxList.add(new VBox(10));
        secondVerticalBoxList.add(new VBox(10));

        // Create before settings horizontal box
        HBox beforeSettingsBox = new HBox(10);
        ObservableList beforeSettingsBoxList = beforeSettingsBox.getChildren();
        beforeSettingsBoxList.add(secondSeparator);
        beforeSettingsBoxList.add(secondVerticalBox);
        beforeSettingsBoxList.add(thirdSeparator);

        // Create settings horizontal box
        HBox settingsBox = new HBox(10);
        ObservableList settingsBoxList = settingsBox.getChildren();
        settingsBoxList.add(fifthSeparator);
        settingsBoxList.add(seventhSeparator);
        settingsBoxList.add(sixthSeparator);

        // Create border pane for second left sidebar
        BorderPane leftBorderPane = new BorderPane();
        leftBorderPane.setCenter(beforeSettingsBox);
        leftBorderPane.setBottom(settingsBox);

        // Horizontal boxes for left side of screen
        HBox firstHorizontalBox = new HBox(10);
        HBox secondHorizontalBox = new HBox(10);

        // Add components to horizontal layout
        ObservableList firstHorizontalBoxList = firstHorizontalBox.getChildren();
        firstHorizontalBoxList.add(secondHorizontalBox);
        firstHorizontalBoxList.add(firstVerticalBox);
        firstHorizontalBoxList.add(leftBorderPane);

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
