package at.petrak.hexcasting.networking

import dev.architectury.networking.NetworkChannel
import at.petrak.hexcasting.Shadowitems
import at.petrak.hexcasting.networking.msg.ShadowitemsMessageCompanion

object ShadowitemsNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Shadowitems.id("networking_channel"))

    fun init() {
        for (subclass in ShadowitemsMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
