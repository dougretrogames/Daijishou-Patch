p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/features/Soundboard.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

c = c.replace('this.this$0.makeButtonSound = z;', 'Soundboard.this.makeButtonSound = z;')
c = c.replace('Soundboard.play$lambda$2(this.f$0, mediaPlayer2);', 'Soundboard.play$lambda$2(Soundboard.this, mediaPlayer2);')

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed Soundboard.java successfully')
