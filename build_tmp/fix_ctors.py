# 1. DaijishouDebugService.java
p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/service/debug/DaijishouDebugService.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()
c = c.replace('final class C02101 extends Lambda<Unit> implements Function0<Unit> {\n        C02101() \n\n        @Override',
              'final class C02101 extends Lambda<Unit> implements Function0<Unit> {\n        C02101() { super(0); }\n\n        @Override')
c = c.replace('C02101() \n', 'C02101() { super(0); }\n')
with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

# 2. MainActivity.java
p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/activities/MainActivity.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()
c = c.replace('C00931() \n', 'C00931() { super(1); }\n')
c = c.replace('C01011() \n', 'C01011() { super(1); }\n')
with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

# 3. WidgetsManager.java
p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/widget/WidgetsManager.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()
c = c.replace('C02121() \n', 'C02121() { super(2); }\n')
with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed 4 constructors!')
