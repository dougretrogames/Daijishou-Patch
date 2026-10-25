package org.eclipse.jgit.transport;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.errors.InvalidObjectIdException;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
final class ProtocolV2Parser {
    private final TransferConfig transferConfig;

    ProtocolV2Parser(TransferConfig transferConfig) {
        this.transferConfig = transferConfig;
    }

    private static String consumeCapabilities(PacketLineIn packetLineIn, Consumer<String> consumer, Consumer<String> consumer2, Consumer<String> consumer3) throws IOException {
        String string = packetLineIn.readString();
        while (!PacketLineIn.isDelimiter(string) && !PacketLineIn.isEnd(string)) {
            if (string.startsWith("server-option=")) {
                consumer.accept(string.substring("server-option=".length()));
            } else if (string.startsWith("agent=")) {
                consumer2.accept(string.substring("agent=".length()));
            } else if (string.startsWith("session-id=")) {
                consumer3.accept(string.substring("session-id=".length()));
            }
            string = packetLineIn.readString();
        }
        return string;
    }

    FetchV2Request parseFetchRequest(PacketLineIn packetLineIn) throws IOException {
        FetchV2Request.Builder builder = FetchV2Request.builder();
        builder.addClientCapability("side-band-64k");
        String strConsumeCapabilities = consumeCapabilities(packetLineIn, new ProtocolV2Parser$$ExternalSyntheticLambda3(builder), new ProtocolV2Parser$$ExternalSyntheticLambda4(builder), new ProtocolV2Parser$$ExternalSyntheticLambda5(builder));
        if (PacketLineIn.isEnd(strConsumeCapabilities)) {
            return builder.build();
        }
        if (!PacketLineIn.isDelimiter(strConsumeCapabilities)) {
            throw new PackProtocolException(MessageFormat.format(JGitText.get().unexpectedPacketLine, strConsumeCapabilities));
        }
        boolean z = false;
        for (String str : packetLineIn.readStrings()) {
            if (str.startsWith(GitProtocolConstants.PACKET_WANT)) {
                builder.addWantId(ObjectId.fromString(str.substring(GitProtocolConstants.PACKET_WANT.length())));
            } else if (this.transferConfig.isAllowRefInWant() && str.startsWith(GitProtocolConstants.PACKET_WANT_REF)) {
                builder.addWantedRef(str.substring(GitProtocolConstants.PACKET_WANT_REF.length()));
            } else if (str.startsWith(GitProtocolConstants.PACKET_HAVE)) {
                builder.addPeerHas(ObjectId.fromString(str.substring(GitProtocolConstants.PACKET_HAVE.length())));
            } else if (str.equals(GitProtocolConstants.PACKET_DONE)) {
                builder.setDoneReceived();
            } else if (str.equals(GitProtocolConstants.OPTION_WAIT_FOR_DONE)) {
                builder.setWaitForDone();
            } else if (str.equals("thin-pack")) {
                builder.addClientCapability("thin-pack");
            } else if (str.equals("no-progress")) {
                builder.addClientCapability("no-progress");
            } else if (str.equals("include-tag")) {
                builder.addClientCapability("include-tag");
            } else if (str.equals("ofs-delta")) {
                builder.addClientCapability("ofs-delta");
            } else if (str.startsWith(GitProtocolConstants.PACKET_SHALLOW)) {
                builder.addClientShallowCommit(ObjectId.fromString(str.substring(GitProtocolConstants.PACKET_SHALLOW.length())));
            } else if (str.startsWith(GitProtocolConstants.PACKET_DEEPEN)) {
                int i = Integer.parseInt(str.substring(GitProtocolConstants.PACKET_DEEPEN.length()));
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
            } else if (str.startsWith(GitProtocolConstants.PACKET_DEEPEN_NOT)) {
                builder.addDeepenNot(str.substring(GitProtocolConstants.PACKET_DEEPEN_NOT.length()));
                if (builder.getDepth() != 0) {
                    throw new PackProtocolException(JGitText.get().deepenNotWithDeepen);
                }
            } else if (str.equals(GitProtocolConstants.OPTION_DEEPEN_RELATIVE)) {
                builder.addClientCapability(GitProtocolConstants.OPTION_DEEPEN_RELATIVE);
            } else if (str.startsWith(GitProtocolConstants.PACKET_DEEPEN_SINCE)) {
                int i2 = Integer.parseInt(str.substring(GitProtocolConstants.PACKET_DEEPEN_SINCE.length()));
                if (i2 <= 0) {
                    throw new PackProtocolException(MessageFormat.format(JGitText.get().invalidTimestamp, str));
                }
                if (builder.getDepth() != 0) {
                    throw new PackProtocolException(JGitText.get().deepenSinceWithDeepen);
                }
                builder.setDeepenSince(i2);
            } else if (this.transferConfig.isAllowFilter() && str.startsWith("filter ")) {
                if (z) {
                    throw new PackProtocolException(JGitText.get().tooManyFilters);
                }
                builder.setFilterSpec(FilterSpec.fromFilterLine(str.substring("filter".length() + 1)));
                z = true;
            } else if (this.transferConfig.isAllowSidebandAll() && str.equals(GitProtocolConstants.OPTION_SIDEBAND_ALL)) {
                builder.setSidebandAll(true);
            } else if (str.startsWith("packfile-uris ")) {
                String[] strArrSplit = str.substring(14).split(CollectionUtils.COMMA);
                for (String str2 : strArrSplit) {
                    builder.addPackfileUriProtocol(str2);
                }
            } else {
                throw new PackProtocolException(MessageFormat.format(JGitText.get().unexpectedPacketLine, str));
            }
        }
        return builder.build();
    }

