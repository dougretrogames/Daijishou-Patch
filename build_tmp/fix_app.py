p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/DaijishouApplication.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

# 1. Fix inner anonymous classes references
c = c.replace('return new Soundboard(this.this$0);', 'return new Soundboard(DaijishouApplication.this);')
c = c.replace('this.this$0.connectionType = i;', 'DaijishouApplication.this.connectionType = i;')
c = c.replace('DaijishouApplication.lifecycleEventObserver$lambda$4(this.f$0, lifecycleOwner, event);', 'DaijishouApplication.lifecycleEventObserver$lambda$4(DaijishouApplication.this, lifecycleOwner, event);')

# 2. Fix writeToFile and readFromFile
start_target = '    private final void writeToFile(String str, String str2) {'
end_target = '    /* JADX INFO: compiled from: DaijishouApplication.kt */\n    @Metadata(d1 = {"\\u0000B\\n\\u0002\\u0018\\u0002'

idx1 = c.find(start_target)
idx2 = c.find(end_target)
assert idx1 != -1 and idx2 != -1, f"idx1={idx1}, idx2={idx2}"

clean_io = '''    private final void writeToFile(String filename, String data) {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        try {
            java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(applicationContext.openFileOutput(filename, 0));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (java.io.IOException e) {
            this.logger.error(this, "File write failed: " + e);
        }
    }

    private final String readFromFile(String filename) {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        try {
            java.io.FileInputStream fileInputStreamOpenFileInput = applicationContext.openFileInput(filename);
            Intrinsics.checkNotNullExpressionValue(fileInputStreamOpenFileInput, "openFileInput(...)");
            java.io.FileInputStream fileInputStream = fileInputStreamOpenFileInput;
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream));
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("\\n");
                    }
                    sb.append(line);
                } else {
                    fileInputStream.close();
                    String string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    return string;
                }
            }
        } catch (java.io.FileNotFoundException e) {
            this.logger.error(this, "File not found: " + e);
            return "";
        } catch (java.io.IOException e2) {
            this.logger.error(this, "File read failed: " + e2);
            return "";
        }
    }

'''

c = c[:idx1] + clean_io + c[idx2:]

# 3. Fix 0 == true ? 1 : 0 in repo inits
c = c.replace(
    'setDaijishouWidgetRepository(new DaijishouWidgetRepository(daijishouApplication, null, i, 0 == true ? 1 : 0));',
    'setDaijishouWidgetRepository(new DaijishouWidgetRepository(daijishouApplication, null, 2, null));'
)
c = c.replace(
    'setRetroAchievementsRepository(new RetroAchievementsRepository(daijishouApplication, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0));',
    'setRetroAchievementsRepository(new RetroAchievementsRepository(daijishouApplication, null, 2, null));'
)

# 4. Fix Iterator<T>
c = c.replace('Iterator<T> it = list2.iterator();', 'Iterator<PlatformEntity> it = list2.iterator();')

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed DaijishouApplication.java successfully')
