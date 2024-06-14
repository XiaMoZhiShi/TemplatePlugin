package ink.xiamomc.example.config;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.jetbrains.annotations.NotNull;
import xiamomc.pluginbase.Configuration.ConfigNode;
import xiamomc.pluginbase.Configuration.ConfigOption;
import xiamomc.pluginbase.Configuration.PluginConfigManager;
import xiamomc.pluginbase.XiaMoJavaPlugin;

import java.util.Map;

public class ExampleConfigManager extends PluginConfigManager
{
    public ExampleConfigManager(XiaMoJavaPlugin plugin)
    {
        super(plugin);
    }

    // `getAllNotDefault()` will get marked as abstract in future versions of PluginBase
    // So we must implement this
    @NotNull
    @Override
    public Map<ConfigNode, Object> getAllNotDefault()
    {
        var options = ExampleConfigOptions.values();
        var map = new Object2ObjectOpenHashMap<ConfigNode, Object>();

        for (var o : options)
        {
            if (o.excludeFromInit()) continue;

            // We don't know which type it is
            // So just hope this won't have error
            var val = getOrDefault((ConfigOption<Object>) o, Object.class);

            if (!val.equals(o.getDefault())) map.put(o.node(), val);
        }

        return map;
    }
}
