import re

with open('build_tmp/apktool_1.8.1/AndroidManifest.xml', encoding='utf-8') as f:
    text = f.read()

activities = re.findall(r'<activity[^>]*android:name="([^"]+)"', text)
print('Activities in 1.8.1 manifest:')
for a in activities:
    print(' ', a)

services = re.findall(r'<service[^>]*android:name="([^"]+)"', text)
print('Services in 1.8.1 manifest:')
for s in services:
    print(' ', s)
