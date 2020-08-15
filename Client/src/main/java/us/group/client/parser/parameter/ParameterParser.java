package us.group.client.parser.parameter;

import us.group.client.types.UserInterfaceType;

public class ParameterParser {
    private String[] args;

    public ParameterParser(String[] args) {
        this.args = args;
    }

    /**
     *
     * @return
     * @throws ParameterParserException
     */

    public ParameterParserResult parse() throws ParameterParserException {
        UserInterfaceType uiType = UserInterfaceType.CLI;

        for (String arg : this.args) {
            switch (arg) {
                case "-cli":
                    uiType = UserInterfaceType.CLI;
                    break;
                case "-gui":
                    uiType = UserInterfaceType.GUI;
                    break;
                default:
                    throw new ParameterParserException("Unrecognized parameter '" + arg + "'.");
            }
        }

        ParameterParserResult result = new ParameterParserResult(uiType);
        return result;
    }
}
