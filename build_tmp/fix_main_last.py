p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/activities/MainActivity.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

c = c.replace('final C00071 c00071 = new Function1<ViewPagerFragment, Boolean>()', 'final Function1<ViewPagerFragment, Boolean> c00071 = new Function1<ViewPagerFragment, Boolean>()')
c = c.replace('final C00081 c00081 = new Function1<ViewPagerFragment, Boolean>()', 'final Function1<ViewPagerFragment, Boolean> c00081 = new Function1<ViewPagerFragment, Boolean>()')
c = c.replace(
    'public static final boolean invoke$lambda$0(Function1 tmp0, Object obj) {',
    'public final boolean invoke$lambda$0(Function1 tmp0, Object obj) {'
)

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed last 4 errors in MainActivity.java')
