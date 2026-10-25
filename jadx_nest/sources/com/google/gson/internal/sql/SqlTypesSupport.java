package com.google.gson.internal.sql;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public final class SqlTypesSupport {
    public static final DefaultDateTypeAdapter.DateType<? extends Date> DATE_DATE_TYPE;
    public static final TypeAdapterFactory DATE_FACTORY;
    public static final boolean SUPPORTS_SQL_TYPES;
    public static final DefaultDateTypeAdapter.DateType<? extends Date> TIMESTAMP_DATE_TYPE;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapterFactory TIME_FACTORY;

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        SUPPORTS_SQL_TYPES = z;
        if (z) {
            DATE_DATE_TYPE = new AnonymousClass1(java.sql.Date.class);
            TIMESTAMP_DATE_TYPE = new AnonymousClass2(Timestamp.class);
            DATE_FACTORY = SqlDateTypeAdapter.FACTORY;
            TIME_FACTORY = SqlTimeTypeAdapter.FACTORY;
            TIMESTAMP_FACTORY = SqlTimestampTypeAdapter.FACTORY;
            return;
        }
        DATE_DATE_TYPE = null;
        TIMESTAMP_DATE_TYPE = null;
        DATE_FACTORY = null;
        TIME_FACTORY = null;
        TIMESTAMP_FACTORY = null;
    }

    /* JADX INFO: renamed from: com.google.gson.internal.sql.SqlTypesSupport$1, reason: invalid class name */
    class AnonymousClass1 extends DefaultDateTypeAdapter.DateType<java.sql.Date> {
        AnonymousClass1(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
        public java.sql.Date deserialize(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.sql.SqlTypesSupport$2, reason: invalid class name */
    class AnonymousClass2 extends DefaultDateTypeAdapter.DateType<Timestamp> {
        AnonymousClass2(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
        public Timestamp deserialize(Date date) {
            return new Timestamp(date.getTime());
        }
    }

    private SqlTypesSupport() {
    }
}
