/*
 * Copyright (c) 2020 shedaniel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.shedaniel.nopotionoffset.mixin;

import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.ContainerScreen;
import net.minecraft.container.Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractInventoryScreen.class)
public abstract class MixinAbstractInventoryScreen<T extends Container> extends ContainerScreen<T> {
    public MixinAbstractInventoryScreen(T container, PlayerInventory playerInventory, Text name) {
        super(container, playerInventory, name);
    }
    
    @Inject(method = "applyStatusEffectOffset", at = @At("RETURN"))
    private void applyStatusEffectOffset(CallbackInfo info) {
        this.x = (this.width - this.containerWidth) / 2;
    }
}
