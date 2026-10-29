package com.magneticchen.daijishou.arcade;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URLDecoder;

public class ArcadeMediaResolver {

    private static final String TAG = "ArcadeMediaResolver";

    public static class ArtworkFiles {
        public File backgroundFile;
        public File boxFile;
    }

    public static ArtworkFiles resolveArtworkFiles(Object itemObj) {
        if (itemObj == null) return null;
        try {
            Method getUriMethod = itemObj.getClass().getMethod("getUri");
            Object uriObj = getUriMethod.invoke(itemObj);
            if (uriObj == null) return null;

            String uriStr = uriObj.toString();
            String path;
            if (uriObj instanceof Uri) {
                path = ((Uri) uriObj).getPath();
            } else if (uriStr.startsWith("file://")) {
                path = uriStr.substring(7);
            } else {
                path = uriStr;
            }

            if (path == null || path.isEmpty()) return null;
            path = URLDecoder.decode(path, "UTF-8");

            File romFile = new File(path);
            File romDir = romFile.getParentFile();
            if (romDir == null || !romDir.exists()) return null;

            String filename = romFile.getName();
            int dot = filename.lastIndexOf('.');
            String baseName = (dot > 0) ? filename.substring(0, dot) : filename;

            String gameName = null;
            try {
                Method getNameMethod = itemObj.getClass().getMethod("getName");
                Object nameObj = getNameMethod.invoke(itemObj);
                if (nameObj != null) gameName = nameObj.toString();
            } catch (Throwable ignored) {}

            File mediaDir = new File(romDir, "media");
            File bgDir = new File(mediaDir, "background");
            File boxDir = new File(mediaDir, "box");

            ArtworkFiles files = new ArtworkFiles();

            // Find background file
            files.backgroundFile = findMediaFile(bgDir, baseName, gameName);

            // Find box art file
            files.boxFile = findMediaFile(boxDir, baseName, gameName);

            // If no box file, fallback to background file
            if (files.boxFile == null && files.backgroundFile != null) {
                files.boxFile = files.backgroundFile;
            }

            return files;
        } catch (Throwable t) {
            Log.w(TAG, "Error resolving artwork files", t);
            return null;
        }
    }

    private static File findMediaFile(File dir, String baseName, String gameName) {
        if (!dir.exists() || !dir.isDirectory()) return null;

        String[] extensions = new String[] { ".png", ".jpg", ".jpeg", ".PNG", ".JPG", ".JPEG" };

        if (baseName != null && !baseName.isEmpty()) {
            for (String ext : extensions) {
                File f = new File(dir, baseName + ext);
                if (f.exists() && f.isFile()) return f;
            }
        }

        if (gameName != null && !gameName.isEmpty() && !gameName.equalsIgnoreCase(baseName)) {
            for (String ext : extensions) {
                File f = new File(dir, gameName + ext);
                if (f.exists() && f.isFile()) return f;
            }
        }

        return null;
    }

    public static String resolveBoxArtPath(Object itemObj) {
        ArtworkFiles files = resolveArtworkFiles(itemObj);
        if (files == null) return null;
        if (files.boxFile != null && files.boxFile.exists()) {
            return files.boxFile.getAbsolutePath();
        }
        if (files.backgroundFile != null && files.backgroundFile.exists()) {
            return files.backgroundFile.getAbsolutePath();
        }
        return null;
    }

    public static boolean resolveAndApplyPreview(Fragment fragment, Object itemObj) {
        if (fragment == null || itemObj == null) return false;
        View rootView = fragment.getView();
        if (rootView == null) return false;

        ArtworkFiles files = resolveArtworkFiles(itemObj);
        if (files == null || (files.backgroundFile == null && files.boxFile == null)) {
            return false;
        }

        Context context = rootView.getContext();

        // 1. Hide placeholder and platform text if artwork is available
        int placeholderId = ArcadeRes.getId(context, "platform_library_placeholder");
        if (placeholderId != 0) {
            View ph = rootView.findViewById(placeholderId);
            if (ph != null) ph.setVisibility(View.GONE);
        }

        int platTextId = ArcadeRes.getId(context, "platform_library_platform_text_view");
        if (platTextId != 0) {
            View pt = rootView.findViewById(platTextId);
            if (pt != null) pt.setVisibility(View.GONE);
        }

        // 2. Load background image
        int bgId = ArcadeRes.getId(context, "platform_library_background");
        if (bgId != 0) {
            ImageView bgView = rootView.findViewById(bgId);
            if (bgView != null && files.backgroundFile != null && files.backgroundFile.exists()) {
                loadIntoImageView(fragment, files.backgroundFile, bgView, 1280, 720, true);
            }
        }

        // 3. Load thumbnail / box art image
        int thumbId = ArcadeRes.getId(context, "platform_library_thumbnail");
        if (thumbId != 0) {
            ImageView thumbView = rootView.findViewById(thumbId);
            File thumbFile = (files.boxFile != null && files.boxFile.exists()) ? files.boxFile : files.backgroundFile;
            if (thumbView != null && thumbFile != null && thumbFile.exists()) {
                loadIntoImageView(fragment, thumbFile, thumbView, 400, 400, false);
            }
        }

        return true;
    }

    private static void loadIntoImageView(Fragment fragment, File file, ImageView imageView, int reqW, int reqH, boolean centerCrop) {
        try {
            // Try Glide first
            com.bumptech.glide.Glide.with(fragment)
                .load(file)
                .into(imageView);
        } catch (Throwable t) {
            // Fallback to sampled BitmapFactory
            try {
                Bitmap bmp = decodeSampledBitmap(file.getAbsolutePath(), reqW, reqH);
                if (bmp != null) {
                    imageView.setImageBitmap(bmp);
                }
            } catch (Throwable ignored) {}
        }
    }

    public static Bitmap decodeSampledBitmap(String path, int reqWidth, int reqHeight) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);

            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return BitmapFactory.decodeFile(path, options);
        } catch (Throwable t) {
            return null;
        }
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}
