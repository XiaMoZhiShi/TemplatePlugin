package ink.xiamomc.example.config;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import xiamomc.pluginbase.Configuration.ConfigNode;
import xiamomc.pluginbase.Configuration.ConfigOption;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class ExampleConfigOptions
{
    // Note: If the initial node name for ConfigNode is empty, it will default to "root".
    //       So `ConfigNode.create().append("booleanValue")` will become `root.booleanValue` in the config.
    public static final ConfigOption<Boolean> booleanValue = new ConfigOption<>(ConfigNode.create().append("booleanValue"), false);

    public static List<ConfigOption<?>> values()
    {
        var fields = Arrays.stream(ExampleConfigOptions.class.getFields())
                .filter(f -> f.getType().equals(ConfigOption.class) && Modifier.isStatic(f.getModifiers()))
                .toList();

        var list = fields.stream().map(f ->
        {
            try
            {
                return (ConfigOption<?>) f.get(null);
            }
            catch (Throwable t)
            {
                throw new RuntimeException(t);
            }
        }).toList();

        return new ObjectArrayList<>(list);
    }

}
