package at.petrak.hexcasting

import at.petrak.hexcasting.config.ShadowitemsConfig
import at.petrak.hexcasting.config.ShadowitemsConfig.GlobalConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object ShadowitemsClient {
    fun init() {
        ShadowitemsConfig.initClient()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(GlobalConfig::class.java, parent).get()
    }
}
