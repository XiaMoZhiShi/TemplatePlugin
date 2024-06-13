package ink.xiamomc.example;

import ink.xiamomc.example.commands.ExampleCommandHelper;
import org.bukkit.Bukkit;
import xiamomc.pluginbase.XiaMoJavaPlugin;

public final class TemplatePlugin extends XiaMoJavaPlugin
{
    public TemplatePlugin()
    {
        instance = this;
    }

    // Your plugin namespace here.
    private static final String namespace = "template";

    public static String namespace()
    {
        return namespace;
    }

    // In case you have some code that doesn't fit into the instance system, call instance().
    // It's recommended to inherit the ExamplePluginObject so that you can access the plugin through the `plugin` field.
    private static TemplatePlugin instance;
    public static TemplatePlugin instance()
    {
        return instance;
    }

    @Override
    public String getNameSpace()
    {
        return namespace();
    }

    // Not initializing here because the plugin isn't initialized
    // If we create a new instance here, it will run before the plugin initialization
    //
    // Also keeping reference for this is not necessary, this is just a showcase.
    private ExampleCommandHelper commandHelper;

    @Override
    public void onEnable()
    {
        super.onEnable();

        // Plugin startup logic here

        // It will register commands automatically
        dependencyManager.cache(commandHelper = new ExampleCommandHelper());
    }

    @Override
    public void onDisable()
    {
        try
        {
            // Plugin shutdown logic here
        }
        catch (Throwable t)
        {
        }

        // It's recommended to make sure `super.onDisable()` always gets called on plugin disable.
        super.onDisable();
    }

    //region Folia compat

    @Override
    public void startMainLoop(Runnable r)
    {
        Bukkit.getGlobalRegionScheduler().runAtFixedRate(this, o -> r.run(), 1, 1);
    }

    @Override
    public void runAsync(Runnable r)
    {
        Bukkit.getAsyncScheduler().runNow(this, o -> r.run());
    }

    //endregion Folia compat
}
