package us.group.client.ui.cli;

import us.group.client.ui.UserInterface;
import us.group.client.types.UserInterfaceType;

public class CommandLineInterface extends UserInterface {
    public UserInterfaceType getUIType() {
        return UserInterfaceType.CLI;
    }
}
