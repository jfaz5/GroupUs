package us.group.client.ui.gui;

import javafx.scene.Node;
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
import javafx.scene.layout.Background;
import javafx.collections.ObservableList;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;

public class GraphicalUserInterfaceHelper extends Application {

    /**
     * Creates a button to be displayed in the left sidebar.
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
     * @return The display window height.
     */

    private int getWindowHeight() {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        return (int)Math.ceil(bounds.getHeight());
    }

    /**
     * Returns the display window width.
     *
     * @return The display window width.
     */

    private int getWindowWidth() {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        return (int)Math.ceil(bounds.getWidth());
    }

    /**
     * Creates direct message placeholders to display for when the user does not
     * have any open conversations.
     *
     * @param numPlaceholders The number of placeholders to create.
     * @return The created direct message placeholders.
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
     * @return The number of direct message placeholders to display.
     */

    private int calculateNumPlaceholders() {
        int shapeHeight = 25;
        int windowHeight = getWindowHeight();
        int numPlaceholders = (int)Math.round((0.18 * windowHeight) / shapeHeight);
        return numPlaceholders;
    }

    /**
     * Creates a node to be used as either vertical or horizontal display glue.
     *
     * @return The created node.
     */

    private Node createGlue() {
        VBox glueNode = new VBox(10);
        return glueNode;
    }

    /**
     * Creates a button to be displayed in the friends header.
     *
     * @param text The button text.
     * @return The created button.
     */

