package io.github.wolverine14.hexshadowitems.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.wolverine14.hexshadowitems.ShadowitemsClient

object FabricShadowitemsModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(ShadowitemsClient::getConfigScreen)
}
