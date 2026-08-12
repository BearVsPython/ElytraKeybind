package com.nrojb.elytrakeybind;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue disableChatMessages = BUILDER
            .comment("Toggle the \"Elytra Toggle: true\" messages")
            .define("disableChatMessages", false);

    public static final ModConfigSpec.BooleanValue showEnabledIcon = BUILDER
            .comment("Show an icon on the HUD when Elytra are enabled.")
            .define("showEnabledIcon", true);

    public static final ModConfigSpec.BooleanValue showDisabledIcon = BUILDER
            .comment("Show an icon on the HUD when Elytra are disabled.")
            .define("showDisabledIcon", true);

    public static final ModConfigSpec.IntValue xOffset = BUILDER
            .comment("X Position for the Enabled/Disabled icon.")
            .defineInRange("iconXPosition", 0, Integer.MIN_VALUE, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue yOffset = BUILDER
            .comment("Y Position for the Enabled/Disabled icon.")
            .defineInRange("iconYPosition", 0, Integer.MIN_VALUE, Integer.MAX_VALUE);

    static final ModConfigSpec SPEC = BUILDER.build();
}
