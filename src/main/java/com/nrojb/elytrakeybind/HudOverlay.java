package com.nrojb.elytrakeybind;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

@EventBusSubscriber(modid = ElytraKeybind.MODID, value = Dist.CLIENT)
public class HudOverlay
{
    private static final ResourceLocation LOCKED_ICON = ResourceLocation.fromNamespaceAndPath(ElytraKeybind.MODID, "textures/locked.png");
    private static final ResourceLocation UNLOCKED_ICON = ResourceLocation.fromNamespaceAndPath(ElytraKeybind.MODID, "textures/unlocked.png");

    private static final ResourceLocation ICON_ID = ResourceLocation.fromNamespaceAndPath(ElytraKeybind.MODID, "status_icon");

    @SubscribeEvent
    public static void registerGuiLayers(RegisterGuiLayersEvent event) {

        event.registerAbove(VanillaGuiLayers.HOTBAR, ICON_ID,
                ((guiGraphics, deltaTracker) -> {

                    // Base location is to the right of the hotbar.
                    int x = Config.xOffset.getAsInt() + Minecraft.getInstance().getWindow().getGuiScaledWidth() / 2 + 100;
                    int y = Config.yOffset.getAsInt() + Minecraft.getInstance().getWindow().getGuiScaledHeight() - 20;

                    if (ElytraKeybind.elytraToggleEnabled && Config.showEnabledIcon.getAsBoolean())
                    {
                        guiGraphics.blit(UNLOCKED_ICON, x, y, 0, 0, 16, 16, 16, 16);
                    }
                    else if (!ElytraKeybind.elytraToggleEnabled && Config.showDisabledIcon.getAsBoolean())
                    {
                        guiGraphics.blit(LOCKED_ICON, x, y, 0, 0, 16, 16, 16, 16);
                    }
                })
        );

    }

}
