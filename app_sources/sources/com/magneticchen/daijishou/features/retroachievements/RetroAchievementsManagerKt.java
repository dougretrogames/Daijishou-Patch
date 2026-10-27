package com.magneticchen.daijishou.features.retroachievements;

import com.haroldadmin.cnradapter.NetworkResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.retroachivements.api.data.pojo.ErrorResponse;

/* INFO: compiled from: RetroAchievementsManager.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"areCredentialsInvalid", "", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "Lorg/retroachivements/api/data/pojo/ErrorResponse;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsManagerKt {
    public static final boolean areCredentialsInvalid(NetworkResponse<?, ErrorResponse> networkResponse) {
        ErrorResponse errorResponse;
        ArrayList<ErrorResponse.Error> errors;
        Intrinsics.checkNotNullParameter(networkResponse, "<this>");
        if ((networkResponse instanceof NetworkResponse.Error) && (errorResponse = (ErrorResponse) ((NetworkResponse.Error) networkResponse).getBody()) != null && (errors = errorResponse.getErrors()) != null) {
            ArrayList<ErrorResponse.Error> arrayList = errors;
            if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
                return false;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((ErrorResponse.Error) it.next()).getStatus() == 419) {
                    return true;
                }
            }
        }
        return false;
    }
}
