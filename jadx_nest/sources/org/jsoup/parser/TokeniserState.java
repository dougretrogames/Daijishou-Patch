package org.jsoup.parser;

import kotlin.text.Typography;
import org.apache.commons.codec.language.Soundex;
import org.apache.http.message.TokenParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;

/* WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* WARN: Unknown enum class pattern. Please report as an issue! */
/* INFO: loaded from: classes5.dex */
abstract class TokeniserState {
    private static final char eof = 65535;
    static final char nullChar = 0;
    private static final char replacementChar = 65533;
    public static final TokeniserState Data = new AnonymousClass1("Data", 0);
    public static final TokeniserState CharacterReferenceInData = new AnonymousClass2("CharacterReferenceInData", 1);
    public static final TokeniserState Rcdata = new AnonymousClass3("Rcdata", 2);
    public static final TokeniserState CharacterReferenceInRcdata = new AnonymousClass4("CharacterReferenceInRcdata", 3);
    public static final TokeniserState Rawtext = new AnonymousClass5("Rawtext", 4);
    public static final TokeniserState ScriptData = new AnonymousClass6("ScriptData", 5);
    public static final TokeniserState PLAINTEXT = new AnonymousClass7("PLAINTEXT", 6);
    public static final TokeniserState TagOpen = new AnonymousClass8("TagOpen", 7);
    public static final TokeniserState EndTagOpen = new AnonymousClass9("EndTagOpen", 8);
    public static final TokeniserState TagName = new AnonymousClass10("TagName", 9);
    public static final TokeniserState RcdataLessthanSign = new AnonymousClass11("RcdataLessthanSign", 10);
    public static final TokeniserState RCDATAEndTagOpen = new AnonymousClass12("RCDATAEndTagOpen", 11);
    public static final TokeniserState RCDATAEndTagName = new AnonymousClass13("RCDATAEndTagName", 12);
    public static final TokeniserState RawtextLessthanSign = new AnonymousClass14("RawtextLessthanSign", 13);
    public static final TokeniserState RawtextEndTagOpen = new AnonymousClass15("RawtextEndTagOpen", 14);
    public static final TokeniserState RawtextEndTagName = new AnonymousClass16("RawtextEndTagName", 15);
    public static final TokeniserState ScriptDataLessthanSign = new AnonymousClass17("ScriptDataLessthanSign", 16);
    public static final TokeniserState ScriptDataEndTagOpen = new AnonymousClass18("ScriptDataEndTagOpen", 17);
    public static final TokeniserState ScriptDataEndTagName = new AnonymousClass19("ScriptDataEndTagName", 18);
    public static final TokeniserState ScriptDataEscapeStart = new AnonymousClass20("ScriptDataEscapeStart", 19);
    public static final TokeniserState ScriptDataEscapeStartDash = new AnonymousClass21("ScriptDataEscapeStartDash", 20);
    public static final TokeniserState ScriptDataEscaped = new AnonymousClass22("ScriptDataEscaped", 21);
    public static final TokeniserState ScriptDataEscapedDash = new AnonymousClass23("ScriptDataEscapedDash", 22);
    public static final TokeniserState ScriptDataEscapedDashDash = new AnonymousClass24("ScriptDataEscapedDashDash", 23);
    public static final TokeniserState ScriptDataEscapedLessthanSign = new AnonymousClass25("ScriptDataEscapedLessthanSign", 24);
    public static final TokeniserState ScriptDataEscapedEndTagOpen = new AnonymousClass26("ScriptDataEscapedEndTagOpen", 25);
    public static final TokeniserState ScriptDataEscapedEndTagName = new AnonymousClass27("ScriptDataEscapedEndTagName", 26);
    public static final TokeniserState ScriptDataDoubleEscapeStart = new AnonymousClass28("ScriptDataDoubleEscapeStart", 27);
    public static final TokeniserState ScriptDataDoubleEscaped = new AnonymousClass29("ScriptDataDoubleEscaped", 28);
    public static final TokeniserState ScriptDataDoubleEscapedDash = new AnonymousClass30("ScriptDataDoubleEscapedDash", 29);
    public static final TokeniserState ScriptDataDoubleEscapedDashDash = new AnonymousClass31("ScriptDataDoubleEscapedDashDash", 30);
    public static final TokeniserState ScriptDataDoubleEscapedLessthanSign = new AnonymousClass32("ScriptDataDoubleEscapedLessthanSign", 31);
    public static final TokeniserState ScriptDataDoubleEscapeEnd = new AnonymousClass33("ScriptDataDoubleEscapeEnd", 32);
    public static final TokeniserState BeforeAttributeName = new AnonymousClass34("BeforeAttributeName", 33);
    public static final TokeniserState AttributeName = new AnonymousClass35("AttributeName", 34);
    public static final TokeniserState AfterAttributeName = new AnonymousClass36("AfterAttributeName", 35);
    public static final TokeniserState BeforeAttributeValue = new AnonymousClass37("BeforeAttributeValue", 36);
    public static final TokeniserState AttributeValue_doubleQuoted = new AnonymousClass38("AttributeValue_doubleQuoted", 37);
    public static final TokeniserState AttributeValue_singleQuoted = new AnonymousClass39("AttributeValue_singleQuoted", 38);
    public static final TokeniserState AttributeValue_unquoted = new AnonymousClass40("AttributeValue_unquoted", 39);
    public static final TokeniserState AfterAttributeValue_quoted = new AnonymousClass41("AfterAttributeValue_quoted", 40);
    public static final TokeniserState SelfClosingStartTag = new AnonymousClass42("SelfClosingStartTag", 41);
    public static final TokeniserState BogusComment = new AnonymousClass43("BogusComment", 42);
    public static final TokeniserState MarkupDeclarationOpen = new AnonymousClass44("MarkupDeclarationOpen", 43);
    public static final TokeniserState MarkupProcessingOpen = new AnonymousClass45("MarkupProcessingOpen", 44);
    public static final TokeniserState CommentStart = new AnonymousClass46("CommentStart", 45);
    public static final TokeniserState CommentStartDash = new AnonymousClass47("CommentStartDash", 46);
    public static final TokeniserState Comment = new AnonymousClass48("Comment", 47);
    public static final TokeniserState CommentEndDash = new AnonymousClass49("CommentEndDash", 48);
    public static final TokeniserState CommentEnd = new AnonymousClass50("CommentEnd", 49);
    public static final TokeniserState CommentEndBang = new AnonymousClass51("CommentEndBang", 50);
    public static final TokeniserState Doctype = new AnonymousClass52("Doctype", 51);
    public static final TokeniserState BeforeDoctypeName = new AnonymousClass53("BeforeDoctypeName", 52);
    public static final TokeniserState DoctypeName = new AnonymousClass54("DoctypeName", 53);
    public static final TokeniserState AfterDoctypeName = new AnonymousClass55("AfterDoctypeName", 54);
    public static final TokeniserState AfterDoctypePublicKeyword = new AnonymousClass56("AfterDoctypePublicKeyword", 55);
    public static final TokeniserState BeforeDoctypePublicIdentifier = new AnonymousClass57("BeforeDoctypePublicIdentifier", 56);
    public static final TokeniserState DoctypePublicIdentifier_doubleQuoted = new AnonymousClass58("DoctypePublicIdentifier_doubleQuoted", 57);
    public static final TokeniserState DoctypePublicIdentifier_singleQuoted = new AnonymousClass59("DoctypePublicIdentifier_singleQuoted", 58);
    public static final TokeniserState AfterDoctypePublicIdentifier = new AnonymousClass60("AfterDoctypePublicIdentifier", 59);
    public static final TokeniserState BetweenDoctypePublicAndSystemIdentifiers = new AnonymousClass61("BetweenDoctypePublicAndSystemIdentifiers", 60);
    public static final TokeniserState AfterDoctypeSystemKeyword = new AnonymousClass62("AfterDoctypeSystemKeyword", 61);
    public static final TokeniserState BeforeDoctypeSystemIdentifier = new AnonymousClass63("BeforeDoctypeSystemIdentifier", 62);
    public static final TokeniserState DoctypeSystemIdentifier_doubleQuoted = new AnonymousClass64("DoctypeSystemIdentifier_doubleQuoted", 63);
    public static final TokeniserState DoctypeSystemIdentifier_singleQuoted = new AnonymousClass65("DoctypeSystemIdentifier_singleQuoted", 64);
    public static final TokeniserState AfterDoctypeSystemIdentifier = new AnonymousClass66("AfterDoctypeSystemIdentifier", 65);
    public static final TokeniserState BogusDoctype = new AnonymousClass67("BogusDoctype", 66);
    public static final TokeniserState CdataSection = new AnonymousClass68("CdataSection", 67);
    private static final /* synthetic */ TokeniserState[] $VALUES = $values();
    static final char[] attributeNameCharsSorted = {'\t', '\n', '\f', TokenParser.CR, TokenParser.SP, '\"', '\'', '/', Typography.less, '=', Typography.greater, '?'};
    static final char[] attributeValueUnquoted = {0, '\t', '\n', '\f', TokenParser.CR, TokenParser.SP, '\"', Typography.amp, '\'', Typography.less, '=', Typography.greater, '`'};
    private static final String replacementStr = String.valueOf((char) 65533);

