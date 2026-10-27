import os, sys, xml.etree.ElementTree as ET
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

from translations_all import get_translations_pt
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
    'values': {
        'music_category_title': 'Music',
        'play_music_title': 'Play music',
        'play_music_summary': 'Play background music found in the \'music\' folder where ROMs are located.'
    },
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

# Ensure base music keys are in each translation dictionary
base_music_keys = {
    'values-pt': {
        'music_category_title': 'Músicas',
        'play_music_title': 'Reproduzir músicas',
        'play_music_summary': 'Reproduzir músicas de fundo da pasta \'music\' onde as ROMs estão localizadas.'
    },
    'values-es': {
        'music_category_title': 'Música',
        'play_music_title': 'Reproducir música',
        'play_music_summary': 'Reproducir música de fondo que se encuentre en la carpeta \'music\' donde están las ROMs.'
    },
    'values-fr': {
        'music_category_title': 'Musique',
        'play_music_title': 'Lire la musique',
        'play_music_summary': 'Lire la musique de fond trouvée dans le dossier \'music\' où se trouvent les ROM.'
    },
    'values-de': {
        'music_category_title': 'Musik',
        'play_music_title': 'Musik abspielen',
        'play_music_summary': 'Hintergrundmusik aus dem Ordner \'music\' am Speicherort der ROMs abspielen.'
    },
    'values-it': {
        'music_category_title': 'Musica',
        'play_music_title': 'Riproduci musica',
        'play_music_summary': 'Riproduci la musica di sottofondo trovata nella cartella \'music\' in cui si trovano le ROM.'
    },
    'values-ja': {
        'music_category_title': '音楽',
        'play_music_title': '音楽を再生',
        'play_music_summary': 'ROMが配置されている「music」フォルダー内のBGMを再生します。'
    },
    'values-ko': {
        'music_category_title': '음악',
        'play_music_title': '음악 재생',
        'play_music_summary': 'ROM이 위치한 \'music\' 폴더에 있는 배경 음악을 재생합니다.'
    },
    'values-zh': {
        'music_category_title': '音乐',
        'play_music_title': '播放音乐',
        'play_music_summary': '播放位于 ROM 所在的“music”文件夹中的背景音乐。'
    },
    'values-zh-rTW': {
        'music_category_title': '音樂',
        'play_music_title': '播放音樂',
        'play_music_summary': '播放位於 ROM 所在「music」資料夾中的背景音樂。'
    },
    'values-hi': {
        'music_category_title': 'संगीत',
        'play_music_title': 'संगीत चलाएं',
        'play_music_summary': 'ROM स्थित \'music\' फ़ोल्डर में पाया गया पृष्ठभूमि संगीत चलाएं।'
    }
}

for loc, d in base_music_keys.items():
    if loc in LOCALE_MAP:
        LOCALE_MAP[loc].update(d)

def inject_translations(xml_path, translations):
    if not os.path.exists(xml_path):
        os.makedirs(os.path.dirname(xml_path), exist_ok=True)
        with open(xml_path, 'w', encoding='utf-8') as f:
            f.write('<?xml version="1.0" encoding="utf-8"?>\n<resources>\n</resources>\n')

    with open(xml_path, 'r', encoding='utf-8') as f:
        content = f.read()

    tree = ET.fromstring(content)
    existing_keys = set(e.get('name') for e in tree.findall('string') if e.get('name'))

    to_add = []
    for k in sorted(translations.keys()):
        if k not in existing_keys:
            val = translations[k]
            entry = f'    <string name="{k}">{val}</string>'
            to_add.append(entry)

    if not to_add:
        return 0

    last_idx = content.rfind('</resources>')
    if last_idx == -1:
        raise ValueError(f"Could not find </resources> in {xml_path}")

    block = '\n' + '\n'.join(to_add) + '\n'
    new_content = content[:last_idx] + block + content[last_idx:]

    with open(xml_path, 'w', encoding='utf-8') as f:
        f.write(new_content)

    return len(to_add)

target_res = 'build_tmp/apktool_1.8.1_v3/res'
total = 0
for loc, trans in LOCALE_MAP.items():
    p = os.path.join(target_res, loc, 'strings.xml')
    cnt = inject_translations(p, trans)
    print(f'{loc}: injected {cnt} strings')
    total += cnt

# Also update values-pt-rBR
pt_file = os.path.join(target_res, 'values-pt', 'strings.xml')
pt_rbr_file = os.path.join(target_res, 'values-pt-rBR', 'strings.xml')
with open(pt_file, 'r', encoding='utf-8') as f:
    pt_tree = ET.fromstring(f.read())
all_pt_strings = {e.get('name'): e.text for e in pt_tree.findall('string') if e.get('name')}
cnt_rbr = inject_translations(pt_rbr_file, all_pt_strings)
print(f'values-pt-rBR: injected {cnt_rbr} strings')

print(f'Total injected strings: {total + cnt_rbr}')
