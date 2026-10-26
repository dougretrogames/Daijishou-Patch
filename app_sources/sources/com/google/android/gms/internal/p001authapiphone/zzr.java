package com.google.android.gms.internal.p001authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsCodeAutofillClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;

/* INFO: compiled from: com.google.android.gms:play-services-auth-api-phone@@18.0.2 */
/* INFO: loaded from: classes3.dex */
public final class zzr extends GoogleApi implements SmsCodeAutofillClient {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzn zznVar = new zzn();
        zzb = zznVar;
        zzc = new Api("SmsCodeAutofill.API", zznVar, clientKey);
    }

    public zzr(Activity activity) {
        super(activity, (Api<Api.ApiOptions.NoOptions>) zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.auth.api.phone.SmsCodeAutofillClient
    public final Task<Integer> checkPermissionState() {
        return doRead(TaskApiCall.builder().setFeatures(zzac.zza).run(new zzk(this)).setMethodKey(1564).build());
    }

    @Override // com.google.android.gms.auth.api.phone.SmsCodeAutofillClient
    public final Task<Boolean> hasOngoingSmsRequest(String str) {
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(!str.isEmpty(), "The package name cannot be empty.");
        return doRead(TaskApiCall.builder().setFeatures(zzac.zza).run(new zzl(this, str)).setMethodKey(1565).build());
    }

    @Override // com.google.android.gms.auth.api.phone.SmsCodeAutofillClient
    public final Task<Void> startSmsCodeRetriever() {
        return doWrite(TaskApiCall.builder().setFeatures(zzac.zza).run(new zzm(this)).setMethodKey(1563).build());
    }

    public zzr(Context context) {
        super(context, (Api<Api.ApiOptions.NoOptions>) zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
