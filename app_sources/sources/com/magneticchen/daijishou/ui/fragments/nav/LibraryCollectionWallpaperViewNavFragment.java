package com.magneticchen.daijishou.ui.fragments.nav;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentKt;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.imageview.ShapeableImageView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.StringPreference;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.data.live.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.data.portables.FavoriteItemsShareable;
import com.magneticchen.daijishou.data.portables.PlatformShareable;
import com.magneticchen.daijishou.ui.activities.MainActivity;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.ListSelectDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.PickPlatformSyncTreeUrDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.PlatformNavFragment;
import com.magneticchen.daijishou.ui.fragments.pager.parameters.LibraryPageSelectedParameters;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.model.LibraryViewModel;
import com.magneticchen.daijishou.ui.model.SynchronizationOfPlatform;
import com.magneticchen.daijishou.ui.views.PlatformCardLayout;
import com.magneticchen.daijishou.utils.PlaidColorUtils;
import com.magneticchen.daijishou.utils.Utils;
import com.skydoves.balloon.internals.DefinitionKt;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: compiled from: LibraryCollectionWallpaperViewNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 ²\u00012\u00020\u0001:\u0002²\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u008a\u0001\u001a\u00030\u008b\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0002J\t\u0010\u008e\u0001\u001a\u000200H\u0016J\u0016\u0010\u008f\u0001\u001a\u00030\u008b\u00012\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0016J-\u0010\u0092\u0001\u001a\u0004\u0018\u00010K2\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0016J%\u0010\u0097\u0001\u001a\u0002002\u0007\u0010\u0098\u0001\u001a\u00020\b2\u0007\u0010\u0099\u0001\u001a\u00020\b2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010\u009c\u0001\u001a\u00030\u008b\u0001H\u0016J\n\u0010\u009d\u0001\u001a\u00030\u008b\u0001H\u0016J\u001f\u0010\u009e\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u009f\u0001\u001a\u00020K2\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0016J\u0015\u0010 \u0001\u001a\u00030\u008b\u00012\t\u0010¡\u0001\u001a\u0004\u0018\u00010SH\u0002J\n\u0010¢\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010£\u0001\u001a\u00030\u008b\u0001H\u0003J.\u0010¤\u0001\u001a\u00030\u008b\u00012\u0007\u0010¥\u0001\u001a\u00020V2\u0007\u0010¦\u0001\u001a\u00020V2\u0007\u0010§\u0001\u001a\u00020V2\u0007\u0010¨\u0001\u001a\u00020VH\u0003J\n\u0010©\u0001\u001a\u00030\u008b\u0001H\u0002J\u0019\u0010ª\u0001\u001a\u00030\u008b\u00012\r\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020S0XH\u0002J\n\u0010¬\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u00ad\u0001\u001a\u00030\u008b\u0001H\u0002J\u0016\u0010®\u0001\u001a\u00030\u008b\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0002J,\u0010¯\u0001\u001a\u00030\u008b\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u00012\t\b\u0002\u0010°\u0001\u001a\u0002002\t\b\u0002\u0010±\u0001\u001a\u000200H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020!X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b=\u0010>R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bC\u0010DR\u000e\u0010F\u001a\u00020GX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020V0XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Y\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010ZR\u000e\u0010[\u001a\u00020KX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020_X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010i\u001a\u0010\u0012\f\u0012\n l*\u0004\u0018\u00010k0k0jX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020vX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010y\u001a\b\u0012\u0004\u0012\u00020z0RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R \u0010}\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0012\n\u0002\u0010Z\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\"\u0010\u0082\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0013\n\u0002\u0010Z\u001a\u0005\b\u0083\u0001\u0010\u007f\"\u0006\b\u0084\u0001\u0010\u0081\u0001R\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000¨\u0006³\u0001"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/LibraryCollectionWallpaperViewNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/PlatformNavFragment;", "()V", "addSyncTreesButton", "Lcom/google/android/material/chip/Chip;", "chipGroup", "Lcom/google/android/material/chip/ChipGroup;", "colorOnPrimary", "", "getColorOnPrimary", "()I", "setColorOnPrimary", "(I)V", "colorPrimary", "getColorPrimary", "setColorPrimary", "defaultChipBackgroundColors", "Landroid/content/res/ColorStateList;", "defaultChipTextColors", "defaultDownloadIconColors", "defaultMonoChipIconColors", "defaultWallpaperDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "description", "Landroid/widget/TextView;", "descriptionFirstString", "", "descriptionItemsCountFormatString", "descriptionPlatformIndexFormatString", "descriptionSecondString", "descriptionThirdString", "editButton", "fadeInAnimation", "Landroid/view/animation/Animation;", "fadeOutAnimation", "favoriteButton", "favoriteFormatString", "fullScreenGrad", "Lcom/google/android/material/imageview/ShapeableImageView;", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "imageViewAnimationIn", "getImageViewAnimationIn", "()Landroid/view/animation/Animation;", "setImageViewAnimationIn", "(Landroid/view/animation/Animation;)V", "imageViewAnimationOut", "isRefreshingAndUpdateWallpaper", "", "isRefreshingCurrentPlatform", "isRefreshingCurrentPlatformStatistic", "isRefreshingSyncStatus", "libraryChip", "libraryCollectionWallpaperViewLayoutManager", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouLinearLayoutManager;", "libraryCollectionWallpaperViewRecyclerView", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "libraryCollectionWallpaperViewRecyclerViewAdapter", "Lcom/magneticchen/daijishou/ui/fragments/nav/LibraryCollectionWallpaperViewRecyclerViewAdapter;", "libraryViewModel", "Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;", "getLibraryViewModel", "()Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;", "libraryViewModel$delegate", "Lkotlin/Lazy;", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "model$delegate", "navController", "Landroidx/navigation/NavController;", "newFormatString", "newlyAddedButton", "nextView", "Landroid/view/View;", "noItemString", "platformCardLayout", "Lcom/magneticchen/daijishou/ui/views/PlatformCardLayout;", "platformDownloadButton", "Lcom/google/android/material/button/MaterialButton;", "platformEntityList", "", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "platformFormatString", "platformId", "", "platformIdList", "", "previousSelectedPlatformIndex", "Ljava/lang/Integer;", "previousView", "progressBar", "Landroid/widget/ProgressBar;", "progressBarLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "progressStatus", "randomButton", "recentFormatString", "recentPlayedButton", "refocusOnScrolledToTop", "secondWallpaper", "selectedPlatformEntity", "selectedPlatformIndex", "shareButton", "shareFileActivity", "Landroidx/activity/result/ActivityResultLauncher;", "Ljava/io/File;", "kotlin.jvm.PlatformType", "sharePlatformConfigString", "sharePlatformFavoriteItemsString", "shareString", "shortAnimationDuration", "slideInLeftAnimation", "slideInRightAnimation", "slideOutLeftAnimation", "slideOutRightAnimation", "smoothScroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "syncButton", "syncString", "synchronizationOfPlatformList", "Lcom/magneticchen/daijishou/ui/model/SynchronizationOfPlatform;", "syncingFormatString", "syncingString", "themeBackgroundColor", "getThemeBackgroundColor", "()Ljava/lang/Integer;", "setThemeBackgroundColor", "(Ljava/lang/Integer;)V", "themeTextColor", "getThemeTextColor", "setThemeTextColor", "title", "Landroid/widget/TextSwitcher;", "titleFirst", "titleSecond", "wallpaper", "imageViewAnimatedChange", "", "bitmap", "Landroid/graphics/Bitmap;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onKioskMode", "onNoneKioskMode", "onViewCreated", "view", "refreshAndUpdateWallpaper", "platformEntity", "refreshChipGroupNavigation", "refreshCurrentPlatform", "refreshCurrentPlatformStatistic", "platformItemCount", "recentPlayedCount", "favoriteCount", "newlyAddedCount", "refreshSyncStatus", "setPlatformList", "newPlatformEntityList", "switchNext", "switchPrevious", "updateLightDarkDecorations", "updateWallpaper", "autoThemeColor", "onlyUpdateColor", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibraryCollectionWallpaperViewNavFragment extends PlatformNavFragment {
    public static final Companion Companion = new Companion(null);
    public static final int PLATFORM_LIBRARY_GRID_VIEW_MODE = 1;
    public static final int PLATFORM_LIBRARY_LIST_VIEW_MODE = 0;
    public static final float RECYCLER_VIEW_SCROLL_OFFSET = 32.0f;
    private static final Typeface typeface;
    private Chip addSyncTreesButton;
    private ChipGroup chipGroup;
    private ColorStateList defaultChipBackgroundColors;
    private ColorStateList defaultChipTextColors;
    private ColorStateList defaultDownloadIconColors;
    private ColorStateList defaultMonoChipIconColors;
    private BitmapDrawable defaultWallpaperDrawable;
    private TextView description;
    private String descriptionItemsCountFormatString;
    private String descriptionPlatformIndexFormatString;
    private Chip editButton;
    private Animation fadeInAnimation;
    private Animation fadeOutAnimation;
    private Chip favoriteButton;
    private String favoriteFormatString;
    private ShapeableImageView fullScreenGrad;
    private HorizontalScrollView horizontalScrollView;
    public Animation imageViewAnimationIn;
    private Animation imageViewAnimationOut;
    private boolean isRefreshingAndUpdateWallpaper;
    private boolean isRefreshingCurrentPlatform;
    private boolean isRefreshingCurrentPlatformStatistic;
    private boolean isRefreshingSyncStatus;
    private Chip libraryChip;
    private DaijishouLinearLayoutManager libraryCollectionWallpaperViewLayoutManager;
    private DaijishouRecyclerView libraryCollectionWallpaperViewRecyclerView;
    private LibraryCollectionWallpaperViewRecyclerViewAdapter libraryCollectionWallpaperViewRecyclerViewAdapter;
    private final Lazy libraryViewModel$delegate;
    private final Lazy model$delegate;
    private NavController navController;
    private String newFormatString;
    private Chip newlyAddedButton;
    private View nextView;
    private String noItemString;
    private PlatformCardLayout platformCardLayout;
    private MaterialButton platformDownloadButton;
    private final List<PlatformEntity> platformEntityList;
    private String platformFormatString;
    private Integer previousSelectedPlatformIndex;
    private View previousView;
    private ProgressBar progressBar;
    private ConstraintLayout progressBarLayout;
    private TextView progressStatus;
    private Chip randomButton;
    private String recentFormatString;
    private Chip recentPlayedButton;
    private boolean refocusOnScrolledToTop;
    private ShapeableImageView secondWallpaper;
    private PlatformEntity selectedPlatformEntity;
    private Chip shareButton;
    private final ActivityResultLauncher<File> shareFileActivity;
    private String sharePlatformConfigString;
    private String sharePlatformFavoriteItemsString;
    private String shareString;
    private Animation slideInLeftAnimation;
    private Animation slideInRightAnimation;
    private Animation slideOutLeftAnimation;
    private Animation slideOutRightAnimation;
    private RecyclerView.SmoothScroller smoothScroller;
    private Chip syncButton;
    private String syncString;
    private List<SynchronizationOfPlatform> synchronizationOfPlatformList;
    private String syncingFormatString;
    private String syncingString;
    private Integer themeBackgroundColor;
    private Integer themeTextColor;
    private TextSwitcher title;
    private TextView titleFirst;
    private TextView titleSecond;
    private ShapeableImageView wallpaper;
    private String descriptionFirstString = "🕹 ";
    private String descriptionSecondString = "0 items • ";
    private String descriptionThirdString = "platform 0 of 0";
    private long shortAnimationDuration = -1;
    private int colorPrimary = -1;
    private int colorOnPrimary = -1;
    private List<Long> platformIdList = CollectionsKt.emptyList();
    private long platformId = -1;
    private int selectedPlatformIndex = -1;

    public LibraryCollectionWallpaperViewNavFragment() {
        final LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment = this;
        final Function0 function0 = null;
        this.libraryViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(libraryCollectionWallpaperViewNavFragment, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return libraryCollectionWallpaperViewNavFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? libraryCollectionWallpaperViewNavFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return libraryCollectionWallpaperViewNavFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.model$delegate = FragmentViewModelLazyKt.createViewModelLazy(libraryCollectionWallpaperViewNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$special$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return libraryCollectionWallpaperViewNavFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? libraryCollectionWallpaperViewNavFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$special$$inlined$activityViewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return libraryCollectionWallpaperViewNavFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        ActivityResultLauncher<File> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ShareFileContract(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda14
            public final void onActivityResult(Object obj) {
                ((File) obj).delete();
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.shareFileActivity = activityResultLauncherRegisterForActivityResult;
        this.platformEntityList = new ArrayList();
        this.synchronizationOfPlatformList = new ArrayList();
    }

    /* JADX INFO: compiled from: LibraryCollectionWallpaperViewNavFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/LibraryCollectionWallpaperViewNavFragment$Companion;", "", "()V", "PLATFORM_LIBRARY_GRID_VIEW_MODE", "", "PLATFORM_LIBRARY_LIST_VIEW_MODE", "RECYCLER_VIEW_SCROLL_OFFSET", "", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/nav/LibraryCollectionWallpaperViewNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LibraryCollectionWallpaperViewNavFragment newInstance() {
            return new LibraryCollectionWallpaperViewNavFragment();
        }
    }

    static {
        typeface = Build.VERSION.SDK_INT >= 28 ? Typeface.create(null, Constants.semiBolderWeight, false) : Typeface.defaultFromStyle(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LibraryViewModel getLibraryViewModel() {
        return (LibraryViewModel) this.libraryViewModel$delegate.getValue();
    }

    private final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model$delegate.getValue();
    }

    public final Animation getImageViewAnimationIn() {
        Animation animation = this.imageViewAnimationIn;
        if (animation != null) {
            return animation;
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageViewAnimationIn");
        return null;
    }

    public final void setImageViewAnimationIn(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "<set-?>");
        this.imageViewAnimationIn = animation;
    }

    public final Integer getThemeTextColor() {
        return this.themeTextColor;
    }

    public final void setThemeTextColor(Integer num) {
        this.themeTextColor = num;
    }

    public final Integer getThemeBackgroundColor() {
        return this.themeBackgroundColor;
    }

    public final void setThemeBackgroundColor(Integer num) {
        this.themeBackgroundColor = num;
    }

    public final int getColorPrimary() {
        return this.colorPrimary;
    }

    public final void setColorPrimary(int i) {
        this.colorPrimary = i;
    }

    public final int getColorOnPrimary() {
        return this.colorOnPrimary;
    }

    public final void setColorOnPrimary(int i) {
        this.colorOnPrimary = i;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onKioskMode() {
        super.onKioskMode();
        Chip chip = this.editButton;
        MaterialButton materialButton = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip = null;
        }
        chip.setVisibility(8);
        MaterialButton materialButton2 = this.platformDownloadButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformDownloadButton");
            materialButton2 = null;
        }
        materialButton2.setVisibility(8);
        Chip chip2 = this.editButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip2 = null;
        }
        chip2.invalidate();
        MaterialButton materialButton3 = this.platformDownloadButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformDownloadButton");
        } else {
            materialButton = materialButton3;
        }
        materialButton.invalidate();
        refreshChipGroupNavigation();
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onNoneKioskMode() {
        super.onNoneKioskMode();
        Chip chip = this.editButton;
        MaterialButton materialButton = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip = null;
        }
        chip.setVisibility(0);
        MaterialButton materialButton2 = this.platformDownloadButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformDownloadButton");
        } else {
            materialButton = materialButton2;
        }
        materialButton.setVisibility(0);
        refreshChipGroupNavigation();
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public boolean onHotKeyPressed(int i, int i2, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(i, i2, keyEvent);
        if (i == 1) {
            switchNext();
            return true;
        }
        if (i == 2) {
            switchPrevious();
            return true;
        }
        if (i == 3) {
            PlayableItemEntity playableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default = DaijishouLibraryModel.getPlayableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default(getDaijishouLibrary(), getLibraryViewModel().getSelectedPlatformId(), false, 2, null);
            if (playableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default == null) {
                return false;
            }
            PlayableItemDetailDialogFragment.Companion.newInstance(playableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default).show(getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
            return true;
        }
        if (i != 4) {
            return false;
        }
        int i3 = getLibraryViewModel().getPreferences().getInt("view_mode", 0);
        NavController navController = null;
        if (i3 == 0) {
            NavController navController2 = this.navController;
            if (navController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
            } else {
                navController = navController2;
            }
            navController.navigate(R.id.libraryCollectionWallpaperViewToPlatformLibraryListViewAction);
        } else if (i3 == 1) {
            NavController navController3 = this.navController;
            if (navController3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
            } else {
                navController = navController3;
            }
            navController.navigate(R.id.libraryCollectionWallpaperViewToPlatformLibraryGridViewAction);
        }
        return true;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public boolean onBackPressed() {
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        HorizontalScrollView horizontalScrollView2 = null;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
            horizontalScrollView = null;
        }
        if (horizontalScrollView.getScrollX() == 0) {
            return super.onBackPressed();
        }
        this.refocusOnScrolledToTop = true;
        HorizontalScrollView horizontalScrollView3 = this.horizontalScrollView;
        if (horizontalScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
        } else {
            horizontalScrollView2 = horizontalScrollView3;
        }
        horizontalScrollView2.smoothScrollTo(0, 0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void switchPrevious() {
        LibraryCollectionWallpaperViewRecyclerViewAdapter libraryCollectionWallpaperViewRecyclerViewAdapter = this.libraryCollectionWallpaperViewRecyclerViewAdapter;
        Chip chip = null;
        if (libraryCollectionWallpaperViewRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerViewAdapter");
            libraryCollectionWallpaperViewRecyclerViewAdapter = null;
        }
        if (libraryCollectionWallpaperViewRecyclerViewAdapter.getItemCount() <= 0) {
            return;
        }
        int itemCount = this.selectedPlatformIndex;
        if (itemCount == 0) {
            LibraryCollectionWallpaperViewRecyclerViewAdapter libraryCollectionWallpaperViewRecyclerViewAdapter2 = this.libraryCollectionWallpaperViewRecyclerViewAdapter;
            if (libraryCollectionWallpaperViewRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerViewAdapter");
                libraryCollectionWallpaperViewRecyclerViewAdapter2 = null;
            }
            itemCount = libraryCollectionWallpaperViewRecyclerViewAdapter2.getItemCount();
        }
        int i = itemCount - 1;
        LibraryCollectionWallpaperViewRecyclerViewAdapter libraryCollectionWallpaperViewRecyclerViewAdapter3 = this.libraryCollectionWallpaperViewRecyclerViewAdapter;
        if (libraryCollectionWallpaperViewRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerViewAdapter");
            libraryCollectionWallpaperViewRecyclerViewAdapter3 = null;
        }
        libraryCollectionWallpaperViewRecyclerViewAdapter3.selectPosition(i);
        DaijishouLinearLayoutManager daijishouLinearLayoutManager = this.libraryCollectionWallpaperViewLayoutManager;
        if (daijishouLinearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewLayoutManager");
            daijishouLinearLayoutManager = null;
        }
        if (!daijishouLinearLayoutManager.isSmoothScrolling()) {
            DaijishouLinearLayoutManager daijishouLinearLayoutManager2 = this.libraryCollectionWallpaperViewLayoutManager;
            if (daijishouLinearLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewLayoutManager");
                daijishouLinearLayoutManager2 = null;
            }
            daijishouLinearLayoutManager2.scrollToPositionWithOffset(Math.max(0, i), getDpToPxConverter().convert(32.0f));
        }
        Chip chip2 = this.libraryChip;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
            chip2 = null;
        }
        chip2.clearFocus();
        Chip chip3 = this.libraryChip;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
        } else {
            chip = chip3;
        }
        chip.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void switchNext() {
        LibraryCollectionWallpaperViewRecyclerViewAdapter libraryCollectionWallpaperViewRecyclerViewAdapter = this.libraryCollectionWallpaperViewRecyclerViewAdapter;
        Chip chip = null;
        if (libraryCollectionWallpaperViewRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerViewAdapter");
            libraryCollectionWallpaperViewRecyclerViewAdapter = null;
        }
        if (libraryCollectionWallpaperViewRecyclerViewAdapter.getItemCount() <= 0) {
            return;
        }
        int i = this.selectedPlatformIndex + 1;
        LibraryCollectionWallpaperViewRecyclerViewAdapter libraryCollectionWallpaperViewRecyclerViewAdapter2 = this.libraryCollectionWallpaperViewRecyclerViewAdapter;
        if (libraryCollectionWallpaperViewRecyclerViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerViewAdapter");
            libraryCollectionWallpaperViewRecyclerViewAdapter2 = null;
        }
        int itemCount = i % libraryCollectionWallpaperViewRecyclerViewAdapter2.getItemCount();
        LibraryCollectionWallpaperViewRecyclerViewAdapter libraryCollectionWallpaperViewRecyclerViewAdapter3 = this.libraryCollectionWallpaperViewRecyclerViewAdapter;
        if (libraryCollectionWallpaperViewRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerViewAdapter");
            libraryCollectionWallpaperViewRecyclerViewAdapter3 = null;
        }
        libraryCollectionWallpaperViewRecyclerViewAdapter3.selectPosition(itemCount);
        DaijishouLinearLayoutManager daijishouLinearLayoutManager = this.libraryCollectionWallpaperViewLayoutManager;
        if (daijishouLinearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewLayoutManager");
            daijishouLinearLayoutManager = null;
        }
        if (!daijishouLinearLayoutManager.isSmoothScrolling()) {
            DaijishouLinearLayoutManager daijishouLinearLayoutManager2 = this.libraryCollectionWallpaperViewLayoutManager;
            if (daijishouLinearLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewLayoutManager");
                daijishouLinearLayoutManager2 = null;
            }
            daijishouLinearLayoutManager2.scrollToPositionWithOffset(Math.max(0, itemCount), getDpToPxConverter().convert(32.0f));
        }
        Chip chip2 = this.libraryChip;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
            chip2 = null;
        }
        chip2.clearFocus();
        Chip chip3 = this.libraryChip;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
        } else {
            chip = chip3;
        }
        chip.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshAndUpdateWallpaper(PlatformEntity platformEntity) {
        LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment;
        if (this.isRefreshingAndUpdateWallpaper) {
            return;
        }
        this.isRefreshingAndUpdateWallpaper = true;
        ShapeableImageView shapeableImageView = null;
        String wallpaperPath = platformEntity != null ? platformEntity.getWallpaperPath() : null;
        if (wallpaperPath == null) {
            libraryCollectionWallpaperViewNavFragment = this;
            updateWallpaper$default(libraryCollectionWallpaperViewNavFragment, null, getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_AUTO_THEME_COLOR.getKey(), BooleanPreference.USE_AUTO_THEME_COLOR.getDefaultValue()), false, 4, null);
        } else {
            libraryCollectionWallpaperViewNavFragment = this;
            CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTaskLoad$default = CachedBitmapLoader.CachedBitmapLoaderTask.load$default(getDaijishouLibrary().getCachedPlatformWallpaperBitmapLoader().with(libraryCollectionWallpaperViewNavFragment).setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.refreshAndUpdateWallpaper.1
                

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                    invoke(bitmap, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Bitmap bitmap, boolean z) {
                    Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                    LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment2 = LibraryCollectionWallpaperViewNavFragment.this;
                    LibraryCollectionWallpaperViewNavFragment.updateWallpaper$default(libraryCollectionWallpaperViewNavFragment2, bitmap, libraryCollectionWallpaperViewNavFragment2.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_AUTO_THEME_COLOR.getKey(), BooleanPreference.USE_AUTO_THEME_COLOR.getDefaultValue()), false, 4, null);
                }
            }).setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.refreshAndUpdateWallpaper.2
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                    invoke2(exc);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Exception e) {
                    Intrinsics.checkNotNullParameter(e, "e");
                    LibraryCollectionWallpaperViewNavFragment.this.getLogger().warn(LibraryCollectionWallpaperViewNavFragment.this, ExceptionsKt.stackTraceToString(e));
                }
            }), wallpaperPath, false, 2, null);
            ShapeableImageView shapeableImageView2 = libraryCollectionWallpaperViewNavFragment.wallpaper;
            if (shapeableImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
            } else {
                shapeableImageView = shapeableImageView2;
            }
            cachedBitmapLoaderTaskLoad$default.into((View) shapeableImageView);
        }
        libraryCollectionWallpaperViewNavFragment.isRefreshingAndUpdateWallpaper = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:65:0x0169  */
    /* JADX WARN: Code duplicated, block: B:67:0x016d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0178  */
    public final void refreshCurrentPlatform() {
        TextSwitcher textSwitcher;
        TextSwitcher textSwitcher2;
        if (this.isRefreshingCurrentPlatform) {
            return;
        }
        this.isRefreshingCurrentPlatform = true;
        this.selectedPlatformIndex = this.platformIdList.indexOf(Long.valueOf(this.platformId));
        getLogger().debug(this, "selectedPlatformIndex: " + this.selectedPlatformIndex + ", platformId: " + this.platformId + ", platformIdList: " + this.platformIdList + ", ");
        int i = this.selectedPlatformIndex;
        if (i != -1) {
            PlatformEntity platformEntity = this.platformEntityList.get(i);
            this.selectedPlatformEntity = platformEntity;
            if (platformEntity != null) {
                LibraryCollectionWallpaperViewRecyclerViewAdapter libraryCollectionWallpaperViewRecyclerViewAdapter = this.libraryCollectionWallpaperViewRecyclerViewAdapter;
                TextView textView = null;
                if (libraryCollectionWallpaperViewRecyclerViewAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerViewAdapter");
                    libraryCollectionWallpaperViewRecyclerViewAdapter = null;
                }
                libraryCollectionWallpaperViewRecyclerViewAdapter.selectPosition(this.selectedPlatformIndex);
                RecyclerView.SmoothScroller smoothScroller = this.smoothScroller;
                if (smoothScroller == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("smoothScroller");
                    smoothScroller = null;
                }
                smoothScroller.setTargetPosition(Math.max(0, this.selectedPlatformIndex - 1));
                DaijishouLinearLayoutManager daijishouLinearLayoutManager = this.libraryCollectionWallpaperViewLayoutManager;
                if (daijishouLinearLayoutManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewLayoutManager");
                    daijishouLinearLayoutManager = null;
                }
                if (!daijishouLinearLayoutManager.isSmoothScrolling()) {
                    DaijishouLinearLayoutManager daijishouLinearLayoutManager2 = this.libraryCollectionWallpaperViewLayoutManager;
                    if (daijishouLinearLayoutManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewLayoutManager");
                        daijishouLinearLayoutManager2 = null;
                    }
                    daijishouLinearLayoutManager2.scrollToPositionWithOffset(Math.max(0, this.selectedPlatformIndex), getDpToPxConverter().convert(32.0f));
                }
                DaijishouViewModel model = getModel();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = this.platformFormatString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformFormatString");
                    str = null;
                }
                String shortname = platformEntity.getShortname();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String upperCase = shortname.toUpperCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                String str2 = String.format(str, Arrays.copyOf(new Object[]{upperCase}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                DaijishouViewModel.setTips$default(model, str2, false, 2, null);
                Integer num = this.previousSelectedPlatformIndex;
                if (num != null) {
                    int i2 = this.selectedPlatformIndex;
                    if (num != null && num.intValue() == i2) {
                        textSwitcher = this.title;
                        if (textSwitcher == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("title");
                            textSwitcher = null;
                        }
                        textSwitcher.setInAnimation(null);
                        textSwitcher2 = this.title;
                        if (textSwitcher2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("title");
                            textSwitcher2 = null;
                        }
                        textSwitcher2.setOutAnimation(null);
                    } else {
                        Integer num2 = this.previousSelectedPlatformIndex;
                        Intrinsics.checkNotNull(num2);
                        if (num2.intValue() < this.selectedPlatformIndex) {
                            TextSwitcher textSwitcher3 = this.title;
                            if (textSwitcher3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("title");
                                textSwitcher3 = null;
                            }
                            Animation animation = this.slideInRightAnimation;
                            if (animation == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("slideInRightAnimation");
                                animation = null;
                            }
                            textSwitcher3.setInAnimation(animation);
                            TextSwitcher textSwitcher4 = this.title;
                            if (textSwitcher4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("title");
                                textSwitcher4 = null;
                            }
                            Animation animation2 = this.slideOutLeftAnimation;
                            if (animation2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("slideOutLeftAnimation");
                                animation2 = null;
                            }
                            textSwitcher4.setOutAnimation(animation2);
                        } else {
                            Integer num3 = this.previousSelectedPlatformIndex;
                            Intrinsics.checkNotNull(num3);
                            if (num3.intValue() > this.selectedPlatformIndex) {
                                TextSwitcher textSwitcher5 = this.title;
                                if (textSwitcher5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("title");
                                    textSwitcher5 = null;
                                }
                                Animation animation3 = this.slideInLeftAnimation;
                                if (animation3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("slideInLeftAnimation");
                                    animation3 = null;
                                }
                                textSwitcher5.setInAnimation(animation3);
                                TextSwitcher textSwitcher6 = this.title;
                                if (textSwitcher6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("title");
                                    textSwitcher6 = null;
                                }
                                Animation animation4 = this.slideOutRightAnimation;
                                if (animation4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("slideOutRightAnimation");
                                    animation4 = null;
                                }
                                textSwitcher6.setOutAnimation(animation4);
                            }
                        }
                    }
                } else {
                    textSwitcher = this.title;
                    if (textSwitcher == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("title");
                        textSwitcher = null;
                    }
                    textSwitcher.setInAnimation(null);
                    textSwitcher2 = this.title;
                    if (textSwitcher2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("title");
                        textSwitcher2 = null;
                    }
                    textSwitcher2.setOutAnimation(null);
                }
                TextSwitcher textSwitcher7 = this.title;
                if (textSwitcher7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                    textSwitcher7 = null;
                }
                textSwitcher7.setText(platformEntity.getName());
                TextSwitcher textSwitcher8 = this.title;
                if (textSwitcher8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                    textSwitcher8 = null;
                }
                textSwitcher8.requestLayout();
                this.previousSelectedPlatformIndex = Integer.valueOf(this.selectedPlatformIndex);
                if (getDefaultSharedPreferences().getBoolean(BooleanPreference.DISPLAY_SHORTNAME_IN_PLATFORMS_PAGE_SUBTITLE.getKey(), BooleanPreference.DISPLAY_SHORTNAME_IN_PLATFORMS_PAGE_SUBTITLE.getDefaultValue())) {
                    String shortname2 = platformEntity.getShortname();
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    String upperCase2 = shortname2.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                    this.descriptionFirstString = "🕹 ️" + upperCase2 + " • ";
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str3 = this.descriptionPlatformIndexFormatString;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descriptionPlatformIndexFormatString");
                    str3 = null;
                }
                String str4 = String.format(str3, Arrays.copyOf(new Object[]{Integer.valueOf(this.selectedPlatformIndex + 1), Integer.valueOf(this.platformEntityList.size())}, 2));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                this.descriptionThirdString = str4;
                TextView textView2 = this.description;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("description");
                } else {
                    textView = textView2;
                }
                textView.setText(this.descriptionFirstString + this.descriptionSecondString + this.descriptionThirdString);
                refreshAndUpdateWallpaper(platformEntity);
            }
        }
        this.isRefreshingCurrentPlatform = false;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0076  */
    /* JADX WARN: Code duplicated, block: B:26:0x007a  */
    private final void refreshChipGroupNavigation() {
        Chip chip;
        ArrayList arrayList = new ArrayList();
        ChipGroup chipGroup = this.chipGroup;
        ChipGroup chipGroup2 = null;
        if (chipGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            chipGroup = null;
        }
        for (View view : ViewGroupKt.getChildren((ViewGroup) chipGroup)) {
            if (view.getVisibility() == 0) {
                arrayList.add(view);
            }
        }
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view2 = (View) obj;
            if (i == 0) {
                if (isKioskMode()) {
                    ArrayList arrayList2 = arrayList;
                    if (arrayList2.size() > 1) {
                        view2.setNextFocusLeftId(((View) arrayList.get(arrayList2.size() - 2)).getId());
                    } else {
                        chip = this.editButton;
                        if (chip == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("editButton");
                            chip = null;
                        }
                        view2.setNextFocusLeftId(chip.getId());
                    }
                } else {
                    chip = this.editButton;
                    if (chip == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("editButton");
                        chip = null;
                    }
                    view2.setNextFocusLeftId(chip.getId());
                }
            } else {
                Chip chip2 = this.libraryChip;
                if (chip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
                    chip2 = null;
                }
                if (!Intrinsics.areEqual(view2, chip2)) {
                    Chip chip3 = this.randomButton;
                    if (chip3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("randomButton");
                        chip3 = null;
                    }
                    if (!Intrinsics.areEqual(view2, chip3)) {
                        if (i != arrayList.size() - 2) {
                            view2.setNextFocusRightId(-1);
                        } else if (isKioskMode()) {
                            Chip chip4 = this.libraryChip;
                            if (chip4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
                                chip4 = null;
                            }
                            view2.setNextFocusRightId(chip4.getId());
                        } else {
                            Chip chip5 = this.editButton;
                            if (chip5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("editButton");
                                chip5 = null;
                            }
                            view2.setNextFocusRightId(chip5.getId());
                        }
                    }
                }
            }
            i = i2;
        }
        ChipGroup chipGroup3 = this.chipGroup;
        if (chipGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            chipGroup3 = null;
        }
        Iterator it = ViewGroupKt.getChildren((ViewGroup) chipGroup3).iterator();
        while (it.hasNext()) {
            ((View) it.next()).requestLayout();
        }
        ChipGroup chipGroup4 = this.chipGroup;
        if (chipGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
        } else {
            chipGroup2 = chipGroup4;
        }
        chipGroup2.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshCurrentPlatformStatistic(long j, long j2, long j3, long j4) {
        if (this.isRefreshingCurrentPlatformStatistic) {
            return;
        }
        this.isRefreshingCurrentPlatformStatistic = true;
        Chip chip = this.recentPlayedButton;
        TextView textView = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = this.recentFormatString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentFormatString");
            str = null;
        }
        String str2 = String.format(str, Arrays.copyOf(new Object[]{Long.valueOf(j2)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        chip.setText(str2);
        Chip chip2 = this.recentPlayedButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip2 = null;
        }
        chip2.setFocusable(0);
        Chip chip3 = this.recentPlayedButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip3 = null;
        }
        chip3.setVisibility(j2 > 0 ? 0 : 8);
        Chip chip4 = this.recentPlayedButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip4 = null;
        }
        chip4.setFocusable(1);
        Chip chip5 = this.favoriteButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip5 = null;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str3 = this.favoriteFormatString;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteFormatString");
            str3 = null;
        }
        String str4 = String.format(str3, Arrays.copyOf(new Object[]{Long.valueOf(j3)}, 1));
        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
        chip5.setText(str4);
        Chip chip6 = this.favoriteButton;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip6 = null;
        }
        chip6.setFocusable(0);
        Chip chip7 = this.favoriteButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip7 = null;
        }
        chip7.setVisibility(j3 > 0 ? 0 : 8);
        Chip chip8 = this.favoriteButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip8 = null;
        }
        chip8.setFocusable(1);
        Chip chip9 = this.newlyAddedButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip9 = null;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String str5 = this.newFormatString;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newFormatString");
            str5 = null;
        }
        String str6 = String.format(str5, Arrays.copyOf(new Object[]{Long.valueOf(j4)}, 1));
        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
        chip9.setText(str6);
        Chip chip10 = this.newlyAddedButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip10 = null;
        }
        chip10.setFocusable(0);
        Chip chip11 = this.newlyAddedButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip11 = null;
        }
        chip11.setVisibility(j4 > 0 ? 0 : 8);
        Chip chip12 = this.newlyAddedButton;
        if (chip12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip12 = null;
        }
        chip12.setFocusable(1);
        refreshChipGroupNavigation();
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
        String str7 = this.descriptionItemsCountFormatString;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionItemsCountFormatString");
            str7 = null;
        }
        String str8 = String.format(str7, Arrays.copyOf(new Object[]{Long.valueOf(j)}, 1));
        Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
        this.descriptionSecondString = str8;
        TextView textView2 = this.description;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("description");
        } else {
            textView = textView2;
        }
        textView.setText(this.descriptionFirstString + this.descriptionSecondString + this.descriptionThirdString);
        this.isRefreshingCurrentPlatformStatistic = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshSyncStatus() {
        String str;
        String str2;
        if (this.isRefreshingSyncStatus) {
            return;
        }
        this.isRefreshingSyncStatus = true;
        List<SynchronizationOfPlatform> list = this.synchronizationOfPlatformList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((SynchronizationOfPlatform) obj).getPlatformId() == this.platformId) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        View view = null;
        try {
            if (arrayList2.isEmpty()) {
                str = "";
            } else {
                String statusString = ((SynchronizationOfPlatform) arrayList2.get(0)).getStatusString();
                int length = 40;
                if (((SynchronizationOfPlatform) arrayList2.get(0)).getStatusString().length() <= 40) {
                    length = ((SynchronizationOfPlatform) arrayList2.get(0)).getStatusString().length();
                }
                String strSubstring = statusString.substring(0, length);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                str = strSubstring + "...";
            }
            TextView textView = this.progressStatus;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressStatus");
                textView = null;
            }
            if (arrayList2.isEmpty()) {
                str2 = this.syncingString;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncingString");
                    str2 = null;
                }
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str3 = this.syncingFormatString;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncingFormatString");
                    str3 = null;
                }
                str2 = String.format(str3, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            }
            textView.setText(str2);
        } catch (Exception e) {
            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
        }
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        ArrayList arrayList3 = arrayList2;
        progressBar.setIndeterminate(true ^ arrayList3.isEmpty());
        View view2 = this.progressBarLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBarLayout");
        } else {
            view = view2;
        }
        view.setVisibility(!arrayList3.isEmpty() ? 0 : 8);
        this.isRefreshingSyncStatus = false;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Context contextRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(contextRequireActivity, "requireActivity(...)");
        String string = getString(R.string.no_items);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.noItemString = string;
        String string2 = getString(R.string.sync);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.syncString = string2;
        String string3 = getString(R.string.syncing);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.syncingString = string3;
        String string4 = getString(R.string.syncing_format);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this.syncingFormatString = string4;
        String string5 = getString(R.string.description_items_count_format);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.descriptionItemsCountFormatString = string5;
        String string6 = getString(R.string.description_platform_index_format);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        this.descriptionPlatformIndexFormatString = string6;
        String string7 = getString(R.string.share);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        this.shareString = string7;
        String string8 = getString(R.string.share_platform_config_string);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        this.sharePlatformConfigString = string8;
        String string9 = getString(R.string.share_platform_favorite_items_string);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        this.sharePlatformFavoriteItemsString = string9;
        String string10 = getString(R.string.platform_format);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        this.platformFormatString = string10;
        String string11 = getString(R.string.favorite_format);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        this.favoriteFormatString = string11;
        String string12 = getString(R.string.recent_format);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        this.recentFormatString = string12;
        String string13 = getString(R.string.new_format);
        Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
        this.newFormatString = string13;
        this.shortAnimationDuration = getResources().getInteger(android.R.integer.config_shortAnimTime);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(contextRequireContext, android.R.anim.fade_in);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation, "loadAnimation(...)");
        this.fadeInAnimation = animationLoadAnimation;
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(contextRequireContext, android.R.anim.fade_out);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation2, "loadAnimation(...)");
        this.fadeOutAnimation = animationLoadAnimation2;
        Animation animation = this.fadeInAnimation;
        Animation animation2 = null;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fadeInAnimation");
            animation = null;
        }
        animation.setDuration(this.shortAnimationDuration);
        Animation animation3 = this.fadeOutAnimation;
        if (animation3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fadeOutAnimation");
            animation3 = null;
        }
        animation3.setDuration(this.shortAnimationDuration);
        Animation animationLoadAnimation3 = AnimationUtils.loadAnimation(contextRequireContext, R.anim.slide_in_right);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation3, "loadAnimation(...)");
        this.slideInRightAnimation = animationLoadAnimation3;
        Animation animationLoadAnimation4 = AnimationUtils.loadAnimation(contextRequireContext, R.anim.slide_out_left);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation4, "loadAnimation(...)");
        this.slideOutLeftAnimation = animationLoadAnimation4;
        Animation animation4 = this.slideInRightAnimation;
        if (animation4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slideInRightAnimation");
            animation4 = null;
        }
        animation4.setDuration(this.shortAnimationDuration);
        Animation animation5 = this.slideOutLeftAnimation;
        if (animation5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slideOutLeftAnimation");
            animation5 = null;
        }
        animation5.setDuration(this.shortAnimationDuration);
        Animation animationLoadAnimation5 = AnimationUtils.loadAnimation(contextRequireContext, android.R.anim.slide_in_left);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation5, "loadAnimation(...)");
        this.slideInLeftAnimation = animationLoadAnimation5;
        Animation animationLoadAnimation6 = AnimationUtils.loadAnimation(contextRequireContext, android.R.anim.slide_out_right);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation6, "loadAnimation(...)");
        this.slideOutRightAnimation = animationLoadAnimation6;
        Animation animation6 = this.slideInLeftAnimation;
        if (animation6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slideInLeftAnimation");
            animation6 = null;
        }
        animation6.setDuration(this.shortAnimationDuration);
        Animation animation7 = this.slideOutRightAnimation;
        if (animation7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slideOutRightAnimation");
            animation7 = null;
        }
        animation7.setDuration(this.shortAnimationDuration);
        Drawable drawable = ContextCompat.getDrawable(contextRequireActivity, R.drawable.ic_polka_dots);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), drawable != null ? DrawableKt.toBitmap$default(drawable, 0, 0, (Bitmap.Config) null, 7, (Object) null) : null);
        this.defaultWallpaperDrawable = bitmapDrawable;
        bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
        BitmapDrawable bitmapDrawable2 = this.defaultWallpaperDrawable;
        if (bitmapDrawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultWallpaperDrawable");
            bitmapDrawable2 = null;
        }
        bitmapDrawable2.setTileModeY(Shader.TileMode.REPEAT);
        ColorStateList colorStateList = ContextCompat.getColorStateList(contextRequireContext, R.color.chip_normal_text_color);
        Intrinsics.checkNotNull(colorStateList);
        this.defaultChipTextColors = colorStateList;
        ColorStateList colorStateList2 = ContextCompat.getColorStateList(contextRequireContext, R.color.chip_normal_background_color);
        Intrinsics.checkNotNull(colorStateList2);
        this.defaultChipBackgroundColors = colorStateList2;
        ColorStateList colorStateList3 = ContextCompat.getColorStateList(contextRequireContext, R.color.chip_mono_icon_color);
        Intrinsics.checkNotNull(colorStateList3);
        this.defaultMonoChipIconColors = colorStateList3;
        ColorStateList colorStateList4 = ContextCompat.getColorStateList(contextRequireContext, R.color.download_icon_color);
        Intrinsics.checkNotNull(colorStateList4);
        this.defaultDownloadIconColors = colorStateList4;
        this.smoothScroller = new LinearSmoothScroller(contextRequireContext) { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreate.1
            protected int getHorizontalSnapPreference() {
                return -1;
            }
        };
        Animation animationLoadAnimation7 = AnimationUtils.loadAnimation(contextRequireContext, android.R.anim.fade_out);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation7, "loadAnimation(...)");
        this.imageViewAnimationOut = animationLoadAnimation7;
        if (animationLoadAnimation7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageViewAnimationOut");
        } else {
            animation2 = animationLoadAnimation7;
        }
        animation2.setDuration(60L);
        Animation animationLoadAnimation8 = AnimationUtils.loadAnimation(contextRequireContext, android.R.anim.fade_in);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation8, "loadAnimation(...)");
        setImageViewAnimationIn(animationLoadAnimation8);
        getImageViewAnimationIn().setDuration(60L);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        NavController navController;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        AppCompatActivity appCompatActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(appCompatActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        final AppCompatActivity appCompatActivity = appCompatActivityRequireActivity;
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final SharedPreferences preferences = getLibraryViewModel().getPreferences();
        LiveData<List<PlatformEntity>> allVisiblePlatformsOrderedByShortName = getDaijishouLibrary().getAllVisiblePlatformsOrderedByShortName();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = getDefaultSharedPreferences().getBoolean(BooleanPreference.ENFORCE_PLATFORM_CARD_ASPECT_RATIO.getKey(), BooleanPreference.ENFORCE_PLATFORM_CARD_ASPECT_RATIO.getDefaultValue());
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_AUTO_THEME_COLOR.getKey(), BooleanPreference.USE_AUTO_THEME_COLOR.getDefaultValue());
        View viewInflate = inflater.inflate(R.layout.fragment_library_collection_wallpaper_view, viewGroup, false);
        Object objFindViewById = viewInflate.findViewById(R.id.library_collection_wallpaper_view_recycler_view);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        this.libraryCollectionWallpaperViewRecyclerView = (DaijishouRecyclerView) objFindViewById;
        this.libraryCollectionWallpaperViewRecyclerViewAdapter = new LibraryCollectionWallpaperViewRecyclerViewAdapter(contextRequireContext, this.platformEntityList);
        this.libraryCollectionWallpaperViewLayoutManager = new DaijishouLinearLayoutManager(contextRequireContext, 0, false);
        ShapeableImageView shapeableImageViewFindViewById = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_wallpaper);
        Intrinsics.checkNotNullExpressionValue(shapeableImageViewFindViewById, "findViewById(...)");
        this.wallpaper = shapeableImageViewFindViewById;
        ShapeableImageView shapeableImageViewFindViewById2 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_second_wallpaper);
        Intrinsics.checkNotNullExpressionValue(shapeableImageViewFindViewById2, "findViewById(...)");
        this.secondWallpaper = shapeableImageViewFindViewById2;
        ShapeableImageView shapeableImageView = this.wallpaper;
        if (shapeableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
            shapeableImageView = null;
        }
        BitmapDrawable bitmapDrawable = this.defaultWallpaperDrawable;
        if (bitmapDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultWallpaperDrawable");
            bitmapDrawable = null;
        }
        shapeableImageView.setBackground(bitmapDrawable);
        ShapeableImageView shapeableImageView2 = this.secondWallpaper;
        if (shapeableImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondWallpaper");
            shapeableImageView2 = null;
        }
        BitmapDrawable bitmapDrawable2 = this.defaultWallpaperDrawable;
        if (bitmapDrawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultWallpaperDrawable");
            bitmapDrawable2 = null;
        }
        shapeableImageView2.setBackground(bitmapDrawable2);
        ShapeableImageView shapeableImageViewFindViewById3 = viewInflate.findViewById(R.id.fullscreen_grad);
        Intrinsics.checkNotNullExpressionValue(shapeableImageViewFindViewById3, "findViewById(...)");
        this.fullScreenGrad = shapeableImageViewFindViewById3;
        View viewFindViewById = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.title = (TextSwitcher) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_title_first_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.titleFirst = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_title_second_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.titleSecond = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_description_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.description = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.progressBar = (ProgressBar) viewFindViewById5;
        ConstraintLayout constraintLayoutFindViewById = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_progress_bar_constraint_layout);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        this.progressBarLayout = constraintLayoutFindViewById;
        View viewFindViewById6 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_progress_status);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.progressStatus = (TextView) viewFindViewById6;
        Object objFindViewById2 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_card_container);
        Intrinsics.checkNotNullExpressionValue(objFindViewById2, "findViewById(...)");
        this.platformCardLayout = (PlatformCardLayout) objFindViewById2;
        MaterialButton materialButtonFindViewById = viewInflate.findViewById(R.id.library_collection_wallpaper_view_download_button);
        Intrinsics.checkNotNullExpressionValue(materialButtonFindViewById, "findViewById(...)");
        this.platformDownloadButton = materialButtonFindViewById;
        View viewFindViewById7 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_horizontal_scroll_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.horizontalScrollView = (HorizontalScrollView) viewFindViewById7;
        ChipGroup chipGroupFindViewById = viewInflate.findViewById(R.id.fragment_library_collection_wallpaper_view_chip_group);
        Intrinsics.checkNotNullExpressionValue(chipGroupFindViewById, "findViewById(...)");
        this.chipGroup = chipGroupFindViewById;
        Chip chipFindViewById = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_lib_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById, "findViewById(...)");
        this.libraryChip = chipFindViewById;
        Chip chipFindViewById2 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_random_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById2, "findViewById(...)");
        this.randomButton = chipFindViewById2;
        Chip chipFindViewById3 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_add_sync_trees_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById3, "findViewById(...)");
        this.syncButton = chipFindViewById3;
        Chip chipFindViewById4 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_recent_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById4, "findViewById(...)");
        this.recentPlayedButton = chipFindViewById4;
        Chip chipFindViewById5 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_favorite_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById5, "findViewById(...)");
        this.favoriteButton = chipFindViewById5;
        Chip chipFindViewById6 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_newly_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById6, "findViewById(...)");
        this.newlyAddedButton = chipFindViewById6;
        Chip chipFindViewById7 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_share_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById7, "findViewById(...)");
        this.shareButton = chipFindViewById7;
        Chip chipFindViewById8 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_edit_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById8, "findViewById(...)");
        this.editButton = chipFindViewById8;
        Chip chipFindViewById9 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_platform_add_sync_trees_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById9, "findViewById(...)");
        this.addSyncTreesButton = chipFindViewById9;
        View viewFindViewById8 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_next_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.nextView = viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(R.id.library_collection_wallpaper_view_previous_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.previousView = viewFindViewById9;
        this.navController = FragmentKt.findNavController(this);
        this.platformIdList = CollectionsKt.emptyList();
        this.platformEntityList.clear();
        Chip chip = this.editButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip = null;
        }
        chip.setVisibility(isKioskMode() ? 8 : 0);
        MaterialButton materialButton = this.platformDownloadButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformDownloadButton");
            materialButton = null;
        }
        materialButton.setVisibility(isKioskMode() ? 8 : 0);
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
            horizontalScrollView = null;
        }
        horizontalScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$7(this.f$0, view, i, i2, i3, i4);
            }
        });
        DaijishouLinearLayoutManager daijishouLinearLayoutManager = this.libraryCollectionWallpaperViewLayoutManager;
        if (daijishouLinearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewLayoutManager");
            daijishouLinearLayoutManager = null;
        }
        daijishouLinearLayoutManager.setShakeOnFocusBound(true);
        DaijishouLinearLayoutManager daijishouLinearLayoutManager2 = this.libraryCollectionWallpaperViewLayoutManager;
        if (daijishouLinearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewLayoutManager");
            daijishouLinearLayoutManager2 = null;
        }
        daijishouLinearLayoutManager2.setFocusBoundStart(true);
        DaijishouLinearLayoutManager daijishouLinearLayoutManager3 = this.libraryCollectionWallpaperViewLayoutManager;
        if (daijishouLinearLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewLayoutManager");
            daijishouLinearLayoutManager3 = null;
        }
        daijishouLinearLayoutManager3.setFocusBoundEnd(false);
        DaijishouLinearLayoutManager daijishouLinearLayoutManager4 = this.libraryCollectionWallpaperViewLayoutManager;
        if (daijishouLinearLayoutManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewLayoutManager");
            daijishouLinearLayoutManager4 = null;
        }
        daijishouLinearLayoutManager4.setFocusBoundEdge(false);
        DaijishouRecyclerView daijishouRecyclerView = this.libraryCollectionWallpaperViewRecyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerView");
            daijishouRecyclerView = null;
        }
        DaijishouLinearLayoutManager daijishouLinearLayoutManager5 = this.libraryCollectionWallpaperViewLayoutManager;
        if (daijishouLinearLayoutManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewLayoutManager");
            daijishouLinearLayoutManager5 = null;
        }
        daijishouRecyclerView.setLayoutManager((RecyclerView.LayoutManager) daijishouLinearLayoutManager5);
        DaijishouRecyclerView daijishouRecyclerView2 = this.libraryCollectionWallpaperViewRecyclerView;
        if (daijishouRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerView");
            daijishouRecyclerView2 = null;
        }
        LibraryCollectionWallpaperViewRecyclerViewAdapter libraryCollectionWallpaperViewRecyclerViewAdapter = this.libraryCollectionWallpaperViewRecyclerViewAdapter;
        if (libraryCollectionWallpaperViewRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerViewAdapter");
            libraryCollectionWallpaperViewRecyclerViewAdapter = null;
        }
        daijishouRecyclerView2.setAdapter(libraryCollectionWallpaperViewRecyclerViewAdapter);
        DaijishouRecyclerView daijishouRecyclerView3 = this.libraryCollectionWallpaperViewRecyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerView");
            daijishouRecyclerView3 = null;
        }
        daijishouRecyclerView3.setItemAnimator(null);
        Chip chip2 = this.libraryChip;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
            chip2 = null;
        }
        chip2.setTypeface((Typeface) null, 3);
        Chip chip3 = this.randomButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("randomButton");
            chip3 = null;
        }
        chip3.setTypeface((Typeface) null, 1);
        Chip chip4 = this.syncButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncButton");
            chip4 = null;
        }
        chip4.setTypeface((Typeface) null, 1);
        Chip chip5 = this.recentPlayedButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip5 = null;
        }
        Typeface typeface2 = typeface;
        chip5.setTypeface(typeface2);
        Chip chip6 = this.favoriteButton;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip6 = null;
        }
        chip6.setTypeface(typeface2);
        Chip chip7 = this.newlyAddedButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip7 = null;
        }
        chip7.setTypeface(typeface2);
        Chip chip8 = this.shareButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareButton");
            chip8 = null;
        }
        chip8.setTypeface(typeface2);
        Chip chip9 = this.editButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip9 = null;
        }
        chip9.setTypeface(typeface2);
        Chip chip10 = this.addSyncTreesButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addSyncTreesButton");
            chip10 = null;
        }
        chip10.setTypeface(typeface2);
        Chip chip11 = this.libraryChip;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
            chip11 = null;
        }
        chip11.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$8(view, z);
            }
        });
        Chip chip12 = this.randomButton;
        if (chip12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("randomButton");
            chip12 = null;
        }
        chip12.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$9(view, z);
            }
        });
        Chip chip13 = this.syncButton;
        if (chip13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncButton");
            chip13 = null;
        }
        chip13.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$10(view, z);
            }
        });
        Chip chip14 = this.recentPlayedButton;
        if (chip14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip14 = null;
        }
        chip14.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$11(view, z);
            }
        });
        Chip chip15 = this.favoriteButton;
        if (chip15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip15 = null;
        }
        chip15.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$12(view, z);
            }
        });
        Chip chip16 = this.newlyAddedButton;
        if (chip16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip16 = null;
        }
        chip16.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$13(view, z);
            }
        });
        Chip chip17 = this.shareButton;
        if (chip17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareButton");
            chip17 = null;
        }
        chip17.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$14(view, z);
            }
        });
        Chip chip18 = this.addSyncTreesButton;
        if (chip18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addSyncTreesButton");
            chip18 = null;
        }
        chip18.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$15(view, z);
            }
        });
        Chip chip19 = this.editButton;
        if (chip19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip19 = null;
        }
        chip19.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$16(view, z);
            }
        });
        View view = this.nextView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$17(this.f$0, view2);
            }
        });
        View view2 = this.previousView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousView");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$18(this.f$0, view3);
            }
        });
        PlatformCardLayout platformCardLayout = this.platformCardLayout;
        if (platformCardLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformCardLayout");
            platformCardLayout = null;
        }
        platformCardLayout.setOnNextSwiped(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.13
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LibraryCollectionWallpaperViewNavFragment.this.switchNext();
            }
        });
        PlatformCardLayout platformCardLayout2 = this.platformCardLayout;
        if (platformCardLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformCardLayout");
            platformCardLayout2 = null;
        }
        platformCardLayout2.setOnPreviousSwiped(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.14
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LibraryCollectionWallpaperViewNavFragment.this.switchPrevious();
            }
        });
        MaterialButton materialButton2 = this.platformDownloadButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformDownloadButton");
            materialButton2 = null;
        }
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$19(this.f$0, view3);
            }
        });
        PlatformCardLayout platformCardLayout3 = this.platformCardLayout;
        if (platformCardLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformCardLayout");
            platformCardLayout3 = null;
        }
        platformCardLayout3.setOnTaped(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int i = preferences.getInt("view_mode", 0);
                LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment = this;
                NavController navController2 = null;
                if (i == 0) {
                    NavController navController3 = libraryCollectionWallpaperViewNavFragment.navController;
                    if (navController3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                        navController3 = null;
                    }
                    NavDestination currentDestination = navController3.getCurrentDestination();
                    if (currentDestination == null || currentDestination.getId() != 2131362366) {
                        return;
                    }
                    NavController navController4 = libraryCollectionWallpaperViewNavFragment.navController;
                    if (navController4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                    } else {
                        navController2 = navController4;
                    }
                    navController2.navigate(R.id.libraryCollectionWallpaperViewToPlatformLibraryListViewAction);
                    return;
                }
                if (i != 1) {
                    return;
                }
                NavController navController5 = libraryCollectionWallpaperViewNavFragment.navController;
                if (navController5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                    navController5 = null;
                }
                NavDestination currentDestination2 = navController5.getCurrentDestination();
                if (currentDestination2 == null || currentDestination2.getId() != 2131362366) {
                    return;
                }
                NavController navController6 = libraryCollectionWallpaperViewNavFragment.navController;
                if (navController6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                } else {
                    navController2 = navController6;
                }
                navController2.navigate(R.id.libraryCollectionWallpaperViewToPlatformLibraryGridViewAction);
            }
        });
        Chip chip20 = this.libraryChip;
        if (chip20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
            chip20 = null;
        }
        chip20.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$21(preferences, this, view3);
            }
        });
        Chip chip21 = this.randomButton;
        if (chip21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("randomButton");
            chip21 = null;
        }
        chip21.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$22(this.f$0, contextRequireContext, view3);
            }
        });
        Chip chip22 = this.syncButton;
        if (chip22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncButton");
            chip22 = null;
        }
        chip22.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$23(this.f$0, view3);
            }
        });
        Chip chip23 = this.recentPlayedButton;
        if (chip23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip23 = null;
        }
        chip23.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$24(appCompatActivity, this, view3);
            }
        });
        Chip chip24 = this.favoriteButton;
        if (chip24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip24 = null;
        }
        chip24.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$25(appCompatActivity, this, view3);
            }
        });
        Chip chip25 = this.newlyAddedButton;
        if (chip25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip25 = null;
        }
        chip25.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$26(appCompatActivity, this, view3);
            }
        });
        Chip chip26 = this.shareButton;
        if (chip26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareButton");
            chip26 = null;
        }
        chip26.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$28(this.f$0, contextRequireContext, view3);
            }
        });
        Chip chip27 = this.addSyncTreesButton;
        if (chip27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addSyncTreesButton");
            chip27 = null;
        }
        chip27.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$29(this.f$0, view3);
            }
        });
        Chip chip28 = this.editButton;
        if (chip28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip28 = null;
        }
        chip28.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$30(this.f$0, view3);
            }
        });
        LibraryCollectionWallpaperViewRecyclerViewAdapter libraryCollectionWallpaperViewRecyclerViewAdapter2 = this.libraryCollectionWallpaperViewRecyclerViewAdapter;
        if (libraryCollectionWallpaperViewRecyclerViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerViewAdapter");
            libraryCollectionWallpaperViewRecyclerViewAdapter2 = null;
        }
        libraryCollectionWallpaperViewRecyclerViewAdapter2.setOnItemSelectListener(new Function4<View, Integer, Long, PlatformEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.26
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view3, Integer num, Long l, PlatformEntity platformEntity) {
                invoke(view3, num.intValue(), l.longValue(), platformEntity);
                return Unit.INSTANCE;
            }

            public final void invoke(View view3, int i, long j, PlatformEntity it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getId() != LibraryCollectionWallpaperViewNavFragment.this.getLibraryViewModel().getSelectedPlatformId()) {
                    LibraryCollectionWallpaperViewNavFragment.this.getLibraryViewModel().setSelectedPlatformId(it.getId());
                }
            }
        });
        LibraryCollectionWallpaperViewRecyclerViewAdapter libraryCollectionWallpaperViewRecyclerViewAdapter3 = this.libraryCollectionWallpaperViewRecyclerViewAdapter;
        if (libraryCollectionWallpaperViewRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerViewAdapter");
            libraryCollectionWallpaperViewRecyclerViewAdapter3 = null;
        }
        libraryCollectionWallpaperViewRecyclerViewAdapter3.setOnItemClickListener(new Function4<View, Integer, Long, PlatformEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.27
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view3, Integer num, Long l, PlatformEntity platformEntity) {
                invoke(view3, num.intValue(), l.longValue(), platformEntity);
                return Unit.INSTANCE;
            }

            public final void invoke(View view3, int i, long j, PlatformEntity platformEntity) {
                Intrinsics.checkNotNullParameter(view3, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(platformEntity, "<anonymous parameter 3>");
                int i2 = preferences.getInt("view_mode", 0);
                LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment = this;
                NavController navController2 = null;
                if (i2 == 0) {
                    NavController navController3 = libraryCollectionWallpaperViewNavFragment.navController;
                    if (navController3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                    } else {
                        navController2 = navController3;
                    }
                    navController2.navigate(R.id.libraryCollectionWallpaperViewToPlatformLibraryListViewAction);
                    return;
                }
                if (i2 != 1) {
                    return;
                }
                NavController navController4 = libraryCollectionWallpaperViewNavFragment.navController;
                if (navController4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                } else {
                    navController2 = navController4;
                }
                navController2.navigate(R.id.libraryCollectionWallpaperViewToPlatformLibraryGridViewAction);
            }
        });
        NavController navController2 = this.navController;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        } else {
            navController = navController2;
        }
        navController.getGraph().setStartDestination(R.id.libraryCollectionWallpaperViewNavFragment);
        this.platformId = getLibraryViewModel().getSelectedPlatformId();
        getLibraryViewModel().getSelectedPlatformIdLiveData().observe(getViewLifecycleOwner(), new LibraryCollectionWallpaperViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Long, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.28
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke2(l);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l) {
                LibraryCollectionWallpaperViewNavFragment.this.getLogger().debug(LibraryCollectionWallpaperViewNavFragment.this, "newPlatformId: " + l);
                LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment = LibraryCollectionWallpaperViewNavFragment.this;
                Intrinsics.checkNotNull(l);
                libraryCollectionWallpaperViewNavFragment.platformId = l.longValue();
                LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment2 = LibraryCollectionWallpaperViewNavFragment.this;
                libraryCollectionWallpaperViewNavFragment2.selectedPlatformEntity = libraryCollectionWallpaperViewNavFragment2.getDaijishouLibrary().getPlatformByIdStatically(l.longValue());
                LibraryCollectionWallpaperViewNavFragment.this.refreshCurrentPlatform();
                LibraryCollectionWallpaperViewNavFragment.this.refreshSyncStatus();
            }
        }));
        getLibraryViewModel().getSelectedPlatformStatistics().observe(getViewLifecycleOwner(), new LibraryCollectionWallpaperViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends Long>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.29
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Long> list) {
                invoke2((List<Long>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Long> list) {
                Intrinsics.checkNotNull(list);
                if (list.isEmpty()) {
                    return;
                }
                LibraryCollectionWallpaperViewNavFragment.this.refreshCurrentPlatformStatistic(list.get(0).longValue(), list.get(1).longValue(), list.get(2).longValue(), list.get(3).longValue());
            }
        }));
        List<PlatformEntity> allVisiblePlatformsOrderedByShortNameStatically = getDaijishouLibrary().getAllVisiblePlatformsOrderedByShortNameStatically();
        List<PlatformEntity> list = allVisiblePlatformsOrderedByShortNameStatically;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((PlatformEntity) it.next()).getPosition() != -1) {
                    allVisiblePlatformsOrderedByShortNameStatically = CollectionsKt.sortedWith(CollectionsKt.sortedWith(list, new Comparator() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$onCreateView$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Integer.valueOf(((PlatformEntity) t).getPosition()), Integer.valueOf(((PlatformEntity) t2).getPosition()));
                        }
                    }), new Comparator() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$onCreateView$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Boolean.valueOf(((PlatformEntity) t2).getPosition() != -1), Boolean.valueOf(((PlatformEntity) t).getPosition() != -1));
                        }
                    });
                    break;
                }
            }
        }
        setPlatformList(allVisiblePlatformsOrderedByShortNameStatically);
        final Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        booleanRef3.element = true;
        allVisiblePlatformsOrderedByShortName.observe(getViewLifecycleOwner(), new LibraryCollectionWallpaperViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends PlatformEntity>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.33
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlatformEntity> list2) {
                invoke2((List<PlatformEntity>) list2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PlatformEntity> list2) {
                if (!booleanRef3.element) {
                    List<PlatformEntity> allVisiblePlatformsOrderedByShortNameStatically2 = this.getDaijishouLibrary().getAllVisiblePlatformsOrderedByShortNameStatically();
                    List<PlatformEntity> list3 = allVisiblePlatformsOrderedByShortNameStatically2;
                    if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                        Iterator<T> it2 = list3.iterator();
                        while (it2.hasNext()) {
                            if (((PlatformEntity) it2.next()).getPosition() != -1) {
                                allVisiblePlatformsOrderedByShortNameStatically2 = CollectionsKt.sortedWith(CollectionsKt.sortedWith(list3, new Comparator() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$onCreateView$33$invoke$$inlined$sortedBy$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t, T t2) {
                                        return ComparisonsKt.compareValues(Integer.valueOf(((PlatformEntity) t).getPosition()), Integer.valueOf(((PlatformEntity) t2).getPosition()));
                                    }
                                }), new Comparator() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$onCreateView$33$invoke$$inlined$sortedByDescending$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.util.Comparator
                                    public final int compare(T t, T t2) {
                                        return ComparisonsKt.compareValues(Boolean.valueOf(((PlatformEntity) t2).getPosition() != -1), Boolean.valueOf(((PlatformEntity) t).getPosition() != -1));
                                    }
                                });
                                break;
                            }
                        }
                    }
                    this.setPlatformList(allVisiblePlatformsOrderedByShortNameStatically2);
                    return;
                }
                booleanRef3.element = false;
            }
        }));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.DISPLAY_SHORTNAME_IN_PLATFORMS_PAGE_SUBTITLE.getKey(), BooleanPreference.DISPLAY_SHORTNAME_IN_PLATFORMS_PAGE_SUBTITLE.getDefaultValue()).observe(getViewLifecycleOwner(), new LibraryCollectionWallpaperViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.34
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                if (LibraryCollectionWallpaperViewNavFragment.this.selectedPlatformEntity != null) {
                    Intrinsics.checkNotNull(bool);
                    if (bool.booleanValue()) {
                        LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment = LibraryCollectionWallpaperViewNavFragment.this;
                        PlatformEntity platformEntity = libraryCollectionWallpaperViewNavFragment.selectedPlatformEntity;
                        Intrinsics.checkNotNull(platformEntity);
                        String shortname = platformEntity.getShortname();
                        Locale locale = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                        String upperCase = shortname.toUpperCase(locale);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        libraryCollectionWallpaperViewNavFragment.descriptionFirstString = "🕹 ️" + upperCase + " • ";
                    } else {
                        LibraryCollectionWallpaperViewNavFragment.this.descriptionFirstString = "🕹 ";
                    }
                    TextView textView = LibraryCollectionWallpaperViewNavFragment.this.description;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("description");
                        textView = null;
                    }
                    textView.setText(LibraryCollectionWallpaperViewNavFragment.this.descriptionFirstString + LibraryCollectionWallpaperViewNavFragment.this.descriptionSecondString + LibraryCollectionWallpaperViewNavFragment.this.descriptionThirdString);
                }
            }
        }));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "hide_platforms_page_title", false).observe(getViewLifecycleOwner(), new LibraryCollectionWallpaperViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.35
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                TextSwitcher textSwitcher = LibraryCollectionWallpaperViewNavFragment.this.title;
                if (textSwitcher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                    textSwitcher = null;
                }
                Intrinsics.checkNotNull(bool);
                textSwitcher.setVisibility(bool.booleanValue() ? 8 : 0);
            }
        }));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "hide_platforms_page_subtitle", false).observe(getViewLifecycleOwner(), new LibraryCollectionWallpaperViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.36
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                TextView textView = LibraryCollectionWallpaperViewNavFragment.this.description;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("description");
                    textView = null;
                }
                Intrinsics.checkNotNull(bool);
                textView.setVisibility(bool.booleanValue() ? 8 : 0);
            }
        }));
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), StringPreference.LIBRARY_COLLECTION_VIEW_MODE.getKey(), StringPreference.LIBRARY_COLLECTION_VIEW_MODE.getDefaultValue()).observe(getViewLifecycleOwner(), new LibraryCollectionWallpaperViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.37
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                NavController navController3 = null;
                if (Intrinsics.areEqual(str, "1")) {
                    NavOptions navOptionsBuild = NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), R.id.libraryCollectionWallpaperViewNavFragment, true, false, 4, (Object) null).build();
                    NavController navController4 = LibraryCollectionWallpaperViewNavFragment.this.navController;
                    if (navController4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                        navController4 = null;
                    }
                    navController4.getGraph().setStartDestination(R.id.libraryCollectionThumbnailsViewNavFragment);
                    NavController navController5 = LibraryCollectionWallpaperViewNavFragment.this.navController;
                    if (navController5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                        navController5 = null;
                    }
                    NavDestination currentDestination = navController5.getCurrentDestination();
                    if (currentDestination == null || currentDestination.getId() != 2131362366) {
                        return;
                    }
                    NavController navController6 = LibraryCollectionWallpaperViewNavFragment.this.navController;
                    if (navController6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                    } else {
                        navController3 = navController6;
                    }
                    navController3.navigate(LibraryCollectionWallpaperViewNavFragmentDirections.Companion.libraryCollectionWallpaperViewToLibraryCollectionThumbnailsViewAction(), navOptionsBuild);
                    return;
                }
                if (Intrinsics.areEqual(str, "2")) {
                    NavOptions navOptionsBuild2 = NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), R.id.libraryCollectionWallpaperViewNavFragment, true, false, 4, (Object) null).build();
                    NavController navController7 = LibraryCollectionWallpaperViewNavFragment.this.navController;
                    if (navController7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                        navController7 = null;
                    }
                    navController7.getGraph().setStartDestination(R.id.libraryCollectionWebViewViewNavFragment);
                    NavController navController8 = LibraryCollectionWallpaperViewNavFragment.this.navController;
                    if (navController8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                        navController8 = null;
                    }
                    NavDestination currentDestination2 = navController8.getCurrentDestination();
                    if (currentDestination2 == null || currentDestination2.getId() != 2131362366) {
                        return;
                    }
                    NavController navController9 = LibraryCollectionWallpaperViewNavFragment.this.navController;
                    if (navController9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                    } else {
                        navController3 = navController9;
                    }
                    navController3.navigate(LibraryCollectionWallpaperViewNavFragmentDirections.Companion.libraryCollectionWallpaperViewToLibraryCollectionWebViewViewAction(), navOptionsBuild2);
                }
            }
        }));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue()).observe(getViewLifecycleOwner(), new LibraryCollectionWallpaperViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.38
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                Chip chip29 = LibraryCollectionWallpaperViewNavFragment.this.shareButton;
                if (chip29 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareButton");
                    chip29 = null;
                }
                chip29.setVisibility(!bool.booleanValue() ? 8 : 0);
            }
        }));
        getDaijishouSynchronization().getSynchronizationOfPlatformListLiveData().observe(getViewLifecycleOwner(), new LibraryCollectionWallpaperViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<SynchronizationOfPlatform>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.39
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<SynchronizationOfPlatform> list2) {
                invoke2(list2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<SynchronizationOfPlatform> list2) {
                LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment = LibraryCollectionWallpaperViewNavFragment.this;
                Intrinsics.checkNotNull(list2);
                libraryCollectionWallpaperViewNavFragment.synchronizationOfPlatformList = list2;
                LibraryCollectionWallpaperViewNavFragment.this.refreshSyncStatus();
            }
        }));
        getDaijishouSynchronization().getOnSynchronizationFinishedLiveData().observe(getViewLifecycleOwner(), new LibraryCollectionWallpaperViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Long, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.40
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke2(l);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l) {
                long j = LibraryCollectionWallpaperViewNavFragment.this.platformId;
                if (l != null && l.longValue() == j) {
                    LibraryCollectionWallpaperViewNavFragment.this.refreshSyncStatus();
                }
            }
        }));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.USE_AUTO_THEME_COLOR.getKey(), BooleanPreference.USE_AUTO_THEME_COLOR.getDefaultValue()).observe(getViewLifecycleOwner(), new LibraryCollectionWallpaperViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.41
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.valueOf(booleanRef2.element))) {
                    return;
                }
                Ref.BooleanRef booleanRef4 = booleanRef2;
                Intrinsics.checkNotNull(bool);
                booleanRef4.element = bool.booleanValue();
                LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment = this;
                libraryCollectionWallpaperViewNavFragment.refreshAndUpdateWallpaper(libraryCollectionWallpaperViewNavFragment.selectedPlatformEntity);
            }
        }));
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(contextRequireContext);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        new SharedPreferenceBooleanLiveData(defaultSharedPreferences, BooleanPreference.ENFORCE_PLATFORM_CARD_ASPECT_RATIO.getKey(), BooleanPreference.ENFORCE_PLATFORM_CARD_ASPECT_RATIO.getDefaultValue()).observe(getViewLifecycleOwner(), new LibraryCollectionWallpaperViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.onCreateView.42
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                if (!Intrinsics.areEqual(Boolean.valueOf(booleanRef.element), bool)) {
                    this.requireView().invalidate();
                }
                Ref.BooleanRef booleanRef4 = booleanRef;
                Intrinsics.checkNotNull(bool);
                booleanRef4.element = bool.booleanValue();
            }
        }));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7(LibraryCollectionWallpaperViewNavFragment this$0, View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.refocusOnScrolledToTop) {
            HorizontalScrollView horizontalScrollView = this$0.horizontalScrollView;
            Chip chip = null;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
                horizontalScrollView = null;
            }
            if (horizontalScrollView.getScrollY() == 0) {
                this$0.refocusOnScrolledToTop = false;
                Chip chip2 = this$0.libraryChip;
                if (chip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
                } else {
                    chip = chip2;
                }
                chip.requestFocus();
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
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, true, 8, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, true, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$12(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, true, 8, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, true, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$13(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, true, 8, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, true, 8, null);
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
    public static final void onCreateView$lambda$17(LibraryCollectionWallpaperViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.switchNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$18(LibraryCollectionWallpaperViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.switchPrevious();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$19(LibraryCollectionWallpaperViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DownloadPlatformsDialogFragment.Companion.newInstance().show(this$0.getChildFragmentManager(), DownloadPlatformsDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$21(SharedPreferences platformLibrarySharedPreferences, LibraryCollectionWallpaperViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(platformLibrarySharedPreferences, "$platformLibrarySharedPreferences");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = platformLibrarySharedPreferences.getInt("view_mode", 0);
        NavController navController = null;
        if (i == 0) {
            NavController navController2 = this$0.navController;
            if (navController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController2 = null;
            }
            NavDestination currentDestination = navController2.getCurrentDestination();
            if (currentDestination == null || currentDestination.getId() != 2131362366) {
                return;
            }
            NavController navController3 = this$0.navController;
            if (navController3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
            } else {
                navController = navController3;
            }
            navController.navigate(R.id.libraryCollectionWallpaperViewToPlatformLibraryListViewAction);
            return;
        }
        if (i != 1) {
            return;
        }
        NavController navController4 = this$0.navController;
        if (navController4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController4 = null;
        }
        NavDestination currentDestination2 = navController4.getCurrentDestination();
        if (currentDestination2 == null || currentDestination2.getId() != 2131362366) {
            return;
        }
        NavController navController5 = this$0.navController;
        if (navController5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
        } else {
            navController = navController5;
        }
        navController.navigate(R.id.libraryCollectionWallpaperViewToPlatformLibraryGridViewAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$22(LibraryCollectionWallpaperViewNavFragment this$0, Context context, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        PlayableItemEntity playableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default = DaijishouLibraryModel.getPlayableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default(this$0.getDaijishouLibrary(), this$0.getLibraryViewModel().getSelectedPlatformId(), false, 2, null);
        if (playableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default == null) {
            String str = this$0.noItemString;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noItemString");
                str = null;
            }
            Toast.makeText(context, str, 0).show();
            return;
        }
        PlayableItemDetailDialogFragment.Companion.newInstance(playableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default).show(this$0.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$23(LibraryCollectionWallpaperViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DaijishouSynchronizationModel daijishouSynchronization = this$0.getDaijishouSynchronization();
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        daijishouSynchronization.scheduleSynchronizationOfPlatformByPlatformId((AppCompatActivity) fragmentActivityRequireActivity, this$0.getLibraryViewModel().getSelectedPlatformId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$24(AppCompatActivity activity, LibraryCollectionWallpaperViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((MainActivity) activity).navigatePage("library", new LibraryPageSelectedParameters(2, this$0.platformId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$25(AppCompatActivity activity, LibraryCollectionWallpaperViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((MainActivity) activity).navigatePage("library", new LibraryPageSelectedParameters(1, this$0.platformId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$26(AppCompatActivity activity, LibraryCollectionWallpaperViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((MainActivity) activity).navigatePage("library", new LibraryPageSelectedParameters(3, this$0.platformId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$28(final LibraryCollectionWallpaperViewNavFragment this$0, final Context context, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        final PlatformEntity platformByIdStatically = this$0.getDaijishouLibrary().getPlatformByIdStatically(this$0.platformId);
        if (platformByIdStatically != null) {
            ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.Companion;
            String str = this$0.shareString;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareString");
                str = null;
            }
            String[] strArr = new String[2];
            String str3 = this$0.sharePlatformConfigString;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharePlatformConfigString");
                str3 = null;
            }
            strArr[0] = str3;
            String str4 = this$0.sharePlatformFavoriteItemsString;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharePlatformFavoriteItemsString");
            } else {
                str2 = str4;
            }
            strArr[1] = str2;
            ListSelectDialogFragment.Companion.newInstance$default(companion, str, CollectionsKt.arrayListOf(strArr), null, false, 12, null).setOnSelectListener(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$onCreateView$23$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    if (i == 0) {
                        PlatformShareable platformShareableExportPlatform = this.this$0.getDaijishouLibrary().exportPlatform(platformByIdStatically);
                        StringFormat stringFormatJson$default = JsonKt.Json$default((Json) null, new Function1<JsonBuilder, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$onCreateView$23$1$1$jsonFormat$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                                invoke2(jsonBuilder);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(JsonBuilder Json) {
                                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                                Json.setPrettyPrint(true);
                                Json.setEncodeDefaults(true);
                            }
                        }, 1, (Object) null);
                        stringFormatJson$default.getSerializersModule();
                        String strEncodeToString = stringFormatJson$default.encodeToString(PlatformShareable.Companion.serializer(), platformShareableExportPlatform);
                        try {
                            String strReplace = new Regex("\\W+").replace(platformByIdStatically.getName(), "");
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(strReplace + ".json", 0));
                            outputStreamWriter.write(strEncodeToString);
                            outputStreamWriter.close();
                            File file = new File(context.getFilesDir(), strReplace + ".json");
                            ActivityResultContract contract = this.this$0.shareFileActivity.getContract();
                            Intrinsics.checkNotNull(contract, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.nav.ShareFileContract");
                            ((ShareFileContract) contract).setSharedFileDescription(platformByIdStatically.getName() + " platform settings.");
                            this.this$0.shareFileActivity.launch(file);
                            return;
                        } catch (IOException unused) {
                            Toast.makeText(context, "IO Exception.", 0).show();
                            return;
                        }
                    }
                    if (i != 1) {
                        return;
                    }
                    FavoriteItemsShareable favoriteItemsShareableExportPlatformFavoriteItems = this.this$0.getDaijishouLibrary().exportPlatformFavoriteItems(platformByIdStatically);
                    StringFormat stringFormatJson$default2 = JsonKt.Json$default((Json) null, new Function1<JsonBuilder, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment$onCreateView$23$1$1$jsonFormat$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                            invoke2(jsonBuilder);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(JsonBuilder Json) {
                            Intrinsics.checkNotNullParameter(Json, "$this$Json");
                            Json.setPrettyPrint(true);
                            Json.setEncodeDefaults(true);
                        }
                    }, 1, (Object) null);
                    stringFormatJson$default2.getSerializersModule();
                    String strEncodeToString2 = stringFormatJson$default2.encodeToString(FavoriteItemsShareable.Companion.serializer(), favoriteItemsShareableExportPlatformFavoriteItems);
                    try {
                        String strReplace2 = new Regex("\\W+").replace(platformByIdStatically.getName(), "");
                        OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(context.openFileOutput(strReplace2 + "FavoriteItems.json", 0));
                        outputStreamWriter2.write(strEncodeToString2);
                        outputStreamWriter2.close();
                        File file2 = new File(context.getFilesDir(), strReplace2 + "FavoriteItems.json");
                        ActivityResultContract contract2 = this.this$0.shareFileActivity.getContract();
                        Intrinsics.checkNotNull(contract2, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.nav.ShareFileContract");
                        ((ShareFileContract) contract2).setSharedFileDescription(platformByIdStatically.getName() + " favorite items.");
                        this.this$0.shareFileActivity.launch(file2);
                    } catch (IOException unused2) {
                        Toast.makeText(context, "IO Exception.", 0).show();
                    }
                }
            }).show(this$0.getChildFragmentManager(), ListSelectDialogFragment.class.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$29(LibraryCollectionWallpaperViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PickPlatformSyncTreeUrDialogFragment.Companion companion = PickPlatformSyncTreeUrDialogFragment.Companion;
        PlatformEntity platformEntity = this$0.selectedPlatformEntity;
        Intrinsics.checkNotNull(platformEntity);
        companion.newInstance(platformEntity).show(this$0.getChildFragmentManager(), PickPlatformSyncTreeUrDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$30(LibraryCollectionWallpaperViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditPlatformDialogFragment.Companion.newInstance(this$0.getDaijishouLibrary().getPlatformByIdStatically(this$0.platformId)).show(this$0.getChildFragmentManager(), "edit_platform");
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Chip chip = this.libraryChip;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
            chip = null;
        }
        chip.requestFocus();
    }

    private final void updateLightDarkDecorations(Bitmap bitmap) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ColorStateList colorStateList = ContextCompat.getColorStateList(contextRequireContext, R.color.black);
        Intrinsics.checkNotNull(colorStateList);
        ColorStateList colorStateList2 = ContextCompat.getColorStateList(contextRequireContext, R.color.white);
        Intrinsics.checkNotNull(colorStateList2);
        ColorStateList colorStateList3 = ContextCompat.getColorStateList(contextRequireContext, R.color.dark_grey);
        Intrinsics.checkNotNull(colorStateList3);
        if (bitmap == null) {
            if (PlaidColorUtils.INSTANCE.isDarkTheme(contextRequireContext)) {
                updateLightDarkDecorations$setDark(this, colorStateList2, colorStateList3);
                return;
            } else {
                updateLightDarkDecorations$setLight(this, colorStateList, colorStateList2);
                return;
            }
        }
        if (Utils.INSTANCE.isBitmapDark(bitmap, 0, Integer.valueOf((bitmap.getHeight() * 2) / 4), Integer.valueOf(bitmap.getWidth() / 2), Integer.valueOf(bitmap.getHeight()))) {
            updateLightDarkDecorations$setDark(this, colorStateList2, colorStateList3);
        } else {
            updateLightDarkDecorations$setLight(this, colorStateList, colorStateList2);
        }
    }

    private static final void updateLightDarkDecorations$setLight(LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment, ColorStateList colorStateList, ColorStateList colorStateList2) {
        ShapeableImageView shapeableImageView = libraryCollectionWallpaperViewNavFragment.fullScreenGrad;
        TextView textView = null;
        if (shapeableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fullScreenGrad");
            shapeableImageView = null;
        }
        shapeableImageView.setBackgroundResource(R.drawable.background_grad_light);
        TextView textView2 = libraryCollectionWallpaperViewNavFragment.titleFirst;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleFirst");
            textView2 = null;
        }
        textView2.setTextColor(colorStateList);
        TextView textView3 = libraryCollectionWallpaperViewNavFragment.titleSecond;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleSecond");
            textView3 = null;
        }
        textView3.setTextColor(colorStateList);
        TextView textView4 = libraryCollectionWallpaperViewNavFragment.description;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("description");
            textView4 = null;
        }
        textView4.setTextColor(colorStateList);
        TextView textView5 = libraryCollectionWallpaperViewNavFragment.progressStatus;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressStatus");
            textView5 = null;
        }
        textView5.setTextColor(colorStateList);
        TextView textView6 = libraryCollectionWallpaperViewNavFragment.titleFirst;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleFirst");
            textView6 = null;
        }
        textView6.setShadowLayer(DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, colorStateList2.getDefaultColor());
        TextView textView7 = libraryCollectionWallpaperViewNavFragment.titleSecond;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleSecond");
            textView7 = null;
        }
        textView7.setShadowLayer(DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, colorStateList2.getDefaultColor());
        TextView textView8 = libraryCollectionWallpaperViewNavFragment.description;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("description");
        } else {
            textView = textView8;
        }
        textView.setShadowLayer(DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, colorStateList2.getDefaultColor());
    }

    private static final void updateLightDarkDecorations$setDark(LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment, ColorStateList colorStateList, ColorStateList colorStateList2) {
        ShapeableImageView shapeableImageView = libraryCollectionWallpaperViewNavFragment.fullScreenGrad;
        TextView textView = null;
        if (shapeableImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fullScreenGrad");
            shapeableImageView = null;
        }
        shapeableImageView.setBackgroundResource(R.drawable.background_grad_dark);
        TextView textView2 = libraryCollectionWallpaperViewNavFragment.titleFirst;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleFirst");
            textView2 = null;
        }
        textView2.setTextColor(colorStateList);
        TextView textView3 = libraryCollectionWallpaperViewNavFragment.titleSecond;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleSecond");
            textView3 = null;
        }
        textView3.setTextColor(colorStateList);
        TextView textView4 = libraryCollectionWallpaperViewNavFragment.description;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("description");
            textView4 = null;
        }
        textView4.setTextColor(colorStateList);
        TextView textView5 = libraryCollectionWallpaperViewNavFragment.progressStatus;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressStatus");
            textView5 = null;
        }
        textView5.setTextColor(colorStateList);
        TextView textView6 = libraryCollectionWallpaperViewNavFragment.titleFirst;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleFirst");
            textView6 = null;
        }
        textView6.setShadowLayer(libraryCollectionWallpaperViewNavFragment.getDpToPxConverter().convert(3.0f), DefinitionKt.NO_Float_VALUE, libraryCollectionWallpaperViewNavFragment.getDpToPxConverter().convert(1.0f), colorStateList2.getDefaultColor());
        TextView textView7 = libraryCollectionWallpaperViewNavFragment.titleSecond;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleSecond");
            textView7 = null;
        }
        textView7.setShadowLayer(libraryCollectionWallpaperViewNavFragment.getDpToPxConverter().convert(3.0f), DefinitionKt.NO_Float_VALUE, libraryCollectionWallpaperViewNavFragment.getDpToPxConverter().convert(1.0f), colorStateList2.getDefaultColor());
        TextView textView8 = libraryCollectionWallpaperViewNavFragment.description;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("description");
        } else {
            textView = textView8;
        }
        textView.setShadowLayer(libraryCollectionWallpaperViewNavFragment.getDpToPxConverter().convert(2.0f), DefinitionKt.NO_Float_VALUE, libraryCollectionWallpaperViewNavFragment.getDpToPxConverter().convert(1.0f), colorStateList2.getDefaultColor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPlatformList(List<PlatformEntity> list) {
        this.platformEntityList.clear();
        this.platformEntityList.addAll(list);
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(Long.valueOf(list.get(i).getId()));
        }
        this.platformIdList = arrayList;
        NavController navController = null;
        if (list.isEmpty()) {
            NavController navController2 = this.navController;
            if (navController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController2 = null;
            }
            navController2.getGraph().setStartDestination(R.id.platformEmptyNavFragment);
            NavController navController3 = this.navController;
            if (navController3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
            } else {
                navController = navController3;
            }
            navController.navigate(R.id.libraryCollectionWallpaperViewToPlatformEmptyAction);
            getLibraryViewModel().setSelectedPlatformId(-1L);
            return;
        }
        if (getLibraryViewModel().getSelectedPlatformId() == -1 || this.platformIdList.indexOf(Long.valueOf(this.platformId)) == -1) {
            getLogger().debug(this, "setSelectedPlatformId(newPlatformEntityList[0].id), platformId: " + this.platformId + ", platformIdList: " + this.platformIdList);
            getLibraryViewModel().setSelectedPlatformId(list.get(0).getId());
        }
        NavController navController4 = this.libraryCollectionWallpaperViewRecyclerViewAdapter;
        if (navController4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionWallpaperViewRecyclerViewAdapter");
        } else {
            navController = navController4;
        }
        navController.notifyDataSetChanged();
        refreshCurrentPlatform();
        refreshSyncStatus();
    }

    static /* synthetic */ void updateWallpaper$default(LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment, Bitmap bitmap, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        libraryCollectionWallpaperViewNavFragment.updateWallpaper(bitmap, z, z2);
    }

    private final void updateWallpaper(Bitmap bitmap, boolean z, boolean z2) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        ColorStateList colorStateList5;
        ColorStateList colorStateList6;
        ColorStateList colorStateList7;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        if (bitmap != null && z) {
            int iHashCode = bitmap.hashCode();
            if (getLibraryViewModel().getPlatformWallpaperColorsList().containsKey(Integer.valueOf(iHashCode))) {
                List<ColorStateList> list = getLibraryViewModel().getPlatformWallpaperColorsList().get(Integer.valueOf(iHashCode));
                Intrinsics.checkNotNull(list);
                List<ColorStateList> list2 = list;
                list2.get(0);
                colorStateList4 = list2.get(1);
                colorStateList2 = list2.get(2);
                colorStateList3 = list2.get(3);
            } else {
                TypedValue typedValue = new TypedValue();
                if (this.themeTextColor == null) {
                    fragmentActivityRequireActivity.getTheme().resolveAttribute(R.attr.themeTextColor, typedValue, true);
                }
                Integer numValueOf = this.themeTextColor;
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(typedValue.data);
                }
                this.themeTextColor = numValueOf;
                if (this.themeBackgroundColor == null) {
                    fragmentActivityRequireActivity.getTheme().resolveAttribute(R.attr.themeBackgroundColor, typedValue, true);
                }
                Integer numValueOf2 = this.themeBackgroundColor;
                if (numValueOf2 == null) {
                    numValueOf2 = Integer.valueOf(typedValue.data);
                }
                this.themeBackgroundColor = numValueOf2;
                Triple<Integer, Integer, Integer> bitmapThemeColors = Utils.INSTANCE.getBitmapThemeColors(bitmap, 0.8f);
                int iIntValue = bitmapThemeColors.getFirst().intValue();
                int iIntValue2 = bitmapThemeColors.getSecond().intValue();
                int iIntValue3 = bitmapThemeColors.getThird().intValue();
                int[][] iArr = {new int[]{android.R.attr.state_focused}, new int[]{-16842908}, new int[]{android.R.attr.state_enabled}};
                Integer num = this.themeBackgroundColor;
                Intrinsics.checkNotNull(num);
                ColorStateList colorStateList8 = new ColorStateList(iArr, new int[]{num.intValue(), iIntValue2, iIntValue2});
                Integer num2 = this.themeBackgroundColor;
                Intrinsics.checkNotNull(num2);
                ColorStateList colorStateList9 = new ColorStateList(iArr, new int[]{num2.intValue(), iIntValue3, iIntValue3});
                Integer num3 = this.themeTextColor;
                Intrinsics.checkNotNull(num3);
                ColorStateList colorStateList10 = new ColorStateList(iArr, new int[]{num3.intValue(), iIntValue, iIntValue});
                ColorStateList colorStateList11 = new ColorStateList(iArr, new int[]{iIntValue2, iIntValue2, iIntValue2});
                getLibraryViewModel().getPlatformWallpaperColorsList().put(Integer.valueOf(iHashCode), CollectionsKt.listOf((Object[]) new ColorStateList[]{colorStateList8, colorStateList9, colorStateList10, colorStateList11}));
                colorStateList2 = colorStateList10;
                colorStateList3 = colorStateList11;
                colorStateList4 = colorStateList9;
            }
            Chip chip = this.recentPlayedButton;
            if (chip == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
                chip = null;
            }
            if (colorStateList4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipTextColors");
                colorStateList5 = null;
            } else {
                colorStateList5 = colorStateList4;
            }
            chip.setTextColor(colorStateList5);
            Chip chip2 = this.favoriteButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip2 = null;
            }
            chip2.setTextColor(colorStateList4);
            Chip chip3 = this.newlyAddedButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
                chip3 = null;
            }
            chip3.setTextColor(colorStateList4);
            Chip chip4 = this.recentPlayedButton;
            if (chip4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
                chip4 = null;
            }
            if (colorStateList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipBackgroundColors");
                colorStateList6 = null;
            } else {
                colorStateList6 = colorStateList2;
            }
            chip4.setChipBackgroundColor(colorStateList6);
            Chip chip5 = this.favoriteButton;
            if (chip5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip5 = null;
            }
            chip5.setChipBackgroundColor(colorStateList2);
            Chip chip6 = this.newlyAddedButton;
            if (chip6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
                chip6 = null;
            }
            chip6.setChipBackgroundColor(colorStateList2);
            Chip chip7 = this.recentPlayedButton;
            if (chip7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
                chip7 = null;
            }
            chip7.setChipIconTint(colorStateList4);
            Chip chip8 = this.favoriteButton;
            if (chip8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip8 = null;
            }
            chip8.setChipIconTint(colorStateList4);
            Chip chip9 = this.newlyAddedButton;
            if (chip9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
                chip9 = null;
            }
            chip9.setChipIconTint(colorStateList4);
            MaterialButton materialButton = this.platformDownloadButton;
            if (materialButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformDownloadButton");
                materialButton = null;
            }
            if (colorStateList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadIconColors");
                colorStateList7 = null;
            } else {
                colorStateList7 = colorStateList3;
            }
            materialButton.setIconTint(colorStateList7);
        } else {
            Chip chip10 = this.recentPlayedButton;
            if (chip10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
                chip10 = null;
            }
            ColorStateList colorStateList12 = this.defaultChipTextColors;
            if (colorStateList12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultChipTextColors");
                colorStateList12 = null;
            }
            chip10.setTextColor(colorStateList12);
            Chip chip11 = this.favoriteButton;
            if (chip11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip11 = null;
            }
            ColorStateList colorStateList13 = this.defaultChipTextColors;
            if (colorStateList13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultChipTextColors");
                colorStateList13 = null;
            }
            chip11.setTextColor(colorStateList13);
            Chip chip12 = this.newlyAddedButton;
            if (chip12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
                chip12 = null;
            }
            ColorStateList colorStateList14 = this.defaultChipTextColors;
            if (colorStateList14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultChipTextColors");
                colorStateList14 = null;
            }
            chip12.setTextColor(colorStateList14);
            Chip chip13 = this.recentPlayedButton;
            if (chip13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
                chip13 = null;
            }
            ColorStateList colorStateList15 = this.defaultChipBackgroundColors;
            if (colorStateList15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultChipBackgroundColors");
                colorStateList15 = null;
            }
            chip13.setChipBackgroundColor(colorStateList15);
            Chip chip14 = this.favoriteButton;
            if (chip14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip14 = null;
            }
            ColorStateList colorStateList16 = this.defaultChipBackgroundColors;
            if (colorStateList16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultChipBackgroundColors");
                colorStateList16 = null;
            }
            chip14.setChipBackgroundColor(colorStateList16);
            Chip chip15 = this.newlyAddedButton;
            if (chip15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
                chip15 = null;
            }
            ColorStateList colorStateList17 = this.defaultChipBackgroundColors;
            if (colorStateList17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultChipBackgroundColors");
                colorStateList17 = null;
            }
            chip15.setChipBackgroundColor(colorStateList17);
            Chip chip16 = this.recentPlayedButton;
            if (chip16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
                chip16 = null;
            }
            ColorStateList colorStateList18 = this.defaultChipTextColors;
            if (colorStateList18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultChipTextColors");
                colorStateList18 = null;
            }
            chip16.setChipIconTint(colorStateList18);
            Chip chip17 = this.favoriteButton;
            if (chip17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip17 = null;
            }
            ColorStateList colorStateList19 = this.defaultChipTextColors;
            if (colorStateList19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultChipTextColors");
                colorStateList19 = null;
            }
            chip17.setChipIconTint(colorStateList19);
            Chip chip18 = this.newlyAddedButton;
            if (chip18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
                chip18 = null;
            }
            ColorStateList colorStateList20 = this.defaultChipTextColors;
            if (colorStateList20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultChipTextColors");
                colorStateList20 = null;
            }
            chip18.setChipIconTint(colorStateList20);
            MaterialButton materialButton2 = this.platformDownloadButton;
            if (materialButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformDownloadButton");
                materialButton2 = null;
            }
            ColorStateList colorStateList21 = this.defaultDownloadIconColors;
            if (colorStateList21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultDownloadIconColors");
                colorStateList = null;
            } else {
                colorStateList = colorStateList21;
            }
            materialButton2.setIconTint(colorStateList);
        }
        if (!z2) {
            imageViewAnimatedChange(bitmap);
        }
        updateLightDarkDecorations(bitmap);
    }

    private final void imageViewAnimatedChange(Bitmap bitmap) {
        Animation animation = this.imageViewAnimationOut;
        ShapeableImageView shapeableImageView = null;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageViewAnimationOut");
            animation = null;
        }
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.imageViewAnimatedChange.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                Intrinsics.checkNotNullParameter(animation2, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
                Intrinsics.checkNotNullParameter(animation2, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                Intrinsics.checkNotNullParameter(animation2, "animation");
            }
        });
        getImageViewAnimationIn().setAnimationListener(new Animation.AnimationListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.LibraryCollectionWallpaperViewNavFragment.imageViewAnimatedChange.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
                Intrinsics.checkNotNullParameter(animation2, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                Intrinsics.checkNotNullParameter(animation2, "animation");
                ShapeableImageView shapeableImageView2 = LibraryCollectionWallpaperViewNavFragment.this.wallpaper;
                ShapeableImageView shapeableImageView3 = null;
                if (shapeableImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
                    shapeableImageView2 = null;
                }
                if (Intrinsics.areEqual(shapeableImageView2.getTag(), (Object) 1)) {
                    ShapeableImageView shapeableImageView4 = LibraryCollectionWallpaperViewNavFragment.this.wallpaper;
                    if (shapeableImageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
                        shapeableImageView4 = null;
                    }
                    ((View) shapeableImageView4).setVisibility(0);
                    ShapeableImageView shapeableImageView5 = LibraryCollectionWallpaperViewNavFragment.this.secondWallpaper;
                    if (shapeableImageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("secondWallpaper");
                        shapeableImageView5 = null;
                    }
                    ((View) shapeableImageView5).setVisibility(0);
                    ShapeableImageView shapeableImageView6 = LibraryCollectionWallpaperViewNavFragment.this.wallpaper;
                    if (shapeableImageView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
                    } else {
                        shapeableImageView3 = shapeableImageView6;
                    }
                    shapeableImageView3.bringToFront();
                    return;
                }
                ShapeableImageView shapeableImageView7 = LibraryCollectionWallpaperViewNavFragment.this.wallpaper;
                if (shapeableImageView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
                    shapeableImageView7 = null;
                }
                ((View) shapeableImageView7).setVisibility(0);
                ShapeableImageView shapeableImageView8 = LibraryCollectionWallpaperViewNavFragment.this.secondWallpaper;
                if (shapeableImageView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("secondWallpaper");
                    shapeableImageView8 = null;
                }
                ((View) shapeableImageView8).setVisibility(0);
                ShapeableImageView shapeableImageView9 = LibraryCollectionWallpaperViewNavFragment.this.secondWallpaper;
                if (shapeableImageView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("secondWallpaper");
                } else {
                    shapeableImageView3 = shapeableImageView9;
                }
                shapeableImageView3.bringToFront();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                Intrinsics.checkNotNullParameter(animation2, "animation");
                ShapeableImageView shapeableImageView2 = LibraryCollectionWallpaperViewNavFragment.this.wallpaper;
                View view = null;
                if (shapeableImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
                    shapeableImageView2 = null;
                }
                if (Intrinsics.areEqual(shapeableImageView2.getTag(), (Object) 1)) {
                    View view2 = LibraryCollectionWallpaperViewNavFragment.this.secondWallpaper;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("secondWallpaper");
                    } else {
                        view = view2;
                    }
                    view.setVisibility(8);
                    return;
                }
                View view3 = LibraryCollectionWallpaperViewNavFragment.this.wallpaper;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
                } else {
                    view = view3;
                }
                view.setVisibility(8);
            }
        });
        ShapeableImageView shapeableImageView2 = this.wallpaper;
        if (shapeableImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
            shapeableImageView2 = null;
        }
        if (Intrinsics.areEqual(shapeableImageView2.getTag(), (Object) 0)) {
            ShapeableImageView shapeableImageView3 = this.wallpaper;
            if (shapeableImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
                shapeableImageView3 = null;
            }
            shapeableImageView3.setTag(1);
            ShapeableImageView shapeableImageView4 = this.secondWallpaper;
            if (shapeableImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondWallpaper");
                shapeableImageView4 = null;
            }
            shapeableImageView4.setTag(0);
            ShapeableImageView shapeableImageView5 = this.wallpaper;
            if (shapeableImageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
                shapeableImageView5 = null;
            }
            shapeableImageView5.setImageBitmap(bitmap);
            ShapeableImageView shapeableImageView6 = this.wallpaper;
            if (shapeableImageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
            } else {
                shapeableImageView = shapeableImageView6;
            }
            shapeableImageView.startAnimation(getImageViewAnimationIn());
            return;
        }
        ShapeableImageView shapeableImageView7 = this.wallpaper;
        if (shapeableImageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wallpaper");
            shapeableImageView7 = null;
        }
        shapeableImageView7.setTag(0);
        ShapeableImageView shapeableImageView8 = this.secondWallpaper;
        if (shapeableImageView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondWallpaper");
            shapeableImageView8 = null;
        }
        shapeableImageView8.setTag(1);
        ShapeableImageView shapeableImageView9 = this.secondWallpaper;
        if (shapeableImageView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondWallpaper");
            shapeableImageView9 = null;
        }
        shapeableImageView9.setImageBitmap(bitmap);
        ShapeableImageView shapeableImageView10 = this.secondWallpaper;
        if (shapeableImageView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondWallpaper");
        } else {
            shapeableImageView = shapeableImageView10;
        }
        shapeableImageView.startAnimation(getImageViewAnimationIn());
    }
}
