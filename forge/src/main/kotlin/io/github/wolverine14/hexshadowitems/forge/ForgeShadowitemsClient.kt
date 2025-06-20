package io.github.wolverine14.hexshadowitems.forge

import io.github.wolverine14.hexshadowitems.ShadowitemsClient
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.LOADING_CONTEXT

object ForgeShadowitemsClient {
    fun init(event: FMLClientSetupEvent) {
        ShadowitemsClient.init()
        LOADING_CONTEXT.registerExtensionPoint(ConfigScreenFactory::class.java) {
            ConfigScreenFactory { _, parent -> ShadowitemsClient.getConfigScreen(parent) }
        }
    }
}
