p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/activities/MainActivity.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

# 1. Fix lazy loaders this.this$0
c = c.replace('return this.this$0.getViewPager();', 'return MainActivity.this.getViewPager();')
c = c.replace('MainActivity mainActivity = this.this$0;', 'MainActivity mainActivity = MainActivity.this;')
c = c.replace('FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();', 'FragmentManager supportFragmentManager = MainActivity.this.getSupportFragmentManager();')
c = c.replace('LeanbackTabLayout leanbackTabLayoutFindViewById = this.this$0.findViewById(R.id.tab_layout);', 'LeanbackTabLayout leanbackTabLayoutFindViewById = (LeanbackTabLayout) MainActivity.this.findViewById(R.id.tab_layout);')
c = c.replace('leanbackTabLayoutFindViewById.setupWithViewPager(this.this$0.getViewPager());', 'leanbackTabLayoutFindViewById.setupWithViewPager(MainActivity.this.getViewPager());')
c = c.replace('LeanbackViewPager leanbackViewPagerFindViewById = this.this$0.findViewById(R.id.main_view_pager);', 'LeanbackViewPager leanbackViewPagerFindViewById = (LeanbackViewPager) MainActivity.this.findViewById(R.id.main_view_pager);')
c = c.replace('Application application = this.this$0.getApplication();', 'Application application = MainActivity.this.getApplication();')

# 2. Fix fragments listOf
c = c.replace(
    'arrayList.addAll(CollectionsKt.listOf((Object[]) new ViewPagerFragment[]{platformsFragmentInstance, widgetsFragmentInstance, appsFragmentInstance, settingsFragmentInstance}));',
    'arrayList.addAll(java.util.Arrays.asList(new ViewPagerFragment[]{platformsFragmentInstance, widgetsFragmentInstance, appsFragmentInstance, settingsFragmentInstance}));'
)

# 3. Fix LayoutParams in viewPager
c = c.replace(
    'ConstraintLayout.LayoutParams layoutParams = view.getLayoutParams();',
    'ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();'
)
c = c.replace(
    'ConstraintLayout.LayoutParams layoutParams2 = (ViewGroup.LayoutParams) layoutParams;',
    'ConstraintLayout.LayoutParams layoutParams2 = layoutParams;'
)

# 4. Fix registerForActivityResult synthetic
c = c.replace('MainActivity._init_$lambda$0(this.f$0, (ActivityResult) obj);', 'MainActivity._init_$lambda$0(MainActivity.this, (ActivityResult) obj);')

# 5. Fix Result in onBackPressed
old_res = '''                        try {
                            Result.Companion companion = Result.Companion;
                            MainActivity mainActivity = this;
                            objM478constructorimpl = Result.m478constructorimpl(Boolean.valueOf(viewPagerFragment.onBackPressed()));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            objM478constructorimpl = Result.m478constructorimpl(ResultKt.createFailure(th));
                        }
                        if (Result.m484isFailureimpl(objM478constructorimpl)) {
                            getLogger().warn(this, Result.m481exceptionOrNullimpl(objM478constructorimpl));
                            return;
                        }'''
new_res = '''                        try {
                            viewPagerFragment.onBackPressed();
                        } catch (Throwable th) {
                            getLogger().warn(this, th);
                        }'''
c = c.replace(old_res, new_res)

# 6. Fix useDefaultWallpaper lambda
c = c.replace('MainActivity.useDefaultWallpaper$lambda$10(this.f$0);', 'MainActivity.useDefaultWallpaper$lambda$10(MainActivity.this);')

# 7. Fix click listeners lambdas
c = c.replace('MainActivity.initClickListeners$lambda$14(this.f$0, view);', 'MainActivity.initClickListeners$lambda$14(MainActivity.this, view);')
c = c.replace('MainActivity.initClickListeners$lambda$15(this.f$0, view);', 'MainActivity.initClickListeners$lambda$15(MainActivity.this, view);')
c = c.replace('MainActivity.initClickListeners$lambda$16(this.f$0, viewModelLazy, view);', 'MainActivity.initClickListeners$lambda$16(MainActivity.this, viewModelLazy, view);')
c = c.replace('MainActivity.initClickListeners$lambda$17(this.f$0, view);', 'MainActivity.initClickListeners$lambda$17(MainActivity.this, view);')

