p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/activities/MainActivity.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

c = c.replace('return MainActivity.C00931.invoke$lambda$0(c00071, obj);', 'return ((Boolean) c00071.invoke((ViewPagerFragment) obj)).booleanValue();')
c = c.replace('return MainActivity.C01011.invoke$lambda$0(c00081, obj);', 'return ((Boolean) c00081.invoke((ViewPagerFragment) obj)).booleanValue();')

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('MainActivity 100% clean!')
