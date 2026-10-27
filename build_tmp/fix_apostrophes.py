import glob
import re

for xml_path in glob.glob('build_tmp/apktool_1.8.1_v3/res/**/strings.xml', recursive=True):
    with open(xml_path, 'r', encoding='utf-8') as f:
        content = f.read()

    def repl(m):
        tag_open = m.group(1)
        text = m.group(2)
        tag_close = m.group(3)
        # Escape single quotes that are not already escaped
        text = re.sub(r"(?<!\\)'", r"\'", text)
        return tag_open + text + tag_close

    new_content = re.sub(r'(<string[^>]*>)(.*?)(</string>)', repl, content)
    if new_content != content:
        with open(xml_path, 'w', encoding='utf-8') as f:
            f.write(new_content)
        print('Fixed apostrophes in:', xml_path)

print('Apostrophe fix completed!')