    private Button createFriendsHeaderButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 12.0));
        button.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        return button;
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
        Separator eighthSeparator = new Separator(Orientation.HORIZONTAL);
        Separator ninthSeparator = new Separator(Orientation.VERTICAL);
        Separator tenthSeparator = new Separator(Orientation.HORIZONTAL);

        // Set vertical line heights
        int lineHeight = getWindowHeight() - 90;
        secondSeparator.setStyle("-fx-height: " + lineHeight + "px; -fx-min-height: " + lineHeight + "px;");
        thirdSeparator.setStyle("-fx-height: " + lineHeight + "px; -fx-min-height: " + lineHeight + "px;");
        fifthSeparator.setStyle("-fx-height: 90px; -fx-min-height: 90px;");
        sixthSeparator.setStyle("-fx-height: 90px; -fx-min-height: 90px;");

        // Set horizontal line widths
        int lineWidth = getWindowWidth() - 322 - 15;
        seventhSeparator.setStyle("-fx-width: 200px; -fx-min-width: 200px;");
        eighthSeparator.setStyle("-fx-width: " + lineWidth + "px; -fx-min-width: " + lineWidth + "px;");
        tenthSeparator.setStyle("-fx-width: " + lineWidth + "px; -fx-min-width: " + lineWidth + "px;");

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
        firstVerticalBoxList.add(createGlue());
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
        directMessagesBoxList.add(createGlue());
        directMessagesBoxList.add(createGlue());
        directMessagesBoxList.add(createGlue());
        directMessagesBoxList.add(createGlue());
        directMessagesBoxList.add(createGlue());
        directMessagesBoxList.add(createDMButton);

        // Add components to second left sidebar
        ObservableList secondVerticalBoxList = secondVerticalBox.getChildren();
        secondVerticalBoxList.add(createGlue());
        secondVerticalBoxList.add(conversationTextField);
        secondVerticalBoxList.add(fourthSeparator);
        secondVerticalBoxList.add(friendsButton);
        secondVerticalBoxList.add(createGlue());
        secondVerticalBoxList.add(directMessagesBox);
        secondVerticalBoxList.add(createGlue());
        secondVerticalBoxList.add(createGlue());

        // Create before settings horizontal box
        HBox beforeSettingsBox = new HBox(10);
        ObservableList beforeSettingsBoxList = beforeSettingsBox.getChildren();
        beforeSettingsBoxList.add(secondSeparator);
        beforeSettingsBoxList.add(secondVerticalBox);
        beforeSettingsBoxList.add(thirdSeparator);

        // Create user account picture button
        Button userAccountPictureButton = new Button();
        userAccountPictureButton.setMaxHeight(40);
        userAccountPictureButton.setMaxWidth(40);
        userAccountPictureButton.setMinHeight(40);
        userAccountPictureButton.setMinWidth(40);
        userAccountPictureButton.setClip(new Circle(20, 20, 20));
        InputStream defaultUserAccountPictureIconStream = classLoader.getResourceAsStream("img/default_user_account_picture_icon.png");
        Image defaultUserAccountPictureIconImage = new Image(defaultUserAccountPictureIconStream);
        BackgroundImage defaultUserAccountPictureIconBackgroundImage = new BackgroundImage(defaultUserAccountPictureIconImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(userAccountPictureButton.getWidth(), userAccountPictureButton.getHeight(), true, true, true, false));
        Background defaultUserAccountPictureIconBackground = new Background(defaultUserAccountPictureIconBackgroundImage);
        userAccountPictureButton.setBackground(defaultUserAccountPictureIconBackground);

        // Create username label
        Label usernameLabel = new Label("TestUsername");
        usernameLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 13.0));
        usernameLabel.setMinWidth(100);

        // Create username label vertical box
        VBox usernameLabelVerticalBox = new VBox(10);
        ObservableList usernameLabelVerticalBoxList = usernameLabelVerticalBox.getChildren();
        usernameLabelVerticalBoxList.add(createGlue());
        usernameLabelVerticalBoxList.add(usernameLabel);

        // Create settings button
        InputStream settingsIconStream = classLoader.getResourceAsStream("img/settings_icon.png");
        Image settingsIconImage = new Image(settingsIconStream);
        ImageView settingsIconView = new ImageView(settingsIconImage);
        settingsIconView.setFitWidth(19);
        settingsIconView.setFitHeight(19);
        Button settingsButton = new Button();
        settingsButton.setGraphic(settingsIconView);
        settingsButton.setMinHeight(39);
        settingsButton.setMinWidth(39);
        settingsButton.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 39px; " +
                        "-fx-min-height: 39px; " +
                        "-fx-max-width: 39px; " +
                        "-fx-border-color: black; " +
                        "-fx-border-radius: 5em; " +
                        "-fx-border-width: 2px; " +
                        "-fx-max-height: 39px;"
        );

        // Create second settings horizontal box
        HBox secondSettingsHorizontalBox = new HBox(10);
        ObservableList secondSettingsHorizontalBoxList = secondSettingsHorizontalBox.getChildren();
        secondSettingsHorizontalBoxList.add(userAccountPictureButton);
        secondSettingsHorizontalBoxList.add(usernameLabelVerticalBox);
        secondSettingsHorizontalBoxList.add(settingsButton);

        // Create settings vertical box
        VBox settingsVerticalBox = new VBox(10);
        ObservableList settingsVerticalBoxList = settingsVerticalBox.getChildren();
        settingsVerticalBoxList.add(seventhSeparator);
        settingsVerticalBoxList.add(secondSettingsHorizontalBox);

        // Create settings horizontal box
        HBox settingsHorizontalBox = new HBox(10);
        ObservableList settingsHorizontalBoxList = settingsHorizontalBox.getChildren();
        settingsHorizontalBoxList.add(fifthSeparator);
        settingsHorizontalBoxList.add(settingsVerticalBox);
        settingsHorizontalBoxList.add(sixthSeparator);

        // Create border pane for second left sidebar
        BorderPane leftBorderPane = new BorderPane();
        leftBorderPane.setCenter(beforeSettingsBox);
        leftBorderPane.setBottom(settingsHorizontalBox);

        // Horizontal boxes for left side of screen
        HBox firstHorizontalBox = new HBox(10);
        HBox secondHorizontalBox = new HBox(10);

        // Create friends logo
        ImageView secondWaveIconView = new ImageView(waveIconImage);
        secondWaveIconView.setFitWidth(20);
        secondWaveIconView.setFitHeight(20);
        Button friendsLogo = new Button();
        friendsLogo.setGraphic(secondWaveIconView);
        friendsLogo.setText("Friends");
        friendsLogo.setAlignment(Pos.BASELINE_LEFT);
        friendsLogo.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, Font.getDefault().getSize() + 1));
        friendsLogo.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        // Create online friends button
        Button onlineFriendsButton = createFriendsHeaderButton("Online");

        // Create all friends button
        Button allFriendsButton = createFriendsHeaderButton("All");

        // Create pending friends button
        Button pendingFriendsButton = createFriendsHeaderButton("Pending");

        // Create blocked user accounts button
        Button blockedUserAccountsButton = createFriendsHeaderButton("Blocked");

        // Create add friend button
        Button addFriendButton = new Button("Add Friend");
        addFriendButton.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 12.0));
        addFriendButton.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-background-color: lightgreen;");

        // Create friends horizontal box
        HBox friendsHorizontalBox = new HBox(10);
        ObservableList friendsHorizontalBoxList = friendsHorizontalBox.getChildren();
        friendsHorizontalBoxList.add(friendsLogo);
        friendsHorizontalBoxList.add(ninthSeparator);
        friendsHorizontalBoxList.add(createGlue());
        friendsHorizontalBoxList.add(onlineFriendsButton);
        friendsHorizontalBoxList.add(createGlue());
        friendsHorizontalBoxList.add(allFriendsButton);
        friendsHorizontalBoxList.add(createGlue());
        friendsHorizontalBoxList.add(pendingFriendsButton);
        friendsHorizontalBoxList.add(createGlue());
        friendsHorizontalBoxList.add(blockedUserAccountsButton);
        friendsHorizontalBoxList.add(createGlue());
        friendsHorizontalBoxList.add(addFriendButton);

        // Create friends vertical box
        VBox friendsVerticalBox = new VBox(10);
        ObservableList friendsVerticalBoxList = friendsVerticalBox.getChildren();
        friendsVerticalBoxList.add(createGlue());
        friendsVerticalBoxList.add(friendsHorizontalBox);
        friendsVerticalBoxList.add(eighthSeparator);

        // Create add friend label
        Label addFriendLabel = new Label("Add Friend");
        addFriendLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 20.0));

        // Create add friend message label
        Label addFriendMessageLabel = new Label("You can add a friend with their GroupUs tag. It's cAsE sEnSitIvE!");
        addFriendMessageLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 15.0));

        // Create enter tag text field
        TextField enterTagTextField = new TextField();
        enterTagTextField.setPromptText("Enter a GroupUs Tag");
        enterTagTextField.setMinHeight(40);
        enterTagTextField.setMinWidth(580);
        enterTagTextField.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 20.0));

        // Create send friend request button
        Button sendFriendRequestButton = new Button();
        sendFriendRequestButton.setText("Send Friend Request");
        sendFriendRequestButton.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16.0));
        sendFriendRequestButton.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-background-color: lightblue;");
        sendFriendRequestButton.setMinHeight(40);

        // Create enter tag horizontal box
        HBox enterTagHorizontalBox = new HBox(10);
        ObservableList enterTagHorizontalBoxList = enterTagHorizontalBox.getChildren();
        enterTagHorizontalBoxList.add(enterTagTextField);
        enterTagHorizontalBoxList.add(sendFriendRequestButton);

        // Create add friend vertical box
        VBox addFriendVerticalBox = new VBox(10);
        ObservableList addFriendVerticalBoxList = addFriendVerticalBox.getChildren();
        addFriendVerticalBoxList.add(addFriendLabel);
        addFriendVerticalBoxList.add(addFriendMessageLabel);
        addFriendVerticalBoxList.add(createGlue());
        addFriendVerticalBoxList.add(enterTagHorizontalBox);

        // Create add friend horizontal box
        HBox addFriendHorizontalBox = new HBox(10);
        ObservableList addFriendHorizontalBoxList = addFriendHorizontalBox.getChildren();
        addFriendHorizontalBoxList.add(createGlue());
        addFriendHorizontalBoxList.add(createGlue());
        addFriendHorizontalBoxList.add(addFriendVerticalBox);

        // Create below friends vertical box
        VBox belowFriendsVerticalBox = new VBox(10);
        ObservableList belowFriendsVerticalBoxList = belowFriendsVerticalBox.getChildren();
        belowFriendsVerticalBoxList.add(addFriendHorizontalBox);

        // Create lonely icon image view
        InputStream lonelyIconStream = classLoader.getResourceAsStream("img/lonely_icon.png");
        Image lonelyIconImage = new Image(lonelyIconStream);
        ImageView lonelyIconView = new ImageView(lonelyIconImage);
        lonelyIconView.setFitWidth(225);
        lonelyIconView.setFitHeight(225);

        // Create lonely message label
        Label lonelyMessageLabel = new Label();
        lonelyMessageLabel.setText("Steve is waiting on friends. You don't have to though!");
        lonelyMessageLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16.0));

        // Create lonely icon horizontal box
        HBox lonelyIconHorizontalBox = new HBox(10);
        ObservableList lonelyIconHorizontalBoxList = lonelyIconHorizontalBox.getChildren();

        for (int i = 0; i < 40; i++)
            lonelyIconHorizontalBoxList.add(createGlue());

        lonelyIconHorizontalBoxList.add(lonelyIconView);

        // Create lonely message horizontal box
        HBox lonelyMessageHorizontalBox = new HBox(10);
        ObservableList lonelyMessageHorizontalBoxList = lonelyMessageHorizontalBox.getChildren();

        for (int i = 0; i < 35; i++)
            lonelyMessageHorizontalBoxList.add(createGlue());

        lonelyMessageHorizontalBoxList.add(lonelyMessageLabel);

        // Create friends and below friends vertical box
        VBox friendsAndBelowFriendsVerticalBox = new VBox(10);
        ObservableList friendsAndBelowFriendsVerticalBoxList = friendsAndBelowFriendsVerticalBox.getChildren();
        friendsAndBelowFriendsVerticalBoxList.add(friendsVerticalBox);
        friendsAndBelowFriendsVerticalBoxList.add(belowFriendsVerticalBox);
        friendsAndBelowFriendsVerticalBoxList.add(createGlue());
        friendsAndBelowFriendsVerticalBoxList.add(tenthSeparator);

        for (int i = 0; i < 13; i++)
            friendsAndBelowFriendsVerticalBoxList.add(createGlue());

        friendsAndBelowFriendsVerticalBoxList.add(lonelyIconHorizontalBox);
        friendsAndBelowFriendsVerticalBoxList.add(createGlue());
        friendsAndBelowFriendsVerticalBoxList.add(createGlue());
        friendsAndBelowFriendsVerticalBoxList.add(lonelyMessageHorizontalBox);

        // Add components to horizontal layout
        ObservableList firstHorizontalBoxList = firstHorizontalBox.getChildren();
        firstHorizontalBoxList.add(secondHorizontalBox);
        firstHorizontalBoxList.add(firstVerticalBox);
        firstHorizontalBoxList.add(leftBorderPane);
        firstHorizontalBoxList.add(friendsAndBelowFriendsVerticalBox);

        // Create home root group
        Group homeRoot = new Group();
        ObservableList homeRootList = homeRoot.getChildren();
        homeRootList.add(firstHorizontalBox);

        // Create scenes
        Scene homeScene = new Scene(homeRoot);

        // Add home scene to stage and display window
        primaryStage.setScene(homeScene);
        primaryStage.setTitle("GroupUs");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