    abstract void read(Tokeniser tokeniser, CharacterReader characterReader);

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$1, reason: invalid class name */
    final enum AnonymousClass1 extends TokeniserState {
        AnonymousClass1(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cCurrent = characterReader.current();
            if (cCurrent == 0) {
                tokeniser.error(this);
                tokeniser.emit(characterReader.consume());
            } else {
                if (cCurrent == '&') {
                    tokeniser.advanceTransition(CharacterReferenceInData);
                    return;
                }
                if (cCurrent == '<') {
                    tokeniser.advanceTransition(TagOpen);
                } else if (cCurrent == 65535) {
                    tokeniser.emit(new Token.EOF());
                } else {
                    tokeniser.emit(characterReader.consumeData());
                }
            }
        }
    }

    private static /* synthetic */ TokeniserState[] $values() {
        return new TokeniserState[]{Data, CharacterReferenceInData, Rcdata, CharacterReferenceInRcdata, Rawtext, ScriptData, PLAINTEXT, TagOpen, EndTagOpen, TagName, RcdataLessthanSign, RCDATAEndTagOpen, RCDATAEndTagName, RawtextLessthanSign, RawtextEndTagOpen, RawtextEndTagName, ScriptDataLessthanSign, ScriptDataEndTagOpen, ScriptDataEndTagName, ScriptDataEscapeStart, ScriptDataEscapeStartDash, ScriptDataEscaped, ScriptDataEscapedDash, ScriptDataEscapedDashDash, ScriptDataEscapedLessthanSign, ScriptDataEscapedEndTagOpen, ScriptDataEscapedEndTagName, ScriptDataDoubleEscapeStart, ScriptDataDoubleEscaped, ScriptDataDoubleEscapedDash, ScriptDataDoubleEscapedDashDash, ScriptDataDoubleEscapedLessthanSign, ScriptDataDoubleEscapeEnd, BeforeAttributeName, AttributeName, AfterAttributeName, BeforeAttributeValue, AttributeValue_doubleQuoted, AttributeValue_singleQuoted, AttributeValue_unquoted, AfterAttributeValue_quoted, SelfClosingStartTag, BogusComment, MarkupDeclarationOpen, MarkupProcessingOpen, CommentStart, CommentStartDash, Comment, CommentEndDash, CommentEnd, CommentEndBang, Doctype, BeforeDoctypeName, DoctypeName, AfterDoctypeName, AfterDoctypePublicKeyword, BeforeDoctypePublicIdentifier, DoctypePublicIdentifier_doubleQuoted, DoctypePublicIdentifier_singleQuoted, AfterDoctypePublicIdentifier, BetweenDoctypePublicAndSystemIdentifiers, AfterDoctypeSystemKeyword, BeforeDoctypeSystemIdentifier, DoctypeSystemIdentifier_doubleQuoted, DoctypeSystemIdentifier_singleQuoted, AfterDoctypeSystemIdentifier, BogusDoctype, CdataSection};
    }

    private TokeniserState(String str, int i) {
        super(str, i);
    }

    /* synthetic */ TokeniserState(String str, int i, AnonymousClass1 anonymousClass1) {
        this(str, i);
    }

    public static TokeniserState valueOf(String str) {
        return (TokeniserState) Enum.valueOf(TokeniserState.class, str);
    }

