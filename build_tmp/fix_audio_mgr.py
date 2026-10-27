p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/features/AudioManager.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

# 1. Fix line 135
c = c.replace(
    'AudioManager.play$lambda$2$lambda$1(this.f$0, mediaPlayer2);',
    'AudioManager.play$lambda$2$lambda$1(AudioManager.this, mediaPlayer2);'
)

# 2. Fix comparators
c = c.replace('public final int compare(T t, T t2) {', 'public final int compare(Object t, Object t2) {')

# 3. Fix line 322
c = c.replace(
    'AudioManager.observeChanges$lambda$9(this.f$0, sharedPreferences, str);',
    'AudioManager.observeChanges$lambda$9(AudioManager.this, sharedPreferences, str);'
)

# 4. Fix AnonymousClass1 and launch call
old_anon = '''        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(uri, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.AudioManager$onLoadPlaylist$1, reason: invalid class name */
    /* JADX INFO: compiled from: AudioManager.kt */
    @Metadata(d1 = {"\\u0000\\n\\n\\u0000\\n\\u0002\\u0010\\u0002\\n\\u0002\\u0018\\u0002\\u0010\\u0000\\u001a\\u00020\\u0001*\\u00020\\u0002H\\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.AudioManager$onLoadPlaylist$1", f = "AudioManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $dir;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Uri uri, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$dir = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AudioManager.this.new AnonymousClass1(this.$dir, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AudioManager audioManager = AudioManager.this;
            audioManager.mp3Files = CollectionsKt.toMutableList((Collection) AudioManager.findMp3Files$default(audioManager, audioManager.application, this.$dir, false, 4, null));
            AudioManager.this.onLoadConfiguration();
            return Unit.INSTANCE;
        }
    }'''

new_anon = '''        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, uri, null), 3, (Object) null);
    }

    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $dir;
        final /* synthetic */ AudioManager this$0;
        int label;

        AnonymousClass1(AudioManager audioManager, Uri uri, Continuation<?> continuation) {
            super(2, (Continuation<Object>) continuation);
            this.this$0 = audioManager;
            this.$dir = uri;
        }

        @Override
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$dir, continuation);
        }

        @Override
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AudioManager audioManager = this.this$0;
            audioManager.mp3Files = CollectionsKt.toMutableList((Collection) AudioManager.findMp3Files$default(audioManager, audioManager.application, this.$dir, false, 4, null));
            this.this$0.onLoadConfiguration();
            return Unit.INSTANCE;
        }
    }'''

assert old_anon in c, 'old_anon not found'
c = c.replace(old_anon, new_anon)

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed features/AudioManager.java successfully')
