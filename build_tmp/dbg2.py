import os, re, json
BASE = r'C:\Users\Douglas\Documents\Daijishou'
RECON = os.path.join(BASE, 'build_tmp', 'smali_recon')
COMP = os.path.join(BASE, 'build_tmp', 'smali_compiled')
meth_re = re.compile(r'^\.method\s+(.*?)([A-Za-z_$<][\w$<>]*)\(([^)]*)\)(\S+)\s*$')
cls = 'com/magneticchen/daijishou/activities/SplashScreenActivity$AnonymousClass1$AnonymousClass2'
def parse(full):
    m = {}
    for line in open(full, encoding='utf-8', errors='replace'):
        if line.startswith('.method '):
            x = meth_re.match(line.rstrip('\n'))
            if x:
                m[(x.group(2), '(' + x.group(3) + ')' + x.group(4))] = x.group(1)
    return m
def path(root): return os.path.join(root, *cls.split('/')) + '.smali'
r = parse(path(RECON)); c = parse(path(COMP))
print('recon members:', len(r)); print('comp members:', len(c))
comp_names = {k[0] for k in c}
for key in c:
    if key in r: continue
    cname, cdesc = key
    if cname == '<init>': continue
    if cname == 'invokeSuspendImpl' and ('invokeSuspend', cdesc) in r: continue
    cands = [k for k in r if k[1] == cdesc and k[0] not in comp_names]
    print('MISSING', cname + cdesc, '-> candidates', cands)
