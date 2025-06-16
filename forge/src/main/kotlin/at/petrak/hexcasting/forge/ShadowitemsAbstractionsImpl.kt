@file:JvmName("ShadowitemsAbstractionsImpl")

package at.petrak.hexcasting.forge

import at.petrak.hexcasting.registry.ShadowitemsRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: ShadowitemsRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
