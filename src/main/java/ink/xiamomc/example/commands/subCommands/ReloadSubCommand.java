package ink.xiamomc.example.commands.subCommands;

import ink.xiamomc.example.ExamplePluginObject;
import ink.xiamomc.example.config.ExampleConfigManager;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import xiamomc.pluginbase.Annotations.Resolved;
import xiamomc.pluginbase.Command.ISubCommand;
import xiamomc.pluginbase.Messages.FormattableMessage;

public class ReloadSubCommand extends ExamplePluginObject implements ISubCommand
{
    @Override
    public @NotNull String getCommandName()
    {
        return "reload";
    }

    @Override
    public FormattableMessage getHelpMessage()
    {
        return null;
    }

    @Resolved
    private ExampleConfigManager configManager;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull String[] args)
    {
        configManager.reload();

        sender.sendMessage(Component.text("Reloaded!"));
        return true;
    }
}
