import re

p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

# Replace static final class Name extends ContinuationImpl with final class Name extends ContinuationImpl
c = re.sub(
    r'static final class (\w+) extends ContinuationImpl',
    r'final class \1 extends ContinuationImpl',
    c
)

# In those constructors, replace super(continuation); with super((Continuation<Object>) continuation);
c = re.sub(
    r'super\(continuation\);',
    r'super((Continuation<Object>) continuation);',
    c
)

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Updated DaijishouSynchronizationModel.java continuations')
