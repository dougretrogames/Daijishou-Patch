import glob
import re

for xml_path in glob.glob('build_tmp/apktool_1.8.1_v3/res/**/strings.xml', recursive=True):
    with open(xml_path, 'r', encoding='utf-8') as f:
        content = f.read()

    def repl(m):
        tag_open = m.group(1)
        text = m.group(2).strip()
        tag_close = m.group(3)
        # remove any crazy backslashes before quotes
        text = text.replace("\\\\'", "'").replace("\\'", "'")
        if "'" in text and not (text.startswith('"') and text.endswith('"')):
            text = f'"{text}"'
        return f'{tag_open}{text}{tag_close}'

    new_content = re.sub(r'(<string[^>]*>)(.*?)(</string>)', repl, content)
    with open(xml_path, 'w', encoding='utf-8') as f:
        f.write(new_content)

print('Normalized quotes in all strings.xml!')
