package at.petrak.hexcasting.fabric

import at.petrak.hexcasting.Shadowitems
import net.fabricmc.api.ModInitializer

object FabricShadowitems : ModInitializer {
    override fun onInitialize() {
        Shadowitems.init()
    }
}
