package org.eclipse.jgit.lib;

import java.util.zip.Inflater;

/* INFO: loaded from: classes5.dex */
public class InflaterCache {
    private static final int SZ = 4;
    private static final Inflater[] inflaterCache = new Inflater[4];
    private static int openInflaterCount;

    public static Inflater get() {
        Inflater impl = getImpl();
        return impl != null ? impl : new Inflater(false);
    }

    private static synchronized Inflater getImpl() {
        int i = openInflaterCount;
        if (i <= 0) {
            return null;
        }
        Inflater[] inflaterArr = inflaterCache;
        int i2 = i - 1;
        openInflaterCount = i2;
        Inflater inflater = inflaterArr[i2];
        inflaterArr[i2] = null;
        return inflater;
    }

    public static void release(Inflater inflater) {
        if (inflater != null) {
            inflater.reset();
            if (releaseImpl(inflater)) {
                inflater.end();
            }
        }
    }

    private static synchronized boolean releaseImpl(Inflater inflater) {
        int i = openInflaterCount;
        if (i >= 4) {
            return true;
        }
        Inflater[] inflaterArr = inflaterCache;
        openInflaterCount = i + 1;
        inflaterArr[i] = inflater;
        return false;
    }

    private InflaterCache() {
        throw new UnsupportedOperationException();
    }
}
