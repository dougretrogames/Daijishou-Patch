p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/features/AudioManager.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

old_block = '''        @Override
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$dir, continuation);
        }

        @Override
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }'''

new_block = '''        @Override
        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$dir, continuation);
        }

        @Override
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) (Object) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }'''

assert old_block in c, 'old_block not found'
c = c.replace(old_block, new_block)

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Updated AudioManager.java create/invoke')
