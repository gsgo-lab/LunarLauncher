package net.kdt.pojavlaunch.lunar;

import androidx.appcompat.app.AppCompatActivity;

import net.kdt.pojavlaunch.value.MinecraftAccount;
import net.kdt.pojavlaunch.Tools;
import net.kdt.pojavlaunch.value.launcherprofiles.MinecraftProfile;

/**
 * Lunar's single facade for the real Minecraft launch pipeline.
 *
 * Tools.launchMinecraft() is the existing engine implementation and handles
 * runtime setup, game preparation, renderer/native initialization and launch.
 */
public final class LunarMinecraftManager {
    private LunarMinecraftManager() {}

    public static void launch(
            AppCompatActivity activity,
            MinecraftAccount account,
            MinecraftProfile profile,
            String versionId,
            int javaRequirement) throws Throwable {

        if (versionId == null || versionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Minecraft version is empty");
        }

        if (javaRequirement != 8 &&
                javaRequirement != 17 &&
                javaRequirement != 21) {
            throw new IllegalArgumentException(
                    "Unsupported Java runtime: " + javaRequirement);
        }

        Tools.launchMinecraft(
                activity,
                account,
                profile,
                versionId,
                javaRequirement
        );
    }
}
