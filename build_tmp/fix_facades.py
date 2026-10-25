import os

ROOT = r'C:\Users\Douglas\Documents\Daijishou\jadx_nest\sources\com\magneticchen\daijishou'
RENAMES = {
    'BuildersKt__Builders_commonKt': 'BuildersKt',
    'JobKt__JobKt': 'JobKt',
    'FlowKt__ErrorsKt': 'FlowKt',
}

changed = []
for dirpath, _, files in os.walk(ROOT):
    for f in files:
        if not f.endswith('.java'):
            continue
        p = os.path.join(dirpath, f)
        with open(p, 'r', encoding='utf-8') as fh:
            src = fh.read()
        new = src
        for a, b in RENAMES.items():
            new = new.replace(a, b)
        if new != src:
            with open(p, 'w', encoding='utf-8', newline='') as fh:
                fh.write(new)
            changed.append(p)

print('files changed:', len(changed))
for p in changed[:10]:
    print(' ', p)
