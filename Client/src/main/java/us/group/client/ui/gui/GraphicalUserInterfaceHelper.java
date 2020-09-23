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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private VBox addFriendTabVerticalBox = new VBox(10);
    private VBox allFriendsTabVerticalBox = new VBox(10);
    private VBox blockedTagsTabVerticalBox = new VBox(10);
    private VBox onlineFriendsTabVerticalBox = new VBox(10);
    private VBox pendingFriendsTabVerticalBox = new VBox(10);

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

    /***
     * Creates an online friends tab vertical box.
     *
     * @param classLoader A ClassLoader instance.
     * @return The created vertical box.
     */

    private VBox createOnlineFriendsTab(ClassLoader classLoader) {
        // Create sleeping icon view
        InputStream sleepingIconStream = classLoader.getResourceAsStream("img/sleeping_icon.png");
        Image sleepingIconImage = new Image(sleepingIconStream);
        ImageView sleepingIconView = new ImageView(sleepingIconImage);
        sleepingIconView.setFitWidth(225);
        sleepingIconView.setFitHeight(225);

        // Create sleeping message label
        Label sleepingMessageLabel = new Label("No one's around to play with Steve.");
        sleepingMessageLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16.0));

        // Create sleeping icon view horizontal box
        HBox sleepingIconViewHorizontalBox = new HBox(10);
        ObservableList sleepingIconViewHorizontalBoxList = sleepingIconViewHorizontalBox.getChildren();

        for (int i = 0; i < 40; i++)
            sleepingIconViewHorizontalBoxList.add(createGlue());

        sleepingIconViewHorizontalBoxList.add(sleepingIconView);

        // Create sleeping message label horizontal box
        HBox sleepingMessageLabelHorizontalBox = new HBox(10);
        ObservableList sleepingMessageLabelHorizontalBoxList = sleepingMessageLabelHorizontalBox.getChildren();

        for (int i = 0; i < 40; i++)
            sleepingMessageLabelHorizontalBoxList.add(createGlue());

        sleepingMessageLabelHorizontalBoxList.add(sleepingMessageLabel);

        // Create online friends tab vertical box
        ObservableList onlineFriendsTabVerticalBoxList = this.onlineFriendsTabVerticalBox.getChildren();

        for (int i = 0; i < 19; i++)
            onlineFriendsTabVerticalBoxList.add(createGlue());

        onlineFriendsTabVerticalBoxList.add(sleepingIconViewHorizontalBox);
        onlineFriendsTabVerticalBoxList.add(createGlue());
        onlineFriendsTabVerticalBoxList.add(createGlue());
        onlineFriendsTabVerticalBoxList.add(createGlue());
        onlineFriendsTabVerticalBoxList.add(sleepingMessageLabelHorizontalBox);

        return this.onlineFriendsTabVerticalBox;
    }

    /***
     * Creates an all friends tab vertical box.
     *
     * @param lonelyIconImage The lonely icon image to be displayed.
     * @param secondFriendsVerticalBoxList An ObservableList instance for the second friends vertical box.
     * @return The created vertical box.
     */

    private VBox createAllFriendsTab(Image lonelyIconImage, ObservableList secondFriendsVerticalBoxList) {
        // Create second lonely icon view
        ImageView secondLonelyIconView = new ImageView(lonelyIconImage);
        secondLonelyIconView.setFitWidth(225);
        secondLonelyIconView.setFitHeight(225);

        // Create second lonely message label
        Label secondLonelyMessageLabel = new Label();
        secondLonelyMessageLabel.setText("Steve is waiting on friends. You don't have to though!");
        secondLonelyMessageLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16.0));

        // Create second add friend button
        Button secondAddFriendButton = new Button();
        secondAddFriendButton.setText("Add Friend");
        secondAddFriendButton.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16.0));
        secondAddFriendButton.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-background-color: lightblue;");
        secondAddFriendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (secondFriendsVerticalBoxList.size() > 1)
                    secondFriendsVerticalBoxList.remove(1);

                secondFriendsVerticalBoxList.add(addFriendTabVerticalBox);
            }
        });

        // Create second lonely icon horizontal box
        HBox secondLonelyIconHorizontalBox = new HBox(10);
        ObservableList secondLonelyIconHorizontalBoxList = secondLonelyIconHorizontalBox.getChildren();

        for (int i = 0; i < 40; i++)
            secondLonelyIconHorizontalBoxList.add(createGlue());

        secondLonelyIconHorizontalBoxList.add(secondLonelyIconView);

        // Create second lonely message horizontal box
        HBox secondLonelyMessageHorizontalBox = new HBox(10);
        ObservableList secondLonelyMessageHorizontalBoxList = secondLonelyMessageHorizontalBox.getChildren();

        for (int i = 0; i < 35; i++)
            secondLonelyMessageHorizontalBoxList.add(createGlue());

        secondLonelyMessageHorizontalBoxList.add(secondLonelyMessageLabel);

        // Create second add friend button horizontal box
        HBox secondAddFriendButtonHorizontalBox = new HBox(10);
        ObservableList secondAddFriendButtonHorizontalBoxList = secondAddFriendButtonHorizontalBox.getChildren();

        for (int i = 0; i < 47; i++)
            secondAddFriendButtonHorizontalBoxList.add(createGlue());

        secondAddFriendButtonHorizontalBoxList.add(secondAddFriendButton);

        // Create all friends tab vertical box
        ObservableList allFriendsTabVerticalBoxList = this.allFriendsTabVerticalBox.getChildren();

        for (int i = 0; i < 18; i++)
            allFriendsTabVerticalBoxList.add(createGlue());

        allFriendsTabVerticalBoxList.add(secondLonelyIconHorizontalBox);
        allFriendsTabVerticalBoxList.add(createGlue());
        allFriendsTabVerticalBoxList.add(createGlue());
        allFriendsTabVerticalBoxList.add(secondLonelyMessageHorizontalBox);
        allFriendsTabVerticalBoxList.add(createGlue());
        allFriendsTabVerticalBoxList.add(secondAddFriendButtonHorizontalBox);

        return this.allFriendsTabVerticalBox;
    }

    /***
     * Creates a blocked tags tab vertical box.
     *
     * @param classLoader A ClassLoader instance.
     * @return The created vertical box.
     */

    private VBox createBlockedTagsTab(ClassLoader classLoader) {
        // Create building icon view
        InputStream buildingIconStream = classLoader.getResourceAsStream("img/building_icon.png");
        Image buildingIconImage = new Image(buildingIconStream);
        ImageView buildingIconView = new ImageView(buildingIconImage);
        buildingIconView.setFitWidth(300);
        buildingIconView.setFitHeight(300);

        // Create building message label
        Label buildingMessageLabel = new Label("You can't unblock the Steve.");
        buildingMessageLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16.0));

        // Create building icon view horizontal box
        HBox buildingIconViewHorizontalBox = new HBox(10);
        ObservableList buildingIconViewHorizontalBoxList = buildingIconViewHorizontalBox.getChildren();

        for (int i = 0; i < 37; i++)
            buildingIconViewHorizontalBoxList.add(createGlue());

        buildingIconViewHorizontalBoxList.add(buildingIconView);

        // Create building message label horizontal box
        HBox buildingMessageLabelHorizontalBox = new HBox(10);
        ObservableList buildingMessageLabelHorizontalBoxList = buildingMessageLabelHorizontalBox.getChildren();

        for (int i = 0; i < 43; i++)
            buildingMessageLabelHorizontalBoxList.add(createGlue());

        buildingMessageLabelHorizontalBoxList.add(buildingMessageLabel);

        // Create blocked tags tab vertical box
        ObservableList blockedTagsTabVerticalBoxList = this.blockedTagsTabVerticalBox.getChildren();

        for (int i = 0; i < 16; i++)
            blockedTagsTabVerticalBoxList.add(createGlue());

        blockedTagsTabVerticalBoxList.add(buildingIconViewHorizontalBox);
        blockedTagsTabVerticalBoxList.add(createGlue());
        blockedTagsTabVerticalBoxList.add(createGlue());
        blockedTagsTabVerticalBoxList.add(createGlue());
        blockedTagsTabVerticalBoxList.add(buildingMessageLabelHorizontalBox);

        return this.blockedTagsTabVerticalBox;
    }

    /***
     * Creates a pending friends tab vertical box.
     *
     * @param classLoader A ClassLoader instance.
     * @return The created vertical box.
     */

    private VBox createPendingFriendsTab(ClassLoader classLoader) {
        // Create standing icon view
        InputStream standingIconStream = classLoader.getResourceAsStream("img/standing_icon.png");
        Image standingIconImage = new Image(standingIconStream);
        ImageView standingIconView = new ImageView(standingIconImage);
        standingIconView.setFitWidth(160);
        standingIconView.setFitHeight(300);

        // Create standing message label
        Label standingMessageLabel = new Label("There are no pending friend requests. Here's Steve for now.");
        standingMessageLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16.0));

        // Create standing icon view horizontal box
        HBox standingIconViewHorizontalBox = new HBox(10);
        ObservableList standingIconViewHorizontalBoxList = standingIconViewHorizontalBox.getChildren();

        for (int i = 0; i < 43; i++)
            standingIconViewHorizontalBoxList.add(createGlue());

        standingIconViewHorizontalBoxList.add(standingIconView);

        // Create standing message label horizontal box
        HBox standingMessageLabelHorizontalBox = new HBox(10);
        ObservableList standingMessageLabelHorizontalBoxList = standingMessageLabelHorizontalBox.getChildren();

        for (int i = 0; i < 33; i++)
            standingMessageLabelHorizontalBoxList.add(createGlue());

        standingMessageLabelHorizontalBoxList.add(standingMessageLabel);

        // Create pending friends tab vertical box
        ObservableList pendingFriendsTabVerticalBoxList = this.pendingFriendsTabVerticalBox.getChildren();

        for (int i = 0; i < 16; i++)
            pendingFriendsTabVerticalBoxList.add(createGlue());

        pendingFriendsTabVerticalBoxList.add(standingIconViewHorizontalBox);
        pendingFriendsTabVerticalBoxList.add(createGlue());
        pendingFriendsTabVerticalBoxList.add(createGlue());
        pendingFriendsTabVerticalBoxList.add(createGlue());
        pendingFriendsTabVerticalBoxList.add(standingMessageLabelHorizontalBox);

        return this.pendingFriendsTabVerticalBox;
    }

    /***
     * Creates an add friend tab vertical box.
     *
     * @param classLoader A ClassLoader instance.
     * @param tenthSeparator The horizontal line below the friends buttons.
     * @param lonelyIconImage The lonely icon image to be displayed.
     * @return The created vertical box.
     */

    private VBox createAddFriendTab(ClassLoader classLoader, Separator tenthSeparator, Image lonelyIconImage) {
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

        // Create first lonely icon image view
        ImageView firstLonelyIconView = new ImageView(lonelyIconImage);
        firstLonelyIconView.setFitWidth(225);
        firstLonelyIconView.setFitHeight(225);

        // Create first lonely message label
        Label firstLonelyMessageLabel = new Label();
        firstLonelyMessageLabel.setText("Steve is waiting on friends. You don't have to though!");
        firstLonelyMessageLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16.0));

        // Create first lonely icon horizontal box
        HBox firstLonelyIconHorizontalBox = new HBox(10);
        ObservableList firstLonelyIconHorizontalBoxList = firstLonelyIconHorizontalBox.getChildren();

        for (int i = 0; i < 40; i++)
            firstLonelyIconHorizontalBoxList.add(createGlue());

        firstLonelyIconHorizontalBoxList.add(firstLonelyIconView);

        // Create first lonely message horizontal box
        HBox firstLonelyMessageHorizontalBox = new HBox(10);
        ObservableList firstLonelyMessageHorizontalBoxList = firstLonelyMessageHorizontalBox.getChildren();

        for (int i = 0; i < 35; i++)
            firstLonelyMessageHorizontalBoxList.add(createGlue());

        firstLonelyMessageHorizontalBoxList.add(firstLonelyMessageLabel);

        // Create add friend tab vertical box
        ObservableList addFriendTabVerticalBoxList = this.addFriendTabVerticalBox.getChildren();
        addFriendTabVerticalBoxList.add(addFriendHorizontalBox);
        addFriendTabVerticalBoxList.add(createGlue());
        addFriendTabVerticalBoxList.add(tenthSeparator);

        for (int i = 0; i < 13; i++)
            addFriendTabVerticalBoxList.add(createGlue());

        addFriendTabVerticalBoxList.add(firstLonelyIconHorizontalBox);
        addFriendTabVerticalBoxList.add(createGlue());
        addFriendTabVerticalBoxList.add(createGlue());
        addFriendTabVerticalBoxList.add(firstLonelyMessageHorizontalBox);

        return this.addFriendTabVerticalBox;
    }

    /**
     * Creates a settings tab vertical box.
     *
     * @return The created vertical box.
     */

    private VBox createSettingsTab() {
        // Create my account label
        Label myAccountLabel = new Label("My Account");
        myAccountLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 30.0));

        // Create username label
        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16.0));

        // Create username text field
        TextField usernameTextField = new TextField();
        usernameTextField.setMinWidth(225);
        usernameTextField.setMinHeight(40);
        usernameTextField.setMaxWidth(225);
        usernameTextField.setMaxHeight(40);

        // Create current password label
        Label currentPasswordLabel = new Label("Current Password");
        currentPasswordLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16.0));

        // Create current password text field
        TextField currentPasswordTextField = new TextField();
        currentPasswordTextField.setMinWidth(225);
        currentPasswordTextField.setMinHeight(40);
        currentPasswordTextField.setMaxWidth(225);
        currentPasswordTextField.setMaxHeight(40);

        // Create horizontal line separator
        Separator horizontalLineSeparator = new Separator(Orientation.HORIZONTAL);

        // Create inner vertical box
        VBox innerVerticalBox = new VBox(10);
        ObservableList innerVerticalBoxList = innerVerticalBox.getChildren();

        for (int i = 0; i < 10; i++)
            innerVerticalBoxList.add(createGlue());

        innerVerticalBoxList.add(usernameLabel);
        innerVerticalBoxList.add(usernameTextField);
        innerVerticalBoxList.add(createGlue());
        innerVerticalBoxList.add(createGlue());
        innerVerticalBoxList.add(currentPasswordLabel);
        innerVerticalBoxList.add(currentPasswordTextField);

        for (int i = 0; i < 10; i++)
            innerVerticalBoxList.add(createGlue());

        // Create inner horizontal box
        HBox innerHorizontalBox = new HBox(10);
        ObservableList innerHorizontalBoxList = innerHorizontalBox.getChildren();

        for (int i = 0; i < 20; i++)
            innerHorizontalBoxList.add(createGlue());

        innerHorizontalBoxList.add(innerVerticalBox);

        for (int i = 0; i < 20; i++)
            innerHorizontalBoxList.add(createGlue());

        // Create second inner vertical box
        VBox secondInnerVerticalBox = new VBox(10);
        secondInnerVerticalBox.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        ObservableList secondInnerVerticalBoxList = secondInnerVerticalBox.getChildren();
        secondInnerVerticalBoxList.add(innerHorizontalBox);
        secondInnerVerticalBoxList.add(horizontalLineSeparator);

        // Create outer vertical box
        VBox outerVerticalBox = new VBox(10);
        ObservableList outerVerticalBoxList = outerVerticalBox.getChildren();

        for (int i = 0; i < 20; i++)
            outerVerticalBoxList.add(createGlue());

        outerVerticalBoxList.add(myAccountLabel);

        for (int i = 0; i < 2; i++)
            outerVerticalBoxList.add(createGlue());

        outerVerticalBoxList.add(secondInnerVerticalBox);

        for (int i = 0; i < 10; i++)
            outerVerticalBoxList.add(createGlue());

        // Create outer horizontal box
        HBox outerHorizontalBox = new HBox(10);
        ObservableList outerHorizontalBoxList = outerHorizontalBox.getChildren();

        for (int i = 0; i < 25; i++)
            outerHorizontalBoxList.add(createGlue());

        outerHorizontalBoxList.add(outerVerticalBox);

        // Create settings tab vertical box
        VBox settingsTabVerticalBox = new VBox(10);
        ObservableList settingsTabVerticalBoxList = settingsTabVerticalBox.getChildren();
        settingsTabVerticalBoxList.add(outerHorizontalBox);

        return settingsTabVerticalBox;
    }

    @Override
    public void start(Stage primaryStage) {
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

        // Create first vertical box
        VBox firstVerticalBox = new VBox(10);
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
        HBox directMessagesHorizontalBox = new HBox(10);
        ObservableList directMessagesHorizontalBoxList = directMessagesHorizontalBox.getChildren();
        directMessagesHorizontalBoxList.add(directMessagesLabel);
        directMessagesHorizontalBoxList.add(createGlue());
        directMessagesHorizontalBoxList.add(createGlue());
        directMessagesHorizontalBoxList.add(createGlue());
        directMessagesHorizontalBoxList.add(createGlue());
        directMessagesHorizontalBoxList.add(createGlue());
        directMessagesHorizontalBoxList.add(createDMButton);

        // Create second vertical box
        VBox secondVerticalBox = new VBox(10);
        ObservableList secondVerticalBoxList = secondVerticalBox.getChildren();
        secondVerticalBoxList.add(createGlue());
        secondVerticalBoxList.add(conversationTextField);
        secondVerticalBoxList.add(fourthSeparator);
        secondVerticalBoxList.add(friendsButton);
        secondVerticalBoxList.add(createGlue());
        secondVerticalBoxList.add(directMessagesHorizontalBox);
        secondVerticalBoxList.add(createGlue());
        secondVerticalBoxList.add(createGlue());

        // Create before settings horizontal box
        HBox beforeSettingsHorizontalBox = new HBox(10);
        ObservableList beforeSettingsHorizontalBoxList = beforeSettingsHorizontalBox.getChildren();
        beforeSettingsHorizontalBoxList.add(secondSeparator);
        beforeSettingsHorizontalBoxList.add(secondVerticalBox);
        beforeSettingsHorizontalBoxList.add(thirdSeparator);

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
        leftBorderPane.setCenter(beforeSettingsHorizontalBox);
        leftBorderPane.setBottom(settingsHorizontalBox);

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

        // Create first add friend button
        Button firstAddFriendButton = new Button("Add Friend");
        firstAddFriendButton.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 12.0));
        firstAddFriendButton.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-background-color: lightgreen;");

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
        friendsHorizontalBoxList.add(firstAddFriendButton);

        // Create friends vertical box
        VBox friendsVerticalBox = new VBox(10);
        ObservableList friendsVerticalBoxList = friendsVerticalBox.getChildren();
        friendsVerticalBoxList.add(createGlue());
        friendsVerticalBoxList.add(friendsHorizontalBox);
        friendsVerticalBoxList.add(eighthSeparator);

        // Create lonely icon image
        InputStream lonelyIconStream = classLoader.getResourceAsStream("img/lonely_icon.png");
        Image lonelyIconImage = new Image(lonelyIconStream);

        // Create online friends tab vertical box
        VBox onlineFriendsTabVerticalBox = createOnlineFriendsTab(classLoader);

        // Create add friend tab vertical box
        VBox addFriendTabVerticalBox = createAddFriendTab(classLoader, tenthSeparator, lonelyIconImage);

        // Create second friends vertical box
        VBox secondFriendsVerticalBox = new VBox(10);
        ObservableList secondFriendsVerticalBoxList = secondFriendsVerticalBox.getChildren();
        secondFriendsVerticalBoxList.add(friendsVerticalBox);
        secondFriendsVerticalBoxList.add(addFriendTabVerticalBox);

        // Create all friends tab vertical box
        VBox allFriendsTabVerticalBox = createAllFriendsTab(lonelyIconImage, secondFriendsVerticalBoxList);

        // Create pending friends tab vertical box
        VBox pendingFriendsTabVerticalBox = createPendingFriendsTab(classLoader);

        // Create blocked tags tab vertical box
        VBox blockedTagsTabVerticalBox = createBlockedTagsTab(classLoader);

        // Create settings tab vertical box
        VBox settingsTabVerticalBox = createSettingsTab();

        // Create padded settings tab vertical box
        VBox paddedSettingsTabVerticalBox = new VBox(10);
        ObservableList paddedSettingsTabVerticalBoxList = paddedSettingsTabVerticalBox.getChildren();
        paddedSettingsTabVerticalBoxList.add(createGlue());
        paddedSettingsTabVerticalBoxList.add(settingsTabVerticalBox);

        // Create first horizontal box
        HBox firstHorizontalBox = new HBox(10);
        ObservableList firstHorizontalBoxList = firstHorizontalBox.getChildren();
        firstHorizontalBoxList.add(createGlue());
        firstHorizontalBoxList.add(firstVerticalBox);
        firstHorizontalBoxList.add(leftBorderPane);
        firstHorizontalBoxList.add(secondFriendsVerticalBox);

        // Define callback method for online friends button onclick event
        onlineFriendsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (secondFriendsVerticalBoxList.size() > 1)
                    secondFriendsVerticalBoxList.remove(1);

                secondFriendsVerticalBoxList.add(onlineFriendsTabVerticalBox);

                if (firstHorizontalBoxList.size() > 3)
                    firstHorizontalBoxList.remove(3);

                firstHorizontalBoxList.add(secondFriendsVerticalBox);
            }
        });

        // Define callback method for all friends button onclick event
        allFriendsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (secondFriendsVerticalBoxList.size() > 1)
                    secondFriendsVerticalBoxList.remove(1);

                secondFriendsVerticalBoxList.add(allFriendsTabVerticalBox);

                if (firstHorizontalBoxList.size() > 3)
                    firstHorizontalBoxList.remove(3);

                firstHorizontalBoxList.add(secondFriendsVerticalBox);
            }
        });

        // Define callback method for pending friends button onclick event
        pendingFriendsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (secondFriendsVerticalBoxList.size() > 1)
                    secondFriendsVerticalBoxList.remove(1);

                secondFriendsVerticalBoxList.add(pendingFriendsTabVerticalBox);

                if (firstHorizontalBoxList.size() > 3)
                    firstHorizontalBoxList.remove(3);

                firstHorizontalBoxList.add(secondFriendsVerticalBox);
            }
        });

        // Define callback method for blocked user accounts button onclick event
        blockedUserAccountsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (secondFriendsVerticalBoxList.size() > 1)
                    secondFriendsVerticalBoxList.remove(1);

                secondFriendsVerticalBoxList.add(blockedTagsTabVerticalBox);

                if (firstHorizontalBoxList.size() > 3)
                    firstHorizontalBoxList.remove(3);

                firstHorizontalBoxList.add(secondFriendsVerticalBox);
            }
        });

        // Define callback method for first add friend button onclick event
        firstAddFriendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (secondFriendsVerticalBoxList.size() > 1)
                    secondFriendsVerticalBoxList.remove(1);

                secondFriendsVerticalBoxList.add(addFriendTabVerticalBox);

                if (firstHorizontalBoxList.size() > 3)
                    firstHorizontalBoxList.remove(3);

                firstHorizontalBoxList.add(secondFriendsVerticalBox);
            }
        });

        // Define callback method for settings button onclick event
        settingsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (firstHorizontalBoxList.size() > 3)
                    firstHorizontalBoxList.remove(3);

                firstHorizontalBoxList.add(paddedSettingsTabVerticalBox);
            }
        });

        // Define callback method for friends button onclick event
        friendsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (secondFriendsVerticalBoxList.size() > 1)
                    secondFriendsVerticalBoxList.remove(1);

                secondFriendsVerticalBoxList.add(addFriendTabVerticalBox);

                if (firstHorizontalBoxList.size() > 3)
                    firstHorizontalBoxList.remove(3);

                firstHorizontalBoxList.add(secondFriendsVerticalBox);
            }
        });

        // Create group
        Group rootGroup = new Group();
        ObservableList rootGroupList = rootGroup.getChildren();
        rootGroupList.add(firstHorizontalBox);

        // Create scene
        Scene rootScene = new Scene(rootGroup);

        // Add scene to stage and display window
        primaryStage.setScene(rootScene);
        primaryStage.setTitle("GroupUs");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
