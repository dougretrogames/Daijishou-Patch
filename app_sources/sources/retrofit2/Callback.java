package retrofit2;

/* INFO: loaded from: classes6.dex */
public interface Callback<T> {
    void onFailure(Call<T> call, Throwable th);

    void onResponse(Call<T> call, Response<T> response);
}
