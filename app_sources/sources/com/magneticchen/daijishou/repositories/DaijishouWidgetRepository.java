package com.magneticchen.daijishou.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_widget.widget_db.AppShortcutWidgetInstanceDAO;
import com.magneticchen.daijishou.daijishou_widget.widget_db.AppShortcutWidgetInstanceEntity;
import com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceDAO;
import com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceEntity;
import com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceDAO;
import com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceEntity;
import com.magneticchen.daijishou.daijishou_widget.widget_db.RSSWidgetInstanceDAO;
import com.magneticchen.daijishou.daijishou_widget.widget_db.RSSWidgetInstanceEntity;
import com.magneticchen.daijishou.daijishou_widget.widget_db.WidgetDatabase;
import com.magneticchen.daijishou.daijishou_widget.widget_db.WidgetInstanceDAO;
import com.magneticchen.daijishou.daijishou_widget.widget_db.WidgetInstanceEntity;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: DaijishouWidgetRepository.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u0016\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00192\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u001b\"\u00020\u0017¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fJ%\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\u00192\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001b\"\u00020\u001f¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%J%\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150\u00192\u0012\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0\u001b\"\u00020%¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*J%\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\u00192\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0\u001b\"\u00020*¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u00152\u0006\u0010/\u001a\u000200J%\u00102\u001a\b\u0012\u0004\u0012\u00020\u00150\u00192\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u0002000\u001b\"\u000200¢\u0006\u0002\u00104J%\u00105\u001a\b\u0012\u0004\u0012\u00020\u00150\u00192\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u0002000\u001b\"\u000200¢\u0006\u0002\u00104J\u0006\u00106\u001a\u000207J\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09J\u0006\u0010;\u001a\u00020:J\u000e\u0010<\u001a\u0002072\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010=\u001a\u0002072\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010>\u001a\u0002072\u0006\u0010$\u001a\u00020%J\u0012\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001909J\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019J\u0012\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001909J\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0019J\u0012\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001909J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020%0\u0019J\u0012\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u001909J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020*0\u0019J\u0012\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001909J\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019J\u0012\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u001909J\f\u0010J\u001a\b\u0012\u0004\u0012\u0002000\u0019J\u0016\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0017092\u0006\u0010L\u001a\u00020\u0015J\u0010\u0010M\u001a\u0004\u0018\u00010\u00172\u0006\u0010L\u001a\u00020\u0015J\u0016\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f092\u0006\u0010L\u001a\u00020\u0015J\u0010\u0010O\u001a\u0004\u0018\u00010\u001f2\u0006\u0010L\u001a\u00020\u0015J\u0016\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%092\u0006\u0010L\u001a\u00020\u0015J\u0010\u0010Q\u001a\u0004\u0018\u00010%2\u0006\u0010L\u001a\u00020\u0015J\u0016\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%092\u0006\u0010L\u001a\u00020\u0015J\u0010\u0010S\u001a\u0004\u0018\u00010%2\u0006\u0010L\u001a\u00020\u0015J\u001e\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u0019092\n\u0010U\u001a\u00020V\"\u00020\u0015J\u0018\u0010W\u001a\b\u0012\u0004\u0012\u00020%0\u00192\n\u0010U\u001a\u00020V\"\u00020\u0015J\u0016\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*092\u0006\u0010L\u001a\u00020\u0015J\u0010\u0010Y\u001a\u0004\u0018\u00010*2\u0006\u0010L\u001a\u00020\u0015J\u0010\u0010Z\u001a\u0004\u0018\u0001002\u0006\u0010L\u001a\u00020\u0015J\u0018\u0010[\u001a\u0004\u0018\u0001002\u0006\u0010\\\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u0015J\u001e\u0010^\u001a\u0002072\u0006\u0010L\u001a\u00020\u00152\u0006\u0010_\u001a\u00020:2\u0006\u0010`\u001a\u00020:J\u000e\u0010a\u001a\u0002072\u0006\u0010L\u001a\u00020\u0015J\u000e\u0010b\u001a\u0002072\u0006\u0010L\u001a\u00020\u0015J\u000e\u0010c\u001a\u0002072\u0006\u0010L\u001a\u00020\u0015J\u000e\u0010d\u001a\u0002072\u0006\u0010L\u001a\u00020\u0015J\u000e\u0010e\u001a\u0002072\u0006\u0010/\u001a\u000200J\u000e\u0010f\u001a\u0002072\u0006\u0010L\u001a\u00020\u0015J\u000e\u0010g\u001a\u0002072\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010h\u001a\u0002072\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010i\u001a\u0002072\u0006\u0010$\u001a\u00020%J\u000e\u0010j\u001a\u0002072\u0006\u0010)\u001a\u00020*J\u000e\u0010k\u001a\u0002072\u0006\u0010/\u001a\u000200R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/magneticchen/daijishou/repositories/DaijishouWidgetRepository;", "", "application", "Landroid/app/Application;", "databaseName", "", "(Landroid/app/Application;Ljava/lang/String;)V", "appShortcutWidgetInstanceDAO", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/AppShortcutWidgetInstanceDAO;", "Lcom/magneticchen/daijishou/DaijishouApplication;", "database", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/WidgetDatabase;", "imageBlockWidgetInstanceDAO", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ImageBlockWidgetInstanceDAO;", "pinAndPlayWidgetInstanceDAO", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/PinAndPlayWidgetInstanceDAO;", "rssWidgetInstanceDAO", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/RSSWidgetInstanceDAO;", "widgetInstanceDAO", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/WidgetInstanceDAO;", "addAppShortcutWidgetInstance", "", "appShortcutWidgetInstanceEntity", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/AppShortcutWidgetInstanceEntity;", "addAppShortcutWidgetInstances", "", "appShortcutWidgetInstanceEntities", "", "([Lcom/magneticchen/daijishou/daijishou_widget/widget_db/AppShortcutWidgetInstanceEntity;)Ljava/util/List;", "addImageBlockWidgetInstance", "imageBlockWidgetInstanceEntity", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ImageBlockWidgetInstanceEntity;", "addImageBlockWidgetInstances", "imageBlockWidgetInstanceEntities", "([Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ImageBlockWidgetInstanceEntity;)Ljava/util/List;", "addPinAndPlayWidgetInstance", "pinAndPlayWidgetInstanceEntity", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/PinAndPlayWidgetInstanceEntity;", "addPinAndPlayWidgetInstances", "([Lcom/magneticchen/daijishou/daijishou_widget/widget_db/PinAndPlayWidgetInstanceEntity;)Ljava/util/List;", "addRSSWidgetInstance", "rssWidgetInstanceEntity", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/RSSWidgetInstanceEntity;", "addRSSWidgetInstances", "rssWidgetInstanceEntities", "([Lcom/magneticchen/daijishou/daijishou_widget/widget_db/RSSWidgetInstanceEntity;)Ljava/util/List;", "addWidgetInstance", "widgetInstanceEntity", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/WidgetInstanceEntity;", "addWidgetInstanceWithoutPositionCorrection", "addWidgetInstances", "widgetInstanceEntities", "([Lcom/magneticchen/daijishou/daijishou_widget/widget_db/WidgetInstanceEntity;)Ljava/util/List;", "addWidgetInstancesWithoutPositionCorrection", "clearAll", "", "countAllAppShortcutWidgetInstances", "Landroidx/lifecycle/LiveData;", "", "countAllAppShortcutWidgetInstancesStatically", "deleteAppShortcutWidgetInstanceEntityImage", "deleteImageBlockWidgetInstanceEntityImage", "deletePinAndPlayWidgetInstanceEntityImage", "getAllAppShortcutWidgetInstances", "getAllAppShortcutWidgetInstancesStatically", "getAllImageBlockWidgetInstances", "getAllImageBlockWidgetInstancesStatically", "getAllPinAndPlayWidgetInstances", "getAllPinAndPlayWidgetInstancesStatically", "getAllRSSWidgetInstances", "getAllRSSWidgetInstancesStatically", "getAllWidgetInstanceIds", "getAllWidgetInstanceIdsStatically", "getAllWidgetInstances", "getAllWidgetInstancesStatically", "getAppShortcutWidgetInstanceById", "id", "getAppShortcutWidgetInstanceByIdStatically", "getImageBlockWidgetInstanceById", "getImageBlockWidgetInstanceByIdStatically", "getPinAndPlayWidgetInstanceById", "getPinAndPlayWidgetInstanceByIdStatically", "getPinAndPlayWidgetInstanceByPlayableItemId", "getPinAndPlayWidgetInstanceByPlayableItemIdStatically", "getPinAndPlayWidgetInstanceByPlayableItemIds", "ids", "", "getPinAndPlayWidgetInstanceByPlayableItemIdsStatically", "getRSSWidgetInstanceById", "getRSSWidgetInstanceByIdStatically", "getWidgetInstanceByIdStatically", "getWidgetInstanceByWidgetIdAndWidgetInstanceIdStatically", "widgetId", "widgetInstanceId", "movePosition", "fromPosition", "toPosition", "removeAppShortcutWidgetInstanceById", "removeImageBlockWidgetInstanceById", "removePinAndPlayWidgetInstanceById", "removeRSSWidgetInstanceById", "removeWidgetInstance", "removeWidgetInstanceById", "updateAppShortcutWidgetInstance", "updateImageBlockWidgetInstance", "updatePinAndPlayWidgetInstance", "updateRSSWidgetInstance", "updateWidgetInstance", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouWidgetRepository {
    private final AppShortcutWidgetInstanceDAO appShortcutWidgetInstanceDAO;
    private final DaijishouApplication application;
    private final WidgetDatabase database;
    private final String databaseName;
    private final ImageBlockWidgetInstanceDAO imageBlockWidgetInstanceDAO;
    private final PinAndPlayWidgetInstanceDAO pinAndPlayWidgetInstanceDAO;
    private final RSSWidgetInstanceDAO rssWidgetInstanceDAO;
    private final WidgetInstanceDAO widgetInstanceDAO;

    public DaijishouWidgetRepository(Application application, String databaseName) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        this.databaseName = databaseName;
        DaijishouApplication daijishouApplication = (DaijishouApplication) application;
        this.application = daijishouApplication;
        WidgetDatabase companion = WidgetDatabase.INSTANCE.getInstance(daijishouApplication, databaseName);
        this.database = companion;
        this.widgetInstanceDAO = companion.widgetInstanceDAO();
        this.imageBlockWidgetInstanceDAO = companion.imageBlockWidgetInstanceDAO();
        this.pinAndPlayWidgetInstanceDAO = companion.pinAndPlayWidgetInstanceDAO();
        this.appShortcutWidgetInstanceDAO = companion.appShortcutWidgetInstanceDAO();
        this.rssWidgetInstanceDAO = companion.rssWidgetInstanceDAO();
    }

    public /* synthetic */ DaijishouWidgetRepository(Application application, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i & 2) != 0 ? WidgetDatabase.DB_NAME : str);
    }

    public final void clearAll() {
        this.database.clearAllTables();
    }

    private final void deleteImageBlockWidgetInstanceEntityImage(ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity) {
        String imagePath = imageBlockWidgetInstanceEntity.getImagePath();
        if (imagePath == null) {
            return;
        }
        File file = new File(imagePath);
        if (file.exists()) {
            FilesKt.deleteRecursively(file);
        }
    }

    public final void deletePinAndPlayWidgetInstanceEntityImage(PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(pinAndPlayWidgetInstanceEntity, "pinAndPlayWidgetInstanceEntity");
        String alternativeImagePath = pinAndPlayWidgetInstanceEntity.getAlternativeImagePath();
        if (alternativeImagePath == null) {
            return;
        }
        File file = new File(alternativeImagePath);
        if (file.exists()) {
            FilesKt.deleteRecursively(file);
        }
    }

    public final void deleteAppShortcutWidgetInstanceEntityImage(AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(appShortcutWidgetInstanceEntity, "appShortcutWidgetInstanceEntity");
        String alternativeImagePath = appShortcutWidgetInstanceEntity.getAlternativeImagePath();
        if (alternativeImagePath == null) {
            return;
        }
        File file = new File(alternativeImagePath);
        if (file.exists()) {
            FilesKt.deleteRecursively(file);
        }
    }

    public final long addWidgetInstance(WidgetInstanceEntity widgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(widgetInstanceEntity, "widgetInstanceEntity");
        return this.widgetInstanceDAO.insert(widgetInstanceEntity);
    }

    public final List<Long> addWidgetInstances(WidgetInstanceEntity... widgetInstanceEntities) {
        Intrinsics.checkNotNullParameter(widgetInstanceEntities, "widgetInstanceEntities");
        return this.widgetInstanceDAO.insertAll((WidgetInstanceEntity[]) Arrays.copyOf(widgetInstanceEntities, widgetInstanceEntities.length));
    }

    public final long addWidgetInstanceWithoutPositionCorrection(WidgetInstanceEntity widgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(widgetInstanceEntity, "widgetInstanceEntity");
        return this.widgetInstanceDAO.insertRaw(widgetInstanceEntity);
    }

    public final List<Long> addWidgetInstancesWithoutPositionCorrection(WidgetInstanceEntity... widgetInstanceEntities) {
        Intrinsics.checkNotNullParameter(widgetInstanceEntities, "widgetInstanceEntities");
        return this.widgetInstanceDAO.insertAll((WidgetInstanceEntity[]) Arrays.copyOf(widgetInstanceEntities, widgetInstanceEntities.length));
    }

    public final void updateWidgetInstance(WidgetInstanceEntity widgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(widgetInstanceEntity, "widgetInstanceEntity");
        this.widgetInstanceDAO.update(widgetInstanceEntity);
    }

    public final void removeWidgetInstance(WidgetInstanceEntity widgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(widgetInstanceEntity, "widgetInstanceEntity");
        this.widgetInstanceDAO.delete(widgetInstanceEntity);
    }

    public final void removeWidgetInstanceById(long id2) {
        this.widgetInstanceDAO.deleteById(id2);
    }

    public final void movePosition(long id2, int fromPosition, int toPosition) {
        this.widgetInstanceDAO.movePosition(id2, fromPosition, toPosition);
    }

    public final LiveData<List<WidgetInstanceEntity>> getAllWidgetInstances() {
        return this.widgetInstanceDAO.selectAll();
    }

    public final LiveData<List<Long>> getAllWidgetInstanceIds() {
        return this.widgetInstanceDAO.selectAllIds();
    }

    public final List<Long> getAllWidgetInstanceIdsStatically() {
        return this.widgetInstanceDAO.selectAllIdsStatically();
    }

    public final List<WidgetInstanceEntity> getAllWidgetInstancesStatically() {
        return this.widgetInstanceDAO.selectAllStatically();
    }

    public final WidgetInstanceEntity getWidgetInstanceByIdStatically(long id2) {
        return this.widgetInstanceDAO.selectByIdStatically(id2);
    }

    public final WidgetInstanceEntity getWidgetInstanceByWidgetIdAndWidgetInstanceIdStatically(String widgetId, long widgetInstanceId) {
        Intrinsics.checkNotNullParameter(widgetId, "widgetId");
        return this.widgetInstanceDAO.selectByWidgetIdAndWidgetInstanceIdStatically(widgetId, widgetInstanceId);
    }

    public final long addImageBlockWidgetInstance(ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(imageBlockWidgetInstanceEntity, "imageBlockWidgetInstanceEntity");
        return this.imageBlockWidgetInstanceDAO.insert(imageBlockWidgetInstanceEntity);
    }

    public final List<Long> addImageBlockWidgetInstances(ImageBlockWidgetInstanceEntity... imageBlockWidgetInstanceEntities) {
        Intrinsics.checkNotNullParameter(imageBlockWidgetInstanceEntities, "imageBlockWidgetInstanceEntities");
        return this.imageBlockWidgetInstanceDAO.insertAll((ImageBlockWidgetInstanceEntity[]) Arrays.copyOf(imageBlockWidgetInstanceEntities, imageBlockWidgetInstanceEntities.length));
    }

    public final void updateImageBlockWidgetInstance(ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(imageBlockWidgetInstanceEntity, "imageBlockWidgetInstanceEntity");
        imageBlockWidgetInstanceEntity.setLastUpdateTimestamp(new Date());
        this.imageBlockWidgetInstanceDAO.update(imageBlockWidgetInstanceEntity);
    }

    public final void removeImageBlockWidgetInstanceById(long id2) {
        ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceByIdStatically = getImageBlockWidgetInstanceByIdStatically(id2);
        if (imageBlockWidgetInstanceByIdStatically != null) {
            deleteImageBlockWidgetInstanceEntityImage(imageBlockWidgetInstanceByIdStatically);
            this.imageBlockWidgetInstanceDAO.delete(imageBlockWidgetInstanceByIdStatically);
        }
    }

    public final LiveData<ImageBlockWidgetInstanceEntity> getImageBlockWidgetInstanceById(long id2) {
        return this.imageBlockWidgetInstanceDAO.selectById(id2);
    }

    public final ImageBlockWidgetInstanceEntity getImageBlockWidgetInstanceByIdStatically(long id2) {
        return this.imageBlockWidgetInstanceDAO.selectByIdStatically(id2);
    }

    public final LiveData<List<ImageBlockWidgetInstanceEntity>> getAllImageBlockWidgetInstances() {
        return this.imageBlockWidgetInstanceDAO.selectAll();
    }

    public final List<ImageBlockWidgetInstanceEntity> getAllImageBlockWidgetInstancesStatically() {
        return this.imageBlockWidgetInstanceDAO.selectAllStatically();
    }

    public final long addRSSWidgetInstance(RSSWidgetInstanceEntity rssWidgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(rssWidgetInstanceEntity, "rssWidgetInstanceEntity");
        return this.rssWidgetInstanceDAO.insert(rssWidgetInstanceEntity);
    }

    public final List<Long> addRSSWidgetInstances(RSSWidgetInstanceEntity... rssWidgetInstanceEntities) {
        Intrinsics.checkNotNullParameter(rssWidgetInstanceEntities, "rssWidgetInstanceEntities");
        return this.rssWidgetInstanceDAO.insertAll((RSSWidgetInstanceEntity[]) Arrays.copyOf(rssWidgetInstanceEntities, rssWidgetInstanceEntities.length));
    }

    public final void updateRSSWidgetInstance(RSSWidgetInstanceEntity rssWidgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(rssWidgetInstanceEntity, "rssWidgetInstanceEntity");
        rssWidgetInstanceEntity.setLastUpdateTimestamp(new Date());
        this.rssWidgetInstanceDAO.update(rssWidgetInstanceEntity);
    }

    public final void removeRSSWidgetInstanceById(long id2) {
        this.rssWidgetInstanceDAO.deleteById(id2);
    }

    public final LiveData<RSSWidgetInstanceEntity> getRSSWidgetInstanceById(long id2) {
        return this.rssWidgetInstanceDAO.selectById(id2);
    }

    public final RSSWidgetInstanceEntity getRSSWidgetInstanceByIdStatically(long id2) {
        return this.rssWidgetInstanceDAO.selectByIdStatically(id2);
    }

    public final LiveData<List<RSSWidgetInstanceEntity>> getAllRSSWidgetInstances() {
        return this.rssWidgetInstanceDAO.selectAll();
    }

    public final List<RSSWidgetInstanceEntity> getAllRSSWidgetInstancesStatically() {
        return this.rssWidgetInstanceDAO.selectAllStatically();
    }

    public final long addPinAndPlayWidgetInstance(PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(pinAndPlayWidgetInstanceEntity, "pinAndPlayWidgetInstanceEntity");
        return this.pinAndPlayWidgetInstanceDAO.insert(pinAndPlayWidgetInstanceEntity);
    }

    public final List<Long> addPinAndPlayWidgetInstances(PinAndPlayWidgetInstanceEntity... pinAndPlayWidgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(pinAndPlayWidgetInstanceEntity, "pinAndPlayWidgetInstanceEntity");
        return this.pinAndPlayWidgetInstanceDAO.insertAll((PinAndPlayWidgetInstanceEntity[]) Arrays.copyOf(pinAndPlayWidgetInstanceEntity, pinAndPlayWidgetInstanceEntity.length));
    }

    public final void updatePinAndPlayWidgetInstance(PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(pinAndPlayWidgetInstanceEntity, "pinAndPlayWidgetInstanceEntity");
        pinAndPlayWidgetInstanceEntity.setLastUpdateTimestamp(new Date());
        this.pinAndPlayWidgetInstanceDAO.update(pinAndPlayWidgetInstanceEntity);
    }

    public final void removePinAndPlayWidgetInstanceById(long id2) {
        PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceByIdStatically = getPinAndPlayWidgetInstanceByIdStatically(id2);
        if (pinAndPlayWidgetInstanceByIdStatically != null) {
            deletePinAndPlayWidgetInstanceEntityImage(pinAndPlayWidgetInstanceByIdStatically);
            this.pinAndPlayWidgetInstanceDAO.deleteById(id2);
        }
    }

    public final LiveData<List<PinAndPlayWidgetInstanceEntity>> getAllPinAndPlayWidgetInstances() {
        return this.pinAndPlayWidgetInstanceDAO.selectAll();
    }

    public final List<PinAndPlayWidgetInstanceEntity> getAllPinAndPlayWidgetInstancesStatically() {
        return this.pinAndPlayWidgetInstanceDAO.selectAllStatically();
    }

    public final LiveData<PinAndPlayWidgetInstanceEntity> getPinAndPlayWidgetInstanceById(long id2) {
        return this.pinAndPlayWidgetInstanceDAO.selectById(id2);
    }

    public final PinAndPlayWidgetInstanceEntity getPinAndPlayWidgetInstanceByIdStatically(long id2) {
        return this.pinAndPlayWidgetInstanceDAO.selectByIdStatically(id2);
    }

    public final LiveData<PinAndPlayWidgetInstanceEntity> getPinAndPlayWidgetInstanceByPlayableItemId(long id2) {
        return this.pinAndPlayWidgetInstanceDAO.selectByPlayableItemId(id2);
    }

    public final PinAndPlayWidgetInstanceEntity getPinAndPlayWidgetInstanceByPlayableItemIdStatically(long id2) {
        return this.pinAndPlayWidgetInstanceDAO.selectByPlayableItemIdStatically(id2);
    }

    public final LiveData<List<PinAndPlayWidgetInstanceEntity>> getPinAndPlayWidgetInstanceByPlayableItemIds(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.pinAndPlayWidgetInstanceDAO.selectByPlayableItemIds(Arrays.copyOf(ids, ids.length));
    }

    public final List<PinAndPlayWidgetInstanceEntity> getPinAndPlayWidgetInstanceByPlayableItemIdsStatically(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.pinAndPlayWidgetInstanceDAO.selectByPlayableItemIdsStatically(Arrays.copyOf(ids, ids.length));
    }

    public final LiveData<Integer> countAllAppShortcutWidgetInstances() {
        return this.appShortcutWidgetInstanceDAO.countAll();
    }

    public final int countAllAppShortcutWidgetInstancesStatically() {
        return this.appShortcutWidgetInstanceDAO.countAllStatically();
    }

    public final LiveData<List<AppShortcutWidgetInstanceEntity>> getAllAppShortcutWidgetInstances() {
        return this.appShortcutWidgetInstanceDAO.selectAll();
    }

    public final List<AppShortcutWidgetInstanceEntity> getAllAppShortcutWidgetInstancesStatically() {
        return this.appShortcutWidgetInstanceDAO.selectAllStatically();
    }

    public final long addAppShortcutWidgetInstance(AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(appShortcutWidgetInstanceEntity, "appShortcutWidgetInstanceEntity");
        return this.appShortcutWidgetInstanceDAO.insert(appShortcutWidgetInstanceEntity);
    }

    public final List<Long> addAppShortcutWidgetInstances(AppShortcutWidgetInstanceEntity... appShortcutWidgetInstanceEntities) {
        Intrinsics.checkNotNullParameter(appShortcutWidgetInstanceEntities, "appShortcutWidgetInstanceEntities");
        return this.appShortcutWidgetInstanceDAO.insertAll((AppShortcutWidgetInstanceEntity[]) Arrays.copyOf(appShortcutWidgetInstanceEntities, appShortcutWidgetInstanceEntities.length));
    }

    public final void updateAppShortcutWidgetInstance(AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceEntity) {
        Intrinsics.checkNotNullParameter(appShortcutWidgetInstanceEntity, "appShortcutWidgetInstanceEntity");
        appShortcutWidgetInstanceEntity.setLastUpdateTimestamp(new Date());
        this.appShortcutWidgetInstanceDAO.update(appShortcutWidgetInstanceEntity);
    }

    public final void removeAppShortcutWidgetInstanceById(long id2) {
        AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceByIdStatically = getAppShortcutWidgetInstanceByIdStatically(id2);
        if (appShortcutWidgetInstanceByIdStatically != null) {
            deleteAppShortcutWidgetInstanceEntityImage(appShortcutWidgetInstanceByIdStatically);
            this.appShortcutWidgetInstanceDAO.deleteById(id2);
        }
    }

    public final LiveData<AppShortcutWidgetInstanceEntity> getAppShortcutWidgetInstanceById(long id2) {
        return this.appShortcutWidgetInstanceDAO.selectById(id2);
    }

    public final AppShortcutWidgetInstanceEntity getAppShortcutWidgetInstanceByIdStatically(long id2) {
        return this.appShortcutWidgetInstanceDAO.selectByIdStatically(id2);
    }
}
