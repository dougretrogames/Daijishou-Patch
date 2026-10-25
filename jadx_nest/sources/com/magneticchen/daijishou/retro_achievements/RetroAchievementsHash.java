package com.magneticchen.daijishou.retro_achievements;

import com.magneticchen.daijishou.DaijishouApplication;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetroAchievementsHash.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0007\u001a\u00060\bR\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsHash;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "systemIdToHash", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getSystemIdToHash", "()Ljava/util/HashMap;", "hash3DO", "", "hashArcade", "hashArduboy", "hashAtari7800", "hashAtariJaguarCD", "hashAtariLynx", "hashFamicomDiskSystem", "hashMSXMSX2", "hashMd5OfEachDisk", "hashPCEngineCDTurboGrafxCD", "hashPCEngineTurboGrafx16SuperGrafx", "hashPCFX", "md5", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsHash {
    private final DaijishouApplication application;
    private final DaijishouApplication.WrappedLogger logger;
    private final HashMap<Integer, String> systemIdToHash;

    public final void hash3DO() {
    }

    public final void hashArcade() {
    }

    public final void hashArduboy() {
    }

    public final void hashAtari7800() {
    }

    public final void hashAtariJaguarCD() {
    }

    public final void hashAtariLynx() {
    }

    public final void hashFamicomDiskSystem() {
    }

    public final void hashMSXMSX2() {
    }

    public final void hashMd5OfEachDisk() {
    }

    public final void hashPCEngineCDTurboGrafxCD() {
    }

    public final void hashPCEngineTurboGrafx16SuperGrafx() {
    }

    public final void hashPCFX() {
    }

    public final void md5() {
    }

    public RetroAchievementsHash(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.logger = application.getLogger();
        this.systemIdToHash = MapsKt.hashMapOf(TuplesKt.to(1, "hashMd5OfEachDisk"));
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final DaijishouApplication.WrappedLogger getLogger() {
        return this.logger;
    }

    public final HashMap<Integer, String> getSystemIdToHash() {
        return this.systemIdToHash;
    }
}
