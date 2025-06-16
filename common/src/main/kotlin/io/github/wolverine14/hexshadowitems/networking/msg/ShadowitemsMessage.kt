package io.github.wolverine14.hexshadowitems.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.wolverine14.hexshadowitems.Shadowitems
import io.github.wolverine14.hexshadowitems.networking.ShadowitemsNetworking
import io.github.wolverine14.hexshadowitems.networking.handler.applyOnClient
import io.github.wolverine14.hexshadowitems.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface ShadowitemsMessage

sealed interface ShadowitemsMessageC2S : ShadowitemsMessage {
    fun sendToServer() {
        ShadowitemsNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface ShadowitemsMessageS2C : ShadowitemsMessage {
    fun sendToPlayer(player: ServerPlayer) {
        ShadowitemsNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        ShadowitemsNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface ShadowitemsMessageCompanion<T : ShadowitemsMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                Shadowitems.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is ShadowitemsMessageC2S -> msg.applyOnServer(ctx)
                    else -> Shadowitems.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                Shadowitems.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is ShadowitemsMessageS2C -> msg.applyOnClient(ctx)
                    else -> Shadowitems.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
