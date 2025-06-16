@file:JvmName("ShadowitemsAbstractions")

package at.petrak.hexcasting

import dev.architectury.injectables.annotations.ExpectPlatform
import at.petrak.hexcasting.registry.ShadowitemsRegistrar

fun initRegistries(vararg registries: ShadowitemsRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: ShadowitemsRegistrar<T>) {
    throw AssertionError()
}
