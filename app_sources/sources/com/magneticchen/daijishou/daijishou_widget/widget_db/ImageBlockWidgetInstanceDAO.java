package com.magneticchen.daijishou.daijishou_widget.widget_db;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: ImageBlockWidgetInstanceDAO.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0011\"\u00020\tH'¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u0003H'J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH'J\u0018\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u000b\u001a\u00020\fH'J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ImageBlockWidgetInstanceDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "imageBlockWidgetInstanceEntity", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ImageBlockWidgetInstanceEntity;", "deleteById", "id", "", "insert", "insertAll", "", "imageBlockWidgetInstanceEntities", "", "([Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ImageBlockWidgetInstanceEntity;)Ljava/util/List;", "selectAll", "selectAllStatically", "selectById", "selectByIdStatically", ConfigConstants.CONFIG_KEY_UPDATE, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ImageBlockWidgetInstanceDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity);

    void deleteById(long id2);

    long insert(ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity);

    List<Long> insertAll(ImageBlockWidgetInstanceEntity... imageBlockWidgetInstanceEntities);

    LiveData<List<ImageBlockWidgetInstanceEntity>> selectAll();

    List<ImageBlockWidgetInstanceEntity> selectAllStatically();

    LiveData<ImageBlockWidgetInstanceEntity> selectById(long id2);

    ImageBlockWidgetInstanceEntity selectByIdStatically(long id2);

    void update(ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity);
}
