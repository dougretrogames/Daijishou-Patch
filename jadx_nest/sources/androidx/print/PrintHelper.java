package androidx.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* INFO: loaded from: classes3.dex */
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    final Context mContext;
    static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION = true;
    static final boolean IS_MIN_MARGINS_HANDLING_CORRECT = true;
    BitmapFactory.Options mDecodeOptions = null;
    final Object mLock = new Object();
    int mScaleMode = 2;
    int mColorMode = 2;
    int mOrientation = 1;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    public static boolean systemSupportsPrint() {
        return true;
    }

    public PrintHelper(Context context) {
        this.mContext = context;
    }

    public void setScaleMode(int i) {
        this.mScaleMode = i;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    public void setColorMode(int i) {
        this.mColorMode = i;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public int getOrientation() {
        int i = this.mOrientation;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public void printBitmap(String str, Bitmap bitmap) {
        printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        PrintAttributes.MediaSize mediaSize;
        if (bitmap == null) {
            return;
        }
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        if (isPortrait(bitmap)) {
            mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
        } else {
            mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        }
        printManager.print(str, new PrintBitmapAdapter(str, this.mScaleMode, bitmap, onPrintFinishCallback), new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.mColorMode).build());
    }

    private class PrintBitmapAdapter extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        private final Bitmap mBitmap;
        private final OnPrintFinishCallback mCallback;
        private final int mFittingMode;
        private final String mJobName;

        PrintBitmapAdapter(String str, int i, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            this.mJobName = str;
            this.mFittingMode = i;
            this.mBitmap = bitmap;
            this.mCallback = onPrintFinishCallback;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.mAttributes = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
        }
    }

    public void printBitmap(String str, Uri uri) throws FileNotFoundException {
        printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        PrintUriAdapter printUriAdapter = new PrintUriAdapter(str, uri, onPrintFinishCallback, this.mScaleMode);
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.mColorMode);
        int i = this.mOrientation;
        if (i == 1 || i == 0) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (i == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, printUriAdapter, builder.build());
    }

    private class PrintUriAdapter extends PrintDocumentAdapter {
        PrintAttributes mAttributes;
        Bitmap mBitmap = null;
        final OnPrintFinishCallback mCallback;
        final int mFittingMode;
        final Uri mImageFile;
        final String mJobName;
        AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;

        PrintUriAdapter(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i) {
            this.mJobName = str;
            this.mImageFile = uri;
            this.mCallback = onPrintFinishCallback;
            this.mFittingMode = i;
        }

        /* WARN: Bottom block not found for handler: all -> 0x0048 */
        @Override // android.print.PrintDocumentAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onLayout(android.print.PrintAttributes r7, android.print.PrintAttributes r8, android.os.CancellationSignal r9, android.print.PrintDocumentAdapter.LayoutResultCallback r10, android.os.Bundle r11) throws java.lang.Throwable {
            /*
                r6 = this;
                monitor-enter(r6)
                r6.mAttributes = r8     // Catch: java.lang.Throwable -> L43
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L43
                boolean r11 = r9.isCanceled()
                if (r11 == 0) goto Le
                r10.onLayoutCancelled()
                return
            Le:
                android.graphics.Bitmap r11 = r6.mBitmap
                if (r11 == 0) goto L2f
                android.print.PrintDocumentInfo$Builder r9 = new android.print.PrintDocumentInfo$Builder
                java.lang.String r11 = r6.mJobName
                r9.<init>(r11)
                r11 = 1
                android.print.PrintDocumentInfo$Builder r9 = r9.setContentType(r11)
                android.print.PrintDocumentInfo$Builder r9 = r9.setPageCount(r11)
                android.print.PrintDocumentInfo r9 = r9.build()
                boolean r7 = r8.equals(r7)
                r7 = r7 ^ r11
                r10.onLayoutFinished(r9, r7)
                return
            L2f:
                androidx.print.PrintHelper$PrintUriAdapter$1 r0 = new androidx.print.PrintHelper$PrintUriAdapter$1
                r1 = r6
                r4 = r7
                r3 = r8
                r2 = r9
                r5 = r10
                r0.<init>(r2, r3, r4, r5)
                r7 = 0
                android.net.Uri[] r7 = new android.net.Uri[r7]
                android.os.AsyncTask r7 = r0.execute(r7)
                r1.mLoadBitmap = r7
                return
            L43:
                r0 = move-exception
                r1 = r6
            L45:
                r7 = r0
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L48
                throw r7
            L48:
                r0 = move-exception
                goto L45
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.PrintUriAdapter.onLayout(android.print.PrintAttributes, android.print.PrintAttributes, android.os.CancellationSignal, android.print.PrintDocumentAdapter$LayoutResultCallback, android.os.Bundle):void");
        }

        /* INFO: renamed from: androidx.print.PrintHelper$PrintUriAdapter$1, reason: invalid class name */
        class AnonymousClass1 extends AsyncTask<Uri, Boolean, Bitmap> {
            final /* synthetic */ CancellationSignal val$cancellationSignal;
            final /* synthetic */ PrintDocumentAdapter.LayoutResultCallback val$layoutResultCallback;
            final /* synthetic */ PrintAttributes val$newPrintAttributes;
            final /* synthetic */ PrintAttributes val$oldPrintAttributes;

            AnonymousClass1(CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
                this.val$cancellationSignal = cancellationSignal;
                this.val$newPrintAttributes = printAttributes;
                this.val$oldPrintAttributes = printAttributes2;
                this.val$layoutResultCallback = layoutResultCallback;
            }

            /* INFO: renamed from: androidx.print.PrintHelper$PrintUriAdapter$1$1, reason: invalid class name and collision with other inner class name */
            class C00211 implements CancellationSignal.OnCancelListener {
                C00211() {
                }

                @Override // android.os.CancellationSignal.OnCancelListener
                public void onCancel() {
                    PrintUriAdapter.this.cancelLoad();
                    AnonymousClass1.this.cancel(false);
                }
            }

            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                this.val$cancellationSignal.setOnCancelListener(new C00211());
            }

            /* INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Bitmap doInBackground(Uri... uriArr) {
                try {
                    return PrintHelper.this.loadConstrainedBitmap(PrintUriAdapter.this.mImageFile);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }

            /* INFO: Access modifiers changed from: protected */
            /* WARN: Code duplicated, block: B:19:0x0046  */
            @Override // android.os.AsyncTask
            public void onPostExecute(Bitmap bitmap) {
                Bitmap bitmapCreateBitmap;
                PrintAttributes.MediaSize mediaSize;
                super.onPostExecute(bitmap);
                if (bitmap == null || (PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION && PrintHelper.this.mOrientation != 0)) {
                    bitmapCreateBitmap = bitmap;
                } else {
                    synchronized (this) {
                        mediaSize = PrintUriAdapter.this.mAttributes.getMediaSize();
                    }
                    if (mediaSize == null || mediaSize.isPortrait() == PrintHelper.isPortrait(bitmap)) {
                        bitmapCreateBitmap = bitmap;
                    } else {
                        Matrix matrix = new Matrix();
                        matrix.postRotate(90.0f);
                        bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    }
                }
                PrintUriAdapter.this.mBitmap = bitmapCreateBitmap;
                if (bitmapCreateBitmap != null) {
                    this.val$layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(PrintUriAdapter.this.mJobName).setContentType(1).setPageCount(1).build(), true ^ this.val$newPrintAttributes.equals(this.val$oldPrintAttributes));
                } else {
                    this.val$layoutResultCallback.onLayoutFailed(null);
                }
                PrintUriAdapter.this.mLoadBitmap = null;
            }

            /* INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onCancelled(Bitmap bitmap) {
                this.val$layoutResultCallback.onLayoutCancelled();
                PrintUriAdapter.this.mLoadBitmap = null;
            }
        }

        void cancelLoad() {
            synchronized (PrintHelper.this.mLock) {
                if (PrintHelper.this.mDecodeOptions != null) {
                    PrintHelper.this.mDecodeOptions = null;
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            cancelLoad();
            AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.mLoadBitmap;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.mBitmap = null;
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static boolean isPortrait(Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    private static PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (printAttributes.getDuplexMode() != 0) {
            minMargins.setDuplexMode(printAttributes.getDuplexMode());
        }
        return minMargins;
    }

    static Matrix getMatrix(int i, int i2, RectF rectF, int i3) {
        float fMin;
        Matrix matrix = new Matrix();
        float f = i;
        float fWidth = rectF.width() / f;
        if (i3 == 2) {
            fMin = Math.max(fWidth, rectF.height() / i2);
        } else {
            fMin = Math.min(fWidth, rectF.height() / i2);
        }
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((rectF.width() - (f * fMin)) / 2.0f, (rectF.height() - (i2 * fMin)) / 2.0f);
        return matrix;
    }

    void writeBitmap(PrintAttributes printAttributes, int i, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        new AnonymousClass1(cancellationSignal, IS_MIN_MARGINS_HANDLING_CORRECT ? printAttributes : copyAttributes(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build(), bitmap, printAttributes, i, parcelFileDescriptor, writeResultCallback).execute(new Void[0]);
    }

    /* INFO: renamed from: androidx.print.PrintHelper$1, reason: invalid class name */
    class AnonymousClass1 extends AsyncTask<Void, Void, Throwable> {
        final /* synthetic */ PrintAttributes val$attributes;
        final /* synthetic */ Bitmap val$bitmap;
        final /* synthetic */ CancellationSignal val$cancellationSignal;
        final /* synthetic */ ParcelFileDescriptor val$fileDescriptor;
        final /* synthetic */ int val$fittingMode;
        final /* synthetic */ PrintAttributes val$pdfAttributes;
        final /* synthetic */ PrintDocumentAdapter.WriteResultCallback val$writeResultCallback;

        AnonymousClass1(CancellationSignal cancellationSignal, PrintAttributes printAttributes, Bitmap bitmap, PrintAttributes printAttributes2, int i, ParcelFileDescriptor parcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            this.val$cancellationSignal = cancellationSignal;
            this.val$pdfAttributes = printAttributes;
            this.val$bitmap = bitmap;
            this.val$attributes = printAttributes2;
            this.val$fittingMode = i;
            this.val$fileDescriptor = parcelFileDescriptor;
            this.val$writeResultCallback = writeResultCallback;
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Throwable doInBackground(Void... voidArr) {
            RectF rectF;
            try {
                if (this.val$cancellationSignal.isCanceled()) {
                    return null;
                }
                PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(PrintHelper.this.mContext, this.val$pdfAttributes);
                Bitmap bitmapConvertBitmapForColorMode = PrintHelper.convertBitmapForColorMode(this.val$bitmap, this.val$pdfAttributes.getColorMode());
                if (this.val$cancellationSignal.isCanceled()) {
                    return null;
                }
                try {
                    PdfDocument.Page pageStartPage = printedPdfDocument.startPage(1);
                    if (PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT) {
                        rectF = new RectF(pageStartPage.getInfo().getContentRect());
                    } else {
                        PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(PrintHelper.this.mContext, this.val$attributes);
                        PdfDocument.Page pageStartPage2 = printedPdfDocument2.startPage(1);
                        RectF rectF2 = new RectF(pageStartPage2.getInfo().getContentRect());
                        printedPdfDocument2.finishPage(pageStartPage2);
                        printedPdfDocument2.close();
                        rectF = rectF2;
                    }
                    Matrix matrix = PrintHelper.getMatrix(bitmapConvertBitmapForColorMode.getWidth(), bitmapConvertBitmapForColorMode.getHeight(), rectF, this.val$fittingMode);
                    if (!PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT) {
                        matrix.postTranslate(rectF.left, rectF.top);
                        pageStartPage.getCanvas().clipRect(rectF);
                    }
                    pageStartPage.getCanvas().drawBitmap(bitmapConvertBitmapForColorMode, matrix, null);
                    printedPdfDocument.finishPage(pageStartPage);
                    if (this.val$cancellationSignal.isCanceled()) {
                        return null;
                    }
                    printedPdfDocument.writeTo(new FileOutputStream(this.val$fileDescriptor.getFileDescriptor()));
                    return null;
                } finally {
                    printedPdfDocument.close();
                    ParcelFileDescriptor parcelFileDescriptor = this.val$fileDescriptor;
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (bitmapConvertBitmapForColorMode != this.val$bitmap) {
                        bitmapConvertBitmapForColorMode.recycle();
                    }
                }
            } catch (Throwable th) {
                return th;
            }
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Throwable th) {
            if (this.val$cancellationSignal.isCanceled()) {
                this.val$writeResultCallback.onWriteCancelled();
            } else if (th == null) {
                this.val$writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
            } else {
                Log.e(PrintHelper.LOG_TAG, "Error writing printed content", th);
                this.val$writeResultCallback.onWriteFailed(null);
            }
        }
    }

    Bitmap loadConstrainedBitmap(Uri uri) throws Throwable {
        BitmapFactory.Options options;
        if (uri == null || this.mContext == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        loadBitmap(uri, options2);
        int i = options2.outWidth;
        int i2 = options2.outHeight;
        if (i > 0 && i2 > 0) {
            int iMax = Math.max(i, i2);
            int i3 = 1;
            while (iMax > MAX_PRINT_SIZE) {
                iMax >>>= 1;
                i3 <<= 1;
            }
            if (i3 > 0 && Math.min(i, i2) / i3 > 0) {
                synchronized (this.mLock) {
                    BitmapFactory.Options options3 = new BitmapFactory.Options();
                    this.mDecodeOptions = options3;
                    options3.inMutable = true;
                    this.mDecodeOptions.inSampleSize = i3;
                    options = this.mDecodeOptions;
                }
                try {
                    Bitmap bitmapLoadBitmap = loadBitmap(uri, options);
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                    }
                    return bitmapLoadBitmap;
                } catch (Throwable th) {
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    private Bitmap loadBitmap(Uri uri, BitmapFactory.Options options) throws Throwable {
        Context context;
        if (uri == null || (context = this.mContext) == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                        return bitmapDecodeStream;
                    } catch (IOException e) {
                        Log.w(LOG_TAG, "close fail ", e);
                    }
                }
                return bitmapDecodeStream;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        Log.w(LOG_TAG, "close fail ", e2);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static Bitmap convertBitmapForColorMode(Bitmap bitmap, int i) {
        if (i != 1) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }
}
