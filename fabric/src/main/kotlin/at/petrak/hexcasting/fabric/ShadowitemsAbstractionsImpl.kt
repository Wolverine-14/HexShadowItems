@file:JvmName("ShadowitemsAbstractionsImpl")

package at.petrak.hexcasting.fabric

import at.petrak.hexcasting.registry.ShadowitemsRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: ShadowitemsRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
