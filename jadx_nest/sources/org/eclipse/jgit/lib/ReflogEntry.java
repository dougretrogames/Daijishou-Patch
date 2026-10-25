package org.eclipse.jgit.lib;

/* JADX INFO: loaded from: classes5.dex */
public interface ReflogEntry {
    public static final String PREFIX_CREATED = "created";
    public static final String PREFIX_FAST_FORWARD = "fast-forward";
    public static final String PREFIX_FORCED_UPDATE = "forced-update";

    String getComment();

    ObjectId getNewId();

    ObjectId getOldId();

    PersonIdent getWho();

    CheckoutEntry parseCheckout();
}
