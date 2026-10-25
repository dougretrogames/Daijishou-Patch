package com.google.api.client.googleapis.notifications;

import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class NotificationUtils {
    public static String randomUuidString() {
        return UUID.randomUUID().toString();
    }

    private NotificationUtils() {
    }
}
