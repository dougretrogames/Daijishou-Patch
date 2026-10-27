import os
import xml.etree.ElementTree as ET

src_base = 'res_translations'
dst_base = 'build_tmp/apktool_1.8.1_v3/res'

for folder in os.listdir(src_base):
    src_file = os.path.join(src_base, folder, 'strings.xml')
    dst_file = os.path.join(dst_base, folder, 'strings.xml')
    if not os.path.exists(src_file):
        continue
    if not os.path.exists(dst_file):
        os.makedirs(os.path.dirname(dst_file), exist_ok=True)
        with open(dst_file, 'w', encoding='utf-8') as f:
            f.write('<?xml version="1.0" encoding="utf-8"?>\n<resources>\n</resources>\n')

    with open(src_file, 'r', encoding='utf-8') as f:
        src_tree = ET.fromstring(f.read())
    with open(dst_file, 'r', encoding='utf-8') as f:
        dst_content = f.read()
    dst_tree = ET.fromstring(dst_content)

    existing_keys = set(e.get('name') for e in dst_tree.findall('string') if e.get('name'))
    to_add = []
    for elem in src_tree.findall('string'):
        name = elem.get('name')
        if name and name not in existing_keys:
            text = elem.text or ''
            # Escape & and < and >
            text_esc = text.replace('&', '&amp;').replace('<', '&lt;').replace('>', '&gt;')
            to_add.append(f'    <string name="{name}">{text_esc}</string>')

    if to_add:
        idx = dst_content.rfind('</resources>')
        new_content = dst_content[:idx] + '\n' + '\n'.join(to_add) + '\n' + dst_content[idx:]
        with open(dst_file, 'w', encoding='utf-8') as f:
            f.write(new_content)
        print(f'{folder}: merged {len(to_add)} strings')
    else:
        print(f'{folder}: up to date')

print('All translations merged successfully!')
