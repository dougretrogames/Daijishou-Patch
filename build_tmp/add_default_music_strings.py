p = 'build_tmp/apktool_1.8.1_v3/res/values/strings.xml'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

entries = """    <string name="music_category_title">Music</string>
    <string name="play_music_title">Play music</string>
    <string name="play_music_summary">Play background music found in the \\'music\\' folder where ROMs are located.</string>
"""

idx = c.rfind('</resources>')
new_c = c[:idx] + entries + c[idx:]
with open(p, 'w', encoding='utf-8') as f:
    f.write(new_c)

print('Added music strings to default values/strings.xml successfully!')
