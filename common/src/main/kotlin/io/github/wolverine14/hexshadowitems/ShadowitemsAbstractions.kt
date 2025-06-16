@file:JvmName("ShadowitemsAbstractions")

package io.github.wolverine14.hexshadowitems

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.wolverine14.hexshadowitems.registry.ShadowitemsRegistrar

fun initRegistries(vararg registries: ShadowitemsRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: ShadowitemsRegistrar<T>) {
    throw AssertionError()
}
