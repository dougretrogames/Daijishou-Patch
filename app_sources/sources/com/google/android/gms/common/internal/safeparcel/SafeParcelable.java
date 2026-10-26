package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;

/* INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* INFO: loaded from: classes3.dex */
public interface SafeParcelable extends Parcelable {
    public static final String NULL = "SAFE_PARCELABLE_NULL_STRING";

    /* INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public @interface Class {
        String creator();

        boolean creatorIsFinal() default true;

        boolean doNotParcelTypeDefaultValues() default false;

        boolean validate() default false;
    }

    /* INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public @interface Constructor {
    }

    /* INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public @interface Field {
        String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";

        String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";

        String getter() default "SAFE_PARCELABLE_NULL_STRING";

        int id();

        String type() default "SAFE_PARCELABLE_NULL_STRING";
    }

    /* INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public @interface Indicator {
        String getter() default "SAFE_PARCELABLE_NULL_STRING";
    }

    /* INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public @interface Param {
        int id();
    }

    /* INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public @interface RemovedParam {
        String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";

        String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";

        int id();
    }

    /* INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public @interface Reserved {
        int[] value();
    }

    /* INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public @interface VersionField {
        String getter() default "SAFE_PARCELABLE_NULL_STRING";

        int id();

        String type() default "SAFE_PARCELABLE_NULL_STRING";
    }
}
