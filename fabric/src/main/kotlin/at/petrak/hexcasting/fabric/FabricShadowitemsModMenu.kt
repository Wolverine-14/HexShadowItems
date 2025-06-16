package at.petrak.hexcasting.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import at.petrak.hexcasting.ShadowitemsClient

object FabricShadowitemsModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(ShadowitemsClient::getConfigScreen)
}
