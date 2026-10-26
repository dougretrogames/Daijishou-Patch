package com.bumptech.glide.load;

import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* INFO: loaded from: classes3.dex */
public final class ImageHeaderParserUtils {
    private static final int MARK_READ_LIMIT = 5242880;

    private interface JpegMpfReader {
        boolean getHasJpegMpfAndRewind(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private interface OrientationReader {
        int getOrientationAndRewind(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private interface TypeReader {
        ImageHeaderParser.ImageType getTypeAndRewind(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private ImageHeaderParserUtils() {
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_READ_LIMIT);
        return getTypeInternal(list, new AnonymousClass1(inputStream));
    }

    /* INFO: renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$1, reason: invalid class name */
    class AnonymousClass1 implements TypeReader {
        final /* synthetic */ InputStream val$finalIs;

        AnonymousClass1(InputStream inputStream) {
            this.val$finalIs = inputStream;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
        public ImageHeaderParser.ImageType getTypeAndRewind(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.getType(this.val$finalIs);
            } finally {
                this.val$finalIs.reset();
            }
        }
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return getTypeInternal(list, new AnonymousClass2(byteBuffer));
    }

    /* INFO: renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$2, reason: invalid class name */
    class AnonymousClass2 implements TypeReader {
        final /* synthetic */ ByteBuffer val$buffer;

        AnonymousClass2(ByteBuffer byteBuffer) {
            this.val$buffer = byteBuffer;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
        public ImageHeaderParser.ImageType getTypeAndRewind(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.getType(this.val$buffer);
            } finally {
                ByteBufferUtil.rewind(this.val$buffer);
            }
        }
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ArrayPool arrayPool) throws IOException {
        return getTypeInternal(list, new AnonymousClass3(parcelFileDescriptorRewinder, arrayPool));
    }

    /* INFO: renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$3, reason: invalid class name */
    class AnonymousClass3 implements TypeReader {
        final /* synthetic */ ArrayPool val$byteArrayPool;
        final /* synthetic */ ParcelFileDescriptorRewinder val$parcelFileDescriptorRewinder;

        AnonymousClass3(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ArrayPool arrayPool) {
            this.val$parcelFileDescriptorRewinder = parcelFileDescriptorRewinder;
            this.val$byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
        public ImageHeaderParser.ImageType getTypeAndRewind(ImageHeaderParser imageHeaderParser) throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.val$parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), this.val$byteArrayPool);
                try {
                    ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream2);
                    recyclableBufferedInputStream2.release();
                    this.val$parcelFileDescriptorRewinder.rewindAndGet();
                    return type;
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        recyclableBufferedInputStream.release();
                    }
                    this.val$parcelFileDescriptorRewinder.rewindAndGet();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static ImageHeaderParser.ImageType getTypeInternal(List<ImageHeaderParser> list, TypeReader typeReader) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType typeAndRewind = typeReader.getTypeAndRewind(list.get(i));
            if (typeAndRewind != ImageHeaderParser.ImageType.UNKNOWN) {
                return typeAndRewind;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static int getOrientation(List<ImageHeaderParser> list, ByteBuffer byteBuffer, ArrayPool arrayPool) throws IOException {
        if (byteBuffer == null) {
            return -1;
        }
        return getOrientationInternal(list, new AnonymousClass4(byteBuffer, arrayPool));
    }

    /* INFO: renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$4, reason: invalid class name */
    class AnonymousClass4 implements OrientationReader {
        final /* synthetic */ ArrayPool val$arrayPool;
        final /* synthetic */ ByteBuffer val$buffer;

        AnonymousClass4(ByteBuffer byteBuffer, ArrayPool arrayPool) {
            this.val$buffer = byteBuffer;
            this.val$arrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
        public int getOrientationAndRewind(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.getOrientation(this.val$buffer, this.val$arrayPool);
            } finally {
                ByteBufferUtil.rewind(this.val$buffer);
            }
        }
    }

    public static int getOrientation(List<ImageHeaderParser> list, InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_READ_LIMIT);
        return getOrientationInternal(list, new AnonymousClass5(inputStream, arrayPool));
    }

    /* INFO: renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$5, reason: invalid class name */
    class AnonymousClass5 implements OrientationReader {
        final /* synthetic */ ArrayPool val$byteArrayPool;
        final /* synthetic */ InputStream val$finalIs;

        AnonymousClass5(InputStream inputStream, ArrayPool arrayPool) {
            this.val$finalIs = inputStream;
            this.val$byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
        public int getOrientationAndRewind(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.getOrientation(this.val$finalIs, this.val$byteArrayPool);
            } finally {
                this.val$finalIs.reset();
            }
        }
    }

    public static int getOrientation(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ArrayPool arrayPool) throws IOException {
        return getOrientationInternal(list, new AnonymousClass6(parcelFileDescriptorRewinder, arrayPool));
    }

    /* INFO: renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$6, reason: invalid class name */
    class AnonymousClass6 implements OrientationReader {
        final /* synthetic */ ArrayPool val$byteArrayPool;
        final /* synthetic */ ParcelFileDescriptorRewinder val$parcelFileDescriptorRewinder;

        AnonymousClass6(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ArrayPool arrayPool) {
            this.val$parcelFileDescriptorRewinder = parcelFileDescriptorRewinder;
            this.val$byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
        public int getOrientationAndRewind(ImageHeaderParser imageHeaderParser) throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.val$parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), this.val$byteArrayPool);
                try {
                    int orientation = imageHeaderParser.getOrientation(recyclableBufferedInputStream2, this.val$byteArrayPool);
                    recyclableBufferedInputStream2.release();
                    this.val$parcelFileDescriptorRewinder.rewindAndGet();
                    return orientation;
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        recyclableBufferedInputStream.release();
                    }
                    this.val$parcelFileDescriptorRewinder.rewindAndGet();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static int getOrientationInternal(List<ImageHeaderParser> list, OrientationReader orientationReader) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int orientationAndRewind = orientationReader.getOrientationAndRewind(list.get(i));
            if (orientationAndRewind != -1) {
                return orientationAndRewind;
            }
        }
        return -1;
    }

    public static boolean hasJpegMpf(List<ImageHeaderParser> list, ByteBuffer byteBuffer, ArrayPool arrayPool) throws IOException {
        if (byteBuffer == null) {
            return false;
        }
        return hasJpegMpfInternal(list, new AnonymousClass7(byteBuffer, arrayPool));
    }

    /* INFO: renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$7, reason: invalid class name */
    class AnonymousClass7 implements JpegMpfReader {
        final /* synthetic */ ByteBuffer val$buffer;
        final /* synthetic */ ArrayPool val$byteArrayPool;

        AnonymousClass7(ByteBuffer byteBuffer, ArrayPool arrayPool) {
            this.val$buffer = byteBuffer;
            this.val$byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.JpegMpfReader
        public boolean getHasJpegMpfAndRewind(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.hasJpegMpf(this.val$buffer, this.val$byteArrayPool);
            } finally {
                ByteBufferUtil.rewind(this.val$buffer);
            }
        }
    }

    public static boolean hasJpegMpf(List<ImageHeaderParser> list, InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return false;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_READ_LIMIT);
        return hasJpegMpfInternal(list, new AnonymousClass8(inputStream, arrayPool));
    }

