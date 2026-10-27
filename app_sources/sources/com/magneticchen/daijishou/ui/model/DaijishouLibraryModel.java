package com.magneticchen.daijishou.ui.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.StringPreference;
import com.magneticchen.daijishou.data.db.entity.EventEntity;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToCategoryPairEntity;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemToGenrePairEntity;
import com.magneticchen.daijishou.data.db.entity.PlayerEntity;
import com.magneticchen.daijishou.data.db.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.data.portables.FavoriteItemsShareable;
import com.magneticchen.daijishou.data.portables.PlatformEntityPortable;
import com.magneticchen.daijishou.data.portables.PlatformShareable;
import com.magneticchen.daijishou.data.portables.PlatformThumbnailsPackIndexJson;
import com.magneticchen.daijishou.data.portables.PlatformThumbnailsPackIndexThumbnailListItemJson;
import com.magneticchen.daijishou.data.portables.PlatformWallpapersPackIndexJson;
import com.magneticchen.daijishou.data.portables.PlatformWallpapersPackIndexWallpaperListItemJson;
import com.magneticchen.daijishou.data.portables.PlayerEntityPortable;
import com.magneticchen.daijishou.data.scraper.ScraperManager;
import com.magneticchen.daijishou.player.AmStartCommandToIntentConverter;
import com.magneticchen.daijishou.player.DaijishouPlayerTemplate;
import com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.ListSelectDialogFragment;
import com.magneticchen.daijishou.ui.model.abstract_view_models.DaijishouAndroidViewModel;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import com.magneticchen.daijishou.utils.FileUtils;
import com.magneticchen.daijishou.utils.ScraperUtilsKt;
import com.magneticchen.daijishou.utils.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;

