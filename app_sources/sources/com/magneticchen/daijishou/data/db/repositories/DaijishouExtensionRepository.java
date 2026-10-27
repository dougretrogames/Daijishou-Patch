package com.magneticchen.daijishou.data.db.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.db.ExtensionDatabase;
import com.magneticchen.daijishou.data.db.dao.ExtensionDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO;
import com.magneticchen.daijishou.data.db.entity.ExtensionDataEntity;
import com.magneticchen.daijishou.data.db.entity.ExtensionDependencyPairEntity;
import com.magneticchen.daijishou.data.db.entity.ExtensionEntity;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryEntity;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionEntity;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToAuthorPairEntity;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToCategoryPairEntity;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToKeywordPairEntity;
import com.magneticchen.daijishou.data.db.entity.ExtensionToPermissionPairEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DaijishouExtensionRepository.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0016\n\u0002\bH\u0018\u00002\u00020\u0001:\u0002ì\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"J%\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0$2\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&\"\u00020'¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020'J%\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001d0$2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0&\"\u00020-¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020-J%\u00101\u001a\b\u0012\u0004\u0012\u00020\u001d0$2\u0012\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u0002030&\"\u000203¢\u0006\u0002\u00104J\u000e\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u000203J%\u00107\u001a\b\u0012\u0004\u0012\u00020\u001d0$2\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u0002090&\"\u000209¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u000209J%\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001d0$2\u0012\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u00020?0&\"\u00020?¢\u0006\u0002\u0010@J\u000e\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020?J%\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001d0$2\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020E0&\"\u00020E¢\u0006\u0002\u0010FJ\u000e\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020EJ\u000e\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020KJ%\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001d0$2\u0012\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u00020K0&\"\u00020K¢\u0006\u0002\u0010NJ%\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001d0$2\u0012\u0010P\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0&\"\u00020\u001f¢\u0006\u0002\u0010QJ%\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001d0$2\u0012\u0010S\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0&\"\u00020\"¢\u0006\u0002\u0010TJ\u0006\u0010U\u001a\u00020VJ\f\u0010W\u001a\b\u0012\u0004\u0012\u00020Y0XJ\u0006\u0010Z\u001a\u00020YJ\u0014\u0010[\u001a\b\u0012\u0004\u0012\u00020Y0X2\u0006\u0010\\\u001a\u00020\u0005J\u000e\u0010]\u001a\u00020Y2\u0006\u0010\\\u001a\u00020\u0005J\u0014\u0010^\u001a\b\u0012\u0004\u0012\u00020Y0X2\u0006\u0010\\\u001a\u00020\u0005J\u000e\u0010_\u001a\u00020Y2\u0006\u0010\\\u001a\u00020\u0005J\u000e\u0010`\u001a\u00020V2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010a\u001a\u00020V2\u0006\u0010!\u001a\u00020\"J\u001f\u0010b\u001a\u00020V2\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&\"\u00020'¢\u0006\u0002\u0010cJ\u000e\u0010d\u001a\u00020V2\u0006\u0010*\u001a\u00020'J\u001f\u0010e\u001a\u00020V2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0&\"\u00020-¢\u0006\u0002\u0010fJ\u000e\u0010g\u001a\u00020V2\u0006\u00100\u001a\u00020-J\u001f\u0010h\u001a\u00020V2\u0012\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u0002030&\"\u000203¢\u0006\u0002\u0010iJ\u000e\u0010j\u001a\u00020V2\u0006\u00106\u001a\u000203J\u001f\u0010k\u001a\u00020V2\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u0002090&\"\u000209¢\u0006\u0002\u0010lJ\u000e\u0010m\u001a\u00020V2\u0006\u0010<\u001a\u000209J\u001f\u0010n\u001a\u00020V2\u0012\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u00020?0&\"\u00020?¢\u0006\u0002\u0010oJ\u000e\u0010p\u001a\u00020V2\u0006\u0010B\u001a\u00020?J\u001f\u0010q\u001a\u00020V2\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020E0&\"\u00020E¢\u0006\u0002\u0010rJ\u000e\u0010s\u001a\u00020V2\u0006\u0010H\u001a\u00020EJ\u000e\u0010t\u001a\u00020V2\u0006\u0010J\u001a\u00020KJ\u001f\u0010u\u001a\u00020V2\u0012\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u00020K0&\"\u00020K¢\u0006\u0002\u0010vJ\u000e\u0010w\u001a\u00020V2\u0006\u0010x\u001a\u00020\u0005J\u001f\u0010y\u001a\u00020V2\u0012\u0010P\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0&\"\u00020\u001f¢\u0006\u0002\u0010zJ\u001f\u0010{\u001a\u00020V2\u0012\u0010S\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0&\"\u00020\"¢\u0006\u0002\u0010|J\u001a\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0$0X2\u0006\u0010~\u001a\u00020\u0005J\u001a\u0010\u007f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0$0X2\u0006\u0010~\u001a\u00020\u0005J\u0013\u0010\u0080\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050$0XJ\r\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050$J\u0013\u0010\u0082\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030$0XJ\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u0002030$J\u0013\u0010\u0084\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0$0XJ\r\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0$J!\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010$2\u0006\u0010\\\u001a\u00020\u00052\t\b\u0002\u0010\u0088\u0001\u001a\u00020YJ!\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010$2\u0006\u0010\\\u001a\u00020\u00052\t\b\u0002\u0010\u0088\u0001\u001a\u00020YJ\u0013\u0010\u008a\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0$0XJ\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0$J\u0017\u0010\u008c\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0X2\u0006\u0010\\\u001a\u00020\u0005J\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\\\u001a\u00020\u0005J \u0010\u008e\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0X2\u0006\u0010x\u001a\u00020\u001d2\u0007\u0010\u008f\u0001\u001a\u00020\u0005J\u001a\u0010\u0090\u0001\u001a\u0004\u0018\u00010\"2\u0006\u0010x\u001a\u00020\u001d2\u0007\u0010\u008f\u0001\u001a\u00020\u0005J\u0017\u0010\u0091\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0X2\u0006\u0010\\\u001a\u00020\u001dJ\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010\"2\u0006\u0010\\\u001a\u00020\u001dJ\u001b\u0010\u0093\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0$0X2\u0006\u0010x\u001a\u00020\u001dJ\u0015\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\"0$2\u0006\u0010x\u001a\u00020\u001dJ.\u0010\u0095\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0$0X2\u0013\u0010\u0096\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050&\"\u00020\u0005¢\u0006\u0003\u0010\u0097\u0001J(\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020'0$2\u0013\u0010\u0096\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050&\"\u00020\u0005¢\u0006\u0003\u0010\u0099\u0001J\u001b\u0010\u009a\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0$0X2\u0006\u0010\\\u001a\u00020\u0005J\u0015\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020'0$2\u0006\u0010\\\u001a\u00020\u0005J.\u0010\u009c\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0$0X2\u0013\u0010\u009d\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050&\"\u00020\u0005¢\u0006\u0003\u0010\u0097\u0001J(\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020'0$2\u0013\u0010\u009d\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050&\"\u00020\u0005¢\u0006\u0003\u0010\u0099\u0001J\u001b\u0010\u009f\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0$0X2\u0006\u0010\\\u001a\u00020\u0005J\u0015\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020'0$2\u0006\u0010\\\u001a\u00020\u0005J.\u0010¡\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0$0X2\u0013\u0010\u009d\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050&\"\u00020\u0005¢\u0006\u0003\u0010\u0097\u0001J(\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020'0$2\u0013\u0010\u009d\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050&\"\u00020\u0005¢\u0006\u0003\u0010\u0099\u0001J\u0017\u0010£\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0X2\u0006\u0010\\\u001a\u00020\u001dJ\u001d\u0010¤\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0X2\f\u0010\u009d\u0001\u001a\u00030¥\u0001\"\u00020\u001dJ\u0011\u0010¦\u0001\u001a\u0004\u0018\u00010'2\u0006\u0010\\\u001a\u00020\u001dJ\u0017\u0010§\u0001\u001a\u0004\u0018\u00010'2\f\u0010\u009d\u0001\u001a\u00030¥\u0001\"\u00020\u001dJ \u0010¨\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0X2\u0007\u0010©\u0001\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u0005J\u001a\u0010ª\u0001\u001a\u0004\u0018\u00010-2\u0007\u0010©\u0001\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u0005J\u0017\u0010«\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001030X2\u0006\u0010\\\u001a\u00020\u001dJ\u0011\u0010¬\u0001\u001a\u0004\u0018\u0001032\u0006\u0010\\\u001a\u00020\u001dJ\u001b\u0010\u00ad\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0$0X2\u0006\u0010x\u001a\u00020\u0005J\u0015\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020-0$2\u0006\u0010x\u001a\u00020\u0005J\u001c\u0010¯\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0$0X2\u0007\u0010©\u0001\u001a\u00020\u0005J\u0016\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020-0$2\u0007\u0010©\u0001\u001a\u00020\u0005J\u0017\u0010±\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0X2\u0006\u0010\\\u001a\u00020\u001dJ\u0011\u0010²\u0001\u001a\u0004\u0018\u00010-2\u0006\u0010\\\u001a\u00020\u001dJ\u001c\u0010³\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090$0X2\u0007\u0010´\u0001\u001a\u00020\u0005J\u0016\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u0002090$2\u0007\u0010´\u0001\u001a\u00020\u0005J$\u0010¶\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090$0X2\u0007\u0010©\u0001\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u0005J\u001e\u0010·\u0001\u001a\b\u0012\u0004\u0012\u0002090$2\u0007\u0010©\u0001\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u0005J\u0017\u0010¸\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090X2\u0006\u0010\\\u001a\u00020\u001dJ\u0011\u0010¹\u0001\u001a\u0004\u0018\u0001092\u0006\u0010\\\u001a\u00020\u001dJ\u001c\u0010º\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0$0X2\u0007\u0010»\u0001\u001a\u00020\u0005J\u001c\u0010¼\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0$0X2\u0007\u0010»\u0001\u001a\u00020\u0005J$\u0010½\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0$0X2\u0007\u0010©\u0001\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u0005J\u001e\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020?0$2\u0007\u0010©\u0001\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u0005J\u0017\u0010¿\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?0X2\u0006\u0010\\\u001a\u00020\u001dJ\u0011\u0010À\u0001\u001a\u0004\u0018\u00010?2\u0006\u0010\\\u001a\u00020\u001dJ\u001c\u0010Á\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0$0X2\u0007\u0010Â\u0001\u001a\u00020\u0005J\u0016\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020E0$2\u0007\u0010Â\u0001\u001a\u00020\u0005J$\u0010Ä\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0$0X2\u0007\u0010©\u0001\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u0005J\u001e\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020E0$2\u0007\u0010©\u0001\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u0005J\u0017\u0010Æ\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E0X2\u0006\u0010\\\u001a\u00020\u001dJ\u0011\u0010Ç\u0001\u001a\u0004\u0018\u00010E2\u0006\u0010\\\u001a\u00020\u001dJ\u0017\u0010È\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010K0X2\u0006\u0010\\\u001a\u00020\u001dJ\u0011\u0010É\u0001\u001a\u0004\u0018\u00010K2\u0006\u0010\\\u001a\u00020\u001dJ\u001b\u0010Ê\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0$0X2\u0006\u0010\\\u001a\u00020\u0005J\u0015\u0010Ë\u0001\u001a\b\u0012\u0004\u0012\u00020K0$2\u0006\u0010\\\u001a\u00020\u0005J\u001c\u0010Ì\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0$0X2\u0007\u0010Í\u0001\u001a\u00020\u0005J\u0016\u0010Î\u0001\u001a\b\u0012\u0004\u0012\u00020K0$2\u0007\u0010Í\u0001\u001a\u00020\u0005J\u0013\u0010Ï\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0$0XJ\r\u0010Ð\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0$J\u0013\u0010Ñ\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0$0XJ\r\u0010Ò\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0$J\u0013\u0010Ó\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0$0XJ\u0007\u0010Ô\u0001\u001a\u00020VJ\r\u0010Õ\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0$J;\u0010Ö\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050$2\u0013\u0010×\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050&\"\u00020\u00052\u0011\b\u0002\u0010Ø\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010$¢\u0006\u0003\u0010Ù\u0001J\u000f\u0010Ú\u0001\u001a\u00020V2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000f\u0010Û\u0001\u001a\u00020V2\u0006\u0010!\u001a\u00020\"J \u0010Ü\u0001\u001a\u00020V2\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&\"\u00020'¢\u0006\u0002\u0010cJ\u000f\u0010Ý\u0001\u001a\u00020V2\u0006\u0010*\u001a\u00020'J \u0010Þ\u0001\u001a\u00020V2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0&\"\u00020-¢\u0006\u0002\u0010fJ\u000f\u0010ß\u0001\u001a\u00020V2\u0006\u00100\u001a\u00020-J \u0010à\u0001\u001a\u00020V2\u0012\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u0002030&\"\u000203¢\u0006\u0002\u0010iJ\u000f\u0010á\u0001\u001a\u00020V2\u0006\u00106\u001a\u000203J \u0010â\u0001\u001a\u00020V2\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u0002090&\"\u000209¢\u0006\u0002\u0010lJ\u000f\u0010ã\u0001\u001a\u00020V2\u0006\u0010<\u001a\u000209J \u0010ä\u0001\u001a\u00020V2\u0012\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u00020?0&\"\u00020?¢\u0006\u0002\u0010oJ\u000f\u0010å\u0001\u001a\u00020V2\u0006\u0010B\u001a\u00020?J \u0010æ\u0001\u001a\u00020V2\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020E0&\"\u00020E¢\u0006\u0002\u0010rJ\u000f\u0010ç\u0001\u001a\u00020V2\u0006\u0010H\u001a\u00020EJ\u000f\u0010è\u0001\u001a\u00020V2\u0006\u0010J\u001a\u00020KJ \u0010é\u0001\u001a\u00020V2\u0012\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u00020K0&\"\u00020K¢\u0006\u0002\u0010vJ \u0010ê\u0001\u001a\u00020V2\u0012\u0010P\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0&\"\u00020\u001f¢\u0006\u0002\u0010zJ \u0010ë\u0001\u001a\u00020V2\u0012\u0010S\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0&\"\u00020\"¢\u0006\u0002\u0010|R\u000e\u0010\u0002\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006í\u0001"}, d2 = {"Lcom/magneticchen/daijishou/data/db/repositories/DaijishouExtensionRepository;", "", "application", "Landroid/app/Application;", "databaseName", "", "(Landroid/app/Application;Ljava/lang/String;)V", "Lcom/magneticchen/daijishou/DaijishouApplication;", "database", "Lcom/magneticchen/daijishou/data/db/ExtensionDatabase;", "extensionDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionDAO;", "extensionDataDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionDataDAO;", "extensionDependencyPairDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionDependencyPairDAO;", "extensionRepositoryDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryDAO;", "extensionRepositoryExtensionDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryExtensionDAO;", "extensionRepositoryExtensionToAuthorPairDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryExtensionToAuthorPairDAO;", "extensionRepositoryExtensionToCategoryPairDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryExtensionToCategoryPairDAO;", "extensionRepositoryExtensionToKeywordPairDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryExtensionToKeywordPairDAO;", "extensionToPermissionPairDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionToPermissionPairDAO;", "addExtension", "", "extensionEntity", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionEntity;", "addExtensionData", "extensionDataEntity", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionDataEntity;", "addExtensionDependencies", "", "extensionDependencyPairEntities", "", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionDependencyPairEntity;", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionDependencyPairEntity;)Ljava/util/List;", "addExtensionDependency", "extensionDependencyPairEntity", "addExtensionRepositories", "extensionRepositoryExtensionEntities", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionEntity;", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionEntity;)Ljava/util/List;", "addExtensionRepository", "extensionRepositoryExtensionEntity", "addExtensionRepositoryEntities", "extensionRepositoryEntities", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryEntity;", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryEntity;)Ljava/util/List;", "addExtensionRepositoryEntity", "extensionRepositoryEntity", "addExtensionRepositoryExtensionToAuthorPairEntities", "extensionRepositoryExtensionToAuthorPairEntities", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToAuthorPairEntity;", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToAuthorPairEntity;)Ljava/util/List;", "addExtensionRepositoryExtensionToAuthorPairEntity", "extensionRepositoryExtensionToAuthorPairEntity", "addExtensionRepositoryExtensionToCategoryPairEntities", "extensionRepositoryExtensionToCategoryPairEntities", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToCategoryPairEntity;", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToCategoryPairEntity;)Ljava/util/List;", "addExtensionRepositoryExtensionToCategoryPairEntity", "extensionRepositoryExtensionToCategoryPairEntity", "addExtensionRepositoryExtensionToKeywordPairEntities", "extensionRepositoryExtensionToKeywordPairEntities", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToKeywordPairEntity;", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToKeywordPairEntity;)Ljava/util/List;", "addExtensionRepositoryExtensionToKeywordPairEntity", "extensionRepositoryExtensionToKeywordPairEntity", "addExtensionToPermissionPair", "extensionToPermissionPairEntity", "Lcom/magneticchen/daijishou/data/db/entity/ExtensionToPermissionPairEntity;", "addExtensionToPermissionPairs", "extensionToPermissionPairEntities", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionToPermissionPairEntity;)Ljava/util/List;", "addExtensions", "extensionEntities", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionEntity;)Ljava/util/List;", "addListOfExtensionData", "extensionDataEntities", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionDataEntity;)Ljava/util/List;", "clearAll", "", "countAllExtensions", "Landroidx/lifecycle/LiveData;", "", "countAllExtensionsStatically", "countExtensionDependenciesByProviderExtensionId", "id", "countExtensionDependenciesByProviderExtensionIdStatically", "countExtensionDependenciesByRequirerExtensionId", "countExtensionDependenciesByRequirerExtensionIdStatically", "deleteExtension", "deleteExtensionData", "deleteExtensionDependencies", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionDependencyPairEntity;)V", "deleteExtensionDependency", "deleteExtensionRepositories", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionEntity;)V", "deleteExtensionRepository", "deleteExtensionRepositoryEntities", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryEntity;)V", "deleteExtensionRepositoryEntity", "deleteExtensionRepositoryExtensionToAuthorPairEntities", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToAuthorPairEntity;)V", "deleteExtensionRepositoryExtensionToAuthorPairEntity", "deleteExtensionRepositoryExtensionToCategoryPairEntities", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToCategoryPairEntity;)V", "deleteExtensionRepositoryExtensionToCategoryPairEntity", "deleteExtensionRepositoryExtensionToKeywordPairEntities", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionRepositoryExtensionToKeywordPairEntity;)V", "deleteExtensionRepositoryExtensionToKeywordPairEntity", "deleteExtensionToPermissionPair", "deleteExtensionToPermissionPairs", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionToPermissionPairEntity;)V", "deleteExtensionToPermissionPairsByExtensionId", "extensionId", "deleteExtensions", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionEntity;)V", "deleteListOfExtensionData", "([Lcom/magneticchen/daijishou/data/db/entity/ExtensionDataEntity;)V", "findExtensionRepositoryExtensionToKeywordPairEntitiesWithKeyword", "search", "findExtensionRepositoryExtensionToKeywordPairEntitiesWithKeywordStatically", "getAllExtensionIds", "getAllExtensionIdsStatically", "getAllExtensionRepositoryEntities", "getAllExtensionRepositoryEntitiesStatically", "getAllExtensions", "getAllExtensionsStatically", "getDeepProviderDependenciesByRequirerId", "Lcom/magneticchen/daijishou/data/db/repositories/DaijishouExtensionRepository$DeepDependency;", "level", "getDeepRequirerDependenciesByProviderId", "getEnabledExtensions", "getEnabledExtensionsStatically", "getExtensionById", "getExtensionByIdStatically", "getExtensionDataByExtensionIdAndKey", "keyString", "getExtensionDataByExtensionIdAndKeyStatically", "getExtensionDataById", "getExtensionDataByIdStatically", "getExtensionDataListByExtensionId", "getExtensionDataListByExtensionIdStatically", "getExtensionDependenciesByBothExtensionIdsContainedInExtensionIdList", "extensionIds", "([Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "getExtensionDependenciesByBothExtensionIdsContainedInExtensionIdListStatically", "([Ljava/lang/String;)Ljava/util/List;", "getExtensionDependenciesByProviderExtensionId", "getExtensionDependenciesByProviderExtensionIdStatically", "getExtensionDependenciesByProviderExtensionIds", "ids", "getExtensionDependenciesByProviderExtensionIdsStatically", "getExtensionDependenciesByRequirerExtensionId", "getExtensionDependenciesByRequirerExtensionIdStatically", "getExtensionDependenciesByRequirerExtensionIds", "getExtensionDependenciesByRequirerExtensionIdsStatically", "getExtensionDependencyById", "getExtensionDependencyByIds", "", "getExtensionDependencyIdStatically", "getExtensionDependencyIdsStatically", "getExtensionRepositoryByRepositoryIdAndExtensionId", "repositoryId", "getExtensionRepositoryByRepositoryIdAndExtensionIdStatically", "getExtensionRepositoryEntityById", "getExtensionRepositoryEntityByIdStatically", "getExtensionRepositoryExtensionEntitiesByExtensionId", "getExtensionRepositoryExtensionEntitiesByExtensionIdStatically", "getExtensionRepositoryExtensionEntitiesByRepositoryId", "getExtensionRepositoryExtensionEntitiesByRepositoryIdStatically", "getExtensionRepositoryExtensionEntityById", "getExtensionRepositoryExtensionEntityByIdStatically", "getExtensionRepositoryExtensionToAuthorPairEntitiesByEmail", "email", "getExtensionRepositoryExtensionToAuthorPairEntitiesByEmailStatically", "getExtensionRepositoryExtensionToAuthorPairEntitiesByRepositoryIdAndExtensionId", "getExtensionRepositoryExtensionToAuthorPairEntitiesByRepositoryIdAndExtensionIdStatically", "getExtensionRepositoryExtensionToAuthorPairEntityById", "getExtensionRepositoryExtensionToAuthorPairEntityByIdStatically", "getExtensionRepositoryExtensionToCategoryPairEntitiesByCategory", "category", "getExtensionRepositoryExtensionToCategoryPairEntitiesByCategoryStatically", "getExtensionRepositoryExtensionToCategoryPairEntitiesByRepositoryIdAndExtensionId", "getExtensionRepositoryExtensionToCategoryPairEntitiesByRepositoryIdAndExtensionIdStatically", "getExtensionRepositoryExtensionToCategoryPairEntityById", "getExtensionRepositoryExtensionToCategoryPairEntityByIdStatically", "getExtensionRepositoryExtensionToKeywordPairEntitiesByKeyword", "keyword", "getExtensionRepositoryExtensionToKeywordPairEntitiesByKeywordStatically", "getExtensionRepositoryExtensionToKeywordPairEntitiesByRepositoryIdAndExtensionId", "getExtensionRepositoryExtensionToKeywordPairEntitiesByRepositoryIdAndExtensionIdStatically", "getExtensionRepositoryExtensionToKeywordPairEntityById", "getExtensionRepositoryExtensionToKeywordPairEntityByIdStatically", "getExtensionToPermissionPairById", "getExtensionToPermissionPairByIdStatically", "getExtensionToPermissionPairsByExtensionId", "getExtensionToPermissionPairsByExtensionIdStatically", "getExtensionToPermissionPairsByPermission", "permission", "getExtensionToPermissionPairsByPermissionStatically", "getPreloadedExtensions", "getPreloadedExtensionsStatically", "getTopLevelAndEnabledExtensions", "getTopLevelAndEnabledExtensionsStatically", "getTopLevelExtensions", "getTopLevelExtensionsAndOtherExtensionsRequired", "getTopLevelExtensionsStatically", "sortExtensionIdsByDependencies", "extensionDataEntityIds", "additionalDependencies", "([Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "updateExtension", "updateExtensionData", "updateExtensionDependencies", "updateExtensionDependency", "updateExtensionRepositories", "updateExtensionRepository", "updateExtensionRepositoryEntities", "updateExtensionRepositoryEntity", "updateExtensionRepositoryExtensionToAuthorPairEntities", "updateExtensionRepositoryExtensionToAuthorPairEntity", "updateExtensionRepositoryExtensionToCategoryPairEntities", "updateExtensionRepositoryExtensionToCategoryPairEntity", "updateExtensionRepositoryExtensionToKeywordPairEntities", "updateExtensionRepositoryExtensionToKeywordPairEntity", "updateExtensionToPermissionPair", "updateExtensionToPermissionPairs", "updateExtensions", "updateListOfExtensionData", "DeepDependency", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouExtensionRepository {
    private final DaijishouApplication application;
    private final ExtensionDatabase database;
    private final String databaseName;
    private final ExtensionDAO extensionDAO;
    private final ExtensionDataDAO extensionDataDAO;
    private final ExtensionDependencyPairDAO extensionDependencyPairDAO;
    private final ExtensionRepositoryDAO extensionRepositoryDAO;
    private final ExtensionRepositoryExtensionDAO extensionRepositoryExtensionDAO;
    private final ExtensionRepositoryExtensionToAuthorPairDAO extensionRepositoryExtensionToAuthorPairDAO;
    private final ExtensionRepositoryExtensionToCategoryPairDAO extensionRepositoryExtensionToCategoryPairDAO;
    private final ExtensionRepositoryExtensionToKeywordPairDAO extensionRepositoryExtensionToKeywordPairDAO;
    private final ExtensionToPermissionPairDAO extensionToPermissionPairDAO;

    public final void getTopLevelExtensionsAndOtherExtensionsRequired() {
    }

    public DaijishouExtensionRepository(Application application, String databaseName) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        this.databaseName = databaseName;
        DaijishouApplication daijishouApplication = (DaijishouApplication) application;
        this.application = daijishouApplication;
        ExtensionDatabase companion = ExtensionDatabase.Companion.getInstance(daijishouApplication, databaseName);
        this.database = companion;
        this.extensionDAO = companion.extensionDAO();
        this.extensionDataDAO = companion.extensionDataDAO();
        this.extensionDependencyPairDAO = companion.extensionDependencyPairDAO();
        this.extensionToPermissionPairDAO = companion.extensionToPermissionPairDAO();
        this.extensionRepositoryDAO = companion.extensionRepositoryDAO();
        this.extensionRepositoryExtensionDAO = companion.extensionRepositoryExtensionDAO();
        this.extensionRepositoryExtensionToAuthorPairDAO = companion.extensionRepositoryExtensionToAuthorPairDAO();
        this.extensionRepositoryExtensionToCategoryPairDAO = companion.extensionRepositoryExtensionToCategoryPairDAO();
        this.extensionRepositoryExtensionToKeywordPairDAO = companion.extensionRepositoryExtensionToKeywordPairDAO();
    }

    public /* synthetic */ DaijishouExtensionRepository(Application application, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i & 2) != 0 ? ExtensionDatabase.DB_NAME : str);
    }

    /* JADX INFO: compiled from: DaijishouExtensionRepository.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/magneticchen/daijishou/data/db/repositories/DaijishouExtensionRepository$DeepDependency;", "", "extensionId", "", "level", "", "adjacentExtensionsId", "versionConstraint", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAdjacentExtensionsId", "()Ljava/lang/String;", "getExtensionId", "getLevel", "()I", "getVersionConstraint", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DeepDependency {
        private final String adjacentExtensionsId;
        private final String extensionId;
        private final int level;
        private final String versionConstraint;

        public static /* synthetic */ DeepDependency copy$default(DeepDependency deepDependency, String str, int i, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = deepDependency.extensionId;
            }
            if ((i2 & 2) != 0) {
                i = deepDependency.level;
            }
            if ((i2 & 4) != 0) {
                str2 = deepDependency.adjacentExtensionsId;
            }
            if ((i2 & 8) != 0) {
                str3 = deepDependency.versionConstraint;
            }
            return deepDependency.copy(str, i, str2, str3);
        }

        public final String component1() {
            return this.extensionId;
        }

        public final int component2() {
            return this.level;
        }

        public final String component3() {
            return this.adjacentExtensionsId;
        }

        public final String component4() {
            return this.versionConstraint;
        }

        public final DeepDependency copy(String extensionId, int i, String adjacentExtensionsId, String versionConstraint) {
            Intrinsics.checkNotNullParameter(extensionId, "extensionId");
            Intrinsics.checkNotNullParameter(adjacentExtensionsId, "adjacentExtensionsId");
            Intrinsics.checkNotNullParameter(versionConstraint, "versionConstraint");
            return new DeepDependency(extensionId, i, adjacentExtensionsId, versionConstraint);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DeepDependency)) {
                return false;
            }
            DeepDependency deepDependency = (DeepDependency) obj;
            return Intrinsics.areEqual(this.extensionId, deepDependency.extensionId) && this.level == deepDependency.level && Intrinsics.areEqual(this.adjacentExtensionsId, deepDependency.adjacentExtensionsId) && Intrinsics.areEqual(this.versionConstraint, deepDependency.versionConstraint);
        }

        public int hashCode() {
            return (((((this.extensionId.hashCode() * 31) + Integer.hashCode(this.level)) * 31) + this.adjacentExtensionsId.hashCode()) * 31) + this.versionConstraint.hashCode();
        }

        public String toString() {
            return "DeepDependency(extensionId=" + this.extensionId + ", level=" + this.level + ", adjacentExtensionsId=" + this.adjacentExtensionsId + ", versionConstraint=" + this.versionConstraint + ")";
        }

        public DeepDependency(String extensionId, int i, String adjacentExtensionsId, String versionConstraint) {
            Intrinsics.checkNotNullParameter(extensionId, "extensionId");
            Intrinsics.checkNotNullParameter(adjacentExtensionsId, "adjacentExtensionsId");
            Intrinsics.checkNotNullParameter(versionConstraint, "versionConstraint");
            this.extensionId = extensionId;
            this.level = i;
            this.adjacentExtensionsId = adjacentExtensionsId;
            this.versionConstraint = versionConstraint;
        }

        public final String getExtensionId() {
            return this.extensionId;
        }

        public final int getLevel() {
            return this.level;
        }

        public final String getAdjacentExtensionsId() {
            return this.adjacentExtensionsId;
        }

        public final String getVersionConstraint() {
            return this.versionConstraint;
        }
    }

    public static /* synthetic */ List getDeepRequirerDependenciesByProviderId$default(DaijishouExtensionRepository daijishouExtensionRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return daijishouExtensionRepository.getDeepRequirerDependenciesByProviderId(str, i);
    }

    public final List<DeepDependency> getDeepRequirerDependenciesByProviderId(String id2, int i) {
        Intrinsics.checkNotNullParameter(id2, "id");
        ArrayList arrayList = new ArrayList();
        List<ExtensionDependencyPairEntity> listSelectByProviderExtensionIdStatically = this.extensionDependencyPairDAO.selectByProviderExtensionIdStatically(id2);
        List<ExtensionDependencyPairEntity> list = listSelectByProviderExtensionIdStatically;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ExtensionDependencyPairEntity extensionDependencyPairEntity : list) {
            arrayList2.add(new DeepDependency(extensionDependencyPairEntity.getRequirerExtensionId(), i, id2, extensionDependencyPairEntity.getVersionConstraint()));
        }
        arrayList.addAll(arrayList2);
        Iterator<ExtensionDependencyPairEntity> it = listSelectByProviderExtensionIdStatically.iterator();
        while (it.hasNext()) {
            arrayList.addAll(getDeepRequirerDependenciesByProviderId(it.next().getRequirerExtensionId(), i + 1));
        }
        return arrayList;
    }

    public static /* synthetic */ List getDeepProviderDependenciesByRequirerId$default(DaijishouExtensionRepository daijishouExtensionRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return daijishouExtensionRepository.getDeepProviderDependenciesByRequirerId(str, i);
    }

    public final List<DeepDependency> getDeepProviderDependenciesByRequirerId(String id2, int i) {
        Intrinsics.checkNotNullParameter(id2, "id");
        ArrayList arrayList = new ArrayList();
        List<ExtensionDependencyPairEntity> listSelectByRequirerExtensionIdStatically = this.extensionDependencyPairDAO.selectByRequirerExtensionIdStatically(id2);
        List<ExtensionDependencyPairEntity> list = listSelectByRequirerExtensionIdStatically;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ExtensionDependencyPairEntity extensionDependencyPairEntity : list) {
            arrayList2.add(new DeepDependency(extensionDependencyPairEntity.getProviderExtensionId(), i, id2, extensionDependencyPairEntity.getVersionConstraint()));
        }
        arrayList.addAll(arrayList2);
        Iterator<ExtensionDependencyPairEntity> it = listSelectByRequirerExtensionIdStatically.iterator();
        while (it.hasNext()) {
            arrayList.addAll(getDeepProviderDependenciesByRequirerId(it.next().getProviderExtensionId(), i + 1));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List sortExtensionIdsByDependencies$default(DaijishouExtensionRepository daijishouExtensionRepository, String[] strArr, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        return daijishouExtensionRepository.sortExtensionIdsByDependencies(strArr, list);
    }

    public final List<String> sortExtensionIdsByDependencies(String[] extensionDataEntityIds, List<String> list) {
        Intrinsics.checkNotNullParameter(extensionDataEntityIds, "extensionDataEntityIds");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (String str : extensionDataEntityIds) {
            linkedHashMap2.put(str, 0);
        }
        List<ExtensionDependencyPairEntity> mutableList = CollectionsKt.toMutableList((Collection) this.extensionDependencyPairDAO.selectByBothExtensionIdsContainedInExtensionIdListStatically((String[]) Arrays.copyOf(extensionDataEntityIds, extensionDataEntityIds.length)));
        if (list != null) {
            mutableList.addAll(mutableList);
        }
        for (ExtensionDependencyPairEntity extensionDependencyPairEntity : mutableList) {
            String providerExtensionId = extensionDependencyPairEntity.getProviderExtensionId();
            String requirerExtensionId = extensionDependencyPairEntity.getRequirerExtensionId();
            if (!linkedHashMap.containsKey(providerExtensionId)) {
                linkedHashMap.put(providerExtensionId, new ArrayList());
            }
            List list2 = (List) linkedHashMap.get(providerExtensionId);
            if (list2 != null) {
                list2.add(requirerExtensionId);
            }
            linkedHashMap2.put(requirerExtensionId, Integer.valueOf(((Number) linkedHashMap2.getOrDefault(requirerExtensionId, 0)).intValue() + 1));
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Object entryObj : linkedHashMap2.entrySet()) {
            Map.Entry entry = (Map.Entry) entryObj;
            if (((Number) entry.getValue()).intValue() == 0) {
                linkedHashMap3.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap3.keySet().iterator();
        while (it.hasNext()) {
            arrayDeque.add((String) it.next());
        }
        ArrayList arrayList = new ArrayList();
        while (!arrayDeque.isEmpty()) {
            String str2 = (String) arrayDeque.removeFirst();
            arrayList.add(str2);
            List<String> list3 = (List) linkedHashMap.get(str2);
            if (list3 != null) {
                for (String str3 : list3) {
                    Object obj = linkedHashMap2.get(str3);
                    Intrinsics.checkNotNull(obj);
                    linkedHashMap2.put(str3, Integer.valueOf(((Number) obj).intValue() - 1));
                    Integer num = (Integer) linkedHashMap2.get(str3);
                    if (num != null && num.intValue() == 0) {
                        arrayDeque.add(str3);
                    }
                }
            }
        }
        if (arrayList.size() == linkedHashMap2.size()) {
            return arrayList;
        }
        throw new IllegalStateException("Cycle detected in dependencies");
    }

    public final void clearAll() {
        this.database.clearAllTables();
    }

    public final LiveData<Integer> countAllExtensions() {
        return this.extensionDAO.countAll();
    }

    public final int countAllExtensionsStatically() {
        return this.extensionDAO.countAllStatically();
    }

    public final LiveData<List<String>> getAllExtensionIds() {
        return this.extensionDAO.selectAllIds();
    }

    public final List<String> getAllExtensionIdsStatically() {
        return this.extensionDAO.selectAllIdsStatically();
    }

    public final LiveData<List<ExtensionEntity>> getAllExtensions() {
        return this.extensionDAO.selectAll();
    }

    public final List<ExtensionEntity> getAllExtensionsStatically() {
        return this.extensionDAO.selectAllStatically();
    }

    public final LiveData<ExtensionEntity> getExtensionById(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.extensionDAO.selectById(id2);
    }

    public final ExtensionEntity getExtensionByIdStatically(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.extensionDAO.selectByIdStatically(id2);
    }

    public final LiveData<List<ExtensionEntity>> getEnabledExtensions() {
        return this.extensionDAO.selectEnabled();
    }

    public final List<ExtensionEntity> getEnabledExtensionsStatically() {
        return this.extensionDAO.selectEnabledStatically();
    }

    public final LiveData<List<ExtensionEntity>> getPreloadedExtensions() {
        return this.extensionDAO.selectPreloaded();
    }

    public final List<ExtensionEntity> getPreloadedExtensionsStatically() {
        return this.extensionDAO.selectPreloadedStatically();
    }

    public final LiveData<List<ExtensionEntity>> getTopLevelExtensions() {
        return this.extensionDAO.selectTopLevel();
    }

    public final List<ExtensionEntity> getTopLevelExtensionsStatically() {
        return this.extensionDAO.selectTopLevelStatically();
    }

    public final LiveData<List<ExtensionEntity>> getTopLevelAndEnabledExtensions() {
        return this.extensionDAO.selectTopLevelAndEnabled();
    }

    public final List<ExtensionEntity> getTopLevelAndEnabledExtensionsStatically() {
        return this.extensionDAO.selectTopLevelAndEnabledStatically();
    }

    public final long addExtension(ExtensionEntity extensionEntity) {
        Intrinsics.checkNotNullParameter(extensionEntity, "extensionEntity");
        return this.extensionDAO.insert(extensionEntity);
    }

    public final List<Long> addExtensions(ExtensionEntity... extensionEntities) {
        Intrinsics.checkNotNullParameter(extensionEntities, "extensionEntities");
        return this.extensionDAO.insertAll((ExtensionEntity[]) Arrays.copyOf(extensionEntities, extensionEntities.length));
    }

    public final void updateExtension(ExtensionEntity extensionEntity) {
        Intrinsics.checkNotNullParameter(extensionEntity, "extensionEntity");
        this.extensionDAO.update(extensionEntity);
    }

    public final void updateExtensions(ExtensionEntity... extensionEntities) {
        Intrinsics.checkNotNullParameter(extensionEntities, "extensionEntities");
        this.extensionDAO.updateAll((ExtensionEntity[]) Arrays.copyOf(extensionEntities, extensionEntities.length));
    }

    public final void deleteExtension(ExtensionEntity extensionEntity) {
        Intrinsics.checkNotNullParameter(extensionEntity, "extensionEntity");
        this.extensionDAO.delete(extensionEntity);
    }

    public final void deleteExtensions(ExtensionEntity... extensionEntities) {
        Intrinsics.checkNotNullParameter(extensionEntities, "extensionEntities");
        this.extensionDAO.deleteAll((ExtensionEntity[]) Arrays.copyOf(extensionEntities, extensionEntities.length));
    }

    public final LiveData<ExtensionDataEntity> getExtensionDataById(long j) {
        return this.extensionDataDAO.selectById(j);
    }

    public final ExtensionDataEntity getExtensionDataByIdStatically(long j) {
        return this.extensionDataDAO.selectByIdStatically(j);
    }

    public final LiveData<List<ExtensionDataEntity>> getExtensionDataListByExtensionId(long j) {
        return this.extensionDataDAO.selectByExtensionId(j);
    }

    public final List<ExtensionDataEntity> getExtensionDataListByExtensionIdStatically(long j) {
        return this.extensionDataDAO.selectByExtensionIdStatically(j);
    }

    public final LiveData<ExtensionDataEntity> getExtensionDataByExtensionIdAndKey(long j, String keyString) {
        Intrinsics.checkNotNullParameter(keyString, "keyString");
        return this.extensionDataDAO.selectByExtensionIdAndKey(j, keyString);
    }

    public final ExtensionDataEntity getExtensionDataByExtensionIdAndKeyStatically(long j, String keyString) {
        Intrinsics.checkNotNullParameter(keyString, "keyString");
        return this.extensionDataDAO.selectByExtensionIdAndKeyStatically(j, keyString);
    }

    public final long addExtensionData(ExtensionDataEntity extensionDataEntity) {
        Intrinsics.checkNotNullParameter(extensionDataEntity, "extensionDataEntity");
        return this.extensionDataDAO.insert(extensionDataEntity);
    }

    public final List<Long> addListOfExtensionData(ExtensionDataEntity... extensionDataEntities) {
        Intrinsics.checkNotNullParameter(extensionDataEntities, "extensionDataEntities");
        return this.extensionDataDAO.insertAll((ExtensionDataEntity[]) Arrays.copyOf(extensionDataEntities, extensionDataEntities.length));
    }

    public final void updateExtensionData(ExtensionDataEntity extensionDataEntity) {
        Intrinsics.checkNotNullParameter(extensionDataEntity, "extensionDataEntity");
        this.extensionDataDAO.update(extensionDataEntity);
    }

    public final void updateListOfExtensionData(ExtensionDataEntity... extensionDataEntities) {
        Intrinsics.checkNotNullParameter(extensionDataEntities, "extensionDataEntities");
        this.extensionDataDAO.updateAll((ExtensionDataEntity[]) Arrays.copyOf(extensionDataEntities, extensionDataEntities.length));
    }

    public final void deleteExtensionData(ExtensionDataEntity extensionDataEntity) {
        Intrinsics.checkNotNullParameter(extensionDataEntity, "extensionDataEntity");
        this.extensionDataDAO.delete(extensionDataEntity);
    }

    public final void deleteListOfExtensionData(ExtensionDataEntity... extensionDataEntities) {
        Intrinsics.checkNotNullParameter(extensionDataEntities, "extensionDataEntities");
        this.extensionDataDAO.deleteAll((ExtensionDataEntity[]) Arrays.copyOf(extensionDataEntities, extensionDataEntities.length));
    }

    public final LiveData<ExtensionToPermissionPairEntity> getExtensionToPermissionPairById(long j) {
        return this.extensionToPermissionPairDAO.selectById(j);
    }

    public final ExtensionToPermissionPairEntity getExtensionToPermissionPairByIdStatically(long j) {
        return this.extensionToPermissionPairDAO.selectByIdStatically(j);
    }

    public final LiveData<List<ExtensionToPermissionPairEntity>> getExtensionToPermissionPairsByExtensionId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.extensionToPermissionPairDAO.selectByExtensionId(id2);
    }

    public final List<ExtensionToPermissionPairEntity> getExtensionToPermissionPairsByExtensionIdStatically(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.extensionToPermissionPairDAO.selectByExtensionIdStatically(id2);
    }

    public final LiveData<List<ExtensionToPermissionPairEntity>> getExtensionToPermissionPairsByPermission(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return this.extensionToPermissionPairDAO.selectByPermission(permission);
    }

    public final List<ExtensionToPermissionPairEntity> getExtensionToPermissionPairsByPermissionStatically(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return this.extensionToPermissionPairDAO.selectByPermissionStatically(permission);
    }

    public final long addExtensionToPermissionPair(ExtensionToPermissionPairEntity extensionToPermissionPairEntity) {
        Intrinsics.checkNotNullParameter(extensionToPermissionPairEntity, "extensionToPermissionPairEntity");
        return this.extensionToPermissionPairDAO.insert(extensionToPermissionPairEntity);
    }

    public final List<Long> addExtensionToPermissionPairs(ExtensionToPermissionPairEntity... extensionToPermissionPairEntities) {
        Intrinsics.checkNotNullParameter(extensionToPermissionPairEntities, "extensionToPermissionPairEntities");
        return this.extensionToPermissionPairDAO.insertAll((ExtensionToPermissionPairEntity[]) Arrays.copyOf(extensionToPermissionPairEntities, extensionToPermissionPairEntities.length));
    }

    public final void updateExtensionToPermissionPair(ExtensionToPermissionPairEntity extensionToPermissionPairEntity) {
        Intrinsics.checkNotNullParameter(extensionToPermissionPairEntity, "extensionToPermissionPairEntity");
        this.extensionToPermissionPairDAO.update(extensionToPermissionPairEntity);
    }

    public final void updateExtensionToPermissionPairs(ExtensionToPermissionPairEntity... extensionToPermissionPairEntities) {
        Intrinsics.checkNotNullParameter(extensionToPermissionPairEntities, "extensionToPermissionPairEntities");
        this.extensionToPermissionPairDAO.updateAll((ExtensionToPermissionPairEntity[]) Arrays.copyOf(extensionToPermissionPairEntities, extensionToPermissionPairEntities.length));
    }

    public final void deleteExtensionToPermissionPair(ExtensionToPermissionPairEntity extensionToPermissionPairEntity) {
        Intrinsics.checkNotNullParameter(extensionToPermissionPairEntity, "extensionToPermissionPairEntity");
        this.extensionToPermissionPairDAO.delete(extensionToPermissionPairEntity);
    }

    public final void deleteExtensionToPermissionPairs(ExtensionToPermissionPairEntity... extensionToPermissionPairEntities) {
        Intrinsics.checkNotNullParameter(extensionToPermissionPairEntities, "extensionToPermissionPairEntities");
        this.extensionToPermissionPairDAO.deleteAll((ExtensionToPermissionPairEntity[]) Arrays.copyOf(extensionToPermissionPairEntities, extensionToPermissionPairEntities.length));
    }

    public final void deleteExtensionToPermissionPairsByExtensionId(String extensionId) {
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        this.extensionToPermissionPairDAO.deleteByExtensionId(extensionId);
    }

    public final LiveData<ExtensionDependencyPairEntity> getExtensionDependencyById(long j) {
        return this.extensionDependencyPairDAO.selectById(j);
    }

    public final ExtensionDependencyPairEntity getExtensionDependencyIdStatically(long j) {
        return this.extensionDependencyPairDAO.selectByIdStatically(j);
    }

    public final LiveData<ExtensionDependencyPairEntity> getExtensionDependencyByIds(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.extensionDependencyPairDAO.selectByIds(Arrays.copyOf(ids, ids.length));
    }

    public final ExtensionDependencyPairEntity getExtensionDependencyIdsStatically(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.extensionDependencyPairDAO.selectByIdsStatically(Arrays.copyOf(ids, ids.length));
    }

    public final LiveData<List<ExtensionDependencyPairEntity>> getExtensionDependenciesByBothExtensionIdsContainedInExtensionIdList(String... extensionIds) {
        Intrinsics.checkNotNullParameter(extensionIds, "extensionIds");
        return this.extensionDependencyPairDAO.selectByBothExtensionIdsContainedInExtensionIdList((String[]) Arrays.copyOf(extensionIds, extensionIds.length));
    }

    public final List<ExtensionDependencyPairEntity> getExtensionDependenciesByBothExtensionIdsContainedInExtensionIdListStatically(String... extensionIds) {
        Intrinsics.checkNotNullParameter(extensionIds, "extensionIds");
        return this.extensionDependencyPairDAO.selectByBothExtensionIdsContainedInExtensionIdListStatically((String[]) Arrays.copyOf(extensionIds, extensionIds.length));
    }

    public final LiveData<Integer> countExtensionDependenciesByProviderExtensionId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.extensionDependencyPairDAO.countByProviderExtensionId(id2);
    }

    public final int countExtensionDependenciesByProviderExtensionIdStatically(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.extensionDependencyPairDAO.countByProviderExtensionIdStatically(id2);
    }

    public final LiveData<List<ExtensionDependencyPairEntity>> getExtensionDependenciesByProviderExtensionId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.extensionDependencyPairDAO.selectByProviderExtensionId(id2);
    }

    public final List<ExtensionDependencyPairEntity> getExtensionDependenciesByProviderExtensionIdStatically(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.extensionDependencyPairDAO.selectByProviderExtensionIdStatically(id2);
    }

    public final LiveData<List<ExtensionDependencyPairEntity>> getExtensionDependenciesByProviderExtensionIds(String... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.extensionDependencyPairDAO.selectByProviderExtensionIds((String[]) Arrays.copyOf(ids, ids.length));
    }

    public final List<ExtensionDependencyPairEntity> getExtensionDependenciesByProviderExtensionIdsStatically(String... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.extensionDependencyPairDAO.selectByProviderExtensionIdsStatically((String[]) Arrays.copyOf(ids, ids.length));
    }

    public final LiveData<Integer> countExtensionDependenciesByRequirerExtensionId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.extensionDependencyPairDAO.countByRequirerExtensionId(id2);
    }

    public final int countExtensionDependenciesByRequirerExtensionIdStatically(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.extensionDependencyPairDAO.countByRequirerExtensionIdStatically(id2);
    }

    public final LiveData<List<ExtensionDependencyPairEntity>> getExtensionDependenciesByRequirerExtensionId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.extensionDependencyPairDAO.selectByRequirerExtensionId(id2);
    }

    public final List<ExtensionDependencyPairEntity> getExtensionDependenciesByRequirerExtensionIdStatically(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.extensionDependencyPairDAO.selectByRequirerExtensionIdStatically(id2);
    }

    public final LiveData<List<ExtensionDependencyPairEntity>> getExtensionDependenciesByRequirerExtensionIds(String... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.extensionDependencyPairDAO.selectByRequirerExtensionIds((String[]) Arrays.copyOf(ids, ids.length));
    }

    public final List<ExtensionDependencyPairEntity> getExtensionDependenciesByRequirerExtensionIdsStatically(String... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.extensionDependencyPairDAO.selectByRequirerExtensionIdsStatically((String[]) Arrays.copyOf(ids, ids.length));
    }

    public final long addExtensionDependency(ExtensionDependencyPairEntity extensionDependencyPairEntity) {
        Intrinsics.checkNotNullParameter(extensionDependencyPairEntity, "extensionDependencyPairEntity");
        return this.extensionDependencyPairDAO.insert(extensionDependencyPairEntity);
    }

    public final List<Long> addExtensionDependencies(ExtensionDependencyPairEntity... extensionDependencyPairEntities) {
        Intrinsics.checkNotNullParameter(extensionDependencyPairEntities, "extensionDependencyPairEntities");
        return this.extensionDependencyPairDAO.insertAll((ExtensionDependencyPairEntity[]) Arrays.copyOf(extensionDependencyPairEntities, extensionDependencyPairEntities.length));
    }

    public final void updateExtensionDependency(ExtensionDependencyPairEntity extensionDependencyPairEntity) {
        Intrinsics.checkNotNullParameter(extensionDependencyPairEntity, "extensionDependencyPairEntity");
        this.extensionDependencyPairDAO.update(extensionDependencyPairEntity);
    }

    public final void updateExtensionDependencies(ExtensionDependencyPairEntity... extensionDependencyPairEntities) {
        Intrinsics.checkNotNullParameter(extensionDependencyPairEntities, "extensionDependencyPairEntities");
        this.extensionDependencyPairDAO.updateAll((ExtensionDependencyPairEntity[]) Arrays.copyOf(extensionDependencyPairEntities, extensionDependencyPairEntities.length));
    }

    public final void deleteExtensionDependency(ExtensionDependencyPairEntity extensionDependencyPairEntity) {
        Intrinsics.checkNotNullParameter(extensionDependencyPairEntity, "extensionDependencyPairEntity");
        this.extensionDependencyPairDAO.delete(extensionDependencyPairEntity);
    }

    public final void deleteExtensionDependencies(ExtensionDependencyPairEntity... extensionDependencyPairEntities) {
        Intrinsics.checkNotNullParameter(extensionDependencyPairEntities, "extensionDependencyPairEntities");
        this.extensionDependencyPairDAO.deleteAll((ExtensionDependencyPairEntity[]) Arrays.copyOf(extensionDependencyPairEntities, extensionDependencyPairEntities.length));
    }

    public final LiveData<ExtensionRepositoryEntity> getExtensionRepositoryEntityById(long j) {
        return this.extensionRepositoryDAO.selectById(j);
    }

    public final ExtensionRepositoryEntity getExtensionRepositoryEntityByIdStatically(long j) {
        return this.extensionRepositoryDAO.selectByIdStatically(j);
    }

    public final LiveData<List<ExtensionRepositoryEntity>> getAllExtensionRepositoryEntities() {
        return this.extensionRepositoryDAO.selectAll();
    }

    public final List<ExtensionRepositoryEntity> getAllExtensionRepositoryEntitiesStatically() {
        return this.extensionRepositoryDAO.selectAllStatically();
    }

    public final long addExtensionRepositoryEntity(ExtensionRepositoryEntity extensionRepositoryEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryEntity, "extensionRepositoryEntity");
        return this.extensionRepositoryDAO.insert(extensionRepositoryEntity);
    }

    public final List<Long> addExtensionRepositoryEntities(ExtensionRepositoryEntity... extensionRepositoryEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryEntities, "extensionRepositoryEntities");
        return this.extensionRepositoryDAO.insertAll((ExtensionRepositoryEntity[]) Arrays.copyOf(extensionRepositoryEntities, extensionRepositoryEntities.length));
    }

    public final void updateExtensionRepositoryEntity(ExtensionRepositoryEntity extensionRepositoryEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryEntity, "extensionRepositoryEntity");
        this.extensionRepositoryDAO.update(extensionRepositoryEntity);
    }

    public final void updateExtensionRepositoryEntities(ExtensionRepositoryEntity... extensionRepositoryEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryEntities, "extensionRepositoryEntities");
        this.extensionRepositoryDAO.updateAll((ExtensionRepositoryEntity[]) Arrays.copyOf(extensionRepositoryEntities, extensionRepositoryEntities.length));
    }

    public final void deleteExtensionRepositoryEntity(ExtensionRepositoryEntity extensionRepositoryEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryEntity, "extensionRepositoryEntity");
        this.extensionRepositoryDAO.delete(extensionRepositoryEntity);
    }

    public final void deleteExtensionRepositoryEntities(ExtensionRepositoryEntity... extensionRepositoryEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryEntities, "extensionRepositoryEntities");
        this.extensionRepositoryDAO.deleteAll((ExtensionRepositoryEntity[]) Arrays.copyOf(extensionRepositoryEntities, extensionRepositoryEntities.length));
    }

    public final LiveData<ExtensionRepositoryExtensionEntity> getExtensionRepositoryExtensionEntityById(long j) {
        return this.extensionRepositoryExtensionDAO.selectById(j);
    }

    public final ExtensionRepositoryExtensionEntity getExtensionRepositoryExtensionEntityByIdStatically(long j) {
        return this.extensionRepositoryExtensionDAO.selectByIdStatically(j);
    }

    public final LiveData<List<ExtensionRepositoryExtensionEntity>> getExtensionRepositoryExtensionEntitiesByExtensionId(String extensionId) {
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        return this.extensionRepositoryExtensionDAO.selectByExtensionId(extensionId);
    }

    public final List<ExtensionRepositoryExtensionEntity> getExtensionRepositoryExtensionEntitiesByExtensionIdStatically(String extensionId) {
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        return this.extensionRepositoryExtensionDAO.selectByExtensionIdStatically(extensionId);
    }

    public final LiveData<List<ExtensionRepositoryExtensionEntity>> getExtensionRepositoryExtensionEntitiesByRepositoryId(String repositoryId) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        return this.extensionRepositoryExtensionDAO.selectByRepositoryId(repositoryId);
    }

    public final List<ExtensionRepositoryExtensionEntity> getExtensionRepositoryExtensionEntitiesByRepositoryIdStatically(String repositoryId) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        return this.extensionRepositoryExtensionDAO.selectByRepositoryIdStatically(repositoryId);
    }

    public final LiveData<ExtensionRepositoryExtensionEntity> getExtensionRepositoryByRepositoryIdAndExtensionId(String repositoryId, String extensionId) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        return this.extensionRepositoryExtensionDAO.selectByRepositoryIdAndExtensionId(repositoryId, extensionId);
    }

    public final ExtensionRepositoryExtensionEntity getExtensionRepositoryByRepositoryIdAndExtensionIdStatically(String repositoryId, String extensionId) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        return this.extensionRepositoryExtensionDAO.selectByRepositoryIdAndExtensionIdStatically(repositoryId, extensionId);
    }

    public final long addExtensionRepository(ExtensionRepositoryExtensionEntity extensionRepositoryExtensionEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionEntity, "extensionRepositoryExtensionEntity");
        return this.extensionRepositoryExtensionDAO.insert(extensionRepositoryExtensionEntity);
    }

    public final List<Long> addExtensionRepositories(ExtensionRepositoryExtensionEntity... extensionRepositoryExtensionEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionEntities, "extensionRepositoryExtensionEntities");
        return this.extensionRepositoryExtensionDAO.insertAll((ExtensionRepositoryExtensionEntity[]) Arrays.copyOf(extensionRepositoryExtensionEntities, extensionRepositoryExtensionEntities.length));
    }

    public final void updateExtensionRepository(ExtensionRepositoryExtensionEntity extensionRepositoryExtensionEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionEntity, "extensionRepositoryExtensionEntity");
        this.extensionRepositoryExtensionDAO.update(extensionRepositoryExtensionEntity);
    }

    public final void updateExtensionRepositories(ExtensionRepositoryExtensionEntity... extensionRepositoryExtensionEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionEntities, "extensionRepositoryExtensionEntities");
        this.extensionRepositoryExtensionDAO.updateAll((ExtensionRepositoryExtensionEntity[]) Arrays.copyOf(extensionRepositoryExtensionEntities, extensionRepositoryExtensionEntities.length));
    }

    public final void deleteExtensionRepository(ExtensionRepositoryExtensionEntity extensionRepositoryExtensionEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionEntity, "extensionRepositoryExtensionEntity");
        this.extensionRepositoryExtensionDAO.delete(extensionRepositoryExtensionEntity);
    }

    public final void deleteExtensionRepositories(ExtensionRepositoryExtensionEntity... extensionRepositoryExtensionEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionEntities, "extensionRepositoryExtensionEntities");
        this.extensionRepositoryExtensionDAO.deleteAll((ExtensionRepositoryExtensionEntity[]) Arrays.copyOf(extensionRepositoryExtensionEntities, extensionRepositoryExtensionEntities.length));
    }

    public final LiveData<ExtensionRepositoryExtensionToAuthorPairEntity> getExtensionRepositoryExtensionToAuthorPairEntityById(long j) {
        return this.extensionRepositoryExtensionToAuthorPairDAO.selectById(j);
    }

    public final ExtensionRepositoryExtensionToAuthorPairEntity getExtensionRepositoryExtensionToAuthorPairEntityByIdStatically(long j) {
        return this.extensionRepositoryExtensionToAuthorPairDAO.selectByIdStatically(j);
    }

    public final LiveData<List<ExtensionRepositoryExtensionToAuthorPairEntity>> getExtensionRepositoryExtensionToAuthorPairEntitiesByRepositoryIdAndExtensionId(String repositoryId, String extensionId) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        return this.extensionRepositoryExtensionToAuthorPairDAO.selectByRepositoryIdAndExtensionId(repositoryId, extensionId);
    }

    public final List<ExtensionRepositoryExtensionToAuthorPairEntity> getExtensionRepositoryExtensionToAuthorPairEntitiesByRepositoryIdAndExtensionIdStatically(String repositoryId, String extensionId) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        return this.extensionRepositoryExtensionToAuthorPairDAO.selectByRepositoryIdAndExtensionIdStatically(repositoryId, extensionId);
    }

    public final LiveData<List<ExtensionRepositoryExtensionToAuthorPairEntity>> getExtensionRepositoryExtensionToAuthorPairEntitiesByEmail(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        return this.extensionRepositoryExtensionToAuthorPairDAO.selectByEmail(email);
    }

    public final List<ExtensionRepositoryExtensionToAuthorPairEntity> getExtensionRepositoryExtensionToAuthorPairEntitiesByEmailStatically(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        return this.extensionRepositoryExtensionToAuthorPairDAO.selectByEmailStatically(email);
    }

    public final long addExtensionRepositoryExtensionToAuthorPairEntity(ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToAuthorPairEntity, "extensionRepositoryExtensionToAuthorPairEntity");
        return this.extensionRepositoryExtensionToAuthorPairDAO.insert(extensionRepositoryExtensionToAuthorPairEntity);
    }

    public final List<Long> addExtensionRepositoryExtensionToAuthorPairEntities(ExtensionRepositoryExtensionToAuthorPairEntity... extensionRepositoryExtensionToAuthorPairEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToAuthorPairEntities, "extensionRepositoryExtensionToAuthorPairEntities");
        return this.extensionRepositoryExtensionToAuthorPairDAO.insertAll((ExtensionRepositoryExtensionToAuthorPairEntity[]) Arrays.copyOf(extensionRepositoryExtensionToAuthorPairEntities, extensionRepositoryExtensionToAuthorPairEntities.length));
    }

    public final void updateExtensionRepositoryExtensionToAuthorPairEntity(ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToAuthorPairEntity, "extensionRepositoryExtensionToAuthorPairEntity");
        this.extensionRepositoryExtensionToAuthorPairDAO.update(extensionRepositoryExtensionToAuthorPairEntity);
    }

    public final void updateExtensionRepositoryExtensionToAuthorPairEntities(ExtensionRepositoryExtensionToAuthorPairEntity... extensionRepositoryExtensionToAuthorPairEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToAuthorPairEntities, "extensionRepositoryExtensionToAuthorPairEntities");
        this.extensionRepositoryExtensionToAuthorPairDAO.updateAll((ExtensionRepositoryExtensionToAuthorPairEntity[]) Arrays.copyOf(extensionRepositoryExtensionToAuthorPairEntities, extensionRepositoryExtensionToAuthorPairEntities.length));
    }

    public final void deleteExtensionRepositoryExtensionToAuthorPairEntity(ExtensionRepositoryExtensionToAuthorPairEntity extensionRepositoryExtensionToAuthorPairEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToAuthorPairEntity, "extensionRepositoryExtensionToAuthorPairEntity");
        this.extensionRepositoryExtensionToAuthorPairDAO.delete(extensionRepositoryExtensionToAuthorPairEntity);
    }

    public final void deleteExtensionRepositoryExtensionToAuthorPairEntities(ExtensionRepositoryExtensionToAuthorPairEntity... extensionRepositoryExtensionToAuthorPairEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToAuthorPairEntities, "extensionRepositoryExtensionToAuthorPairEntities");
        this.extensionRepositoryExtensionToAuthorPairDAO.deleteAll((ExtensionRepositoryExtensionToAuthorPairEntity[]) Arrays.copyOf(extensionRepositoryExtensionToAuthorPairEntities, extensionRepositoryExtensionToAuthorPairEntities.length));
    }

    public final LiveData<ExtensionRepositoryExtensionToCategoryPairEntity> getExtensionRepositoryExtensionToCategoryPairEntityById(long j) {
        return this.extensionRepositoryExtensionToCategoryPairDAO.selectById(j);
    }

    public final ExtensionRepositoryExtensionToCategoryPairEntity getExtensionRepositoryExtensionToCategoryPairEntityByIdStatically(long j) {
        return this.extensionRepositoryExtensionToCategoryPairDAO.selectByIdStatically(j);
    }

    public final LiveData<List<ExtensionRepositoryExtensionToCategoryPairEntity>> getExtensionRepositoryExtensionToCategoryPairEntitiesByRepositoryIdAndExtensionId(String repositoryId, String extensionId) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        return this.extensionRepositoryExtensionToCategoryPairDAO.selectByRepositoryIdAndExtensionId(repositoryId, extensionId);
    }

    public final List<ExtensionRepositoryExtensionToCategoryPairEntity> getExtensionRepositoryExtensionToCategoryPairEntitiesByRepositoryIdAndExtensionIdStatically(String repositoryId, String extensionId) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        return this.extensionRepositoryExtensionToCategoryPairDAO.selectByRepositoryIdAndExtensionIdStatically(repositoryId, extensionId);
    }

    public final LiveData<List<ExtensionRepositoryExtensionToCategoryPairEntity>> getExtensionRepositoryExtensionToCategoryPairEntitiesByCategory(String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        return this.extensionRepositoryExtensionToCategoryPairDAO.selectByCategory(category);
    }

    public final LiveData<List<ExtensionRepositoryExtensionToCategoryPairEntity>> getExtensionRepositoryExtensionToCategoryPairEntitiesByCategoryStatically(String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        return this.extensionRepositoryExtensionToCategoryPairDAO.selectByCategory(category);
    }

    public final long addExtensionRepositoryExtensionToCategoryPairEntity(ExtensionRepositoryExtensionToCategoryPairEntity extensionRepositoryExtensionToCategoryPairEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToCategoryPairEntity, "extensionRepositoryExtensionToCategoryPairEntity");
        return this.extensionRepositoryExtensionToCategoryPairDAO.insert(extensionRepositoryExtensionToCategoryPairEntity);
    }

    public final List<Long> addExtensionRepositoryExtensionToCategoryPairEntities(ExtensionRepositoryExtensionToCategoryPairEntity... extensionRepositoryExtensionToCategoryPairEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToCategoryPairEntities, "extensionRepositoryExtensionToCategoryPairEntities");
        return this.extensionRepositoryExtensionToCategoryPairDAO.insertAll((ExtensionRepositoryExtensionToCategoryPairEntity[]) Arrays.copyOf(extensionRepositoryExtensionToCategoryPairEntities, extensionRepositoryExtensionToCategoryPairEntities.length));
    }

    public final void updateExtensionRepositoryExtensionToCategoryPairEntity(ExtensionRepositoryExtensionToCategoryPairEntity extensionRepositoryExtensionToCategoryPairEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToCategoryPairEntity, "extensionRepositoryExtensionToCategoryPairEntity");
        this.extensionRepositoryExtensionToCategoryPairDAO.update(extensionRepositoryExtensionToCategoryPairEntity);
    }

    public final void updateExtensionRepositoryExtensionToCategoryPairEntities(ExtensionRepositoryExtensionToCategoryPairEntity... extensionRepositoryExtensionToCategoryPairEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToCategoryPairEntities, "extensionRepositoryExtensionToCategoryPairEntities");
        this.extensionRepositoryExtensionToCategoryPairDAO.updateAll((ExtensionRepositoryExtensionToCategoryPairEntity[]) Arrays.copyOf(extensionRepositoryExtensionToCategoryPairEntities, extensionRepositoryExtensionToCategoryPairEntities.length));
    }

    public final void deleteExtensionRepositoryExtensionToCategoryPairEntity(ExtensionRepositoryExtensionToCategoryPairEntity extensionRepositoryExtensionToCategoryPairEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToCategoryPairEntity, "extensionRepositoryExtensionToCategoryPairEntity");
        this.extensionRepositoryExtensionToCategoryPairDAO.delete(extensionRepositoryExtensionToCategoryPairEntity);
    }

    public final void deleteExtensionRepositoryExtensionToCategoryPairEntities(ExtensionRepositoryExtensionToCategoryPairEntity... extensionRepositoryExtensionToCategoryPairEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToCategoryPairEntities, "extensionRepositoryExtensionToCategoryPairEntities");
        this.extensionRepositoryExtensionToCategoryPairDAO.deleteAll((ExtensionRepositoryExtensionToCategoryPairEntity[]) Arrays.copyOf(extensionRepositoryExtensionToCategoryPairEntities, extensionRepositoryExtensionToCategoryPairEntities.length));
    }

    public final LiveData<ExtensionRepositoryExtensionToKeywordPairEntity> getExtensionRepositoryExtensionToKeywordPairEntityById(long j) {
        return this.extensionRepositoryExtensionToKeywordPairDAO.selectById(j);
    }

    public final ExtensionRepositoryExtensionToKeywordPairEntity getExtensionRepositoryExtensionToKeywordPairEntityByIdStatically(long j) {
        return this.extensionRepositoryExtensionToKeywordPairDAO.selectByIdStatically(j);
    }

    public final LiveData<List<ExtensionRepositoryExtensionToKeywordPairEntity>> getExtensionRepositoryExtensionToKeywordPairEntitiesByRepositoryIdAndExtensionId(String repositoryId, String extensionId) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        return this.extensionRepositoryExtensionToKeywordPairDAO.selectByRepositoryIdAndExtensionId(repositoryId, extensionId);
    }

    public final List<ExtensionRepositoryExtensionToKeywordPairEntity> getExtensionRepositoryExtensionToKeywordPairEntitiesByRepositoryIdAndExtensionIdStatically(String repositoryId, String extensionId) {
        Intrinsics.checkNotNullParameter(repositoryId, "repositoryId");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        return this.extensionRepositoryExtensionToKeywordPairDAO.selectByRepositoryIdAndExtensionIdStatically(repositoryId, extensionId);
    }

    public final LiveData<List<ExtensionRepositoryExtensionToKeywordPairEntity>> getExtensionRepositoryExtensionToKeywordPairEntitiesByKeyword(String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.extensionRepositoryExtensionToKeywordPairDAO.selectByKeyword(keyword);
    }

    public final List<ExtensionRepositoryExtensionToKeywordPairEntity> getExtensionRepositoryExtensionToKeywordPairEntitiesByKeywordStatically(String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.extensionRepositoryExtensionToKeywordPairDAO.selectByKeywordStatically(keyword);
    }

    public final LiveData<List<ExtensionRepositoryExtensionToKeywordPairEntity>> findExtensionRepositoryExtensionToKeywordPairEntitiesWithKeyword(String search) {
        Intrinsics.checkNotNullParameter(search, "search");
        return this.extensionRepositoryExtensionToKeywordPairDAO.findWithKeyword(search);
    }

    public final LiveData<List<ExtensionRepositoryExtensionToKeywordPairEntity>> findExtensionRepositoryExtensionToKeywordPairEntitiesWithKeywordStatically(String search) {
        Intrinsics.checkNotNullParameter(search, "search");
        return this.extensionRepositoryExtensionToKeywordPairDAO.findWithKeyword(search);
    }

    public final long addExtensionRepositoryExtensionToKeywordPairEntity(ExtensionRepositoryExtensionToKeywordPairEntity extensionRepositoryExtensionToKeywordPairEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToKeywordPairEntity, "extensionRepositoryExtensionToKeywordPairEntity");
        return this.extensionRepositoryExtensionToKeywordPairDAO.insert(extensionRepositoryExtensionToKeywordPairEntity);
    }

    public final List<Long> addExtensionRepositoryExtensionToKeywordPairEntities(ExtensionRepositoryExtensionToKeywordPairEntity... extensionRepositoryExtensionToKeywordPairEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToKeywordPairEntities, "extensionRepositoryExtensionToKeywordPairEntities");
        return this.extensionRepositoryExtensionToKeywordPairDAO.insertAll((ExtensionRepositoryExtensionToKeywordPairEntity[]) Arrays.copyOf(extensionRepositoryExtensionToKeywordPairEntities, extensionRepositoryExtensionToKeywordPairEntities.length));
    }

    public final void updateExtensionRepositoryExtensionToKeywordPairEntity(ExtensionRepositoryExtensionToKeywordPairEntity extensionRepositoryExtensionToKeywordPairEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToKeywordPairEntity, "extensionRepositoryExtensionToKeywordPairEntity");
        this.extensionRepositoryExtensionToKeywordPairDAO.update(extensionRepositoryExtensionToKeywordPairEntity);
    }

    public final void updateExtensionRepositoryExtensionToKeywordPairEntities(ExtensionRepositoryExtensionToKeywordPairEntity... extensionRepositoryExtensionToKeywordPairEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToKeywordPairEntities, "extensionRepositoryExtensionToKeywordPairEntities");
        this.extensionRepositoryExtensionToKeywordPairDAO.updateAll((ExtensionRepositoryExtensionToKeywordPairEntity[]) Arrays.copyOf(extensionRepositoryExtensionToKeywordPairEntities, extensionRepositoryExtensionToKeywordPairEntities.length));
    }

    public final void deleteExtensionRepositoryExtensionToKeywordPairEntity(ExtensionRepositoryExtensionToKeywordPairEntity extensionRepositoryExtensionToKeywordPairEntity) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToKeywordPairEntity, "extensionRepositoryExtensionToKeywordPairEntity");
        this.extensionRepositoryExtensionToKeywordPairDAO.delete(extensionRepositoryExtensionToKeywordPairEntity);
    }

    public final void deleteExtensionRepositoryExtensionToKeywordPairEntities(ExtensionRepositoryExtensionToKeywordPairEntity... extensionRepositoryExtensionToKeywordPairEntities) {
        Intrinsics.checkNotNullParameter(extensionRepositoryExtensionToKeywordPairEntities, "extensionRepositoryExtensionToKeywordPairEntities");
        this.extensionRepositoryExtensionToKeywordPairDAO.deleteAll((ExtensionRepositoryExtensionToKeywordPairEntity[]) Arrays.copyOf(extensionRepositoryExtensionToKeywordPairEntities, extensionRepositoryExtensionToKeywordPairEntities.length));
    }
}
