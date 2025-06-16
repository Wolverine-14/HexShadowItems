package at.petrak.hexcasting.fabric

import at.petrak.hexcasting.ShadowitemsClient
import net.fabricmc.api.ClientModInitializer

object FabricShadowitemsClient : ClientModInitializer {
    override fun onInitializeClient() {
        ShadowitemsClient.init()
    }
}
