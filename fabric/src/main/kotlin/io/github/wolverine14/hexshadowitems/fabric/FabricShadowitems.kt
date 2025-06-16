package io.github.wolverine14.hexshadowitems.fabric

import io.github.wolverine14.hexshadowitems.Shadowitems
import net.fabricmc.api.ModInitializer

object FabricShadowitems : ModInitializer {
    override fun onInitialize() {
        Shadowitems.init()
    }
}
