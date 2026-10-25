import json, os, hashlib
BASE = r'C:\Users\Douglas\Documents\Daijishou'
R = os.path.join(BASE, 'build_tmp', 'smali_recon')
C = os.path.join(BASE, 'build_tmp', 'smali_compiled')
patched = set(json.load(open(os.path.join(BASE, 'build_tmp', 'patched_classes.json'))))
for cls in ['com/magneticchen/daijishou/daijishou_widget/widgets/rss/RSSWidgetNavFragment$AnonymousClass4',
            'com/magneticchen/daijishou/daijishou_widget/widgets/rss/RSSWidgetNavFragment',
            'com/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetContinueFaceFragment$AnonymousClass1']:
    rp = os.path.join(R, *cls.split('/')) + '.smali'
    cp = os.path.join(C, *cls.split('/')) + '.smali'
    print(cls)
    print('  recon exists', os.path.exists(rp), 'compiled exists', os.path.exists(cp), 'in patched', cls in patched)
    if os.path.exists(rp) and os.path.exists(cp):
        r = open(rp, encoding='utf-8', errors='replace').read()
        c = open(cp, encoding='utf-8', errors='replace').read()
        print('  identical', r == c, 'len', len(r), len(c))
