package com.magneticchen.daijishou.data.db.dao;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntityMergedInfo;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PlayableItemDAO.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u0016\n\u0002\b@\n\u0002\u0018\u0002\n\u0002\b \bg\u0018\u0000 Ì\u00012\u00020\u0001:\u0002Ì\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0012\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\b\u0010\u000b\u001a\u00020\u0004H'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\r\u001a\u00020\u0004H'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000fH'J \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u001a\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u001a\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH'J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000fH'J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH'J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000fH'J \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u001a\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH'J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000fH'J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH'J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H'J(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\"\u0010$\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\"\u0010&\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H'J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H'J\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H'J(\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\"\u0010,\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J(\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\"\u0010.\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H'J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H'J\u0018\u00101\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H'J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H'J!\u00106\u001a\u0002032\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020508\"\u000205H'¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u0002032\u0006\u0010\u0010\u001a\u00020\u000fH'J\u0018\u0010;\u001a\u0002032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020=H'J&\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u0004H'J&\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u0004H'J \u0010D\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u0004H'J0\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J*\u0010F\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J0\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J*\u0010H\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J \u0010I\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u0004H'J\u0010\u0010J\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H'J'\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000f0?2\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020508\"\u000205H'¢\u0006\u0002\u0010LJ\u0014\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u0003H'J\u001e\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010O\u001a\b\u0012\u0004\u0012\u0002050?2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0014\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0?0\u0003H'J\u001e\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0?0\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010R\u001a\b\u0012\u0004\u0012\u00020\u000f0?2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u000e\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000f0?H'J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u0002050?H'J\u001c\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010\u0010\u001a\u00020\u000fH'J$\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020=H'J.\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020=2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J(\u0010X\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020=2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010Y\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020=H'J&\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J \u0010[\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0016\u0010\\\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010\u0010\u001a\u00020\u000fH'J\u001c\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010\u0010\u001a\u00020\u000fH'J&\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J \u0010_\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010\u0010\u001a\u00020\u000fH'J&\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010b\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u0004H'J0\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010b\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J*\u0010d\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010b\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J \u0010e\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010b\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u0004H'J\u0018\u0010f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00032\u0006\u0010\u0010\u001a\u00020\u000fH'J\"\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u001c\u0010h\u001a\u0004\u0018\u0001052\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0012\u0010i\u001a\u0004\u0018\u0001052\u0006\u0010\u0010\u001a\u00020\u000fH'J\u001a\u0010j\u001a\b\u0012\u0004\u0012\u0002050?2\n\u0010k\u001a\u00020l\"\u00020\u000fH'J-\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0012\u0010n\u001a\n\u0012\u0006\b\u0001\u0012\u00020A08\"\u00020AH'¢\u0006\u0002\u0010oJ7\u0010p\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0012\u0010n\u001a\n\u0012\u0006\b\u0001\u0012\u00020A08\"\u00020A2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'¢\u0006\u0002\u0010qJ1\u0010r\u001a\b\u0012\u0004\u0012\u0002050?2\u0012\u0010n\u001a\n\u0012\u0006\b\u0001\u0012\u00020A08\"\u00020A2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'¢\u0006\u0002\u0010sJ'\u0010t\u001a\b\u0012\u0004\u0012\u0002050?2\u0012\u0010n\u001a\n\u0012\u0006\b\u0001\u0012\u00020A08\"\u00020AH'¢\u0006\u0002\u0010uJ$\u0010v\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010w\u001a\u00020\u000f2\u0006\u0010b\u001a\u00020AH'J\u001e\u0010x\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010w\u001a\u00020\u000f2\u0006\u0010b\u001a\u00020AH'J.\u0010y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010w\u001a\u00020\u000f2\u0006\u0010b\u001a\u00020A2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J(\u0010z\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010w\u001a\u00020\u000f2\u0006\u0010b\u001a\u00020A2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010{\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\b\b\u0002\u0010B\u001a\u00020\u0004H'J&\u0010|\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u0004H'J0\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J*\u0010~\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J \u0010\u007f\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u0004H'J'\u0010\u0080\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010b\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u0004H'J1\u0010\u0081\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010b\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J+\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010b\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J!\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010b\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u0004H'J)\u0010\u0084\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J#\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0011\u0010\u0086\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u0003H'J\u001b\u0010\u0087\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0015\u0010\u0088\u0001\u001a\u0004\u0018\u0001052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u000b\u0010\u0089\u0001\u001a\u0004\u0018\u000105H'J1\u0010\u008a\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0007\u0010\u008b\u0001\u001a\u00020\"2\u0007\u0010\u008c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J;\u0010\u008d\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0007\u0010\u008b\u0001\u001a\u00020\"2\u0007\u0010\u008c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J5\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0007\u0010\u008b\u0001\u001a\u00020\"2\u0007\u0010\u008c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J+\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0007\u0010\u008b\u0001\u001a\u00020\"2\u0007\u0010\u008c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J\u0019\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\b\b\u0002\u0010B\u001a\u00020\u0004H'J\u001d\u0010\u0091\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0?0\u00032\u0006\u0010\u0010\u001a\u00020\u000fH'J'\u0010\u0092\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0?0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J!\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0?2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0017\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0?2\u0006\u0010\u0010\u001a\u00020\u000fH'J\u001d\u0010\u0095\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0?0\u00032\u0006\u0010\u0010\u001a\u00020\u000fH'J'\u0010\u0096\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0?0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J!\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0?2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0017\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0?2\u0006\u0010\u0010\u001a\u00020\u000fH'J\u0011\u0010\u0099\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u0003H'J\u000b\u0010\u009a\u0001\u001a\u0004\u0018\u000105H'J(\u0010\u009b\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J0\u0010\u009d\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J:\u0010\u009e\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J4\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010\u0010\u001a\u00020\u000f2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J*\u0010 \u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010\u0010\u001a\u00020\u000f2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J0\u0010¡\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010b\u001a\u00020A2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J:\u0010¢\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010b\u001a\u00020A2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J4\u0010£\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010b\u001a\u00020A2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J*\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010b\u001a\u00020A2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J2\u0010¥\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J,\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010§\u0001\u001a\b\u0012\u0004\u0012\u0002050\u00032\u0007\u0010\u009c\u0001\u001a\u00020\"H'J\"\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u0002050\u00032\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010©\u0001\u001a\u0004\u0018\u0001052\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0014\u0010ª\u0001\u001a\u0004\u0018\u0001052\u0007\u0010\u009c\u0001\u001a\u00020\"H'J\"\u0010«\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J\u001c\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010?2\n\u0010k\u001a\u00020l\"\u00020\u000fH'J\u0011\u0010®\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u0003H'J\u0019\u0010¯\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00032\u0006\u0010\u0010\u001a\u00020\u000fH'J#\u0010°\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u001d\u0010±\u0001\u001a\u0004\u0018\u0001052\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0013\u0010²\u0001\u001a\u0004\u0018\u0001052\u0006\u0010\u0010\u001a\u00020\u000fH'J\u001b\u0010³\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0015\u0010´\u0001\u001a\u0004\u0018\u0001052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u000b\u0010µ\u0001\u001a\u0004\u0018\u000105H'J(\u0010¶\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J0\u0010·\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J:\u0010¸\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J4\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010\u0010\u001a\u00020\u000f2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J*\u0010º\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010\u0010\u001a\u00020\u000f2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J0\u0010»\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010b\u001a\u00020A2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J:\u0010¼\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0006\u0010b\u001a\u00020A2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J4\u0010½\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010b\u001a\u00020A2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J*\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0006\u0010b\u001a\u00020A2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J2\u0010¿\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050?0\u00032\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J,\u0010À\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u001a\u0010Á\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00032\u0007\u0010\u009c\u0001\u001a\u00020\"H'J$\u0010Â\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00032\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010Ã\u0001\u001a\u0004\u0018\u0001052\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H'J\u0014\u0010Ä\u0001\u001a\u0004\u0018\u0001052\u0007\u0010\u009c\u0001\u001a\u00020\"H'J\"\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u0002050?2\u0007\u0010\u009c\u0001\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020\u0004H'J\u0011\u0010Æ\u0001\u001a\u0002032\u0006\u00104\u001a\u000205H'J\"\u0010Ç\u0001\u001a\u0002032\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020508\"\u000205H'¢\u0006\u0002\u00109J\u0014\u0010È\u0001\u001a\u0002032\t\u0010É\u0001\u001a\u0004\u0018\u00010AH'J\u0012\u0010Ê\u0001\u001a\u0002032\u0007\u0010Ë\u0001\u001a\u00020\u0007H'¨\u0006Í\u0001"}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/PlayableItemDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllByVisibility", "visibility", "", "countAllByVisibilityStatically", "countAllByVisibilityWithDisjointSetPrimaryPlayableItemId", "countAllByVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countAllStatically", "countAllWithDisjointSetPrimaryPlayableItemId", "countAllWithDisjointSetPrimaryPlayableItemIdStatically", "countByAttachedPlatformId", "", "id", "countByAttachedPlatformIdAndVisibility", "countByAttachedPlatformIdAndVisibilityStatically", "countByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId", "countByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countByAttachedPlatformIdStatically", "countByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId", "countByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically", "countFavoriteByAttachedPlatformId", "countFavoriteByAttachedPlatformIdAndVisibility", "countFavoriteByAttachedPlatformIdAndVisibilityStatically", "countFavoriteByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId", "countFavoriteByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countFavoriteByAttachedPlatformIdStatically", "countFavoriteByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId", "countFavoriteByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically", "countNewlyByAttachedPlatformId", "date", "Ljava/util/Date;", "countNewlyByAttachedPlatformIdAndVisibility", "countNewlyByAttachedPlatformIdAndVisibilityStatically", "countNewlyByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId", "countNewlyByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countNewlyByAttachedPlatformIdStatically", "countNewlyByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId", "countNewlyByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically", "countRecentByAttachedPlatformId", "countRecentByAttachedPlatformIdAndVisibility", "countRecentByAttachedPlatformIdAndVisibilityStatically", "countRecentByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId", "countRecentByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countRecentByAttachedPlatformIdStatically", "countRecentByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId", "countRecentByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically", "delete", "", "playableItemEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "deleteAll", "playableItemEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V", "deleteByAttachedPlatformId", "deleteByAttachedPlatformIdAndSyncTreeUri", "uri", "Landroid/net/Uri;", "findWithName", "", "search", "", "limit", "findWithNameAndDescription", "findWithNameAndDescriptionStatically", "findWithNameAndVisibility", "findWithNameAndVisibilityStatically", "findWithNameDescriptionAndVisibility", "findWithNameDescriptionAndVisibilityStatically", "findWithNameStatically", "insert", "insertAll", "([Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)Ljava/util/List;", "selectAll", "selectAllByVisibility", "selectAllByVisibilityStatically", "selectAllIds", "selectAllIdsByVisibility", "selectAllIdsByVisibilityStatically", "selectAllIdsStatically", "selectAllStatically", "selectByAttachedPlatformId", "selectByAttachedPlatformIdAndSyncTreeUri", "selectByAttachedPlatformIdAndSyncTreeUriAndVisibility", "selectByAttachedPlatformIdAndSyncTreeUriAndVisibilityStatically", "selectByAttachedPlatformIdAndSyncTreeUriStatically", "selectByAttachedPlatformIdAndVisibility", "selectByAttachedPlatformIdAndVisibilityStatically", "selectByAttachedPlatformIdStatically", "selectByDisjointSetPrimaryPlayableItemId", "selectByDisjointSetPrimaryPlayableItemIdAndVisibility", "selectByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically", "selectByDisjointSetPrimaryPlayableItemIdStatically", "selectByGenreId", "genreId", "selectByGenreIdAndVisibility", "selectByGenreIdAndVisibilityStatically", "selectByGenreIdStatically", "selectById", "selectByIdAndVisibility", "selectByIdAndVisibilityStatically", "selectByIdStatically", "selectByIdsStatically", "ids", "", "selectByMd5List", "md5List", "([Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "selectByMd5ListAndVisibility", "([Ljava/lang/String;Z)Landroidx/lifecycle/LiveData;", "selectByMd5ListAndVisibilityStatically", "([Ljava/lang/String;Z)Ljava/util/List;", "selectByMd5ListStatically", "([Ljava/lang/String;)Ljava/util/List;", "selectByPlatformIdAndGenreId", "platformId", "selectByPlatformIdAndGenreIdStatically", "selectByPlatformIdGenreIdAndVisibility", "selectByPlatformIdGenreIdAndVisibilityStatically", "selectFavorite", "selectFavoriteByAttachedPlatformId", "selectFavoriteByAttachedPlatformIdAndVisibility", "selectFavoriteByAttachedPlatformIdAndVisibilityStatically", "selectFavoriteByAttachedPlatformIdStatically", "selectFavoriteByGenreId", "selectFavoriteByGenreIdAndVisibility", "selectFavoriteByGenreIdAndVisibilityStatically", "selectFavoriteByGenreIdStatically", "selectFavoriteByVisibility", "selectFavoriteByVisibilityStatically", "selectFavoriteRandomly", "selectFavoriteRandomlyByVisibility", "selectFavoriteRandomlyByVisibilityStatically", "selectFavoriteRandomlyStatically", "selectFavoriteRecentOrNewly", "afterDateRecent", "afterDateNewly", "selectFavoriteRecentOrNewlyByVisibility", "selectFavoriteRecentOrNewlyByVisibilityStatically", "selectFavoriteRecentOrNewlyStatically", "selectFavoriteStatically", "selectIdsByAttachedPlatformId", "selectIdsByAttachedPlatformIdAndVisibility", "selectIdsByAttachedPlatformIdAndVisibilityStatically", "selectIdsByAttachedPlatformIdStatically", "selectIdsByDisjointSetPrimaryPlayableItemId", "selectIdsByDisjointSetPrimaryPlayableItemIdAndVisibility", "selectIdsByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically", "selectIdsByDisjointSetPrimaryPlayableItemIdStatically", "selectMostRecent", "selectMostRecentStatically", "selectNewly", "afterDate", "selectNewlyByAttachedPlatformId", "selectNewlyByAttachedPlatformIdAndVisibility", "selectNewlyByAttachedPlatformIdAndVisibilityStatically", "selectNewlyByAttachedPlatformIdStatically", "selectNewlyByGenreId", "selectNewlyByGenreIdAndVisibility", "selectNewlyByGenreIdAndVisibilityStatically", "selectNewlyByGenreIdStatically", "selectNewlyByVisibility", "selectNewlyByVisibilityStatically", "selectNewlyRandomly", "selectNewlyRandomlyByVisibility", "selectNewlyRandomlyByVisibilityStatically", "selectNewlyRandomlyStatically", "selectNewlyStatically", "selectPlayableItemEntityMergedInfoByDisjointSetPrimaryPlayableItemIdsStatically", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;", "selectRandomly", "selectRandomlyByAttachedPlatformId", "selectRandomlyByAttachedPlatformIdAndVisibility", "selectRandomlyByAttachedPlatformIdAndVisibilityStatically", "selectRandomlyByAttachedPlatformIdStatically", "selectRandomlyByVisibility", "selectRandomlyByVisibilityStatically", "selectRandomlyStatically", "selectRecent", "selectRecentByAttachedPlatformId", "selectRecentByAttachedPlatformIdAndVisibility", "selectRecentByAttachedPlatformIdAndVisibilityStatically", "selectRecentByAttachedPlatformIdStatically", "selectRecentByGenreId", "selectRecentByGenreIdAndVisibility", "selectRecentByGenreIdAndVisibilityStatically", "selectRecentByGenreIdStatically", "selectRecentByVisibility", "selectRecentByVisibilityStatically", "selectRecentRandomly", "selectRecentRandomlyByVisibility", "selectRecentRandomlyByVisibilityStatically", "selectRecentRandomlyStatically", "selectRecentStatically", "update", "updateAll", "updatePreviewMediaPathAll", "previewMediaPath", "updateUseCustomPlayerAll", "useCustomPlayer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface PlayableItemDAO {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String SCORE = "is_favorite+(CASE WHEN last_played_timestamp >= :afterDateRecent THEN 1 ELSE 0 END)+(CASE WHEN added_date_timestamp >= :afterDateNewly THEN 1 ELSE 0 END)+(1-1/(play_count+1)) AS score";

    LiveData<Integer> countAll();

    LiveData<Integer> countAllByVisibility(boolean z);

    int countAllByVisibilityStatically(boolean z);

    LiveData<Integer> countAllByVisibilityWithDisjointSetPrimaryPlayableItemId(boolean z);

    int countAllByVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(boolean z);

    int countAllStatically();

    LiveData<Integer> countAllWithDisjointSetPrimaryPlayableItemId();

    int countAllWithDisjointSetPrimaryPlayableItemIdStatically();

    LiveData<Long> countByAttachedPlatformId(long j);

    LiveData<Long> countByAttachedPlatformIdAndVisibility(long j, boolean z);

    long countByAttachedPlatformIdAndVisibilityStatically(long j, boolean z);

    LiveData<Long> countByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(long j, boolean z);

    long countByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(long j, boolean z);

    long countByAttachedPlatformIdStatically(long j);

    LiveData<Long> countByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(long j);

    long countByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(long j);

    LiveData<Long> countFavoriteByAttachedPlatformId(long j);

    LiveData<Long> countFavoriteByAttachedPlatformIdAndVisibility(long j, boolean z);

    long countFavoriteByAttachedPlatformIdAndVisibilityStatically(long j, boolean z);

    LiveData<Long> countFavoriteByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(long j, boolean z);

    long countFavoriteByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(long j, boolean z);

    long countFavoriteByAttachedPlatformIdStatically(long j);

    LiveData<Long> countFavoriteByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(long j);

    long countFavoriteByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(long j);

    LiveData<Long> countNewlyByAttachedPlatformId(long j, Date date);

    LiveData<Long> countNewlyByAttachedPlatformIdAndVisibility(long j, Date date, boolean z);

    long countNewlyByAttachedPlatformIdAndVisibilityStatically(long j, Date date, boolean z);

    LiveData<Long> countNewlyByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(long j, Date date, boolean z);

    long countNewlyByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(long j, Date date, boolean z);

    long countNewlyByAttachedPlatformIdStatically(long j, Date date);

    LiveData<Long> countNewlyByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(long j, Date date);

    long countNewlyByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(long j, Date date);

    LiveData<Long> countRecentByAttachedPlatformId(long j, Date date);

    LiveData<Long> countRecentByAttachedPlatformIdAndVisibility(long j, Date date, boolean z);

    long countRecentByAttachedPlatformIdAndVisibilityStatically(long j, Date date, boolean z);

    LiveData<Long> countRecentByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(long j, Date date, boolean z);

    long countRecentByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(long j, Date date, boolean z);

    long countRecentByAttachedPlatformIdStatically(long j, Date date);

    LiveData<Long> countRecentByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(long j, Date date);

    long countRecentByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(long j, Date date);

    void delete(PlayableItemEntity playableItemEntity);

    void deleteAll(PlayableItemEntity... playableItemEntityArr);

    void deleteByAttachedPlatformId(long j);

    void deleteByAttachedPlatformIdAndSyncTreeUri(long j, Uri uri);

    LiveData<List<PlayableItemEntity>> findWithName(String str, int i);

    LiveData<List<PlayableItemEntity>> findWithNameAndDescription(String str, int i);

    List<PlayableItemEntity> findWithNameAndDescriptionStatically(String str, int i);

    LiveData<List<PlayableItemEntity>> findWithNameAndVisibility(String str, int i, boolean z);

    List<PlayableItemEntity> findWithNameAndVisibilityStatically(String str, int i, boolean z);

    LiveData<List<PlayableItemEntity>> findWithNameDescriptionAndVisibility(String str, int i, boolean z);

    List<PlayableItemEntity> findWithNameDescriptionAndVisibilityStatically(String str, int i, boolean z);

    List<PlayableItemEntity> findWithNameStatically(String str, int i);

    long insert(PlayableItemEntity playableItemEntity);

    List<Long> insertAll(PlayableItemEntity... playableItemEntityArr);

    LiveData<List<PlayableItemEntity>> selectAll();

    LiveData<List<PlayableItemEntity>> selectAllByVisibility(boolean z);

    List<PlayableItemEntity> selectAllByVisibilityStatically(boolean z);

    LiveData<List<Long>> selectAllIds();

    LiveData<List<Long>> selectAllIdsByVisibility(boolean z);

    List<Long> selectAllIdsByVisibilityStatically(boolean z);

    List<Long> selectAllIdsStatically();

    List<PlayableItemEntity> selectAllStatically();

    LiveData<List<PlayableItemEntity>> selectByAttachedPlatformId(long j);

    LiveData<List<PlayableItemEntity>> selectByAttachedPlatformIdAndSyncTreeUri(long j, Uri uri);

    LiveData<List<PlayableItemEntity>> selectByAttachedPlatformIdAndSyncTreeUriAndVisibility(long j, Uri uri, boolean z);

    List<PlayableItemEntity> selectByAttachedPlatformIdAndSyncTreeUriAndVisibilityStatically(long j, Uri uri, boolean z);

    List<PlayableItemEntity> selectByAttachedPlatformIdAndSyncTreeUriStatically(long j, Uri uri);

    LiveData<List<PlayableItemEntity>> selectByAttachedPlatformIdAndVisibility(long j, boolean z);

    List<PlayableItemEntity> selectByAttachedPlatformIdAndVisibilityStatically(long j, boolean z);

    List<PlayableItemEntity> selectByAttachedPlatformIdStatically(long j);

    LiveData<List<PlayableItemEntity>> selectByDisjointSetPrimaryPlayableItemId(long j);

    LiveData<List<PlayableItemEntity>> selectByDisjointSetPrimaryPlayableItemIdAndVisibility(long j, boolean z);

    List<PlayableItemEntity> selectByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically(long j, boolean z);

    List<PlayableItemEntity> selectByDisjointSetPrimaryPlayableItemIdStatically(long j);

    LiveData<List<PlayableItemEntity>> selectByGenreId(String str, int i);

    LiveData<List<PlayableItemEntity>> selectByGenreIdAndVisibility(String str, int i, boolean z);

    List<PlayableItemEntity> selectByGenreIdAndVisibilityStatically(String str, int i, boolean z);

    List<PlayableItemEntity> selectByGenreIdStatically(String str, int i);

    LiveData<PlayableItemEntity> selectById(long j);

    LiveData<PlayableItemEntity> selectByIdAndVisibility(long j, boolean z);

    PlayableItemEntity selectByIdAndVisibilityStatically(long j, boolean z);

    PlayableItemEntity selectByIdStatically(long j);

    List<PlayableItemEntity> selectByIdsStatically(long... jArr);

    LiveData<List<PlayableItemEntity>> selectByMd5List(String... strArr);

    LiveData<List<PlayableItemEntity>> selectByMd5ListAndVisibility(String[] strArr, boolean z);

    List<PlayableItemEntity> selectByMd5ListAndVisibilityStatically(String[] strArr, boolean z);

    List<PlayableItemEntity> selectByMd5ListStatically(String... strArr);

    LiveData<List<PlayableItemEntity>> selectByPlatformIdAndGenreId(long j, String str);

    List<PlayableItemEntity> selectByPlatformIdAndGenreIdStatically(long j, String str);

    LiveData<List<PlayableItemEntity>> selectByPlatformIdGenreIdAndVisibility(long j, String str, boolean z);

    List<PlayableItemEntity> selectByPlatformIdGenreIdAndVisibilityStatically(long j, String str, boolean z);

    LiveData<List<PlayableItemEntity>> selectFavorite(int i);

    LiveData<List<PlayableItemEntity>> selectFavoriteByAttachedPlatformId(long j, int i);

    LiveData<List<PlayableItemEntity>> selectFavoriteByAttachedPlatformIdAndVisibility(long j, int i, boolean z);

    List<PlayableItemEntity> selectFavoriteByAttachedPlatformIdAndVisibilityStatically(long j, int i, boolean z);

    List<PlayableItemEntity> selectFavoriteByAttachedPlatformIdStatically(long j, int i);

    LiveData<List<PlayableItemEntity>> selectFavoriteByGenreId(String str, int i);

    LiveData<List<PlayableItemEntity>> selectFavoriteByGenreIdAndVisibility(String str, int i, boolean z);

    List<PlayableItemEntity> selectFavoriteByGenreIdAndVisibilityStatically(String str, int i, boolean z);

    List<PlayableItemEntity> selectFavoriteByGenreIdStatically(String str, int i);

    LiveData<List<PlayableItemEntity>> selectFavoriteByVisibility(int i, boolean z);

    List<PlayableItemEntity> selectFavoriteByVisibilityStatically(int i, boolean z);

    LiveData<PlayableItemEntity> selectFavoriteRandomly();

    LiveData<PlayableItemEntity> selectFavoriteRandomlyByVisibility(boolean z);

    PlayableItemEntity selectFavoriteRandomlyByVisibilityStatically(boolean z);

    PlayableItemEntity selectFavoriteRandomlyStatically();

    LiveData<List<PlayableItemEntity>> selectFavoriteRecentOrNewly(Date date, Date date2, int i);

    LiveData<List<PlayableItemEntity>> selectFavoriteRecentOrNewlyByVisibility(Date date, Date date2, int i, boolean z);

    List<PlayableItemEntity> selectFavoriteRecentOrNewlyByVisibilityStatically(Date date, Date date2, int i, boolean z);

    List<PlayableItemEntity> selectFavoriteRecentOrNewlyStatically(Date date, Date date2, int i);

    List<PlayableItemEntity> selectFavoriteStatically(int i);

    LiveData<List<Long>> selectIdsByAttachedPlatformId(long j);

    LiveData<List<Long>> selectIdsByAttachedPlatformIdAndVisibility(long j, boolean z);

    List<Long> selectIdsByAttachedPlatformIdAndVisibilityStatically(long j, boolean z);

    List<Long> selectIdsByAttachedPlatformIdStatically(long j);

    LiveData<List<Long>> selectIdsByDisjointSetPrimaryPlayableItemId(long j);

    LiveData<List<Long>> selectIdsByDisjointSetPrimaryPlayableItemIdAndVisibility(long j, boolean z);

    List<Long> selectIdsByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically(long j, boolean z);

    List<Long> selectIdsByDisjointSetPrimaryPlayableItemIdStatically(long j);

    LiveData<PlayableItemEntity> selectMostRecent();

    PlayableItemEntity selectMostRecentStatically();

    LiveData<List<PlayableItemEntity>> selectNewly(Date date, int i);

    LiveData<List<PlayableItemEntity>> selectNewlyByAttachedPlatformId(long j, Date date, int i);

    LiveData<List<PlayableItemEntity>> selectNewlyByAttachedPlatformIdAndVisibility(long j, Date date, int i, boolean z);

    List<PlayableItemEntity> selectNewlyByAttachedPlatformIdAndVisibilityStatically(long j, Date date, int i, boolean z);

    List<PlayableItemEntity> selectNewlyByAttachedPlatformIdStatically(long j, Date date, int i);

    LiveData<List<PlayableItemEntity>> selectNewlyByGenreId(String str, Date date, int i);

    LiveData<List<PlayableItemEntity>> selectNewlyByGenreIdAndVisibility(String str, Date date, int i, boolean z);

    List<PlayableItemEntity> selectNewlyByGenreIdAndVisibilityStatically(String str, Date date, int i, boolean z);

    List<PlayableItemEntity> selectNewlyByGenreIdStatically(String str, Date date, int i);

    LiveData<List<PlayableItemEntity>> selectNewlyByVisibility(Date date, int i, boolean z);

    List<PlayableItemEntity> selectNewlyByVisibilityStatically(Date date, int i, boolean z);

    LiveData<PlayableItemEntity> selectNewlyRandomly(Date date);

    LiveData<PlayableItemEntity> selectNewlyRandomlyByVisibility(Date date, boolean z);

    PlayableItemEntity selectNewlyRandomlyByVisibilityStatically(Date date, boolean z);

    PlayableItemEntity selectNewlyRandomlyStatically(Date date);

    List<PlayableItemEntity> selectNewlyStatically(Date date, int i);

    List<PlayableItemEntityMergedInfo> selectPlayableItemEntityMergedInfoByDisjointSetPrimaryPlayableItemIdsStatically(long... jArr);

    LiveData<PlayableItemEntity> selectRandomly();

    LiveData<PlayableItemEntity> selectRandomlyByAttachedPlatformId(long j);

    LiveData<PlayableItemEntity> selectRandomlyByAttachedPlatformIdAndVisibility(long j, boolean z);

    PlayableItemEntity selectRandomlyByAttachedPlatformIdAndVisibilityStatically(long j, boolean z);

    PlayableItemEntity selectRandomlyByAttachedPlatformIdStatically(long j);

    LiveData<PlayableItemEntity> selectRandomlyByVisibility(boolean z);

    PlayableItemEntity selectRandomlyByVisibilityStatically(boolean z);

    PlayableItemEntity selectRandomlyStatically();

    LiveData<List<PlayableItemEntity>> selectRecent(Date date, int i);

    LiveData<List<PlayableItemEntity>> selectRecentByAttachedPlatformId(long j, Date date, int i);

    LiveData<List<PlayableItemEntity>> selectRecentByAttachedPlatformIdAndVisibility(long j, Date date, int i, boolean z);

    List<PlayableItemEntity> selectRecentByAttachedPlatformIdAndVisibilityStatically(long j, Date date, int i, boolean z);

    List<PlayableItemEntity> selectRecentByAttachedPlatformIdStatically(long j, Date date, int i);

    LiveData<List<PlayableItemEntity>> selectRecentByGenreId(String str, Date date, int i);

    LiveData<List<PlayableItemEntity>> selectRecentByGenreIdAndVisibility(String str, Date date, int i, boolean z);

    List<PlayableItemEntity> selectRecentByGenreIdAndVisibilityStatically(String str, Date date, int i, boolean z);

    List<PlayableItemEntity> selectRecentByGenreIdStatically(String str, Date date, int i);

    LiveData<List<PlayableItemEntity>> selectRecentByVisibility(Date date, int i, boolean z);

    List<PlayableItemEntity> selectRecentByVisibilityStatically(Date date, int i, boolean z);

    LiveData<PlayableItemEntity> selectRecentRandomly(Date date);

    LiveData<PlayableItemEntity> selectRecentRandomlyByVisibility(Date date, boolean z);

    PlayableItemEntity selectRecentRandomlyByVisibilityStatically(Date date, boolean z);

    PlayableItemEntity selectRecentRandomlyStatically(Date date);

    List<PlayableItemEntity> selectRecentStatically(Date date, int i);

    void update(PlayableItemEntity playableItemEntity);

    void updateAll(PlayableItemEntity... playableItemEntityArr);

    void updatePreviewMediaPathAll(String str);

    void updateUseCustomPlayerAll(boolean z);

    /* JADX INFO: compiled from: PlayableItemDAO.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/data/db/dao/PlayableItemDAO$Companion;", "", "()V", "SCORE", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String SCORE = "is_favorite+(CASE WHEN last_played_timestamp >= :afterDateRecent THEN 1 ELSE 0 END)+(CASE WHEN added_date_timestamp >= :afterDateNewly THEN 1 ELSE 0 END)+(1-1/(play_count+1)) AS score";

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: PlayableItemDAO.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ LiveData countAllByVisibility$default(PlayableItemDAO playableItemDAO, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countAllByVisibility");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return playableItemDAO.countAllByVisibility(z);
        }

        public static /* synthetic */ int countAllByVisibilityStatically$default(PlayableItemDAO playableItemDAO, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countAllByVisibilityStatically");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return playableItemDAO.countAllByVisibilityStatically(z);
        }

        public static /* synthetic */ LiveData countAllByVisibilityWithDisjointSetPrimaryPlayableItemId$default(PlayableItemDAO playableItemDAO, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countAllByVisibilityWithDisjointSetPrimaryPlayableItemId");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return playableItemDAO.countAllByVisibilityWithDisjointSetPrimaryPlayableItemId(z);
        }

        public static /* synthetic */ int countAllByVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(PlayableItemDAO playableItemDAO, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countAllByVisibilityWithDisjointSetPrimaryPlayableItemIdStatically");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return playableItemDAO.countAllByVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(z);
        }

        public static /* synthetic */ LiveData selectAllIdsByVisibility$default(PlayableItemDAO playableItemDAO, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectAllIdsByVisibility");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return playableItemDAO.selectAllIdsByVisibility(z);
        }

        public static /* synthetic */ List selectAllIdsByVisibilityStatically$default(PlayableItemDAO playableItemDAO, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectAllIdsByVisibilityStatically");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return playableItemDAO.selectAllIdsByVisibilityStatically(z);
        }

        public static /* synthetic */ LiveData selectAllByVisibility$default(PlayableItemDAO playableItemDAO, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectAllByVisibility");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return playableItemDAO.selectAllByVisibility(z);
        }

        public static /* synthetic */ List selectAllByVisibilityStatically$default(PlayableItemDAO playableItemDAO, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectAllByVisibilityStatically");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return playableItemDAO.selectAllByVisibilityStatically(z);
        }

        public static /* synthetic */ LiveData selectRandomlyByVisibility$default(PlayableItemDAO playableItemDAO, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRandomlyByVisibility");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return playableItemDAO.selectRandomlyByVisibility(z);
        }

        public static /* synthetic */ PlayableItemEntity selectRandomlyByVisibilityStatically$default(PlayableItemDAO playableItemDAO, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRandomlyByVisibilityStatically");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return playableItemDAO.selectRandomlyByVisibilityStatically(z);
        }

        public static /* synthetic */ LiveData selectRecentRandomlyByVisibility$default(PlayableItemDAO playableItemDAO, Date date, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentRandomlyByVisibility");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectRecentRandomlyByVisibility(date, z);
        }

        public static /* synthetic */ PlayableItemEntity selectRecentRandomlyByVisibilityStatically$default(PlayableItemDAO playableItemDAO, Date date, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentRandomlyByVisibilityStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectRecentRandomlyByVisibilityStatically(date, z);
        }

        public static /* synthetic */ LiveData selectFavoriteRandomlyByVisibility$default(PlayableItemDAO playableItemDAO, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteRandomlyByVisibility");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return playableItemDAO.selectFavoriteRandomlyByVisibility(z);
        }

        public static /* synthetic */ PlayableItemEntity selectFavoriteRandomlyByVisibilityStatically$default(PlayableItemDAO playableItemDAO, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteRandomlyByVisibilityStatically");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return playableItemDAO.selectFavoriteRandomlyByVisibilityStatically(z);
        }

        public static /* synthetic */ LiveData selectNewlyRandomlyByVisibility$default(PlayableItemDAO playableItemDAO, Date date, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyRandomlyByVisibility");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectNewlyRandomlyByVisibility(date, z);
        }

        public static /* synthetic */ PlayableItemEntity selectNewlyRandomlyByVisibilityStatically$default(PlayableItemDAO playableItemDAO, Date date, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyRandomlyByVisibilityStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectNewlyRandomlyByVisibilityStatically(date, z);
        }

        public static /* synthetic */ LiveData selectRandomlyByAttachedPlatformIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRandomlyByAttachedPlatformIdAndVisibility");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectRandomlyByAttachedPlatformIdAndVisibility(j, z);
        }

        public static /* synthetic */ PlayableItemEntity selectRandomlyByAttachedPlatformIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRandomlyByAttachedPlatformIdAndVisibilityStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectRandomlyByAttachedPlatformIdAndVisibilityStatically(j, z);
        }

        public static /* synthetic */ LiveData selectByIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByIdAndVisibility");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectByIdAndVisibility(j, z);
        }

        public static /* synthetic */ PlayableItemEntity selectByIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByIdAndVisibilityStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectByIdAndVisibilityStatically(j, z);
        }

        public static /* synthetic */ LiveData selectByMd5ListAndVisibility$default(PlayableItemDAO playableItemDAO, String[] strArr, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByMd5ListAndVisibility");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectByMd5ListAndVisibility(strArr, z);
        }

        public static /* synthetic */ List selectByMd5ListAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, String[] strArr, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByMd5ListAndVisibilityStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectByMd5ListAndVisibilityStatically(strArr, z);
        }

        public static /* synthetic */ LiveData selectByGenreId$default(PlayableItemDAO playableItemDAO, String str, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByGenreId");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.selectByGenreId(str, i);
        }

        public static /* synthetic */ LiveData selectByGenreIdAndVisibility$default(PlayableItemDAO playableItemDAO, String str, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByGenreIdAndVisibility");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectByGenreIdAndVisibility(str, i, z);
        }

        public static /* synthetic */ List selectByGenreIdStatically$default(PlayableItemDAO playableItemDAO, String str, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByGenreIdStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.selectByGenreIdStatically(str, i);
        }

        public static /* synthetic */ List selectByGenreIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, String str, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByGenreIdAndVisibilityStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectByGenreIdAndVisibilityStatically(str, i, z);
        }

        public static /* synthetic */ LiveData selectByPlatformIdGenreIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByPlatformIdGenreIdAndVisibility");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectByPlatformIdGenreIdAndVisibility(j, str, z);
        }

        public static /* synthetic */ List selectByPlatformIdGenreIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByPlatformIdGenreIdAndVisibilityStatically");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectByPlatformIdGenreIdAndVisibilityStatically(j, str, z);
        }

        public static /* synthetic */ LiveData selectRecentByGenreId$default(PlayableItemDAO playableItemDAO, String str, Date date, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentByGenreId");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            return playableItemDAO.selectRecentByGenreId(str, date, i);
        }

        public static /* synthetic */ LiveData selectRecentByGenreIdAndVisibility$default(PlayableItemDAO playableItemDAO, String str, Date date, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentByGenreIdAndVisibility");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            if ((i2 & 8) != 0) {
                z = true;
            }
            return playableItemDAO.selectRecentByGenreIdAndVisibility(str, date, i, z);
        }

        public static /* synthetic */ List selectRecentByGenreIdStatically$default(PlayableItemDAO playableItemDAO, String str, Date date, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentByGenreIdStatically");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            return playableItemDAO.selectRecentByGenreIdStatically(str, date, i);
        }

        public static /* synthetic */ List selectRecentByGenreIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, String str, Date date, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentByGenreIdAndVisibilityStatically");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            if ((i2 & 8) != 0) {
                z = true;
            }
            return playableItemDAO.selectRecentByGenreIdAndVisibilityStatically(str, date, i, z);
        }

        public static /* synthetic */ LiveData selectFavoriteByGenreId$default(PlayableItemDAO playableItemDAO, String str, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteByGenreId");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.selectFavoriteByGenreId(str, i);
        }

        public static /* synthetic */ LiveData selectFavoriteByGenreIdAndVisibility$default(PlayableItemDAO playableItemDAO, String str, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteByGenreIdAndVisibility");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectFavoriteByGenreIdAndVisibility(str, i, z);
        }

        public static /* synthetic */ List selectFavoriteByGenreIdStatically$default(PlayableItemDAO playableItemDAO, String str, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteByGenreIdStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.selectFavoriteByGenreIdStatically(str, i);
        }

        public static /* synthetic */ List selectFavoriteByGenreIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, String str, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteByGenreIdAndVisibilityStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectFavoriteByGenreIdAndVisibilityStatically(str, i, z);
        }

        public static /* synthetic */ LiveData selectNewlyByGenreId$default(PlayableItemDAO playableItemDAO, String str, Date date, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyByGenreId");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            return playableItemDAO.selectNewlyByGenreId(str, date, i);
        }

        public static /* synthetic */ LiveData selectNewlyByGenreIdAndVisibility$default(PlayableItemDAO playableItemDAO, String str, Date date, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyByGenreIdAndVisibility");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            if ((i2 & 8) != 0) {
                z = true;
            }
            return playableItemDAO.selectNewlyByGenreIdAndVisibility(str, date, i, z);
        }

        public static /* synthetic */ List selectNewlyByGenreIdStatically$default(PlayableItemDAO playableItemDAO, String str, Date date, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyByGenreIdStatically");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            return playableItemDAO.selectNewlyByGenreIdStatically(str, date, i);
        }

        public static /* synthetic */ List selectNewlyByGenreIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, String str, Date date, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyByGenreIdAndVisibilityStatically");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            if ((i2 & 8) != 0) {
                z = true;
            }
            return playableItemDAO.selectNewlyByGenreIdAndVisibilityStatically(str, date, i, z);
        }

        public static /* synthetic */ LiveData selectByAttachedPlatformIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByAttachedPlatformIdAndVisibility");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectByAttachedPlatformIdAndVisibility(j, z);
        }

        public static /* synthetic */ List selectByAttachedPlatformIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByAttachedPlatformIdAndVisibilityStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectByAttachedPlatformIdAndVisibilityStatically(j, z);
        }

        public static /* synthetic */ LiveData selectIdsByAttachedPlatformIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectIdsByAttachedPlatformIdAndVisibility");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectIdsByAttachedPlatformIdAndVisibility(j, z);
        }

        public static /* synthetic */ List selectIdsByAttachedPlatformIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectIdsByAttachedPlatformIdAndVisibilityStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectIdsByAttachedPlatformIdAndVisibilityStatically(j, z);
        }

        public static /* synthetic */ LiveData selectIdsByDisjointSetPrimaryPlayableItemIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectIdsByDisjointSetPrimaryPlayableItemIdAndVisibility");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectIdsByDisjointSetPrimaryPlayableItemIdAndVisibility(j, z);
        }

        public static /* synthetic */ List selectIdsByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectIdsByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectIdsByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically(j, z);
        }

        public static /* synthetic */ LiveData selectByDisjointSetPrimaryPlayableItemIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByDisjointSetPrimaryPlayableItemIdAndVisibility");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectByDisjointSetPrimaryPlayableItemIdAndVisibility(j, z);
        }

        public static /* synthetic */ List selectByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically(j, z);
        }

        public static /* synthetic */ LiveData selectByAttachedPlatformIdAndSyncTreeUriAndVisibility$default(PlayableItemDAO playableItemDAO, long j, Uri uri, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByAttachedPlatformIdAndSyncTreeUriAndVisibility");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectByAttachedPlatformIdAndSyncTreeUriAndVisibility(j, uri, z);
        }

        public static /* synthetic */ List selectByAttachedPlatformIdAndSyncTreeUriAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, Uri uri, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectByAttachedPlatformIdAndSyncTreeUriAndVisibilityStatically");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectByAttachedPlatformIdAndSyncTreeUriAndVisibilityStatically(j, uri, z);
        }

        public static /* synthetic */ LiveData selectRecentByAttachedPlatformId$default(PlayableItemDAO playableItemDAO, long j, Date date, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentByAttachedPlatformId");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            return playableItemDAO.selectRecentByAttachedPlatformId(j, date, i);
        }

        public static /* synthetic */ LiveData selectRecentByAttachedPlatformIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, Date date, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentByAttachedPlatformIdAndVisibility");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                z = true;
            }
            return playableItemDAO.selectRecentByAttachedPlatformIdAndVisibility(j, date, i3, z);
        }

        public static /* synthetic */ List selectRecentByAttachedPlatformIdStatically$default(PlayableItemDAO playableItemDAO, long j, Date date, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentByAttachedPlatformIdStatically");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            return playableItemDAO.selectRecentByAttachedPlatformIdStatically(j, date, i);
        }

        public static /* synthetic */ List selectRecentByAttachedPlatformIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, Date date, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentByAttachedPlatformIdAndVisibilityStatically");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                z = true;
            }
            return playableItemDAO.selectRecentByAttachedPlatformIdAndVisibilityStatically(j, date, i3, z);
        }

        public static /* synthetic */ LiveData selectFavoriteByAttachedPlatformId$default(PlayableItemDAO playableItemDAO, long j, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteByAttachedPlatformId");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.selectFavoriteByAttachedPlatformId(j, i);
        }

        public static /* synthetic */ LiveData selectFavoriteByAttachedPlatformIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteByAttachedPlatformIdAndVisibility");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectFavoriteByAttachedPlatformIdAndVisibility(j, i, z);
        }

        public static /* synthetic */ List selectFavoriteByAttachedPlatformIdStatically$default(PlayableItemDAO playableItemDAO, long j, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteByAttachedPlatformIdStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.selectFavoriteByAttachedPlatformIdStatically(j, i);
        }

        public static /* synthetic */ List selectFavoriteByAttachedPlatformIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteByAttachedPlatformIdAndVisibilityStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectFavoriteByAttachedPlatformIdAndVisibilityStatically(j, i, z);
        }

        public static /* synthetic */ LiveData selectNewlyByAttachedPlatformId$default(PlayableItemDAO playableItemDAO, long j, Date date, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyByAttachedPlatformId");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            return playableItemDAO.selectNewlyByAttachedPlatformId(j, date, i);
        }

        public static /* synthetic */ LiveData selectNewlyByAttachedPlatformIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, Date date, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyByAttachedPlatformIdAndVisibility");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                z = true;
            }
            return playableItemDAO.selectNewlyByAttachedPlatformIdAndVisibility(j, date, i3, z);
        }

        public static /* synthetic */ List selectNewlyByAttachedPlatformIdStatically$default(PlayableItemDAO playableItemDAO, long j, Date date, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyByAttachedPlatformIdStatically");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            return playableItemDAO.selectNewlyByAttachedPlatformIdStatically(j, date, i);
        }

        public static /* synthetic */ List selectNewlyByAttachedPlatformIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, Date date, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyByAttachedPlatformIdAndVisibilityStatically");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                z = true;
            }
            return playableItemDAO.selectNewlyByAttachedPlatformIdAndVisibilityStatically(j, date, i3, z);
        }

        public static /* synthetic */ LiveData selectFavoriteRecentOrNewly$default(PlayableItemDAO playableItemDAO, Date date, Date date2, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteRecentOrNewly");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            return playableItemDAO.selectFavoriteRecentOrNewly(date, date2, i);
        }

        public static /* synthetic */ LiveData selectFavoriteRecentOrNewlyByVisibility$default(PlayableItemDAO playableItemDAO, Date date, Date date2, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteRecentOrNewlyByVisibility");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            if ((i2 & 8) != 0) {
                z = true;
            }
            return playableItemDAO.selectFavoriteRecentOrNewlyByVisibility(date, date2, i, z);
        }

        public static /* synthetic */ List selectFavoriteRecentOrNewlyStatically$default(PlayableItemDAO playableItemDAO, Date date, Date date2, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteRecentOrNewlyStatically");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            return playableItemDAO.selectFavoriteRecentOrNewlyStatically(date, date2, i);
        }

        public static /* synthetic */ List selectFavoriteRecentOrNewlyByVisibilityStatically$default(PlayableItemDAO playableItemDAO, Date date, Date date2, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteRecentOrNewlyByVisibilityStatically");
            }
            if ((i2 & 4) != 0) {
                i = 512;
            }
            if ((i2 & 8) != 0) {
                z = true;
            }
            return playableItemDAO.selectFavoriteRecentOrNewlyByVisibilityStatically(date, date2, i, z);
        }

        public static /* synthetic */ LiveData selectRecent$default(PlayableItemDAO playableItemDAO, Date date, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecent");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.selectRecent(date, i);
        }

        public static /* synthetic */ LiveData selectRecentByVisibility$default(PlayableItemDAO playableItemDAO, Date date, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentByVisibility");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectRecentByVisibility(date, i, z);
        }

        public static /* synthetic */ List selectRecentStatically$default(PlayableItemDAO playableItemDAO, Date date, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.selectRecentStatically(date, i);
        }

        public static /* synthetic */ List selectRecentByVisibilityStatically$default(PlayableItemDAO playableItemDAO, Date date, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectRecentByVisibilityStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectRecentByVisibilityStatically(date, i, z);
        }

        public static /* synthetic */ LiveData selectFavorite$default(PlayableItemDAO playableItemDAO, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavorite");
            }
            if ((i2 & 1) != 0) {
                i = 512;
            }
            return playableItemDAO.selectFavorite(i);
        }

        public static /* synthetic */ LiveData selectFavoriteByVisibility$default(PlayableItemDAO playableItemDAO, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteByVisibility");
            }
            if ((i2 & 1) != 0) {
                i = 512;
            }
            if ((i2 & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectFavoriteByVisibility(i, z);
        }

        public static /* synthetic */ List selectFavoriteStatically$default(PlayableItemDAO playableItemDAO, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteStatically");
            }
            if ((i2 & 1) != 0) {
                i = 512;
            }
            return playableItemDAO.selectFavoriteStatically(i);
        }

        public static /* synthetic */ List selectFavoriteByVisibilityStatically$default(PlayableItemDAO playableItemDAO, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectFavoriteByVisibilityStatically");
            }
            if ((i2 & 1) != 0) {
                i = 512;
            }
            if ((i2 & 2) != 0) {
                z = true;
            }
            return playableItemDAO.selectFavoriteByVisibilityStatically(i, z);
        }

        public static /* synthetic */ LiveData selectNewly$default(PlayableItemDAO playableItemDAO, Date date, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewly");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.selectNewly(date, i);
        }

        public static /* synthetic */ LiveData selectNewlyByVisibility$default(PlayableItemDAO playableItemDAO, Date date, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyByVisibility");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectNewlyByVisibility(date, i, z);
        }

        public static /* synthetic */ List selectNewlyStatically$default(PlayableItemDAO playableItemDAO, Date date, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.selectNewlyStatically(date, i);
        }

        public static /* synthetic */ List selectNewlyByVisibilityStatically$default(PlayableItemDAO playableItemDAO, Date date, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectNewlyByVisibilityStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.selectNewlyByVisibilityStatically(date, i, z);
        }

        public static /* synthetic */ LiveData findWithName$default(PlayableItemDAO playableItemDAO, String str, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWithName");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.findWithName(str, i);
        }

        public static /* synthetic */ LiveData findWithNameAndVisibility$default(PlayableItemDAO playableItemDAO, String str, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWithNameAndVisibility");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.findWithNameAndVisibility(str, i, z);
        }

        public static /* synthetic */ List findWithNameStatically$default(PlayableItemDAO playableItemDAO, String str, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWithNameStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.findWithNameStatically(str, i);
        }

        public static /* synthetic */ List findWithNameAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, String str, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWithNameAndVisibilityStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.findWithNameAndVisibilityStatically(str, i, z);
        }

        public static /* synthetic */ LiveData findWithNameAndDescription$default(PlayableItemDAO playableItemDAO, String str, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWithNameAndDescription");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.findWithNameAndDescription(str, i);
        }

        public static /* synthetic */ LiveData findWithNameDescriptionAndVisibility$default(PlayableItemDAO playableItemDAO, String str, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWithNameDescriptionAndVisibility");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.findWithNameDescriptionAndVisibility(str, i, z);
        }

        public static /* synthetic */ List findWithNameAndDescriptionStatically$default(PlayableItemDAO playableItemDAO, String str, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWithNameAndDescriptionStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            return playableItemDAO.findWithNameAndDescriptionStatically(str, i);
        }

        public static /* synthetic */ List findWithNameDescriptionAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, String str, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findWithNameDescriptionAndVisibilityStatically");
            }
            if ((i2 & 2) != 0) {
                i = 512;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            return playableItemDAO.findWithNameDescriptionAndVisibilityStatically(str, i, z);
        }

        public static /* synthetic */ LiveData countByAttachedPlatformIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countByAttachedPlatformIdAndVisibility");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.countByAttachedPlatformIdAndVisibility(j, z);
        }

        public static /* synthetic */ long countByAttachedPlatformIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countByAttachedPlatformIdAndVisibilityStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.countByAttachedPlatformIdAndVisibilityStatically(j, z);
        }

        public static /* synthetic */ LiveData countByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.countByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(j, z);
        }

        public static /* synthetic */ long countByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.countByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, z);
        }

        public static /* synthetic */ LiveData countFavoriteByAttachedPlatformIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countFavoriteByAttachedPlatformIdAndVisibility");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.countFavoriteByAttachedPlatformIdAndVisibility(j, z);
        }

        public static /* synthetic */ long countFavoriteByAttachedPlatformIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countFavoriteByAttachedPlatformIdAndVisibilityStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.countFavoriteByAttachedPlatformIdAndVisibilityStatically(j, z);
        }

        public static /* synthetic */ LiveData countRecentByAttachedPlatformIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, Date date, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countRecentByAttachedPlatformIdAndVisibility");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return playableItemDAO.countRecentByAttachedPlatformIdAndVisibility(j, date, z);
        }

        public static /* synthetic */ long countRecentByAttachedPlatformIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, Date date, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countRecentByAttachedPlatformIdAndVisibilityStatically");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return playableItemDAO.countRecentByAttachedPlatformIdAndVisibilityStatically(j, date, z);
        }

        public static /* synthetic */ LiveData countNewlyByAttachedPlatformIdAndVisibility$default(PlayableItemDAO playableItemDAO, long j, Date date, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countNewlyByAttachedPlatformIdAndVisibility");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return playableItemDAO.countNewlyByAttachedPlatformIdAndVisibility(j, date, z);
        }

        public static /* synthetic */ long countNewlyByAttachedPlatformIdAndVisibilityStatically$default(PlayableItemDAO playableItemDAO, long j, Date date, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countNewlyByAttachedPlatformIdAndVisibilityStatically");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return playableItemDAO.countNewlyByAttachedPlatformIdAndVisibilityStatically(j, date, z);
        }

        public static /* synthetic */ LiveData countFavoriteByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countFavoriteByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.countFavoriteByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(j, z);
        }

        public static /* synthetic */ long countFavoriteByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(PlayableItemDAO playableItemDAO, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countFavoriteByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return playableItemDAO.countFavoriteByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, z);
        }

        public static /* synthetic */ LiveData countRecentByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId$default(PlayableItemDAO playableItemDAO, long j, Date date, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countRecentByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return playableItemDAO.countRecentByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(j, date, z);
        }

        public static /* synthetic */ long countRecentByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(PlayableItemDAO playableItemDAO, long j, Date date, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countRecentByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return playableItemDAO.countRecentByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, date, z);
        }

        public static /* synthetic */ LiveData countNewlyByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId$default(PlayableItemDAO playableItemDAO, long j, Date date, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countNewlyByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return playableItemDAO.countNewlyByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(j, date, z);
        }

        public static /* synthetic */ long countNewlyByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(PlayableItemDAO playableItemDAO, long j, Date date, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countNewlyByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return playableItemDAO.countNewlyByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, date, z);
        }
    }
}
