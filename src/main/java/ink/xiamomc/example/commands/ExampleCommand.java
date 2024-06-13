package ink.xiamomc.example.commands;

import ink.xiamomc.example.ExamplePluginObject;
import ink.xiamomc.example.messages.CommandStrings;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import xiamomc.pluginbase.Command.IPluginCommand;
import xiamomc.pluginbase.Messages.FormattableMessage;

import java.util.List;

public class ExampleCommand extends ExamplePluginObject implements IPluginCommand
{
    @Override
    public String getCommandName()
    {
        // Make sure the command name is present in the build script
        // See build.gradle.kts#L92
        return "example_command";
    }

    @Override
    public String getPermissionRequirement()
    {
        // Null if this doesn't require any permission
        return IPluginCommand.super.getPermissionRequirement();
    }

    @Override
    public List<String> onTabComplete(List<String> args, CommandSender source)
    {
        return List.of("Suggestion_1", "Suggestion_2");
    }

    @Override
    public FormattableMessage getHelpMessage()
    {
        return CommandStrings.exampleMessage();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings)
    {
        commandSender.sendMessage(Component.text("You just fired this command!"));

        // Return false will make server display a message about command not found for the sender.
        return true;
    }
}
