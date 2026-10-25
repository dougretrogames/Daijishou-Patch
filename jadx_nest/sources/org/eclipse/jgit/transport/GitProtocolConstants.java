package org.eclipse.jgit.transport;

/* JADX INFO: loaded from: classes5.dex */
public final class GitProtocolConstants {
    public static final String CAPABILITY_ATOMIC = "atomic";
    public static final String CAPABILITY_DELETE_REFS = "delete-refs";
    public static final String CAPABILITY_OFS_DELTA = "ofs-delta";
    public static final String CAPABILITY_PUSH_CERT = "push-cert";
    public static final String CAPABILITY_PUSH_OPTIONS = "push-options";
    public static final String CAPABILITY_QUIET = "quiet";
    public static final String CAPABILITY_REF_IN_WANT = "ref-in-want";
    public static final String CAPABILITY_REPORT_STATUS = "report-status";
    public static final String CAPABILITY_SERVER_OPTION = "server-option";
    public static final String CAPABILITY_SHALLOW = "shallow";
    public static final String CAPABILITY_SIDE_BAND_64K = "side-band-64k";
    public static final String COMMAND_FETCH = "fetch";
    public static final String COMMAND_LS_REFS = "ls-refs";
    public static final String COMMAND_OBJECT_INFO = "object-info";
    public static final String OPTION_AGENT = "agent";
    public static final String OPTION_ALLOW_REACHABLE_SHA1_IN_WANT = "allow-reachable-sha1-in-want";
    public static final String OPTION_ALLOW_TIP_SHA1_IN_WANT = "allow-tip-sha1-in-want";
    public static final String OPTION_DEEPEN_RELATIVE = "deepen-relative";
    public static final String OPTION_FILTER = "filter";
    public static final String OPTION_INCLUDE_TAG = "include-tag";
    public static final String OPTION_MULTI_ACK = "multi_ack";
    public static final String OPTION_MULTI_ACK_DETAILED = "multi_ack_detailed";
    public static final String OPTION_NO_DONE = "no-done";
    public static final String OPTION_NO_PROGRESS = "no-progress";
    public static final String OPTION_OFS_DELTA = "ofs-delta";
    public static final String OPTION_PUSH_CERT = "push-cert";
    public static final String OPTION_SERVER_OPTION = "server-option";
    public static final String OPTION_SESSION_ID = "session-id";
    public static final String OPTION_SHALLOW = "shallow";
    public static final String OPTION_SIDEBAND_ALL = "sideband-all";
    public static final String OPTION_SIDE_BAND = "side-band";
    public static final String OPTION_SIDE_BAND_64K = "side-band-64k";
    public static final String OPTION_SYMREF = "symref";
    public static final String OPTION_THIN_PACK = "thin-pack";
    public static final String OPTION_WAIT_FOR_DONE = "wait-for-done";
    public static final String OPTION_WANT_REF = "want-ref";
    public static final String PACKET_ACK = "ACK ";
    public static final String PACKET_DEEPEN = "deepen ";
    public static final String PACKET_DEEPEN_NOT = "deepen-not ";
    public static final String PACKET_DEEPEN_SINCE = "deepen-since ";
    public static final String PACKET_DELIM = "0001";
    public static final String PACKET_DONE = "done";
    public static final String PACKET_END = "0000";
    public static final String PACKET_ERR = "ERR ";
    public static final String PACKET_FLUSH = "0000";
    public static final String PACKET_HAVE = "have ";
    public static final String PACKET_SHALLOW = "shallow ";
    public static final String PACKET_UNSHALLOW = "unshallow ";
    public static final String PACKET_WANT = "want ";
    public static final String PACKET_WANT_REF = "want-ref ";
    public static final String PROTOCOL_ENVIRONMENT_VARIABLE = "GIT_PROTOCOL";
    public static final String PROTOCOL_HEADER = "Git-Protocol";
    public static final String REF_ATTR_PEELED = "peeled:";
    public static final String REF_ATTR_SYMREF_TARGET = "symref-target:";
    public static final String SECTION_ACKNOWLEDGMENTS = "acknowledgments";
    public static final String SECTION_PACKFILE = "packfile";
    public static final String SECTION_SHALLOW_INFO = "shallow-info";
    public static final String VERSION_1 = "version 1";
    public static final String VERSION_2 = "version 2";
    public static final String VERSION_2_REQUEST = "version=2";

    enum MultiAck {
        OFF,
        CONTINUE,
        DETAILED;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static MultiAck[] valuesCustom() {
            MultiAck[] multiAckArrValuesCustom = values();
            int length = multiAckArrValuesCustom.length;
            MultiAck[] multiAckArr = new MultiAck[length];
            System.arraycopy(multiAckArrValuesCustom, 0, multiAckArr, 0, length);
            return multiAckArr;
        }
    }

    private GitProtocolConstants() {
    }
}
