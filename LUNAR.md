# Lunar Launcher Edition

This source tree is a branded Lunar Launcher edition built on the supplied
Amethyst Android source tree.

## Already provided by the engine

- real Minecraft: Java Edition launch pipeline
- Android Java runtime support
- Java 8 / 17 / 21 runtime components
- Minecraft version/profile management
- libraries and assets preparation/download flow
- download progress UI
- LWJGL/native components
- OpenGL/Vulkan-related renderer choices
- touch controls/editor and JSON control import path
- Fabric/Forge-related components present in the upstream tree
- foreground game service and game activity

## Lunar additions

`app_pojavlauncher/src/main/java/net/kdt/pojavlaunch/lunar/`

contains:

- `LunarMinecraftManager` — single Lunar entry point into the real launch path
- `LunarPerformanceManager` — conservative device-aware RAM recommendation
- `LunarPerformanceProfile` — MAX_FPS/BALANCED/QUALITY
- `LunarLauncherInfo` — Lunar branding metadata

The old Amethyst package names remain intentionally unchanged inside the
engine to avoid a dangerous whole-project package refactor.

## Build

From the project root:

    ./gradlew :app_pojavlauncher:assembleDebug

Debug APK:

    app_pojavlauncher/build/outputs/apk/debug/

The project still contains upstream license/copyright material. Keep it.
