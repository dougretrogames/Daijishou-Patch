import os, re

root = r'C:\Users\Douglas\Documents\Daijishou\jadx_nest\sources\com\magneticchen\daijishou'

vm = os.path.join(root, 'view_models', 'DaijishouConsoleViewModel.java')
if os.path.exists(vm):
    s = open(vm, encoding='utf-8', errors='replace').read()
    print('console startWith:', sorted(set(re.findall(r'startWith = "([^"]+)"', s))))
    print('console descriptions sample:', len(re.findall(r'description = ', s)))

ops = os.path.join(root, 'daijishou_debug_service', 'passive_protocol', 'client_operations')
if os.path.isdir(ops):
    print('operations:', sorted(f[:-5] for f in os.listdir(ops) if f.endswith('.java') and '$' not in f))

dep = os.path.join(root, 'daijishou_debug_service', 'passive_protocol', 'deprecated', 'client_command_definitions')
if os.path.isdir(dep):
    print('deprecated commands:', sorted(f[:-5] for f in os.listdir(dep) if f.endswith('.java') and '$' not in f))

print('== extension mentions')
hits = []
for dp, _, fns in os.walk(root):
    for fn in fns:
        if not fn.endswith('.java'):
            continue
        p = os.path.join(dp, fn)
        s = open(p, encoding='utf-8', errors='replace').read()
        if re.search(r'(?i)extension', s):
            hits.append(os.path.relpath(p, root))
print(len(hits))
for h in hits[:60]:
    print('  ', h)
