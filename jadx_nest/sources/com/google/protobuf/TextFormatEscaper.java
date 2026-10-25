package com.google.protobuf;

/* JADX INFO: loaded from: classes4.dex */
final class TextFormatEscaper {

    private interface ByteSequence {
        byte byteAt(int offset);

        int size();
    }

    private TextFormatEscaper() {
    }

    static String escapeBytes(ByteSequence input) {
        StringBuilder sb = new StringBuilder(input.size());
        for (int i = 0; i < input.size(); i++) {
            byte bByteAt = input.byteAt(i);
            if (bByteAt == 34) {
                sb.append("\\\"");
            } else if (bByteAt == 39) {
                sb.append("\\'");
            } else if (bByteAt != 92) {
                switch (bByteAt) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bByteAt >= 32 && bByteAt <= 126) {
                            sb.append((char) bByteAt);
                        } else {
                            sb.append('\\');
                            sb.append((char) (((bByteAt >>> 6) & 3) + 48));
                            sb.append((char) (((bByteAt >>> 3) & 7) + 48));
                            sb.append((char) ((bByteAt & 7) + 48));
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: com.google.protobuf.TextFormatEscaper$1, reason: invalid class name */
    class AnonymousClass1 implements ByteSequence {
        final /* synthetic */ ByteString val$input;

        AnonymousClass1(final ByteString val$input) {
            this.val$input = val$input;
        }

        @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
        public int size() {
            return this.val$input.size();
        }

        @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
        public byte byteAt(int offset) {
            return this.val$input.byteAt(offset);
        }
    }

    static String escapeBytes(final ByteString input) {
        return escapeBytes(new AnonymousClass1(input));
    }

    /* JADX INFO: renamed from: com.google.protobuf.TextFormatEscaper$2, reason: invalid class name */
    class AnonymousClass2 implements ByteSequence {
        final /* synthetic */ byte[] val$input;

        AnonymousClass2(final byte[] val$input) {
            this.val$input = val$input;
        }

        @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
        public int size() {
            return this.val$input.length;
        }

        @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
        public byte byteAt(int offset) {
            return this.val$input[offset];
        }
    }

    static String escapeBytes(final byte[] input) {
        return escapeBytes(new AnonymousClass2(input));
    }

    static String escapeText(String input) {
        return escapeBytes(ByteString.copyFromUtf8(input));
    }

    static String escapeDoubleQuotesAndBackslashes(String input) {
        return input.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