    LsRefsV2Request parseLsRefsRequest(PacketLineIn packetLineIn) throws IOException {
        LsRefsV2Request.Builder builder = LsRefsV2Request.builder();
        ArrayList arrayList = new ArrayList();
        String strConsumeCapabilities = consumeCapabilities(packetLineIn, new ProtocolV2Parser$$ExternalSyntheticLambda0(builder), new ProtocolV2Parser$$ExternalSyntheticLambda1(builder), new ProtocolV2Parser$$ExternalSyntheticLambda2(builder));
        if (PacketLineIn.isEnd(strConsumeCapabilities)) {
            return builder.build();
        }
        if (!PacketLineIn.isDelimiter(strConsumeCapabilities)) {
            throw new PackProtocolException(MessageFormat.format(JGitText.get().unexpectedPacketLine, strConsumeCapabilities));
        }
        for (String str : packetLineIn.readStrings()) {
            if (str.equals("peel")) {
                builder.setPeel(true);
            } else if (str.equals("symrefs")) {
                builder.setSymrefs(true);
            } else if (str.startsWith("ref-prefix ")) {
                arrayList.add(str.substring("ref-prefix ".length()));
            } else {
                throw new PackProtocolException(MessageFormat.format(JGitText.get().unexpectedPacketLine, str));
            }
        }
        return builder.setRefPrefixes(arrayList).build();
    }

    ObjectInfoRequest parseObjectInfoRequest(PacketLineIn packetLineIn) throws IOException {
        ObjectInfoRequest.Builder builder = ObjectInfoRequest.builder();
        ArrayList arrayList = new ArrayList();
        String string = packetLineIn.readString();
        if (PacketLineIn.isEnd(string)) {
            return builder.build();
        }
        if (!PacketLineIn.isDelimiter(string)) {
            throw new PackProtocolException(MessageFormat.format(JGitText.get().unexpectedPacketLine, string));
        }
        String string2 = packetLineIn.readString();
        if (!string2.equals("size")) {
            throw new PackProtocolException(MessageFormat.format(JGitText.get().unexpectedPacketLine, string2));
        }
        for (String str : packetLineIn.readStrings()) {
            if (!str.startsWith("oid ")) {
                throw new PackProtocolException(MessageFormat.format(JGitText.get().unexpectedPacketLine, str));
            }
            String strSubstring = str.substring("oid ".length());
            try {
                arrayList.add(ObjectId.fromString(strSubstring));
            } catch (InvalidObjectIdException e) {
                throw new PackProtocolException(MessageFormat.format(JGitText.get().invalidObject, strSubstring), e);
            }
        }
        return builder.setObjectIDs(arrayList).build();
    }
}
