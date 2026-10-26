# build_tmp/apply_translations.py
import os, sys, xml.etree.ElementTree as ET
sys.stdout.reconfigure(encoding='utf-8')
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

from translations_all import get_translations_pt, BASE_KEYS
from translations_es import get_translations_es
from translations_fr import get_translations_fr
from translations_de import get_translations_de
from translations_it import get_translations_it
from translations_ja import get_translations_ja
from translations_ko import get_translations_ko
from translations_zh import get_translations_zh
from translations_zh_tw import get_translations_zh_tw
from translations_hi import get_translations_hi

LOCALE_MAP = {
    'values-pt': get_translations_pt(),
    'values-es': get_translations_es(),
    'values-fr': get_translations_fr(),
    'values-de': get_translations_de(),
    'values-it': get_translations_it(),
    'values-ja': get_translations_ja(),
    'values-ko': get_translations_ko(),
    'values-zh': get_translations_zh(),
    'values-zh-rTW': get_translations_zh_tw(),
    'values-hi': get_translations_hi(),
}

def escape_xml_text(val):
    # XML escaping: & -> &amp;, < -> &lt;, > -> &gt;
    # (Notice: in Android strings.xml, apostrophe is \' and double quote is \" or literal in escaped string)
    # Don't double-escape if already escaped
    return val.replace('&', '&amp;').replace('<', '&lt;').replace('>', '&gt;')

def inject_translations(xml_path, translations):
    if not os.path.exists(xml_path):
        print(f"File not found: {xml_path}")
        return 0

    with open(xml_path, 'r', encoding='utf-8') as f:
        content = f.read()

    # Parse existing keys
    tree = ET.fromstring(content)
    existing_keys = set(e.get('name') for e in tree.findall('string') if e.get('name'))

    to_add = []
    for k in sorted(translations.keys()):
        if k not in existing_keys:
            val = translations[k]
            # Android XML string entry
            entry = f'    <string name="{k}">{val}</string>'
            to_add.append(entry)

    if not to_add:
        print(f"{xml_path}: Already 100% up to date.")
        return 0

    # Insert before </resources>
    last_idx = content.rfind('</resources>')
    if last_idx == -1:
        raise ValueError(f"Could not find </resources> in {xml_path}")

    block = '\n' + '\n'.join(to_add) + '\n'
    new_content = content[:last_idx] + block + content[last_idx:]

    with open(xml_path, 'w', encoding='utf-8') as f:
        f.write(new_content)

    print(f"{xml_path}: Injected {len(to_add)} translated strings.")
    return len(to_add)

# 1. Apply to jadx-1.5.6/resources/res/
total_injected = 0
for loc, trans in LOCALE_MAP.items():
    p = os.path.join('jadx-1.5.6', 'resources', 'res', loc, 'strings.xml')
    total_injected += inject_translations(p, trans)

# Also copy all pt strings into values-pt-rBR if missing
pt_file = os.path.join('jadx-1.5.6', 'resources', 'res', 'values-pt', 'strings.xml')
pt_rbr_file = os.path.join('jadx-1.5.6', 'resources', 'res', 'values-pt-rBR', 'strings.xml')
with open(pt_file, 'r', encoding='utf-8') as f:
    pt_tree = ET.fromstring(f.read())
all_pt_strings = {e.get('name'): e.text for e in pt_tree.findall('string') if e.get('name')}
injected_rbr = inject_translations(pt_rbr_file, all_pt_strings)
print(f"values-pt-rBR: Injected {injected_rbr} strings from values-pt.")

print(f"\nCompleted! Total string injections across all locales: {total_injected + injected_rbr}")
