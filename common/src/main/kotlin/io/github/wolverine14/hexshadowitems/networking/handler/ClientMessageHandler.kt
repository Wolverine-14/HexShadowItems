package io.github.wolverine14.hexshadowitems.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.wolverine14.hexshadowitems.config.ShadowitemsConfig
import io.github.wolverine14.hexshadowitems.networking.msg.*

fun ShadowitemsMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            ShadowitemsConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
