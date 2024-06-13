package ink.xiamomc.example.messages;

import xiamomc.pluginbase.Messages.FormattableMessage;

public class CommandStrings extends AbstractStrings
{
    public static FormattableMessage exampleMessage()
    {
        return getFormattable(getKey("example"), "This is an example messsage!");
    }

    private static String getKey(String key)
    {
        return "command." + key;
    }
}
