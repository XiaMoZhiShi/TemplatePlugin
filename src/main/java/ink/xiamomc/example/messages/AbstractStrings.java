package ink.xiamomc.example.messages;

import ink.xiamomc.example.TemplatePlugin;
import xiamomc.pluginbase.Messages.FormattableMessage;
import xiamomc.pluginbase.Messages.IStrings;

public abstract class AbstractStrings implements IStrings
{
    private static final String nameSpace = TemplatePlugin.namespace();

    protected static FormattableMessage getFormattable(String key, String defaultValue)
    {
        return new FormattableMessage(nameSpace, key, defaultValue);
    }
}