# 8. Fix this.recreate()
c = c.replace('this.recreate();', 'MainActivity.this.recreate();')

# 9. Fix statusVal integer unboxing
old_debug = '''                int i2 = (Integer) MainActivity.initDebugModeObserver$lambda$18(viewModelLazy).getStatusLiveData().getValue();
                if (i2 == null) {
                    i2 = 0;
                }
                int i3 = (i2.intValue() != 0 || MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getKey(), BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getDefaultValue()) || bool.booleanValue()) ? 0 : 8;'''
new_debug = '''                Integer statusInt = (Integer) MainActivity.initDebugModeObserver$lambda$18(viewModelLazy).getStatusLiveData().getValue();
                int i2 = statusInt != null ? statusInt.intValue() : 0;
                int i3 = (i2 != 0 || MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getKey(), BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getDefaultValue()) || bool.booleanValue()) ? 0 : 8;'''
c = c.replace(old_debug, new_debug)

old_sync = '''                int i = (Integer) MainActivity.initShowSyncObserver$lambda$19(viewModelLazy).getStatusLiveData().getValue();
                int i2 = 0;
                if (i == null) {
                    i = 0;
                }
                if (i.intValue() == 0 && !MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue())) {'''
new_sync = '''                Integer statusInt2 = (Integer) MainActivity.initShowSyncObserver$lambda$19(viewModelLazy).getStatusLiveData().getValue();
                int i = statusInt2 != null ? statusInt2.intValue() : 0;
                int i2 = 0;
                if (i == 0 && !MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue())) {'''
c = c.replace(old_sync, new_sync)

# 10. Fix ObjectAnimator View.ALPHA
c = c.replace('(Property<ConstraintLayout, Float>) View.ALPHA', '(Property) View.ALPHA')

# 11. Fix C00931 and C01011
c = c.replace(
    'static final class C00931 extends Lambda implements Function1<Boolean, Unit> {\n        C00931() {}',
    'final class C00931 extends Lambda<Unit> implements Function1<Boolean, Unit> {\n        C00931() { super(1); }'
)
c = c.replace(
    'static final class C01011 extends Lambda implements Function1<Boolean, Unit> {\n        C01011() {}',
    'final class C01011 extends Lambda<Unit> implements Function1<Boolean, Unit> {\n        C01011() { super(1); }'
)

# 12. Fix static in inner classes
c = c.replace(
    'private static final DaijishouSynchronizationModel invoke$lambda$0(Lazy<DaijishouSynchronizationModel> lazy) {',
    'private final DaijishouSynchronizationModel invoke$lambda$0(Lazy<DaijishouSynchronizationModel> lazy) {'
)

# 13. Fix connection observer
c = c.replace('LifecycleOwner lifecycleOwner = this;', 'MainActivity lifecycleOwner = MainActivity.this;')
c = c.replace('this.clockTime24HourFormat', 'MainActivity.this.clockTime24HourFormat')
c = c.replace('this.clockTimeFormat', 'MainActivity.this.clockTimeFormat')

# 14. Fix initTabLayout for loop
old_tab_loop = '''        int tabCount = getTabLayout().getTabCount();
        for (final int i = 0; i < tabCount; i++) {
            TabLayout.Tab tabAt = getTabLayout().getTabAt(i);
            View view = ViewGroupKt.get(getTabLayout(), 0);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt = ((ViewGroup) view).getChildAt(i);
            ViewPagerFragment item = getMainViewPagerAdapter().getItem(i);
            childAt.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MainActivity.initTabLayout$lambda$26(this.f$0, i, view2);
                }
            });'''

new_tab_loop = '''        int tabCount = getTabLayout().getTabCount();
        for (int i = 0; i < tabCount; i++) {
            final int finalI = i;
            TabLayout.Tab tabAt = getTabLayout().getTabAt(i);
            View view = ViewGroupKt.get(getTabLayout(), 0);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt = ((ViewGroup) view).getChildAt(i);
            ViewPagerFragment item = getMainViewPagerAdapter().getItem(i);
            childAt.setOnClickListener(new View.OnClickListener() {
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MainActivity.initTabLayout$lambda$26(MainActivity.this, finalI, view2);
                }
            });'''
c = c.replace(old_tab_loop, new_tab_loop)

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed MainActivity.java successfully')
