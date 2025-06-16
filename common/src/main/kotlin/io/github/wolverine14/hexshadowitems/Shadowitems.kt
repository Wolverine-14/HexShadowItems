package io.github.wolverine14.hexshadowitems

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.wolverine14.hexshadowitems.config.ShadowitemsConfig
import io.github.wolverine14.hexshadowitems.networking.ShadowitemsNetworking
import io.github.wolverine14.hexshadowitems.registry.ShadowitemsActions

object Shadowitems {
    const val MODID = "shadowitems"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        ShadowitemsConfig.init()
        initRegistries(
            ShadowitemsActions,
        )
        ShadowitemsNetworking.init()
    }
}
