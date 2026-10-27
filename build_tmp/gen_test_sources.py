import os

jadx_dir = os.path.abspath(r'build_tmp/jadx_1.8.1_no_inline/sources/com/magneticchen/daijishou')
sources = []
for root, dirs, files in os.walk(jadx_dir):
    for f in files:
        if f.endswith('.java'):
            sources.append(os.path.join(root, f).replace('\\', '/'))

print(f'Total java files found in 1.8.1: {len(sources)}')
with open('build_tmp/test_181_sources.txt', 'w', encoding='utf-8') as f:
    f.write('\n'.join(f'"{s}"' for s in sources))
