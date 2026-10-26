package com.magneticchen.daijishou.application_data;

import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.upgrade_scripts.ClearDisjointedEventsUpgradeScript;
import com.magneticchen.daijishou.upgrade_scripts.ForeverUpgradeScript;
import com.magneticchen.daijishou.upgrade_scripts.PlatformsForeverUpgradeScript;
import com.magneticchen.daijishou.upgrade_scripts.SyncEntirelyUpgradeScript;
import com.magneticchen.daijishou.upgrade_scripts.UpdateEveryPlatformUpgradeScript;
import com.magneticchen.daijishou.upgrade_scripts.UpgradeScript;
import com.magneticchen.daijishou.upgrade_scripts.UpgradeScript402;
import com.magneticchen.daijishou.upgrade_scripts.UpgradeScript60;
import com.magneticchen.daijishou.upgrade_scripts.UpgradeScript64;
import com.magneticchen.daijishou.upgrade_scripts.UpgradeScript67;
import com.magneticchen.daijishou.upgrade_scripts.UpgradeScript69;
import com.magneticchen.daijishou.upgrade_scripts.UpgradeScript73;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.BranchConfig;

/* INFO: compiled from: Constants.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\rR\u000e\u0010&\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010E\u001a\u00020Fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010I\u001a\u0004\bG\u0010HR-\u0010J\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100Kj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010`L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010Q\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u000e\u0010X\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010^\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\b_\u0010TR\u0014\u0010`\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\ba\u0010WR\u000e\u0010b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010m\u001a\u00020Fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010I\u001a\u0004\bn\u0010HR\u000e\u0010o\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010r\u001a\u00020Fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010I\u001a\u0004\bs\u0010HR\u000e\u0010t\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010u\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bv\u0010TR\u000e\u0010w\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00040|¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u000e\u0010\u007f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100|¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010~R\u0019\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100|¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010~R\u0019\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040|¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010~R\u000f\u0010\u0087\u0001\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100|¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010~R\u0019\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100|¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010~R\u0019\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040|¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010~R\u000f\u0010\u008e\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0090\u0001\u001a\u00020\u000b¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010\rR\u000f\u0010\u0092\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0001\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0099\u0001\u001a\u00020\u000b¢\u0006\t\n\u0000\u001a\u0005\b\u009a\u0001\u0010\rR\u0019\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100|¢\u0006\t\n\u0000\u001a\u0005\b\u009c\u0001\u0010~R\u000f\u0010\u009d\u0001\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u009e\u0001\u001a\u0016\u0012\u0005\u0012\u00030 \u00010\u009f\u0001j\n\u0012\u0005\u0012\u00030 \u0001`¡\u0001¢\u0006\n\n\u0000\u001a\u0006\b¢\u0001\u0010£\u0001R\u000f\u0010¤\u0001\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¥\u0001\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¦\u0001\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010§\u0001\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¨\u0001\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010©\u0001\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0001\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010«\u0001\u001a\u00020R¢\u0006\t\n\u0000\u001a\u0005\b¬\u0001\u0010TR\u0016\u0010\u00ad\u0001\u001a\u00020\u0010X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b®\u0001\u0010WR\u000f\u0010¯\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010°\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010±\u0001\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006²\u0001"}, d2 = {"Lcom/magneticchen/daijishou/application_data/Constants;", "", "()V", "achievementGridItemMaxSpanCount", "", "achievementGridItemMinWidthAndHeightDp", "", "appIconsCacheSize", "appLaunchingDelayMs", "", "aspectRatioRegex", "Lkotlin/text/Regex;", "getAspectRatioRegex", "()Lkotlin/text/Regex;", "chipMarginDp", "crashSecretKeyword", "", "daijishouSDKUri", "debugOffSecretKeyword", "debugOnSecretKeyword", "defaultBackButtonSoundId", "defaultBoxArtDSESSFormat", "defaultButtonSoundId", "defaultFirstAdditionalHotkeyKeyCode", "defaultLeftHotkeyKeyCode", "defaultPlatformThumbnailsPackUrlString", "defaultPlatformWallpapersPackUrlString", "defaultRightHotkeyKeyCode", "defaultSearchHotkeyKeyCode", "defaultSecondAdditionalHotkeyKeyCode", "defaultSelectButtonSoundId", "defaultSwitchingNextHotkeyKeyCode", "defaultSwitchingPreviousHotkeyKeyCode", "defaultThemeId", "defaultThumbnailDimensionRatio", "defaultYoutubeVideoIdDSESSFormat", "discIndexRegex", "getDiscIndexRegex", "discordUri", "donationUri", "downloadedBoxArtImagesShortEdgeBase", "downloadedImagesShortEdgeBase", "enlargeScale", "githubUri", "guaranteeSplashScreenMs", "highlightImagesCacheRows", "igdbAccessToken", "igdbClientId", "igdbExpiresInSec", "igdbStartDateMs", "indexToFarAwayFromTop", "keyDownListSize", "keyStrokeCoolDownMs", "largerEnlargeScale", "largestEnlargeScale", "layoutDimensionRatio", "layoutDimensionRatioFloat", "libraryBoxArtCacheExpirationInMinutes", "libraryBoxArtCacheSize", "libraryBoxArtImagesShortEdgeBase", "libraryImagesCacheSize", "librarySnapshotCacheExpirationInMinutes", "librarySnapshotCacheSize", "librarySnapshotImagesShortEdgeBase", "libraryTitleCacheExpirationInMinutes", "libraryTitleCacheSize", "libraryTitleImagesShortEdgeBase", "loggerFilename", "messagesIndexUri", "newlyDurationDefinition", "Lkotlin/time/Duration;", "getNewlyDurationDefinition-UwyO8pc", "()J", "J", "packageNameToDisplayNameHashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getPackageNameToDisplayNameHashMap", "()Ljava/util/HashMap;", "platformThumbnailCacheExpirationInMinutes", "platformThumbnailCacheSize", "platformThumbnailFormat", "Landroid/graphics/Bitmap$CompressFormat;", "getPlatformThumbnailFormat", "()Landroid/graphics/Bitmap$CompressFormat;", "platformThumbnailFormatExtension", "getPlatformThumbnailFormatExtension", "()Ljava/lang/String;", "platformThumbnailImagesShortEdgeBase", "platformThumbnailQuality", "platformThumbnailsDirectory", "platformThumbnailsPacksIndexUri", "platformWallpaperCacheExpirationInMinutes", "platformWallpaperCacheSize", "platformWallpaperFormat", "getPlatformWallpaperFormat", "platformWallpaperFormatExtension", "getPlatformWallpaperFormatExtension", "platformWallpaperImagesShortEdgeBase", "platformWallpaperQuality", "platformWallpapersDirectory", "platformWallpapersPacksIndexUri", "platformsIndexUri", "playableItemHeightLandscapePercentage", "playableItemHeightLandscapePower", "playableItemHeightMaxDp", "playableItemHeightPercentage", "playableItemHeightPower", "previewMediaPath", "recentDurationDefinition", "getRecentDurationDefinition-UwyO8pc", "retroAchievementsAchievementDataCacheSize", "retroAchievementsRAWebKeyUri", "retroAchievementsRAWebUri", "retroAchievementsRefreshIntervalDefinition", "getRetroAchievementsRefreshIntervalDefinition-UwyO8pc", "scraperBoxArtFileName", "scraperFormat", "getScraperFormat", "scraperQuality", "scraperSnapshotFileName", "scraperTitleFileName", "scrapingBatchSize", "secretComboKeyList", "", "getSecretComboKeyList", "()Ljava/util/List;", "secretKeyword", "semiBolderWeight", "soundIds", "getSoundIds", "soundNames", "getSoundNames", "sounds", "getSounds", "storeReviewLink", "themeIds", "getThemeIds", "themeNames", "getThemeNames", "themes", "getThemes", "thumbnailGridMaxSpanCount", "thumbnailGridTargetWidthAndHeightDp", "toGenericNameRegex", "getToGenericNameRegex", "triggerStoreReviewEventsCountThreshold", "trimMemoryExpirationLessThanMs", "trimMemoryLibraryBoxArtCacheExpirationLessThanMs", "trimMemoryLibrarySnapshotCacheExpirationLessThanMs", "trimMemoryLibraryTitleCacheExpirationLessThanMs", "trimMemoryPlatformThumbnailCacheExpirationLessThanMs", "trimMemoryPlatformWallpaperCacheExpirationLessThanMs", "trivialRegex", "getTrivialRegex", "trivialWords", "getTrivialWords", "uUIDFilename", "upgradeScripts", "Ljava/util/ArrayList;", "Lcom/magneticchen/daijishou/upgrade_scripts/UpgradeScript;", "Lkotlin/collections/ArrayList;", "getUpgradeScripts", "()Ljava/util/ArrayList;", "videoDelayMs", "wallpaperFilename", "widgetBorderAnimationDuration", "widgetMaxBorderColorMixRatio", "widgetMinBorderColorMixRatio", "widgetTargetWidth", "widgetThemeBorderColorMixRatio", "widgetThumbnailFormat", "getWidgetThumbnailFormat", "widgetThumbnailFormatExtension", "getWidgetThumbnailFormatExtension", "widgetThumbnailQuality", "widgetThumbnailShortEdgeBase", "youtubeStartSeconds", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Constants {
    public static final int achievementGridItemMaxSpanCount = 16;
    public static final float achievementGridItemMinWidthAndHeightDp = 76.0f;
    public static final int appIconsCacheSize = 384;
    public static final long appLaunchingDelayMs = 150;
    public static final float chipMarginDp = 8.0f;
    public static final String crashSecretKeyword = "NUKE!!!";
    public static final String daijishouSDKUri = "https://github.com/Daijishou/Daijishou-SDK";
    public static final String debugOffSecretKeyword = "howdoyouturndebugoff?";
    public static final String debugOnSecretKeyword = "howdoyouturndebugon?";
    public static final String defaultBoxArtDSESSFormat = "DSESS:BOX_ART:TAGS(scraperKeyword):https://thegamesdb.net/search.php?name=%7BscraperKeyword%7D&dsess_selector=img.card-img-top&dsess_attribute=src&dsess_replacer=images%5C%2F.%2A%5C%2Fboxart&dsess_replacer_value=images%2Foriginal%2Fboxart";
    public static final String defaultButtonSoundId = "0";
    public static final int defaultFirstAdditionalHotkeyKeyCode = 100;
    public static final int defaultLeftHotkeyKeyCode = 102;
    public static final String defaultPlatformThumbnailsPackUrlString = "";
    public static final String defaultPlatformWallpapersPackUrlString = "https://raw.githubusercontent.com/TapiocaFox/Daijishou/main/themes/platform_wallpapers_packs/colorful/";
    public static final int defaultRightHotkeyKeyCode = 103;
    public static final int defaultSearchHotkeyKeyCode = 99;
    public static final int defaultSecondAdditionalHotkeyKeyCode = -1;
    public static final int defaultSwitchingNextHotkeyKeyCode = 105;
    public static final int defaultSwitchingPreviousHotkeyKeyCode = 104;
    public static final String defaultThumbnailDimensionRatio = "1:1";
    public static final String defaultYoutubeVideoIdDSESSFormat = "DSESS:YOUTUBE:TAGS(scraperKeyword,platformName,localeLanguageAndCountry):https://www.google.com/search?q=%7BscraperKeyword%7D+%7BplatformName%7D+Walkthrough+YouTube&tbs=dur:l&hl=%7BlocaleLanguageAndCountry%7D&tbm=vid&dsess_selector=a%5Bdata-ved%5D&dsess_attribute=href&dsess_extractor=%5E.%2Av%3D%28%5B%5E%26%5D%2A%29.%2A%24";
    public static final String discordUri = "https://discord.com/invite/nJbxdT3QQE";
    public static final String donationUri = "https://github.com/TapiocaFox/Daijishou#donation";
    public static final int downloadedBoxArtImagesShortEdgeBase = 360;
    public static final int downloadedImagesShortEdgeBase = 720;
    public static final float enlargeScale = 1.03f;
    public static final String githubUri = "https://github.com/TapiocaFox/Daijishou";
    public static final int guaranteeSplashScreenMs = 1500;
    public static final int highlightImagesCacheRows = 64;
    public static final String igdbAccessToken = "fwzlkr2dapc4wsx9k2pb2fjssmic6x";
    public static final String igdbClientId = "zo3ip5g87c5ew7r27q3n1czhczi90l";
    public static final long igdbExpiresInSec = 5642641;
    public static final long igdbStartDateMs = 1664699470254L;
    public static final int indexToFarAwayFromTop = 256;
    public static final int keyDownListSize = 32;
    public static final int keyStrokeCoolDownMs = 45;
    public static final float largerEnlargeScale = 1.04f;
    public static final float largestEnlargeScale = 1.1f;
    public static final String layoutDimensionRatio = "19:9";
    public static final float layoutDimensionRatioFloat = 2.1111112f;
    public static final long libraryBoxArtCacheExpirationInMinutes = 5;
    public static final int libraryBoxArtCacheSize = 256;
    public static final int libraryBoxArtImagesShortEdgeBase = 240;
    public static final int libraryImagesCacheSize = 128;
    public static final long librarySnapshotCacheExpirationInMinutes = 1;
    public static final int librarySnapshotCacheSize = 32;
    public static final int librarySnapshotImagesShortEdgeBase = 720;
    public static final long libraryTitleCacheExpirationInMinutes = 1;
    public static final int libraryTitleCacheSize = 16;
    public static final int libraryTitleImagesShortEdgeBase = 720;
    public static final String loggerFilename = "daijishou_logs.json";
    public static final String messagesIndexUri = "https://raw.githubusercontent.com/TapiocaFox/Daijishou/main/messages/index.json";
    public static final long platformThumbnailCacheExpirationInMinutes = 5;
    public static final int platformThumbnailCacheSize = 16;
    public static final int platformThumbnailImagesShortEdgeBase = 240;
    public static final int platformThumbnailQuality = 100;
    public static final String platformThumbnailsDirectory = "platform_thumbnails";
    public static final String platformThumbnailsPacksIndexUri = "https://raw.githubusercontent.com/TapiocaFox/Daijishou/main/themes/platform_thumbnails_packs/index.json";
    public static final long platformWallpaperCacheExpirationInMinutes = 5;
    public static final int platformWallpaperCacheSize = 16;
    public static final int platformWallpaperImagesShortEdgeBase = 720;
    public static final int platformWallpaperQuality = 100;
    public static final String platformWallpapersDirectory = "platform_wallpapers";
    public static final String platformWallpapersPacksIndexUri = "https://raw.githubusercontent.com/TapiocaFox/Daijishou/main/themes/platform_wallpapers_packs/index.json";
    public static final String platformsIndexUri = "https://raw.githubusercontent.com/TapiocaFox/Daijishou/main/platforms/index.json";
    public static final float playableItemHeightLandscapePercentage = 0.42f;
    public static final float playableItemHeightLandscapePower = 0.15f;
    public static final float playableItemHeightMaxDp = 320.0f;
    public static final float playableItemHeightPercentage = 0.42f;
    public static final float playableItemHeightPower = 0.15f;
    public static final String previewMediaPath = "preview_media";
    public static final int retroAchievementsAchievementDataCacheSize = 256;
    public static final String retroAchievementsRAWebKeyUri = "https://retroachievements.org/controlpanel.php";
    public static final String retroAchievementsRAWebUri = "https://github.com/RetroAchievements/RAWeb";
    public static final String scraperBoxArtFileName = "box_art.png";
    public static final int scraperQuality = 100;
    public static final String scraperSnapshotFileName = "snapshot.png";
    public static final String scraperTitleFileName = "title.png";
    public static final int scrapingBatchSize = 8;
    public static final String secretKeyword = "nooxyhowdoyouturnthison?";
    public static final int semiBolderWeight = 750;
    public static final String storeReviewLink = "https://play.google.com/store/apps/details?id=com.magneticchen.daijishou";
    public static final int thumbnailGridMaxSpanCount = 8;
    public static final float thumbnailGridTargetWidthAndHeightDp = 120.0f;
    public static final int triggerStoreReviewEventsCountThreshold = 256;
    public static final long trimMemoryExpirationLessThanMs = 30000;
    public static final long trimMemoryLibraryBoxArtCacheExpirationLessThanMs = 240000;
    public static final long trimMemoryLibrarySnapshotCacheExpirationLessThanMs = 30000;
    public static final long trimMemoryLibraryTitleCacheExpirationLessThanMs = 30000;
    public static final long trimMemoryPlatformThumbnailCacheExpirationLessThanMs = 240000;
    public static final long trimMemoryPlatformWallpaperCacheExpirationLessThanMs = 240000;
    public static final String uUIDFilename = "daijishou_uuid.txt";
    public static final long videoDelayMs = 1200;
    public static final String wallpaperFilename = "wallpaper.png";
    public static final long widgetBorderAnimationDuration = 200;
    public static final float widgetMaxBorderColorMixRatio = 0.95f;
    public static final float widgetMinBorderColorMixRatio = 0.25f;
    public static final float widgetTargetWidth = 125.0f;
    public static final float widgetThemeBorderColorMixRatio = 1.0f;
    public static final int widgetThumbnailQuality = 100;
    public static final int widgetThumbnailShortEdgeBase = 256;
    public static final float youtubeStartSeconds = 90.0f;
    public static final Constants INSTANCE = new Constants();
    private static final Regex aspectRatioRegex = new Regex("^([0-9]*[.])?[0-9]+:([0-9]*[.])?[0-9]+$");
    private static final long retroAchievementsRefreshIntervalDefinition = DurationKt.toDuration(30, DurationUnit.SECONDS);
    private static final long recentDurationDefinition = DurationKt.toDuration(7, DurationUnit.DAYS);
    private static final long newlyDurationDefinition = DurationKt.toDuration(1, DurationUnit.DAYS);
    private static final Bitmap.CompressFormat platformWallpaperFormat = Bitmap.CompressFormat.PNG;
    private static final String platformWallpaperFormatExtension = "png";
    private static final Bitmap.CompressFormat platformThumbnailFormat = Bitmap.CompressFormat.PNG;
    private static final String platformThumbnailFormatExtension = "png";
    private static final Bitmap.CompressFormat widgetThumbnailFormat = Bitmap.CompressFormat.PNG;
    private static final String widgetThumbnailFormatExtension = "png";
    private static final Bitmap.CompressFormat scraperFormat = Bitmap.CompressFormat.PNG;
    private static final Regex toGenericNameRegex = new Regex("^\\s*([^(|)\\[}]*[^\\s|()\\[}])\\s*(?:\\(.*\\))*(?:\\[.*])*(?:\\.)*.*$");
    private static final Regex discIndexRegex = new Regex("^.*\\(\\s*disc\\s*(\\d+)\\s*\\).*$", RegexOption.IGNORE_CASE);
    private static final List<Integer> themes = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.style.Theme_DaijishouPurpleMonotonic), Integer.valueOf(R.style.Theme_DaijishouPurpleMonotonic), Integer.valueOf(R.style.Theme_DaijishouYellowMonotonic), Integer.valueOf(R.style.Theme_DaijishouYellowMonotonic), Integer.valueOf(R.style.Theme_DaijishouRedMonotonic), Integer.valueOf(R.style.Theme_DaijishouRedMonotonic), Integer.valueOf(R.style.Theme_DaijishouBlueMonotonic), Integer.valueOf(R.style.Theme_DaijishouBlueMonotonic), Integer.valueOf(R.style.Theme_DaijishouPinkMonotonic), Integer.valueOf(R.style.Theme_DaijishouPinkMonotonic), Integer.valueOf(R.style.Theme_DaijishouBlueGreyMonotonic), Integer.valueOf(R.style.Theme_DaijishouBlueGreyMonotonic), Integer.valueOf(R.style.Theme_DaijishouGrey), Integer.valueOf(R.style.Theme_DaijishouGreyMonotonic), Integer.valueOf(R.style.Theme_DaijishouGreen), Integer.valueOf(R.style.Theme_DaijishouSuperGreen)});
    private static final List<String> themeNames = CollectionsKt.listOf(new String[]{"Purple", "Purple (Monotonic)", "Yellow", "Yellow (Monotonic)", "Red", "Red (Monotonic)", "Blue", "Blue (Monotonic)", "Pink", "Pink (Monotonic)", "BlueGrey", "BlueGrey (Monotonic)", "Grey", "Grey (Monotonic)", "Green", "Super Green"});
    public static final String defaultThemeId = "purple";
    private static final List<String> themeIds = CollectionsKt.listOf(new String[]{defaultThemeId, "purple_monotonic", "yellow", "yellow_monotonic", "red", "red_monotonic", "blue", "blue_monotonic", "pink", "pink_monotonic", "blue_grey", "blue_grey_monotonic", "grey", "grey_monotonic", "green", "super_green"});
    private static final List<Integer> sounds = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.raw.timber), Integer.valueOf(R.raw.jungle), Integer.valueOf(R.raw.ting), Integer.valueOf(R.raw.bounce), Integer.valueOf(R.raw.bounce2), Integer.valueOf(R.raw.bubble), Integer.valueOf(R.raw.string), Integer.valueOf(R.raw.wooden)});
    private static final List<String> soundNames = CollectionsKt.listOf(new String[]{"Timber", "Jungle", "Ting", "Bounce", "Bounce 2", "Bubble", "String", "Wooden"});
    public static final String defaultSelectButtonSoundId = "5";
    public static final String defaultBackButtonSoundId = "6";
    private static final List<String> soundIds = CollectionsKt.listOf(new String[]{"0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", defaultSelectButtonSoundId, defaultBackButtonSoundId, "7"});
    private static final HashMap<String, String> packageNameToDisplayNameHashMap = MapsKt.hashMapOf(TuplesKt.to("com.retroarch", "RetroArch"), TuplesKt.to("com.retroarch.aarch64", "RetroArch 64"), TuplesKt.to("org.ppsspp.ppsspp", "PPSSPP"), TuplesKt.to("org.ppsspp.ppssppgold", "PPSSPP Gold"), TuplesKt.to("com.dsemu.drastic", "Drastic"));
    private static final ArrayList<UpgradeScript> upgradeScripts = CollectionsKt.arrayListOf(new UpgradeScript60(), new UpgradeScript64(), new UpgradeScript67(), new UpgradeScript69(), new UpgradeScript73(), new UpgradeScript402(), new ClearDisjointedEventsUpgradeScript(), new PlatformsForeverUpgradeScript(), new SyncEntirelyUpgradeScript(), new UpdateEveryPlatformUpgradeScript(), new ForeverUpgradeScript());
    private static final List<Integer> secretComboKeyList = CollectionsKt.listOf(new Integer[]{19, 19, 20, 20, 21, 22, 21, 22, 19, 19, 20, 20, 21, 22, 21, 22});
    private static final List<String> trivialWords = CollectionsKt.listOf(new String[]{"the", "a", "of", "-", CollectionUtils.COMMA, BranchConfig.LOCAL_REPOSITORY});
    private static final Regex trivialRegex = new Regex("^(?:\\d{0,2}|[^\\d]{0,3})$");

    private Constants() {
    }

    public final Regex getAspectRatioRegex() {
        return aspectRatioRegex;
    }

    /* INFO: renamed from: getRetroAchievementsRefreshIntervalDefinition-UwyO8pc, reason: not valid java name */
    public final long m3493getRetroAchievementsRefreshIntervalDefinitionUwyO8pc() {
        return retroAchievementsRefreshIntervalDefinition;
    }

    /* INFO: renamed from: getRecentDurationDefinition-UwyO8pc, reason: not valid java name */
    public final long m3492getRecentDurationDefinitionUwyO8pc() {
        return recentDurationDefinition;
    }

    /* INFO: renamed from: getNewlyDurationDefinition-UwyO8pc, reason: not valid java name */
    public final long m3491getNewlyDurationDefinitionUwyO8pc() {
        return newlyDurationDefinition;
    }

    public final Bitmap.CompressFormat getPlatformWallpaperFormat() {
        return platformWallpaperFormat;
    }

    public final String getPlatformWallpaperFormatExtension() {
        return platformWallpaperFormatExtension;
    }

    public final Bitmap.CompressFormat getPlatformThumbnailFormat() {
        return platformThumbnailFormat;
    }

    public final String getPlatformThumbnailFormatExtension() {
        return platformThumbnailFormatExtension;
    }

    public final Bitmap.CompressFormat getWidgetThumbnailFormat() {
        return widgetThumbnailFormat;
    }

    public final String getWidgetThumbnailFormatExtension() {
        return widgetThumbnailFormatExtension;
    }

    public final Bitmap.CompressFormat getScraperFormat() {
        return scraperFormat;
    }

    public final Regex getToGenericNameRegex() {
        return toGenericNameRegex;
    }

    public final Regex getDiscIndexRegex() {
        return discIndexRegex;
    }

    public final List<Integer> getThemes() {
        return themes;
    }

    public final List<String> getThemeNames() {
        return themeNames;
    }

    public final List<String> getThemeIds() {
        return themeIds;
    }

    public final List<Integer> getSounds() {
        return sounds;
    }

    public final List<String> getSoundNames() {
        return soundNames;
    }

    public final List<String> getSoundIds() {
        return soundIds;
    }

    public final HashMap<String, String> getPackageNameToDisplayNameHashMap() {
        return packageNameToDisplayNameHashMap;
    }

    public final ArrayList<UpgradeScript> getUpgradeScripts() {
        return upgradeScripts;
    }

    public final List<Integer> getSecretComboKeyList() {
        return secretComboKeyList;
    }

    public final List<String> getTrivialWords() {
        return trivialWords;
    }

    public final Regex getTrivialRegex() {
        return trivialRegex;
    }
}
