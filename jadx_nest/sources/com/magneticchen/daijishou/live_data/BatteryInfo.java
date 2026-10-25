package com.magneticchen.daijishou.live_data;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: BatteryLiveData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/magneticchen/daijishou/live_data/BatteryInfo;", "", "()V", "health", "", "level", "plugged", "", "scale", NotificationCompat.CATEGORY_STATUS, "temperature", "voltage", "getHealth", "getLevel", "getPercent", "getPlugged", "getScale", "getStatus", "getTemperature", "getVoltage", "setHealth", "", "setLevel", "setPlugged", "setScale", "setStatus", "setTemperature", "setVoltage", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BatteryInfo {
    private int health;
    private int level;
    private boolean plugged;
    private int scale;
    private int status;
    private int temperature;
    private int voltage;

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int status) {
        this.status = status;
    }

    public final int getHealth() {
        return this.health;
    }

    public final void setHealth(int health) {
        this.health = health;
    }

    public final boolean getPlugged() {
        return this.plugged;
    }

    public final void setPlugged(boolean plugged) {
        this.plugged = plugged;
    }

    public final int getLevel() {
        return this.level;
    }

    public final void setLevel(int level) {
        this.level = level;
    }

    public final int getTemperature() {
        return this.temperature;
    }

    public final void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public final int getScale() {
        return this.scale;
    }

    public final void setScale(int scale) {
        this.scale = scale;
    }

    public final int getVoltage() {
        return this.voltage;
    }

    public final void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public final int getPercent() {
        return (int) ((this.level / this.scale) * 100);
    }

    public String toString() {
        return "BatteryInfo{status=" + this.status + ", health=" + this.health + ", plugged=" + this.plugged + ", level=" + this.level + ", scale=" + this.scale + ", percent=" + getPercent() + ", temperature=" + this.temperature + ", voltage=" + this.voltage + "}";
    }
}
