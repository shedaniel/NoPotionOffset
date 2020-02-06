package me.shedaniel.nopotionoffset.mixin;

import net.minecraft.client.gui.screen.ingame.AbstractContainerScreen;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.container.Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractInventoryScreen.class)
public abstract class MixinAbstractInventoryScreen<T extends Container> extends AbstractContainerScreen<T> {
    public MixinAbstractInventoryScreen(T container, PlayerInventory playerInventory, Text name) {
        super(container, playerInventory, name);
    }
    
    @Inject(method = "applyStatusEffectOffset", at = @At("RETURN"))
    private void applyStatusEffectOffset(CallbackInfo info) {
        this.x = (this.width - this.containerWidth) / 2;
    }
}
