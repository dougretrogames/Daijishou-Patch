package com.magneticchen.daijishou.daijishou_widget.widget_db;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: RSSWidgetInstanceDAO.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH'J'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0010\"\u00020\tH'¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u0003H'J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH'J\u0018\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\u000b\u001a\u00020\fH'J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widget_db/RSSWidgetInstanceDAO;", "", "countAll", "Landroidx/lifecycle/LiveData;", "", "countAllStatically", "delete", "", "rssWidgetInstanceEntity", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/RSSWidgetInstanceEntity;", "deleteById", "id", "", "insert", "insertAll", "", "", "([Lcom/magneticchen/daijishou/daijishou_widget/widget_db/RSSWidgetInstanceEntity;)Ljava/util/List;", "selectAll", "selectAllStatically", "selectById", "selectByIdStatically", ConfigConstants.CONFIG_KEY_UPDATE, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface RSSWidgetInstanceDAO {
    LiveData<Integer> countAll();

    int countAllStatically();

    void delete(RSSWidgetInstanceEntity rssWidgetInstanceEntity);

    void deleteById(long id2);

    long insert(RSSWidgetInstanceEntity rssWidgetInstanceEntity);

    List<Long> insertAll(RSSWidgetInstanceEntity... rssWidgetInstanceEntity);

    LiveData<List<RSSWidgetInstanceEntity>> selectAll();

    List<RSSWidgetInstanceEntity> selectAllStatically();

    LiveData<RSSWidgetInstanceEntity> selectById(long id2);

    RSSWidgetInstanceEntity selectByIdStatically(long id2);

    void update(RSSWidgetInstanceEntity rssWidgetInstanceEntity);
}
