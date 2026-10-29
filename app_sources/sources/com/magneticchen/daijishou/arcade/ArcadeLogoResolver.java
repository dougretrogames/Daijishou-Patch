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

        // 1. Check special items: "Todos os Jogos", "Apps", "Coleções"
        if (item.getId() == -998L || "all_games".equalsIgnoreCase(item.getShortname())) {
            File allGamesLogo = findSpecialLogoFile("clearlogo_allsystems.png");
            if (allGamesLogo != null && allGamesLogo.exists()) {
                loadInto(context, allGamesLogo, logoView, fallbackTitle);
                return;
            }
            int resId = ArcadeRes.getDrawable(context, "arcade_clearlogo_allsystems");
            if (resId != 0) {
                loadInto(context, resId, logoView, fallbackTitle);
                return;
            }
        }

        if (item.isAndroidApps() || item.getId() == -999L || "android".equalsIgnoreCase(item.getShortname()) || "apps".equalsIgnoreCase(item.getShortname())) {
            // Check ARC Browser / 2-Jogos apps clearlogo
            File appsLogo = findAppsLogoFile();
            if (appsLogo != null && appsLogo.exists()) {
                loadInto(context, appsLogo, logoView, fallbackTitle);
                return;
            }
            // Check bundled drawable
            int resId = ArcadeRes.getDrawable(context, "arcade_clearlogo_apps");
            if (resId != 0) {
                loadInto(context, resId, logoView, fallbackTitle);
                return;
            }
            int fallbackIcon = ArcadeRes.getDrawable(context, "ic_baseline_android_24");
            if (fallbackIcon != 0) {
                logoView.setVisibility(View.VISIBLE);
                if (fallbackTitle != null) {
                    fallbackTitle.setVisibility(View.VISIBLE);
                    fallbackTitle.setText(item.getName());
                }
                Glide.with(context).load(fallbackIcon).into(logoView);
                return;
            }
        }

        if ("collections".equalsIgnoreCase(item.getShortname()) || "colecoes".equalsIgnoreCase(item.getShortname())) {
            File collectionsLogo = findSpecialLogoFile("clearlogo_collections.png");
            if (collectionsLogo != null && collectionsLogo.exists()) {
                loadInto(context, collectionsLogo, logoView, fallbackTitle);
                return;
            }
            int resId = ArcadeRes.getDrawable(context, "arcade_clearlogo_collections");
            if (resId != 0) {
                loadInto(context, resId, logoView, fallbackTitle);
                return;
            }
        }

        // 2. Look for clearlogo files on local storage (2-Jogos, Daijishou, etc.)
        File clearlogoFile = findClearlogoFile(context, item.getShortname());
        if (clearlogoFile != null && clearlogoFile.exists()) {
            loadInto(context, clearlogoFile, logoView, fallbackTitle);
            return;
        }

        // 3. Fall back to platform's downloaded thumbnail in internal storage
        if (item.getId() > 0) {
            File internalThumb = new File(context.getFilesDir(), "platform_thumbnails" + File.separator + item.getId() + ".png");
            if (internalThumb.exists()) {
                loadInto(context, internalThumb, logoView, fallbackTitle);
                return;
            }
        }

        // 4. Fall back to platform's thumbnailPath
        String thumbPath = item.getThumbnailPath();
        if (thumbPath != null && !thumbPath.isEmpty()) {
            loadInto(context, thumbPath, logoView, fallbackTitle);
            return;
        }

        // 5. Stylized TextView with console title
        logoView.setImageDrawable(null);
        logoView.setVisibility(View.GONE);
        if (fallbackTitle != null) {
            fallbackTitle.setVisibility(View.VISIBLE);
            fallbackTitle.setText(item.getName());
        }
    }

    private static void loadInto(Context context, Object source, ImageView logoView, TextView fallbackTitle) {
        if (fallbackTitle != null) {
            fallbackTitle.setVisibility(View.GONE);
        }
        logoView.setVisibility(View.VISIBLE);
        Glide.with(context)
            .load(source)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(logoView);
    }

    private static File findSpecialLogoFile(String filename) {
        File storage = Environment.getExternalStorageDirectory();
        File f1 = new File(storage, "2-Jogos" + File.separator + filename);
        if (f1.exists()) return f1;
        File f2 = new File(storage, "Daijishou" + File.separator + filename);
        if (f2.exists()) return f2;
        File f3 = new File(storage, "Daijishou" + File.separator + "clearlogos" + File.separator + filename);
        if (f3.exists()) return f3;
        return null;
    }

    private static File findAppsLogoFile() {
        File storage = Environment.getExternalStorageDirectory();
        File f1 = new File(storage, "2-Jogos/apps/media/clearlogo.png");
        if (f1.exists()) return f1;
        File f2 = new File(storage, "2-Jogos/clearlogo_apps.png");
        if (f2.exists()) return f2;
        File f3 = new File(storage, "2-Jogos/clearlogo_android.png");
        if (f3.exists()) return f3;
        File f4 = new File(storage, "Daijishou/clearlogos/android.png");
        if (f4.exists()) return f4;
        File f5 = new File(storage, "Daijishou/clearlogos/apps.png");
        if (f5.exists()) return f5;
        return null;
    }

    private static File findClearlogoFile(Context context, String shortname) {
        if (shortname == null || shortname.isEmpty()) return null;
        String sn = shortname.toLowerCase();

        String[] aliases = getAliases(sn);
        File storage = Environment.getExternalStorageDirectory();

        // 1. Direct 2-Jogos structure: 2-Jogos/{shortname}/media/clearlogo.png
        for (String alias : aliases) {
            File f = new File(storage, "2-Jogos" + File.separator + alias + File.separator + "media" + File.separator + "clearlogo.png");
            if (f.exists()) return f;
            File fFlat = new File(storage, "2-Jogos" + File.separator + "clearlogo_" + alias + ".png");
            if (fFlat.exists()) return fFlat;
            File fCol = new File(storage, "2-Jogos" + File.separator + "collection_" + alias + ".png");
            if (fCol.exists()) return fCol;
        }

        // 2. Daijishou folder structure: /sdcard/Daijishou/clearlogos/{shortname}.png
        String[] subdirs = {
            "clearlogos",
            "clear_logos",
            "logos",
            "platform_thumbnails",
            "thumbnails"
        };

        File sdcardDaijishou = new File(storage, "Daijishou");
        if (sdcardDaijishou.exists()) {
            for (String alias : aliases) {
                for (String sub : subdirs) {
                    File candidate = new File(sdcardDaijishou, sub + File.separator + alias + ".png");
                    if (candidate.exists()) return candidate;
                }
            }
        }

        // 3. App external files dir (Android/data/com.magneticchen.daijishou/files/)
        File extFiles = context.getExternalFilesDir(null);
        if (extFiles != null) {
            for (String alias : aliases) {
                for (String sub : subdirs) {
                    File candidate = new File(extFiles, sub + File.separator + alias + ".png");
                    if (candidate.exists()) return candidate;
                }
            }
        }

        // 4. ARC Browser directory if migrated
        File arcClearlogos = new File(storage, "Android/data/net.floatingpoint.android.arcturus/files/clearlogos");
        if (arcClearlogos.exists()) {
            for (String alias : aliases) {
                File candidate = new File(arcClearlogos, alias + ".png");
                if (candidate.exists()) return candidate;
            }
        }

        return null;
    }

    private static String[] getAliases(String shortname) {
        if ("genesis".equals(shortname) || "megadrive".equals(shortname)) {
            return new String[]{shortname, "genesis", "megadrive"};
        }
        if ("gc".equals(shortname) || "gamecube".equals(shortname)) {
            return new String[]{shortname, "gc", "gamecube"};
        }
        if ("master".equals(shortname) || "mastersystem".equals(shortname)) {
            return new String[]{shortname, "master", "mastersystem"};
        }
        if ("tg16".equals(shortname) || "pce".equals(shortname) || "pcengine".equals(shortname)) {
            return new String[]{shortname, "pcengine", "tg16", "pce"};
        }
        if ("tgcd".equals(shortname) || "pcecd".equals(shortname) || "pcenginecd".equals(shortname)) {
            return new String[]{shortname, "pcenginecd", "tgcd", "pcecd"};
        }
        if ("coleco".equals(shortname) || "colecovision".equals(shortname)) {
            return new String[]{shortname, "colecovision", "coleco"};
        }
        if ("wsc".equals(shortname) || "ws".equals(shortname) || "wswanc".equals(shortname)) {
            return new String[]{shortname, "wswanc", "wsc", "ws"};
        }
        if ("arcade".equals(shortname) || "mame".equals(shortname) || "fbneo".equals(shortname)) {
            return new String[]{shortname, "arcade", "mame", "fbneo"};
        }
        if ("android".equals(shortname) || "apps".equals(shortname)) {
            return new String[]{shortname, "apps", "android"};
        }
        return new String[]{shortname};
    }
}
