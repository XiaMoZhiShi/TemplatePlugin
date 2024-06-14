package ink.xiamomc.example.commands;

import ink.xiamomc.example.TemplatePlugin;
import ink.xiamomc.example.commands.subCommands.ReloadSubCommand;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import xiamomc.pluginbase.Command.ISubCommand;
import xiamomc.pluginbase.Command.SubCommandHandler;
import xiamomc.pluginbase.Messages.FormattableMessage;

import java.util.List;

public class SubcommandHub extends SubCommandHandler<TemplatePlugin>
{
    public SubcommandHub()
    {
        initializeCommands();
    }

    private final List<ISubCommand> subCommands = new ObjectArrayList<>();

    private void initializeCommands()
    {
        subCommands.add(new ReloadSubCommand());
    }

    @Override
    public List<ISubCommand> getSubCommands()
    {
        // Used for TabComplete and execution
        // Don't create command instances here, it's a bad idea.
        return subCommands;
    }

    @Override
    public List<FormattableMessage> getNotes()
    {
        // TBH I forgot what does this stand for :(
        return List.of();
    }

    @Override
    public String getCommandName()
    {
        // See ExampleCommand#getCommandName()
        return "example_command_2";
    }

    @Override
    public String getPermissionRequirement()
    {
        // See ExampleCommand#getPermissionRequirement()
        return super.getPermissionRequirement();
    }

    @Override
    public FormattableMessage getHelpMessage()
    {
        // See ExampleCommand#getHelpMessage()
        return null;
    }

    @Override
    protected String getPluginNamespace()
    {
        return TemplatePlugin.namespace();
    }
}
