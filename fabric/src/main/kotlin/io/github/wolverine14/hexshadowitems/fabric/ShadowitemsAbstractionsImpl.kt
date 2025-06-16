@file:JvmName("ShadowitemsAbstractionsImpl")

package io.github.wolverine14.hexshadowitems.fabric

import io.github.wolverine14.hexshadowitems.registry.ShadowitemsRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: ShadowitemsRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
