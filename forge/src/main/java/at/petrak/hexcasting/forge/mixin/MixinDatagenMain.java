package at.petrak.hexcasting.forge.mixin;

import at.petrak.hexcasting.Shadowitems;
import org.spongepowered.asm.mixin.Mixin;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;

// scuffed workaround for https://github.com/architectury/architectury-loom/issues/189
@Mixin(net.minecraft.data.Main.class)
public class MixinDatagenMain {
    @WrapMethod(method = "main", remap = false)
    private static void shadowitems$systemExitAfterDatagenFinishes(String[] strings, Operation<Void> original) {
        try {
            original.call((Object) strings);
        } catch (Throwable throwable) {
            Shadowitems.LOGGER.error("Datagen failed!", throwable);
            System.exit(1);
        }
        Shadowitems.LOGGER.info("Datagen succeeded, terminating.");
        System.exit(0);
    }
}
