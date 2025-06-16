package io.github.wolverine14.hexshadowitems.networking.msg

import io.github.wolverine14.hexshadowitems.config.ShadowitemsConfig
import net.minecraft.network.FriendlyByteBuf

data class MsgSyncConfigS2C(val serverConfig: ShadowitemsConfig.ServerConfig) : ShadowitemsMessageS2C {
    companion object : ShadowitemsMessageCompanion<MsgSyncConfigS2C> {
        override val type = MsgSyncConfigS2C::class.java

        override fun decode(buf: FriendlyByteBuf) = MsgSyncConfigS2C(
            serverConfig = ShadowitemsConfig.ServerConfig.decode(buf),
        )

        override fun MsgSyncConfigS2C.encode(buf: FriendlyByteBuf) {
            serverConfig.encode(buf)
        }
    }
}
