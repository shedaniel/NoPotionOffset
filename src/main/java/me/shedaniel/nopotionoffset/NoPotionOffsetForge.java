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

package me.shedaniel.nopotionoffset;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod("no-potion-offset-forge")
public class NoPotionOffsetForge {
    public NoPotionOffsetForge() {
        DistExecutor.runWhenOn(Dist.CLIENT, () -> new Runnable() {
            @Override
            public void run() {
                MinecraftForge.EVENT_BUS.addListener(this::shiftPotion);
            }
            
            private void shiftPotion(GuiScreenEvent.PotionShiftEvent event) {
                event.setCanceled(true);
            }
        });
    }
}
