package io.github.wolverine14.hexshadowitems

import io.github.wolverine14.hexshadowitems.config.ShadowitemsConfig
import io.github.wolverine14.hexshadowitems.config.ShadowitemsConfig.GlobalConfig
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
