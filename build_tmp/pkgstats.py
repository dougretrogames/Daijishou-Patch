import os, collections

root = r'C:\Users\Douglas\Documents\Daijishou\jadx_nest\sources\com\magneticchen\daijishou'
pkgs = collections.Counter()
files = []
for dp, _, fns in os.walk(root):
    for fn in fns:
        if fn.endswith('.java'):
            rel = os.path.relpath(dp, root)
            top = rel.split(os.sep)[0] if rel != '.' else '(root)'
            pkgs[top] += 1
            files.append(os.path.join(dp, fn))
print('total java files', len(files))
for k, v in pkgs.most_common():
    print(f'{v:5}  {k}')
