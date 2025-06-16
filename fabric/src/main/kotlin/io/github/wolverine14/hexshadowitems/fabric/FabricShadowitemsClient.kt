package io.github.wolverine14.hexshadowitems.fabric

import io.github.wolverine14.hexshadowitems.ShadowitemsClient
import net.fabricmc.api.ClientModInitializer

object FabricShadowitemsClient : ClientModInitializer {
    override fun onInitializeClient() {
        ShadowitemsClient.init()
    }
}
