package io.github.wolverine14.hexshadowitems.forge

import dev.architectury.platform.forge.EventBuses
import io.github.wolverine14.hexshadowitems.Shadowitems
import net.minecraft.data.DataProvider
import net.minecraft.data.DataProvider.Factory
import net.minecraft.data.PackOutput
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Shadowitems.MODID)
class ShadowitemsForge {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Shadowitems.MODID, this)
            addListener(ForgeShadowitemsClient::init)
            addListener(::gatherData)
        }
        Shadowitems.init()
    }

    private fun gatherData(event: GatherDataEvent) {
        event.apply {
            // TODO: add datagen providers here
        }
    }
}

fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, factory: (PackOutput) -> T) =
    generator.addProvider(run, Factory { factory(it) })
