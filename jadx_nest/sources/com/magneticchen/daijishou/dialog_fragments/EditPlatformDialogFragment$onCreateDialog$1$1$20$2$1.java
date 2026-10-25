package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.scraper.ScraperUtilsKt;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: EditPlatformDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.EditPlatformDialogFragment$onCreateDialog$1$1$20$2$1", f = "EditPlatformDialogFragment.kt", i = {}, l = {798}, m = "invokeSuspendImpl", n = {}, s = {})
final class EditPlatformDialogFragment$onCreateDialog$1$1$20$2$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ long $id;
    final /* synthetic */ PlatformEntity $newPlatformEntity;
    final /* synthetic */ PlatformEntity $platformEntity;
    final /* synthetic */ File $selectedWallpaperFileAssertive;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EditPlatformDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditPlatformDialogFragment$onCreateDialog$1$1$20$2$1(Context context, EditPlatformDialogFragment editPlatformDialogFragment, long j, File file, PlatformEntity platformEntity, AlertDialog alertDialog, PlatformEntity platformEntity2, Continuation<?> continuation) {
        super(2, continuation);
        this.$context = context;
        this.this$0 = editPlatformDialogFragment;
        this.$id = j;
        this.$selectedWallpaperFileAssertive = file;
        this.$newPlatformEntity = platformEntity;
        this.$dialog = alertDialog;
        this.$platformEntity = platformEntity2;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        EditPlatformDialogFragment$onCreateDialog$1$1$20$2$1 editPlatformDialogFragment$onCreateDialog$1$1$20$2$1 = new EditPlatformDialogFragment$onCreateDialog$1$1$20$2$1(this.$context, this.this$0, this.$id, this.$selectedWallpaperFileAssertive, this.$newPlatformEntity, this.$dialog, this.$platformEntity, continuation);
        editPlatformDialogFragment$onCreateDialog$1$1$20$2$1.L$0 = obj;
        return editPlatformDialogFragment$onCreateDialog$1$1$20$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((EditPlatformDialogFragment$onCreateDialog$1$1$20$2$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            String str = this.$context.getFilesDir() + InternalZipConstants.ZIP_FILE_SEPARATOR + this.this$0.wallpaperDirectoryName + InternalZipConstants.ZIP_FILE_SEPARATOR + this.$id + ".png";
            this.this$0.getLogger().debug(coroutineScope, str);
            DaijishouApplication.WrappedLogger logger = this.this$0.getLogger();
            String absolutePath = this.$selectedWallpaperFileAssertive.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            logger.debug(coroutineScope, absolutePath);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.$selectedWallpaperFileAssertive.getAbsolutePath());
            Intrinsics.checkNotNull(bitmapDecodeFile);
            Bitmap resizedBitmap = ScraperUtilsKt.getResizedBitmap(bitmapDecodeFile, 720);
            Intrinsics.checkNotNull(resizedBitmap);
            resizedBitmap.compress(Constants.INSTANCE.getPlatformWallpaperFormat(), 100, fileOutputStream);
            this.$newPlatformEntity.setWallpaperPath(str);
            this.$selectedWallpaperFileAssertive.delete();
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$newPlatformEntity, this.$id, this.this$0, this.$dialog, this.$context, this.$platformEntity, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.EditPlatformDialogFragment$onCreateDialog$1$1$20$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: EditPlatformDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.EditPlatformDialogFragment$onCreateDialog$1$1$20$2$1$1", f = "EditPlatformDialogFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ AlertDialog $dialog;
        final /* synthetic */ long $id;
        final /* synthetic */ PlatformEntity $newPlatformEntity;
        final /* synthetic */ PlatformEntity $platformEntity;
        int label;
        final /* synthetic */ EditPlatformDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PlatformEntity platformEntity, long j, EditPlatformDialogFragment editPlatformDialogFragment, AlertDialog alertDialog, Context context, PlatformEntity platformEntity2, Continuation<?> continuation) {
            super(2, continuation);
            this.$newPlatformEntity = platformEntity;
            this.$id = j;
            this.this$0 = editPlatformDialogFragment;
            this.$dialog = alertDialog;
            this.$context = context;
            this.$platformEntity = platformEntity2;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$newPlatformEntity, this.$id, this.this$0, this.$dialog, this.$context, this.$platformEntity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$45$saveAndDismiss(this.$newPlatformEntity, this.$id, this.this$0, this.$dialog, this.$context, this.$platformEntity);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
