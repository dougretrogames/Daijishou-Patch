package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Gainmap;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Preconditions;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* INFO: loaded from: classes3.dex */
final class GlideBitmapFactory {
    private static final String TAG = "GlideBitmapFactory";

    private GlideBitmapFactory() {
    }

    public static Bitmap decodeStream(InputStream inputStream, BitmapFactory.Options options, ImageReader imageReader) {
        if (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) {
            return safeAndExpensiveDecodeHardwareBitmapWithGainmap(inputStream, options);
        }
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap decodeByteArray(byte[] bArr, BitmapFactory.Options options, ImageReader imageReader) {
        if (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) {
            return safeAndExpensiveDecodeHardwareBitmapWithGainmap(bArr, options);
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, BitmapFactory.Options options, ImageReader imageReader) {
        if (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) {
            return safeAndExpensiveDecodeHardwareBitmapWithGainmap(fileDescriptor, options);
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    private static boolean isLikelyToContainGainmap(ImageReader imageReader) {
        try {
            boolean zHasJpegMpf = imageReader.hasJpegMpf();
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "isLikelyToContainGainmap=" + zHasJpegMpf);
            }
            return zHasJpegMpf;
        } catch (IOException e) {
            if (!Log.isLoggable(TAG, 2)) {
                return false;
            }
            Log.v(TAG, "isLikelyToContainGainmap failed", e);
            return false;
        }
    }

    /* WARN: Code duplicated, block: B:10:0x0019 A[PHI: r0
  0x0019: PHI (r0v10 android.graphics.Bitmap) = (r0v8 android.graphics.Bitmap), (r0v4 android.graphics.Bitmap) binds: [B:14:0x0025, B:9:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(InputStream inputStream, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeStream;
        Preconditions.checkArgument(options.inPreferredConfig == Bitmap.Config.HARDWARE);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmapSafeDecodeBitmapWithGainmap = null;
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (bitmapDecodeStream != null) {
                try {
                    bitmapSafeDecodeBitmapWithGainmap = safeDecodeBitmapWithGainmap(bitmapDecodeStream);
                    if (bitmapDecodeStream != null) {
                        bitmapDecodeStream.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bitmapDecodeStream != null) {
                        bitmapDecodeStream.recycle();
                    }
                    options.inPreferredConfig = Bitmap.Config.HARDWARE;
                    throw th;
                }
            } else if (bitmapDecodeStream != null) {
                bitmapDecodeStream.recycle();
            }
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            return bitmapSafeDecodeBitmapWithGainmap;
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeStream = null;
        }
    }

    /* WARN: Code duplicated, block: B:10:0x001b A[PHI: r0
  0x001b: PHI (r0v10 android.graphics.Bitmap) = (r0v8 android.graphics.Bitmap), (r0v4 android.graphics.Bitmap) binds: [B:14:0x0027, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(byte[] bArr, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeByteArray;
        Preconditions.checkArgument(options.inPreferredConfig == Bitmap.Config.HARDWARE);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmapSafeDecodeBitmapWithGainmap = null;
        try {
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null) {
                try {
                    bitmapSafeDecodeBitmapWithGainmap = safeDecodeBitmapWithGainmap(bitmapDecodeByteArray);
                    if (bitmapDecodeByteArray != null) {
                        bitmapDecodeByteArray.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bitmapDecodeByteArray != null) {
                        bitmapDecodeByteArray.recycle();
                    }
                    options.inPreferredConfig = Bitmap.Config.HARDWARE;
                    throw th;
                }
            } else if (bitmapDecodeByteArray != null) {
                bitmapDecodeByteArray.recycle();
            }
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            return bitmapSafeDecodeBitmapWithGainmap;
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeByteArray = null;
        }
    }

    /* WARN: Code duplicated, block: B:10:0x0019 A[PHI: r0
  0x0019: PHI (r0v10 android.graphics.Bitmap) = (r0v8 android.graphics.Bitmap), (r0v4 android.graphics.Bitmap) binds: [B:14:0x0025, B:9:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(FileDescriptor fileDescriptor, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeFileDescriptor;
        Preconditions.checkArgument(options.inPreferredConfig == Bitmap.Config.HARDWARE);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmapSafeDecodeBitmapWithGainmap = null;
        try {
            bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            if (bitmapDecodeFileDescriptor != null) {
                try {
                    bitmapSafeDecodeBitmapWithGainmap = safeDecodeBitmapWithGainmap(bitmapDecodeFileDescriptor);
                    if (bitmapDecodeFileDescriptor != null) {
                        bitmapDecodeFileDescriptor.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bitmapDecodeFileDescriptor != null) {
                        bitmapDecodeFileDescriptor.recycle();
                    }
                    options.inPreferredConfig = Bitmap.Config.HARDWARE;
                    throw th;
                }
            } else if (bitmapDecodeFileDescriptor != null) {
                bitmapDecodeFileDescriptor.recycle();
            }
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            return bitmapSafeDecodeBitmapWithGainmap;
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeFileDescriptor = null;
        }
    }

    private static Bitmap safeDecodeBitmapWithGainmap(Bitmap bitmap) {
        Gainmap gainmap = bitmap.getGainmap();
        if (gainmap != null && gainmap.getGainmapContents().getConfig() == Bitmap.Config.ALPHA_8) {
            bitmap.setGainmap(GainmapCopier.convertSingleChannelGainmapToTripleChannelGainmap(gainmap));
        }
        return bitmap.copy(Bitmap.Config.HARDWARE, false);
    }

    private static final class GainmapCopier {
        private static final ColorMatrixColorFilter OPAQUE_FILTER = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255.0f});

        private GainmapCopier() {
        }

        public static Gainmap convertSingleChannelGainmapToTripleChannelGainmap(Gainmap gainmap) {
            Bitmap gainmapContents = gainmap.getGainmapContents();
            if (gainmapContents.getConfig() != Bitmap.Config.ALPHA_8) {
                return gainmap;
            }
            Gainmap gainmap2 = new Gainmap(copyAlpha8ToOpaqueArgb888(gainmapContents));
            float[] ratioMin = gainmap.getRatioMin();
            gainmap2.setRatioMin(ratioMin[0], ratioMin[1], ratioMin[2]);
            float[] ratioMax = gainmap.getRatioMax();
            gainmap2.setRatioMax(ratioMax[0], ratioMax[1], ratioMax[2]);
            float[] gamma = gainmap.getGamma();
            gainmap2.setGamma(gamma[0], gamma[1], gamma[2]);
            float[] epsilonSdr = gainmap.getEpsilonSdr();
            gainmap2.setEpsilonSdr(epsilonSdr[0], epsilonSdr[1], epsilonSdr[2]);
            float[] epsilonHdr = gainmap.getEpsilonHdr();
            gainmap2.setEpsilonHdr(epsilonHdr[0], epsilonHdr[1], epsilonHdr[2]);
            gainmap2.setDisplayRatioForFullHdr(gainmap.getDisplayRatioForFullHdr());
            gainmap2.setMinDisplayRatioForHdrTransition(gainmap.getMinDisplayRatioForHdrTransition());
            return gainmap2;
        }

        private static Bitmap copyAlpha8ToOpaqueArgb888(Bitmap bitmap) {
            Preconditions.checkArgument(bitmap.getConfig() == Bitmap.Config.ALPHA_8);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(OPAQUE_FILTER);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return bitmapCreateBitmap;
        }
    }

    public static final class GainmapDecoderWorkaroundStateCalculator {
        private static final GlideSuppliers.GlideSupplier<Boolean> REQUIRES_GAIN_MAP_FIX = GlideSuppliers.memorize(new GlideBitmapFactory$GainmapDecoderWorkaroundStateCalculator$$ExternalSyntheticLambda0());
        private static final String TAG = "GainmapWorkaroundCalc";

        private GainmapDecoderWorkaroundStateCalculator() {
        }

        /* INFO: Access modifiers changed from: private */
        public static boolean needsGainmapDecodeWorkaround(BitmapFactory.Options options) {
            if (Build.VERSION.SDK_INT == 34 && options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return REQUIRES_GAIN_MAP_FIX.get().booleanValue();
            }
            return false;
        }

        private static boolean calculateNeedsGainmapDecodeWorkaround() {
            if (Build.VERSION.SDK_INT != 34) {
                return false;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.HARDWARE, false);
            bitmapCreateBitmap.recycle();
            boolean z = bitmapCopy == null;
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "calculateNeedsGainmapDecodeWorkaround=" + z);
            }
            if (bitmapCopy != null) {
                bitmapCopy.recycle();
            }
            return z;
        }
    }
}
