import re

path = 'build_tmp/apktool_1.8.1_v3/AndroidManifest.xml'
with open(path, 'r', encoding='utf-8') as f:
    text = f.read()

# Remove any existing uses-sdk
text = re.sub(r'\s*<uses-sdk[^>]*>', '', text)

# Find </manifest> and start of <manifest
m = re.search(r'<manifest\b([^>]*)>', text)
if m:
    manifest_tag = m.group(0)
    # clean manifest_tag
    manifest_tag = re.sub(r'\s*<uses-sdk[^>]*>', '', manifest_tag)
    # replace original manifest tag
    text = text[:m.start()] + manifest_tag + '\n    <uses-sdk android:minSdkVersion="24" android:targetSdkVersion="35"/>' + text[m.end():]

with open(path, 'w', encoding='utf-8') as f:
    f.write(text)

print("Fixed manifest successfully!")
