package com.sherman.infinite_resources;

import com.mojang.logging.LogUtils;
import com.sherman.infinite_resources.registry.ModRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(InfiniteResources.MODID)
public class InfiniteResources {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "infinite_resources";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public InfiniteResources(IEventBus modEventBus) {

        ModRegistry.register(modEventBus);

    }
}
