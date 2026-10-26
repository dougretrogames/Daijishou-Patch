package org.eclipse.jgit.transport;

import java.io.EOFException;
import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.transport.parser.FirstWant;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
final class ProtocolV0Parser {
    private final TransferConfig transferConfig;

    ProtocolV0Parser(TransferConfig transferConfig) {
        this.transferConfig = transferConfig;
    }

    FetchV0Request recvWants(PacketLineIn packetLineIn) throws IOException {
        FetchV0Request.Builder builder = new FetchV0Request.Builder();
        boolean z = true;
        boolean z2 = false;
        while (true) {
            try {
                String string = packetLineIn.readString();
                if (PacketLineIn.isEnd(string)) {
                    break;
                }
                if (string.startsWith(GitProtocolConstants.PACKET_DEEPEN)) {
                    int i = Integer.parseInt(string.substring(GitProtocolConstants.PACKET_DEEPEN.length()));
                    if (i <= 0) {
                        throw new PackProtocolException(MessageFormat.format(JGitText.get().invalidDepth, Integer.valueOf(i)));
                    }
                    if (builder.getDeepenSince() != 0) {
                        throw new PackProtocolException(JGitText.get().deepenSinceWithDeepen);
                    }
                    if (builder.hasDeepenNots()) {
                        throw new PackProtocolException(JGitText.get().deepenNotWithDeepen);
                    }
                    builder.setDepth(i);
                } else if (string.startsWith(GitProtocolConstants.PACKET_DEEPEN_NOT)) {
                    builder.addDeepenNot(string.substring(GitProtocolConstants.PACKET_DEEPEN_NOT.length()));
                    if (builder.getDepth() != 0) {
                        throw new PackProtocolException(JGitText.get().deepenNotWithDeepen);
                    }
                } else if (string.startsWith(GitProtocolConstants.PACKET_DEEPEN_SINCE)) {
                    int i2 = Integer.parseInt(string.substring(GitProtocolConstants.PACKET_DEEPEN_SINCE.length()));
                    if (i2 <= 0) {
                        throw new PackProtocolException(MessageFormat.format(JGitText.get().invalidTimestamp, string));
                    }
                    if (builder.getDepth() != 0) {
                        throw new PackProtocolException(JGitText.get().deepenSinceWithDeepen);
                    }
                    builder.setDeepenSince(i2);
                } else if (string.startsWith(GitProtocolConstants.PACKET_SHALLOW)) {
                    builder.addClientShallowCommit(ObjectId.fromString(string.substring(GitProtocolConstants.PACKET_SHALLOW.length())));
                } else if (this.transferConfig.isAllowFilter() && string.startsWith("filter ")) {
                    String strSubstring = string.substring("filter".length() + 1);
                    if (z2) {
                        throw new PackProtocolException(JGitText.get().tooManyFilters);
                    }
                    builder.setFilterSpec(FilterSpec.fromFilterLine(strSubstring));
                    z2 = true;
                } else {
                    if (!string.startsWith(GitProtocolConstants.PACKET_WANT) || string.length() < 45) {
                        throw new PackProtocolException(MessageFormat.format(JGitText.get().expectedGot, "want", string));
                    }
                    if (z && string.length() > 45) {
                        FirstWant firstWantFromLine = FirstWant.fromLine(string);
                        builder.addClientCapabilities(firstWantFromLine.getCapabilities());
                        builder.setAgent(firstWantFromLine.getAgent());
                        builder.setClientSID(firstWantFromLine.getClientSID());
                        string = firstWantFromLine.getLine();
                    }
                    builder.addWantId(ObjectId.fromString(string.substring(GitProtocolConstants.PACKET_WANT.length())));
                    z = false;
                }
            } catch (EOFException e) {
                if (!z) {
                    throw e;
                }
            }
        }
        return builder.build();
    }
}
