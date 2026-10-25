import json
BASE = r'C:\Users\Douglas\Documents\Daijishou\build_tmp'
p = json.load(open(BASE + r'\patched_classes.json'))
target = 'com/magneticchen/daijishou/activities/SplashScreenActivity$AnonymousClass1$AnonymousClass2'
print('patched count:', len(p))
print('target in patched:', target in p)
print([x for x in p if x.endswith('AnonymousClass2') and 'SplashScreenActivity' in x])
stubs = json.load(open(BASE + r'\class_map.json'))['stubs']
print('target in stubs:', target in stubs)
print('stubs with Splash:', [x for x in stubs if 'SplashScreenActivity' in x])
