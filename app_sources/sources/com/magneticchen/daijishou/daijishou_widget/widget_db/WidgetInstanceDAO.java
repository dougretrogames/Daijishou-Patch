package com.magneticchen.daijishou.daijishou_widget.widget_db;

import androidx.lifecycle.LiveData;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: WidgetInstanceDAO.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H'J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH'J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016J'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0016\"\u00020\u000bH\u0016¢\u0006\u0002\u0010\u0017J'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0016\"\u00020\u000bH'¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH'J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00140\u0003H'J\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00140\u0003H'J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H'J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H'J\u0012\u0010!\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH'J\u001a\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000eH'J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0004H'J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H'J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH'¨\u0006)"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widget_db/WidgetInstanceDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "decreasePositionFromPosition", "", "position", "delete", "widgetInstanceEntity", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/WidgetInstanceEntity;", "deleteById", "id", "", "deleteRaw", "getMaxPositionStatically", "()Ljava/lang/Integer;", "insert", "insertAll", "", "widgetInstanceEntities", "", "([Lcom/magneticchen/daijishou/daijishou_widget/widget_db/WidgetInstanceEntity;)Ljava/util/List;", "insertAllRaw", "insertRaw", "movePosition", "fromPosition", "toPosition", "selectAll", "selectAllIds", "selectAllIdsStatically", "selectAllStatically", "selectByIdStatically", "selectByWidgetIdAndWidgetInstanceIdStatically", "widgetId", "", "widgetInstanceId", "setPositionById", "swiftPositionBetween", ConfigConstants.CONFIG_KEY_UPDATE, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface WidgetInstanceDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void decreasePositionFromPosition(int position);

    void delete(WidgetInstanceEntity widgetInstanceEntity);

    void deleteById(long id2);

    void deleteRaw(WidgetInstanceEntity widgetInstanceEntity);

    Integer getMaxPositionStatically();

    long insert(WidgetInstanceEntity widgetInstanceEntity);

    List<Long> insertAll(WidgetInstanceEntity... widgetInstanceEntities);

    List<Long> insertAllRaw(WidgetInstanceEntity... widgetInstanceEntity);

    long insertRaw(WidgetInstanceEntity widgetInstanceEntity);

    void movePosition(long id2, int fromPosition, int toPosition);

    LiveData<List<WidgetInstanceEntity>> selectAll();

    LiveData<List<Long>> selectAllIds();

    List<Long> selectAllIdsStatically();

    List<WidgetInstanceEntity> selectAllStatically();

    WidgetInstanceEntity selectByIdStatically(long id2);

    WidgetInstanceEntity selectByWidgetIdAndWidgetInstanceIdStatically(String widgetId, long widgetInstanceId);

    void setPositionById(long id2, int position);

    void swiftPositionBetween(int fromPosition, int toPosition);

    void update(WidgetInstanceEntity widgetInstanceEntity);

    /* INFO: compiled from: WidgetInstanceDAO.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void movePosition(WidgetInstanceDAO widgetInstanceDAO, long j, int i, int i2) {
            widgetInstanceDAO.swiftPositionBetween(i, i2);
            widgetInstanceDAO.setPositionById(j, i2);
        }

        public static long insert(WidgetInstanceDAO widgetInstanceDAO, WidgetInstanceEntity widgetInstanceEntity) {
            Intrinsics.checkNotNullParameter(widgetInstanceEntity, "widgetInstanceEntity");
            Integer maxPositionStatically = widgetInstanceDAO.getMaxPositionStatically();
            widgetInstanceEntity.setPosition((maxPositionStatically != null ? maxPositionStatically.intValue() : -1) + 1);
            return widgetInstanceDAO.insertRaw(widgetInstanceEntity);
        }

        public static List<Long> insertAll(WidgetInstanceDAO widgetInstanceDAO, WidgetInstanceEntity... widgetInstanceEntities) {
            Intrinsics.checkNotNullParameter(widgetInstanceEntities, "widgetInstanceEntities");
            Integer maxPositionStatically = widgetInstanceDAO.getMaxPositionStatically();
            int iIntValue = (maxPositionStatically != null ? maxPositionStatically.intValue() : -1) + 1;
            for (WidgetInstanceEntity widgetInstanceEntity : widgetInstanceEntities) {
                widgetInstanceEntity.setPosition(iIntValue);
                iIntValue++;
            }
            return widgetInstanceDAO.insertAllRaw((WidgetInstanceEntity[]) Arrays.copyOf(widgetInstanceEntities, widgetInstanceEntities.length));
        }

        public static void delete(WidgetInstanceDAO widgetInstanceDAO, WidgetInstanceEntity widgetInstanceEntity) {
            Intrinsics.checkNotNullParameter(widgetInstanceEntity, "widgetInstanceEntity");
            int position = widgetInstanceEntity.getPosition();
            widgetInstanceDAO.deleteRaw(widgetInstanceEntity);
            widgetInstanceDAO.decreasePositionFromPosition(position);
        }

        public static void deleteById(WidgetInstanceDAO widgetInstanceDAO, long j) {
            WidgetInstanceEntity widgetInstanceEntitySelectByIdStatically = widgetInstanceDAO.selectByIdStatically(j);
            if (widgetInstanceEntitySelectByIdStatically != null) {
                widgetInstanceDAO.delete(widgetInstanceEntitySelectByIdStatically);
            }
        }
    }
}
