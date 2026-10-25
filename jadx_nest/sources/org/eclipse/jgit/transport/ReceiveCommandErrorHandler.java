package org.eclipse.jgit.transport;

import java.io.IOException;
import java.util.List;
import org.eclipse.jgit.errors.MissingObjectException;

/* JADX INFO: loaded from: classes5.dex */
public interface ReceiveCommandErrorHandler {
    default void handleNewIdValidationException(ReceiveCommand receiveCommand, IOException iOException) {
        receiveCommand.setResult(ReceiveCommand.Result.REJECTED_MISSING_OBJECT, receiveCommand.getNewId().name());
    }

    default void handleOldIdValidationException(ReceiveCommand receiveCommand, IOException iOException) {
        receiveCommand.setResult(ReceiveCommand.Result.REJECTED_MISSING_OBJECT, receiveCommand.getOldId().name());
    }

    default void handleFastForwardCheckException(ReceiveCommand receiveCommand, IOException iOException) {
        if (iOException instanceof MissingObjectException) {
            receiveCommand.setResult(ReceiveCommand.Result.REJECTED_MISSING_OBJECT, iOException.getMessage());
        } else {
            receiveCommand.setResult(ReceiveCommand.Result.REJECTED_OTHER_REASON);
        }
    }

    default void handleBatchRefUpdateException(List<ReceiveCommand> list, IOException iOException) {
        for (ReceiveCommand receiveCommand : list) {
            if (receiveCommand.getResult() == ReceiveCommand.Result.NOT_ATTEMPTED) {
                receiveCommand.reject(iOException);
            }
        }
    }
}
