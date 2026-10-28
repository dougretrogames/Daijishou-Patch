package com.magneticchen.daijishou.arcade;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;

public class ArcadeLogoResolver {

    public static void resolveAndLoadLogo(Context context, ArcadeItem item, ImageView logoView, TextView fallbackTitle) {
        if (context == null || item == null || logoView == null) return;

        if (item.isAndroidApps()) {
            int iconRes = ArcadeRes.getDrawable(context, "ic_baseline_android_24");
            if (iconRes != 0) {
                logoView.setVisibility(View.VISIBLE);
                if (fallbackTitle != null) {
                    fallbackTitle.setVisibility(View.VISIBLE);
                    fallbackTitle.setText(item.getName());
                }
                Glide.with(context).load(iconRes).into(logoView);
                return;
            }
        }

        // 1. Look for custom clearlogo files in Daijishou / theme directories
        File clearlogoFile = findClearlogoFile(context, item.getShortname());
        if (clearlogoFile != null && clearlogoFile.exists()) {
            if (fallbackTitle != null) fallbackTitle.setVisibility(View.GONE);
            logoView.setVisibility(View.VISIBLE);
            Glide.with(context)
                .load(clearlogoFile)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(logoView);
            return;
        }

        // 2. Fall back to platform's thumbnailPath
        String thumbPath = item.getThumbnailPath();
        if (thumbPath != null && !thumbPath.isEmpty()) {
            if (fallbackTitle != null) fallbackTitle.setVisibility(View.GONE);
            logoView.setVisibility(View.VISIBLE);
            Glide.with(context)
                .load(thumbPath)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(logoView);
            return;
        }

        // 3. Fallback to stylized TextView with console title
        logoView.setImageDrawable(null);
        logoView.setVisibility(View.GONE);
        if (fallbackTitle != null) {
            fallbackTitle.setVisibility(View.VISIBLE);
            fallbackTitle.setText(item.getName());
        }
    }

    private static File findClearlogoFile(Context context, String shortname) {
        if (shortname == null || shortname.isEmpty()) return null;

        String[] subdirs = {
            "clearlogos",
            "clear_logos",
            "logos",
            "platform_thumbnails",
            "thumbnails"
        };

        // Check external files dir (Android/data/com.magneticchen.daijishou/files/)
        File extFiles = context.getExternalFilesDir(null);
        if (extFiles != null) {
            for (String sub : subdirs) {
                File candidate = new File(extFiles, sub + File.separator + shortname + ".png");
                if (candidate.exists()) return candidate;
            }
        }

        // Check /sdcard/Daijishou/
        File sdcardDaijishou = new File(Environment.getExternalStorageDirectory(), "Daijishou");
        if (sdcardDaijishou.exists()) {
            for (String sub : subdirs) {
                File candidate = new File(sdcardDaijishou, sub + File.separator + shortname + ".png");
                if (candidate.exists()) return candidate;
            }
        }

        // Check ARC Browser clearlogos dir if migrated
        File arcClearlogos = new File(Environment.getExternalStorageDirectory(), "Android/data/net.floatingpoint.android.arcturus/files/clearlogos");
        if (arcClearlogos.exists()) {
            File candidate = new File(arcClearlogos, shortname + ".png");
            if (candidate.exists()) return candidate;
        }

        return null;
    }
}
