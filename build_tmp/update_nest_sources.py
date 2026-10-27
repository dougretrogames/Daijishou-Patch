import os

src_dir = os.path.abspath('app_sources/sources')
files = []
for root, _, filenames in os.walk(src_dir):
    for f in filenames:
        if f.endswith('.java'):
            p = os.path.join(root, f).replace('\\', '/')
            files.append(f'"{p}"')

with open('nest_sources_compile.txt', 'w', encoding='utf-8') as f:
    f.write('\n'.join(files))

print(f'Updated nest_sources_compile.txt with {len(files)} files!')
