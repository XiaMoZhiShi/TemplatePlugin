package ink.xiamomc.example;

import xiamomc.pluginbase.PluginObject;

public class ExamplePluginObject extends PluginObject<TemplatePlugin>
{
    @Override
    protected String getPluginNamespace()
    {
        return TemplatePlugin.namespace();
    }
}
