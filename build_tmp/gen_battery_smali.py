import subprocess, os, zipfile

javac = r'C:\Program Files\Eclipse Adoptium\jdk-21.0.12.101-hotspot\bin\javac.exe'
android = os.path.expandvars(r'%LOCALAPPDATA%\Android\Sdk\platforms\android-35\android.jar')
d8 = os.path.expandvars(r'%LOCALAPPDATA%\Android\Sdk\build-tools\35.0.0\d8.bat')

out_dir = 'build_tmp/bat_classes'
os.makedirs(out_dir, exist_ok=True)

bat_src = """package com.magneticchen.daijishou.data.live;

public final class BatteryInfo {
    private int status = -1;
    private int health = -1;
    private boolean plugged = false;
    private int level = -1;
    private int scale = -1;
    private int temperature = -1;
    private int voltage = -1;

    public final int getStatus() { return this.status; }
    public final void setStatus(int i) { this.status = i; }
    public final int getHealth() { return this.health; }
    public final void setHealth(int i) { this.health = i; }
    public final boolean getPlugged() { return this.plugged; }
    public final void setPlugged(boolean z) { this.plugged = z; }
    public final int getLevel() { return this.level; }
    public final void setLevel(int i) { this.level = i; }
    public final int getScale() { return this.scale; }
    public final void setScale(int i) { this.scale = i; }
    public final int getTemperature() { return this.temperature; }
    public final void setTemperature(int i) { this.temperature = i; }
    public final int getVoltage() { return this.voltage; }
    public final void setVoltage(int i) { this.voltage = i; }

    public final int getPercent() {
        if (this.scale <= 0) {
            return this.level > 0 ? this.level : 0;
        }
        if (this.level < 0) {
            return 0;
        }
        return Math.min(100, Math.max(0, Math.round(((float) this.level / (float) this.scale) * 100.0f)));
    }

    public String toString() {
        return "BatteryInfo{status=" + this.status + ", health=" + this.health + ", plugged=" + this.plugged + ", level=" + this.level + ", scale=" + this.scale + ", percent=" + getPercent() + ", temperature=" + this.temperature + ", voltage=" + this.voltage + "}";
    }
}
"""
with open('build_tmp/BatteryInfo.java', 'w', encoding='utf-8') as f:
    f.write(bat_src)

res_javac = subprocess.run([javac, '-source', '8', '-target', '8', '-bootclasspath', android, '-d', out_dir, 'build_tmp/BatteryInfo.java'], capture_output=True, text=True)
print('javac:', res_javac.returncode, res_javac.stderr)

out_dex = 'build_tmp/bat_dex'
os.makedirs(out_dex, exist_ok=True)
res_d8 = subprocess.run([d8, '--release', '--output', out_dex, '--min-api', '26', os.path.join(out_dir, 'com/magneticchen/daijishou/data/live/BatteryInfo.class')], capture_output=True, text=True)
print('d8:', res_d8.returncode, res_d8.stderr)

with zipfile.ZipFile('build_tmp/bat_dummy.apk', 'w') as z:
    z.write(os.path.join(out_dex, 'classes.dex'), 'classes.dex')

res_apktool = subprocess.run(['java', '-jar', 'tools/apktool_3.0.3.jar', 'd', 'build_tmp/bat_dummy.apk', '-o', 'build_tmp/bat_smali', '-f', '-r'], capture_output=True, text=True)
print('apktool d:', res_apktool.returncode)
