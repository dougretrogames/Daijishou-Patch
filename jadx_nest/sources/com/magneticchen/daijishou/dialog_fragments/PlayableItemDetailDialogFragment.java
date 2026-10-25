package com.magneticchen.daijishou.dialog_fragments;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowMetrics;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.daijishou_library_db.Genre;
import com.magneticchen.daijishou.daijishou_library_db.Genres;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.daijishou_widget.WidgetsManager;
import com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play.PinAndPlayWidgetBuilder;
import com.magneticchen.daijishou.live_data.ConnectionLiveData;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.live_data.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.live_data.TripleLiveData;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.utils.UtilsKt;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import com.magneticchen.daijishou.view_models.PlayableItemDetailViewModel;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ·\u00012\u00020\u0001:\u0004·\u0001¸\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0094\u0001\u001a\u00020\u00042\u0007\u0010\u0095\u0001\u001a\u00020VJ\u0013\u0010\u0096\u0001\u001a\u00020\u00132\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0002J\u0015\u0010\u0099\u0001\u001a\u00030\u009a\u00012\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\u0015\u0010\u009c\u0001\u001a\u00030\u009a\u00012\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u009d\u0001\u001a\u00030\u009a\u00012\u0006\u0010F\u001a\u00020GH\u0002J\t\u0010\u009e\u0001\u001a\u00020\u001dH\u0016J\u0016\u0010\u009f\u0001\u001a\u00030\u009a\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016J.\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016J\n\u0010¨\u0001\u001a\u00030\u009a\u0001H\u0016J\n\u0010©\u0001\u001a\u00030\u009a\u0001H\u0016J\n\u0010ª\u0001\u001a\u00030\u009a\u0001H\u0016J\n\u0010«\u0001\u001a\u00030\u009a\u0001H\u0016J \u0010¬\u0001\u001a\u00030\u009a\u00012\b\u0010\u00ad\u0001\u001a\u00030£\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016J\u0013\u0010®\u0001\u001a\u00030\u009a\u00012\u0007\u0010¯\u0001\u001a\u00020\u0004H\u0002J\n\u0010°\u0001\u001a\u00030\u009a\u0001H\u0002J\n\u0010±\u0001\u001a\u00030\u009a\u0001H\u0002J\u0012\u0010²\u0001\u001a\u00030\u009a\u00012\b\u0010³\u0001\u001a\u00030´\u0001J\u0012\u0010µ\u0001\u001a\u00030\u009a\u00012\u0006\u0010F\u001a\u00020GH\u0002J\n\u0010¶\u0001\u001a\u00030\u009a\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u000e\u00102\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00101\u001a\u0004\b7\u00108R\u000e\u0010:\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u00101\u001a\u0004\bC\u0010DR\u000e\u0010F\u001a\u00020GX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010Q\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u00101\u001a\u0004\bR\u0010SR\u0012\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0004\n\u0002\u0010WR\u001b\u0010X\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u00101\u001a\u0004\bY\u0010SR\u001b\u0010[\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u00101\u001a\u0004\b\\\u0010SR\u001b\u0010^\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u00101\u001a\u0004\b_\u0010SR\u001b\u0010a\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u00101\u001a\u0004\bb\u0010SR\u001b\u0010d\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u00101\u001a\u0004\be\u0010SR\u001b\u0010g\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u00101\u001a\u0004\bh\u0010SR\u001b\u0010j\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u00101\u001a\u0004\bk\u0010SR\u001b\u0010m\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u00101\u001a\u0004\bn\u0010SR\u001b\u0010p\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u00101\u001a\u0004\bq\u0010SR\u0010\u0010s\u001a\u0004\u0018\u00010tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020xX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020|X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0015\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0084\u0001\u001a\u00030\u0085\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0086\u0001\u001a\u00070\u0087\u0001R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0088\u0001\u001a\u00030\u0089\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00020G0\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "addFavoriteString", "", "background", "Landroid/widget/ImageView;", "backgroundSetLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "boxArtAspectRatio", "boxArtAspectRatioFloat", "", "boxArtAspectRatioList", "", "colorIconThemeTintList", "Landroid/content/res/ColorStateList;", "colorOnThemeTintList", "colorThemeTintList", "connectionType", "", "descriptionFormatString", "descriptionTextView", "Landroid/widget/TextView;", "detailContainerLayout", "detailScrollView", "Landroid/widget/ScrollView;", "detailTextView", "displayHeightPixels", "doPlaying", "", "editButton", "Lcom/google/android/material/chip/Chip;", "favoriteButton", "favoriteImageView", "genresTextView", "gradientImageView", "hasPlayed", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "isFavoriteDrawable", "Landroid/graphics/drawable/Drawable;", "isFavoriteString", "isLoadingYoutube", "isNotFavoriteDrawable", "makePreviewVideoSounds", "mergePlayableItems", "getMergePlayableItems", "()Z", "mergePlayableItems$delegate", "Lkotlin/Lazy;", "newlyButton", "newlyImageView", "noneString", "pinAndPlayWidget", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;", "getPinAndPlayWidget", "()Lcom/magneticchen/daijishou/daijishou_widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;", "pinAndPlayWidget$delegate", "pinButton", "placeholder", "platformDescriptionTextView", "platformName", "platformTextView", "playButton", "playPreviewVideo", "playableItemDetailViewModel", "Lcom/magneticchen/daijishou/view_models/PlayableItemDetailViewModel;", "getPlayableItemDetailViewModel", "()Lcom/magneticchen/daijishou/view_models/PlayableItemDetailViewModel;", "playableItemDetailViewModel$delegate", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "playableItemViewedEventRegistered", "previewVideoButton", "recentButton", "recentImageView", "refocusOnScrolledToTop", "retroAchievementsDescriptionFormatString", "retroAchievementsDescriptionNewFormatString", "retroAchievementsDescriptionWithPlayerCountFormatString", "retroAchievementsDescriptionWithRatingFormatString", "retroAchievementsGame0PlayerString", "getRetroAchievementsGame0PlayerString", "()Ljava/lang/String;", "retroAchievementsGame0PlayerString$delegate", "retroAchievementsGameId", "", "Ljava/lang/Long;", "retroAchievementsGameMoreThen1024PlayersString", "getRetroAchievementsGameMoreThen1024PlayersString", "retroAchievementsGameMoreThen1024PlayersString$delegate", "retroAchievementsGameMoreThen128PlayersString", "getRetroAchievementsGameMoreThen128PlayersString", "retroAchievementsGameMoreThen128PlayersString$delegate", "retroAchievementsGameMoreThen16284PlayersString", "getRetroAchievementsGameMoreThen16284PlayersString", "retroAchievementsGameMoreThen16284PlayersString$delegate", "retroAchievementsGameMoreThen2048PlayersString", "getRetroAchievementsGameMoreThen2048PlayersString", "retroAchievementsGameMoreThen2048PlayersString$delegate", "retroAchievementsGameMoreThen256PlayersString", "getRetroAchievementsGameMoreThen256PlayersString", "retroAchievementsGameMoreThen256PlayersString$delegate", "retroAchievementsGameMoreThen4096PlayersString", "getRetroAchievementsGameMoreThen4096PlayersString", "retroAchievementsGameMoreThen4096PlayersString$delegate", "retroAchievementsGameMoreThen512PlayersString", "getRetroAchievementsGameMoreThen512PlayersString", "retroAchievementsGameMoreThen512PlayersString$delegate", "retroAchievementsGameMoreThen64PlayersString", "getRetroAchievementsGameMoreThen64PlayersString", "retroAchievementsGameMoreThen64PlayersString$delegate", "retroAchievementsGameMoreThen8192PlayersString", "getRetroAchievementsGameMoreThen8192PlayersString", "retroAchievementsGameMoreThen8192PlayersString$delegate", "retroAchievementsGameRecord", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "retroAchievementsLoginRequiredDetailString", "retroAchievementsLoginRequiredWitEmojiString", "retroAchievementsNextRefreshDate", "Ljava/util/Date;", "retroAchievementsRefreshing", "retroAchievementsRefreshingString", "retroAchievementsSharedPreferences", "Landroid/content/SharedPreferences;", "retroAchievementsTextView", "retroAchievementsUnavailableString", "retroAchievementsUnavailableWithEmojiString", "root", "screenAspectRatioList", "similarItemsLayout", "Landroid/widget/LinearLayout;", "similarItemsRecyclerView", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "similarItemsRecyclerViewAdapter", "Lcom/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment$SimilarListAdapter;", "similarItemsRecyclerViewLayoutManager", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouLinearLayoutManager;", "similarPlayableItemList", "", "thumbnail", "titleTextView", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "youTubePlayerCurrentSecond", "youtubePlayerView", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "youtubeVideoId", "getPlayerCountLabel", "playerCount", "getScreenHeight", "activity", "Landroid/app/Activity;", "loadBackground", "", "pathName", "loadBoxArt", "loadYoutube", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onKioskMode", "onNoneKioskMode", "onResume", "onStart", "onViewCreated", "view", "playYoutubeVideo", "id", "refreshDimensionRatioHeight", "refreshPinButton", "refreshPlatform", "platform", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "refreshPlayableItem", "stopYoutubeVideo", "Companion", "SimilarListAdapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlayableItemDetailDialogFragment extends DaijishouDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Typeface typeface;
    private String addFavoriteString;
    private ImageView background;
    private ConstraintLayout backgroundSetLayout;
    private List<String> boxArtAspectRatioList;
    private ColorStateList colorIconThemeTintList;
    private ColorStateList colorOnThemeTintList;
    private ColorStateList colorThemeTintList;
    private int connectionType;
    private String descriptionFormatString;
    private TextView descriptionTextView;
    private ConstraintLayout detailContainerLayout;
    private ScrollView detailScrollView;
    private TextView detailTextView;
    private boolean doPlaying;
    private Chip editButton;
    private Chip favoriteButton;
    private ImageView favoriteImageView;
    private TextView genresTextView;
    private ImageView gradientImageView;
    private boolean hasPlayed;
    private HorizontalScrollView horizontalScrollView;
    private Drawable isFavoriteDrawable;
    private String isFavoriteString;
    private boolean isLoadingYoutube;
    private Drawable isNotFavoriteDrawable;
    private Chip newlyButton;
    private ImageView newlyImageView;
    private String noneString;
    private Chip pinButton;
    private ImageView placeholder;
    private TextView platformDescriptionTextView;
    private TextView platformTextView;
    private Chip playButton;

    /* JADX INFO: renamed from: playableItemDetailViewModel$delegate, reason: from kotlin metadata */
    private final Lazy playableItemDetailViewModel;
    public PlayableItemEntity playableItemEntity;
    private boolean playableItemViewedEventRegistered;
    private Chip previewVideoButton;
    private Chip recentButton;
    private ImageView recentImageView;
    private boolean refocusOnScrolledToTop;
    private String retroAchievementsDescriptionFormatString;
    private String retroAchievementsDescriptionNewFormatString;
    private String retroAchievementsDescriptionWithPlayerCountFormatString;
    private String retroAchievementsDescriptionWithRatingFormatString;
    private Long retroAchievementsGameId;
    private RetroAchievementsGameRecordEntity retroAchievementsGameRecord;
    private String retroAchievementsLoginRequiredDetailString;
    public String retroAchievementsLoginRequiredWitEmojiString;
    private Date retroAchievementsNextRefreshDate;
    private boolean retroAchievementsRefreshing;
    public String retroAchievementsRefreshingString;
    private SharedPreferences retroAchievementsSharedPreferences;
    public TextView retroAchievementsTextView;
    private String retroAchievementsUnavailableString;
    private String retroAchievementsUnavailableWithEmojiString;
    private ConstraintLayout root;
    private List<String> screenAspectRatioList;
    private LinearLayout similarItemsLayout;
    private DaijishouRecyclerView similarItemsRecyclerView;
    private SimilarListAdapter similarItemsRecyclerViewAdapter;
    private DaijishouLinearLayoutManager similarItemsRecyclerViewLayoutManager;
    private ImageView thumbnail;
    private TextView titleTextView;
    private YouTubePlayer youTubePlayer;
    private float youTubePlayerCurrentSecond;
    private YouTubePlayerView youtubePlayerView;
    private String youtubeVideoId;
    private boolean playPreviewVideo = true;
    private boolean makePreviewVideoSounds = true;
    private String boxArtAspectRatio = Constants.defaultThumbnailDimensionRatio;
    private final List<PlayableItemEntity> similarPlayableItemList = new ArrayList();
    private int displayHeightPixels = -1;
    private float boxArtAspectRatioFloat = 1.0f;
    private String platformName = "";

    /* JADX INFO: renamed from: pinAndPlayWidget$delegate, reason: from kotlin metadata */
    private final Lazy pinAndPlayWidget = LazyKt.lazy(new PlayableItemDetailDialogFragment$pinAndPlayWidget$2(this));

    /* JADX INFO: renamed from: mergePlayableItems$delegate, reason: from kotlin metadata */
    private final Lazy mergePlayableItems = LazyKt.lazy(new PlayableItemDetailDialogFragment$mergePlayableItems$2(this));

    /* JADX INFO: renamed from: retroAchievementsGame0PlayerString$delegate, reason: from kotlin metadata */
    private final Lazy retroAchievementsGame0PlayerString = LazyKt.lazy(new PlayableItemDetailDialogFragment$retroAchievementsGame0PlayerString$2(this));

    /* JADX INFO: renamed from: retroAchievementsGameMoreThen64PlayersString$delegate, reason: from kotlin metadata */
    private final Lazy retroAchievementsGameMoreThen64PlayersString = LazyKt.lazy(new PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen64PlayersString$2(this));

    /* JADX INFO: renamed from: retroAchievementsGameMoreThen128PlayersString$delegate, reason: from kotlin metadata */
    private final Lazy retroAchievementsGameMoreThen128PlayersString = LazyKt.lazy(new PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen128PlayersString$2(this));

    /* JADX INFO: renamed from: retroAchievementsGameMoreThen256PlayersString$delegate, reason: from kotlin metadata */
    private final Lazy retroAchievementsGameMoreThen256PlayersString = LazyKt.lazy(new PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen256PlayersString$2(this));

    /* JADX INFO: renamed from: retroAchievementsGameMoreThen512PlayersString$delegate, reason: from kotlin metadata */
    private final Lazy retroAchievementsGameMoreThen512PlayersString = LazyKt.lazy(new PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen512PlayersString$2(this));

    /* JADX INFO: renamed from: retroAchievementsGameMoreThen1024PlayersString$delegate, reason: from kotlin metadata */
    private final Lazy retroAchievementsGameMoreThen1024PlayersString = LazyKt.lazy(new PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen1024PlayersString$2(this));

    /* JADX INFO: renamed from: retroAchievementsGameMoreThen2048PlayersString$delegate, reason: from kotlin metadata */
    private final Lazy retroAchievementsGameMoreThen2048PlayersString = LazyKt.lazy(new PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen2048PlayersString$2(this));

    /* JADX INFO: renamed from: retroAchievementsGameMoreThen4096PlayersString$delegate, reason: from kotlin metadata */
    private final Lazy retroAchievementsGameMoreThen4096PlayersString = LazyKt.lazy(new PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen4096PlayersString$2(this));

    /* JADX INFO: renamed from: retroAchievementsGameMoreThen8192PlayersString$delegate, reason: from kotlin metadata */
    private final Lazy retroAchievementsGameMoreThen8192PlayersString = LazyKt.lazy(new PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen8192PlayersString$2(this));

    /* JADX INFO: renamed from: retroAchievementsGameMoreThen16284PlayersString$delegate, reason: from kotlin metadata */
    private final Lazy retroAchievementsGameMoreThen16284PlayersString = LazyKt.lazy(new PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen16284PlayersString$2(this));

    public PlayableItemDetailDialogFragment() {
        PlayableItemDetailDialogFragment playableItemDetailDialogFragment = this;
        this.playableItemDetailViewModel = FragmentViewModelLazyKt.createViewModelLazy(playableItemDetailDialogFragment, Reflection.getOrCreateKotlinClass(PlayableItemDetailViewModel.class), new PlayableItemDetailDialogFragment$special$$inlined$activityViewModels$default$1(playableItemDetailDialogFragment), new PlayableItemDetailDialogFragment$special$$inlined$activityViewModels$default$2(null, playableItemDetailDialogFragment), new PlayableItemDetailDialogFragment$special$$inlined$activityViewModels$default$3(playableItemDetailDialogFragment));
    }

    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment$Companion;", "", "()V", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment;", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlayableItemDetailDialogFragment newInstance(PlayableItemEntity playableItemEntity) {
            Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
            PlayableItemDetailDialogFragment playableItemDetailDialogFragment = new PlayableItemDetailDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("playableItemEntity", playableItemEntity);
            playableItemDetailDialogFragment.setArguments(bundle);
            return playableItemDetailDialogFragment;
        }
    }

    static {
        typeface = Build.VERSION.SDK_INT >= 28 ? Typeface.create(null, Constants.semiBolderWeight, false) : Typeface.defaultFromStyle(1);
    }

    private final PlayableItemDetailViewModel getPlayableItemDetailViewModel() {
        return (PlayableItemDetailViewModel) this.playableItemDetailViewModel.getValue();
    }

    private final PinAndPlayWidgetBuilder getPinAndPlayWidget() {
        return (PinAndPlayWidgetBuilder) this.pinAndPlayWidget.getValue();
    }

    private final boolean getMergePlayableItems() {
        return ((Boolean) this.mergePlayableItems.getValue()).booleanValue();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment
    public void onKioskMode() {
        super.onKioskMode();
        Chip chip = this.editButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip = null;
        }
        chip.setVisibility(8);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment
    public void onNoneKioskMode() {
        super.onNoneKioskMode();
        Chip chip = this.editButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip = null;
        }
        chip.setVisibility(0);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment
    public boolean onBackPressed() {
        ScrollView scrollView = this.detailScrollView;
        DaijishouRecyclerView daijishouRecyclerView = null;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailScrollView");
            scrollView = null;
        }
        if (scrollView.getScrollY() == 0) {
            return super.onBackPressed();
        }
        this.refocusOnScrolledToTop = true;
        ScrollView scrollView2 = this.detailScrollView;
        if (scrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailScrollView");
            scrollView2 = null;
        }
        scrollView2.smoothScrollTo(0, 0);
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
            horizontalScrollView = null;
        }
        horizontalScrollView.smoothScrollTo(0, 0);
        DaijishouRecyclerView daijishouRecyclerView2 = this.similarItemsRecyclerView;
        if (daijishouRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerView");
        } else {
            daijishouRecyclerView = daijishouRecyclerView2;
        }
        daijishouRecyclerView.smoothScrollToPosition(0);
        return false;
    }

    private final void loadBoxArt(String pathName) {
        ImageView imageView = null;
        TextView textView = null;
        if (pathName == null) {
            ImageView imageView2 = this.thumbnail;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                imageView2 = null;
            }
            imageView2.setImageBitmap(null);
            ImageView imageView3 = this.placeholder;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeholder");
                imageView3 = null;
            }
            imageView3.setVisibility(0);
            TextView textView2 = this.platformTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformTextView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            return;
        }
        CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad = getDaijishouLibrary().getCachedBoxArtBitmapLoader().with(this).setOnSucceedListener(new C02231()).setOnFailedListener(new C02242()).load(pathName);
        ImageView imageView4 = this.thumbnail;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
        } else {
            imageView = imageView4;
        }
        cachedBitmapLoaderTaskLoad.into(imageView);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$loadBoxArt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02231 extends Lambda<Unit> implements Function2<Bitmap, Boolean, Unit> {
        C02231() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
            invoke(bitmap, bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Bitmap bitmap, boolean z) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            ImageView imageView = PlayableItemDetailDialogFragment.this.thumbnail;
            TextView textView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                imageView = null;
            }
            imageView.setImageBitmap(bitmap);
            ImageView imageView2 = PlayableItemDetailDialogFragment.this.placeholder;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeholder");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
            TextView textView2 = PlayableItemDetailDialogFragment.this.platformTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformTextView");
                textView2 = null;
            }
            textView2.setVisibility(8);
            if (PlayableItemDetailDialogFragment.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_AUTO_THEME_COLOR.getKey(), BooleanPreference.USE_AUTO_THEME_COLOR.getDefaultValue())) {
                TypedValue typedValue = new TypedValue();
                PlayableItemDetailDialogFragment.this.requireActivity().getTheme().resolveAttribute(R.attr.themeTextColor, typedValue, true);
                int i = typedValue.data;
                PlayableItemDetailDialogFragment.this.requireActivity().getTheme().resolveAttribute(R.attr.themeBackgroundColor, typedValue, true);
                int i2 = typedValue.data;
                Triple bitmapThemeColors$default = Utils.getBitmapThemeColors$default(Utils.INSTANCE, bitmap, 0.0f, 2, null);
                int[][] iArr = {new int[]{android.R.attr.state_focused}, new int[]{-16842908}, new int[]{android.R.attr.state_enabled}};
                int iIntValue = ((Number) bitmapThemeColors$default.getFirst()).intValue();
                int iIntValue2 = ((Number) bitmapThemeColors$default.getSecond()).intValue();
                int iIntValue3 = ((Number) bitmapThemeColors$default.getThird()).intValue();
                PlayableItemDetailDialogFragment.this.colorThemeTintList = new ColorStateList(iArr, new int[]{i, iIntValue, iIntValue});
                PlayableItemDetailDialogFragment.this.colorIconThemeTintList = new ColorStateList(iArr, new int[]{i2, iIntValue2, iIntValue2});
                PlayableItemDetailDialogFragment.this.colorOnThemeTintList = new ColorStateList(iArr, new int[]{i2, iIntValue3, iIntValue3});
                SimilarListAdapter similarListAdapter = PlayableItemDetailDialogFragment.this.similarItemsRecyclerViewAdapter;
                if (similarListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerViewAdapter");
                    similarListAdapter = null;
                }
                similarListAdapter.notifyDataSetChanged();
                TextView textView3 = PlayableItemDetailDialogFragment.this.platformDescriptionTextView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformDescriptionTextView");
                    textView3 = null;
                }
                textView3.setBackgroundTintList(PlayableItemDetailDialogFragment.this.colorThemeTintList);
                Chip chip = PlayableItemDetailDialogFragment.this.pinButton;
                if (chip == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                    chip = null;
                }
                chip.setChipBackgroundColor(PlayableItemDetailDialogFragment.this.colorThemeTintList);
                Chip chip2 = PlayableItemDetailDialogFragment.this.previewVideoButton;
                if (chip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
                    chip2 = null;
                }
                chip2.setChipBackgroundColor(PlayableItemDetailDialogFragment.this.colorThemeTintList);
                Chip chip3 = PlayableItemDetailDialogFragment.this.recentButton;
                if (chip3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                    chip3 = null;
                }
                chip3.setChipBackgroundColor(PlayableItemDetailDialogFragment.this.colorThemeTintList);
                Chip chip4 = PlayableItemDetailDialogFragment.this.newlyButton;
                if (chip4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
                    chip4 = null;
                }
                chip4.setChipBackgroundColor(PlayableItemDetailDialogFragment.this.colorThemeTintList);
                Chip chip5 = PlayableItemDetailDialogFragment.this.pinButton;
                if (chip5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                    chip5 = null;
                }
                chip5.setChipStrokeColor(PlayableItemDetailDialogFragment.this.colorThemeTintList);
                Chip chip6 = PlayableItemDetailDialogFragment.this.previewVideoButton;
                if (chip6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
                    chip6 = null;
                }
                chip6.setChipStrokeColor(PlayableItemDetailDialogFragment.this.colorThemeTintList);
                Chip chip7 = PlayableItemDetailDialogFragment.this.recentButton;
                if (chip7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                    chip7 = null;
                }
                chip7.setChipStrokeColor(PlayableItemDetailDialogFragment.this.colorThemeTintList);
                Chip chip8 = PlayableItemDetailDialogFragment.this.newlyButton;
                if (chip8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
                    chip8 = null;
                }
                chip8.setChipStrokeColor(PlayableItemDetailDialogFragment.this.colorThemeTintList);
                TextView textView4 = PlayableItemDetailDialogFragment.this.platformDescriptionTextView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformDescriptionTextView");
                    textView4 = null;
                }
                textView4.setTextColor(PlayableItemDetailDialogFragment.this.colorOnThemeTintList);
                Chip chip9 = PlayableItemDetailDialogFragment.this.pinButton;
                if (chip9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                    chip9 = null;
                }
                chip9.setTextColor(PlayableItemDetailDialogFragment.this.colorOnThemeTintList);
                Chip chip10 = PlayableItemDetailDialogFragment.this.previewVideoButton;
                if (chip10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
                    chip10 = null;
                }
                chip10.setTextColor(PlayableItemDetailDialogFragment.this.colorOnThemeTintList);
                Chip chip11 = PlayableItemDetailDialogFragment.this.recentButton;
                if (chip11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                    chip11 = null;
                }
                chip11.setTextColor(PlayableItemDetailDialogFragment.this.colorOnThemeTintList);
                Chip chip12 = PlayableItemDetailDialogFragment.this.newlyButton;
                if (chip12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
                    chip12 = null;
                }
                chip12.setTextColor(PlayableItemDetailDialogFragment.this.colorOnThemeTintList);
                Chip chip13 = PlayableItemDetailDialogFragment.this.pinButton;
                if (chip13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                    chip13 = null;
                }
                chip13.setChipIconTint(PlayableItemDetailDialogFragment.this.colorOnThemeTintList);
                Chip chip14 = PlayableItemDetailDialogFragment.this.previewVideoButton;
                if (chip14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
                    chip14 = null;
                }
                chip14.setChipIconTint(PlayableItemDetailDialogFragment.this.colorOnThemeTintList);
                Chip chip15 = PlayableItemDetailDialogFragment.this.recentButton;
                if (chip15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                    chip15 = null;
                }
                chip15.setChipIconTint(PlayableItemDetailDialogFragment.this.colorOnThemeTintList);
                Chip chip16 = PlayableItemDetailDialogFragment.this.newlyButton;
                if (chip16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
                    chip16 = null;
                }
                chip16.setChipIconTint(PlayableItemDetailDialogFragment.this.colorOnThemeTintList);
                Chip chip17 = PlayableItemDetailDialogFragment.this.editButton;
                if (chip17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editButton");
                    chip17 = null;
                }
                chip17.setChipIconTint(PlayableItemDetailDialogFragment.this.colorIconThemeTintList);
                TextView textView5 = PlayableItemDetailDialogFragment.this.detailTextView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
                } else {
                    textView = textView5;
                }
                textView.setLinkTextColor(iIntValue2);
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$loadBoxArt$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02242 extends Lambda<Unit> implements Function1<Exception, Unit> {
        C02242() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
            invoke2(exc);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            PlayableItemDetailDialogFragment.this.getLogger().warn(PlayableItemDetailDialogFragment.this, ExceptionsKt.stackTraceToString(e));
            ImageView imageView = PlayableItemDetailDialogFragment.this.thumbnail;
            TextView textView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                imageView = null;
            }
            imageView.setImageBitmap(null);
            ImageView imageView2 = PlayableItemDetailDialogFragment.this.placeholder;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeholder");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            TextView textView2 = PlayableItemDetailDialogFragment.this.platformTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformTextView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
        }
    }

    private final void loadBackground(String pathName) {
        ImageView imageView = null;
        if (pathName == null) {
            ImageView imageView2 = this.background;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
                imageView2 = null;
            }
            imageView2.setImageBitmap(null);
            return;
        }
        CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad = getDaijishouLibrary().getCachedSnapshotBitmapLoader().with(this).setOnSucceedListener(new AnonymousClass1()).setOnFailedListener(new AnonymousClass2()).load(pathName);
        ImageView imageView3 = this.thumbnail;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
        } else {
            imageView = imageView3;
        }
        cachedBitmapLoaderTaskLoad.into(imageView);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$loadBackground$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function2<Bitmap, Boolean, Unit> {
        AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
            invoke(bitmap, bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Bitmap bitmap, boolean z) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            ImageView imageView = PlayableItemDetailDialogFragment.this.background;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
                imageView = null;
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$loadBackground$2, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function1<Exception, Unit> {
        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
            invoke2(exc);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            PlayableItemDetailDialogFragment.this.getLogger().warn(PlayableItemDetailDialogFragment.this, ExceptionsKt.stackTraceToString(e));
            ImageView imageView = PlayableItemDetailDialogFragment.this.background;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
                imageView = null;
            }
            imageView.setImageBitmap(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopYoutubeVideo() {
        this.doPlaying = false;
        this.hasPlayed = false;
        this.youTubePlayerCurrentSecond = 0.0f;
        YouTubePlayer youTubePlayer = this.youTubePlayer;
        if (youTubePlayer != null) {
            youTubePlayer.pause();
        }
        YouTubePlayer youTubePlayer2 = this.youTubePlayer;
        if (youTubePlayer2 != null) {
            youTubePlayer2.cueVideo("", 0.0f);
        }
        YouTubePlayerView youTubePlayerView = this.youtubePlayerView;
        Chip chip = null;
        if (youTubePlayerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("youtubePlayerView");
            youTubePlayerView = null;
        }
        youTubePlayerView.setVisibility(8);
        ImageView imageView = this.background;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("background");
            imageView = null;
        }
        imageView.setVisibility(0);
        Chip chip2 = this.previewVideoButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
        } else {
            chip = chip2;
        }
        chip.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playYoutubeVideo(String id2) {
        YouTubePlayer youTubePlayer;
        this.youtubeVideoId = id2;
        Chip chip = this.previewVideoButton;
        YouTubePlayerView youTubePlayerView = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
            chip = null;
        }
        chip.setVisibility(0);
        if (!this.playPreviewVideo || this.connectionType == -1 || (youTubePlayer = this.youTubePlayer) == null) {
            return;
        }
        if (this.doPlaying && this.hasPlayed) {
            YouTubePlayerView youTubePlayerView2 = this.youtubePlayerView;
            if (youTubePlayerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("youtubePlayerView");
            } else {
                youTubePlayerView = youTubePlayerView2;
            }
            youTubePlayerView.setVisibility(0);
            youTubePlayer.play();
            return;
        }
        if (this.makePreviewVideoSounds) {
            youTubePlayer.unMute();
        } else {
            youTubePlayer.mute();
        }
        YouTubePlayerView youTubePlayerView3 = this.youtubePlayerView;
        if (youTubePlayerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("youtubePlayerView");
        } else {
            youTubePlayerView = youTubePlayerView3;
        }
        youTubePlayerView.setVisibility(4);
        this.doPlaying = true;
        youTubePlayer.loadVideo(id2, 90.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadYoutube(PlayableItemEntity playableItemEntity) {
        if (this.isLoadingYoutube) {
            return;
        }
        this.isLoadingYoutube = true;
        stopYoutubeVideo();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C02251(playableItemEntity, null), 2, null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$loadYoutube$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$loadYoutube$1", f = "PlayableItemDetailDialogFragment.kt", i = {}, l = {375}, m = "invokeSuspendImpl", n = {}, s = {})
    final class C02251 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ PlayableItemEntity $playableItemEntity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02251(PlayableItemEntity playableItemEntity, Continuation<?> continuation) {
            super(2, continuation);
            this.$playableItemEntity = playableItemEntity;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return PlayableItemDetailDialogFragment.this.new C02251(this.$playableItemEntity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((C02251) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = new ArrayList();
                DaijishouLibraryModel daijishouLibrary = PlayableItemDetailDialogFragment.this.getDaijishouLibrary();
                Long attachedPlatformId = this.$playableItemEntity.getAttachedPlatformId();
                PlatformEntity platformByIdStatically = daijishouLibrary.getPlatformByIdStatically(attachedPlatformId != null ? attachedPlatformId.longValue() : -1L);
                Long attachedPlatformId2 = this.$playableItemEntity.getAttachedPlatformId();
                if (attachedPlatformId2 != null) {
                    attachedPlatformId2.longValue();
                    if (platformByIdStatically != null) {
                        Boxing.boxBoolean(arrayList.addAll(platformByIdStatically.getScraperSourceList()));
                    }
                }
                PlayableItemDetailDialogFragment playableItemDetailDialogFragment = PlayableItemDetailDialogFragment.this;
                playableItemDetailDialogFragment.youtubeVideoId = playableItemDetailDialogFragment.getDaijishouLibrary().getScraper().scrapeYoutubeVideoIdByKeywords(arrayList, platformByIdStatically != null ? platformByIdStatically.getName() : null, this.$playableItemEntity.getScraperKeywordList());
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(PlayableItemDetailDialogFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PlayableItemDetailDialogFragment.this.isLoadingYoutube = false;
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$loadYoutube$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$loadYoutube$1$2", f = "PlayableItemDetailDialogFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            int label;
            final /* synthetic */ PlayableItemDetailDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(PlayableItemDetailDialogFragment playableItemDetailDialogFragment, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = playableItemDetailDialogFragment;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
                    String str = this.this$0.youtubeVideoId;
                    if (str == null) {
                        return null;
                    }
                    this.this$0.playYoutubeVideo(str);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void refreshDimensionRatioHeight() {
        float fDimensionRatioToFloat = Utils.INSTANCE.dimensionRatioToFloat(this.boxArtAspectRatio);
        ConstraintLayout constraintLayout = null;
        if (fDimensionRatioToFloat > 1.0f) {
            ConstraintLayout constraintLayout2 = this.backgroundSetLayout;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            } else {
                constraintLayout = constraintLayout2;
            }
            ConstraintLayout constraintLayout3 = constraintLayout;
            ViewGroup.LayoutParams layoutParams = constraintLayout3.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = (int) (Math.min(getDpToPxConverter().convert(320.0f), this.displayHeightPixels * 0.42f) * ((float) Math.pow(1.0f / fDimensionRatioToFloat, 0.15f)));
                constraintLayout3.setLayoutParams(layoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        ConstraintLayout constraintLayout4 = this.backgroundSetLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
        } else {
            constraintLayout = constraintLayout4;
        }
        ConstraintLayout constraintLayout5 = constraintLayout;
        ViewGroup.LayoutParams layoutParams2 = constraintLayout5.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = (int) (Math.min(getDpToPxConverter().convert(320.0f), this.displayHeightPixels * 0.42f) * ((float) Math.pow(1.0f / fDimensionRatioToFloat, 0.15f)));
            constraintLayout5.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void refreshPinButton() {
        Chip chip = null;
        if (getMergePlayableItems()) {
            PinAndPlayWidgetBuilder pinAndPlayWidget = getPinAndPlayWidget();
            PlayableItemEntity playableItemEntity = this.playableItemEntity;
            if (playableItemEntity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                playableItemEntity = null;
            }
            if (pinAndPlayWidget.isPlayableItemIdsInAPinAndPlayWidget(playableItemEntity.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds())) {
                Chip chip2 = this.pinButton;
                if (chip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                    chip2 = null;
                }
                if (chip2.isFocused()) {
                    Chip chip3 = this.playButton;
                    if (chip3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("playButton");
                        chip3 = null;
                    }
                    chip3.requestFocus();
                }
                Chip chip4 = this.pinButton;
                if (chip4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                } else {
                    chip = chip4;
                }
                chip.setVisibility(8);
                return;
            }
            Chip chip5 = this.pinButton;
            if (chip5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                chip5 = null;
            }
            chip5.setVisibility(0);
            Chip chip6 = this.pinButton;
            if (chip6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                chip6 = null;
            }
            chip6.setChipIconResource(R.drawable.outline_push_pin_24);
            Chip chip7 = this.pinButton;
            if (chip7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            } else {
                chip = chip7;
            }
            chip.setText(getString(R.string.pin_item));
            return;
        }
        PinAndPlayWidgetBuilder pinAndPlayWidget2 = getPinAndPlayWidget();
        PlayableItemEntity playableItemEntity2 = this.playableItemEntity;
        if (playableItemEntity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity2 = null;
        }
        if (pinAndPlayWidget2.isPlayableItemIdInAPinAndPlayWidget(playableItemEntity2.getId())) {
            Chip chip8 = this.pinButton;
            if (chip8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                chip8 = null;
            }
            if (chip8.isFocused()) {
                Chip chip9 = this.playButton;
                if (chip9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playButton");
                    chip9 = null;
                }
                chip9.requestFocus();
            }
            Chip chip10 = this.pinButton;
            if (chip10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            } else {
                chip = chip10;
            }
            chip.setVisibility(8);
            return;
        }
        Chip chip11 = this.pinButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip11 = null;
        }
        chip11.setVisibility(0);
        Chip chip12 = this.pinButton;
        if (chip12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip12 = null;
        }
        chip12.setChipIconResource(R.drawable.outline_push_pin_24);
        Chip chip13 = this.pinButton;
        if (chip13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
        } else {
            chip = chip13;
        }
        chip.setText(getString(R.string.pin_item));
    }

    private final int getScreenHeight(Activity activity) {
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = activity.getWindowManager().getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
            return currentWindowMetrics.getBounds().height();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshPlayableItem(PlayableItemEntity playableItemEntity) throws IOException {
        PlayableItemEntity playableItemEntity2;
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex;
        String strDecapitalize;
        Drawable drawable;
        String str;
        String str2;
        Drawable drawable2;
        String strDecapitalize2;
        PlayableItemEntity playableItemEntity3 = this.playableItemEntity;
        Chip chip = null;
        if (playableItemEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity2 = null;
        } else {
            playableItemEntity2 = playableItemEntity3;
        }
        this.playableItemEntity = playableItemEntity;
        if (getMergePlayableItems()) {
            getDaijishouLibrary().injectPlayableItemWithMergedInfo(playableItemEntity);
        }
        String str3 = playableItemEntity.getPreviewMediaPath() + "index.json";
        if (new File(str3).exists()) {
            String string = IOUtils.toString(new FileInputStream(str3), StandardCharsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex$$serializer.INSTANCE, string);
        } else {
            playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }
        Date date = new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3492getRecentDurationDefinitionUwyO8pc()));
        Date date2 = new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3491getNewlyDurationDefinitionUwyO8pc()));
        TextView textView = this.titleTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        textView.setText(getDaijishouLibrary().prettifyTitleWithPreferences(playableItemEntity.getName()));
        TextView textView2 = this.titleTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView2 = null;
        }
        textView2.setSelected(true);
        if (getMergePlayableItems()) {
            TextView textView3 = this.descriptionTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
                textView3 = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str4 = this.descriptionFormatString;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionFormatString");
                str4 = null;
            }
            if (playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp() != null) {
                Utils utils = Utils.INSTANCE;
                Date mergedLastPlayedTimestamp = playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp();
                Intrinsics.checkNotNull(mergedLastPlayedTimestamp);
                strDecapitalize2 = StringsKt.decapitalize(utils.getRelativeTimeString(mergedLastPlayedTimestamp.getTime()));
            } else {
                String str5 = this.noneString;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noneString");
                    strDecapitalize2 = null;
                } else {
                    strDecapitalize2 = str5;
                }
            }
            String str6 = String.format(str4, Arrays.copyOf(new Object[]{strDecapitalize2, Integer.valueOf(playableItemEntity.getMergedInfo().getMergedPlayedCount())}, 2));
            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
            textView3.setText(str6);
        } else {
            TextView textView4 = this.descriptionTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
                textView4 = null;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str7 = this.descriptionFormatString;
            if (str7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionFormatString");
                str7 = null;
            }
            if (playableItemEntity.getLastPlayedTimestamp() != null) {
                Utils utils2 = Utils.INSTANCE;
                Date lastPlayedTimestamp = playableItemEntity.getLastPlayedTimestamp();
                Intrinsics.checkNotNull(lastPlayedTimestamp);
                strDecapitalize = StringsKt.decapitalize(utils2.getRelativeTimeString(lastPlayedTimestamp.getTime()));
            } else {
                String str8 = this.noneString;
                if (str8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noneString");
                    strDecapitalize = null;
                } else {
                    strDecapitalize = str8;
                }
            }
            String str9 = String.format(str7, Arrays.copyOf(new Object[]{strDecapitalize, Integer.valueOf(playableItemEntity.getPlayCount())}, 2));
            Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
            textView4.setText(str9);
        }
        List<String> genreIdsByPlayableItemIdStatically = getDaijishouLibrary().getGenreIdsByPlayableItemIdStatically(playableItemEntity.getId());
        if (!genreIdsByPlayableItemIdStatically.isEmpty()) {
            TextView textView5 = this.genresTextView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("genresTextView");
                textView5 = null;
            }
            int size = genreIdsByPlayableItemIdStatically.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Genre genre = Genres.INSTANCE.getGenres().get(genreIdsByPlayableItemIdStatically.get(i));
                arrayList.add(getString(genre != null ? genre.getNameStringId() : R.string.unknown_genre_name));
            }
            textView5.setText(CollectionsKt.joinToString$default(arrayList, " • ", null, null, 0, null, null, 62, null));
        }
        if (getMergePlayableItems()) {
            Chip chip2 = this.favoriteButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip2 = null;
            }
            if (playableItemEntity.getMergedInfo().getMergedIsFavorite()) {
                drawable2 = this.isFavoriteDrawable;
                if (drawable2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isFavoriteDrawable");
                    drawable2 = null;
                }
            } else {
                Drawable drawable3 = this.isNotFavoriteDrawable;
                if (drawable3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isNotFavoriteDrawable");
                    drawable2 = null;
                } else {
                    drawable2 = drawable3;
                }
            }
            chip2.setChipIcon(drawable2);
        } else {
            Chip chip3 = this.favoriteButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip3 = null;
            }
            if (playableItemEntity.isFavorite()) {
                drawable = this.isFavoriteDrawable;
                if (drawable == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isFavoriteDrawable");
                    drawable = null;
                }
            } else {
                Drawable drawable4 = this.isNotFavoriteDrawable;
                if (drawable4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isNotFavoriteDrawable");
                    drawable = null;
                } else {
                    drawable = drawable4;
                }
            }
            chip3.setChipIcon(drawable);
        }
        if (getMergePlayableItems()) {
            Chip chip4 = this.favoriteButton;
            if (chip4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip4 = null;
            }
            if (playableItemEntity.getMergedInfo().getMergedIsFavorite()) {
                String str10 = this.isFavoriteString;
                if (str10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isFavoriteString");
                    str10 = null;
                }
                str2 = str10;
            } else {
                String str11 = this.addFavoriteString;
                if (str11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addFavoriteString");
                    str11 = null;
                }
                str2 = str11;
            }
            chip4.setText(str2);
        } else {
            Chip chip5 = this.favoriteButton;
            if (chip5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip5 = null;
            }
            if (playableItemEntity.isFavorite()) {
                String str12 = this.isFavoriteString;
                if (str12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isFavoriteString");
                    str12 = null;
                }
                str = str12;
            } else {
                String str13 = this.addFavoriteString;
                if (str13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addFavoriteString");
                    str13 = null;
                }
                str = str13;
            }
            chip5.setText(str);
        }
        refreshPinButton();
        if (getMergePlayableItems()) {
            ImageView imageView = this.favoriteImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteImageView");
                imageView = null;
            }
            imageView.setVisibility(playableItemEntity.getMergedInfo().getMergedIsFavorite() ? 0 : 8);
        } else {
            ImageView imageView2 = this.favoriteImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteImageView");
                imageView2 = null;
            }
            imageView2.setVisibility(playableItemEntity.isFavorite() ? 0 : 8);
        }
        Date mergedLastPlayedTimestamp2 = getMergePlayableItems() ? playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp() : playableItemEntity.getLastPlayedTimestamp();
        if (mergedLastPlayedTimestamp2 != null) {
            Chip chip6 = this.recentButton;
            if (chip6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                chip6 = null;
            }
            chip6.setVisibility(mergedLastPlayedTimestamp2.after(date) ? 0 : 8);
            ImageView imageView3 = this.recentImageView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentImageView");
                imageView3 = null;
            }
            imageView3.setVisibility(mergedLastPlayedTimestamp2.after(date) ? 0 : 8);
        } else {
            Chip chip7 = this.recentButton;
            if (chip7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                chip7 = null;
            }
            chip7.setVisibility(8);
            ImageView imageView4 = this.recentImageView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentImageView");
                imageView4 = null;
            }
            imageView4.setVisibility(8);
        }
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.SHOW_SIMILAR_ITEMS.getKey(), BooleanPreference.SHOW_SIMILAR_ITEMS.getDefaultValue())) {
            DaijishouLibraryModel daijishouLibrary = getDaijishouLibrary();
            PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) DaijishouLibraryModel.getSimilarPlayableItems$default(getDaijishouLibrary(), playableItemEntity, 0, false, 6, null).toArray(new PlayableItemEntity[0]);
            List<PlayableItemEntity> mergedPlayableItemsWithPreferences = daijishouLibrary.getMergedPlayableItemsWithPreferences((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : mergedPlayableItemsWithPreferences) {
                if (!Intrinsics.areEqual(((PlayableItemEntity) obj).getDisjointSetPrimaryPlayableItemId(), playableItemEntity.getDisjointSetPrimaryPlayableItemId()) || !getMergePlayableItems()) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            LinearLayout linearLayout = this.similarItemsLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("similarItemsLayout");
                linearLayout = null;
            }
            linearLayout.setVisibility(arrayList3.isEmpty() ? 8 : 0);
            this.similarPlayableItemList.clear();
            this.similarPlayableItemList.addAll(arrayList3);
            SimilarListAdapter similarListAdapter = this.similarItemsRecyclerViewAdapter;
            if (similarListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerViewAdapter");
                similarListAdapter = null;
            }
            similarListAdapter.notifyDataSetChanged();
            DaijishouRecyclerView daijishouRecyclerView = this.similarItemsRecyclerView;
            if (daijishouRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerView");
                daijishouRecyclerView = null;
            }
            daijishouRecyclerView.scrollToPosition(0);
        } else {
            LinearLayout linearLayout2 = this.similarItemsLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("similarItemsLayout");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
        }
        Date mergedAddedDateTimestamp = getMergePlayableItems() ? playableItemEntity.getMergedInfo().getMergedAddedDateTimestamp() : playableItemEntity.getAddedDateTimestamp();
        Chip chip8 = this.newlyButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip8 = null;
        }
        chip8.setVisibility(mergedAddedDateTimestamp.after(date2) ? 0 : 8);
        ImageView imageView5 = this.newlyImageView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyImageView");
            imageView5 = null;
        }
        imageView5.setVisibility(mergedAddedDateTimestamp.after(date2) ? 0 : 8);
        loadBoxArt(playableItemEntity.getPreviewMediaPath() + playableItemPreviewMediaIndex.getBoxArtPath());
        loadBackground(playableItemEntity.getPreviewMediaPath() + playableItemPreviewMediaIndex.getSnapshotPath());
        if (playableItemEntity2.getId() != playableItemEntity.getId() || this.youtubeVideoId == null) {
            loadYoutube(playableItemEntity);
        }
        Chip chip9 = this.recentButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip9 = null;
        }
        chip9.requestLayout();
        Chip chip10 = this.newlyButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
        } else {
            chip = chip10;
        }
        chip.requestLayout();
    }

    public final void refreshPlatform(PlatformEntity platform) {
        String customBoxArtAspectRatio;
        Intrinsics.checkNotNullParameter(platform, "platform");
        getLogger().debug(this, "refreshPlatform");
        this.platformName = platform.getName();
        String shortname = platform.getShortname();
        TextView textView = this.platformTextView;
        ConstraintLayout constraintLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformTextView");
            textView = null;
        }
        String upperCase = shortname.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        textView.setText(upperCase);
        TextView textView2 = this.platformDescriptionTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformDescriptionTextView");
            textView2 = null;
        }
        textView2.setText(this.platformName);
        TextView textView3 = this.platformDescriptionTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformDescriptionTextView");
            textView3 = null;
        }
        textView3.setSelected(true);
        if (!platform.getUseCustomBoxArtAspectRatio() || platform.getCustomBoxArtAspectRatio() == null) {
            List<String> list = this.boxArtAspectRatioList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("boxArtAspectRatioList");
                list = null;
            }
            customBoxArtAspectRatio = list.get(platform.getBoxArtAspectRatioId());
        } else {
            customBoxArtAspectRatio = platform.getCustomBoxArtAspectRatio();
            Intrinsics.checkNotNull(customBoxArtAspectRatio);
        }
        this.boxArtAspectRatio = customBoxArtAspectRatio;
        ConstraintLayout constraintLayout2 = this.backgroundSetLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams = constraintLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = this.boxArtAspectRatio;
        getLogger().debug(this, "refreshPlatform boxArtAspectRatio: " + this.boxArtAspectRatio);
        refreshDimensionRatioHeight();
        ConstraintLayout constraintLayout3 = this.backgroundSetLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
        } else {
            constraintLayout = constraintLayout3;
        }
        constraintLayout.requestLayout();
    }

    private final String getRetroAchievementsGame0PlayerString() {
        return (String) this.retroAchievementsGame0PlayerString.getValue();
    }

    private final String getRetroAchievementsGameMoreThen64PlayersString() {
        return (String) this.retroAchievementsGameMoreThen64PlayersString.getValue();
    }

    private final String getRetroAchievementsGameMoreThen128PlayersString() {
        return (String) this.retroAchievementsGameMoreThen128PlayersString.getValue();
    }

    private final String getRetroAchievementsGameMoreThen256PlayersString() {
        return (String) this.retroAchievementsGameMoreThen256PlayersString.getValue();
    }

    private final String getRetroAchievementsGameMoreThen512PlayersString() {
        return (String) this.retroAchievementsGameMoreThen512PlayersString.getValue();
    }

    private final String getRetroAchievementsGameMoreThen1024PlayersString() {
        return (String) this.retroAchievementsGameMoreThen1024PlayersString.getValue();
    }

    private final String getRetroAchievementsGameMoreThen2048PlayersString() {
        return (String) this.retroAchievementsGameMoreThen2048PlayersString.getValue();
    }

    private final String getRetroAchievementsGameMoreThen4096PlayersString() {
        return (String) this.retroAchievementsGameMoreThen4096PlayersString.getValue();
    }

    private final String getRetroAchievementsGameMoreThen8192PlayersString() {
        return (String) this.retroAchievementsGameMoreThen8192PlayersString.getValue();
    }

    private final String getRetroAchievementsGameMoreThen16284PlayersString() {
        return (String) this.retroAchievementsGameMoreThen16284PlayersString.getValue();
    }

    public final String getPlayerCountLabel(long playerCount) {
        if (playerCount == 0) {
            String retroAchievementsGame0PlayerString = getRetroAchievementsGame0PlayerString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGame0PlayerString, "<get-retroAchievementsGame0PlayerString>(...)");
            return retroAchievementsGame0PlayerString;
        }
        if (64 <= playerCount && playerCount < 128) {
            String retroAchievementsGameMoreThen64PlayersString = getRetroAchievementsGameMoreThen64PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen64PlayersString, "<get-retroAchievementsGa…Then64PlayersString>(...)");
            return retroAchievementsGameMoreThen64PlayersString;
        }
        if (128 <= playerCount && playerCount < 256) {
            String retroAchievementsGameMoreThen128PlayersString = getRetroAchievementsGameMoreThen128PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen128PlayersString, "<get-retroAchievementsGa…hen128PlayersString>(...)");
            return retroAchievementsGameMoreThen128PlayersString;
        }
        if (256 <= playerCount && playerCount < 512) {
            String retroAchievementsGameMoreThen256PlayersString = getRetroAchievementsGameMoreThen256PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen256PlayersString, "<get-retroAchievementsGa…hen256PlayersString>(...)");
            return retroAchievementsGameMoreThen256PlayersString;
        }
        if (512 <= playerCount && playerCount < 1024) {
            String retroAchievementsGameMoreThen512PlayersString = getRetroAchievementsGameMoreThen512PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen512PlayersString, "<get-retroAchievementsGa…hen512PlayersString>(...)");
            return retroAchievementsGameMoreThen512PlayersString;
        }
        if (1024 <= playerCount && playerCount < PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
            String retroAchievementsGameMoreThen1024PlayersString = getRetroAchievementsGameMoreThen1024PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen1024PlayersString, "<get-retroAchievementsGa…en1024PlayersString>(...)");
            return retroAchievementsGameMoreThen1024PlayersString;
        }
        if (PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH <= playerCount && playerCount < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            String retroAchievementsGameMoreThen2048PlayersString = getRetroAchievementsGameMoreThen2048PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen2048PlayersString, "<get-retroAchievementsGa…en2048PlayersString>(...)");
            return retroAchievementsGameMoreThen2048PlayersString;
        }
        if (PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM <= playerCount && playerCount < PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
            String retroAchievementsGameMoreThen4096PlayersString = getRetroAchievementsGameMoreThen4096PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen4096PlayersString, "<get-retroAchievementsGa…en4096PlayersString>(...)");
            return retroAchievementsGameMoreThen4096PlayersString;
        }
        if (PlaybackStateCompat.ACTION_PLAY_FROM_URI <= playerCount && playerCount < 16284) {
            String retroAchievementsGameMoreThen8192PlayersString = getRetroAchievementsGameMoreThen8192PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen8192PlayersString, "<get-retroAchievementsGa…en8192PlayersString>(...)");
            return retroAchievementsGameMoreThen8192PlayersString;
        }
        String retroAchievementsGameMoreThen16284PlayersString = getRetroAchievementsGameMoreThen16284PlayersString();
        Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen16284PlayersString, "<get-retroAchievementsGa…n16284PlayersString>(...)");
        return retroAchievementsGameMoreThen16284PlayersString;
    }

    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment$SimilarListAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "playableItemEntityList", "", "(Lcom/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment$SimilarListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class SimilarListAdapter extends DaijishouRecyclerView.Adapter<PlayableItemEntity> {
        private final List<PlayableItemEntity> playableItemEntityList;
        final /* synthetic */ PlayableItemDetailDialogFragment this$0;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return position;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SimilarListAdapter(PlayableItemDetailDialogFragment playableItemDetailDialogFragment, List<PlayableItemEntity> playableItemEntityList) {
            super(playableItemEntityList, false, false, 6, null);
            Intrinsics.checkNotNullParameter(playableItemEntityList, "playableItemEntityList");
            this.this$0 = playableItemDetailDialogFragment;
            this.playableItemEntityList = playableItemEntityList;
        }

        /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment$SimilarListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment$SimilarListAdapter;Landroid/view/View;)V", "favoriteImageView", "Landroid/widget/ImageView;", "firstLine", "Landroid/widget/TextView;", "newlyImageView", "recentImageView", "secondLine", "onBind", "", "position", "", "item", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlayableItemEntity>.ViewHolder {
            private final ImageView favoriteImageView;
            private final TextView firstLine;
            private final ImageView newlyImageView;
            private final ImageView recentImageView;
            private final TextView secondLine;
            final /* synthetic */ SimilarListAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(SimilarListAdapter similarListAdapter, View itemView) {
                super(similarListAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = similarListAdapter;
                View viewFindViewById = itemView.findViewById(R.id.list_item_log_record_first_line);
                Intrinsics.checkNotNull(viewFindViewById);
                this.firstLine = (TextView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R.id.list_item_log_record_second_line);
                Intrinsics.checkNotNull(viewFindViewById2);
                this.secondLine = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R.id.similar_list_item_recent_image_view);
                Intrinsics.checkNotNull(viewFindViewById3);
                this.recentImageView = (ImageView) viewFindViewById3;
                View viewFindViewById4 = itemView.findViewById(R.id.similar_list_item_newly_image_view);
                Intrinsics.checkNotNull(viewFindViewById4);
                this.newlyImageView = (ImageView) viewFindViewById4;
                View viewFindViewById5 = itemView.findViewById(R.id.similar_list_item_favorite_image_view);
                Intrinsics.checkNotNull(viewFindViewById5);
                this.favoriteImageView = (ImageView) viewFindViewById5;
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, PlayableItemEntity item) {
                String upperCase;
                Intrinsics.checkNotNullParameter(item, "item");
                if (this.this$0.this$0.colorThemeTintList != null) {
                    PlayableItemDetailDialogFragment playableItemDetailDialogFragment = this.this$0.this$0;
                    TextView textView = this.secondLine;
                    ColorStateList colorStateList = playableItemDetailDialogFragment.colorThemeTintList;
                    Intrinsics.checkNotNull(colorStateList);
                    textView.setBackgroundTintList(colorStateList);
                    TextView textView2 = this.secondLine;
                    ColorStateList colorStateList2 = playableItemDetailDialogFragment.colorOnThemeTintList;
                    Intrinsics.checkNotNull(colorStateList2);
                    textView2.setTextColor(colorStateList2);
                }
                this.firstLine.setText(this.this$0.this$0.getDaijishouLibrary().prettifyTitleWithPreferences(item.getName()));
                Long attachedPlatformId = item.getAttachedPlatformId();
                if (attachedPlatformId != null) {
                    PlatformEntity platformByIdStatically = this.this$0.this$0.getDaijishouLibrary().getPlatformByIdStatically(attachedPlatformId.longValue());
                    if (platformByIdStatically != null) {
                        TextView textView3 = this.secondLine;
                        if (new Regex("[^0-9a-zA-Z\\s]+").containsMatchIn(platformByIdStatically.getName()) || platformByIdStatically.getName().length() > 12) {
                            String shortname = platformByIdStatically.getShortname();
                            Locale ROOT = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                            upperCase = shortname.toUpperCase(ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        } else {
                            upperCase = platformByIdStatically.getName();
                        }
                        textView3.setText(upperCase);
                    }
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3492getRecentDurationDefinitionUwyO8pc());
                long jCurrentTimeMillis2 = System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3491getNewlyDurationDefinitionUwyO8pc());
                Date lastPlayedTimestamp = item.getLastPlayedTimestamp();
                Long lValueOf = lastPlayedTimestamp != null ? Long.valueOf(lastPlayedTimestamp.getTime()) : null;
                if (lValueOf != null) {
                    this.recentImageView.setVisibility(lValueOf.longValue() > jCurrentTimeMillis ? 0 : 8);
                } else {
                    this.recentImageView.setVisibility(8);
                }
                this.newlyImageView.setVisibility(item.getAddedDateTimestamp().getTime() > jCurrentTimeMillis2 ? 0 : 8);
                this.favoriteImageView.setVisibility(item.isFavorite() ? 0 : 8);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_similar_playable_item, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        String string = getString(R.string.none_lowercase);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.noneString = string;
        String string2 = getString(R.string.add_favorite);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.addFavoriteString = string2;
        String string3 = getString(R.string.is_favorite);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.isFavoriteString = string3;
        this.descriptionFormatString = "🕑 " + getString(R.string.playable_item_subtitle_format);
        String string4 = getString(R.string.retro_achievements_achievement_unavailable);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this.retroAchievementsUnavailableString = string4;
        String string5 = getString(R.string.retro_achievements_achievement_unavailable_with_emoji);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.retroAchievementsUnavailableWithEmojiString = string5;
        String string6 = getString(R.string.retro_achievements_refreshing);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        this.retroAchievementsRefreshingString = string6;
        String string7 = getString(R.string.retro_achievements_login_required_with_emoji);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        this.retroAchievementsLoginRequiredWitEmojiString = string7;
        String string8 = getString(R.string.retro_achievements_login_required_detail);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        this.retroAchievementsLoginRequiredDetailString = string8;
        String string9 = getString(R.string.retro_achievements_game_description_format);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        this.retroAchievementsDescriptionFormatString = string9;
        String string10 = getString(R.string.retro_achievements_game_description_new_format);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        this.retroAchievementsDescriptionNewFormatString = string10;
        String string11 = getString(R.string.retro_achievements_game_description_with_player_count_format);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        this.retroAchievementsDescriptionWithPlayerCountFormatString = string11;
        String string12 = getString(R.string.retro_achievements_game_rating_format);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        this.retroAchievementsDescriptionWithRatingFormatString = string12;
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_round_favorite_24, contextRequireContext.getTheme());
        Intrinsics.checkNotNull(drawable);
        this.isFavoriteDrawable = drawable;
        Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_round_favorite_border_24, contextRequireContext.getTheme());
        Intrinsics.checkNotNull(drawable2);
        this.isNotFavoriteDrawable = drawable2;
        String[] stringArray = getResources().getStringArray(R.array.box_art_aspect_ratio_array);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        this.boxArtAspectRatioList = ArraysKt.toList(stringArray);
        String[] stringArray2 = getResources().getStringArray(R.array.screen_aspect_ratio_array);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "getStringArray(...)");
        this.screenAspectRatioList = ArraysKt.toList(stringArray2);
        this.playPreviewVideo = getDefaultSharedPreferences().getBoolean(BooleanPreference.PLAY_PREVIEW_VIDEO.getKey(), BooleanPreference.PLAY_PREVIEW_VIDEO.getDefaultValue());
        this.makePreviewVideoSounds = getDefaultSharedPreferences().getBoolean(BooleanPreference.MAKE_PREVIEW_VIDEO_SOUNDS.getKey(), BooleanPreference.MAKE_PREVIEW_VIDEO_SOUNDS.getDefaultValue());
        this.retroAchievementsNextRefreshDate = new Date();
        this.retroAchievementsRefreshing = false;
        if (Build.VERSION.SDK_INT >= 33) {
            Object parcelable = bundleRequireArguments.getParcelable("playableItemEntity", PlayableItemEntity.class);
            Intrinsics.checkNotNull(parcelable);
            this.playableItemEntity = (PlayableItemEntity) parcelable;
        } else {
            Parcelable parcelable2 = bundleRequireArguments.getParcelable("playableItemEntity");
            Intrinsics.checkNotNull(parcelable2);
            this.playableItemEntity = (PlayableItemEntity) parcelable2;
        }
        this.retroAchievementsSharedPreferences = getRetroAchievementsManager().getRetroAchievementsSharedPreferences();
        this.displayHeightPixels = getScreenHeight(fragmentActivityRequireActivity);
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setRetroAchievementsManager(((DaijishouApplication) application).getRetroAchievementsManager());
        if (this.playableItemViewedEventRegistered) {
            return;
        }
        DaijishouLibraryModel daijishouLibrary = getDaijishouLibrary();
        PlayableItemEntity playableItemEntity = this.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        daijishouLibrary.registerPlayableItemViewedEvent(playableItemEntity);
        this.playableItemViewedEventRegistered = true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.heightPixels / displayMetrics.widthPixels;
        if (f < 1.0f) {
            f = 1.0f / f;
        }
        new PlayableItemDetailDialogFragment$onCreateView$smoothScroller$1(contextRequireContext);
        View viewInflate = inflater.inflate(R.layout.fragment_playable_item_detail, container, true);
        View viewFindViewById = viewInflate.findViewById(R.id.rounded_full_screen_dialog_root);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.root = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.playable_item_detail_scroll_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.detailScrollView = (ScrollView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.playable_item_detail_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.titleTextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.playable_item_detail_platform_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.platformTextView = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.playable_item_detail_platform_description_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.platformDescriptionTextView = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.playable_item_detail_genres_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.genresTextView = (TextView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.playable_item_detail_retro_achievements_textview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.retroAchievementsTextView = (TextView) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.playable_item_detail_description_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.descriptionTextView = (TextView) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(R.id.playable_item_detail_detail_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.detailTextView = (TextView) viewFindViewById9;
        View viewFindViewById10 = viewInflate.findViewById(R.id.playable_item_detail_thumbnail);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.thumbnail = (ImageView) viewFindViewById10;
        View viewFindViewById11 = viewInflate.findViewById(R.id.playable_item_detail_content_grad);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.gradientImageView = (ImageView) viewFindViewById11;
        View viewFindViewById12 = viewInflate.findViewById(R.id.rounded_full_screen_dialog_background);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.background = (ImageView) viewFindViewById12;
        View viewFindViewById13 = viewInflate.findViewById(R.id.playable_item_detail_recent_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.recentImageView = (ImageView) viewFindViewById13;
        View viewFindViewById14 = viewInflate.findViewById(R.id.playable_item_detail_newly_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.newlyImageView = (ImageView) viewFindViewById14;
        View viewFindViewById15 = viewInflate.findViewById(R.id.playable_item_detail_favorite_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.favoriteImageView = (ImageView) viewFindViewById15;
        View viewFindViewById16 = viewInflate.findViewById(R.id.playable_item_detail_background_set);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.backgroundSetLayout = (ConstraintLayout) viewFindViewById16;
        View viewFindViewById17 = viewInflate.findViewById(R.id.rounded_full_screen_dialog_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.detailContainerLayout = (ConstraintLayout) viewFindViewById17;
        View viewFindViewById18 = viewInflate.findViewById(R.id.playable_item_detail_placeholder);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.placeholder = (ImageView) viewFindViewById18;
        View viewFindViewById19 = viewInflate.findViewById(R.id.player_associated_platforms_horizontal_scroll_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        this.horizontalScrollView = (HorizontalScrollView) viewFindViewById19;
        View viewFindViewById20 = viewInflate.findViewById(R.id.playable_item_detail_preview_video_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
        this.previewVideoButton = (Chip) viewFindViewById20;
        View viewFindViewById21 = viewInflate.findViewById(R.id.playable_item_detail_play_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
        this.playButton = (Chip) viewFindViewById21;
        View viewFindViewById22 = viewInflate.findViewById(R.id.playable_item_detail_favorite_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById22, "findViewById(...)");
        this.favoriteButton = (Chip) viewFindViewById22;
        View viewFindViewById23 = viewInflate.findViewById(R.id.playable_item_detail_pin_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById23, "findViewById(...)");
        this.pinButton = (Chip) viewFindViewById23;
        View viewFindViewById24 = viewInflate.findViewById(R.id.playable_item_detail_recent_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById24, "findViewById(...)");
        this.recentButton = (Chip) viewFindViewById24;
        View viewFindViewById25 = viewInflate.findViewById(R.id.playable_item_detail_newly_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById25, "findViewById(...)");
        this.newlyButton = (Chip) viewFindViewById25;
        View viewFindViewById26 = viewInflate.findViewById(R.id.playable_item_detail_edit_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById26, "findViewById(...)");
        this.editButton = (Chip) viewFindViewById26;
        View viewFindViewById27 = viewInflate.findViewById(R.id.playable_item_detail_similar_items_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById27, "findViewById(...)");
        this.similarItemsRecyclerView = (DaijishouRecyclerView) viewFindViewById27;
        this.similarItemsRecyclerViewAdapter = new SimilarListAdapter(this, this.similarPlayableItemList);
        this.similarItemsRecyclerViewLayoutManager = new DaijishouLinearLayoutManager(contextRequireContext, 0, false);
        View viewFindViewById28 = viewInflate.findViewById(R.id.playable_item_detail_similar_items_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById28, "findViewById(...)");
        this.similarItemsLayout = (LinearLayout) viewFindViewById28;
        View viewFindViewById29 = viewInflate.findViewById(R.id.playable_item_detail_youtube_player_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById29, "findViewById(...)");
        this.youtubePlayerView = (YouTubePlayerView) viewFindViewById29;
        this.similarPlayableItemList.clear();
        Chip chip = this.editButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip = null;
        }
        chip.setVisibility(getIsKioskMode() ? 8 : 0);
        ScrollView scrollView = this.detailScrollView;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailScrollView");
            scrollView = null;
        }
        scrollView.setOnScrollChangeListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda0(this));
        ImageView imageView = this.gradientImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradientImageView");
            imageView = null;
        }
        imageView.setVisibility(8);
        Chip chip2 = this.previewVideoButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
            chip2 = null;
        }
        Typeface typeface2 = typeface;
        chip2.setTypeface(typeface2);
        Chip chip3 = this.playButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip3 = null;
        }
        chip3.setTypeface(null, 3);
        Chip chip4 = this.favoriteButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip4 = null;
        }
        chip4.setTypeface(null, 1);
        Chip chip5 = this.pinButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip5 = null;
        }
        chip5.setTypeface(null, 1);
        Chip chip6 = this.recentButton;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip6 = null;
        }
        chip6.setTypeface(typeface2);
        Chip chip7 = this.newlyButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip7 = null;
        }
        chip7.setTypeface(typeface2);
        Chip chip8 = this.editButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip8 = null;
        }
        chip8.setTypeface(typeface2);
        Lifecycle lifecycle = getLifecycle();
        YouTubePlayerView youTubePlayerView = this.youtubePlayerView;
        if (youTubePlayerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("youtubePlayerView");
            youTubePlayerView = null;
        }
        lifecycle.addObserver(youTubePlayerView);
        ConstraintLayout constraintLayout = this.detailContainerLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailContainerLayout");
            constraintLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ConstraintLayout.LayoutParams) layoutParams).setMargins(0, getDpToPxConverter().convert(20.0f), 0, 0);
        DaijishouLinearLayoutManager daijishouLinearLayoutManager = this.similarItemsRecyclerViewLayoutManager;
        if (daijishouLinearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerViewLayoutManager");
            daijishouLinearLayoutManager = null;
        }
        daijishouLinearLayoutManager.setFocusBoundEdge(false);
        DaijishouLinearLayoutManager daijishouLinearLayoutManager2 = this.similarItemsRecyclerViewLayoutManager;
        if (daijishouLinearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerViewLayoutManager");
            daijishouLinearLayoutManager2 = null;
        }
        daijishouLinearLayoutManager2.setFocusBoundStart(true);
        DaijishouLinearLayoutManager daijishouLinearLayoutManager3 = this.similarItemsRecyclerViewLayoutManager;
        if (daijishouLinearLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerViewLayoutManager");
            daijishouLinearLayoutManager3 = null;
        }
        daijishouLinearLayoutManager3.setFocusBoundEnd(true);
        DaijishouRecyclerView daijishouRecyclerView = this.similarItemsRecyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerView");
            daijishouRecyclerView = null;
        }
        DaijishouLinearLayoutManager daijishouLinearLayoutManager4 = this.similarItemsRecyclerViewLayoutManager;
        if (daijishouLinearLayoutManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerViewLayoutManager");
            daijishouLinearLayoutManager4 = null;
        }
        daijishouRecyclerView.setLayoutManager(daijishouLinearLayoutManager4);
        DaijishouRecyclerView daijishouRecyclerView2 = this.similarItemsRecyclerView;
        if (daijishouRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerView");
            daijishouRecyclerView2 = null;
        }
        SimilarListAdapter similarListAdapter = this.similarItemsRecyclerViewAdapter;
        if (similarListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerViewAdapter");
            similarListAdapter = null;
        }
        daijishouRecyclerView2.setAdapter(similarListAdapter);
        if (f > 2.1111112f) {
            ConstraintLayout constraintLayout2 = this.detailContainerLayout;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailContainerLayout");
                constraintLayout2 = null;
            }
            ViewGroup.LayoutParams layoutParams2 = constraintLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams2).dimensionRatio = Constants.layoutDimensionRatio;
            ConstraintLayout constraintLayout3 = this.detailContainerLayout;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailContainerLayout");
                constraintLayout3 = null;
            }
            constraintLayout3.requestLayout();
        }
        YouTubePlayerView youTubePlayerView2 = this.youtubePlayerView;
        if (youTubePlayerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("youtubePlayerView");
            youTubePlayerView2 = null;
        }
        youTubePlayerView2.setClipToOutline(true);
        YouTubePlayerView youTubePlayerView3 = this.youtubePlayerView;
        if (youTubePlayerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("youtubePlayerView");
            youTubePlayerView3 = null;
        }
        youTubePlayerView3.initialize(new C02262(), new IFramePlayerOptions.Builder().controls(0).build());
        YouTubePlayerView youTubePlayerView4 = this.youtubePlayerView;
        if (youTubePlayerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("youtubePlayerView");
            youTubePlayerView4 = null;
        }
        youTubePlayerView4.getYouTubePlayerWhenReady(new AnonymousClass3());
        DaijishouRecyclerView daijishouRecyclerView3 = this.similarItemsRecyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerView");
            daijishouRecyclerView3 = null;
        }
        daijishouRecyclerView3.addOnScrollListener(new AnonymousClass4());
        ConstraintLayout constraintLayout4 = this.backgroundSetLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout4 = null;
        }
        constraintLayout4.setOnFocusChangeListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda16());
        Chip chip9 = this.playButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip9 = null;
        }
        chip9.setOnFocusChangeListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda17());
        Chip chip10 = this.favoriteButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip10 = null;
        }
        chip10.setOnFocusChangeListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda1());
        Chip chip11 = this.pinButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip11 = null;
        }
        chip11.setOnFocusChangeListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda2());
        Chip chip12 = this.previewVideoButton;
        if (chip12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
            chip12 = null;
        }
        chip12.setOnFocusChangeListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda3());
        Chip chip13 = this.recentButton;
        if (chip13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip13 = null;
        }
        chip13.setOnFocusChangeListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda4());
        Chip chip14 = this.newlyButton;
        if (chip14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip14 = null;
        }
        chip14.setOnFocusChangeListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda5());
        Chip chip15 = this.editButton;
        if (chip15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip15 = null;
        }
        chip15.setOnFocusChangeListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda6());
        ConstraintLayout constraintLayout5 = this.backgroundSetLayout;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout5 = null;
        }
        constraintLayout5.setOnClickListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda7(this, fragmentActivityRequireActivity));
        TextView textView = this.retroAchievementsTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsTextView");
            textView = null;
        }
        textView.setOnClickListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda9(this, fragmentActivityRequireActivity));
        Chip chip16 = this.playButton;
        if (chip16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip16 = null;
        }
        chip16.setOnClickListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda10(this, fragmentActivityRequireActivity));
        Chip chip17 = this.favoriteButton;
        if (chip17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip17 = null;
        }
        chip17.setOnClickListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda11(this));
        Chip chip18 = this.pinButton;
        if (chip18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip18 = null;
        }
        chip18.setOnClickListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda12(this));
        Chip chip19 = this.previewVideoButton;
        if (chip19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
            chip19 = null;
        }
        chip19.setOnClickListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda13(this));
        Chip chip20 = this.editButton;
        if (chip20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip20 = null;
        }
        chip20.setOnClickListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda14(this));
        TextView textView2 = this.detailTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
            textView2 = null;
        }
        textView2.setOnClickListener(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda15(this));
        SimilarListAdapter similarListAdapter2 = this.similarItemsRecyclerViewAdapter;
        if (similarListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerViewAdapter");
            similarListAdapter2 = null;
        }
        similarListAdapter2.setOnItemClickListener(new AnonymousClass21());
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        PlayableItemEntity playableItemEntity = this.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        try {
            refreshPlayableItem(playableItemEntity);
        } catch (java.io.IOException e) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
        }
        PlayableItemDetailViewModel playableItemDetailViewModel = getPlayableItemDetailViewModel();
        PlayableItemEntity playableItemEntity2 = this.playableItemEntity;
        if (playableItemEntity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity2 = null;
        }
        LiveData<PlayableItemEntity> liveDataSelectedPlayableItem = playableItemDetailViewModel.selectedPlayableItem(playableItemEntity2);
        PlayableItemDetailDialogFragment playableItemDetailDialogFragment = this;
        liveDataSelectedPlayableItem.observe(playableItemDetailDialogFragment, new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass22(booleanRef, this)));
        PlayableItemEntity playableItemEntity3 = this.playableItemEntity;
        if (playableItemEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity3 = null;
        }
        Long attachedPlatformId = playableItemEntity3.getAttachedPlatformId();
        if (attachedPlatformId != null) {
            PlatformEntity platformByIdStatically = getDaijishouLibrary().getPlatformByIdStatically(attachedPlatformId.longValue());
            if (platformByIdStatically != null) {
                refreshPlatform(platformByIdStatically);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
        }
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = true;
        getPlayableItemDetailViewModel().getPlatformEntityLiveData().observe(playableItemDetailDialogFragment, new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass24(booleanRef2, this)));
        getPlayableItemDetailViewModel().getSelectedPlayableItemDescriptionLiveData().observe(playableItemDetailDialogFragment, new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass25()));
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "enable_retro_achievements", true);
        SharedPreferences sharedPreferences = this.retroAchievementsSharedPreferences;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsSharedPreferences");
            sharedPreferences = null;
        }
        SharedPreferenceStringLiveData sharedPreferenceStringLiveData = new SharedPreferenceStringLiveData(sharedPreferences, "username", null);
        SharedPreferences sharedPreferences2 = this.retroAchievementsSharedPreferences;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsSharedPreferences");
            sharedPreferences2 = null;
        }
        TripleLiveData tripleLiveData = new TripleLiveData(sharedPreferenceBooleanLiveData, sharedPreferenceStringLiveData, new SharedPreferenceStringLiveData(sharedPreferences2, "web_api_key", null));
        tripleLiveData.observe(getViewLifecycleOwner(), new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass26()));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Transformations.switchMap(tripleLiveData, new PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1(objectRef, this)).observe(getViewLifecycleOwner(), new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass27(objectRef)));
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(contextRequireContext);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        new SharedPreferenceBooleanLiveData(defaultSharedPreferences, BooleanPreference.PRETTIFY_TITLES.getKey(), BooleanPreference.PRETTIFY_TITLES.getDefaultValue()).observe(playableItemDetailDialogFragment, new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass28()));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.PLAY_PREVIEW_VIDEO.getKey(), BooleanPreference.PLAY_PREVIEW_VIDEO.getDefaultValue()).observe(playableItemDetailDialogFragment, new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass29()));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "make_preview_video_sounds", true).observe(playableItemDetailDialogFragment, new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass30()));
        new ConnectionLiveData(contextRequireContext).observe(playableItemDetailDialogFragment, new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass31()));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5(PlayableItemDetailDialogFragment this$0, View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.refocusOnScrolledToTop) {
            ScrollView scrollView = this$0.detailScrollView;
            ConstraintLayout constraintLayout = null;
            if (scrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailScrollView");
                scrollView = null;
            }
            if (scrollView.getScrollY() == 0) {
                this$0.refocusOnScrolledToTop = false;
                ConstraintLayout constraintLayout2 = this$0.backgroundSetLayout;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
                } else {
                    constraintLayout = constraintLayout2;
                }
                constraintLayout.requestFocus();
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment$onCreateView$2", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "onCurrentSecond", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "second", "", "onStateChange", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "onVideoDuration", TypedValues.TransitionType.S_DURATION, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class C02262 extends AbstractYouTubePlayerListener {
        C02262() {
        }

        @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
        public void onVideoDuration(YouTubePlayer youTubePlayer, float duration) {
            Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
            super.onVideoDuration(youTubePlayer, duration);
            float f = duration / 2.0f;
            if (90.0f <= f || PlayableItemDetailDialogFragment.this.hasPlayed) {
                return;
            }
            youTubePlayer.seekTo(f);
        }

        @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
        public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
            Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
            Intrinsics.checkNotNullParameter(state, "state");
            super.onStateChange(youTubePlayer, state);
            if (state == PlayerConstants.PlayerState.ENDED) {
                youTubePlayer.seekTo(0.0f);
                return;
            }
            if (state == PlayerConstants.PlayerState.VIDEO_CUED) {
                if (PlayableItemDetailDialogFragment.this.hasPlayed) {
                    return;
                }
                youTubePlayer.seekTo(90.0f);
            } else if (state == PlayerConstants.PlayerState.PLAYING && !PlayableItemDetailDialogFragment.this.hasPlayed && PlayableItemDetailDialogFragment.this.doPlaying) {
                new Handler().postDelayed(new PlayableItemDetailDialogFragment$onCreateView$2$$ExternalSyntheticLambda0(PlayableItemDetailDialogFragment.this), Constants.videoDelayMs);
            }
        }


        @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
        public void onCurrentSecond(YouTubePlayer youTubePlayer, float second) {
            Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
            super.onCurrentSecond(youTubePlayer, second);
            PlayableItemDetailDialogFragment.this.youTubePlayerCurrentSecond = second;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$3, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment$onCreateView$3", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerCallback;", "onYouTubePlayer", "", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass3 implements YouTubePlayerCallback {
        AnonymousClass3() {
        }

        @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
        public void onYouTubePlayer(YouTubePlayer youTubePlayer) {
            Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
            PlayableItemDetailDialogFragment.this.youTubePlayer = youTubePlayer;
            String str = PlayableItemDetailDialogFragment.this.youtubeVideoId;
            if (str != null) {
                PlayableItemDetailDialogFragment.this.playYoutubeVideo(str);
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$4, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment$onCreateView$4", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass4 extends RecyclerView.OnScrollListener {
        AnonymousClass4() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            DaijishouRecyclerView daijishouRecyclerView = PlayableItemDetailDialogFragment.this.similarItemsRecyclerView;
            TextView textView = null;
            if (daijishouRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerView");
                daijishouRecyclerView = null;
            }
            RecyclerView.LayoutManager layoutManager = daijishouRecyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager);
            int iFindFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            DaijishouRecyclerView daijishouRecyclerView2 = PlayableItemDetailDialogFragment.this.similarItemsRecyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerView");
                daijishouRecyclerView2 = null;
            }
            RecyclerView.LayoutManager layoutManager2 = daijishouRecyclerView2.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2);
            View viewFindViewByPosition = layoutManager2.findViewByPosition(iFindFirstVisibleItemPosition);
            if (viewFindViewByPosition != null) {
                TextView textView2 = PlayableItemDetailDialogFragment.this.detailTextView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
                } else {
                    textView = textView2;
                }
                textView.setNextFocusDownId(viewFindViewByPosition.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$10(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$11(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$12(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$13(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$14(PlayableItemDetailDialogFragment this$0, FragmentActivity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
        FragmentActivity fragmentActivity = activity;
        PlayableItemEntity playableItemEntity = this$0.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        daijishouLibrary.play(fragmentActivity, playableItemEntity, PlayableItemDetailDialogFragment$onCreateView$13$1.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$17(PlayableItemDetailDialogFragment this$0, FragmentActivity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity = this$0.retroAchievementsGameRecord;
        if (retroAchievementsGameRecordEntity == null || retroAchievementsGameRecordEntity.getName() == null) {
            return;
        }
        RetroAchievementsGameDialogFragment.Companion companion = RetroAchievementsGameDialogFragment.INSTANCE;
        long id2 = retroAchievementsGameRecordEntity.getId();
        PlayableItemEntity playableItemEntity = this$0.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        RetroAchievementsGameDialogFragment.Companion.newInstance$default(companion, id2, playableItemEntity, null, null, null, 28, null).show(activity.getSupportFragmentManager(), RetroAchievementsGameDialogFragment.class.getName());
        Dialog dialog = this$0.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$18(PlayableItemDetailDialogFragment this$0, FragmentActivity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
        FragmentActivity fragmentActivity = activity;
        PlayableItemEntity playableItemEntity = this$0.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        daijishouLibrary.play(fragmentActivity, playableItemEntity, PlayableItemDetailDialogFragment$onCreateView$15$1.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$19(PlayableItemDetailDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
        PlayableItemEntity playableItemEntity = this$0.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        daijishouLibrary.toggleIsPlayableItemFavorite(playableItemEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$20(PlayableItemDetailDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = null;
        if (this$0.getMergePlayableItems()) {
            PinAndPlayWidgetBuilder pinAndPlayWidget = this$0.getPinAndPlayWidget();
            PlayableItemEntity playableItemEntity2 = this$0.playableItemEntity;
            if (playableItemEntity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                playableItemEntity2 = null;
            }
            if (pinAndPlayWidget.isPlayableItemIdsInAPinAndPlayWidget(playableItemEntity2.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds())) {
                WidgetsManager widgetManager = this$0.getWidgetManager();
                FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
                Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                AppCompatActivity appCompatActivity = (AppCompatActivity) fragmentActivityRequireActivity;
                PlayableItemEntity playableItemEntity3 = this$0.playableItemEntity;
                if (playableItemEntity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                } else {
                    playableItemEntity = playableItemEntity3;
                }
                widgetManager.requestWidgetInstanceRemoval(appCompatActivity, PinAndPlayWidgetBuilder.class, playableItemEntity.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds(), new PlayableItemDetailDialogFragment$onCreateView$17$2(this$0));
            } else {
                WidgetsManager widgetManager2 = this$0.getWidgetManager();
                FragmentActivity fragmentActivityRequireActivity2 = this$0.requireActivity();
                Intrinsics.checkNotNull(fragmentActivityRequireActivity2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                AppCompatActivity appCompatActivity2 = (AppCompatActivity) fragmentActivityRequireActivity2;
                PlayableItemEntity playableItemEntity4 = this$0.playableItemEntity;
                if (playableItemEntity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                } else {
                    playableItemEntity = playableItemEntity4;
                }
                widgetManager2.requestWidgetInstanceCreation(appCompatActivity2, PinAndPlayWidgetBuilder.class, Long.valueOf(playableItemEntity.getId()), new PlayableItemDetailDialogFragment$onCreateView$17$1(this$0));
            }
        } else {
            PinAndPlayWidgetBuilder pinAndPlayWidget2 = this$0.getPinAndPlayWidget();
            PlayableItemEntity playableItemEntity5 = this$0.playableItemEntity;
            if (playableItemEntity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                playableItemEntity5 = null;
            }
            if (pinAndPlayWidget2.isPlayableItemIdInAPinAndPlayWidget(playableItemEntity5.getId())) {
                WidgetsManager widgetManager3 = this$0.getWidgetManager();
                FragmentActivity fragmentActivityRequireActivity3 = this$0.requireActivity();
                Intrinsics.checkNotNull(fragmentActivityRequireActivity3, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                AppCompatActivity appCompatActivity3 = (AppCompatActivity) fragmentActivityRequireActivity3;
                PlayableItemEntity playableItemEntity6 = this$0.playableItemEntity;
                if (playableItemEntity6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                } else {
                    playableItemEntity = playableItemEntity6;
                }
                widgetManager3.requestWidgetInstanceRemoval(appCompatActivity3, PinAndPlayWidgetBuilder.class, Long.valueOf(playableItemEntity.getId()), new PlayableItemDetailDialogFragment$onCreateView$17$4(this$0));
            } else {
                WidgetsManager widgetManager4 = this$0.getWidgetManager();
                FragmentActivity fragmentActivityRequireActivity4 = this$0.requireActivity();
                Intrinsics.checkNotNull(fragmentActivityRequireActivity4, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                AppCompatActivity appCompatActivity4 = (AppCompatActivity) fragmentActivityRequireActivity4;
                PlayableItemEntity playableItemEntity7 = this$0.playableItemEntity;
                if (playableItemEntity7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                } else {
                    playableItemEntity = playableItemEntity7;
                }
                widgetManager4.requestWidgetInstanceCreation(appCompatActivity4, PinAndPlayWidgetBuilder.class, Long.valueOf(playableItemEntity.getId()), new PlayableItemDetailDialogFragment$onCreateView$17$3(this$0));
            }
        }
        this$0.refreshPinButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$21(PlayableItemDetailDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/watch?v=" + this$0.youtubeVideoId + "&t=" + ((int) this$0.youTubePlayerCurrentSecond))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$22(PlayableItemDetailDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        FragmentActivity fragmentActivity = fragmentActivityRequireActivity;
        PlayableItemEntity playableItemEntity = this$0.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        daijishouLibrary.editPlayableItem(fragmentActivity, playableItemEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$23(PlayableItemDetailDialogFragment this$0, View view) throws UnsupportedEncodingException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.playableItemEntity;
        PlayableItemEntity playableItemEntity2 = null;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        if (playableItemEntity.getScraperKeywordList().isEmpty()) {
            return;
        }
        DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
        PlayableItemEntity playableItemEntity3 = this$0.playableItemEntity;
        if (playableItemEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
        } else {
            playableItemEntity2 = playableItemEntity3;
        }
        String strEncode = URLEncoder.encode(daijishouLibrary.prettifyTitle(playableItemEntity2.getScraperKeywordList().get(0), false) + " " + this$0.platformName, "UTF-8");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/search?q=" + strEncode + "&hl=" + UtilsKt.getLanguageAndCountry(locale))));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$21, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass21 extends Lambda<Unit> implements Function4<View, Integer, Long, PlayableItemEntity, Unit> {
        AnonymousClass21() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
            invoke(view, num.intValue(), l.longValue(), playableItemEntity);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, PlayableItemEntity it) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(it, "it");
            PlayableItemDetailDialogFragment.INSTANCE.newInstance(it).show(PlayableItemDetailDialogFragment.this.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
            PlayableItemDetailDialogFragment.this.requireDialog().dismiss();
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$22, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass22 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
        final /* synthetic */ Ref.BooleanRef $loadingDataFirstTime;
        final /* synthetic */ PlayableItemDetailDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass22(Ref.BooleanRef booleanRef, PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
            super(1);
            this.$loadingDataFirstTime = booleanRef;
            this.this$0 = playableItemDetailDialogFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
            try {
                invoke2(playableItemEntity);
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlayableItemEntity playableItemEntity) throws IOException {
            if (!this.$loadingDataFirstTime.element) {
                Integer value = this.this$0.getDaijishouSynchronization().getStatusLiveData().getValue();
                if ((value != null && value.intValue() == 3) || playableItemEntity == null) {
                    return;
                }
                this.this$0.refreshPlayableItem(playableItemEntity);
                return;
            }
            this.$loadingDataFirstTime.element = false;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$24, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass24 extends Lambda<Unit> implements Function1<PlatformEntity, Unit> {
        final /* synthetic */ Ref.BooleanRef $loadingPlatformDataFirstTime;
        final /* synthetic */ PlayableItemDetailDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass24(Ref.BooleanRef booleanRef, PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
            super(1);
            this.$loadingPlatformDataFirstTime = booleanRef;
            this.this$0 = playableItemDetailDialogFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
            invoke2(platformEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlatformEntity platformEntity) {
            if (this.$loadingPlatformDataFirstTime.element) {
                this.$loadingPlatformDataFirstTime.element = false;
                return;
            }
            PlayableItemDetailDialogFragment playableItemDetailDialogFragment = this.this$0;
            Intrinsics.checkNotNull(platformEntity);
            playableItemDetailDialogFragment.refreshPlatform(platformEntity);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$25, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass25 extends Lambda<Unit> implements Function1<String, Unit> {
        AnonymousClass25() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            TextView textView = null;
            if (str == null) {
                TextView textView2 = PlayableItemDetailDialogFragment.this.detailTextView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
                    textView2 = null;
                }
                textView2.setText((CharSequence) null);
                TextView textView3 = PlayableItemDetailDialogFragment.this.detailTextView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
                } else {
                    textView = textView3;
                }
                textView.setVisibility(8);
                return;
            }
            TextView textView4 = PlayableItemDetailDialogFragment.this.detailTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
                textView4 = null;
            }
            textView4.setText(Html.fromHtml(str));
            TextView textView5 = PlayableItemDetailDialogFragment.this.detailTextView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
            } else {
                textView = textView5;
            }
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$26, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012>\u0010\u0002\u001a:\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005 \u0006*\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Triple;", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass26 extends Lambda<Unit> implements Function1<Triple<? extends Boolean, ? extends String, ? extends String>, Unit> {
        AnonymousClass26() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Triple<? extends Boolean, ? extends String, ? extends String> triple) {
            invoke2((Triple<Boolean, String, String>) triple);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Triple<Boolean, String, String> triple) {
            TextView textView = PlayableItemDetailDialogFragment.this.retroAchievementsTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsTextView");
                textView = null;
            }
            textView.setVisibility(Intrinsics.areEqual((Object) triple.getFirst(), (Object) false) ? 8 : 0);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$27, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass27 extends Lambda<Unit> implements Function1<RetroAchievementsGameRecordEntity, Unit> {
        final /* synthetic */ Ref.ObjectRef<String> $webApiKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass27(Ref.ObjectRef<String> objectRef) {
            super(1);
            this.$webApiKey = objectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
            invoke2(retroAchievementsGameRecordEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
            String str;
            PlayableItemDetailDialogFragment.this.retroAchievementsGameRecord = retroAchievementsGameRecordEntity;
            String str2 = "retroAchievementsUnavailableWithEmojiString";
            String str3 = null;
            if (retroAchievementsGameRecordEntity == null) {
                TextView textView = PlayableItemDetailDialogFragment.this.retroAchievementsTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsTextView");
                    textView = null;
                }
                if (this.$webApiKey.element == null) {
                    String str4 = PlayableItemDetailDialogFragment.this.retroAchievementsLoginRequiredWitEmojiString;
                    if (str4 == null) {
                        str2 = "retroAchievementsLoginRequiredWitEmojiString";
                        Intrinsics.throwUninitializedPropertyAccessException(str2);
                    } else {
                        str3 = str4;
                    }
                } else {
                    String str5 = PlayableItemDetailDialogFragment.this.retroAchievementsUnavailableWithEmojiString;
                    if (str5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str2);
                    } else {
                        str3 = str5;
                    }
                }
                textView.setText(str3);
                return;
            }
            TextView textView2 = PlayableItemDetailDialogFragment.this.retroAchievementsTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsTextView");
                textView2 = null;
            }
            if (retroAchievementsGameRecordEntity.getName() != null && retroAchievementsGameRecordEntity.getRating() == null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str6 = PlayableItemDetailDialogFragment.this.retroAchievementsDescriptionNewFormatString;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsDescriptionNewFormatString");
                } else {
                    str3 = str6;
                }
                String str7 = String.format(str3, Arrays.copyOf(new Object[]{Long.valueOf(retroAchievementsGameRecordEntity.getDistinctPlayerCount()), PlayableItemDetailDialogFragment.this.getPlayerCountLabel(retroAchievementsGameRecordEntity.getDistinctPlayerCount()), Integer.valueOf(retroAchievementsGameRecordEntity.getUnlockedAchievementsCount()), Integer.valueOf(retroAchievementsGameRecordEntity.getAchievementsCount()), Float.valueOf(((float) retroAchievementsGameRecordEntity.getAchievementsCount()) != 0.0f ? (retroAchievementsGameRecordEntity.getUnlockedAchievementsCount() * 100.0f) / retroAchievementsGameRecordEntity.getAchievementsCount() : 0.0f)}, 5));
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                str = str7;
            } else if (retroAchievementsGameRecordEntity.getName() != null) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str8 = PlayableItemDetailDialogFragment.this.retroAchievementsDescriptionWithRatingFormatString;
                if (str8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsDescriptionWithRatingFormatString");
                } else {
                    str3 = str8;
                }
                String str9 = String.format(str3, Arrays.copyOf(new Object[]{retroAchievementsGameRecordEntity.getRating(), Integer.valueOf(retroAchievementsGameRecordEntity.getRatingVotesCount()), Integer.valueOf(retroAchievementsGameRecordEntity.getUnlockedAchievementsCount()), Integer.valueOf(retroAchievementsGameRecordEntity.getAchievementsCount()), Float.valueOf(((float) retroAchievementsGameRecordEntity.getAchievementsCount()) != 0.0f ? (retroAchievementsGameRecordEntity.getUnlockedAchievementsCount() * 100.0f) / retroAchievementsGameRecordEntity.getAchievementsCount() : 0.0f)}, 5));
                Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                str = str9;
            } else {
                String str10 = PlayableItemDetailDialogFragment.this.retroAchievementsUnavailableWithEmojiString;
                if (str10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsUnavailableWithEmojiString");
                } else {
                    str3 = str10;
                }
                str = str3;
            }
            textView2.setText(str);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$28, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass28 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        AnonymousClass28() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            PlayableItemEntity playableItemEntity = PlayableItemDetailDialogFragment.this.playableItemEntity;
            TextView textView = null;
            if (playableItemEntity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                playableItemEntity = null;
            }
            PlayableItemDetailDialogFragment playableItemDetailDialogFragment = PlayableItemDetailDialogFragment.this;
            TextView textView2 = playableItemDetailDialogFragment.titleTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            } else {
                textView = textView2;
            }
            textView.setText(playableItemDetailDialogFragment.getDaijishouLibrary().prettifyTitleWithPreferences(playableItemEntity.getName()));
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$29, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass29 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        AnonymousClass29() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            PlayableItemDetailDialogFragment playableItemDetailDialogFragment = PlayableItemDetailDialogFragment.this;
            Intrinsics.checkNotNull(bool);
            playableItemDetailDialogFragment.playPreviewVideo = bool.booleanValue();
            if (!PlayableItemDetailDialogFragment.this.playPreviewVideo || PlayableItemDetailDialogFragment.this.youtubeVideoId == null) {
                PlayableItemDetailDialogFragment.this.stopYoutubeVideo();
                return;
            }
            PlayableItemDetailDialogFragment playableItemDetailDialogFragment2 = PlayableItemDetailDialogFragment.this;
            String str = playableItemDetailDialogFragment2.youtubeVideoId;
            Intrinsics.checkNotNull(str);
            playableItemDetailDialogFragment2.playYoutubeVideo(str);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$30, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass30 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        AnonymousClass30() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            PlayableItemDetailDialogFragment playableItemDetailDialogFragment = PlayableItemDetailDialogFragment.this;
            Intrinsics.checkNotNull(bool);
            playableItemDetailDialogFragment.makePreviewVideoSounds = bool.booleanValue();
            if (PlayableItemDetailDialogFragment.this.makePreviewVideoSounds) {
                YouTubePlayer youTubePlayer = PlayableItemDetailDialogFragment.this.youTubePlayer;
                if (youTubePlayer != null) {
                    youTubePlayer.unMute();
                    return;
                }
                return;
            }
            YouTubePlayer youTubePlayer2 = PlayableItemDetailDialogFragment.this.youTubePlayer;
            if (youTubePlayer2 != null) {
                youTubePlayer2.mute();
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$31, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "hasConnection", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass31 extends Lambda<Unit> implements Function1<Integer, Unit> {
        AnonymousClass31() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            int i = PlayableItemDetailDialogFragment.this.connectionType;
            if (num != null && i == num.intValue()) {
                return;
            }
            PlayableItemDetailDialogFragment playableItemDetailDialogFragment = PlayableItemDetailDialogFragment.this;
            Intrinsics.checkNotNull(num);
            playableItemDetailDialogFragment.connectionType = num.intValue();
            if (PlayableItemDetailDialogFragment.this.connectionType == -1 || !PlayableItemDetailDialogFragment.this.playPreviewVideo) {
                PlayableItemDetailDialogFragment.this.stopYoutubeVideo();
                return;
            }
            PlayableItemDetailDialogFragment playableItemDetailDialogFragment2 = PlayableItemDetailDialogFragment.this;
            PlayableItemEntity playableItemEntity = playableItemDetailDialogFragment2.playableItemEntity;
            if (playableItemEntity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                playableItemEntity = null;
            }
            playableItemDetailDialogFragment2.loadYoutube(playableItemEntity);
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog(...)");
        super.onViewCreated(view, savedInstanceState);
        view.requestFocus();
        ConstraintLayout constraintLayout = this.root;
        ConstraintLayout constraintLayout2 = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            constraintLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).setMargins(getDpToPxConverter().convert(12.0f), getDpToPxConverter().convert(12.0f), getDpToPxConverter().convert(12.0f), getDpToPxConverter().convert(12.0f));
        ConstraintLayout constraintLayout3 = this.root;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            constraintLayout3 = null;
        }
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.roundest_full_screen_dialog, contextRequireContext.getTheme());
        Intrinsics.checkNotNull(drawable);
        constraintLayout3.setBackground(drawable);
        Window window = dialogRequireDialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        ConstraintLayout constraintLayout4 = this.backgroundSetLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
        } else {
            constraintLayout2 = constraintLayout4;
        }
        constraintLayout2.requestLayout();
        Window window2 = dialogRequireDialog.getWindow();
        if (window2 != null) {
            window2.setWindowAnimations(R.style.FullScreenDialogAnimation);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new PlayableItemDetailDialogFragment$$ExternalSyntheticLambda8(this), getResources().getInteger(android.R.integer.config_shortAnimTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$26(PlayableItemDetailDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ConstraintLayout constraintLayout = this$0.backgroundSetLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout = null;
        }
        constraintLayout.requestFocus();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog(...)");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        Window window2 = dialogRequireDialog.getWindow();
        if (window2 != null) {
            window2.setFlags(1024, 1024);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Window window = requireDialog().getWindow();
        Intrinsics.checkNotNull(window);
        window.getWindowManager().updateViewLayout(window.getDecorView(), window.getAttributes());
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
        ((MainActivity) activity).setAndroidPDialogFixStopKeyDispatching(false);
    }

    public static final void onStateChange$lambda$0(PlayableItemDetailDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hasPlayed = true;
        if (this$0.doPlaying) {
            ImageView imageView = this$0.background;
            YouTubePlayerView youTubePlayerView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
                imageView = null;
            }
            if (imageView.getVisibility() == 0) {
                ImageView imageView2 = this$0.background;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("background");
                    imageView2 = null;
                }
                imageView2.setVisibility(8);
            }
            YouTubePlayerView youTubePlayerView2 = this$0.youtubePlayerView;
            if (youTubePlayerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("youtubePlayerView");
                youTubePlayerView2 = null;
            }
            if (youTubePlayerView2.getVisibility() != 0) {
                YouTubePlayerView youTubePlayerView3 = this$0.youtubePlayerView;
                if (youTubePlayerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("youtubePlayerView");
                } else {
                    youTubePlayerView = youTubePlayerView3;
                }
                youTubePlayerView.setVisibility(0);
            }
        }
    }

}
