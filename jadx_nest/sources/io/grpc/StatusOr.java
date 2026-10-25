package io.grpc;

import androidx.core.app.NotificationCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class StatusOr<T> {
    private final Status status;
    private final T value;

    private StatusOr(Status status, T t) {
        this.status = status;
        this.value = t;
    }

    public static <T> StatusOr<T> fromValue(@Nullable T t) {
        return new StatusOr<>(null, t);
    }

    public static <T> StatusOr<T> fromStatus(Status status) {
        StatusOr<T> statusOr = new StatusOr<>((Status) Preconditions.checkNotNull(status, NotificationCompat.CATEGORY_STATUS), null);
        Preconditions.checkArgument(!status.isOk(), "cannot use OK status: %s", status);
        return statusOr;
    }

    public boolean hasValue() {
        return this.status == null;
    }

    @Nullable
    public T getValue() {
        if (this.status != null) {
            throw new IllegalStateException("No value present.");
        }
        return this.value;
    }

    public Status getStatus() {
        Status status = this.status;
        return status == null ? Status.OK : status;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StatusOr)) {
            return false;
        }
        StatusOr statusOr = (StatusOr) obj;
        if (hasValue() != statusOr.hasValue()) {
            return false;
        }
        if (hasValue()) {
            return Objects.equal(this.value, statusOr.value);
        }
        return Objects.equal(this.status, statusOr.status);
    }

    public int hashCode() {
        return Objects.hashCode(this.status, this.value);
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        Status status = this.status;
        if (status == null) {
            stringHelper.add("value", this.value);
        } else {
            stringHelper.add("error", status);
        }
        return stringHelper.toString();
    }
}
