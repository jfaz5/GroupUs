package us.group.client.parser.parameter;

import us.group.client.types.UserInterfaceType;

public class ParameterParserResult {
    private UserInterfaceType uiType;

    public ParameterParserResult(UserInterfaceType uiType) {
        this.uiType = uiType;
    }

    public UserInterfaceType getUIType() {
        return this.uiType;
    }
}
