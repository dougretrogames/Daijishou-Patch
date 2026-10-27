p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

# 1. Fix themes listOf
c = c.replace(
    'this.themes = CollectionsKt.listOf((Object[]) new Integer[]{',
    'this.themes = java.util.Arrays.asList(new Integer[]{'
)

# 2. Fix changeDarkModeListener this.f$0
c = c.replace(
    'DaijishouAppCompatActivity.changeDarkModeListener$lambda$0(this.f$0, sharedPreferences, str);',
    'DaijishouAppCompatActivity.changeDarkModeListener$lambda$0(DaijishouAppCompatActivity.this, sharedPreferences, str);'
)

# 3. Fix this.this$0 -> DaijishouAppCompatActivity.this
c = c.replace(
    'Application application = this.this$0.getApplication();',
    'Application application = DaijishouAppCompatActivity.this.getApplication();'
)

# 4. Fix this.themes, this.setTheme, this.recreate inside lambda
c = c.replace(
    'iIntValue2 = ((Number) this.themes.get(iIndexOf2)).intValue();',
    'iIntValue2 = ((Number) DaijishouAppCompatActivity.this.themes.get(iIndexOf2)).intValue();'
)
c = c.replace(
    'this.setTheme(iIntValue2);',
    'DaijishouAppCompatActivity.this.setTheme(iIntValue2);'
)
c = c.replace(
    'this.recreate();',
    'DaijishouAppCompatActivity.this.recreate();'
)

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed DaijishouAppCompatActivity.java successfully')
