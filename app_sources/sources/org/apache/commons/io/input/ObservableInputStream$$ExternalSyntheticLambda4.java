package org.apache.commons.io.input;

import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class ObservableInputStream$$ExternalSyntheticLambda4 implements IOConsumer {
    public final /* synthetic */ IOException f$0;

    public /* synthetic */ ObservableInputStream$$ExternalSyntheticLambda4(IOException iOException) {
        this.f$0 = iOException;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        ((ObservableInputStream.Observer) obj).error(this.f$0);
    }
}
