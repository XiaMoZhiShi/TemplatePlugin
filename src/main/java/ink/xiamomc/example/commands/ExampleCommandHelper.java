package ink.xiamomc.example.commands;

import ink.xiamomc.example.TemplatePlugin;
import xiamomc.pluginbase.Command.CommandHelper;
import xiamomc.pluginbase.Command.IPluginCommand;
import xiamomc.pluginbase.XiaMoJavaPlugin;

import java.util.List;

public class ExampleCommandHelper extends CommandHelper<TemplatePlugin>
{
    private final List<IPluginCommand> commands = List.of(
            new ExampleCommand()
    );

    @Override
    public List<IPluginCommand> getCommands()
    {
        return commands;
    }

    @Override
    protected XiaMoJavaPlugin getPlugin()
    {
        return TemplatePlugin.instance();
    }

    @Override
    protected String getPluginNamespace()
    {
        return TemplatePlugin.namespace();
    }
}