    /* INFO: renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$8, reason: invalid class name */
    class AnonymousClass8 implements JpegMpfReader {
        final /* synthetic */ ArrayPool val$byteArrayPool;
        final /* synthetic */ InputStream val$finalIs;

        AnonymousClass8(InputStream inputStream, ArrayPool arrayPool) {
            this.val$finalIs = inputStream;
            this.val$byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.JpegMpfReader
        public boolean getHasJpegMpfAndRewind(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.hasJpegMpf(this.val$finalIs, this.val$byteArrayPool);
            } finally {
                this.val$finalIs.reset();
            }
        }
    }

    public static boolean hasJpegMpf(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ArrayPool arrayPool) throws IOException {
        return hasJpegMpfInternal(list, new AnonymousClass9(parcelFileDescriptorRewinder, arrayPool));
    }

    /* INFO: renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$9, reason: invalid class name */
    class AnonymousClass9 implements JpegMpfReader {
        final /* synthetic */ ArrayPool val$byteArrayPool;
        final /* synthetic */ ParcelFileDescriptorRewinder val$parcelFileDescriptorRewinder;

        AnonymousClass9(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ArrayPool arrayPool) {
            this.val$parcelFileDescriptorRewinder = parcelFileDescriptorRewinder;
            this.val$byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.JpegMpfReader
        public boolean getHasJpegMpfAndRewind(ImageHeaderParser imageHeaderParser) throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.val$parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), this.val$byteArrayPool);
                try {
                    boolean zHasJpegMpf = imageHeaderParser.hasJpegMpf(recyclableBufferedInputStream2, this.val$byteArrayPool);
                    recyclableBufferedInputStream2.release();
                    this.val$parcelFileDescriptorRewinder.rewindAndGet();
                    return zHasJpegMpf;
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        recyclableBufferedInputStream.release();
                    }
                    this.val$parcelFileDescriptorRewinder.rewindAndGet();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static boolean hasJpegMpfInternal(List<ImageHeaderParser> list, JpegMpfReader jpegMpfReader) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (jpegMpfReader.getHasJpegMpfAndRewind(list.get(i))) {
                return true;
            }
        }
        return false;
    }
}