/* JADX INFO: compiled from: DaijishouLibraryModel.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 Í\u00012\u00020\u0001:\u0002Í\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*J%\u0010+\u001a\b\u0012\u0004\u0012\u00020%0,2\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0.\"\u00020*¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020%2\u0006\u00101\u001a\u000202J\u0016\u00103\u001a\u0002042\u0006\u0010&\u001a\u00020'2\u0006\u00105\u001a\u000206J0\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u001e2\u0006\u00105\u001a\u0002062\u0018\u00109\u001a\u0014\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u0002040:J0\u0010<\u001a\u0002042\u0006\u0010&\u001a\u00020'2\u0006\u00108\u001a\u00020\u001e2\u0006\u00105\u001a\u0002062\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010=J\u0006\u0010>\u001a\u000206J\u000e\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020%J\u0010\u0010A\u001a\u0004\u0018\u00010\u001e2\u0006\u0010B\u001a\u00020\u001eJ\u0006\u0010C\u001a\u000204J\u0018\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u0018\u0010G\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u000e\u0010H\u001a\u00020%2\u0006\u0010E\u001a\u00020%J\u000e\u0010I\u001a\u00020%2\u0006\u0010E\u001a\u00020%J\u0018\u0010J\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u0018\u0010K\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u000e\u0010L\u001a\u00020%2\u0006\u0010E\u001a\u00020%J\u000e\u0010M\u001a\u00020%2\u0006\u0010E\u001a\u00020%J\u0018\u0010N\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u0018\u0010O\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u000e\u0010P\u001a\u00020%2\u0006\u0010E\u001a\u00020%J\u000e\u0010Q\u001a\u00020%2\u0006\u0010E\u001a\u00020%J\u0018\u0010R\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u0018\u0010S\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u000e\u0010T\u001a\u00020%2\u0006\u0010E\u001a\u00020%J\u000e\u0010U\u001a\u00020%2\u0006\u0010E\u001a\u00020%J\u0006\u0010V\u001a\u000204J\u000e\u0010W\u001a\u0002042\u0006\u0010@\u001a\u00020%J\u0006\u0010X\u001a\u000204J\u000e\u0010Y\u001a\u0002042\u0006\u0010)\u001a\u00020*J\u001f\u0010Z\u001a\u0002042\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0.\"\u00020*¢\u0006\u0002\u0010[J\u000e\u0010\\\u001a\u0002042\u0006\u0010@\u001a\u00020\u001eJ\u000e\u0010]\u001a\u0002042\u0006\u0010@\u001a\u00020%J\u000e\u0010^\u001a\u0002042\u0006\u00101\u001a\u000202J\u0006\u0010_\u001a\u000204J\u0016\u0010`\u001a\u0002042\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dJ\u0010\u0010e\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\u000e\u0010f\u001a\u00020g2\u0006\u0010&\u001a\u00020'J\u000e\u0010h\u001a\u00020i2\u0006\u0010&\u001a\u00020'J\u001e\u0010j\u001a\b\u0012\u0004\u0012\u00020d0,2\u0006\u0010k\u001a\u00020\u001e2\b\b\u0002\u0010l\u001a\u000206J(\u0010m\u001a\b\u0012\u0004\u0012\u00020d0,2\u0006\u0010k\u001a\u00020\u001e2\b\b\u0002\u0010l\u001a\u0002062\b\b\u0002\u0010F\u001a\u00020;J\f\u0010n\u001a\b\u0012\u0004\u0012\u0002060oJ\u0006\u0010p\u001a\u000206J\u0012\u0010q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0,0oJ\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u001e0,J\u0012\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0,0oJ\f\u0010t\u001a\b\u0012\u0004\u0012\u0002060oJ\f\u0010u\u001a\b\u0012\u0004\u0012\u00020'0,J\f\u0010v\u001a\b\u0012\u0004\u0012\u0002060oJ\u001c\u0010w\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0,0o2\b\b\u0002\u0010F\u001a\u00020;J\u0012\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020,0oJ\f\u0010y\u001a\b\u0012\u0004\u0012\u0002060oJ\f\u0010z\u001a\b\u0012\u0004\u0012\u0002020,J\u0012\u0010{\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0,0oJ\f\u0010|\u001a\b\u0012\u0004\u0012\u00020'0,J\b\u0010}\u001a\u0004\u0018\u00010dJ\u0012\u0010~\u001a\u0004\u0018\u00010d2\b\b\u0002\u0010F\u001a\u00020;J\u001a\u0010\u007f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0,0o2\u0006\u0010@\u001a\u00020%J%\u0010\u0080\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0,0o2\u0006\u0010@\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u001f\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0,2\u0006\u0010@\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u0015\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0,2\u0006\u0010@\u001a\u00020%J\u001b\u0010\u0083\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0,0o2\u0006\u0010@\u001a\u00020%J\u0015\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0,2\u0006\u0010@\u001a\u00020%J\u0010\u0010\u0085\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0086\u00010oJ\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u0001J(\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020d0,2\u0013\u0010\u0089\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020d0.\"\u00020d¢\u0006\u0003\u0010\u008a\u0001J(\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020d0,2\u0013\u0010\u0089\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020d0.\"\u00020d¢\u0006\u0003\u0010\u008a\u0001J\u000f\u0010\u008c\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010d0oJ\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010dJ\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010dJ\u0013\u0010\u008f\u0001\u001a\u0004\u0018\u00010d2\b\b\u0002\u0010F\u001a\u00020;J\u001d\u0010\u0090\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0,0o2\b\b\u0002\u0010l\u001a\u000206J'\u0010\u0090\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0,0o2\b\b\u0002\u0010l\u001a\u0002062\b\b\u0002\u0010F\u001a\u00020;J\u0017\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020d0,2\b\b\u0002\u0010l\u001a\u000206J!\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020d0,2\b\b\u0002\u0010l\u001a\u0002062\b\b\u0002\u0010F\u001a\u00020;J\u0017\u0010\u0092\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0o2\u0006\u0010@\u001a\u00020%J\u0011\u0010\u0093\u0001\u001a\u0004\u0018\u00010'2\u0006\u0010@\u001a\u00020%J\u0018\u0010\u0094\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0o2\u0007\u0010\u0095\u0001\u001a\u00020\u001eJ\u0012\u0010\u0096\u0001\u001a\u0004\u0018\u00010'2\u0007\u0010\u0095\u0001\u001a\u00020\u001eJ\u0017\u0010\u0097\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010d0o2\u0006\u0010@\u001a\u00020%J!\u0010\u0098\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010d0o2\u0006\u0010@\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u001b\u0010\u0099\u0001\u001a\u0004\u0018\u00010d2\u0006\u0010@\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u0011\u0010\u009a\u0001\u001a\u0004\u0018\u00010d2\u0006\u0010@\u001a\u00020%J$\u0010\u009b\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0,0o2\u0006\u0010E\u001a\u00020%2\u0007\u0010\u009c\u0001\u001a\u00020\u001eJ\u001e\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020d0,2\u0006\u0010E\u001a\u00020%2\u0007\u0010\u009c\u0001\u001a\u00020\u001eJ.\u0010\u009e\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0,0o2\u0006\u0010E\u001a\u00020%2\u0007\u0010\u009c\u0001\u001a\u00020\u001e2\b\b\u0002\u0010F\u001a\u00020;J(\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020d0,2\u0006\u0010E\u001a\u00020%2\u0007\u0010\u009c\u0001\u001a\u00020\u001e2\b\b\u0002\u0010F\u001a\u00020;J\t\u0010 \u0001\u001a\u0004\u0018\u00010dJ\u001b\u0010¡\u0001\u001a\u0004\u0018\u00010d2\u0006\u0010@\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020;J\u0011\u0010¢\u0001\u001a\u0004\u0018\u00010d2\u0006\u0010@\u001a\u00020%J\u0013\u0010£\u0001\u001a\u0004\u0018\u00010d2\b\b\u0002\u0010F\u001a\u00020;J\u0011\u0010¤\u0001\u001a\u0004\u0018\u0001022\u0006\u0010@\u001a\u00020%J1\u0010¥\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0086\u00010,0o2\u0007\u0010¦\u0001\u001a\u0002062\b\u0010§\u0001\u001a\u00030¨\u00012\b\b\u0002\u0010l\u001a\u000206J+\u0010©\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010,2\u0007\u0010¦\u0001\u001a\u0002062\b\u0010§\u0001\u001a\u00030¨\u00012\b\b\u0002\u0010l\u001a\u000206J\t\u0010ª\u0001\u001a\u0004\u0018\u00010dJ\u0013\u0010«\u0001\u001a\u0004\u0018\u00010d2\b\b\u0002\u0010F\u001a\u00020;J\u001d\u0010¬\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0,0o2\b\b\u0002\u0010l\u001a\u000206J'\u0010¬\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0,0o2\b\b\u0002\u0010l\u001a\u0002062\b\b\u0002\u0010F\u001a\u00020;J\u0017\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020d0,2\b\b\u0002\u0010l\u001a\u000206J!\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020d0,2\b\b\u0002\u0010l\u001a\u0002062\b\b\u0002\u0010F\u001a\u00020;J*\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020d0,2\u0006\u0010c\u001a\u00020d2\b\b\u0002\u0010l\u001a\u0002062\t\b\u0002\u0010¯\u0001\u001a\u00020;J\u0010\u0010°\u0001\u001a\u0002042\u0007\u0010±\u0001\u001a\u00020iJM\u0010²\u0001\u001a\u0002042\u0007\u0010³\u0001\u001a\u00020g2\t\b\u0002\u0010´\u0001\u001a\u00020;2\t\b\u0002\u0010µ\u0001\u001a\u00020;2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010b2\u0019\b\u0002\u00109\u001a\u0013\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u000204\u0018\u00010¶\u0001J\u0010\u0010·\u0001\u001a\u0002042\u0007\u0010¸\u0001\u001a\u00020\u001eJ3\u0010¹\u0001\u001a\u0002042\u0006\u0010a\u001a\u00020b2\u0007\u0010³\u0001\u001a\u00020g2\u0019\b\u0002\u00109\u001a\u0013\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u000204\u0018\u00010¶\u0001J\u000f\u0010º\u0001\u001a\u0002042\u0006\u0010c\u001a\u00020dJ0\u0010»\u0001\u001a\u0002042\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0017\b\u0002\u00109\u001a\u0011\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u000204\u0018\u00010¶\u0001J\u001b\u0010¼\u0001\u001a\u00020\u001e2\u0007\u0010½\u0001\u001a\u00020\u001e2\t\b\u0002\u0010¾\u0001\u001a\u00020;J\u0012\u0010¿\u0001\u001a\u0004\u0018\u00010\u001e2\u0007\u0010½\u0001\u001a\u00020\u001eJ\u000f\u0010À\u0001\u001a\u0002042\u0006\u0010c\u001a\u00020dJ\u0007\u0010Á\u0001\u001a\u000204J\u001a\u0010Â\u0001\u001a\u0002042\u0006\u0010&\u001a\u00020'2\t\b\u0002\u0010Ã\u0001\u001a\u00020;J\u000f\u0010Ä\u0001\u001a\u0002042\u0006\u0010c\u001a\u00020dJ?\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020d0,2\u0006\u0010k\u001a\u00020\u001e2\b\b\u0002\u0010l\u001a\u0002062\t\b\u0002\u0010Æ\u0001\u001a\u00020;2\t\b\u0002\u0010¯\u0001\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;J\u000f\u0010Ç\u0001\u001a\u00020d2\u0006\u0010c\u001a\u00020dJ\u000f\u0010È\u0001\u001a\u00020d2\u0006\u0010c\u001a\u00020dJ\u000f\u0010É\u0001\u001a\u0002042\u0006\u0010&\u001a\u00020'J\u000f\u0010Ê\u0001\u001a\u0002042\u0006\u0010c\u001a\u00020dJ\u000f\u0010Ë\u0001\u001a\u0002042\u0006\u0010)\u001a\u00020*J \u0010Ì\u0001\u001a\u0002042\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0.\"\u00020*¢\u0006\u0002\u0010[R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00060\u0016R\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020!0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006Î\u0001"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;", "Lcom/magneticchen/daijishou/ui/model/abstract_view_models/DaijishouAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "cachedBoxArtBitmapLoader", "Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "getCachedBoxArtBitmapLoader", "()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "cachedPlatformThumbnailBitmapLoader", "getCachedPlatformThumbnailBitmapLoader", "cachedPlatformWallpaperBitmapLoader", "getCachedPlatformWallpaperBitmapLoader", "cachedSnapshotBitmapLoader", "getCachedSnapshotBitmapLoader", "cachedTitleBitmapLoader", "getCachedTitleBitmapLoader", "daijishouLibraryRepository", "Lcom/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository;", "daijishouPlayerTemplate", "Lcom/magneticchen/daijishou/player/DaijishouPlayerTemplate;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "Lcom/magneticchen/daijishou/DaijishouApplication;", ExtensionRepositoryExtensionToCategoryPairEntity.SCRAPER_CATEGORY, "Lcom/magneticchen/daijishou/data/scraper/ScraperManager;", "getScraper", "()Lcom/magneticchen/daijishou/data/scraper/ScraperManager;", "urlStringToPlatformThumbnailsPackIndexJsonCache", "Lnet/jodah/expiringmap/ExpiringMap;", "", "Lcom/magneticchen/daijishou/data/portables/PlatformThumbnailsPackIndexJson;", "urlStringToPlatformWallpapersPackIndexJsonCache", "Lcom/magneticchen/daijishou/data/portables/PlatformWallpapersPackIndexJson;", "getUrlStringToPlatformWallpapersPackIndexJsonCache", "()Lnet/jodah/expiringmap/ExpiringMap;", "addPlatform", "", "platformEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "addPlayableItemToGenrePair", "playableItemToGenrePairEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;", "addPlayableItemToGenrePairs", "", "playableItemToGenrePairEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;)Ljava/util/List;", "addPlayer", "playerEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayerEntity;", "applyPlatformPreviewMediaIndexJsonToPlatformWithCurrentSettings", "", "previewMediaType", "", "applyPlatformPreviewMediaPackIndexJsonToAllPlatforms", "platformPreviewMediaPackUrlString", "callback", "Lkotlin/Function2;", "", "applyPlatformPreviewMediaPackIndexJsonToPlatform", "Lkotlin/Function0;", "clearAllDisjointedPlayableItems", "clearAllDisjointedPlayableItemsByAttachedPlatformId", "id", "convertAmStartArgumentsToPackageName", "amStartArguments", "convertPlatformIdToShortname", "countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically", "platformId", "visibility", "countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countFavoritePlayableItemsByAttachedPlatformIdStatically", "countFavoritePlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically", "countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically", "countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countNewlyPlayableItemsByAttachedPlatformIdStatically", "countNewlyPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically", "countPlayableItemsByAttachedPlatformIdAndVisibilityStatically", "countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countPlayableItemsByAttachedPlatformIdStatically", "countPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically", "countRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically", "countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countRecentPlayableItemsByAttachedPlatformIdStatically", "countRecentPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically", "deleteAllEvents", "deleteAllEventsByPlayableItemId", "deleteAllPlayableItemToGenrePairs", "deletePlayableItemToGenrePair", "deletePlayableItemToGenrePairs", "([Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;)V", "deletePlayableItemToGenrePairsByGenreId", "deletePlayableItemToGenrePairsByPlayableItemId", "deletePlayer", "disableAllPlayableItemsCustomPlayer", "editPlayableItem", "activity", "Landroid/app/Activity;", "playableItemEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "ensurePlatformsPreviewMediaDirectory", "exportPlatform", "Lcom/magneticchen/daijishou/data/portables/PlatformShareable;", "exportPlatformFavoriteItems", "Lcom/magneticchen/daijishou/data/portables/FavoriteItemsShareable;", "findPlayableItemsWithNameAndDescriptionStatically", "keyword", "limit", "findPlayableItemsWithNameDescriptionAndVisibilityStatically", "getAllEventsCount", "Landroidx/lifecycle/LiveData;", "getAllEventsCountStatically", "getAllGenreIds", "getAllGenreIdsStatically", "getAllPlatforms", "getAllPlatformsCount", "getAllPlatformsStatically", "getAllPlayableItemCount", "getAllPlayableItemsIdsByVisibility", "getAllPlayers", "getAllPlayersCount", "getAllPlayersStatically", "getAllVisiblePlatformsOrderedByShortName", "getAllVisiblePlatformsOrderedByShortNameStatically", "getFavoritePlayableItemRandomly", "getFavoritePlayableItemRandomlyByVisibility", "getGenreIdsByPlatformId", "getGenreIdsByPlatformIdAndVisibility", "getGenreIdsByPlatformIdAndVisibilityStatically", "getGenreIdsByPlatformIdStatically", "getGenreIdsByPlayableItemId", "getGenreIdsByPlayableItemIdStatically", "getLatestEvent", "Lcom/magneticchen/daijishou/data/db/entity/EventEntity;", "getLatestEventStatically", "getMergedPlayableItems", "playableItemEntities", "([Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)Ljava/util/List;", "getMergedPlayableItemsWithPreferences", "getMostRecentPlayableItem", "getMostRecentPlayableItemStatically", "getNewlyPlayableItemRandomly", "getNewlyPlayableItemRandomlyByVisibility", "getNewlyPlayableItems", "getNewlyPlayableItemsStatically", "getPlatformById", "getPlatformByIdStatically", "getPlatformByShortName", "shortname", "getPlatformByShortNameStatically", "getPlayableItemById", "getPlayableItemByIdAndVisibility", "getPlayableItemByIdAndVisibilityStatically", "getPlayableItemByIdStatically", "getPlayableItemIdsByPlatformIdAndGenreId", "genreId", "getPlayableItemIdsByPlatformIdAndGenreIdStatically", "getPlayableItemIdsByPlatformIdGenreIdAndVisibility", "getPlayableItemIdsByPlatformIdGenreIdAndVisibilityStatically", "getPlayableItemRandomly", "getPlayableItemRandomlyByAttachedPlatformIdAndVisibilityStatically", "getPlayableItemRandomlyByAttachedPlatformIdStatically", "getPlayableItemRandomlyByVisibility", "getPlayerByIdStatically", "getRecentEventsByEvent", "event", "afterDate", "Ljava/util/Date;", "getRecentEventsByEventStatically", "getRecentPlayableItemRandomly", "getRecentPlayableItemRandomlyByVisibility", "getRecentPlayableItems", "getRecentPlayableItemsStatically", "getSimilarPlayableItems", "withVisibility", "importFavoriteItems", "favoriteItemsShareable", "importPlatform", "platformShareable", "toast", "forceReplace", "Lkotlin/Function1;", "importPlatformFromPegasus", "string", "importPlatformWithDialog", "injectPlayableItemWithMergedInfo", "play", "prettifyTitle", "title", "showDiscIndex", "prettifyTitleWithPreferences", "registerPlayableItemViewedEvent", "removeAllPlayableItemsPreviewMedia", "removePlatform", "deletePlayers", "removePlayableItem", "searchPlayableItemsByKeyword", "ignoreTrivial", "toggleIsPlayableItemCompleted", "toggleIsPlayableItemFavorite", "updatePlatform", "updatePlayableItem", "updatePlayableItemToGenrePair", "updatePlayableItemToGenrePairs", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouLibraryModel extends DaijishouAndroidViewModel {
    public static final Companion Companion = new Companion(null);
    private static final Regex packageNameRegex = new Regex("\\.*-n[\\s]*(.*)/");
    private final CachedBitmapLoader cachedBoxArtBitmapLoader;
    private final CachedBitmapLoader cachedPlatformThumbnailBitmapLoader;
    private final CachedBitmapLoader cachedPlatformWallpaperBitmapLoader;
    private final CachedBitmapLoader cachedSnapshotBitmapLoader;
    private final CachedBitmapLoader cachedTitleBitmapLoader;
    private final DaijishouLibraryRepository daijishouLibraryRepository;
    private final DaijishouPlayerTemplate daijishouPlayerTemplate;
    private final DaijishouApplication.WrappedLogger logger;
    private final ScraperManager scraper;
    private final ExpiringMap<String, PlatformThumbnailsPackIndexJson> urlStringToPlatformThumbnailsPackIndexJsonCache;
    private final ExpiringMap<String, PlatformWallpapersPackIndexJson> urlStringToPlatformWallpapersPackIndexJsonCache;

    public final void convertPlatformIdToShortname() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouLibraryModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.daijishouLibraryRepository = getApplication().getDaijishouLibraryRepository();
        this.scraper = getApplication().getScraperManager();
        this.daijishouPlayerTemplate = new DaijishouPlayerTemplate(application);
        this.logger = getApplication().getLogger();
        this.cachedBoxArtBitmapLoader = getApplication().getCachedBoxArtBitmapLoader();
        this.cachedSnapshotBitmapLoader = getApplication().getCachedSnapshotBitmapLoader();
        this.cachedTitleBitmapLoader = getApplication().getCachedTitleBitmapLoader();
        this.cachedPlatformWallpaperBitmapLoader = getApplication().getCachedPlatformWallpaperBitmapLoader();
        this.cachedPlatformThumbnailBitmapLoader = getApplication().getCachedPlatformThumbnailBitmapLoader();
        ExpiringMap<String, PlatformWallpapersPackIndexJson> expiringMapBuild = ExpiringMap.builder().maxSize(8).expiration(3L, TimeUnit.MINUTES).expirationPolicy(ExpirationPolicy.CREATED).build();
        Intrinsics.checkNotNullExpressionValue(expiringMapBuild, "build(...)");
        this.urlStringToPlatformWallpapersPackIndexJsonCache = expiringMapBuild;
        ExpiringMap<String, PlatformThumbnailsPackIndexJson> expiringMapBuild2 = ExpiringMap.builder().maxSize(8).expiration(3L, TimeUnit.MINUTES).expirationPolicy(ExpirationPolicy.CREATED).build();
        Intrinsics.checkNotNullExpressionValue(expiringMapBuild2, "build(...)");
        this.urlStringToPlatformThumbnailsPackIndexJsonCache = expiringMapBuild2;
    }

    /* JADX INFO: compiled from: DaijishouLibraryModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel$Companion;", "", "()V", "launcherIntent", "Landroid/content/Intent;", "getLauncherIntent", "()Landroid/content/Intent;", "packageNameRegex", "Lkotlin/text/Regex;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Intent getLauncherIntent() {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    public final ScraperManager getScraper() {
        return this.scraper;
    }

    public final CachedBitmapLoader getCachedBoxArtBitmapLoader() {
        return this.cachedBoxArtBitmapLoader;
    }

    public final CachedBitmapLoader getCachedSnapshotBitmapLoader() {
        return this.cachedSnapshotBitmapLoader;
    }

    public final CachedBitmapLoader getCachedTitleBitmapLoader() {
        return this.cachedTitleBitmapLoader;
    }

    public final CachedBitmapLoader getCachedPlatformWallpaperBitmapLoader() {
        return this.cachedPlatformWallpaperBitmapLoader;
    }

    public final CachedBitmapLoader getCachedPlatformThumbnailBitmapLoader() {
        return this.cachedPlatformThumbnailBitmapLoader;
    }

    public final ExpiringMap<String, PlatformWallpapersPackIndexJson> getUrlStringToPlatformWallpapersPackIndexJsonCache() {
        return this.urlStringToPlatformWallpapersPackIndexJsonCache;
    }

    public final String convertAmStartArgumentsToPackageName(String amStartArguments) {
        List<String> groupValues;
        Intrinsics.checkNotNullParameter(amStartArguments, "amStartArguments");
        MatchResult matchResultFind$default = Regex.find$default(packageNameRegex, amStartArguments, 0, 2, null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
            return null;
        }
        return groupValues.get(1);
    }

    public static /* synthetic */ String prettifyTitle$default(DaijishouLibraryModel daijishouLibraryModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return daijishouLibraryModel.prettifyTitle(str, z);
    }

    public final String prettifyTitle(String title, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        return getApplication().prettifyTitle(title, z);
    }

    public final String prettifyTitleWithPreferences(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (!getDefaultSharedPreferences().getBoolean(BooleanPreference.PRETTIFY_TITLES.getKey(), BooleanPreference.PRETTIFY_TITLES.getDefaultValue())) {
            return title;
        }
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue())) {
            return prettifyTitle(title, false);
        }
        return prettifyTitle(title, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensurePlatformsPreviewMediaDirectory(int i) {
        if (i == 0) {
            File file = new File(getApplication().getFilesDir() + "/platform_wallpapers/");
            if (file.exists()) {
                return;
            }
            file.mkdirs();
            return;
        }
        if (i != 1) {
            return;
        }
        File file2 = new File(getApplication().getFilesDir() + "/platform_thumbnails/");
        if (file2.exists()) {
            return;
        }
        file2.mkdirs();
    }

    public final long addPlayableItemToGenrePair(PlayableItemToGenrePairEntity playableItemToGenrePairEntity) {
        Intrinsics.checkNotNullParameter(playableItemToGenrePairEntity, "playableItemToGenrePairEntity");
        return this.daijishouLibraryRepository.addPlayableItemToGenrePair(playableItemToGenrePairEntity);
    }

    public final List<Long> addPlayableItemToGenrePairs(PlayableItemToGenrePairEntity... playableItemToGenrePairEntities) {
        Intrinsics.checkNotNullParameter(playableItemToGenrePairEntities, "playableItemToGenrePairEntities");
        return this.daijishouLibraryRepository.addPlayableItemToGenrePairs((PlayableItemToGenrePairEntity[]) Arrays.copyOf(playableItemToGenrePairEntities, playableItemToGenrePairEntities.length));
    }

    public final void updatePlayableItemToGenrePair(PlayableItemToGenrePairEntity playableItemToGenrePairEntity) {
        Intrinsics.checkNotNullParameter(playableItemToGenrePairEntity, "playableItemToGenrePairEntity");
        this.daijishouLibraryRepository.updatePlayableItemToGenrePair(playableItemToGenrePairEntity);
    }

    public final void updatePlayableItemToGenrePairs(PlayableItemToGenrePairEntity... playableItemToGenrePairEntities) {
        Intrinsics.checkNotNullParameter(playableItemToGenrePairEntities, "playableItemToGenrePairEntities");
        this.daijishouLibraryRepository.updatePlayableItemToGenrePairs((PlayableItemToGenrePairEntity[]) Arrays.copyOf(playableItemToGenrePairEntities, playableItemToGenrePairEntities.length));
    }

    public final void deletePlayableItemToGenrePair(PlayableItemToGenrePairEntity playableItemToGenrePairEntity) {
        Intrinsics.checkNotNullParameter(playableItemToGenrePairEntity, "playableItemToGenrePairEntity");
        this.daijishouLibraryRepository.deletePlayableItemToGenrePair(playableItemToGenrePairEntity);
    }

    public final void deletePlayableItemToGenrePairs(PlayableItemToGenrePairEntity... playableItemToGenrePairEntities) {
        Intrinsics.checkNotNullParameter(playableItemToGenrePairEntities, "playableItemToGenrePairEntities");
        this.daijishouLibraryRepository.deletePlayableItemToGenrePairs((PlayableItemToGenrePairEntity[]) Arrays.copyOf(playableItemToGenrePairEntities, playableItemToGenrePairEntities.length));
    }

    public final void deletePlayableItemToGenrePairsByGenreId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        this.daijishouLibraryRepository.deletePlayableItemToGenrePairsByGenreId(id2);
    }

    public final void deletePlayableItemToGenrePairsByPlayableItemId(long j) {
        this.daijishouLibraryRepository.deletePlayableItemToGenrePairsByPlayableItemId(j);
    }

    public final void deleteAllPlayableItemToGenrePairs() {
        this.daijishouLibraryRepository.deleteAllPlayableItemToGenrePairs();
    }

    public final LiveData<List<String>> getAllGenreIds() {
        return this.daijishouLibraryRepository.getAllGenreIds();
    }

    public final List<String> getAllGenreIdsStatically() {
        return this.daijishouLibraryRepository.getAllGenreIdsStatically();
    }

    public final LiveData<List<String>> getGenreIdsByPlayableItemId(long j) {
        return this.daijishouLibraryRepository.getGenreIdsByPlayableItemId(j);
    }

    public final List<String> getGenreIdsByPlayableItemIdStatically(long j) {
        return this.daijishouLibraryRepository.getGenreIdsByPlayableItemIdStatically(j);
    }

    public final LiveData<List<String>> getGenreIdsByPlatformId(long j) {
        return this.daijishouLibraryRepository.getGenreIdsByPlatformId(j);
    }

    public final List<String> getGenreIdsByPlatformIdStatically(long j) {
        return this.daijishouLibraryRepository.getGenreIdsByPlatformIdStatically(j);
    }

    public static /* synthetic */ LiveData getGenreIdsByPlatformIdAndVisibility$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getGenreIdsByPlatformIdAndVisibility(j, z);
    }

    public final LiveData<List<String>> getGenreIdsByPlatformIdAndVisibility(long j, boolean z) {
        return this.daijishouLibraryRepository.getGenreIdsByPlatformIdAndVisibility(j, z);
    }

    public static /* synthetic */ List getGenreIdsByPlatformIdAndVisibilityStatically$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getGenreIdsByPlatformIdAndVisibilityStatically(j, z);
    }

    public final List<String> getGenreIdsByPlatformIdAndVisibilityStatically(long j, boolean z) {
        return this.daijishouLibraryRepository.getGenreIdsByPlatformIdAndVisibilityStatically(j, z);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemIdsByPlatformIdAndGenreId(long j, String genreId) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        return this.daijishouLibraryRepository.getPlayableItemsByPlatformIdAndGenreId(j, genreId);
    }

    public final List<PlayableItemEntity> getPlayableItemIdsByPlatformIdAndGenreIdStatically(long j, String genreId) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        return this.daijishouLibraryRepository.getPlayableItemsByPlatformIdAndGenreIdStatically(j, genreId);
    }

    public static /* synthetic */ LiveData getPlayableItemIdsByPlatformIdGenreIdAndVisibility$default(DaijishouLibraryModel daijishouLibraryModel, long j, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getPlayableItemIdsByPlatformIdGenreIdAndVisibility(j, str, z);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemIdsByPlatformIdGenreIdAndVisibility(long j, String genreId, boolean z) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        return this.daijishouLibraryRepository.getPlayableItemsByPlatformIdGenreIdAndVisibility(j, genreId, z);
    }

    public static /* synthetic */ List getPlayableItemIdsByPlatformIdGenreIdAndVisibilityStatically$default(DaijishouLibraryModel daijishouLibraryModel, long j, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getPlayableItemIdsByPlatformIdGenreIdAndVisibilityStatically(j, str, z);
    }

    public final List<PlayableItemEntity> getPlayableItemIdsByPlatformIdGenreIdAndVisibilityStatically(long j, String genreId, boolean z) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        return this.daijishouLibraryRepository.getPlayableItemsByPlatformIdGenreIdAndVisibilityStatically(j, genreId, z);
    }

    public final void deleteAllEvents() {
        this.daijishouLibraryRepository.deleteAllEvents();
    }

    public final void registerPlayableItemViewedEvent(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        this.daijishouLibraryRepository.addEvent(new EventEntity(0L, 2, null, Long.valueOf(playableItemEntity.getId()), null, null, null, null, 245, null));
    }

    public final void deleteAllEventsByPlayableItemId(long j) {
        this.daijishouLibraryRepository.deleteAllEventsByPlayableItemId(j);
    }

    public final LiveData<Integer> getAllEventsCount() {
        return this.daijishouLibraryRepository.countAllEvents();
    }

    public final int getAllEventsCountStatically() {
        return this.daijishouLibraryRepository.countAllEventsStatically();
    }

    public final LiveData<EventEntity> getLatestEvent() {
        return this.daijishouLibraryRepository.getLatestEvent();
    }

    public final EventEntity getLatestEventStatically() {
        return this.daijishouLibraryRepository.getLatestEventStatically();
    }

    public static /* synthetic */ LiveData getRecentEventsByEvent$default(DaijishouLibraryModel daijishouLibraryModel, int i, Date date, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = CategoryWidgetViewModel.LIMIT;
        }
        return daijishouLibraryModel.getRecentEventsByEvent(i, date, i2);
    }

    public final LiveData<List<EventEntity>> getRecentEventsByEvent(int i, Date afterDate, int i2) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.daijishouLibraryRepository.getRecentEventsByEvent(i, afterDate, i2);
    }

    public static /* synthetic */ List getRecentEventsByEventStatically$default(DaijishouLibraryModel daijishouLibraryModel, int i, Date date, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = CategoryWidgetViewModel.LIMIT;
        }
        return daijishouLibraryModel.getRecentEventsByEventStatically(i, date, i2);
    }

    public final List<EventEntity> getRecentEventsByEventStatically(int i, Date afterDate, int i2) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.daijishouLibraryRepository.getRecentEventsByEventStatically(i, afterDate, i2);
    }

    public final void applyPlatformPreviewMediaIndexJsonToPlatformWithCurrentSettings(PlatformEntity platformEntity, int i) {
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        if (i == 0) {
            if (platformEntity.getWallpaperPath() != null || (string = getDefaultSharedPreferences().getString(StringPreference.SELECTED_PLATFORM_WALLPAPERS_PACK_URL_STRING.getKey(), StringPreference.SELECTED_PLATFORM_WALLPAPERS_PACK_URL_STRING.getDefaultValue())) == null) {
                return;
            }
            applyPlatformPreviewMediaPackIndexJsonToPlatform$default(this, platformEntity, string, i, null, 8, null);
            return;
        }
        if (i == 1 && platformEntity.getThumbnailPath() == null && (string2 = getDefaultSharedPreferences().getString(StringPreference.SELECTED_PLATFORM_THUMBNAILS_PACK_URL_STRING.getKey(), StringPreference.SELECTED_PLATFORM_THUMBNAILS_PACK_URL_STRING.getDefaultValue())) != null) {
            applyPlatformPreviewMediaPackIndexJsonToPlatform$default(this, platformEntity, string2, i, null, 8, null);
        }
    }

    public final long addPlatform(PlatformEntity platformEntity) {
        String wallpaperPath;
        Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        PlatformEntity platformByIdStatically = getPlatformByIdStatically(platformEntity.getId());
        if (platformByIdStatically != null && (wallpaperPath = platformByIdStatically.getWallpaperPath()) != null) {
            this.cachedPlatformWallpaperBitmapLoader.remove(wallpaperPath);
        }
        long jAddPlatform = this.daijishouLibraryRepository.addPlatform(platformEntity);
        PlatformEntity platformByIdStatically2 = getPlatformByIdStatically(jAddPlatform);
        if (platformByIdStatically2 != null) {
            applyPlatformPreviewMediaIndexJsonToPlatformWithCurrentSettings(platformByIdStatically2, 0);
            applyPlatformPreviewMediaIndexJsonToPlatformWithCurrentSettings(platformByIdStatically2, 1);
        }
        return jAddPlatform;
    }

    public final void updatePlatform(PlatformEntity platformEntity) {
        String wallpaperPath;
        Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        PlatformEntity platformByIdStatically = getPlatformByIdStatically(platformEntity.getId());
        if (platformByIdStatically != null && (wallpaperPath = platformByIdStatically.getWallpaperPath()) != null) {
            this.cachedPlatformWallpaperBitmapLoader.remove(wallpaperPath);
        }
        this.daijishouLibraryRepository.updatePlatform(platformEntity);
    }

    public static /* synthetic */ void removePlatform$default(DaijishouLibraryModel daijishouLibraryModel, PlatformEntity platformEntity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        daijishouLibraryModel.removePlatform(platformEntity, z);
    }

    public final void removePlatform(PlatformEntity platformEntity, boolean z) {
        Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        this.daijishouLibraryRepository.removePlatform(platformEntity, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void importPlatform$default(DaijishouLibraryModel daijishouLibraryModel, PlatformShareable platformShareable, boolean z, boolean z2, Activity activity, Function1 function1, int i, Object obj) throws Exception {
        if ((i & 2) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 4) != 0) {
            z2 = false;
        }
        daijishouLibraryModel.importPlatform(platformShareable, z3, z2, (i & 8) != 0 ? null : activity, (i & 16) != 0 ? null : function1);
    }

    public final void importPlatform(PlatformShareable platformShareable, boolean z, boolean z2, Activity activity, final Function1<? super PlatformEntity, Unit> function1) throws Exception {
        Intrinsics.checkNotNullParameter(platformShareable, "platformShareable");
        this.daijishouLibraryRepository.importPlatform(platformShareable, z, z2, activity, new Function1<PlatformEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel.importPlatform.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
                invoke2(platformEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlatformEntity platformEntity) {
                if (platformEntity != null) {
                    DaijishouLibraryModel daijishouLibraryModel = this;
                    daijishouLibraryModel.applyPlatformPreviewMediaIndexJsonToPlatformWithCurrentSettings(platformEntity, 0);
                    daijishouLibraryModel.applyPlatformPreviewMediaIndexJsonToPlatformWithCurrentSettings(platformEntity, 1);
                }
                Function1<PlatformEntity, Unit> function2 = function1;
                if (function2 != null) {
                    function2.invoke(platformEntity);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void importPlatformWithDialog$default(DaijishouLibraryModel daijishouLibraryModel, Activity activity, PlatformShareable platformShareable, Function1 function1, int i, Object obj) throws Exception {
        if ((i & 4) != 0) {
            function1 = null;
        }
        daijishouLibraryModel.importPlatformWithDialog(activity, platformShareable, function1);
    }

    public final void importPlatformWithDialog(Activity activity, PlatformShareable platformShareable, final Function1<? super PlatformEntity, Unit> function1) throws Exception {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(platformShareable, "platformShareable");
        this.daijishouLibraryRepository.importPlatformWithDialog(activity, platformShareable, new Function1<PlatformEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel.importPlatformWithDialog.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
                invoke2(platformEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlatformEntity platformEntity) {
                if (platformEntity != null) {
                    DaijishouLibraryModel daijishouLibraryModel = this;
                    daijishouLibraryModel.getApplication().getLogger().debug(daijishouLibraryModel, "importPlatformWithDialogCallback");
                    daijishouLibraryModel.applyPlatformPreviewMediaIndexJsonToPlatformWithCurrentSettings(platformEntity, 0);
                    daijishouLibraryModel.applyPlatformPreviewMediaIndexJsonToPlatformWithCurrentSettings(platformEntity, 1);
                }
                Function1<PlatformEntity, Unit> function2 = function1;
                if (function2 != null) {
                    function2.invoke(platformEntity);
                }
            }
        });
    }

    public final void importPlatformFromPegasus(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.daijishouLibraryRepository.importPlatformFromPegasus(string);
        Unit unit = Unit.INSTANCE;
    }

    public final void importFavoriteItems(FavoriteItemsShareable favoriteItemsShareable) {
        Intrinsics.checkNotNullParameter(favoriteItemsShareable, "favoriteItemsShareable");
        List<String> playableItemLazyMd5List = favoriteItemsShareable.getPlayableItemLazyMd5List();
        int size = favoriteItemsShareable.getPlayableItemLazyMd5List().size();
        DaijishouLibraryRepository daijishouLibraryRepository = this.daijishouLibraryRepository;
        String[] strArr = (String[]) playableItemLazyMd5List.toArray(new String[0]);
        List<PlayableItemEntity> playableItemsByMd5ListStatically = daijishouLibraryRepository.getPlayableItemsByMd5ListStatically((String[]) Arrays.copyOf(strArr, strArr.length));
        int i = 0;
        int i2 = 0;
        for (PlayableItemEntity playableItemEntity : playableItemsByMd5ListStatically) {
            if (playableItemEntity.isFavorite()) {
                i2++;
            } else {
                playableItemEntity.setFavorite(true);
                i++;
            }
        }
        DaijishouLibraryRepository daijishouLibraryRepository2 = this.daijishouLibraryRepository;
        PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) playableItemsByMd5ListStatically.toArray(new PlayableItemEntity[0]);
        daijishouLibraryRepository2.updatePlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
        Toast.makeText(getApplication(), "Favorited " + i + " items. " + i2 + " items already favorited. " + (size - (i + i2)) + " items not existed in the library.", 1).show();
    }

    public final PlatformShareable exportPlatform(PlatformEntity platformEntity) {
        Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        List<Long> playerIdList = platformEntity.getPlayerIdList();
        PlatformEntityPortable platformEntityPortable = new PlatformEntityPortable(platformEntity.getName(), platformEntity.getUniqueId(), platformEntity.getShortname(), platformEntity.getDescription(), platformEntity.getAcceptedFilenameRegex(), platformEntity.getScraperSourceList(), platformEntity.getBoxArtAspectRatioId(), platformEntity.getUseCustomBoxArtAspectRatio(), platformEntity.getCustomBoxArtAspectRatio(), platformEntity.getScreenAspectRatioId(), platformEntity.getUseCustomScreenAspectRatio(), platformEntity.getCustomScreenAspectRatio(), (List) null, platformEntity.getExtra(), 4096, (DefaultConstructorMarker) null);
        int size = playerIdList.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            PlayerEntity playerByIdStatically = this.daijishouLibraryRepository.getPlayerByIdStatically(playerIdList.get(i).longValue());
            arrayList.add(playerByIdStatically == null ? null : new PlayerEntityPortable(playerByIdStatically.getName(), playerByIdStatically.getUniqueId(), playerByIdStatically.getDescription(), playerByIdStatically.getAcceptedFilenameRegex(), playerByIdStatically.getAmStartArguments(), playerByIdStatically.getKillPackageProcesses(), playerByIdStatically.getKillPackageProcessesWarning(), playerByIdStatically.getExtra()));
        }
        ArrayList arrayList2 = arrayList;
        Collections.swap(arrayList2, playerIdList.indexOf(Long.valueOf(platformEntity.getDefaultPlayerId())), 0);
        return new PlatformShareable(20, platformEntityPortable, CollectionsKt.filterNotNull(arrayList2));
    }

    public final FavoriteItemsShareable exportPlatformFavoriteItems(PlatformEntity platformEntity) {
        Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        List favoritePlayableItemsByAttachedPlatformIdStatically$default = DaijishouLibraryRepository.getFavoritePlayableItemsByAttachedPlatformIdStatically$default(this.daijishouLibraryRepository, platformEntity.getId(), 0, 2, null);
        int size = favoritePlayableItemsByAttachedPlatformIdStatically$default.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((PlayableItemEntity) favoritePlayableItemsByAttachedPlatformIdStatically$default.get(i)).getMd5());
        }
        return new FavoriteItemsShareable(20, arrayList);
    }

    public final LiveData<Integer> getAllPlatformsCount() {
        return this.daijishouLibraryRepository.countAllPlatforms();
    }

    public final LiveData<List<PlatformEntity>> getAllPlatforms() {
        return this.daijishouLibraryRepository.getAllPlatforms();
    }

    public final List<PlatformEntity> getAllPlatformsStatically() {
        return this.daijishouLibraryRepository.getAllPlatformsStatically();
    }

    public final LiveData<List<PlatformEntity>> getAllVisiblePlatformsOrderedByShortName() {
        return this.daijishouLibraryRepository.getAllVisiblePlatformsOrderedByShortName();
    }

    public final List<PlatformEntity> getAllVisiblePlatformsOrderedByShortNameStatically() {
        return this.daijishouLibraryRepository.getAllVisiblePlatformsOrderedByShortNameStatically();
    }

    public final LiveData<PlatformEntity> getPlatformById(long j) {
        return this.daijishouLibraryRepository.getPlatformById(j);
    }

    public final PlatformEntity getPlatformByIdStatically(long j) {
        return this.daijishouLibraryRepository.getPlatformByIdStatically(j);
    }

    public final LiveData<PlatformEntity> getPlatformByShortName(String shortname) {
        Intrinsics.checkNotNullParameter(shortname, "shortname");
        return this.daijishouLibraryRepository.getPlatformByShortname(shortname);
    }

    public final PlatformEntity getPlatformByShortNameStatically(String shortname) {
        Intrinsics.checkNotNullParameter(shortname, "shortname");
        return this.daijishouLibraryRepository.getPlatformByShortnameStatically(shortname);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DaijishouLibraryModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1", f = "DaijishouLibraryModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $callback;
        final /* synthetic */ PlatformEntity $platformEntity;
        final /* synthetic */ String $platformPreviewMediaPackUrlString;
        final /* synthetic */ int $previewMediaType;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DaijishouLibraryModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01181(int i, DaijishouLibraryModel daijishouLibraryModel, String str, Function0<Unit> function0, PlatformEntity platformEntity, Continuation<? super C01181> continuation) {
            super(2, continuation);
            this.$previewMediaType = i;
            this.this$0 = daijishouLibraryModel;
            this.$platformPreviewMediaPackUrlString = str;
            this.$callback = function0;
            this.$platformEntity = platformEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01181 c01181 = new C01181(this.$previewMediaType, this.this$0, this.$platformPreviewMediaPackUrlString, this.$callback, this.$platformEntity, continuation);
            c01181.L$0 = obj;
            return c01181;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            T t;
            T t2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            int i = this.$previewMediaType;
            if (i == 0) {
                this.this$0.ensurePlatformsPreviewMediaDirectory(0);
                try {
                    if (this.this$0.getUrlStringToPlatformWallpapersPackIndexJsonCache().keySet().contains(this.$platformPreviewMediaPackUrlString)) {
                        Object obj2 = this.this$0.getUrlStringToPlatformWallpapersPackIndexJsonCache().get(this.$platformPreviewMediaPackUrlString);
                        Intrinsics.checkNotNull(obj2);
                        t2 = (PlatformWallpapersPackIndexJson) obj2;
                    } else {
                        PlatformWallpapersPackIndexJson platformWallpapersPackIndexJson = (PlatformWallpapersPackIndexJson) this.this$0.getApplication().getWeakJson().decodeFromString(PlatformWallpapersPackIndexJson.Companion.serializer(), Utils.INSTANCE.readEntireTextFromURL(this.$platformPreviewMediaPackUrlString + "index.json"));
                        this.this$0.getUrlStringToPlatformWallpapersPackIndexJsonCache().put(this.$platformPreviewMediaPackUrlString, platformWallpapersPackIndexJson);
                        t2 = platformWallpapersPackIndexJson;
                    }
                    objectRef.element = t2;
                } catch (Exception e) {
                    this.this$0.logger.warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                    Function0<Unit> function0 = this.$callback;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    return Unit.INSTANCE;
                }
            } else if (i == 1) {
                this.this$0.ensurePlatformsPreviewMediaDirectory(1);
                try {
                    if (this.this$0.urlStringToPlatformThumbnailsPackIndexJsonCache.keySet().contains(this.$platformPreviewMediaPackUrlString)) {
                        Object obj3 = this.this$0.urlStringToPlatformThumbnailsPackIndexJsonCache.get(this.$platformPreviewMediaPackUrlString);
                        Intrinsics.checkNotNull(obj3);
                        t = (PlatformThumbnailsPackIndexJson) obj3;
                    } else {
                        PlatformThumbnailsPackIndexJson platformThumbnailsPackIndexJson = (PlatformThumbnailsPackIndexJson) this.this$0.getApplication().getWeakJson().decodeFromString(PlatformThumbnailsPackIndexJson.Companion.serializer(), Utils.INSTANCE.readEntireTextFromURL(this.$platformPreviewMediaPackUrlString + "index.json"));
                        this.this$0.urlStringToPlatformThumbnailsPackIndexJsonCache.put(this.$platformPreviewMediaPackUrlString, platformThumbnailsPackIndexJson);
                        t = platformThumbnailsPackIndexJson;
                    }
                    objectRef2.element = t;
                } catch (Exception e2) {
                    this.this$0.logger.warn(coroutineScope, ExceptionsKt.stackTraceToString(e2));
                    Function0<Unit> function1 = this.$callback;
                    if (function1 != null) {
                        function1.invoke();
                    }
                    return Unit.INSTANCE;
                }
            }
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = -1;
            invokeSuspend$nextPreviewMedia(intRef, this.$previewMediaType, objectRef, this.$platformPreviewMediaPackUrlString, this.$callback, this.$platformEntity, objectRef2, this.this$0);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$nextPreviewMedia(final Ref.IntRef intRef, final int i, final Ref.ObjectRef<PlatformWallpapersPackIndexJson> objectRef, final String str, final Function0<Unit> function0, final PlatformEntity platformEntity, final Ref.ObjectRef<PlatformThumbnailsPackIndexJson> objectRef2, final DaijishouLibraryModel daijishouLibraryModel) {
            intRef.element++;
            Ref.IntRef intRef2 = new Ref.IntRef();
            if (i == 0) {
                int i2 = intRef.element;
                PlatformWallpapersPackIndexJson platformWallpapersPackIndexJson = objectRef.element;
                Intrinsics.checkNotNull(platformWallpapersPackIndexJson);
                if (i2 >= platformWallpapersPackIndexJson.getWallpaperList().size()) {
                    if (objectRef.element.getHasDefaultWallpaper()) {
                        invokeSuspend$nextPreviewMedia$tryThisPreviewMedia(intRef2, daijishouLibraryModel, i, platformEntity, str + objectRef.element.getDefaultWallpaperFilename(), new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Function0<Unit> function1 = function0;
                                if (function1 != null) {
                                    function1.invoke();
                                }
                            }
                        }, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Function0<Unit> function1 = function0;
                                if (function1 != null) {
                                    function1.invoke();
                                }
                            }
                        });
                        return;
                    } else {
                        if (function0 != null) {
                            function0.invoke();
                            return;
                        }
                        return;
                    }
                }
                PlatformWallpapersPackIndexWallpaperListItemJson platformWallpapersPackIndexWallpaperListItemJson = objectRef.element.getWallpaperList().get(intRef.element);
                if (Intrinsics.areEqual(platformWallpapersPackIndexWallpaperListItemJson.getMatchPlatformUniqueId(), platformEntity.getUniqueId())) {
                    invokeSuspend$nextPreviewMedia$tryThisPreviewMedia(intRef2, daijishouLibraryModel, i, platformEntity, str + platformWallpapersPackIndexWallpaperListItemJson.getFilename(), new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Function0<Unit> function1 = function0;
                            if (function1 != null) {
                                function1.invoke();
                            }
                        }
                    }, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            DaijishouLibraryModel.C01181.invokeSuspend$nextPreviewMedia(intRef, i, objectRef, str, function0, platformEntity, objectRef2, daijishouLibraryModel);
                        }
                    });
                    return;
                } else {
                    invokeSuspend$nextPreviewMedia(intRef, i, objectRef, str, function0, platformEntity, objectRef2, daijishouLibraryModel);
                    return;
                }
            }
            if (i != 1) {
                return;
            }
            int i3 = intRef.element;
            PlatformThumbnailsPackIndexJson platformThumbnailsPackIndexJson = objectRef2.element;
            Intrinsics.checkNotNull(platformThumbnailsPackIndexJson);
            if (i3 >= platformThumbnailsPackIndexJson.getThumbnailList().size()) {
                if (objectRef2.element.getHasDefaultThumbnail()) {
                    invokeSuspend$nextPreviewMedia$tryThisPreviewMedia(intRef2, daijishouLibraryModel, i, platformEntity, str + objectRef2.element.getDefaultThumbnailFilename(), new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Function0<Unit> function1 = function0;
                            if (function1 != null) {
                                function1.invoke();
                            }
                        }
                    }, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Function0<Unit> function1 = function0;
                            if (function1 != null) {
                                function1.invoke();
                            }
                        }
                    });
                    return;
                } else {
                    if (function0 != null) {
                        function0.invoke();
                        return;
                    }
                    return;
                }
            }
            PlatformThumbnailsPackIndexThumbnailListItemJson platformThumbnailsPackIndexThumbnailListItemJson = objectRef2.element.getThumbnailList().get(intRef.element);
            if (Intrinsics.areEqual(platformThumbnailsPackIndexThumbnailListItemJson.getMatchPlatformUniqueId(), platformEntity.getUniqueId())) {
                invokeSuspend$nextPreviewMedia$tryThisPreviewMedia(intRef2, daijishouLibraryModel, i, platformEntity, str + platformThumbnailsPackIndexThumbnailListItemJson.getFilename(), new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function0<Unit> function1 = function0;
                        if (function1 != null) {
                            function1.invoke();
                        }
                    }
                }, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DaijishouLibraryModel.C01181.invokeSuspend$nextPreviewMedia(intRef, i, objectRef, str, function0, platformEntity, objectRef2, daijishouLibraryModel);
                    }
                });
            } else {
                invokeSuspend$nextPreviewMedia(intRef, i, objectRef, str, function0, platformEntity, objectRef2, daijishouLibraryModel);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$nextPreviewMedia$tryThisPreviewMedia(final Ref.IntRef intRef, final DaijishouLibraryModel daijishouLibraryModel, final int i, final PlatformEntity platformEntity, final String str, final Function0<Unit> function0, final Function0<Unit> function1) {
            if (intRef.element >= 3) {
                function1.invoke();
            } else {
                intRef.element++;
                Glide.with(daijishouLibraryModel.getApplication()).asBitmap().load(str).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(new CustomTarget<Bitmap>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$tryThisPreviewMedia$1
                    public void onLoadCleared(Drawable drawable) {
                    }

                    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                    }

                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                        try {
                            int i2 = i;
                            if (i2 == 0) {
                                String str2 = daijishouLibraryModel.getApplication().getFilesDir() + "/platform_wallpapers/" + platformEntity.getId() + ".png";
                                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                                Bitmap resizedBitmap = ScraperUtilsKt.getResizedBitmap(bitmap, 720);
                                Intrinsics.checkNotNull(resizedBitmap);
                                resizedBitmap.compress(Constants.INSTANCE.getPlatformWallpaperFormat(), 100, fileOutputStream);
                                platformEntity.setWallpaperPath(str2);
                            } else if (i2 == 1) {
                                String str3 = daijishouLibraryModel.getApplication().getFilesDir() + "/platform_thumbnails/" + platformEntity.getId() + ".png";
                                FileOutputStream fileOutputStream2 = new FileOutputStream(str3);
                                Bitmap resizedBitmap2 = ScraperUtilsKt.getResizedBitmap(bitmap, 240);
                                Intrinsics.checkNotNull(resizedBitmap2);
                                resizedBitmap2.compress(Constants.INSTANCE.getPlatformThumbnailFormat(), 100, fileOutputStream2);
                                platformEntity.setThumbnailPath(str3);
                            }
                            daijishouLibraryModel.updatePlatform(platformEntity);
                        } catch (IOException e) {
                            daijishouLibraryModel.logger.warn(this, ExceptionsKt.stackTraceToString(e));
                        }
                        function0.invoke();
                    }

                    public void onLoadFailed(Drawable drawable) {
                        super.onLoadFailed(drawable);
                        DaijishouLibraryModel.C01181.invokeSuspend$nextPreviewMedia$tryThisPreviewMedia(intRef, daijishouLibraryModel, i, platformEntity, str, function0, function1);
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void applyPlatformPreviewMediaPackIndexJsonToPlatform$default(DaijishouLibraryModel daijishouLibraryModel, PlatformEntity platformEntity, String str, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function0 = null;
        }
        daijishouLibraryModel.applyPlatformPreviewMediaPackIndexJsonToPlatform(platformEntity, str, i, function0);
    }

    public final void applyPlatformPreviewMediaPackIndexJsonToPlatform(PlatformEntity platformEntity, String platformPreviewMediaPackUrlString, int i, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        Intrinsics.checkNotNullParameter(platformPreviewMediaPackUrlString, "platformPreviewMediaPackUrlString");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new C01181(i, this, platformPreviewMediaPackUrlString, function0, platformEntity, null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1, reason: invalid class name */
    /* JADX INFO: compiled from: DaijishouLibraryModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1", f = "DaijishouLibraryModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Boolean, Integer, Unit> $callback;
        final /* synthetic */ String $platformPreviewMediaPackUrlString;
        final /* synthetic */ int $previewMediaType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(int i, String str, Function2<? super Boolean, ? super Integer, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$previewMediaType = i;
            this.$platformPreviewMediaPackUrlString = str;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DaijishouLibraryModel.this.new AnonymousClass1(this.$previewMediaType, this.$platformPreviewMediaPackUrlString, this.$callback, continuation);
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
            List<PlatformEntity> allPlatformsStatically = DaijishouLibraryModel.this.getAllPlatformsStatically();
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = -1;
            invokeSuspend$nextPlatform(intRef, allPlatformsStatically, DaijishouLibraryModel.this, this.$previewMediaType, this.$platformPreviewMediaPackUrlString, this.$callback);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$nextPlatform(final Ref.IntRef intRef, final List<PlatformEntity> list, final DaijishouLibraryModel daijishouLibraryModel, final int i, final String str, final Function2<? super Boolean, ? super Integer, Unit> function2) {
            intRef.element++;
            if (intRef.element >= list.size()) {
                BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) daijishouLibraryModel), Dispatchers.getMain(), (CoroutineStart) null, new DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1$nextPlatform$1(function2, null), 2, (Object) null);
                return;
            }
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) daijishouLibraryModel), Dispatchers.getMain(), (CoroutineStart) null, new DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1$nextPlatform$2(function2, intRef, list, null), 2, (Object) null);
            PlatformEntity platformEntity = list.get(intRef.element);
            if (i == 0) {
                daijishouLibraryModel.applyPlatformPreviewMediaPackIndexJsonToPlatform(platformEntity, str, i, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1$nextPlatform$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DaijishouLibraryModel.AnonymousClass1.invokeSuspend$nextPlatform(intRef, list, daijishouLibraryModel, i, str, function2);
                    }
                });
            } else {
                if (i != 1) {
                    return;
                }
                daijishouLibraryModel.applyPlatformPreviewMediaPackIndexJsonToPlatform(platformEntity, str, i, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1$nextPlatform$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DaijishouLibraryModel.AnonymousClass1.invokeSuspend$nextPlatform(intRef, list, daijishouLibraryModel, i, str, function2);
                    }
                });
            }
        }
    }

    public final void applyPlatformPreviewMediaPackIndexJsonToAllPlatforms(String platformPreviewMediaPackUrlString, int i, Function2<? super Boolean, ? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(platformPreviewMediaPackUrlString, "platformPreviewMediaPackUrlString");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(i, platformPreviewMediaPackUrlString, callback, null), 2, (Object) null);
    }

    public final long addPlayer(PlayerEntity playerEntity) {
        Intrinsics.checkNotNullParameter(playerEntity, "playerEntity");
        return this.daijishouLibraryRepository.addPlayer(playerEntity);
    }

    public final void deletePlayer(PlayerEntity playerEntity) {
        Intrinsics.checkNotNullParameter(playerEntity, "playerEntity");
        this.daijishouLibraryRepository.deletePlayer(playerEntity);
    }

    public final LiveData<Integer> getAllPlayersCount() {
        return this.daijishouLibraryRepository.countAllPlayers();
    }

    public final LiveData<List<PlayerEntity>> getAllPlayers() {
        return this.daijishouLibraryRepository.getAllPlayers();
    }

    public final List<PlayerEntity> getAllPlayersStatically() {
        return this.daijishouLibraryRepository.getAllPlayersStatically();
    }

    public final PlayerEntity getPlayerByIdStatically(long j) {
        return this.daijishouLibraryRepository.getPlayerByIdStatically(j);
    }

    public final void updatePlayableItem(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        this.daijishouLibraryRepository.updatePlayableItem(playableItemEntity);
    }

    public final void removePlayableItem(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        this.daijishouLibraryRepository.removePlayableItem(playableItemEntity);
    }

    public final void removeAllPlayableItemsPreviewMedia() {
        this.daijishouLibraryRepository.removeAllPlayableItemsPreviewMediaAndRelations();
    }

    public final PlayableItemEntity toggleIsPlayableItemFavorite(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        PlayableItemEntity playableItemEntityCopy$default = PlayableItemEntity.copy$default(playableItemEntity, 0L, null, false, false, null, 0, null, false, null, null, false, false, false, false, null, null, null, null, null, null, false, null, 0, null, null, false, false, null, 268435455, null);
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue()) && playableItemEntity.getDisjointSetPrimaryPlayableItemId() != null) {
            injectPlayableItemWithMergedInfo(playableItemEntityCopy$default);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = playableItemEntityCopy$default.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds().iterator();
            while (it.hasNext()) {
                PlayableItemEntity playableItemByIdStatically = this.daijishouLibraryRepository.getPlayableItemByIdStatically(((Number) it.next()).longValue());
                if (playableItemByIdStatically != null) {
                    playableItemByIdStatically.setFavorite(!playableItemEntityCopy$default.getMergedInfo().getMergedIsFavorite());
                    arrayList.add(playableItemByIdStatically);
                }
            }
            DaijishouLibraryRepository daijishouLibraryRepository = this.daijishouLibraryRepository;
            PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) arrayList.toArray(new PlayableItemEntity[0]);
            daijishouLibraryRepository.updatePlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
            playableItemEntityCopy$default.setFavorite(!playableItemEntityCopy$default.getMergedInfo().getMergedIsFavorite());
            playableItemEntityCopy$default.getMergedInfo().setMergedIsFavorite(!playableItemEntityCopy$default.getMergedInfo().getMergedIsFavorite());
            return playableItemEntityCopy$default;
        }
        playableItemEntityCopy$default.setFavorite(!playableItemEntityCopy$default.isFavorite());
        this.daijishouLibraryRepository.updatePlayableItem(playableItemEntityCopy$default);
        return playableItemEntityCopy$default;
    }

    public final PlayableItemEntity toggleIsPlayableItemCompleted(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        PlayableItemEntity playableItemEntityCopy$default = PlayableItemEntity.copy$default(playableItemEntity, 0L, null, false, false, null, 0, null, false, null, null, false, false, false, false, null, null, null, null, null, null, false, null, 0, null, null, false, false, null, 268435455, null);
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue()) && playableItemEntity.getDisjointSetPrimaryPlayableItemId() != null) {
            injectPlayableItemWithMergedInfo(playableItemEntityCopy$default);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = playableItemEntityCopy$default.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds().iterator();
            while (it.hasNext()) {
                PlayableItemEntity playableItemByIdStatically = this.daijishouLibraryRepository.getPlayableItemByIdStatically(((Number) it.next()).longValue());
                if (playableItemByIdStatically != null) {
                    playableItemByIdStatically.setCompleted(!playableItemEntityCopy$default.getMergedInfo().getMergedIsCompleted());
                    arrayList.add(playableItemByIdStatically);
                }
            }
            DaijishouLibraryRepository daijishouLibraryRepository = this.daijishouLibraryRepository;
            PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) arrayList.toArray(new PlayableItemEntity[0]);
            daijishouLibraryRepository.updatePlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
            playableItemEntityCopy$default.setCompleted(!playableItemEntityCopy$default.getMergedInfo().getMergedIsCompleted());
            playableItemEntityCopy$default.getMergedInfo().setMergedIsCompleted(!playableItemEntityCopy$default.getMergedInfo().getMergedIsCompleted());
            return playableItemEntityCopy$default;
        }
        playableItemEntityCopy$default.setCompleted(!playableItemEntityCopy$default.isCompleted());
        this.daijishouLibraryRepository.updatePlayableItem(playableItemEntityCopy$default);
        return playableItemEntityCopy$default;
    }

    public final void disableAllPlayableItemsCustomPlayer() {
        this.daijishouLibraryRepository.disableAllPlayableItemsCustomPlayer();
    }

    public final int clearAllDisjointedPlayableItems() {
        return this.daijishouLibraryRepository.clearAllDisjointedPlayableItems();
    }

    public final int clearAllDisjointedPlayableItemsByAttachedPlatformId(long j) {
        return this.daijishouLibraryRepository.clearAllDisjointedPlayableItemsByAttachedPlatformId(j);
    }

    public final void editPlayableItem(Activity activity, PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        final AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
        if (playableItemEntity.getDisjointSetPrimaryPlayableItemId() == null || !getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue())) {
            editPlayableItem$editPlayableItemEntity(appCompatActivity, playableItemEntity);
            return;
        }
        DaijishouLibraryRepository daijishouLibraryRepository = this.daijishouLibraryRepository;
        Long disjointSetPrimaryPlayableItemId = playableItemEntity.getDisjointSetPrimaryPlayableItemId();
        Intrinsics.checkNotNull(disjointSetPrimaryPlayableItemId);
        final List<PlayableItemEntity> playableItemsByDisjointSetPrimaryPlayableItemIdStatically = daijishouLibraryRepository.getPlayableItemsByDisjointSetPrimaryPlayableItemIdStatically(disjointSetPrimaryPlayableItemId.longValue());
        if (playableItemsByDisjointSetPrimaryPlayableItemIdStatically.size() == 1) {
            editPlayableItem$editPlayableItemEntity(appCompatActivity, playableItemEntity);
            return;
        }
        ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.Companion;
        String string = getApplication().getString(R.string.select_a_playable_item);
        int size = playableItemsByDisjointSetPrimaryPlayableItemIdStatically.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(playableItemsByDisjointSetPrimaryPlayableItemIdStatically.get(i).getName());
        }
        ListSelectDialogFragment.Companion.newInstance$default(companion, string, new ArrayList(arrayList), null, false, 12, null).setOnSelectListener(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel.editPlayableItem.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                DaijishouLibraryModel.editPlayableItem$editPlayableItemEntity(appCompatActivity, playableItemsByDisjointSetPrimaryPlayableItemIdStatically.get(i2));
            }
        }).setOnCancelListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel.editPlayableItem.3
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }).show(appCompatActivity.getSupportFragmentManager(), ListSelectDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void editPlayableItem$editPlayableItemEntity(AppCompatActivity appCompatActivity, PlayableItemEntity playableItemEntity) {
        EditPlayableItemDialogFragment.Companion.newInstance(playableItemEntity).show(appCompatActivity.getSupportFragmentManager(), EditPlayableItemDialogFragment.class.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void play$default(DaijishouLibraryModel daijishouLibraryModel, Activity activity, PlayableItemEntity playableItemEntity, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        daijishouLibraryModel.play(activity, playableItemEntity, function1);
    }

    public final void play(final Activity activity, PlayableItemEntity playableItemEntity, final Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        final AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
        if (playableItemEntity.getDisjointSetPrimaryPlayableItemId() == null || !getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue())) {
            play$playPlayableItem(function1, this, activity, appCompatActivity, playableItemEntity);
            return;
        }
        DaijishouLibraryRepository daijishouLibraryRepository = this.daijishouLibraryRepository;
        Long disjointSetPrimaryPlayableItemId = playableItemEntity.getDisjointSetPrimaryPlayableItemId();
        Intrinsics.checkNotNull(disjointSetPrimaryPlayableItemId);
        final List<PlayableItemEntity> playableItemsByDisjointSetPrimaryPlayableItemIdStatically = daijishouLibraryRepository.getPlayableItemsByDisjointSetPrimaryPlayableItemIdStatically(disjointSetPrimaryPlayableItemId.longValue());
        if (playableItemsByDisjointSetPrimaryPlayableItemIdStatically.size() == 1) {
            play$playPlayableItem(function1, this, activity, appCompatActivity, playableItemEntity);
            return;
        }
        ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.Companion;
        String string = getApplication().getString(R.string.select_a_playable_item);
        int size = playableItemsByDisjointSetPrimaryPlayableItemIdStatically.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(playableItemsByDisjointSetPrimaryPlayableItemIdStatically.get(i).getName());
        }
        ListSelectDialogFragment.Companion.newInstance$default(companion, string, new ArrayList(arrayList), null, false, 12, null).setOnSelectListener(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel.play.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                DaijishouLibraryModel.play$playPlayableItem(function1, this, activity, appCompatActivity, playableItemsByDisjointSetPrimaryPlayableItemIdStatically.get(i2));
            }
        }).setOnCancelListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel.play.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function1<Boolean, Unit> function2 = function1;
                if (function2 != null) {
                    function2.invoke(false);
                }
            }
        }).show(appCompatActivity.getSupportFragmentManager(), ListSelectDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:58:0x01de  */
    /* JADX WARN: Code duplicated, block: B:60:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:63:0x0204  */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, com.magneticchen.daijishou.data.db.entity.PlayerEntity] */
    public static final void play$playPlayableItem(Function1<? super Boolean, Unit> function1, final DaijishouLibraryModel daijishouLibraryModel, final Activity activity, final AppCompatActivity appCompatActivity, final PlayableItemEntity playableItemEntity) {
        final Context context;
        Exception exc;
        String localizedMessage;
        String strStackTraceToString;
        long defaultPlayerId;
        String lowerCase;
        String lowerCase2;
        MatchResult matchResultFind$default;
        List<String> groupValues;
        final Function1<? super Boolean, Unit> function2 = function1;
        DaijishouLibraryModel daijishouLibraryModel2 = daijishouLibraryModel;
        Long attachedPlatformId = playableItemEntity.getAttachedPlatformId();
        if (attachedPlatformId != null) {
            long jLongValue = attachedPlatformId.longValue();
            Context applicationContext = daijishouLibraryModel2.getApplication().getApplicationContext();
            if (applicationContext != null) {
                Intrinsics.checkNotNull(applicationContext);
                try {
                    PlatformEntity platformByIdStatically = daijishouLibraryModel2.getPlatformByIdStatically(jLongValue);
                    Intrinsics.checkNotNull(platformByIdStatically);
                    if (playableItemEntity.getUseCustomPlayer()) {
                        Long customPlayerId = playableItemEntity.getCustomPlayerId();
                        Intrinsics.checkNotNull(customPlayerId);
                        defaultPlayerId = customPlayerId.longValue();
                    } else {
                        defaultPlayerId = platformByIdStatically.getDefaultPlayerId();
                    }
                    context = applicationContext;
                    try {
                        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        objectRef.element = daijishouLibraryModel2.daijishouLibraryRepository.getPlayerByIdStatically(defaultPlayerId);
                        final String str = (objectRef.element == 0 || (matchResultFind$default = Regex.find$default(packageNameRegex, ((PlayerEntity) objectRef.element).getAmStartArguments(), 0, 2, null)) == null || (groupValues = matchResultFind$default.getGroupValues()) == null) ? null : groupValues.get(1);
                        PackageManager packageManager = daijishouLibraryModel2.getApplication().getPackageManager();
                        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
                        final List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(Companion.getLauncherIntent(), 0);
                        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
                        final boolean zIsUriDaijishouPlayerTemplate = daijishouLibraryModel2.daijishouPlayerTemplate.isUriDaijishouPlayerTemplate(activity, playableItemEntity.getUri());
                        boolean z = playableItemEntity.getPlayableItemType() != 1;
                        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                            try {
                                if (str != null) {
                                    lowerCase = str.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                } else {
                                    lowerCase = null;
                                }
                                String str2 = resolveInfo.activityInfo.packageName;
                                if (str2 != null) {
                                    Intrinsics.checkNotNull(str2);
                                    lowerCase2 = str2.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                } else {
                                    lowerCase2 = null;
                                }
                                if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                                    z = true;
                                }
                                daijishouLibraryModel2 = daijishouLibraryModel;
                                platformByIdStatically = platformByIdStatically;
                            } catch (Exception e) {
                                e = e;
                                daijishouLibraryModel2 = daijishouLibraryModel;
                                exc = e;
                                daijishouLibraryModel2.logger.warn(daijishouLibraryModel2, ExceptionsKt.stackTraceToString(exc));
                                String string = daijishouLibraryModel2.getApplication().getString(R.string.player_error_format);
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                localizedMessage = e.getLocalizedMessage();
                                if (localizedMessage != null) {
                                    strStackTraceToString = ExceptionsKt.stackTraceToString(exc);
                                } else {
                                    strStackTraceToString = ExceptionsKt.stackTraceToString(exc);
                                }
                                String str3 = String.format(string, Arrays.copyOf(new Object[]{strStackTraceToString}, 1));
                                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                                Toast.makeText(context, str3, 0).show();
                                if (function2 != null) {
                                    function2.invoke(false);
                                    return;
                                }
                                return;
                            }
                        }
                        final PlatformEntity platformEntity = platformByIdStatically;
                        if (!z && !zIsUriDaijishouPlayerTemplate) {
                            try {
                                AcknowledgementDialogFragment.Companion companion = AcknowledgementDialogFragment.Companion;
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                String string2 = daijishouLibraryModel.getApplication().getString(R.string.package_format);
                                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                String str4 = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
                                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                                String string3 = daijishouLibraryModel.getApplication().getString(R.string.the_player_is_not_available_warning_format);
                                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                String str5 = String.format(string3, Arrays.copyOf(new Object[]{str}, 1));
                                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                                final String str6 = str;
                                companion.newInstance(str4, str5, daijishouLibraryModel.getApplication().getString(R.string.confirm), daijishouLibraryModel.getApplication().getString(R.string.cancel), daijishouLibraryModel.getApplication().getString(R.string.the_player_is_not_available_warning_detect)).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$play$playPlayableItem$1$1$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str)));
                                        Function1<Boolean, Unit> function3 = function2;
                                        if (function3 != null) {
                                            function3.invoke(false);
                                        }
                                    }
                                }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$play$playPlayableItem$1$1$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        Function1<Boolean, Unit> function3 = function2;
                                        if (function3 != null) {
                                            function3.invoke(false);
                                        }
                                    }
                                }).setOnNeutralButtonClickedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$play$playPlayableItem$1$1$4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        String lowerCase3;
                                        List<Long> playerIdList = platformEntity.getPlayerIdList();
                                        final ArrayList arrayList = new ArrayList();
                                        ArrayList arrayList2 = new ArrayList();
                                        DaijishouLibraryModel daijishouLibraryModel3 = daijishouLibraryModel;
                                        List<ResolveInfo> list = listQueryIntentActivities;
                                        Iterator<T> it = playerIdList.iterator();
                                        while (it.hasNext()) {
                                            PlayerEntity playerByIdStatically = daijishouLibraryModel3.daijishouLibraryRepository.getPlayerByIdStatically(((Number) it.next()).longValue());
                                            if (playerByIdStatically != null) {
                                                String strConvertAmStartArgumentsToPackageName = daijishouLibraryModel3.convertAmStartArgumentsToPackageName(playerByIdStatically.getAmStartArguments());
                                                for (ResolveInfo resolveInfo2 : list) {
                                                    String lowerCase4 = null;
                                                    if (strConvertAmStartArgumentsToPackageName != null) {
                                                        lowerCase3 = strConvertAmStartArgumentsToPackageName.toLowerCase(Locale.ROOT);
                                                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                                    } else {
                                                        lowerCase3 = null;
                                                    }
                                                    String str7 = resolveInfo2.activityInfo.packageName;
                                                    if (str7 != null) {
                                                        Intrinsics.checkNotNull(str7);
                                                        lowerCase4 = str7.toLowerCase(Locale.ROOT);
                                                        Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                                    }
                                                    if (Intrinsics.areEqual(lowerCase3, lowerCase4)) {
                                                        arrayList.add(playerByIdStatically);
                                                        arrayList2.add(playerByIdStatically.getName());
                                                    }
                                                }
                                            }
                                        }
                                        ListSelectDialogFragment listSelectDialogFragmentNewInstance$default = ListSelectDialogFragment.Companion.newInstance$default(ListSelectDialogFragment.Companion, daijishouLibraryModel.getApplication().getString(R.string.available_players), arrayList2, null, false, 12, null);
                                        final PlayableItemEntity playableItemEntity2 = playableItemEntity;
                                        final DaijishouLibraryModel daijishouLibraryModel4 = daijishouLibraryModel;
                                        final PlatformEntity platformEntity2 = platformEntity;
                                        final Ref.ObjectRef<PlayerEntity> objectRef2 = objectRef;
                                        final AppCompatActivity appCompatActivity2 = appCompatActivity;
                                        final String str8 = str6;
                                        final Function1<Boolean, Unit> function3 = function2;
                                        final Context context2 = context;
                                        final boolean z2 = zIsUriDaijishouPlayerTemplate;
                                        ListSelectDialogFragment onSelectListener = listSelectDialogFragmentNewInstance$default.setOnSelectListener(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$play$playPlayableItem$1$1$4.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                                invoke(num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX WARN: Type inference failed for: r10v2, types: [T, com.magneticchen.daijishou.data.db.entity.PlayerEntity] */
                                            public final void invoke(int i) {
                                                PlayerEntity playerEntity = arrayList.get(i);
                                                if (playableItemEntity2.getUseCustomPlayer()) {
                                                    playableItemEntity2.setCustomPlayerId(Long.valueOf(playerEntity.getId()));
                                                    daijishouLibraryModel4.daijishouLibraryRepository.updatePlayableItem(playableItemEntity2);
                                                } else {
                                                    platformEntity2.setDefaultPlayerId(playerEntity.getId());
                                                    daijishouLibraryModel4.daijishouLibraryRepository.updatePlatform(platformEntity2);
                                                }
                                                objectRef2.element = playerEntity;
                                                DaijishouLibraryModel.play$playPlayableItem$lambda$15$lambda$14$playItWithRules(objectRef2, daijishouLibraryModel4, appCompatActivity2, str8, playableItemEntity2, function3, context2, z2);
                                            }
                                        });
                                        final Function1<Boolean, Unit> function4 = function2;
                                        onSelectListener.setOnCancelListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$play$playPlayableItem$1$1$4.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            

                                            @Override // kotlin.jvm.functions.Function0
                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                Function1<Boolean, Unit> function5 = function4;
                                                if (function5 != null) {
                                                    function5.invoke(false);
                                                }
                                            }
                                        }).show(appCompatActivity.getSupportFragmentManager(), ListSelectDialogFragment.class.getName());
                                    }
                                }).show(appCompatActivity.getSupportFragmentManager(), AcknowledgementDialogFragment.class.getName());
                                return;
                            } catch (Exception e2) {
                                e = e2;
                                function2 = function1;
                                daijishouLibraryModel2 = daijishouLibraryModel;
                                exc = e;
                                daijishouLibraryModel2.logger.warn(daijishouLibraryModel2, ExceptionsKt.stackTraceToString(exc));
                                String string4 = daijishouLibraryModel2.getApplication().getString(R.string.player_error_format);
                                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                                localizedMessage = e.getLocalizedMessage();
                                if (localizedMessage != null) {
                                    strStackTraceToString = ExceptionsKt.stackTraceToString(exc);
                                } else {
                                    strStackTraceToString = ExceptionsKt.stackTraceToString(exc);
                                }
                                String str7 = String.format(string4, Arrays.copyOf(new Object[]{strStackTraceToString}, 1));
                                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                Toast.makeText(context, str7, 0).show();
                                if (function2 != null) {
                                    function2.invoke(false);
                                    return;
                                }
                                return;
                            }
                        }
                        function2 = function1;
                        daijishouLibraryModel2 = daijishouLibraryModel;
                        applicationContext = context;
                        play$playPlayableItem$lambda$15$lambda$14$playItWithRules(objectRef, daijishouLibraryModel2, appCompatActivity, str, playableItemEntity, function2, applicationContext, zIsUriDaijishouPlayerTemplate);
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    context = applicationContext;
                }
                exc = e;
                daijishouLibraryModel2.logger.warn(daijishouLibraryModel2, ExceptionsKt.stackTraceToString(exc));
                String string5 = daijishouLibraryModel2.getApplication().getString(R.string.player_error_format);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                localizedMessage = e.getLocalizedMessage();
                if (localizedMessage != null || (strStackTraceToString = localizedMessage.toString()) == null) {
                    strStackTraceToString = ExceptionsKt.stackTraceToString(exc);
                }
                String str8 = String.format(string5, Arrays.copyOf(new Object[]{strStackTraceToString}, 1));
                Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                Toast.makeText(context, str8, 0).show();
                if (function2 != null) {
                    function2.invoke(false);
                    return;
                }
                return;
            }
        }
        if (function2 != null) {
            function2.invoke(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:54:0x01b3 A[Catch: Exception -> 0x02af, TryCatch #0 {Exception -> 0x02af, blocks: (B:3:0x0012, B:6:0x0025, B:7:0x002c, B:9:0x0041, B:11:0x004b, B:14:0x0055, B:15:0x005c, B:17:0x0071, B:28:0x00ac, B:30:0x00b7, B:33:0x00bf, B:34:0x00c6, B:36:0x00fe, B:41:0x0129, B:47:0x013f, B:49:0x014d, B:59:0x026d, B:60:0x0276, B:52:0x0155, B:54:0x01b3, B:55:0x01be, B:57:0x0262, B:24:0x0099, B:20:0x008c), top: B:67:0x0012, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0262 A[Catch: Exception -> 0x02af, TryCatch #0 {Exception -> 0x02af, blocks: (B:3:0x0012, B:6:0x0025, B:7:0x002c, B:9:0x0041, B:11:0x004b, B:14:0x0055, B:15:0x005c, B:17:0x0071, B:28:0x00ac, B:30:0x00b7, B:33:0x00bf, B:34:0x00c6, B:36:0x00fe, B:41:0x0129, B:47:0x013f, B:49:0x014d, B:59:0x026d, B:60:0x0276, B:52:0x0155, B:54:0x01b3, B:55:0x01be, B:57:0x0262, B:24:0x0099, B:20:0x008c), top: B:67:0x0012, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r18v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    public static final void play$playPlayableItem$lambda$15$lambda$14$playIt(PlayableItemEntity playableItemEntity, Ref.ObjectRef<PlayerEntity> objectRef, Function1<? super Boolean, Unit> function1, Context context, DaijishouLibraryModel daijishouLibraryModel, boolean z) {
        boolean z2;
        int i;
        int r18 = 1;
        List<Pair<String, String>> listMutableListOf;
        boolean z3;
        try {
            int playableItemType = playableItemEntity.getPlayableItemType();
            PlayerEntity playerEntity = objectRef.element;
            Intrinsics.checkNotNull(playerEntity);
            if (playableItemType != playerEntity.getPlayer()) {
                if (function1 != null) {
                    function1.invoke(false);
                }
                Toast.makeText(context, daijishouLibraryModel.getApplication().getString(R.string.playable_item_and_player_have_different_type), 0).show();
                return;
            }
            Uri uri = playableItemEntity.getUri();
            if (playableItemEntity.getPlayableItemType() == 1 && Intrinsics.areEqual(uri, Uri.EMPTY)) {
                if (function1 != null) {
                    function1.invoke(false);
                }
                Toast.makeText(context, daijishouLibraryModel.getApplication().getString(R.string.empty_uri_warning), 0).show();
                return;
            }
            PlayerEntity playerEntity2 = objectRef.element;
            Intrinsics.checkNotNull(playerEntity2);
            String filePath = "/dev/null";
            if (StringsKt.contains$default((CharSequence) playerEntity2.getAmStartArguments(), (CharSequence) "{file.path}", false, 2, (Object) null)) {
                try {
                    filePath = FileUtils.INSTANCE.getFilePath(context, uri);
                    z2 = false;
                } catch (Exception e) {
                    z2 = false;
                    daijishouLibraryModel.logger.warn(daijishouLibraryModel, ExceptionsKt.stackTraceToString(e));
                    String path = uri.getPath();
                    if (path != null) {
                        filePath = path;
                    }
                }
                File file = new File(filePath);
                if (playableItemEntity.getPlayableItemType() == 1 && !file.exists()) {
                    if (function1 != null) {
                        function1.invoke(Boolean.valueOf(z2));
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = daijishouLibraryModel.getApplication().getString(R.string.playable_item_no_longer_exists_on_analysed_path_warning_format);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String str = String.format(string, Arrays.copyOf(new Object[]{filePath, uri.toString(), uri.getPath(), uri.getAuthority()}, 4));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    Toast.makeText(context, str, 1).show();
                    return;
                }
            } else {
                z2 = false;
            }
            PlayerEntity playerEntity3 = objectRef.element;
            Intrinsics.checkNotNull(playerEntity3);
            if (StringsKt.contains$default(playerEntity3.getAmStartArguments(), "{file.uri}", z2, 2, (Object) null)) {
                z3 = true;
                i = 3;
            } else {
                try {
                    PlayerEntity playerEntity4 = objectRef.element;
                    Intrinsics.checkNotNull(playerEntity4);
                    i = 3;
                    r18 = 1;
                    if (StringsKt.contains$default((CharSequence) playerEntity4.getAmStartArguments(), (CharSequence) "{file.documenturi}", false, 2, (Object) null)) {
                        z3 = true;
                    }
                    r18 = z3 ? 1 : 0;
                    Pair[] pairArr = new Pair[7];
                    pairArr[0] = new Pair("\"{file.path}\"", filePath);
                    pairArr[r18] = new Pair("{file.path}", filePath);
                    pairArr[2] = new Pair("\"{file.uri}\"", uri.toString());
                    pairArr[i] = new Pair("{file.uri}", uri.toString());
                    pairArr[4] = new Pair("\"{file.documenturi}\"", uri.toString());
                    pairArr[5] = new Pair("{file.documenturi}", uri.toString());
                    pairArr[6] = new Pair("{android.activity}", String.valueOf(playableItemEntity.getActivityComponentString()));
                    listMutableListOf = CollectionsKt.mutableListOf(pairArr);
                    if (z) {
                        listMutableListOf.addAll(daijishouLibraryModel.daijishouPlayerTemplate.getTemplateTagsAndValuesFromUri(uri));
                    }
                    AmStartCommandToIntentConverter amStartCommandToIntentConverter = AmStartCommandToIntentConverter.INSTANCE;
                    PlayerEntity playerEntity5 = objectRef.element;
                    Intrinsics.checkNotNull(playerEntity5);
                    context.startActivity(amStartCommandToIntentConverter.createIntentByCommandArgs(playerEntity5.getAmStartArguments(), listMutableListOf));
                    PlayableItemEntity playableItemEntityCopy$default = PlayableItemEntity.copy$default(playableItemEntity, 0L, null, false, false, null, 0, null, false, null, null, false, false, false, false, null, null, null, null, null, null, false, null, 0, null, null, false, false, null, 268435455, null);
                    playableItemEntityCopy$default.setPlayCount(playableItemEntityCopy$default.getPlayCount() + 1);
                    playableItemEntityCopy$default.setLastPlayedTimestamp(new Date());
                    daijishouLibraryModel.daijishouLibraryRepository.updatePlayableItem(playableItemEntityCopy$default);
                    DaijishouLibraryRepository daijishouLibraryRepository = daijishouLibraryModel.daijishouLibraryRepository;
                    Long lValueOf = Long.valueOf(playableItemEntity.getId());
                    Long attachedPlatformId = playableItemEntity.getAttachedPlatformId();
                    PlayerEntity playerEntity6 = objectRef.element;
                    Intrinsics.checkNotNull(playerEntity6);
                    daijishouLibraryRepository.addEvent(new EventEntity(0L, 1, null, lValueOf, attachedPlatformId, Long.valueOf(playerEntity6.getId()), null, null, 197, null));
                    if (function1 != null) {
                        function1.invoke(Boolean.valueOf((boolean) r18));
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e = e2;
                }
            }
            DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(daijishouLibraryModel.getApplication().getApplicationContext(), uri);
            if (documentFileFromSingleUri != null) {
                if (!documentFileFromSingleUri.exists()) {
                }
                r18 = z3 ? 1 : 0;
                Pair[] pairArr2 = new Pair[7];
                pairArr2[0] = new Pair("\"{file.path}\"", filePath);
                pairArr2[r18] = new Pair("{file.path}", filePath);
                pairArr2[2] = new Pair("\"{file.uri}\"", uri.toString());
                pairArr2[i] = new Pair("{file.uri}", uri.toString());
                pairArr2[4] = new Pair("\"{file.documenturi}\"", uri.toString());
                pairArr2[5] = new Pair("{file.documenturi}", uri.toString());
                pairArr2[6] = new Pair("{android.activity}", String.valueOf(playableItemEntity.getActivityComponentString()));
                listMutableListOf = CollectionsKt.mutableListOf(pairArr2);
                if (z) {
                    listMutableListOf.addAll(daijishouLibraryModel.daijishouPlayerTemplate.getTemplateTagsAndValuesFromUri(uri));
                }
                AmStartCommandToIntentConverter amStartCommandToIntentConverter2 = AmStartCommandToIntentConverter.INSTANCE;
                PlayerEntity playerEntity7 = objectRef.element;
                Intrinsics.checkNotNull(playerEntity7);
                context.startActivity(amStartCommandToIntentConverter2.createIntentByCommandArgs(playerEntity7.getAmStartArguments(), listMutableListOf));
                PlayableItemEntity playableItemEntityCopy$default2 = PlayableItemEntity.copy$default(playableItemEntity, 0L, null, false, false, null, 0, null, false, null, null, false, false, false, false, null, null, null, null, null, null, false, null, 0, null, null, false, false, null, 268435455, null);
                playableItemEntityCopy$default2.setPlayCount(playableItemEntityCopy$default2.getPlayCount() + 1);
                playableItemEntityCopy$default2.setLastPlayedTimestamp(new Date());
                daijishouLibraryModel.daijishouLibraryRepository.updatePlayableItem(playableItemEntityCopy$default2);
                DaijishouLibraryRepository daijishouLibraryRepository2 = daijishouLibraryModel.daijishouLibraryRepository;
                Long lValueOf2 = Long.valueOf(playableItemEntity.getId());
                Long attachedPlatformId2 = playableItemEntity.getAttachedPlatformId();
                PlayerEntity playerEntity8 = objectRef.element;
                Intrinsics.checkNotNull(playerEntity8);
                daijishouLibraryRepository2.addEvent(new EventEntity(0L, 1, null, lValueOf2, attachedPlatformId2, Long.valueOf(playerEntity8.getId()), null, null, 197, null));
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf((boolean) r18));
                    return;
                }
                return;
            }
            if (function1 != null) {
                r18 = z3 ? 1 : 0;
                function1.invoke(false);
            }
            r18 = z3 ? 1 : 0;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = daijishouLibraryModel.getApplication().getString(R.string.playable_item_no_longer_exists_on_uri_warning_format);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String str2 = String.format(string2, Arrays.copyOf(new Object[]{uri.toString(), uri.getPath(), uri.getAuthority()}, i));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            Toast.makeText(context, str2, z3 ? 1 : 0 ? 1 : 0).show();
            return;
        } catch (Exception e3) {
            e = e3;
        }
        daijishouLibraryModel.logger.warn(daijishouLibraryModel, ExceptionsKt.stackTraceToString(e));
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String string3 = daijishouLibraryModel.getApplication().getString(R.string.player_error_format);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String str3 = String.format(string3, Arrays.copyOf(new Object[]{e.getLocalizedMessage()}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        Toast.makeText(context, str3, 0).show();
        if (function1 != null) {
            function1.invoke(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$playPlayableItem$lambda$15$lambda$14$killPackageProcesses(AppCompatActivity appCompatActivity, String str) {
        Object systemService = appCompatActivity.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService).killBackgroundProcesses(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$playPlayableItem$lambda$15$lambda$14$playItWithRules(final Ref.ObjectRef<PlayerEntity> objectRef, final DaijishouLibraryModel daijishouLibraryModel, final AppCompatActivity appCompatActivity, final String str, final PlayableItemEntity playableItemEntity, final Function1<? super Boolean, Unit> function1, final Context context, final boolean z) {
        PlayerEntity playerEntity = objectRef.element;
        Intrinsics.checkNotNull(playerEntity);
        if (playerEntity.getKillPackageProcesses()) {
            PlayerEntity playerEntity2 = objectRef.element;
            Intrinsics.checkNotNull(playerEntity2);
            if (playerEntity2.getKillPackageProcessesWarning() && !daijishouLibraryModel.getDefaultSharedPreferences().getBoolean(BooleanPreference.DISABLE_PLAYER_KILL_PACKAGE_PROCESSES_WARNING.getKey(), BooleanPreference.DISABLE_PLAYER_KILL_PACKAGE_PROCESSES_WARNING.getDefaultValue())) {
                AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, daijishouLibraryModel.getApplication().getString(R.string.kill_package_processes_warning_title), daijishouLibraryModel.getApplication().getString(R.string.kill_package_processes_warning), null, null, daijishouLibraryModel.getApplication().getString(R.string.no_killing), 12, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$play$playPlayableItem$1$1$playItWithRules$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DaijishouLibraryModel.play$playPlayableItem$lambda$15$lambda$14$killPackageProcesses(appCompatActivity, str);
                        DaijishouLibraryModel.play$playPlayableItem$lambda$15$lambda$14$playIt(playableItemEntity, objectRef, function1, context, daijishouLibraryModel, z);
                    }
                }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$play$playPlayableItem$1$1$playItWithRules$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function1<Boolean, Unit> function2 = function1;
                        if (function2 != null) {
                            function2.invoke(false);
                        }
                    }
                }).setOnNeutralButtonClickedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouLibraryModel$play$playPlayableItem$1$1$playItWithRules$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DaijishouLibraryModel.play$playPlayableItem$lambda$15$lambda$14$playIt(playableItemEntity, objectRef, function1, context, daijishouLibraryModel, z);
                    }
                }).show(appCompatActivity.getSupportFragmentManager(), AcknowledgementDialogFragment.class.getName());
                return;
            } else {
                play$playPlayableItem$lambda$15$lambda$14$killPackageProcesses(appCompatActivity, str);
                play$playPlayableItem$lambda$15$lambda$14$playIt(playableItemEntity, objectRef, function1, context, daijishouLibraryModel, z);
                return;
            }
        }
        play$playPlayableItem$lambda$15$lambda$14$playIt(playableItemEntity, objectRef, function1, context, daijishouLibraryModel, z);
    }

    public final void injectPlayableItemWithMergedInfo(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        this.daijishouLibraryRepository.updatePlayableItemWithMergedInfo(playableItemEntity);
    }

    public final List<PlayableItemEntity> getMergedPlayableItems(PlayableItemEntity... playableItemEntities) {
        Intrinsics.checkNotNullParameter(playableItemEntities, "playableItemEntities");
        return this.daijishouLibraryRepository.getMergedPlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntities, playableItemEntities.length));
    }

    public final List<PlayableItemEntity> getMergedPlayableItemsWithPreferences(PlayableItemEntity... playableItemEntities) {
        Intrinsics.checkNotNullParameter(playableItemEntities, "playableItemEntities");
        return getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue()) ? getMergedPlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntities, playableItemEntities.length)) : ArraysKt.toList(playableItemEntities);
    }

    public static /* synthetic */ LiveData getAllPlayableItemsIdsByVisibility$default(DaijishouLibraryModel daijishouLibraryModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getAllPlayableItemsIdsByVisibility(z);
    }

    public final LiveData<List<Long>> getAllPlayableItemsIdsByVisibility(boolean z) {
        return this.daijishouLibraryRepository.getAllPlayableItemsIdsByVisibility(z);
    }

    public final LiveData<Integer> getAllPlayableItemCount() {
        return this.daijishouLibraryRepository.countAllPlayableItems();
    }

    public final LiveData<PlayableItemEntity> getPlayableItemById(long j) {
        return this.daijishouLibraryRepository.getPlayableItemById(j);
    }

    public static /* synthetic */ LiveData getPlayableItemByIdAndVisibility$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getPlayableItemByIdAndVisibility(j, z);
    }

    public final LiveData<PlayableItemEntity> getPlayableItemByIdAndVisibility(long j, boolean z) {
        return this.daijishouLibraryRepository.getPlayableItemByIdAndVisibility(j, z);
    }

    public final PlayableItemEntity getPlayableItemByIdStatically(long j) {
        return this.daijishouLibraryRepository.getPlayableItemByIdStatically(j);
    }

    public static /* synthetic */ PlayableItemEntity getPlayableItemByIdAndVisibilityStatically$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getPlayableItemByIdAndVisibilityStatically(j, z);
    }

    public final PlayableItemEntity getPlayableItemByIdAndVisibilityStatically(long j, boolean z) {
        return this.daijishouLibraryRepository.getPlayableItemByIdAndVisibilityStatically(j, z);
    }

    public final PlayableItemEntity getPlayableItemRandomlyByAttachedPlatformIdStatically(long j) {
        return this.daijishouLibraryRepository.getPlayableItemRandomlyByAttachedPlatformIdStatically(j);
    }

    public static /* synthetic */ PlayableItemEntity getPlayableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getPlayableItemRandomlyByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final PlayableItemEntity getPlayableItemRandomlyByAttachedPlatformIdAndVisibilityStatically(long j, boolean z) {
        return this.daijishouLibraryRepository.getPlayableItemRandomlyByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final LiveData<PlayableItemEntity> getMostRecentPlayableItem() {
        return this.daijishouLibraryRepository.getMostRecentPlayableItem();
    }

    public final PlayableItemEntity getMostRecentPlayableItemStatically() {
        return this.daijishouLibraryRepository.getMostRecentPlayableItemStatically();
    }

    public static /* synthetic */ LiveData getRecentPlayableItems$default(DaijishouLibraryModel daijishouLibraryModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 512;
        }
        return daijishouLibraryModel.getRecentPlayableItems(i);
    }

    public final LiveData<List<PlayableItemEntity>> getRecentPlayableItems(int i) {
        return this.daijishouLibraryRepository.getRecentPlayableItems(new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc())), i);
    }

    public static /* synthetic */ LiveData getRecentPlayableItems$default(DaijishouLibraryModel daijishouLibraryModel, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 512;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getRecentPlayableItems(i, z);
    }

    public final LiveData<List<PlayableItemEntity>> getRecentPlayableItems(int i, boolean z) {
        return this.daijishouLibraryRepository.getRecentPlayableItemsByVisibility(new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc())), i, z);
    }

    public static /* synthetic */ List getRecentPlayableItemsStatically$default(DaijishouLibraryModel daijishouLibraryModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 512;
        }
        return daijishouLibraryModel.getRecentPlayableItemsStatically(i);
    }

    public final List<PlayableItemEntity> getRecentPlayableItemsStatically(int i) {
        return this.daijishouLibraryRepository.getRecentPlayableItemsStatically(new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc())), i);
    }

    public static /* synthetic */ List getRecentPlayableItemsStatically$default(DaijishouLibraryModel daijishouLibraryModel, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 512;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getRecentPlayableItemsStatically(i, z);
    }

    public final List<PlayableItemEntity> getRecentPlayableItemsStatically(int i, boolean z) {
        return this.daijishouLibraryRepository.getRecentPlayableItemsByVisibilityStatically(new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc())), i, z);
    }

    public static /* synthetic */ LiveData getNewlyPlayableItems$default(DaijishouLibraryModel daijishouLibraryModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 512;
        }
        return daijishouLibraryModel.getNewlyPlayableItems(i);
    }

    public final LiveData<List<PlayableItemEntity>> getNewlyPlayableItems(int i) {
        return this.daijishouLibraryRepository.getNewlyPlayableItems(new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc())), i);
    }

    public static /* synthetic */ LiveData getNewlyPlayableItems$default(DaijishouLibraryModel daijishouLibraryModel, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 512;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getNewlyPlayableItems(i, z);
    }

    public final LiveData<List<PlayableItemEntity>> getNewlyPlayableItems(int i, boolean z) {
        return this.daijishouLibraryRepository.getNewlyPlayableItemsByVisibility(new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc())), i, z);
    }

    public static /* synthetic */ List getNewlyPlayableItemsStatically$default(DaijishouLibraryModel daijishouLibraryModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 512;
        }
        return daijishouLibraryModel.getNewlyPlayableItemsStatically(i);
    }

    public final List<PlayableItemEntity> getNewlyPlayableItemsStatically(int i) {
        return this.daijishouLibraryRepository.getNewlyPlayableItemsStatically(new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc())), i);
    }

    public static /* synthetic */ List getNewlyPlayableItemsStatically$default(DaijishouLibraryModel daijishouLibraryModel, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 512;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getNewlyPlayableItemsStatically(i, z);
    }

    public final List<PlayableItemEntity> getNewlyPlayableItemsStatically(int i, boolean z) {
        return this.daijishouLibraryRepository.getNewlyPlayableItemsByVisibilityStatically(new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc())), i, z);
    }

    public final PlayableItemEntity getPlayableItemRandomly() {
        return this.daijishouLibraryRepository.getPlayableItemRandomly();
    }

    public static /* synthetic */ PlayableItemEntity getPlayableItemRandomlyByVisibility$default(DaijishouLibraryModel daijishouLibraryModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getPlayableItemRandomlyByVisibility(z);
    }

    public final PlayableItemEntity getPlayableItemRandomlyByVisibility(boolean z) {
        return this.daijishouLibraryRepository.getPlayableItemRandomlyByVisibility(z);
    }

    public final PlayableItemEntity getFavoritePlayableItemRandomly() {
        return this.daijishouLibraryRepository.getFavoritePlayableItemRandomly();
    }

    public static /* synthetic */ PlayableItemEntity getFavoritePlayableItemRandomlyByVisibility$default(DaijishouLibraryModel daijishouLibraryModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getFavoritePlayableItemRandomlyByVisibility(z);
    }

    public final PlayableItemEntity getFavoritePlayableItemRandomlyByVisibility(boolean z) {
        return this.daijishouLibraryRepository.getFavoritePlayableItemRandomlyByVisibility(z);
    }

    public final PlayableItemEntity getRecentPlayableItemRandomly() {
        return this.daijishouLibraryRepository.getRecentPlayableItemRandomly(new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc())));
    }

    public static /* synthetic */ PlayableItemEntity getRecentPlayableItemRandomlyByVisibility$default(DaijishouLibraryModel daijishouLibraryModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getRecentPlayableItemRandomlyByVisibility(z);
    }

    public final PlayableItemEntity getRecentPlayableItemRandomlyByVisibility(boolean z) {
        return this.daijishouLibraryRepository.getRecentPlayableItemRandomlyByVisibility(new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc())), z);
    }

    public final PlayableItemEntity getNewlyPlayableItemRandomly() {
        return this.daijishouLibraryRepository.getNewlyPlayableItemRandomly(new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc())));
    }

    public static /* synthetic */ PlayableItemEntity getNewlyPlayableItemRandomlyByVisibility$default(DaijishouLibraryModel daijishouLibraryModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getNewlyPlayableItemRandomlyByVisibility(z);
    }

    public final PlayableItemEntity getNewlyPlayableItemRandomlyByVisibility(boolean z) {
        return this.daijishouLibraryRepository.getNewlyPlayableItemRandomlyByVisibility(new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc())), z);
    }

    public static /* synthetic */ List getSimilarPlayableItems$default(DaijishouLibraryModel daijishouLibraryModel, PlayableItemEntity playableItemEntity, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryModel.getSimilarPlayableItems(playableItemEntity, i, z);
    }

    public final List<PlayableItemEntity> getSimilarPlayableItems(PlayableItemEntity playableItemEntity, int i, boolean z) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        return DaijishouLibraryRepository.getSimilarPlayableItems$default(this.daijishouLibraryRepository, playableItemEntity, i, z, false, 8, null);
    }

    public static /* synthetic */ List searchPlayableItemsByKeyword$default(DaijishouLibraryModel daijishouLibraryModel, String str, int i, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8;
        }
        return daijishouLibraryModel.searchPlayableItemsByKeyword(str, i, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? true : z3);
    }

    public final List<PlayableItemEntity> searchPlayableItemsByKeyword(String keyword, int i, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.daijishouLibraryRepository.searchPlayableItemsByKeyword(keyword, i, null, z, z2, z3);
    }

    public static /* synthetic */ List findPlayableItemsWithNameAndDescriptionStatically$default(DaijishouLibraryModel daijishouLibraryModel, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return daijishouLibraryModel.findPlayableItemsWithNameAndDescriptionStatically(str, i);
    }

    public final List<PlayableItemEntity> findPlayableItemsWithNameAndDescriptionStatically(String keyword, int i) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.daijishouLibraryRepository.findPlayableItemsWithNameAndDescriptionStatically(keyword, i);
    }

    public static /* synthetic */ List findPlayableItemsWithNameDescriptionAndVisibilityStatically$default(DaijishouLibraryModel daijishouLibraryModel, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryModel.findPlayableItemsWithNameDescriptionAndVisibilityStatically(str, i, z);
    }

    public final List<PlayableItemEntity> findPlayableItemsWithNameDescriptionAndVisibilityStatically(String keyword, int i, boolean z) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.daijishouLibraryRepository.findPlayableItemsWithNameDescriptionAndVisibilityStatically(keyword, i, z);
    }

    public final long countPlayableItemsByAttachedPlatformIdStatically(long j) {
        return this.daijishouLibraryRepository.countPlayableItemsByAttachedPlatformIdStatically(j);
    }

    public static /* synthetic */ long countPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.countPlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final long countPlayableItemsByAttachedPlatformIdAndVisibilityStatically(long j, boolean z) {
        return this.daijishouLibraryRepository.countPlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final long countRecentPlayableItemsByAttachedPlatformIdStatically(long j) {
        return this.daijishouLibraryRepository.countRecentPlayableItemsByAttachedPlatformIdStatically(j, new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc())));
    }

    public static /* synthetic */ long countRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.countRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final long countRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically(long j, boolean z) {
        return this.daijishouLibraryRepository.countRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc())), z);
    }

    public final long countFavoritePlayableItemsByAttachedPlatformIdStatically(long j) {
        return this.daijishouLibraryRepository.countFavoritePlayableItemsByAttachedPlatformIdStatically(j);
    }

    public static /* synthetic */ long countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final long countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically(long j, boolean z) {
        return this.daijishouLibraryRepository.countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final long countNewlyPlayableItemsByAttachedPlatformIdStatically(long j) {
        return this.daijishouLibraryRepository.countNewlyPlayableItemsByAttachedPlatformIdStatically(j, new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc())));
    }

    public static /* synthetic */ long countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final long countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically(long j, boolean z) {
        return this.daijishouLibraryRepository.countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc())), z);
    }

    public final long countPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(long j) {
        return this.daijishouLibraryRepository.countPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(j);
    }

    public static /* synthetic */ long countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, z);
    }

    public final long countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(long j, boolean z) {
        return this.daijishouLibraryRepository.countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, z);
    }

    public final long countRecentPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(long j) {
        return this.daijishouLibraryRepository.countRecentPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(j, new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc())));
    }

    public static /* synthetic */ long countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, z);
    }

    public final long countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(long j, boolean z) {
        return this.daijishouLibraryRepository.countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc())), z);
    }

    public final long countFavoritePlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(long j) {
        return this.daijishouLibraryRepository.countFavoritePlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(j);
    }

    public static /* synthetic */ long countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, z);
    }

    public final long countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(long j, boolean z) {
        return this.daijishouLibraryRepository.countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, z);
    }

    public final long countNewlyPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(long j) {
        return this.daijishouLibraryRepository.countNewlyPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(j, new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc())));
    }

    public static /* synthetic */ long countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(DaijishouLibraryModel daijishouLibraryModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryModel.countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, z);
    }

    public final long countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(long j, boolean z) {
        return this.daijishouLibraryRepository.countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc())), z);
    }
}
