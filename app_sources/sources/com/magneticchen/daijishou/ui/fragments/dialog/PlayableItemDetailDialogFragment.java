package com.magneticchen.daijishou.ui.fragments.dialog;

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
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataScope;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.Genre;
import com.magneticchen.daijishou.data.Genres;
import com.magneticchen.daijishou.data.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntityMergedInfo;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsGameRecordEntity;
import com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.data.live.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.data.live.TripleLiveData;
import com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager;
import com.magneticchen.daijishou.service.youtube.YoutubePlayerService;
import com.magneticchen.daijishou.ui.activities.MainActivity;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.model.PlayableItemDetailViewModel;
import com.magneticchen.daijishou.ui.widget.WidgetsManager;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetBuilder;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.utils.UtilsKt;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.skydoves.balloon.internals.DefinitionKt;
import java.io.File;
import java.io.FileInputStream;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ·\u00012\u00020\u0001:\u0004·\u0001¸\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u008d\u0001\u001a\u00020\u00042\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001J\u0013\u0010\u0090\u0001\u001a\u00020\u001b2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\n\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0002J\u0015\u0010\u0095\u0001\u001a\u00030\u0094\u00012\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\u0015\u0010\u0097\u0001\u001a\u00030\u0094\u00012\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\t\u0010\u0098\u0001\u001a\u00020,H\u0016J\u0016\u0010\u0099\u0001\u001a\u00030\u0094\u00012\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J.\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u00012\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J\n\u0010¢\u0001\u001a\u00030\u0094\u0001H\u0016J\n\u0010£\u0001\u001a\u00030\u0094\u0001H\u0016J\n\u0010¤\u0001\u001a\u00030\u0094\u0001H\u0016J\n\u0010¥\u0001\u001a\u00030\u0094\u0001H\u0016J\u0013\u0010¦\u0001\u001a\u00030\u0094\u00012\u0007\u0010§\u0001\u001a\u00020GH\u0002J\u0014\u0010¦\u0001\u001a\u00030\u0094\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H\u0002J\u0013\u0010ª\u0001\u001a\u00030\u0094\u00012\u0007\u0010§\u0001\u001a\u00020GH\u0002J\u0014\u0010ª\u0001\u001a\u00030\u0094\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H\u0002J\u0013\u0010«\u0001\u001a\u00030\u0094\u00012\u0007\u0010§\u0001\u001a\u00020GH\u0002J\u0014\u0010«\u0001\u001a\u00030\u0094\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H\u0002J\u0013\u0010¬\u0001\u001a\u00030\u0094\u00012\u0007\u0010§\u0001\u001a\u00020GH\u0002J\u0014\u0010¬\u0001\u001a\u00030\u0094\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H\u0002J\u0013\u0010\u00ad\u0001\u001a\u00030\u0094\u00012\u0007\u0010§\u0001\u001a\u00020GH\u0002J\u0014\u0010\u00ad\u0001\u001a\u00030\u0094\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H\u0002J\u0013\u0010®\u0001\u001a\u00030\u0094\u00012\u0007\u0010§\u0001\u001a\u00020GH\u0002J\u0014\u0010®\u0001\u001a\u00030\u0094\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H\u0002J \u0010¯\u0001\u001a\u00030\u0094\u00012\b\u0010°\u0001\u001a\u00030\u009d\u00012\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J\n\u0010±\u0001\u001a\u00030\u0094\u0001H\u0002J\n\u0010²\u0001\u001a\u00030\u0094\u0001H\u0002J\u0012\u0010³\u0001\u001a\u00030\u0094\u00012\b\u0010´\u0001\u001a\u00030µ\u0001J\u0012\u0010¶\u0001\u001a\u00030\u0094\u00012\u0006\u0010F\u001a\u00020GH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u000e\u00102\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00101\u001a\u0004\b7\u00108R\u000e\u0010:\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u00101\u001a\u0004\bC\u0010DR\u000e\u0010F\u001a\u00020GX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010Q\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u00101\u001a\u0004\bR\u0010SR\u001b\u0010U\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u00101\u001a\u0004\bV\u0010SR\u001b\u0010X\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u00101\u001a\u0004\bY\u0010SR\u001b\u0010[\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u00101\u001a\u0004\b\\\u0010SR\u001b\u0010^\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u00101\u001a\u0004\b_\u0010SR\u001b\u0010a\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u00101\u001a\u0004\bb\u0010SR\u001b\u0010d\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u00101\u001a\u0004\be\u0010SR\u001b\u0010g\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u00101\u001a\u0004\bh\u0010SR\u001b\u0010j\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u00101\u001a\u0004\bk\u0010SR\u001b\u0010m\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u00101\u001a\u0004\bn\u0010SR\u0010\u0010p\u001a\u0004\u0018\u00010qX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020uX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020yX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u007f\u001a\u00030\u0080\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0081\u0001\u001a\u00030\u0082\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0083\u0001\u001a\u00070\u0084\u0001R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0087\u0001\u001a\t\u0012\u0004\u0012\u00020G0\u0088\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "addFavoriteString", "", "background", "Landroid/widget/ImageView;", "backgroundSetLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "boxArtAspectRatio", "boxArtAspectRatioList", "", "colorIconThemeTintList", "Landroid/content/res/ColorStateList;", "colorOnThemeTintList", "colorThemeTintList", "completeButton", "Lcom/google/android/material/chip/Chip;", "completedImageView", "descriptionFormatString", "descriptionTextView", "Landroid/widget/TextView;", "detailContainerLayout", "detailScrollView", "Landroid/widget/ScrollView;", "detailTextView", "displayHeightPixels", "", "editButton", "favoriteButton", "favoriteImageView", "focusListener", "Landroid/view/View$OnFocusChangeListener;", "genresTextView", "gradientImageView", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "isCompletedDrawable", "Landroid/graphics/drawable/Drawable;", "isFavoriteDrawable", "isFavoriteString", "isNotCompletedDrawable", "isNotFavoriteDrawable", "makePreviewVideoSounds", "", "mergePlayableItems", "getMergePlayableItems", "()Z", "mergePlayableItems$delegate", "Lkotlin/Lazy;", "newlyButton", "newlyImageView", "noneString", "pinAndPlayWidget", "Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;", "getPinAndPlayWidget", "()Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;", "pinAndPlayWidget$delegate", "pinButton", "placeholder", "platformDescriptionTextView", "platformName", "platformTextView", "playButton", "playPreviewVideo", "playableItemDetailViewModel", "Lcom/magneticchen/daijishou/ui/model/PlayableItemDetailViewModel;", "getPlayableItemDetailViewModel", "()Lcom/magneticchen/daijishou/ui/model/PlayableItemDetailViewModel;", "playableItemDetailViewModel$delegate", "playableItemEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "playableItemViewedEventRegistered", "previewVideoButton", "recentButton", "recentImageView", "refocusOnScrolledToTop", "retroAchievementsDescriptionFormatString", "retroAchievementsDescriptionNewFormatString", "retroAchievementsDescriptionWithPlayerCountFormatString", "retroAchievementsDescriptionWithRatingFormatString", "retroAchievementsGame0PlayerString", "getRetroAchievementsGame0PlayerString", "()Ljava/lang/String;", "retroAchievementsGame0PlayerString$delegate", "retroAchievementsGameMoreThen1024PlayersString", "getRetroAchievementsGameMoreThen1024PlayersString", "retroAchievementsGameMoreThen1024PlayersString$delegate", "retroAchievementsGameMoreThen128PlayersString", "getRetroAchievementsGameMoreThen128PlayersString", "retroAchievementsGameMoreThen128PlayersString$delegate", "retroAchievementsGameMoreThen16284PlayersString", "getRetroAchievementsGameMoreThen16284PlayersString", "retroAchievementsGameMoreThen16284PlayersString$delegate", "retroAchievementsGameMoreThen2048PlayersString", "getRetroAchievementsGameMoreThen2048PlayersString", "retroAchievementsGameMoreThen2048PlayersString$delegate", "retroAchievementsGameMoreThen256PlayersString", "getRetroAchievementsGameMoreThen256PlayersString", "retroAchievementsGameMoreThen256PlayersString$delegate", "retroAchievementsGameMoreThen4096PlayersString", "getRetroAchievementsGameMoreThen4096PlayersString", "retroAchievementsGameMoreThen4096PlayersString$delegate", "retroAchievementsGameMoreThen512PlayersString", "getRetroAchievementsGameMoreThen512PlayersString", "retroAchievementsGameMoreThen512PlayersString$delegate", "retroAchievementsGameMoreThen64PlayersString", "getRetroAchievementsGameMoreThen64PlayersString", "retroAchievementsGameMoreThen64PlayersString$delegate", "retroAchievementsGameMoreThen8192PlayersString", "getRetroAchievementsGameMoreThen8192PlayersString", "retroAchievementsGameMoreThen8192PlayersString$delegate", "retroAchievementsGameRecord", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "retroAchievementsLoginRequiredDetailString", "retroAchievementsLoginRequiredWitEmojiString", "retroAchievementsNextRefreshDate", "Ljava/util/Date;", "retroAchievementsRefreshing", "retroAchievementsRefreshingString", "retroAchievementsSharedPreferences", "Landroid/content/SharedPreferences;", "retroAchievementsTextView", "retroAchievementsUnavailableString", "retroAchievementsUnavailableWithEmojiString", "root", "screenAspectRatioList", "similarItemsLayout", "Landroid/widget/LinearLayout;", "similarItemsRecyclerView", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "similarItemsRecyclerViewAdapter", "Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment$SimilarListAdapter;", "similarItemsRecyclerViewLayoutManager", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouLinearLayoutManager;", "similarPlayableItemList", "", "thumbnail", "titleTextView", "youtubePlayerService", "Lcom/magneticchen/daijishou/service/youtube/YoutubePlayerService;", "getPlayerCountLabel", "playerCount", "", "getScreenHeight", "activity", "Landroid/app/Activity;", "initChipFocusListener", "", "loadBackground", "pathName", "loadBoxArt", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onKioskMode", "onNoneKioskMode", "onResume", "onStart", "onUpdateCompletedButton", "item", "mergedInfo", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;", "onUpdateCompletedIcon", "onUpdateFavoriteButton", "onUpdateFavoriteIcon", "onUpdateRecentButton", "onUpdateRecentIcon", "onViewCreated", "view", "refreshDimensionRatioHeight", "refreshPinButton", "refreshPlatform", "platform", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "refreshPlayableItem", "Companion", "SimilarListAdapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlayableItemDetailDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
    private static final Typeface typeface;
    private String addFavoriteString;
    private ImageView background;
    private ConstraintLayout backgroundSetLayout;
    private List<String> boxArtAspectRatioList;
    private ColorStateList colorIconThemeTintList;
    private ColorStateList colorOnThemeTintList;
    private ColorStateList colorThemeTintList;
    private Chip completeButton;
    private ImageView completedImageView;
    private String descriptionFormatString;
    private TextView descriptionTextView;
    private ConstraintLayout detailContainerLayout;
    private ScrollView detailScrollView;
    private TextView detailTextView;
    private Chip editButton;
    private Chip favoriteButton;
    private ImageView favoriteImageView;
    private TextView genresTextView;
    private ImageView gradientImageView;
    private HorizontalScrollView horizontalScrollView;
    private Drawable isCompletedDrawable;
    private Drawable isFavoriteDrawable;
    private String isFavoriteString;
    private Drawable isNotCompletedDrawable;
    private Drawable isNotFavoriteDrawable;
    private Chip newlyButton;
    private ImageView newlyImageView;
    private String noneString;
    private Chip pinButton;
    private ImageView placeholder;
    private TextView platformDescriptionTextView;
    private TextView platformTextView;
    private Chip playButton;
    private final Lazy playableItemDetailViewModel$delegate;
    private PlayableItemEntity playableItemEntity;
    private boolean playableItemViewedEventRegistered;
    private Chip previewVideoButton;
    private Chip recentButton;
    private ImageView recentImageView;
    private boolean refocusOnScrolledToTop;
    private String retroAchievementsDescriptionFormatString;
    private String retroAchievementsDescriptionNewFormatString;
    private String retroAchievementsDescriptionWithPlayerCountFormatString;
    private String retroAchievementsDescriptionWithRatingFormatString;
    private RetroAchievementsGameRecordEntity retroAchievementsGameRecord;
    private String retroAchievementsLoginRequiredDetailString;
    private String retroAchievementsLoginRequiredWitEmojiString;
    private Date retroAchievementsNextRefreshDate;
    private boolean retroAchievementsRefreshing;
    private String retroAchievementsRefreshingString;
    private SharedPreferences retroAchievementsSharedPreferences;
    private TextView retroAchievementsTextView;
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
    private YoutubePlayerService youtubePlayerService;
    private boolean playPreviewVideo = true;
    private boolean makePreviewVideoSounds = true;
    private String boxArtAspectRatio = Constants.defaultThumbnailDimensionRatio;
    private final List<PlayableItemEntity> similarPlayableItemList = new ArrayList();
    private int displayHeightPixels = -1;
    private String platformName = "";
    private final Lazy pinAndPlayWidget$delegate = LazyKt.lazy(new Function0<PinAndPlayWidgetBuilder>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$pinAndPlayWidget$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PinAndPlayWidgetBuilder invoke() {
            WidgetBuilder widgetBuilder = this.this$0.getWidgetManager().getWidgetBuilders().get(PinAndPlayWidgetBuilder.class);
            Intrinsics.checkNotNull(widgetBuilder, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetBuilder");
            return (PinAndPlayWidgetBuilder) widgetBuilder;
        }
    });
    private final Lazy mergePlayableItems$delegate = LazyKt.lazy(new Function0<Boolean>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$mergePlayableItems$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(this.this$0.getDefaultSharedPreferences().getBoolean("merge_playable_items", true));
        }
    });
    private final View.OnFocusChangeListener focusListener = new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda10
        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            PlayableItemDetailDialogFragment.focusListener$lambda$0(view, z);
        }
    };
    private final Lazy retroAchievementsGame0PlayerString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$retroAchievementsGame0PlayerString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getString(R.string.retro_achievements_game_0_distinct_player);
        }
    });
    private final Lazy retroAchievementsGameMoreThen64PlayersString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen64PlayersString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getString(R.string.retro_achievements_game_more_than_64_distinct_players);
        }
    });
    private final Lazy retroAchievementsGameMoreThen128PlayersString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen128PlayersString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getString(R.string.retro_achievements_game_more_than_128_distinct_players);
        }
    });
    private final Lazy retroAchievementsGameMoreThen256PlayersString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen256PlayersString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getString(R.string.retro_achievements_game_more_than_256_distinct_players);
        }
    });
    private final Lazy retroAchievementsGameMoreThen512PlayersString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen512PlayersString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getString(R.string.retro_achievements_game_more_than_512_distinct_players);
        }
    });
    private final Lazy retroAchievementsGameMoreThen1024PlayersString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen1024PlayersString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getString(R.string.retro_achievements_game_more_than_1024_distinct_players);
        }
    });
    private final Lazy retroAchievementsGameMoreThen2048PlayersString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen2048PlayersString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getString(R.string.retro_achievements_game_more_than_2048_distinct_players);
        }
    });
    private final Lazy retroAchievementsGameMoreThen4096PlayersString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen4096PlayersString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getString(R.string.retro_achievements_game_more_than_4096_distinct_players);
        }
    });
    private final Lazy retroAchievementsGameMoreThen8192PlayersString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen8192PlayersString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getString(R.string.retro_achievements_game_more_than_8192_distinct_players);
        }
    });
    private final Lazy retroAchievementsGameMoreThen16284PlayersString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$retroAchievementsGameMoreThen16284PlayersString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getString(R.string.retro_achievements_game_more_than_16384_distinct_players);
        }
    });

    public PlayableItemDetailDialogFragment() {
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        this.playableItemDetailViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(PlayableItemDetailViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment$Companion;", "", "()V", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment;", "playableItemEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        return (PlayableItemDetailViewModel) this.playableItemDetailViewModel$delegate.getValue();
    }

    private final PinAndPlayWidgetBuilder getPinAndPlayWidget() {
        return (PinAndPlayWidgetBuilder) this.pinAndPlayWidget$delegate.getValue();
    }

    private final boolean getMergePlayableItems() {
        return ((Boolean) this.mergePlayableItems$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void focusListener$lambda$0(View view, boolean z) {
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

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public void onKioskMode() {
        super.onKioskMode();
        Chip chip = this.editButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip = null;
        }
        chip.setVisibility(8);
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public void onNoneKioskMode() {
        super.onNoneKioskMode();
        Chip chip = this.editButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip = null;
        }
        chip.setVisibility(0);
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
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

    private final void loadBoxArt(String str) {
        ImageView imageView = null;
        TextView textView = null;
        if (str == null) {
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
        CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad$default = CachedBitmapLoader.CachedBitmapLoaderTask.load$default(getDaijishouLibrary().getCachedBoxArtBitmapLoader().with((Fragment) this).setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.loadBoxArt.1
            

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                invoke(bitmap, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Bitmap bitmap, boolean z) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                ImageView imageView4 = PlayableItemDetailDialogFragment.this.thumbnail;
                TextView textView3 = null;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                    imageView4 = null;
                }
                imageView4.setImageBitmap(bitmap);
                ImageView imageView5 = PlayableItemDetailDialogFragment.this.placeholder;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("placeholder");
                    imageView5 = null;
                }
                imageView5.setVisibility(8);
                TextView textView4 = PlayableItemDetailDialogFragment.this.platformTextView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformTextView");
                    textView4 = null;
                }
                textView4.setVisibility(8);
                if (PlayableItemDetailDialogFragment.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_AUTO_THEME_COLOR.getKey(), BooleanPreference.USE_AUTO_THEME_COLOR.getDefaultValue())) {
                    TypedValue typedValue = new TypedValue();
                    PlayableItemDetailDialogFragment.this.requireActivity().getTheme().resolveAttribute(R.attr.themeTextColor, typedValue, true);
                    int i = typedValue.data;
                    PlayableItemDetailDialogFragment.this.requireActivity().getTheme().resolveAttribute(R.attr.themeBackgroundColor, typedValue, true);
                    int i2 = typedValue.data;
                    Triple bitmapThemeColors$default = Utils.getBitmapThemeColors$default(Utils.INSTANCE, bitmap, DefinitionKt.NO_Float_VALUE, 2, null);
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
                    TextView textView5 = PlayableItemDetailDialogFragment.this.platformDescriptionTextView;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("platformDescriptionTextView");
                        textView5 = null;
                    }
                    textView5.setBackgroundTintList(PlayableItemDetailDialogFragment.this.colorThemeTintList);
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
                    TextView textView6 = PlayableItemDetailDialogFragment.this.platformDescriptionTextView;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("platformDescriptionTextView");
                        textView6 = null;
                    }
                    textView6.setTextColor(PlayableItemDetailDialogFragment.this.colorOnThemeTintList);
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
                    TextView textView7 = PlayableItemDetailDialogFragment.this.detailTextView;
                    if (textView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
                    } else {
                        textView3 = textView7;
                    }
                    textView3.setLinkTextColor(iIntValue2);
                }
            }
        }).setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.loadBoxArt.2
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                PlayableItemDetailDialogFragment.this.getLogger().warn(PlayableItemDetailDialogFragment.this, ExceptionsKt.stackTraceToString(e));
                ImageView imageView4 = PlayableItemDetailDialogFragment.this.thumbnail;
                TextView textView3 = null;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                    imageView4 = null;
                }
                imageView4.setImageBitmap(null);
                ImageView imageView5 = PlayableItemDetailDialogFragment.this.placeholder;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("placeholder");
                    imageView5 = null;
                }
                imageView5.setVisibility(0);
                TextView textView4 = PlayableItemDetailDialogFragment.this.platformTextView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformTextView");
                } else {
                    textView3 = textView4;
                }
                textView3.setVisibility(0);
            }
        }), str, false, 2, null);
        ImageView imageView4 = this.thumbnail;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
        } else {
            imageView = imageView4;
        }
        cachedBitmapLoaderTaskLoad$default.into(imageView);
    }

    private final void loadBackground(String str) {
        ImageView imageView = null;
        if (str == null) {
            ImageView imageView2 = this.background;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
                imageView2 = null;
            }
            imageView2.setImageBitmap(null);
            return;
        }
        CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad$default = CachedBitmapLoader.CachedBitmapLoaderTask.load$default(getDaijishouLibrary().getCachedSnapshotBitmapLoader().with((Fragment) this).setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.loadBackground.1
            

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                invoke(bitmap, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Bitmap bitmap, boolean z) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                ImageView imageView3 = PlayableItemDetailDialogFragment.this.background;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("background");
                    imageView3 = null;
                }
                imageView3.setImageBitmap(bitmap);
            }
        }).setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.loadBackground.2
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                PlayableItemDetailDialogFragment.this.getLogger().warn(PlayableItemDetailDialogFragment.this, ExceptionsKt.stackTraceToString(e));
                ImageView imageView3 = PlayableItemDetailDialogFragment.this.background;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("background");
                    imageView3 = null;
                }
                imageView3.setImageBitmap(null);
            }
        }), str, false, 2, null);
        ImageView imageView3 = this.thumbnail;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
        } else {
            imageView = imageView3;
        }
        cachedBitmapLoaderTaskLoad$default.into(imageView);
    }

    private final void refreshDimensionRatioHeight() {
        float fDimensionRatioToFloat = Utils.INSTANCE.dimensionRatioToFloat(this.boxArtAspectRatio);
        View view = null;
        if (fDimensionRatioToFloat > 1.0f) {
            View view2 = this.backgroundSetLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            } else {
                view = view2;
            }
            View view3 = view;
            ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = (int) (Math.min(getDpToPxConverter().convert(320.0f), this.displayHeightPixels * 0.42f) * ((float) Math.pow(1.0f / fDimensionRatioToFloat, 0.15f)));
                view3.setLayoutParams(layoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        View view4 = this.backgroundSetLayout;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
        } else {
            view = view4;
        }
        View view5 = view;
        ViewGroup.LayoutParams layoutParams2 = view5.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = (int) (Math.min(getDpToPxConverter().convert(320.0f), this.displayHeightPixels * 0.42f) * ((float) Math.pow(1.0f / fDimensionRatioToFloat, 0.15f)));
            view5.setLayoutParams(layoutParams2);
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
    public final void refreshPlayableItem(PlayableItemEntity playableItemEntity) {
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex;
        String strDecapitalize;
        String strDecapitalize2;
        if (this.playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
        }
        this.playableItemEntity = playableItemEntity;
        if (getMergePlayableItems()) {
            getDaijishouLibrary().injectPlayableItemWithMergedInfo(playableItemEntity);
        }
        String str = playableItemEntity.getPreviewMediaPath() + "index.json";
        if (new File(str).exists()) {
            String string = IOUtils.toString(new FileInputStream(str), StandardCharsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(PlayableItemPreviewMediaIndex.Companion.serializer(), string);
        } else {
            playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }
        new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc()));
        Date date = new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc()));
        TextView textView = this.titleTextView;
        Chip chip = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        textView.setText(playableItemEntity.getDoNotPrettify() ? playableItemEntity.getName() : getDaijishouLibrary().prettifyTitleWithPreferences(playableItemEntity.getName()));
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
            String str2 = this.descriptionFormatString;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionFormatString");
                str2 = null;
            }
            if (playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp() != null) {
                Utils utils = Utils.INSTANCE;
                Date mergedLastPlayedTimestamp = playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp();
                Intrinsics.checkNotNull(mergedLastPlayedTimestamp);
                strDecapitalize2 = StringsKt.decapitalize(utils.getRelativeTimeString(mergedLastPlayedTimestamp.getTime()));
            } else {
                String str3 = this.noneString;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noneString");
                    strDecapitalize2 = null;
                } else {
                    strDecapitalize2 = str3;
                }
            }
            String str4 = String.format(str2, Arrays.copyOf(new Object[]{strDecapitalize2, Integer.valueOf(playableItemEntity.getMergedInfo().getMergedPlayedCount())}, 2));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            textView3.setText(str4);
        } else {
            TextView textView4 = this.descriptionTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
                textView4 = null;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str5 = this.descriptionFormatString;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionFormatString");
                str5 = null;
            }
            if (playableItemEntity.getLastPlayedTimestamp() != null) {
                Utils utils2 = Utils.INSTANCE;
                Date lastPlayedTimestamp = playableItemEntity.getLastPlayedTimestamp();
                Intrinsics.checkNotNull(lastPlayedTimestamp);
                strDecapitalize = StringsKt.decapitalize(utils2.getRelativeTimeString(lastPlayedTimestamp.getTime()));
            } else {
                String str6 = this.noneString;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noneString");
                    strDecapitalize = null;
                } else {
                    strDecapitalize = str6;
                }
            }
            String str7 = String.format(str5, Arrays.copyOf(new Object[]{strDecapitalize, Integer.valueOf(playableItemEntity.getPlayCount())}, 2));
            Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
            textView4.setText(str7);
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
            onUpdateFavoriteButton(playableItemEntity.getMergedInfo());
            onUpdateFavoriteIcon(playableItemEntity.getMergedInfo());
            onUpdateRecentButton(playableItemEntity.getMergedInfo());
            onUpdateRecentIcon(playableItemEntity.getMergedInfo());
            onUpdateCompletedButton(playableItemEntity.getMergedInfo());
            onUpdateCompletedIcon(playableItemEntity.getMergedInfo());
        } else {
            onUpdateFavoriteButton(playableItemEntity);
            onUpdateFavoriteIcon(playableItemEntity);
            onUpdateRecentButton(playableItemEntity);
            onUpdateRecentIcon(playableItemEntity);
            onUpdateCompletedButton(playableItemEntity);
            onUpdateCompletedIcon(playableItemEntity);
        }
        refreshPinButton();
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
        Chip chip2 = this.newlyButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip2 = null;
        }
        chip2.setVisibility(mergedAddedDateTimestamp.after(date) ? 0 : 8);
        ImageView imageView = this.newlyImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyImageView");
            imageView = null;
        }
        imageView.setVisibility(mergedAddedDateTimestamp.after(date) ? 0 : 8);
        loadBoxArt(playableItemEntity.getPreviewMediaPath() + playableItemPreviewMediaIndex.getBoxArtPath());
        loadBackground(playableItemEntity.getPreviewMediaPath() + playableItemPreviewMediaIndex.getSnapshotPath());
        YoutubePlayerService youtubePlayerService = this.youtubePlayerService;
        if (youtubePlayerService != null) {
            youtubePlayerService.initialize(playableItemEntity);
        }
        Chip chip3 = this.recentButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip3 = null;
        }
        chip3.requestLayout();
        Chip chip4 = this.newlyButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
        } else {
            chip = chip4;
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
        ConstraintLayout.LayoutParams layoutParams = constraintLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        layoutParams.dimensionRatio = this.boxArtAspectRatio;
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
        return (String) this.retroAchievementsGame0PlayerString$delegate.getValue();
    }

    private final String getRetroAchievementsGameMoreThen64PlayersString() {
        return (String) this.retroAchievementsGameMoreThen64PlayersString$delegate.getValue();
    }

    private final String getRetroAchievementsGameMoreThen128PlayersString() {
        return (String) this.retroAchievementsGameMoreThen128PlayersString$delegate.getValue();
    }

    private final String getRetroAchievementsGameMoreThen256PlayersString() {
        return (String) this.retroAchievementsGameMoreThen256PlayersString$delegate.getValue();
    }

    private final String getRetroAchievementsGameMoreThen512PlayersString() {
        return (String) this.retroAchievementsGameMoreThen512PlayersString$delegate.getValue();
    }

    private final String getRetroAchievementsGameMoreThen1024PlayersString() {
        return (String) this.retroAchievementsGameMoreThen1024PlayersString$delegate.getValue();
    }

    private final String getRetroAchievementsGameMoreThen2048PlayersString() {
        return (String) this.retroAchievementsGameMoreThen2048PlayersString$delegate.getValue();
    }

    private final String getRetroAchievementsGameMoreThen4096PlayersString() {
        return (String) this.retroAchievementsGameMoreThen4096PlayersString$delegate.getValue();
    }

    private final String getRetroAchievementsGameMoreThen8192PlayersString() {
        return (String) this.retroAchievementsGameMoreThen8192PlayersString$delegate.getValue();
    }

    private final String getRetroAchievementsGameMoreThen16284PlayersString() {
        return (String) this.retroAchievementsGameMoreThen16284PlayersString$delegate.getValue();
    }

    public final String getPlayerCountLabel(long j) {
        if (j == 0) {
            String retroAchievementsGame0PlayerString = getRetroAchievementsGame0PlayerString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGame0PlayerString, "<get-retroAchievementsGame0PlayerString>(...)");
            return retroAchievementsGame0PlayerString;
        }
        if (64 <= j && j < 128) {
            String retroAchievementsGameMoreThen64PlayersString = getRetroAchievementsGameMoreThen64PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen64PlayersString, "<get-retroAchievementsGa…Then64PlayersString>(...)");
            return retroAchievementsGameMoreThen64PlayersString;
        }
        if (128 <= j && j < 256) {
            String retroAchievementsGameMoreThen128PlayersString = getRetroAchievementsGameMoreThen128PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen128PlayersString, "<get-retroAchievementsGa…hen128PlayersString>(...)");
            return retroAchievementsGameMoreThen128PlayersString;
        }
        if (256 <= j && j < 512) {
            String retroAchievementsGameMoreThen256PlayersString = getRetroAchievementsGameMoreThen256PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen256PlayersString, "<get-retroAchievementsGa…hen256PlayersString>(...)");
            return retroAchievementsGameMoreThen256PlayersString;
        }
        if (512 <= j && j < 1024) {
            String retroAchievementsGameMoreThen512PlayersString = getRetroAchievementsGameMoreThen512PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen512PlayersString, "<get-retroAchievementsGa…hen512PlayersString>(...)");
            return retroAchievementsGameMoreThen512PlayersString;
        }
        if (1024 <= j && j < 2048) {
            String retroAchievementsGameMoreThen1024PlayersString = getRetroAchievementsGameMoreThen1024PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen1024PlayersString, "<get-retroAchievementsGa…en1024PlayersString>(...)");
            return retroAchievementsGameMoreThen1024PlayersString;
        }
        if (2048 <= j && j < 4096) {
            String retroAchievementsGameMoreThen2048PlayersString = getRetroAchievementsGameMoreThen2048PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen2048PlayersString, "<get-retroAchievementsGa…en2048PlayersString>(...)");
            return retroAchievementsGameMoreThen2048PlayersString;
        }
        if (4096 <= j && j < 8192) {
            String retroAchievementsGameMoreThen4096PlayersString = getRetroAchievementsGameMoreThen4096PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen4096PlayersString, "<get-retroAchievementsGa…en4096PlayersString>(...)");
            return retroAchievementsGameMoreThen4096PlayersString;
        }
        if (8192 <= j && j < 16284) {
            String retroAchievementsGameMoreThen8192PlayersString = getRetroAchievementsGameMoreThen8192PlayersString();
            Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen8192PlayersString, "<get-retroAchievementsGa…en8192PlayersString>(...)");
            return retroAchievementsGameMoreThen8192PlayersString;
        }
        String retroAchievementsGameMoreThen16284PlayersString = getRetroAchievementsGameMoreThen16284PlayersString();
        Intrinsics.checkNotNullExpressionValue(retroAchievementsGameMoreThen16284PlayersString, "<get-retroAchievementsGa…n16284PlayersString>(...)");
        return retroAchievementsGameMoreThen16284PlayersString;
    }

    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment$SimilarListAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "playableItemEntityList", "", "(Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment$SimilarListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class SimilarListAdapter extends DaijishouRecyclerView.Adapter<PlayableItemEntity> {
        private final List<PlayableItemEntity> playableItemEntityList;
        final /* synthetic */ PlayableItemDetailDialogFragment this$0;

        public long getItemId(int i) {
            return i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SimilarListAdapter(PlayableItemDetailDialogFragment playableItemDetailDialogFragment, List<PlayableItemEntity> playableItemEntityList) {
            super(playableItemEntityList, false, false, 6, null);
            Intrinsics.checkNotNullParameter(playableItemEntityList, "playableItemEntityList");
            this.this$0 = playableItemDetailDialogFragment;
            this.playableItemEntityList = playableItemEntityList;
        }

        /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment$SimilarListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment$SimilarListAdapter;Landroid/view/View;)V", "favoriteImageView", "Landroid/widget/ImageView;", "firstLine", "Landroid/widget/TextView;", "newlyImageView", "recentImageView", "secondLine", "onBind", "", "position", "", "item", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, PlayableItemEntity item) {
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
                long jCurrentTimeMillis = System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc());
                long jCurrentTimeMillis2 = System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc());
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

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_similar_playable_item, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_baseline_check_circle_24, contextRequireContext.getTheme());
        Intrinsics.checkNotNull(drawable);
        this.isCompletedDrawable = drawable;
        Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_round_check_circle_outline_24, contextRequireContext.getTheme());
        Intrinsics.checkNotNull(drawable2);
        this.isNotCompletedDrawable = drawable2;
        Drawable drawable3 = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_round_favorite_24, contextRequireContext.getTheme());
        Intrinsics.checkNotNull(drawable3);
        this.isFavoriteDrawable = drawable3;
        Drawable drawable4 = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_round_favorite_border_24, contextRequireContext.getTheme());
        Intrinsics.checkNotNull(drawable4);
        this.isNotFavoriteDrawable = drawable4;
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
        this.displayHeightPixels = getScreenHeight((Activity) fragmentActivityRequireActivity);
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

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.heightPixels / displayMetrics.widthPixels;
        if (f < 1.0f) {
            f = 1.0f / f;
        }
        new LinearSmoothScroller(contextRequireContext) { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.onCreateView.1
            protected int getHorizontalSnapPreference() {
                return 0;
            }
        };
        View viewInflate = inflater.inflate(R.layout.fragment_playable_item_detail, viewGroup, true);
        ConstraintLayout constraintLayoutFindViewById = viewInflate.findViewById(R.id.rounded_full_screen_dialog_root);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        this.root = constraintLayoutFindViewById;
        View viewFindViewById = viewInflate.findViewById(R.id.playable_item_detail_scroll_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.detailScrollView = (ScrollView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.playable_item_detail_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        this.titleTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$5(this.f$0, view);
            }
        });
        View viewFindViewById3 = viewInflate.findViewById(R.id.playable_item_detail_platform_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.platformTextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.playable_item_detail_platform_description_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.platformDescriptionTextView = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.playable_item_detail_genres_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.genresTextView = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.playable_item_detail_retro_achievements_textview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.retroAchievementsTextView = (TextView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.playable_item_detail_description_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.descriptionTextView = (TextView) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.playable_item_detail_detail_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.detailTextView = (TextView) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(R.id.playable_item_detail_thumbnail);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.thumbnail = (ImageView) viewFindViewById9;
        View viewFindViewById10 = viewInflate.findViewById(R.id.playable_item_detail_content_grad);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.gradientImageView = (ImageView) viewFindViewById10;
        View viewFindViewById11 = viewInflate.findViewById(R.id.rounded_full_screen_dialog_background);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.background = (ImageView) viewFindViewById11;
        View viewFindViewById12 = viewInflate.findViewById(R.id.playable_item_detail_recent_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.recentImageView = (ImageView) viewFindViewById12;
        View viewFindViewById13 = viewInflate.findViewById(R.id.playable_item_detail_newly_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.newlyImageView = (ImageView) viewFindViewById13;
        View viewFindViewById14 = viewInflate.findViewById(R.id.playable_item_detail_favorite_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.favoriteImageView = (ImageView) viewFindViewById14;
        View viewFindViewById15 = viewInflate.findViewById(R.id.playable_item_detail_completed_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.completedImageView = (ImageView) viewFindViewById15;
        ConstraintLayout constraintLayoutFindViewById2 = viewInflate.findViewById(R.id.playable_item_detail_background_set);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById2, "findViewById(...)");
        this.backgroundSetLayout = constraintLayoutFindViewById2;
        ConstraintLayout constraintLayoutFindViewById3 = viewInflate.findViewById(R.id.rounded_full_screen_dialog_container);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById3, "findViewById(...)");
        this.detailContainerLayout = constraintLayoutFindViewById3;
        View viewFindViewById16 = viewInflate.findViewById(R.id.playable_item_detail_placeholder);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.placeholder = (ImageView) viewFindViewById16;
        View viewFindViewById17 = viewInflate.findViewById(R.id.player_associated_platforms_horizontal_scroll_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.horizontalScrollView = (HorizontalScrollView) viewFindViewById17;
        Chip chipFindViewById = viewInflate.findViewById(R.id.playable_item_detail_preview_video_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById, "findViewById(...)");
        this.previewVideoButton = chipFindViewById;
        Chip chipFindViewById2 = viewInflate.findViewById(R.id.playable_item_detail_play_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById2, "findViewById(...)");
        this.playButton = chipFindViewById2;
        Chip chipFindViewById3 = viewInflate.findViewById(R.id.playable_item_detail_favorite_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById3, "findViewById(...)");
        this.favoriteButton = chipFindViewById3;
        Chip chipFindViewById4 = viewInflate.findViewById(R.id.playable_item_detail_completed_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById4, "findViewById(...)");
        this.completeButton = chipFindViewById4;
        Chip chipFindViewById5 = viewInflate.findViewById(R.id.playable_item_detail_pin_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById5, "findViewById(...)");
        this.pinButton = chipFindViewById5;
        Chip chipFindViewById6 = viewInflate.findViewById(R.id.playable_item_detail_recent_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById6, "findViewById(...)");
        this.recentButton = chipFindViewById6;
        Chip chipFindViewById7 = viewInflate.findViewById(R.id.playable_item_detail_newly_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById7, "findViewById(...)");
        this.newlyButton = chipFindViewById7;
        Chip chipFindViewById8 = viewInflate.findViewById(R.id.playable_item_detail_edit_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById8, "findViewById(...)");
        this.editButton = chipFindViewById8;
        Object objFindViewById = viewInflate.findViewById(R.id.playable_item_detail_similar_items_recycler_view);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        this.similarItemsRecyclerView = (DaijishouRecyclerView) objFindViewById;
        this.similarItemsRecyclerViewAdapter = new SimilarListAdapter(this, this.similarPlayableItemList);
        this.similarItemsRecyclerViewLayoutManager = new DaijishouLinearLayoutManager(contextRequireContext, 0, false);
        View viewFindViewById18 = viewInflate.findViewById(R.id.playable_item_detail_similar_items_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.similarItemsLayout = (LinearLayout) viewFindViewById18;
        SharedPreferences defaultSharedPreferences = getDefaultSharedPreferences();
        View viewFindViewById19 = viewInflate.findViewById(R.id.playable_item_detail_youtube_player_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        YoutubePlayerService youtubePlayerService = new YoutubePlayerService(getDaijishouLibrary(), (Fragment) this, defaultSharedPreferences, (YouTubePlayerView) viewFindViewById19);
        Chip chip = this.previewVideoButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
            chip = null;
        }
        chip.setVisibility(8);
        youtubePlayerService.getManager().onPlaying(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$3$1
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageView imageView = this.this$0.background;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("background");
                    imageView = null;
                }
                imageView.setVisibility(4);
            }
        }).onStopped(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$3$2
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageView imageView = this.this$0.background;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("background");
                    imageView = null;
                }
                imageView.setVisibility(0);
            }
        }).onLinkReady(new PlayableItemDetailDialogFragment$onCreateView$3$3(this));
        PlayableItemEntity playableItemEntity = this.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        this.youtubePlayerService = youtubePlayerService.initialize(playableItemEntity);
        this.similarPlayableItemList.clear();
        Chip chip2 = this.editButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip2 = null;
        }
        chip2.setVisibility(isKioskMode() ? 8 : 0);
        ScrollView scrollView = this.detailScrollView;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailScrollView");
            scrollView = null;
        }
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$7(this.f$0, view, i, i2, i3, i4);
            }
        });
        ImageView imageView = this.gradientImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradientImageView");
            imageView = null;
        }
        imageView.setVisibility(8);
        Chip chip3 = this.previewVideoButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
            chip3 = null;
        }
        Typeface typeface2 = typeface;
        chip3.setTypeface(typeface2);
        Chip chip4 = this.playButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip4 = null;
        }
        chip4.setTypeface((Typeface) null, 3);
        Chip chip5 = this.favoriteButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip5 = null;
        }
        chip5.setTypeface((Typeface) null, 1);
        Chip chip6 = this.completeButton;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            chip6 = null;
        }
        chip6.setTypeface((Typeface) null, 1);
        Chip chip7 = this.pinButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip7 = null;
        }
        chip7.setTypeface((Typeface) null, 1);
        Chip chip8 = this.recentButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip8 = null;
        }
        chip8.setTypeface(typeface2);
        Chip chip9 = this.newlyButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip9 = null;
        }
        chip9.setTypeface(typeface2);
        Chip chip10 = this.editButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip10 = null;
        }
        chip10.setTypeface(typeface2);
        ConstraintLayout constraintLayout = this.detailContainerLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailContainerLayout");
            constraintLayout = null;
        }
        ConstraintLayout.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        layoutParams.setMargins(0, getDpToPxConverter().convert(20.0f), 0, 0);
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
        daijishouRecyclerView.setLayoutManager((RecyclerView.LayoutManager) daijishouLinearLayoutManager4);
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
            ConstraintLayout.LayoutParams layoutParams2 = constraintLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            layoutParams2.dimensionRatio = Constants.layoutDimensionRatio;
            ConstraintLayout constraintLayout3 = this.detailContainerLayout;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailContainerLayout");
                constraintLayout3 = null;
            }
            constraintLayout3.requestLayout();
        }
        DaijishouRecyclerView daijishouRecyclerView3 = this.similarItemsRecyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerView");
            daijishouRecyclerView3 = null;
        }
        daijishouRecyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.onCreateView.5
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, i);
                DaijishouRecyclerView daijishouRecyclerView4 = PlayableItemDetailDialogFragment.this.similarItemsRecyclerView;
                TextView textView2 = null;
                if (daijishouRecyclerView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerView");
                    daijishouRecyclerView4 = null;
                }
                LinearLayoutManager layoutManager = daijishouRecyclerView4.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager);
                int iFindFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                DaijishouRecyclerView daijishouRecyclerView5 = PlayableItemDetailDialogFragment.this.similarItemsRecyclerView;
                if (daijishouRecyclerView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerView");
                    daijishouRecyclerView5 = null;
                }
                RecyclerView.LayoutManager layoutManager2 = daijishouRecyclerView5.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager2);
                View viewFindViewByPosition = layoutManager2.findViewByPosition(iFindFirstVisibleItemPosition);
                if (viewFindViewByPosition != null) {
                    TextView textView3 = PlayableItemDetailDialogFragment.this.detailTextView;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
                    } else {
                        textView2 = textView3;
                    }
                    textView2.setNextFocusDownId(viewFindViewByPosition.getId());
                }
            }
        });
        ConstraintLayout constraintLayout4 = this.backgroundSetLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout4 = null;
        }
        constraintLayout4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$8(view, z);
            }
        });
        Chip chip11 = this.playButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip11 = null;
        }
        chip11.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$9(view, z);
            }
        });
        Chip chip12 = this.favoriteButton;
        if (chip12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip12 = null;
        }
        chip12.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$10(view, z);
            }
        });
        Chip chip13 = this.completeButton;
        if (chip13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            chip13 = null;
        }
        chip13.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$11(view, z);
            }
        });
        Chip chip14 = this.pinButton;
        if (chip14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip14 = null;
        }
        chip14.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$12(view, z);
            }
        });
        Chip chip15 = this.previewVideoButton;
        if (chip15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewVideoButton");
            chip15 = null;
        }
        chip15.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$13(view, z);
            }
        });
        Chip chip16 = this.recentButton;
        if (chip16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip16 = null;
        }
        chip16.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$14(view, z);
            }
        });
        Chip chip17 = this.newlyButton;
        if (chip17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip17 = null;
        }
        chip17.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$15(view, z);
            }
        });
        Chip chip18 = this.editButton;
        if (chip18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip18 = null;
        }
        chip18.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$16(view, z);
            }
        });
        ConstraintLayout constraintLayout5 = this.backgroundSetLayout;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout5 = null;
        }
        constraintLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$17(this.f$0, fragmentActivityRequireActivity, view);
            }
        });
        TextView textView2 = this.retroAchievementsTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsTextView");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$20(this.f$0, fragmentActivityRequireActivity, view);
            }
        });
        Chip chip19 = this.playButton;
        if (chip19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip19 = null;
        }
        chip19.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$21(this.f$0, fragmentActivityRequireActivity, view);
            }
        });
        Chip chip20 = this.favoriteButton;
        if (chip20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip20 = null;
        }
        chip20.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$22(this.f$0, view);
            }
        });
        Chip chip21 = this.completeButton;
        if (chip21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            chip21 = null;
        }
        chip21.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$23(this.f$0, view);
            }
        });
        Chip chip22 = this.pinButton;
        if (chip22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip22 = null;
        }
        chip22.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$24(this.f$0, view);
            }
        });
        Chip chip23 = this.editButton;
        if (chip23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip23 = null;
        }
        chip23.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayableItemDetailDialogFragment.onCreateView$lambda$25(this.f$0, view);
            }
        });
        TextView textView3 = this.detailTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
            textView3 = null;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws UnsupportedEncodingException {
                PlayableItemDetailDialogFragment.onCreateView$lambda$26(this.f$0, view);
            }
        });
        SimilarListAdapter similarListAdapter2 = this.similarItemsRecyclerViewAdapter;
        if (similarListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("similarItemsRecyclerViewAdapter");
            similarListAdapter2 = null;
        }
        similarListAdapter2.setOnItemClickListener(new Function4<View, Integer, Long, PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.onCreateView.23
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity2) {
                invoke(view, num.intValue(), l.longValue(), playableItemEntity2);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, PlayableItemEntity it) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(it, "it");
                PlayableItemDetailDialogFragment.Companion.newInstance(it).show(PlayableItemDetailDialogFragment.this.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
                PlayableItemDetailDialogFragment.this.requireDialog().dismiss();
            }
        });
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        PlayableItemEntity playableItemEntity2 = this.playableItemEntity;
        if (playableItemEntity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity2 = null;
        }
        refreshPlayableItem(playableItemEntity2);
        PlayableItemDetailViewModel playableItemDetailViewModel = getPlayableItemDetailViewModel();
        PlayableItemEntity playableItemEntity3 = this.playableItemEntity;
        if (playableItemEntity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity3 = null;
        }
        LiveData<PlayableItemEntity> liveDataOnPlayableItem = playableItemDetailViewModel.onPlayableItem(playableItemEntity3);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        liveDataOnPlayableItem.observe(lifecycleOwner, new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.onCreateView.24
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity4) {
                invoke2(playableItemEntity4);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayableItemEntity playableItemEntity4) {
                if (!booleanRef.element) {
                    Integer num = (Integer) this.getDaijishouSynchronization().getStatusLiveData().getValue();
                    if ((num != null && num.intValue() == 3) || playableItemEntity4 == null) {
                        return;
                    }
                    this.refreshPlayableItem(playableItemEntity4);
                    return;
                }
                booleanRef.element = false;
            }
        }));
        PlayableItemEntity playableItemEntity4 = this.playableItemEntity;
        if (playableItemEntity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity4 = null;
        }
        Long attachedPlatformId = playableItemEntity4.getAttachedPlatformId();
        if (attachedPlatformId != null) {
            PlatformEntity platformByIdStatically = getDaijishouLibrary().getPlatformByIdStatically(attachedPlatformId.longValue());
            if (platformByIdStatically != null) {
                refreshPlatform(platformByIdStatically);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
        }
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = true;
        getPlayableItemDetailViewModel().getPlatformEntityLiveData().observe(lifecycleOwner, new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<PlatformEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.onCreateView.26
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
                invoke2(platformEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlatformEntity platformEntity) {
                if (booleanRef2.element) {
                    booleanRef2.element = false;
                    return;
                }
                PlayableItemDetailDialogFragment playableItemDetailDialogFragment = this;
                Intrinsics.checkNotNull(platformEntity);
                playableItemDetailDialogFragment.refreshPlatform(platformEntity);
            }
        }));
        getPlayableItemDetailViewModel().getSelectedPlayableItemDescriptionLiveData().observe(lifecycleOwner, new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.onCreateView.27
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                TextView textView4 = null;
                if (str == null) {
                    TextView textView5 = PlayableItemDetailDialogFragment.this.detailTextView;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
                        textView5 = null;
                    }
                    textView5.setText((CharSequence) null);
                    TextView textView6 = PlayableItemDetailDialogFragment.this.detailTextView;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
                    } else {
                        textView4 = textView6;
                    }
                    textView4.setVisibility(8);
                    return;
                }
                TextView textView7 = PlayableItemDetailDialogFragment.this.detailTextView;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
                    textView7 = null;
                }
                textView7.setText(Html.fromHtml(str));
                TextView textView8 = PlayableItemDetailDialogFragment.this.detailTextView;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("detailTextView");
                } else {
                    textView4 = textView8;
                }
                textView4.setVisibility(0);
            }
        }));
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "enable_retro_achievements", true);
        SharedPreferences sharedPreferences = this.retroAchievementsSharedPreferences;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsSharedPreferences");
            sharedPreferences = null;
        }
        SharedPreferenceStringLiveData sharedPreferenceStringLiveData = new SharedPreferenceStringLiveData(sharedPreferences, RetroAchievementsManager.USERNAME_PREFERENCE_STRING, null);
        SharedPreferences sharedPreferences2 = this.retroAchievementsSharedPreferences;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsSharedPreferences");
            sharedPreferences2 = null;
        }
        LiveData tripleLiveData = new TripleLiveData(sharedPreferenceBooleanLiveData, sharedPreferenceStringLiveData, new SharedPreferenceStringLiveData(sharedPreferences2, RetroAchievementsManager.WEB_API_KEY_PREFERENCE_STRING, null));
        tripleLiveData.observe(getViewLifecycleOwner(), new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<Triple<? extends Boolean, ? extends String, ? extends String>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.onCreateView.28
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Triple<? extends Boolean, ? extends String, ? extends String> triple) {
                invoke2((Triple<Boolean, String, String>) triple);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Triple<Boolean, String, String> triple) {
                TextView textView4 = PlayableItemDetailDialogFragment.this.retroAchievementsTextView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsTextView");
                    textView4 = null;
                }
                textView4.setVisibility(Intrinsics.areEqual((Object) triple.getFirst(), (Object) false) ? 8 : 0);
            }
        }));
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Transformations.switchMap(tripleLiveData, new Function1<Triple<Boolean, String, String>, LiveData<RetroAchievementsGameRecordEntity>>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final LiveData<RetroAchievementsGameRecordEntity> invoke(Triple<Boolean, String, String> triple) {
                final Boolean first = triple.getFirst();
                objectRef.element = triple.getSecond();
                String third = triple.getThird();
                PlayableItemEntity playableItemEntity5 = null;
                if (objectRef.element == null || third == null) {
                    TextView textView4 = this.retroAchievementsTextView;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsTextView");
                        textView4 = null;
                    }
                    String str = this.retroAchievementsLoginRequiredWitEmojiString;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsLoginRequiredWitEmojiString");
                        str = null;
                    }
                    textView4.setText(str);
                    return new MutableLiveData<>((Object) null);
                }
                final RetroAchievementsRepository retroAchievementsRepository = this.getRetroAchievementsManager().getRetroAchievementsRepository();
                TextView textView5 = this.retroAchievementsTextView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsTextView");
                    textView5 = null;
                }
                String str2 = this.retroAchievementsRefreshingString;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsRefreshingString");
                    str2 = null;
                }
                textView5.setText("🏆 " + str2);
                RetroAchievementsRepository retroAchievementsRepository2 = this.getRetroAchievementsManager().getRetroAchievementsRepository();
                PlayableItemEntity playableItemEntity6 = this.playableItemEntity;
                if (playableItemEntity6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                } else {
                    playableItemEntity5 = playableItemEntity6;
                }
                LiveData<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> retroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemId = retroAchievementsRepository2.getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemId(playableItemEntity5.getId());
                final PlayableItemDetailDialogFragment playableItemDetailDialogFragment = this;
                LiveData liveDataSwitchMap = Transformations.switchMap(retroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemId, new Function1<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity, LiveData<Long>>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
                    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1", f = "PlayableItemDetailDialogFragment.kt", i = {0}, l = {906, 907}, m = "invokeSuspend", n = {"$this$liveData"}, s = {"L$0"})
                    static final class C00131 extends SuspendLambda implements Function2<LiveDataScope<Long>, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Boolean $enableRA;
                        final /* synthetic */ RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity $surjection;
                        private /* synthetic */ Object L$0;
                        int label;
                        final /* synthetic */ PlayableItemDetailDialogFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00131(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity, Boolean bool, PlayableItemDetailDialogFragment playableItemDetailDialogFragment, Continuation<? super C00131> continuation) {
                            super(2, continuation);
                            this.$surjection = retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
                            this.$enableRA = bool;
                            this.this$0 = playableItemDetailDialogFragment;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            C00131 c00131 = new C00131(this.$surjection, this.$enableRA, this.this$0, continuation);
                            c00131.L$0 = obj;
                            return c00131;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(LiveDataScope<Long> liveDataScope, Continuation<? super Unit> continuation) {
                            return ((C00131) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
                        
                            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getIO(), new com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1.AnonymousClass1.C00131.C00141(r7.this$0, r7.$surjection, r1, null), r7) == r0) goto L19;
                         */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                            /*
                                r7 = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r7.label
                                r2 = 2
                                r3 = 1
                                if (r1 == 0) goto L22
                                if (r1 == r3) goto L1a
                                if (r1 != r2) goto L12
                                kotlin.ResultKt.throwOnFailure(r8)
                                goto L70
                            L12:
                                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r8.<init>(r0)
                                throw r8
                            L1a:
                                java.lang.Object r1 = r7.L$0
                                androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
                                kotlin.ResultKt.throwOnFailure(r8)
                                goto L44
                            L22:
                                kotlin.ResultKt.throwOnFailure(r8)
                                java.lang.Object r8 = r7.L$0
                                r1 = r8
                                androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
                                com.magneticchen.daijishou.data.db.entity.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity r8 = r7.$surjection
                                if (r8 == 0) goto L44
                                long r4 = r8.getGameId()
                                java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
                                r4 = r7
                                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                                r7.L$0 = r1
                                r7.label = r3
                                java.lang.Object r8 = r1.emit(r8, r4)
                                if (r8 != r0) goto L44
                                goto L6f
                            L44:
                                java.lang.Boolean r8 = r7.$enableRA
                                java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                                boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r3)
                                if (r8 == 0) goto L70
                                kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
                                kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
                                com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1$1 r3 = new com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1$1
                                com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment r4 = r7.this$0
                                com.magneticchen.daijishou.data.db.entity.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity r5 = r7.$surjection
                                r6 = 0
                                r3.<init>(r4, r5, r1, r6)
                                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                                r1 = r7
                                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                                r7.L$0 = r6
                                r7.label = r2
                                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r3, r1)
                                if (r8 != r0) goto L70
                            L6f:
                                return r0
                            L70:
                                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                                return r8
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1.AnonymousClass1.C00131.invokeSuspend(java.lang.Object):java.lang.Object");
                        }

                        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1$1", f = "PlayableItemDetailDialogFragment.kt", i = {}, l = {908, 911}, m = "invokeSuspend", n = {}, s = {})
                        static final class C00141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ LiveDataScope<Long> $$this$liveData;
                            final /* synthetic */ RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity $surjection;
                            int label;
                            final /* synthetic */ PlayableItemDetailDialogFragment this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00141(PlayableItemDetailDialogFragment playableItemDetailDialogFragment, RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity, LiveDataScope<Long> liveDataScope, Continuation<? super C00141> continuation) {
                                super(2, continuation);
                                this.this$0 = playableItemDetailDialogFragment;
                                this.$surjection = retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
                                this.$$this$liveData = liveDataScope;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C00141(this.this$0, this.$surjection, this.$$this$liveData, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C00141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
                            
                                if (r6.$$this$liveData.emit((java.lang.Object) null, r6) == r0) goto L21;
                             */
                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                                /*
                                    r6 = this;
                                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                    int r1 = r6.label
                                    r2 = 0
                                    r3 = 2
                                    r4 = 1
                                    if (r1 == 0) goto L1f
                                    if (r1 == r4) goto L1b
                                    if (r1 != r3) goto L13
                                    kotlin.ResultKt.throwOnFailure(r7)
                                    goto L5c
                                L13:
                                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                    r7.<init>(r0)
                                    throw r7
                                L1b:
                                    kotlin.ResultKt.throwOnFailure(r7)
                                    goto L42
                                L1f:
                                    kotlin.ResultKt.throwOnFailure(r7)
                                    com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment r7 = r6.this$0
                                    com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager r7 = com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.access$getRetroAchievementsManager(r7)
                                    com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment r1 = r6.this$0
                                    com.magneticchen.daijishou.data.db.entity.PlayableItemEntity r1 = com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.access$getPlayableItemEntity$p(r1)
                                    if (r1 != 0) goto L36
                                    java.lang.String r1 = "playableItemEntity"
                                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                                    r1 = r2
                                L36:
                                    r5 = r6
                                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                                    r6.label = r4
                                    java.lang.Object r7 = r7.refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntityIfExpired(r1, r5)
                                    if (r7 != r0) goto L42
                                    goto L5b
                                L42:
                                    java.lang.Boolean r7 = (java.lang.Boolean) r7
                                    boolean r7 = r7.booleanValue()
                                    com.magneticchen.daijishou.data.db.entity.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity r1 = r6.$surjection
                                    if (r1 != 0) goto L5c
                                    if (r7 != 0) goto L5c
                                    androidx.lifecycle.LiveDataScope<java.lang.Long> r7 = r6.$$this$liveData
                                    r1 = r6
                                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                                    r6.label = r3
                                    java.lang.Object r7 = r7.emit(r2, r1)
                                    if (r7 != r0) goto L5c
                                L5b:
                                    return r0
                                L5c:
                                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                                    return r7
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1.AnonymousClass1.C00131.C00141.invokeSuspend(java.lang.Object):java.lang.Object");
                            }
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final LiveData<Long> invoke(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) {
                        return CoroutineLiveDataKt.liveData$default(Dispatchers.getMain(), 0L, new C00131(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity, first, playableItemDetailDialogFragment, null), 2, (Object) null);
                    }
                });
                final Ref.ObjectRef<String> objectRef2 = objectRef;
                final PlayableItemDetailDialogFragment playableItemDetailDialogFragment2 = this;
                return Transformations.switchMap(liveDataSwitchMap, new Function1<Long, LiveData<RetroAchievementsGameRecordEntity>>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    @Override // kotlin.jvm.functions.Function1
                    public final LiveData<RetroAchievementsGameRecordEntity> invoke(final Long l) {
                        if (l == null) {
                            return new MutableLiveData<>((Object) null);
                        }
                        RetroAchievementsRepository retroAchievementsRepository3 = retroAchievementsRepository;
                        String str3 = objectRef2.element;
                        Intrinsics.checkNotNull(str3);
                        LiveData<RetroAchievementsGameRecordEntity> retroAchievementsGameRecordByUserIdAndGameId = retroAchievementsRepository3.getRetroAchievementsGameRecordByUserIdAndGameId(str3, l.longValue());
                        final Boolean bool = first;
                        final PlayableItemDetailDialogFragment playableItemDetailDialogFragment3 = playableItemDetailDialogFragment2;
                        return Transformations.switchMap(retroAchievementsGameRecordByUserIdAndGameId, new Function1<RetroAchievementsGameRecordEntity, LiveData<RetroAchievementsGameRecordEntity>>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.onCreateView.retroAchievementsGameRecordLiveData.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            

                            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 9, 0}, xi = 48)
                            @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1", f = "PlayableItemDetailDialogFragment.kt", i = {}, l = {920, 921, 927, 929}, m = "invokeSuspend", n = {}, s = {})
                            static final class C00151 extends SuspendLambda implements Function2<LiveDataScope<RetroAchievementsGameRecordEntity>, Continuation<? super Unit>, Object> {
                                final /* synthetic */ Boolean $enableRA;
                                final /* synthetic */ Long $gameId;
                                final /* synthetic */ RetroAchievementsGameRecordEntity $gameRecord;
                                private /* synthetic */ Object L$0;
                                int label;
                                final /* synthetic */ PlayableItemDetailDialogFragment this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C00151(Boolean bool, Long l, RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity, PlayableItemDetailDialogFragment playableItemDetailDialogFragment, Continuation<? super C00151> continuation) {
                                    super(2, continuation);
                                    this.$enableRA = bool;
                                    this.$gameId = l;
                                    this.$gameRecord = retroAchievementsGameRecordEntity;
                                    this.this$0 = playableItemDetailDialogFragment;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    C00151 c00151 = new C00151(this.$enableRA, this.$gameId, this.$gameRecord, this.this$0, continuation);
                                    c00151.L$0 = obj;
                                    return c00151;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(LiveDataScope<RetroAchievementsGameRecordEntity> liveDataScope, Continuation<? super Unit> continuation) {
                                    return ((C00151) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                /* JADX WARN: Code duplicated, block: B:25:0x005d  */
                                /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
                                
                                    if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getIO(), new com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1.AnonymousClass2.AnonymousClass1.C00151.C00161(r9.this$0, r9.$gameId, null), r9) == r0) goto L33;
                                 */
                                /* JADX WARN: Code restructure failed: missing block: B:29:0x0083, code lost:
                                
                                    if (r10.emit((java.lang.Object) null, r9) == r0) goto L33;
                                 */
                                /* JADX WARN: Code restructure failed: missing block: B:32:0x008f, code lost:
                                
                                    if (r10.emit((java.lang.Object) null, r9) == r0) goto L33;
                                 */
                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct add '--show-bad-code' argument
                                */
                                public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                                    /*
                                        r9 = this;
                                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                        int r1 = r9.label
                                        r2 = 4
                                        r3 = 3
                                        r4 = 2
                                        r5 = 0
                                        r6 = 1
                                        if (r1 == 0) goto L27
                                        if (r1 == r6) goto L23
                                        if (r1 == r4) goto L1e
                                        if (r1 == r3) goto L1e
                                        if (r1 != r2) goto L16
                                        goto L1e
                                    L16:
                                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                        r10.<init>(r0)
                                        throw r10
                                    L1e:
                                        kotlin.ResultKt.throwOnFailure(r10)
                                        goto L92
                                    L23:
                                        kotlin.ResultKt.throwOnFailure(r10)
                                        goto L5d
                                    L27:
                                        kotlin.ResultKt.throwOnFailure(r10)
                                        java.lang.Object r10 = r9.L$0
                                        androidx.lifecycle.LiveDataScope r10 = (androidx.lifecycle.LiveDataScope) r10
                                        java.lang.Boolean r1 = r9.$enableRA
                                        java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
                                        boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r7)
                                        if (r1 == 0) goto L86
                                        java.lang.Long r1 = r9.$gameId
                                        com.magneticchen.daijishou.data.db.entity.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity$Companion r2 = com.magneticchen.daijishou.data.db.entity.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.Companion
                                        long r7 = r2.getNULL_GAME_ID()
                                        if (r1 != 0) goto L45
                                        goto L4d
                                    L45:
                                        long r1 = r1.longValue()
                                        int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
                                        if (r1 == 0) goto L7a
                                    L4d:
                                        com.magneticchen.daijishou.data.db.entity.RetroAchievementsGameRecordEntity r1 = r9.$gameRecord
                                        if (r1 == 0) goto L5d
                                        r2 = r9
                                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                                        r9.label = r6
                                        java.lang.Object r10 = r10.emit(r1, r2)
                                        if (r10 != r0) goto L5d
                                        goto L91
                                    L5d:
                                        kotlinx.coroutines.CoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getIO()
                                        kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
                                        com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1$1 r1 = new com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1$1
                                        com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment r2 = r9.this$0
                                        java.lang.Long r3 = r9.$gameId
                                        r1.<init>(r2, r3, r5)
                                        kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                                        r2 = r9
                                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                                        r9.label = r4
                                        java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r1, r2)
                                        if (r10 != r0) goto L92
                                        goto L91
                                    L7a:
                                        r1 = r9
                                        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                                        r9.label = r3
                                        java.lang.Object r10 = r10.emit(r5, r1)
                                        if (r10 != r0) goto L92
                                        goto L91
                                    L86:
                                        r1 = r9
                                        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                                        r9.label = r2
                                        java.lang.Object r10 = r10.emit(r5, r1)
                                        if (r10 != r0) goto L92
                                    L91:
                                        return r0
                                    L92:
                                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                                        return r10
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1.AnonymousClass2.AnonymousClass1.C00151.invokeSuspend(java.lang.Object):java.lang.Object");
                                }

                                /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1$1, reason: invalid class name and collision with other inner class name */
                                /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                                @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1$1", f = "PlayableItemDetailDialogFragment.kt", i = {}, l = {922}, m = "invokeSuspend", n = {}, s = {})
                                static final class C00161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
                                    final /* synthetic */ Long $gameId;
                                    int label;
                                    final /* synthetic */ PlayableItemDetailDialogFragment this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    C00161(PlayableItemDetailDialogFragment playableItemDetailDialogFragment, Long l, Continuation<? super C00161> continuation) {
                                        super(2, continuation);
                                        this.this$0 = playableItemDetailDialogFragment;
                                        this.$gameId = l;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C00161(this.this$0, this.$gameId, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                                        return ((C00161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) throws Throwable {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i != 0) {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                            return obj;
                                        }
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        Object objRefreshMyRetroAchievementsGameRecordByGameIdIfExpired = this.this$0.getRetroAchievementsManager().refreshMyRetroAchievementsGameRecordByGameIdIfExpired(this.$gameId.longValue(), this);
                                        return objRefreshMyRetroAchievementsGameRecordByGameIdIfExpired == coroutine_suspended ? coroutine_suspended : objRefreshMyRetroAchievementsGameRecordByGameIdIfExpired;
                                    }
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final LiveData<RetroAchievementsGameRecordEntity> invoke(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
                                return CoroutineLiveDataKt.liveData$default(Dispatchers.getMain(), 0L, new C00151(bool, l, retroAchievementsGameRecordEntity, playableItemDetailDialogFragment3, null), 2, (Object) null);
                            }
                        });
                    }
                });
            }
        }).observe(getViewLifecycleOwner(), new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<RetroAchievementsGameRecordEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.onCreateView.29
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

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
                    TextView textView4 = PlayableItemDetailDialogFragment.this.retroAchievementsTextView;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsTextView");
                        textView4 = null;
                    }
                    if (objectRef.element == null) {
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
                    textView4.setText(str3);
                    return;
                }
                TextView textView5 = PlayableItemDetailDialogFragment.this.retroAchievementsTextView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsTextView");
                    textView5 = null;
                }
                String name = retroAchievementsGameRecordEntity.getName();
                float unlockedAchievementsCount = DefinitionKt.NO_Float_VALUE;
                if (name != null && retroAchievementsGameRecordEntity.getRating() == null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str6 = PlayableItemDetailDialogFragment.this.retroAchievementsDescriptionNewFormatString;
                    if (str6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsDescriptionNewFormatString");
                    } else {
                        str3 = str6;
                    }
                    Long lValueOf = Long.valueOf(retroAchievementsGameRecordEntity.getDistinctPlayerCount());
                    String playerCountLabel = PlayableItemDetailDialogFragment.this.getPlayerCountLabel(retroAchievementsGameRecordEntity.getDistinctPlayerCount());
                    Integer numValueOf = Integer.valueOf(retroAchievementsGameRecordEntity.getUnlockedAchievementsCount());
                    Integer numValueOf2 = Integer.valueOf(retroAchievementsGameRecordEntity.getAchievementsCount());
                    if (retroAchievementsGameRecordEntity.getAchievementsCount() != DefinitionKt.NO_Float_VALUE) {
                        unlockedAchievementsCount = (retroAchievementsGameRecordEntity.getUnlockedAchievementsCount() * 100.0f) / retroAchievementsGameRecordEntity.getAchievementsCount();
                    }
                    String str7 = String.format(str3, Arrays.copyOf(new Object[]{lValueOf, playerCountLabel, numValueOf, numValueOf2, Float.valueOf(unlockedAchievementsCount)}, 5));
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
                    Float rating = retroAchievementsGameRecordEntity.getRating();
                    Integer numValueOf3 = Integer.valueOf(retroAchievementsGameRecordEntity.getRatingVotesCount());
                    Integer numValueOf4 = Integer.valueOf(retroAchievementsGameRecordEntity.getUnlockedAchievementsCount());
                    Integer numValueOf5 = Integer.valueOf(retroAchievementsGameRecordEntity.getAchievementsCount());
                    if (retroAchievementsGameRecordEntity.getAchievementsCount() != DefinitionKt.NO_Float_VALUE) {
                        unlockedAchievementsCount = (retroAchievementsGameRecordEntity.getUnlockedAchievementsCount() * 100.0f) / retroAchievementsGameRecordEntity.getAchievementsCount();
                    }
                    String str9 = String.format(str3, Arrays.copyOf(new Object[]{rating, numValueOf3, numValueOf4, numValueOf5, Float.valueOf(unlockedAchievementsCount)}, 5));
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
                textView5.setText(str);
            }
        }));
        SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(contextRequireContext);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences2, "getDefaultSharedPreferences(...)");
        new SharedPreferenceBooleanLiveData(defaultSharedPreferences2, BooleanPreference.PRETTIFY_TITLES.getKey(), BooleanPreference.PRETTIFY_TITLES.getDefaultValue()).observe(lifecycleOwner, new PlayableItemDetailDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.onCreateView.30
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                PlayableItemEntity playableItemEntity5 = PlayableItemDetailDialogFragment.this.playableItemEntity;
                TextView textView4 = null;
                if (playableItemEntity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                    playableItemEntity5 = null;
                }
                PlayableItemDetailDialogFragment playableItemDetailDialogFragment = PlayableItemDetailDialogFragment.this;
                TextView textView5 = playableItemDetailDialogFragment.titleTextView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                } else {
                    textView4 = textView5;
                }
                textView4.setText(playableItemEntity5.getDoNotPrettify() ? playableItemEntity5.getName() : playableItemDetailDialogFragment.getDaijishouLibrary().prettifyTitleWithPreferences(playableItemEntity5.getName()));
            }
        }));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5(PlayableItemDetailDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        String name = playableItemEntity.getName();
        TextView textView = this$0.titleTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        TextView textView2 = this$0.titleTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView2 = null;
        }
        textView.setText(Intrinsics.areEqual(textView2.getText(), name) ? DaijishouLibraryModel.prettifyTitle$default(this$0.getDaijishouLibrary(), name, false, 2, null) : name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7(PlayableItemDetailDialogFragment this$0, View view, int i, int i2, int i3, int i4) {
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
    public static final void onCreateView$lambda$14(View view, boolean z) {
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
    public static final void onCreateView$lambda$15(View view, boolean z) {
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
    public static final void onCreateView$lambda$16(View view, boolean z) {
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
    public static final void onCreateView$lambda$17(PlayableItemDetailDialogFragment this$0, FragmentActivity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
        Activity activity2 = (Activity) activity;
        PlayableItemEntity playableItemEntity = this$0.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        daijishouLibrary.play(activity2, playableItemEntity, new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$15$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$20(PlayableItemDetailDialogFragment this$0, FragmentActivity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity = this$0.retroAchievementsGameRecord;
        if (retroAchievementsGameRecordEntity == null || retroAchievementsGameRecordEntity.getName() == null) {
            return;
        }
        RetroAchievementsGameDialogFragment.Companion companion = RetroAchievementsGameDialogFragment.Companion;
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
    public static final void onCreateView$lambda$21(PlayableItemDetailDialogFragment this$0, FragmentActivity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
        Activity activity2 = (Activity) activity;
        PlayableItemEntity playableItemEntity = this$0.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        DaijishouLibraryModel.play$default(daijishouLibrary, activity2, playableItemEntity, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$22(PlayableItemDetailDialogFragment this$0, View view) {
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
    public static final void onCreateView$lambda$23(PlayableItemDetailDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
        PlayableItemEntity playableItemEntity = this$0.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        daijishouLibrary.toggleIsPlayableItemCompleted(playableItemEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$24(final PlayableItemDetailDialogFragment this$0, View view) {
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
                widgetManager.requestWidgetInstanceRemoval(appCompatActivity, PinAndPlayWidgetBuilder.class, playableItemEntity.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds(), new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$20$2
                    

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        PlayableItemDetailDialogFragment playableItemDetailDialogFragment;
                        int i;
                        Context contextRequireContext = this.this$0.requireContext();
                        if (z) {
                            playableItemDetailDialogFragment = this.this$0;
                            i = R.string.remove_pin_succeed_message;
                        } else {
                            playableItemDetailDialogFragment = this.this$0;
                            i = R.string.remove_pin_failed_message;
                        }
                        Toast.makeText(contextRequireContext, playableItemDetailDialogFragment.getString(i), 0).show();
                    }
                });
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
                widgetManager2.requestWidgetInstanceCreation(appCompatActivity2, PinAndPlayWidgetBuilder.class, Long.valueOf(playableItemEntity.getId()), new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$20$1
                    

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        PlayableItemDetailDialogFragment playableItemDetailDialogFragment;
                        int i;
                        Context contextRequireContext = this.this$0.requireContext();
                        if (z) {
                            playableItemDetailDialogFragment = this.this$0;
                            i = R.string.pin_succeed_message;
                        } else {
                            playableItemDetailDialogFragment = this.this$0;
                            i = R.string.pin_failed_message;
                        }
                        Toast.makeText(contextRequireContext, playableItemDetailDialogFragment.getString(i), 0).show();
                    }
                });
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
                widgetManager3.requestWidgetInstanceRemoval(appCompatActivity3, PinAndPlayWidgetBuilder.class, Long.valueOf(playableItemEntity.getId()), new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$20$4
                    

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        PlayableItemDetailDialogFragment playableItemDetailDialogFragment;
                        int i;
                        Context contextRequireContext = this.this$0.requireContext();
                        if (z) {
                            playableItemDetailDialogFragment = this.this$0;
                            i = R.string.remove_pin_succeed_message;
                        } else {
                            playableItemDetailDialogFragment = this.this$0;
                            i = R.string.remove_pin_failed_message;
                        }
                        Toast.makeText(contextRequireContext, playableItemDetailDialogFragment.getString(i), 0).show();
                    }
                });
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
                widgetManager4.requestWidgetInstanceCreation(appCompatActivity4, PinAndPlayWidgetBuilder.class, Long.valueOf(playableItemEntity.getId()), new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$onCreateView$20$3
                    

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        PlayableItemDetailDialogFragment playableItemDetailDialogFragment;
                        int i;
                        Context contextRequireContext = this.this$0.requireContext();
                        if (z) {
                            playableItemDetailDialogFragment = this.this$0;
                            i = R.string.pin_succeed_message;
                        } else {
                            playableItemDetailDialogFragment = this.this$0;
                            i = R.string.pin_failed_message;
                        }
                        Toast.makeText(contextRequireContext, playableItemDetailDialogFragment.getString(i), 0).show();
                    }
                });
            }
        }
        this$0.refreshPinButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$25(PlayableItemDetailDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Activity activity = (Activity) fragmentActivityRequireActivity;
        PlayableItemEntity playableItemEntity = this$0.playableItemEntity;
        if (playableItemEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
            playableItemEntity = null;
        }
        daijishouLibrary.editPlayableItem(activity, playableItemEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$26(PlayableItemDetailDialogFragment this$0, View view) throws UnsupportedEncodingException {
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

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog(...)");
        super.onViewCreated(view, bundle);
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
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                PlayableItemDetailDialogFragment.onViewCreated$lambda$29(this.f$0);
            }
        }, getResources().getInteger(android.R.integer.config_shortAnimTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$29(PlayableItemDetailDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ConstraintLayout constraintLayout = this$0.backgroundSetLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout = null;
        }
        constraintLayout.requestFocus();
    }

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
            window2.setFlags(CategoryWidgetViewModel.LIMIT, CategoryWidgetViewModel.LIMIT);
        }
    }

    public void onResume() {
        super.onResume();
        Window window = requireDialog().getWindow();
        Intrinsics.checkNotNull(window);
        window.getWindowManager().updateViewLayout(window.getDecorView(), window.getAttributes());
        MainActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.activities.MainActivity");
        activity.setAndroidPDialogFixStopKeyDispatching(false);
    }

    private final void onUpdateRecentIcon(PlayableItemEntityMergedInfo playableItemEntityMergedInfo) {
        Date date = new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc()));
        Date mergedLastPlayedTimestamp = playableItemEntityMergedInfo.getMergedLastPlayedTimestamp();
        ImageView imageView = null;
        if (mergedLastPlayedTimestamp != null && mergedLastPlayedTimestamp.after(date)) {
            ImageView imageView2 = this.recentImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentImageView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this.recentImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentImageView");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    private final void onUpdateRecentIcon(PlayableItemEntity playableItemEntity) {
        Date date = new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc()));
        Date lastPlayedTimestamp = playableItemEntity.getLastPlayedTimestamp();
        ImageView imageView = null;
        if (lastPlayedTimestamp != null && lastPlayedTimestamp.after(date)) {
            ImageView imageView2 = this.recentImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentImageView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this.recentImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentImageView");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    private final void onUpdateRecentButton(PlayableItemEntityMergedInfo playableItemEntityMergedInfo) {
        Date date = new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc()));
        Date mergedLastPlayedTimestamp = playableItemEntityMergedInfo.getMergedLastPlayedTimestamp();
        Chip chip = null;
        if (mergedLastPlayedTimestamp != null && mergedLastPlayedTimestamp.after(date)) {
            Chip chip2 = this.recentButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            } else {
                chip = chip2;
            }
            chip.setVisibility(0);
            return;
        }
        Chip chip3 = this.recentButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
        } else {
            chip = chip3;
        }
        chip.setVisibility(8);
    }

    private final void onUpdateRecentButton(PlayableItemEntity playableItemEntity) {
        Date date = new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc()));
        Date lastPlayedTimestamp = playableItemEntity.getLastPlayedTimestamp();
        Chip chip = null;
        if (lastPlayedTimestamp != null && lastPlayedTimestamp.after(date)) {
            Chip chip2 = this.recentButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            } else {
                chip = chip2;
            }
            chip.setVisibility(0);
            return;
        }
        Chip chip3 = this.recentButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
        } else {
            chip = chip3;
        }
        chip.setVisibility(8);
    }

    private final void onUpdateFavoriteButton(PlayableItemEntity playableItemEntity) {
        Chip chip = null;
        if (playableItemEntity.isFavorite()) {
            Chip chip2 = this.favoriteButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip2 = null;
            }
            Drawable drawable = this.isFavoriteDrawable;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("isFavoriteDrawable");
                drawable = null;
            }
            chip2.setChipIcon(drawable);
            Chip chip3 = this.favoriteButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            } else {
                chip = chip3;
            }
            chip.setText(getString(R.string.is_favorite));
            return;
        }
        Chip chip4 = this.favoriteButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip4 = null;
        }
        Drawable drawable2 = this.isNotFavoriteDrawable;
        if (drawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("isNotFavoriteDrawable");
            drawable2 = null;
        }
        chip4.setChipIcon(drawable2);
        Chip chip5 = this.favoriteButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
        } else {
            chip = chip5;
        }
        chip.setText(getString(R.string.add_favorite));
    }

    private final void onUpdateFavoriteButton(PlayableItemEntityMergedInfo playableItemEntityMergedInfo) {
        Chip chip = null;
        if (playableItemEntityMergedInfo.getMergedIsFavorite()) {
            Chip chip2 = this.favoriteButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip2 = null;
            }
            Drawable drawable = this.isFavoriteDrawable;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("isFavoriteDrawable");
                drawable = null;
            }
            chip2.setChipIcon(drawable);
            Chip chip3 = this.favoriteButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            } else {
                chip = chip3;
            }
            chip.setText(getString(R.string.is_favorite));
            return;
        }
        Chip chip4 = this.favoriteButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip4 = null;
        }
        Drawable drawable2 = this.isNotFavoriteDrawable;
        if (drawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("isNotFavoriteDrawable");
            drawable2 = null;
        }
        chip4.setChipIcon(drawable2);
        Chip chip5 = this.favoriteButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
        } else {
            chip = chip5;
        }
        chip.setText(getString(R.string.add_favorite));
    }

    private final void onUpdateFavoriteIcon(PlayableItemEntityMergedInfo playableItemEntityMergedInfo) {
        ImageView imageView = this.favoriteImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteImageView");
            imageView = null;
        }
        imageView.setVisibility(playableItemEntityMergedInfo.getMergedIsFavorite() ? 0 : 8);
    }

    private final void onUpdateFavoriteIcon(PlayableItemEntity playableItemEntity) {
        ImageView imageView = this.favoriteImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteImageView");
            imageView = null;
        }
        imageView.setVisibility(playableItemEntity.isFavorite() ? 0 : 8);
    }

    private final void onUpdateCompletedButton(PlayableItemEntity playableItemEntity) {
        Chip chip = null;
        if (playableItemEntity.isCompleted()) {
            Chip chip2 = this.completeButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("completeButton");
                chip2 = null;
            }
            Drawable drawable = this.isCompletedDrawable;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("isCompletedDrawable");
                drawable = null;
            }
            chip2.setChipIcon(drawable);
            Chip chip3 = this.completeButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            } else {
                chip = chip3;
            }
            chip.setText(getString(R.string.is_completed));
            return;
        }
        Chip chip4 = this.completeButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            chip4 = null;
        }
        Drawable drawable2 = this.isNotCompletedDrawable;
        if (drawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("isNotCompletedDrawable");
            drawable2 = null;
        }
        chip4.setChipIcon(drawable2);
        Chip chip5 = this.completeButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
        } else {
            chip = chip5;
        }
        chip.setText(getString(R.string.mark_completed));
    }

    private final void onUpdateCompletedButton(PlayableItemEntityMergedInfo playableItemEntityMergedInfo) {
        Chip chip = null;
        if (playableItemEntityMergedInfo.getMergedIsCompleted()) {
            Chip chip2 = this.completeButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("completeButton");
                chip2 = null;
            }
            Drawable drawable = this.isCompletedDrawable;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("isCompletedDrawable");
                drawable = null;
            }
            chip2.setChipIcon(drawable);
            Chip chip3 = this.completeButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            } else {
                chip = chip3;
            }
            chip.setText(getString(R.string.is_completed));
            return;
        }
        Chip chip4 = this.completeButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            chip4 = null;
        }
        Drawable drawable2 = this.isNotCompletedDrawable;
        if (drawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("isNotCompletedDrawable");
            drawable2 = null;
        }
        chip4.setChipIcon(drawable2);
        Chip chip5 = this.completeButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
        } else {
            chip = chip5;
        }
        chip.setText(getString(R.string.mark_completed));
    }

    private final void onUpdateCompletedIcon(PlayableItemEntity playableItemEntity) {
        ImageView imageView = null;
        if (playableItemEntity.isCompleted()) {
            ImageView imageView2 = this.completedImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("completedImageView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this.completedImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completedImageView");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    private final void onUpdateCompletedIcon(PlayableItemEntityMergedInfo playableItemEntityMergedInfo) {
        ImageView imageView = null;
        if (playableItemEntityMergedInfo.getMergedIsCompleted()) {
            ImageView imageView2 = this.completedImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("completedImageView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this.completedImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completedImageView");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    private final void initChipFocusListener() {
        ConstraintLayout constraintLayout = this.backgroundSetLayout;
        Chip chip = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout = null;
        }
        constraintLayout.setOnFocusChangeListener(this.focusListener);
        Chip chip2 = this.playButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip2 = null;
        }
        chip2.setOnFocusChangeListener(this.focusListener);
        Chip chip3 = this.favoriteButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip3 = null;
        }
        chip3.setOnFocusChangeListener(this.focusListener);
        Chip chip4 = this.completeButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            chip4 = null;
        }
        chip4.setOnFocusChangeListener(this.focusListener);
        Chip chip5 = this.pinButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip5 = null;
        }
        chip5.setOnFocusChangeListener(this.focusListener);
        Chip chip6 = this.recentButton;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip6 = null;
        }
        chip6.setOnFocusChangeListener(this.focusListener);
        Chip chip7 = this.newlyButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip7 = null;
        }
        chip7.setOnFocusChangeListener(this.focusListener);
        Chip chip8 = this.editButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
        } else {
            chip = chip8;
        }
        chip.setOnFocusChangeListener(this.focusListener);
    }
}
