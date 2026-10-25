package com.google.api.client.googleapis.notifications;

import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public interface UnparsedNotificationCallback extends Serializable {
    void onNotification(StoredChannel storedChannel, UnparsedNotification unparsedNotification) throws IOException;
}
