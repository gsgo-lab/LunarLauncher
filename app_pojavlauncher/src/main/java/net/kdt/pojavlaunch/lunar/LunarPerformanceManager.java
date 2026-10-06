package net.kdt.pojavlaunch.lunar;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Conservative device-aware RAM recommendation for Lunar.
 * The underlying engine remains responsible for final JVM/runtime safety.
 */
public final class LunarPerformanceManager {
    private LunarPerformanceManager() {}

    public static int recommendedRamMb(Context context, LunarPerformanceProfile profile) {
        ActivityManager am = (ActivityManager)
                context.getSystemService(Context.ACTIVITY_SERVICE);

        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(info);

        long totalMb = info.totalMem / (1024L * 1024L);
        double ratio;

        switch (profile) {
            case MAX_FPS:
                ratio = 0.40;
                break;
            case QUALITY:
                ratio = 0.32;
                break;
            case BALANCED:
            default:
                ratio = 0.35;
                break;
        }

        int result = (int) Math.round(totalMb * ratio);
        result = Math.max(768, result);
        result = Math.min(result, (int) Math.max(768, totalMb / 2));
        return result;
    }
}
