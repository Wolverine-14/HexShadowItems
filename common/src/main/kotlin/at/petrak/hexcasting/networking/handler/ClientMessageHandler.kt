package at.petrak.hexcasting.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import at.petrak.hexcasting.config.ShadowitemsConfig
import at.petrak.hexcasting.networking.msg.*

fun ShadowitemsMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            ShadowitemsConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
