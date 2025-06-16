package io.github.wolverine14.hexshadowitems.networking

import dev.architectury.networking.NetworkChannel
import io.github.wolverine14.hexshadowitems.Shadowitems
import io.github.wolverine14.hexshadowitems.networking.msg.ShadowitemsMessageCompanion

object ShadowitemsNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Shadowitems.id("networking_channel"))

    fun init() {
        for (subclass in ShadowitemsMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
