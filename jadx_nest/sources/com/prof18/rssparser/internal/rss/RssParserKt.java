package com.prof18.rssparser.internal.rss;

import com.prof18.rssparser.internal.ChannelFactory;
import com.prof18.rssparser.internal.RssKeyword;
import com.prof18.rssparser.internal.XmlPullParser_Kt;
import com.prof18.rssparser.model.RssChannel;
import com.prof18.rssparser.model.RssItem;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: RssParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"extractRSSContent", "Lcom/prof18/rssparser/model/RssChannel;", "Lkotlinx/coroutines/CoroutineScope;", "xmlPullParser", "Lorg/xmlpull/v1/XmlPullParser;", "rssparser_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RssParserKt {
    public static final RssChannel extractRSSContent(CoroutineScope coroutineScope, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(xmlPullParser, "xmlPullParser");
        ChannelFactory channelFactory = new ChannelFactory();
        int eventType = xmlPullParser.getEventType();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (eventType != 1 && CoroutineScopeKt.isActive(coroutineScope)) {
            if (eventType == 2) {
                if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Channel.C0082Channel.INSTANCE)) {
                    z = true;
                } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.C0083Item.INSTANCE)) {
                    z3 = true;
                } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Channel.Itunes.Owner.INSTANCE)) {
                    z4 = true;
                } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Channel.LastBuildDate.INSTANCE)) {
                    if (z) {
                        channelFactory.getChannelBuilder().lastBuildDate(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Channel.UpdatePeriod.INSTANCE)) {
                    if (z) {
                        channelFactory.getChannelBuilder().updatePeriod(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Url.INSTANCE)) {
                    if (z2) {
                        channelFactory.getChannelImageBuilder().url(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Channel.Itunes.Category.INSTANCE)) {
                    if (z) {
                        channelFactory.getItunesChannelBuilder().addCategory(XmlPullParser_Kt.attributeValue(xmlPullParser, RssKeyword.Channel.Itunes.Text.INSTANCE));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Channel.Itunes.Type.INSTANCE)) {
                    if (z) {
                        channelFactory.getItunesChannelBuilder().type(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Channel.Itunes.NewFeedUrl.INSTANCE)) {
                    if (z) {
                        channelFactory.getItunesChannelBuilder().newsFeedUrl(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Author.INSTANCE)) {
                    if (z3) {
                        channelFactory.getArticleBuilder().author(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Category.INSTANCE)) {
                    if (z3) {
                        channelFactory.getArticleBuilder().addCategory(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Thumbnail.INSTANCE)) {
                    if (z3) {
                        channelFactory.getArticleBuilder().image(XmlPullParser_Kt.attributeValue(xmlPullParser, RssKeyword.Url.INSTANCE));
                    }
                } else if (!XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.MediaContent.INSTANCE)) {
                    if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Enclosure.INSTANCE)) {
                        if (z3) {
                            String strAttributeValue = XmlPullParser_Kt.attributeValue(xmlPullParser, RssKeyword.Item.Type.INSTANCE);
                            if (strAttributeValue != null && StringsKt.contains$default((CharSequence) strAttributeValue, (CharSequence) "image", false, 2, (Object) null)) {
                                channelFactory.getArticleBuilder().image(XmlPullParser_Kt.attributeValue(xmlPullParser, RssKeyword.Url.INSTANCE));
                            } else if (strAttributeValue != null && StringsKt.contains$default((CharSequence) strAttributeValue, (CharSequence) "audio", false, 2, (Object) null)) {
                                channelFactory.getArticleBuilder().audioIfNull(XmlPullParser_Kt.attributeValue(xmlPullParser, RssKeyword.Url.INSTANCE));
                            } else if (strAttributeValue != null && StringsKt.contains$default((CharSequence) strAttributeValue, (CharSequence) "video", false, 2, (Object) null)) {
                                channelFactory.getArticleBuilder().videoIfNull(XmlPullParser_Kt.attributeValue(xmlPullParser, RssKeyword.Url.INSTANCE));
                            } else {
                                RssItem.Builder articleBuilder = channelFactory.getArticleBuilder();
                                String strNextText = xmlPullParser.nextText();
                                Intrinsics.checkNotNullExpressionValue(strNextText, "nextText(...)");
                                articleBuilder.image(StringsKt.trim((CharSequence) strNextText).toString());
                            }
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Source.INSTANCE)) {
                        if (z3) {
                            String strAttributeValue2 = XmlPullParser_Kt.attributeValue(xmlPullParser, RssKeyword.Url.INSTANCE);
                            channelFactory.getArticleBuilder().sourceName(xmlPullParser.nextText());
                            channelFactory.getArticleBuilder().sourceUrl(strAttributeValue2);
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Time.INSTANCE)) {
                        if (z3) {
                            channelFactory.getArticleBuilder().pubDate(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Guid.INSTANCE)) {
                        if (z3) {
                            channelFactory.getArticleBuilder().guid(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Content.INSTANCE)) {
                        if (z3) {
                            String strNextTrimmedText = XmlPullParser_Kt.nextTrimmedText(xmlPullParser);
                            channelFactory.getArticleBuilder().content(strNextTrimmedText);
                            channelFactory.setImageFromContent(strNextTrimmedText);
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.PubDate.INSTANCE)) {
                        if (z3) {
                            if (xmlPullParser.next() == 4) {
                                RssItem.Builder articleBuilder2 = channelFactory.getArticleBuilder();
                                String text = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                                articleBuilder2.pubDate(StringsKt.trim((CharSequence) text).toString());
                            }
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.News.Image.INSTANCE)) {
                        if (z3) {
                            channelFactory.getArticleBuilder().image(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Itunes.Episode.INSTANCE)) {
                        if (z3) {
                            channelFactory.getItunesArticleBuilder().episode(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Itunes.EpisodeType.INSTANCE)) {
                        if (z3) {
                            channelFactory.getItunesArticleBuilder().episodeType(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Itunes.Season.INSTANCE)) {
                        if (z3) {
                            channelFactory.getItunesArticleBuilder().season(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Comments.INSTANCE)) {
                        if (z3) {
                            channelFactory.getArticleBuilder().commentUrl(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.Thumb.INSTANCE)) {
                        if (z3) {
                            channelFactory.getArticleBuilder().image(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Channel.Itunes.OwnerName.INSTANCE)) {
                        if (z4) {
                            channelFactory.getItunesOwnerBuilder().name(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Channel.Itunes.OwnerEmail.INSTANCE)) {
                        if (z4) {
                            channelFactory.getItunesOwnerBuilder().email(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Image.INSTANCE)) {
                        if (z && !z3) {
                            z2 = true;
                        } else if (z3) {
                            xmlPullParser.next();
                            String text2 = xmlPullParser.getText();
                            String string = text2 != null ? StringsKt.trim((CharSequence) text2).toString() : null;
                            String str = string;
                            if (str != null && str.length() != 0) {
                                channelFactory.getArticleBuilder().image(string);
                            } else {
                                xmlPullParser.next();
                                if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Link.INSTANCE)) {
                                    channelFactory.getArticleBuilder().image(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                                }
                            }
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Title.INSTANCE)) {
                        if (z) {
                            if (z2) {
                                channelFactory.getChannelImageBuilder().title(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                            } else if (z3) {
                                channelFactory.getArticleBuilder().title(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                            } else {
                                channelFactory.getChannelBuilder().title(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                            }
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Link.INSTANCE)) {
                        if (z) {
                            if (z2) {
                                channelFactory.getChannelImageBuilder().link(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                            } else if (z3) {
                                channelFactory.getArticleBuilder().link(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                            } else {
                                channelFactory.getChannelBuilder().link(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                            }
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Description.INSTANCE)) {
                        if (z) {
                            if (z3) {
                                String strNextTrimmedText2 = XmlPullParser_Kt.nextTrimmedText(xmlPullParser);
                                channelFactory.getArticleBuilder().description(strNextTrimmedText2);
                                channelFactory.setImageFromContent(strNextTrimmedText2);
                            } else if (z2) {
                                channelFactory.getChannelImageBuilder().description(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                            } else {
                                channelFactory.getChannelBuilder().description(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                            }
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Itunes.Author.INSTANCE)) {
                        if (z3) {
                            channelFactory.getItunesArticleBuilder().author(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        } else if (z) {
                            channelFactory.getItunesChannelBuilder().author(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Itunes.Duration.INSTANCE)) {
                        if (z3) {
                            channelFactory.getItunesArticleBuilder().duration(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        } else if (z) {
                            channelFactory.getItunesChannelBuilder().duration(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Itunes.Keywords.INSTANCE)) {
                        String strNextTrimmedText3 = XmlPullParser_Kt.nextTrimmedText(xmlPullParser);
                        if (z3) {
                            channelFactory.setArticleItunesKeywords(strNextTrimmedText3);
                        } else if (z) {
                            channelFactory.setChannelItunesKeywords(strNextTrimmedText3);
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Itunes.Image.INSTANCE)) {
                        if (z3) {
                            channelFactory.getItunesArticleBuilder().image(XmlPullParser_Kt.attributeValue(xmlPullParser, RssKeyword.Href.INSTANCE));
                        } else if (z) {
                            channelFactory.getItunesChannelBuilder().image(XmlPullParser_Kt.attributeValue(xmlPullParser, RssKeyword.Href.INSTANCE));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Itunes.Explicit.INSTANCE)) {
                        if (z3) {
                            channelFactory.getItunesArticleBuilder().explicit(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        } else if (z) {
                            channelFactory.getItunesChannelBuilder().explicit(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Itunes.Subtitle.INSTANCE)) {
                        if (z3) {
                            channelFactory.getItunesArticleBuilder().subtitle(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        } else if (z) {
                            channelFactory.getItunesChannelBuilder().subtitle(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    } else if (XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Itunes.Summary.INSTANCE)) {
                        if (z3) {
                            channelFactory.getItunesArticleBuilder().summary(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        } else if (z) {
                            channelFactory.getItunesChannelBuilder().summary(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                        }
                    }
                } else if (z3) {
                    channelFactory.getArticleBuilder().image(XmlPullParser_Kt.attributeValue(xmlPullParser, RssKeyword.Url.INSTANCE));
                }
            } else if (eventType == 3 && XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Item.C0083Item.INSTANCE)) {
                channelFactory.buildArticle();
                z3 = false;
            } else if (eventType == 3 && XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Channel.C0082Channel.INSTANCE)) {
                z = false;
            } else if (eventType == 3 && XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Image.INSTANCE)) {
                z2 = false;
            } else if (eventType == 3 && XmlPullParser_Kt.contains(xmlPullParser, RssKeyword.Channel.Itunes.Owner.INSTANCE)) {
                channelFactory.buildItunesOwner();
                z4 = false;
            }
            eventType = xmlPullParser.next();
        }
        return channelFactory.build();
    }
}