    public static TokeniserState[] values() {
        return (TokeniserState[]) $VALUES.clone();
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$2, reason: invalid class name */
    final enum AnonymousClass2 extends TokeniserState {
        AnonymousClass2(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readCharRef(tokeniser, Data);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$3, reason: invalid class name */
    final enum AnonymousClass3 extends TokeniserState {
        AnonymousClass3(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cCurrent = characterReader.current();
            if (cCurrent == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
            } else {
                if (cCurrent == '&') {
                    tokeniser.advanceTransition(CharacterReferenceInRcdata);
                    return;
                }
                if (cCurrent == '<') {
                    tokeniser.advanceTransition(RcdataLessthanSign);
                } else if (cCurrent == 65535) {
                    tokeniser.emit(new Token.EOF());
                } else {
                    tokeniser.emit(characterReader.consumeData());
                }
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$4, reason: invalid class name */
    final enum AnonymousClass4 extends TokeniserState {
        AnonymousClass4(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readCharRef(tokeniser, Rcdata);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$5, reason: invalid class name */
    final enum AnonymousClass5 extends TokeniserState {
        AnonymousClass5(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readRawData(tokeniser, characterReader, this, RawtextLessthanSign);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$6, reason: invalid class name */
    final enum AnonymousClass6 extends TokeniserState {
        AnonymousClass6(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readRawData(tokeniser, characterReader, this, ScriptDataLessthanSign);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$7, reason: invalid class name */
    final enum AnonymousClass7 extends TokeniserState {
        AnonymousClass7(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cCurrent = characterReader.current();
            if (cCurrent == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
            } else if (cCurrent == 65535) {
                tokeniser.emit(new Token.EOF());
            } else {
                tokeniser.emit(characterReader.consumeTo((char) 0));
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$8, reason: invalid class name */
    final enum AnonymousClass8 extends TokeniserState {
        AnonymousClass8(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cCurrent = characterReader.current();
            if (cCurrent == '!') {
                tokeniser.advanceTransition(MarkupDeclarationOpen);
                return;
            }
            if (cCurrent == '/') {
                tokeniser.advanceTransition(EndTagOpen);
                return;
            }
            if (cCurrent == '?') {
                if (tokeniser.syntax == Document.OutputSettings.Syntax.xml) {
                    tokeniser.advanceTransition(MarkupProcessingOpen);
                    return;
                } else {
                    tokeniser.createBogusCommentPending();
                    tokeniser.transition(BogusComment);
                    return;
                }
            }
            if (characterReader.matchesAsciiAlpha()) {
                tokeniser.createTagPending(true);
                tokeniser.transition(TagName);
            } else {
                tokeniser.error(this);
                tokeniser.emit(Typography.less);
                tokeniser.transition(Data);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$9, reason: invalid class name */
    final enum AnonymousClass9 extends TokeniserState {
        AnonymousClass9(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.emit("</");
                tokeniser.transition(Data);
            } else if (characterReader.matchesAsciiAlpha()) {
                tokeniser.createTagPending(false);
                tokeniser.transition(TagName);
            } else if (characterReader.matches(Typography.greater)) {
                tokeniser.error(this);
                tokeniser.advanceTransition(Data);
            } else {
                tokeniser.error(this);
                tokeniser.createBogusCommentPending();
                tokeniser.commentPending.append('/');
                tokeniser.transition(BogusComment);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$10, reason: invalid class name */
    final enum AnonymousClass10 extends TokeniserState {
        AnonymousClass10(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.tagPending.appendTagName(characterReader.consumeTagName());
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.tagPending.appendTagName(TokeniserState.replacementStr);
                return;
            }
            if (cConsume != ' ') {
                if (cConsume == '/') {
                    tokeniser.transition(SelfClosingStartTag);
                    return;
                }
                if (cConsume == '>') {
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                } else if (cConsume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                } else if (cConsume != '\t' && cConsume != '\n' && cConsume != '\f' && cConsume != '\r') {
                    tokeniser.tagPending.appendTagName(cConsume);
                    return;
                }
            }
            tokeniser.transition(BeforeAttributeName);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$11, reason: invalid class name */
    final enum AnonymousClass11 extends TokeniserState {
        AnonymousClass11(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(RCDATAEndTagOpen);
            } else if (characterReader.readFully() && characterReader.matchesAsciiAlpha() && tokeniser.appropriateEndTagName() != null && !characterReader.containsIgnoreCase(tokeniser.appropriateEndTagSeq())) {
                tokeniser.tagPending = tokeniser.createTagPending(false).name(tokeniser.appropriateEndTagName());
                tokeniser.emitTagPending();
                tokeniser.transition(TagOpen);
            } else {
                tokeniser.emit(Typography.less);
                tokeniser.transition(Rcdata);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$12, reason: invalid class name */
    final enum AnonymousClass12 extends TokeniserState {
        AnonymousClass12(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesAsciiAlpha()) {
                tokeniser.createTagPending(false);
                tokeniser.tagPending.appendTagName(characterReader.current());
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.advanceTransition(RCDATAEndTagName);
                return;
            }
            tokeniser.emit("</");
            tokeniser.transition(Rcdata);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$13, reason: invalid class name */
    final enum AnonymousClass13 extends TokeniserState {
        AnonymousClass13(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesAsciiAlpha()) {
                String strConsumeTagName = characterReader.consumeTagName();
                tokeniser.tagPending.appendTagName(strConsumeTagName);
                tokeniser.dataBuffer.append(strConsumeTagName);
                return;
            }
            char cConsume = characterReader.consume();
            if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniser.transition(BeforeAttributeName);
                    return;
                } else {
                    anythingElse(tokeniser, characterReader);
                    return;
                }
            }
            if (cConsume == '/') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniser.transition(SelfClosingStartTag);
                    return;
                } else {
                    anythingElse(tokeniser, characterReader);
                    return;
                }
            }
            if (cConsume == '>') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                } else {
                    anythingElse(tokeniser, characterReader);
                    return;
                }
            }
            anythingElse(tokeniser, characterReader);
        }

        private void anythingElse(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.emit("</");
            tokeniser.emit(tokeniser.dataBuffer.value());
            characterReader.unconsume();
            tokeniser.transition(Rcdata);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$14, reason: invalid class name */
    final enum AnonymousClass14 extends TokeniserState {
        AnonymousClass14(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(RawtextEndTagOpen);
            } else {
                tokeniser.emit(Typography.less);
                tokeniser.transition(Rawtext);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$15, reason: invalid class name */
    final enum AnonymousClass15 extends TokeniserState {
        AnonymousClass15(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readEndTag(tokeniser, characterReader, RawtextEndTagName, Rawtext);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$16, reason: invalid class name */
    final enum AnonymousClass16 extends TokeniserState {
        AnonymousClass16(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, Rawtext);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$17, reason: invalid class name */
    final enum AnonymousClass17 extends TokeniserState {
        AnonymousClass17(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == '!') {
                tokeniser.emit("<!");
                tokeniser.transition(ScriptDataEscapeStart);
                return;
            }
            if (cConsume == '/') {
                tokeniser.createTempBuffer();
                tokeniser.transition(ScriptDataEndTagOpen);
            } else if (cConsume == 65535) {
                tokeniser.emit(Typography.less);
                tokeniser.eofError(this);
                tokeniser.transition(Data);
            } else {
                tokeniser.emit(Typography.less);
                characterReader.unconsume();
                tokeniser.transition(ScriptData);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$18, reason: invalid class name */
    final enum AnonymousClass18 extends TokeniserState {
        AnonymousClass18(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readEndTag(tokeniser, characterReader, ScriptDataEndTagName, ScriptData);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$19, reason: invalid class name */
    final enum AnonymousClass19 extends TokeniserState {
        AnonymousClass19(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, ScriptData);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$20, reason: invalid class name */
    final enum AnonymousClass20 extends TokeniserState {
        AnonymousClass20(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches(Soundex.SILENT_MARKER)) {
                tokeniser.emit(Soundex.SILENT_MARKER);
                tokeniser.advanceTransition(ScriptDataEscapeStartDash);
            } else {
                tokeniser.transition(ScriptData);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$21, reason: invalid class name */
    final enum AnonymousClass21 extends TokeniserState {
        AnonymousClass21(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches(Soundex.SILENT_MARKER)) {
                tokeniser.emit(Soundex.SILENT_MARKER);
                tokeniser.advanceTransition(ScriptDataEscapedDashDash);
            } else {
                tokeniser.transition(ScriptData);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$22, reason: invalid class name */
    final enum AnonymousClass22 extends TokeniserState {
        AnonymousClass22(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
                return;
            }
            char cCurrent = characterReader.current();
            if (cCurrent == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
            } else if (cCurrent == '-') {
                tokeniser.emit(Soundex.SILENT_MARKER);
                tokeniser.advanceTransition(ScriptDataEscapedDash);
            } else if (cCurrent == '<') {
                tokeniser.advanceTransition(ScriptDataEscapedLessthanSign);
            } else {
                tokeniser.emit(characterReader.consumeToAny(Soundex.SILENT_MARKER, Typography.less, 0));
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$23, reason: invalid class name */
    final enum AnonymousClass23 extends TokeniserState {
        AnonymousClass23(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
                return;
            }
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.emit((char) 65533);
                tokeniser.transition(ScriptDataEscaped);
            } else if (cConsume == '-') {
                tokeniser.emit(cConsume);
                tokeniser.transition(ScriptDataEscapedDashDash);
            } else if (cConsume == '<') {
                tokeniser.transition(ScriptDataEscapedLessthanSign);
            } else {
                tokeniser.emit(cConsume);
                tokeniser.transition(ScriptDataEscaped);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$24, reason: invalid class name */
    final enum AnonymousClass24 extends TokeniserState {
        AnonymousClass24(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
                return;
            }
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.emit((char) 65533);
                tokeniser.transition(ScriptDataEscaped);
            } else {
                if (cConsume == '-') {
                    tokeniser.emit(cConsume);
                    return;
                }
                if (cConsume == '<') {
                    tokeniser.transition(ScriptDataEscapedLessthanSign);
                } else if (cConsume == '>') {
                    tokeniser.emit(cConsume);
                    tokeniser.transition(ScriptData);
                } else {
                    tokeniser.emit(cConsume);
                    tokeniser.transition(ScriptDataEscaped);
                }
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$25, reason: invalid class name */
    final enum AnonymousClass25 extends TokeniserState {
        AnonymousClass25(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesAsciiAlpha()) {
                tokeniser.createTempBuffer();
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.emit(Typography.less);
                tokeniser.emit(characterReader.current());
                tokeniser.advanceTransition(ScriptDataDoubleEscapeStart);
                return;
            }
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(ScriptDataEscapedEndTagOpen);
            } else {
                tokeniser.emit(Typography.less);
                tokeniser.transition(ScriptDataEscaped);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$26, reason: invalid class name */
    final enum AnonymousClass26 extends TokeniserState {
        AnonymousClass26(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesAsciiAlpha()) {
                tokeniser.createTagPending(false);
                tokeniser.tagPending.appendTagName(characterReader.current());
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.advanceTransition(ScriptDataEscapedEndTagName);
                return;
            }
            tokeniser.emit("</");
            tokeniser.transition(ScriptDataEscaped);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$27, reason: invalid class name */
    final enum AnonymousClass27 extends TokeniserState {
        AnonymousClass27(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, ScriptDataEscaped);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$28, reason: invalid class name */
    final enum AnonymousClass28 extends TokeniserState {
        AnonymousClass28(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, ScriptDataDoubleEscaped, ScriptDataEscaped);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$29, reason: invalid class name */
    final enum AnonymousClass29 extends TokeniserState {
        AnonymousClass29(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cCurrent = characterReader.current();
            if (cCurrent == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit((char) 65533);
            } else if (cCurrent == '-') {
                tokeniser.emit(cCurrent);
                tokeniser.advanceTransition(ScriptDataDoubleEscapedDash);
            } else if (cCurrent == '<') {
                tokeniser.emit(cCurrent);
                tokeniser.advanceTransition(ScriptDataDoubleEscapedLessthanSign);
            } else if (cCurrent == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
            } else {
                tokeniser.emit(characterReader.consumeToAny(Soundex.SILENT_MARKER, Typography.less, 0));
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$30, reason: invalid class name */
    final enum AnonymousClass30 extends TokeniserState {
        AnonymousClass30(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.emit((char) 65533);
                tokeniser.transition(ScriptDataDoubleEscaped);
            } else if (cConsume == '-') {
                tokeniser.emit(cConsume);
                tokeniser.transition(ScriptDataDoubleEscapedDashDash);
            } else if (cConsume == '<') {
                tokeniser.emit(cConsume);
                tokeniser.transition(ScriptDataDoubleEscapedLessthanSign);
            } else if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
            } else {
                tokeniser.emit(cConsume);
                tokeniser.transition(ScriptDataDoubleEscaped);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$31, reason: invalid class name */
    final enum AnonymousClass31 extends TokeniserState {
        AnonymousClass31(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.emit((char) 65533);
                tokeniser.transition(ScriptDataDoubleEscaped);
                return;
            }
            if (cConsume == '-') {
                tokeniser.emit(cConsume);
                return;
            }
            if (cConsume == '<') {
                tokeniser.emit(cConsume);
                tokeniser.transition(ScriptDataDoubleEscapedLessthanSign);
            } else if (cConsume == '>') {
                tokeniser.emit(cConsume);
                tokeniser.transition(ScriptData);
            } else if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
            } else {
                tokeniser.emit(cConsume);
                tokeniser.transition(ScriptDataDoubleEscaped);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$32, reason: invalid class name */
    final enum AnonymousClass32 extends TokeniserState {
        AnonymousClass32(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.emit('/');
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(ScriptDataDoubleEscapeEnd);
                return;
            }
            tokeniser.transition(ScriptDataDoubleEscaped);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$33, reason: invalid class name */
    final enum AnonymousClass33 extends TokeniserState {
        AnonymousClass33(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, ScriptDataEscaped, ScriptDataDoubleEscaped);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$34, reason: invalid class name */
    final enum AnonymousClass34 extends TokeniserState {
        AnonymousClass34(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                characterReader.unconsume();
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tokeniser.transition(AttributeName);
                return;
            }
            if (cConsume != ' ') {
                if (cConsume != '\"' && cConsume != '\'') {
                    if (cConsume == '/') {
                        tokeniser.transition(SelfClosingStartTag);
                        return;
                    }
                    if (cConsume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.transition(Data);
                        return;
                    }
                    if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r') {
                        return;
                    }
                    switch (cConsume) {
                        case '>':
                            tokeniser.emitTagPending();
                            tokeniser.transition(Data);
                            return;
                        case '?':
                            if (tokeniser.tagPending instanceof Token.XmlDecl) {
                                return;
                            }
                            break;
                    }
                    tokeniser.tagPending.newAttribute();
                    characterReader.unconsume();
                    tokeniser.transition(AttributeName);
                    return;
                }
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tokeniser.tagPending.appendAttributeName(cConsume, characterReader.pos() - 1, characterReader.pos());
                tokeniser.transition(AttributeName);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$35, reason: invalid class name */
    final enum AnonymousClass35 extends TokeniserState {
        AnonymousClass35(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            int iPos = characterReader.pos();
            tokeniser.tagPending.appendAttributeName(characterReader.consumeToAnySorted(attributeNameCharsSorted), iPos, characterReader.pos());
            int iPos2 = characterReader.pos();
            char cConsume = characterReader.consume();
            if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ') {
                tokeniser.transition(AfterAttributeName);
                return;
            }
            if (cConsume != '\"' && cConsume != '\'') {
                if (cConsume == '/') {
                    tokeniser.transition(SelfClosingStartTag);
                    return;
                }
                if (cConsume != 65535) {
                    switch (cConsume) {
                        case '=':
                            tokeniser.transition(BeforeAttributeValue);
                            return;
                        case '>':
                            tokeniser.emitTagPending();
                            tokeniser.transition(Data);
                            return;
                        case '?':
                            if (tokeniser.syntax == Document.OutputSettings.Syntax.xml && (tokeniser.tagPending instanceof Token.XmlDecl)) {
                                tokeniser.transition(AfterAttributeName);
                                return;
                            }
                            break;
                    }
                    tokeniser.tagPending.appendAttributeName(cConsume, iPos2, characterReader.pos());
                    return;
                }
                tokeniser.eofError(this);
                tokeniser.transition(Data);
                return;
            }
            tokeniser.error(this);
            tokeniser.tagPending.appendAttributeName(cConsume, iPos2, characterReader.pos());
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$36, reason: invalid class name */
    final enum AnonymousClass36 extends TokeniserState {
        AnonymousClass36(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeName((char) 65533, characterReader.pos() - 1, characterReader.pos());
                tokeniser.transition(AttributeName);
                return;
            }
            if (cConsume != ' ') {
                if (cConsume != '\"' && cConsume != '\'') {
                    if (cConsume == '/') {
                        tokeniser.transition(SelfClosingStartTag);
                        return;
                    }
                    if (cConsume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.transition(Data);
                        return;
                    }
                    if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r') {
                        return;
                    }
                    switch (cConsume) {
                        case '<':
                            break;
                        case '=':
                            tokeniser.transition(BeforeAttributeValue);
                            break;
                        case '>':
                            tokeniser.emitTagPending();
                            tokeniser.transition(Data);
                            break;
                        default:
                            tokeniser.tagPending.newAttribute();
                            characterReader.unconsume();
                            tokeniser.transition(AttributeName);
                            break;
                    }
                    return;
                }
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tokeniser.tagPending.appendAttributeName(cConsume, characterReader.pos() - 1, characterReader.pos());
                tokeniser.transition(AttributeName);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$37, reason: invalid class name */
    final enum AnonymousClass37 extends TokeniserState {
        AnonymousClass37(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue((char) 65533, characterReader.pos() - 1, characterReader.pos());
                tokeniser.transition(AttributeValue_unquoted);
                return;
            }
            if (cConsume != ' ') {
                if (cConsume == '\"') {
                    tokeniser.transition(AttributeValue_doubleQuoted);
                    return;
                }
                if (cConsume != '`') {
                    if (cConsume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.emitTagPending();
                        tokeniser.transition(Data);
                        return;
                    }
                    if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r') {
                        return;
                    }
                    if (cConsume == '&') {
                        characterReader.unconsume();
                        tokeniser.transition(AttributeValue_unquoted);
                        return;
                    }
                    if (cConsume == '\'') {
                        tokeniser.transition(AttributeValue_singleQuoted);
                        return;
                    }
                    switch (cConsume) {
                        case '<':
                        case '=':
                            break;
                        case '>':
                            tokeniser.error(this);
                            tokeniser.emitTagPending();
                            tokeniser.transition(Data);
                            break;
                        default:
                            characterReader.unconsume();
                            tokeniser.transition(AttributeValue_unquoted);
                            break;
                    }
                    return;
                }
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue(cConsume, characterReader.pos() - 1, characterReader.pos());
                tokeniser.transition(AttributeValue_unquoted);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$38, reason: invalid class name */
    final enum AnonymousClass38 extends TokeniserState {
        AnonymousClass38(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            int iPos = characterReader.pos();
            String strConsumeAttributeQuoted = characterReader.consumeAttributeQuoted(false);
            if (strConsumeAttributeQuoted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(strConsumeAttributeQuoted, iPos, characterReader.pos());
            } else {
                tokeniser.tagPending.setEmptyAttributeValue();
            }
            int iPos2 = characterReader.pos();
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue((char) 65533, iPos2, characterReader.pos());
                return;
            }
            if (cConsume == '\"') {
                tokeniser.transition(AfterAttributeValue_quoted);
                return;
            }
            if (cConsume != '&') {
                if (cConsume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                } else {
                    tokeniser.tagPending.appendAttributeValue(cConsume, iPos2, characterReader.pos());
                    return;
                }
            }
            int[] iArrConsumeCharacterReference = tokeniser.consumeCharacterReference('\"', true);
            if (iArrConsumeCharacterReference != null) {
                tokeniser.tagPending.appendAttributeValue(iArrConsumeCharacterReference, iPos2, characterReader.pos());
            } else {
                tokeniser.tagPending.appendAttributeValue(Typography.amp, iPos2, characterReader.pos());
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$39, reason: invalid class name */
    final enum AnonymousClass39 extends TokeniserState {
        AnonymousClass39(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            int iPos = characterReader.pos();
            String strConsumeAttributeQuoted = characterReader.consumeAttributeQuoted(true);
            if (strConsumeAttributeQuoted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(strConsumeAttributeQuoted, iPos, characterReader.pos());
            } else {
                tokeniser.tagPending.setEmptyAttributeValue();
            }
            int iPos2 = characterReader.pos();
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue((char) 65533, iPos2, characterReader.pos());
                return;
            }
            if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
                return;
            }
            if (cConsume != '&') {
                if (cConsume == '\'') {
                    tokeniser.transition(AfterAttributeValue_quoted);
                    return;
                } else {
                    tokeniser.tagPending.appendAttributeValue(cConsume, iPos2, characterReader.pos());
                    return;
                }
            }
            int[] iArrConsumeCharacterReference = tokeniser.consumeCharacterReference('\'', true);
            if (iArrConsumeCharacterReference != null) {
                tokeniser.tagPending.appendAttributeValue(iArrConsumeCharacterReference, iPos2, characterReader.pos());
            } else {
                tokeniser.tagPending.appendAttributeValue(Typography.amp, iPos2, characterReader.pos());
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$40, reason: invalid class name */
    final enum AnonymousClass40 extends TokeniserState {
        AnonymousClass40(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            int iPos = characterReader.pos();
            String strConsumeToAnySorted = characterReader.consumeToAnySorted(attributeValueUnquoted);
            if (strConsumeToAnySorted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(strConsumeToAnySorted, iPos, characterReader.pos());
            }
            int iPos2 = characterReader.pos();
            char cConsume = characterReader.consume();
            if (cConsume != 0) {
                if (cConsume != ' ') {
                    if (cConsume != '\"' && cConsume != '`') {
                        if (cConsume == 65535) {
                            tokeniser.eofError(this);
                            tokeniser.transition(Data);
                            return;
                        }
                        if (cConsume != '\t' && cConsume != '\n' && cConsume != '\f' && cConsume != '\r') {
                            if (cConsume == '&') {
                                int[] iArrConsumeCharacterReference = tokeniser.consumeCharacterReference(Character.valueOf(Typography.greater), true);
                                if (iArrConsumeCharacterReference != null) {
                                    tokeniser.tagPending.appendAttributeValue(iArrConsumeCharacterReference, iPos2, characterReader.pos());
                                    return;
                                } else {
                                    tokeniser.tagPending.appendAttributeValue(Typography.amp, iPos2, characterReader.pos());
                                    return;
                                }
                            }
                            if (cConsume != '\'') {
                                switch (cConsume) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        tokeniser.emitTagPending();
                                        tokeniser.transition(Data);
                                        break;
                                    default:
                                        tokeniser.tagPending.appendAttributeValue(cConsume, iPos2, characterReader.pos());
                                        break;
                                }
                                return;
                            }
                        }
                    }
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue(cConsume, iPos2, characterReader.pos());
                    return;
                }
                tokeniser.transition(BeforeAttributeName);
                return;
            }
            tokeniser.error(this);
            tokeniser.tagPending.appendAttributeValue((char) 65533, iPos2, characterReader.pos());
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$41, reason: invalid class name */
    final enum AnonymousClass41 extends TokeniserState {
        AnonymousClass41(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ') {
                tokeniser.transition(BeforeAttributeName);
                return;
            }
            if (cConsume == '/') {
                tokeniser.transition(SelfClosingStartTag);
                return;
            }
            if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
            } else if (cConsume == '>') {
                tokeniser.emitTagPending();
                tokeniser.transition(Data);
            } else {
                if (cConsume == '?' && (tokeniser.tagPending instanceof Token.XmlDecl)) {
                    return;
                }
                characterReader.unconsume();
                tokeniser.error(this);
                tokeniser.transition(BeforeAttributeName);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$42, reason: invalid class name */
    final enum AnonymousClass42 extends TokeniserState {
        AnonymousClass42(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == '>') {
                tokeniser.tagPending.selfClosing = true;
                tokeniser.emitTagPending();
                tokeniser.transition(Data);
            } else if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
            } else {
                characterReader.unconsume();
                tokeniser.error(this);
                tokeniser.transition(BeforeAttributeName);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$43, reason: invalid class name */
    final enum AnonymousClass43 extends TokeniserState {
        AnonymousClass43(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.commentPending.append(characterReader.consumeTo(Typography.greater));
            char cCurrent = characterReader.current();
            if (cCurrent == '>' || cCurrent == 65535) {
                characterReader.consume();
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$44, reason: invalid class name */
    final enum AnonymousClass44 extends TokeniserState {
        AnonymousClass44(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchConsume("--")) {
                tokeniser.createCommentPending();
                tokeniser.transition(CommentStart);
                return;
            }
            if (characterReader.matchConsumeIgnoreCase("DOCTYPE")) {
                tokeniser.transition(Doctype);
                return;
            }
            if (characterReader.matchConsume("[CDATA[")) {
                tokeniser.createTempBuffer();
                tokeniser.transition(CdataSection);
            } else if (tokeniser.syntax == Document.OutputSettings.Syntax.xml && characterReader.matchesAsciiAlpha()) {
                tokeniser.createXmlDeclPending(true);
                tokeniser.transition(TagName);
            } else {
                tokeniser.error(this);
                tokeniser.createBogusCommentPending();
                tokeniser.transition(BogusComment);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$45, reason: invalid class name */
    final enum AnonymousClass45 extends TokeniserState {
        AnonymousClass45(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesAsciiAlpha()) {
                tokeniser.createXmlDeclPending(false);
                tokeniser.transition(TagName);
            } else {
                tokeniser.error(this);
                tokeniser.createBogusCommentPending();
                tokeniser.commentPending.append('?');
                tokeniser.transition(BogusComment);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$46, reason: invalid class name */
    final enum AnonymousClass46 extends TokeniserState {
        AnonymousClass46(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.append((char) 65533);
                tokeniser.transition(Comment);
                return;
            }
            if (cConsume == '-') {
                tokeniser.transition(CommentStartDash);
                return;
            }
            if (cConsume == '>') {
                tokeniser.error(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else {
                characterReader.unconsume();
                tokeniser.transition(Comment);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$47, reason: invalid class name */
    final enum AnonymousClass47 extends TokeniserState {
        AnonymousClass47(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.append((char) 65533);
                tokeniser.transition(Comment);
                return;
            }
            if (cConsume == '-') {
                tokeniser.transition(CommentEnd);
                return;
            }
            if (cConsume == '>') {
                tokeniser.error(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else {
                tokeniser.commentPending.append(cConsume);
                tokeniser.transition(Comment);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$48, reason: invalid class name */
    final enum AnonymousClass48 extends TokeniserState {
        AnonymousClass48(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cCurrent = characterReader.current();
            if (cCurrent == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.commentPending.append((char) 65533);
            } else if (cCurrent == '-') {
                tokeniser.advanceTransition(CommentEndDash);
            } else {
                if (cCurrent == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;
                }
                tokeniser.commentPending.append(characterReader.consumeToAny(Soundex.SILENT_MARKER, 0));
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$49, reason: invalid class name */
    final enum AnonymousClass49 extends TokeniserState {
        AnonymousClass49(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.append(Soundex.SILENT_MARKER).append((char) 65533);
                tokeniser.transition(Comment);
            } else {
                if (cConsume == '-') {
                    tokeniser.transition(CommentEnd);
                    return;
                }
                if (cConsume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                } else {
                    tokeniser.commentPending.append(Soundex.SILENT_MARKER).append(cConsume);
                    tokeniser.transition(Comment);
                }
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$50, reason: invalid class name */
    final enum AnonymousClass50 extends TokeniserState {
        AnonymousClass50(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.append("--").append((char) 65533);
                tokeniser.transition(Comment);
                return;
            }
            if (cConsume == '!') {
                tokeniser.transition(CommentEndBang);
                return;
            }
            if (cConsume == '-') {
                tokeniser.commentPending.append(Soundex.SILENT_MARKER);
                return;
            }
            if (cConsume == '>') {
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else if (cConsume != 65535) {
                tokeniser.commentPending.append("--").append(cConsume);
                tokeniser.transition(Comment);
            } else {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$51, reason: invalid class name */
    final enum AnonymousClass51 extends TokeniserState {
        AnonymousClass51(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.append("--!").append((char) 65533);
                tokeniser.transition(Comment);
                return;
            }
            if (cConsume == '-') {
                tokeniser.commentPending.append("--!");
                tokeniser.transition(CommentEndDash);
                return;
            }
            if (cConsume == '>') {
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            } else if (cConsume != 65535) {
                tokeniser.commentPending.append("--!").append(cConsume);
                tokeniser.transition(Comment);
            } else {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$52, reason: invalid class name */
    final enum AnonymousClass52 extends TokeniserState {
        AnonymousClass52(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ') {
                tokeniser.transition(BeforeDoctypeName);
                return;
            }
            if (cConsume != '>') {
                if (cConsume == 65535) {
                    tokeniser.eofError(this);
                } else {
                    tokeniser.error(this);
                    tokeniser.transition(BeforeDoctypeName);
                    return;
                }
            }
            tokeniser.error(this);
            tokeniser.createDoctypePending();
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.emitDoctypePending();
            tokeniser.transition(Data);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$53, reason: invalid class name */
    final enum AnonymousClass53 extends TokeniserState {
        AnonymousClass53(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesAsciiAlpha()) {
                tokeniser.createDoctypePending();
                tokeniser.transition(DoctypeName);
                return;
            }
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.name.append((char) 65533);
                tokeniser.transition(DoctypeName);
                return;
            }
            if (cConsume != ' ') {
                if (cConsume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.createDoctypePending();
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                }
                if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r') {
                    return;
                }
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.name.append(cConsume);
                tokeniser.transition(DoctypeName);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$54, reason: invalid class name */
    final enum AnonymousClass54 extends TokeniserState {
        AnonymousClass54(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesAsciiAlpha()) {
                tokeniser.doctypePending.name.append(characterReader.consumeLetterSequence());
                return;
            }
            char cConsume = characterReader.consume();
            if (cConsume != 0) {
                if (cConsume != ' ') {
                    if (cConsume == '>') {
                        tokeniser.emitDoctypePending();
                        tokeniser.transition(Data);
                        return;
                    }
                    if (cConsume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.doctypePending.forceQuirks = true;
                        tokeniser.emitDoctypePending();
                        tokeniser.transition(Data);
                        return;
                    }
                    if (cConsume != '\t' && cConsume != '\n' && cConsume != '\f' && cConsume != '\r') {
                        tokeniser.doctypePending.name.append(cConsume);
                        return;
                    }
                }
                tokeniser.transition(AfterDoctypeName);
                return;
            }
            tokeniser.error(this);
            tokeniser.doctypePending.name.append((char) 65533);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$55, reason: invalid class name */
    final enum AnonymousClass55 extends TokeniserState {
        AnonymousClass55(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (characterReader.matchesAny('\t', '\n', TokenParser.CR, '\f', TokenParser.SP)) {
                characterReader.advance();
                return;
            }
            if (characterReader.matches(Typography.greater)) {
                tokeniser.emitDoctypePending();
                tokeniser.advanceTransition(Data);
                return;
            }
            if (characterReader.matchConsumeIgnoreCase(DocumentType.PUBLIC_KEY)) {
                tokeniser.doctypePending.pubSysKey = DocumentType.PUBLIC_KEY;
                tokeniser.transition(AfterDoctypePublicKeyword);
            } else if (characterReader.matchConsumeIgnoreCase(DocumentType.SYSTEM_KEY)) {
                tokeniser.doctypePending.pubSysKey = DocumentType.SYSTEM_KEY;
                tokeniser.transition(AfterDoctypeSystemKeyword);
            } else {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.advanceTransition(BogusDoctype);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$56, reason: invalid class name */
    final enum AnonymousClass56 extends TokeniserState {
        AnonymousClass56(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ') {
                tokeniser.transition(BeforeDoctypePublicIdentifier);
                return;
            }
            if (cConsume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(DoctypePublicIdentifier_doubleQuoted);
                return;
            }
            if (cConsume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(DoctypePublicIdentifier_singleQuoted);
                return;
            }
            if (cConsume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.error(this);
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.transition(BogusDoctype);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$57, reason: invalid class name */
    final enum AnonymousClass57 extends TokeniserState {
        AnonymousClass57(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ') {
                return;
            }
            if (cConsume == '\"') {
                tokeniser.transition(DoctypePublicIdentifier_doubleQuoted);
                return;
            }
            if (cConsume == '\'') {
                tokeniser.transition(DoctypePublicIdentifier_singleQuoted);
                return;
            }
            if (cConsume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.error(this);
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.transition(BogusDoctype);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$58, reason: invalid class name */
    final enum AnonymousClass58 extends TokeniserState {
        AnonymousClass58(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.publicIdentifier.append((char) 65533);
                return;
            }
            if (cConsume == '\"') {
                tokeniser.transition(AfterDoctypePublicIdentifier);
                return;
            }
            if (cConsume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.doctypePending.publicIdentifier.append(cConsume);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$59, reason: invalid class name */
    final enum AnonymousClass59 extends TokeniserState {
        AnonymousClass59(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.publicIdentifier.append((char) 65533);
                return;
            }
            if (cConsume == '\'') {
                tokeniser.transition(AfterDoctypePublicIdentifier);
                return;
            }
            if (cConsume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.doctypePending.publicIdentifier.append(cConsume);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$60, reason: invalid class name */
    final enum AnonymousClass60 extends TokeniserState {
        AnonymousClass60(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ') {
                tokeniser.transition(BetweenDoctypePublicAndSystemIdentifiers);
                return;
            }
            if (cConsume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (cConsume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (cConsume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            } else {
                if (cConsume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                }
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(BogusDoctype);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$61, reason: invalid class name */
    final enum AnonymousClass61 extends TokeniserState {
        AnonymousClass61(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ') {
                return;
            }
            if (cConsume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (cConsume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (cConsume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            } else {
                if (cConsume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                }
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(BogusDoctype);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$62, reason: invalid class name */
    final enum AnonymousClass62 extends TokeniserState {
        AnonymousClass62(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ') {
                tokeniser.transition(BeforeDoctypeSystemIdentifier);
                return;
            }
            if (cConsume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (cConsume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (cConsume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.error(this);
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.emitDoctypePending();
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$63, reason: invalid class name */
    final enum AnonymousClass63 extends TokeniserState {
        AnonymousClass63(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ') {
                return;
            }
            if (cConsume == '\"') {
                tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (cConsume == '\'') {
                tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (cConsume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.error(this);
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.transition(BogusDoctype);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$64, reason: invalid class name */
    final enum AnonymousClass64 extends TokeniserState {
        AnonymousClass64(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.systemIdentifier.append((char) 65533);
                return;
            }
            if (cConsume == '\"') {
                tokeniser.transition(AfterDoctypeSystemIdentifier);
                return;
            }
            if (cConsume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.doctypePending.systemIdentifier.append(cConsume);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$65, reason: invalid class name */
    final enum AnonymousClass65 extends TokeniserState {
        AnonymousClass65(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.systemIdentifier.append((char) 65533);
                return;
            }
            if (cConsume == '\'') {
                tokeniser.transition(AfterDoctypeSystemIdentifier);
                return;
            }
            if (cConsume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            if (cConsume == 65535) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }
            tokeniser.doctypePending.systemIdentifier.append(cConsume);
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$66, reason: invalid class name */
    final enum AnonymousClass66 extends TokeniserState {
        AnonymousClass66(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ') {
                return;
            }
            if (cConsume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            } else {
                if (cConsume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                }
                tokeniser.error(this);
                tokeniser.transition(BogusDoctype);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$67, reason: invalid class name */
    final enum AnonymousClass67 extends TokeniserState {
        AnonymousClass67(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char cConsume = characterReader.consume();
            if (cConsume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            } else {
                if (cConsume != 65535) {
                    return;
                }
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }
        }
    }

    /* INFO: renamed from: org.jsoup.parser.TokeniserState$68, reason: invalid class name */
    final enum AnonymousClass68 extends TokeniserState {
        AnonymousClass68(String str, int i) {
            super(str, i, null);
        }

        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.dataBuffer.append(characterReader.consumeTo("]]>"));
            if (characterReader.matchConsume("]]>") || characterReader.isEmpty()) {
                tokeniser.emit(new Token.CData(tokeniser.dataBuffer.value()));
                tokeniser.transition(Data);
            }
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static void handleDataEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState) {
        if (characterReader.matchesAsciiAlpha()) {
            String strConsumeTagName = characterReader.consumeTagName();
            tokeniser.tagPending.appendTagName(strConsumeTagName);
            tokeniser.dataBuffer.append(strConsumeTagName);
            return;
        }
        if (tokeniser.isAppropriateEndTagToken() && !characterReader.isEmpty()) {
            char cConsume = characterReader.consume();
            if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ') {
                tokeniser.transition(BeforeAttributeName);
                return;
            }
            if (cConsume == '/') {
                tokeniser.transition(SelfClosingStartTag);
                return;
            } else {
                if (cConsume == '>') {
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                }
                tokeniser.dataBuffer.append(cConsume);
            }
        }
        tokeniser.emit("</");
        tokeniser.emit(tokeniser.dataBuffer.value());
        tokeniser.transition(tokeniserState);
    }

    /* INFO: Access modifiers changed from: private */
    public static void readRawData(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char cCurrent = characterReader.current();
        if (cCurrent == 0) {
            tokeniser.error(tokeniserState);
            characterReader.advance();
            tokeniser.emit((char) 65533);
        } else if (cCurrent == '<') {
            tokeniser.advanceTransition(tokeniserState2);
        } else if (cCurrent == 65535) {
            tokeniser.emit(new Token.EOF());
        } else {
            tokeniser.emit(characterReader.consumeRawData());
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static void readCharRef(Tokeniser tokeniser, TokeniserState tokeniserState) {
        int[] iArrConsumeCharacterReference = tokeniser.consumeCharacterReference(null, false);
        if (iArrConsumeCharacterReference == null) {
            tokeniser.emit(Typography.amp);
        } else {
            tokeniser.emit(iArrConsumeCharacterReference);
        }
        tokeniser.transition(tokeniserState);
    }

    /* INFO: Access modifiers changed from: private */
    public static void readEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.matchesAsciiAlpha()) {
            tokeniser.createTagPending(false);
            tokeniser.transition(tokeniserState);
        } else {
            tokeniser.emit("</");
            tokeniser.transition(tokeniserState2);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static void handleDataDoubleEscapeTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.matchesAsciiAlpha()) {
            String strConsumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.dataBuffer.append(strConsumeLetterSequence);
            tokeniser.emit(strConsumeLetterSequence);
            return;
        }
        char cConsume = characterReader.consume();
        if (cConsume == '\t' || cConsume == '\n' || cConsume == '\f' || cConsume == '\r' || cConsume == ' ' || cConsume == '/' || cConsume == '>') {
            if (tokeniser.dataBuffer.value().equals("script")) {
                tokeniser.transition(tokeniserState);
            } else {
                tokeniser.transition(tokeniserState2);
            }
            tokeniser.emit(cConsume);
            return;
        }
        characterReader.unconsume();
        tokeniser.transition(tokeniserState2);
    }
}
