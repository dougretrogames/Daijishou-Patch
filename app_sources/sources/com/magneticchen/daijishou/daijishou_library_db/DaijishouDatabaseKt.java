package com.magneticchen.daijishou.daijishou_library_db;

import androidx.room.migration.Migration;
import kotlin.Metadata;

/* INFO: compiled from: DaijishouDatabase.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0003\"\u0011\u0010\u0010\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0003\"\u0011\u0010\u0012\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0003\"\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0003\"\u0011\u0010\u0016\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0003\"\u0011\u0010\u0018\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0003\"\u0011\u0010\u001a\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0003\"\u0011\u0010\u001c\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0003\"\u0011\u0010\u001e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0003\"\u0011\u0010 \u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0003¨\u0006\""}, d2 = {"MIGRATION_10_11", "Landroidx/room/migration/Migration;", "getMIGRATION_10_11", "()Landroidx/room/migration/Migration;", "MIGRATION_11_12", "getMIGRATION_11_12", "MIGRATION_12_13", "getMIGRATION_12_13", "MIGRATION_13_14", "getMIGRATION_13_14", "MIGRATION_14_15", "getMIGRATION_14_15", "MIGRATION_15_16", "getMIGRATION_15_16", "MIGRATION_16_17", "getMIGRATION_16_17", "MIGRATION_1_2", "getMIGRATION_1_2", "MIGRATION_2_3", "getMIGRATION_2_3", "MIGRATION_3_4", "getMIGRATION_3_4", "MIGRATION_4_5", "getMIGRATION_4_5", "MIGRATION_5_6", "getMIGRATION_5_6", "MIGRATION_6_7", "getMIGRATION_6_7", "MIGRATION_7_8", "getMIGRATION_7_8", "MIGRATION_8_9", "getMIGRATION_8_9", "MIGRATION_9_10", "getMIGRATION_9_10", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DaijishouDatabaseKt {
    private static final Migration MIGRATION_1_2 = new DaijishouDatabaseKt$MIGRATION_1_2$1();
    private static final Migration MIGRATION_2_3 = new DaijishouDatabaseKt$MIGRATION_2_3$1();
    private static final Migration MIGRATION_3_4 = new DaijishouDatabaseKt$MIGRATION_3_4$1();
    private static final Migration MIGRATION_4_5 = new DaijishouDatabaseKt$MIGRATION_4_5$1();
    private static final Migration MIGRATION_5_6 = new DaijishouDatabaseKt$MIGRATION_5_6$1();
    private static final Migration MIGRATION_6_7 = new DaijishouDatabaseKt$MIGRATION_6_7$1();
    private static final Migration MIGRATION_7_8 = new DaijishouDatabaseKt$MIGRATION_7_8$1();
    private static final Migration MIGRATION_8_9 = new DaijishouDatabaseKt$MIGRATION_8_9$1();
    private static final Migration MIGRATION_9_10 = new DaijishouDatabaseKt$MIGRATION_9_10$1();
    private static final Migration MIGRATION_10_11 = new DaijishouDatabaseKt$MIGRATION_10_11$1();
    private static final Migration MIGRATION_11_12 = new DaijishouDatabaseKt$MIGRATION_11_12$1();
    private static final Migration MIGRATION_12_13 = new DaijishouDatabaseKt$MIGRATION_12_13$1();
    private static final Migration MIGRATION_13_14 = new DaijishouDatabaseKt$MIGRATION_13_14$1();
    private static final Migration MIGRATION_14_15 = new DaijishouDatabaseKt$MIGRATION_14_15$1();
    private static final Migration MIGRATION_15_16 = new DaijishouDatabaseKt$MIGRATION_15_16$1();
    private static final Migration MIGRATION_16_17 = new DaijishouDatabaseKt$MIGRATION_16_17$1();

    public static final Migration getMIGRATION_1_2() {
        return MIGRATION_1_2;
    }

    public static final Migration getMIGRATION_2_3() {
        return MIGRATION_2_3;
    }

    public static final Migration getMIGRATION_3_4() {
        return MIGRATION_3_4;
    }

    public static final Migration getMIGRATION_4_5() {
        return MIGRATION_4_5;
    }

    public static final Migration getMIGRATION_5_6() {
        return MIGRATION_5_6;
    }

    public static final Migration getMIGRATION_6_7() {
        return MIGRATION_6_7;
    }

    public static final Migration getMIGRATION_7_8() {
        return MIGRATION_7_8;
    }

    public static final Migration getMIGRATION_8_9() {
        return MIGRATION_8_9;
    }

    public static final Migration getMIGRATION_9_10() {
        return MIGRATION_9_10;
    }

    public static final Migration getMIGRATION_10_11() {
        return MIGRATION_10_11;
    }

    public static final Migration getMIGRATION_11_12() {
        return MIGRATION_11_12;
    }

    public static final Migration getMIGRATION_12_13() {
        return MIGRATION_12_13;
    }

    public static final Migration getMIGRATION_13_14() {
        return MIGRATION_13_14;
    }

    public static final Migration getMIGRATION_14_15() {
        return MIGRATION_14_15;
    }

    public static final Migration getMIGRATION_15_16() {
        return MIGRATION_15_16;
    }

    public static final Migration getMIGRATION_16_17() {
        return MIGRATION_16_17;
    }
}
