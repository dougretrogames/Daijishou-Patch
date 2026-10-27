import xml.etree.ElementTree as ET

p = 'build_tmp/apktool_1.8.1_v3/res/values/strings.xml'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

tree = ET.fromstring(c)
seen = set()
unique_elems = []
for elem in tree.findall('string'):
    name = elem.get('name')
    if name not in seen:
        seen.add(name)
        text = (elem.text or '').replace("'", "\\'")
        unique_elems.append(f'    <string name="{name}">{text}</string>')

if 'music_category_title' not in seen:
    unique_elems.append('    <string name="music_category_title">Music</string>')
if 'play_music_title' not in seen:
    unique_elems.append('    <string name="play_music_title">Play music</string>')
if 'play_music_summary' not in seen:
    unique_elems.append("    <string name=\"play_music_summary\">Play background music found in the \\'music\\' folder where ROMs are located.</string>")

new_content = '<?xml version="1.0" encoding="utf-8"?>\n<resources>\n' + '\n'.join(unique_elems) + '\n</resources>\n'
with open(p, 'w', encoding='utf-8') as f:
    f.write(new_content)

print('Deduplicated values/strings.xml!')
