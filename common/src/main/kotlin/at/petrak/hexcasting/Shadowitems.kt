package at.petrak.hexcasting

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import at.petrak.hexcasting.config.ShadowitemsConfig
import at.petrak.hexcasting.networking.ShadowitemsNetworking
import at.petrak.hexcasting.registry.ShadowitemsActions

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
