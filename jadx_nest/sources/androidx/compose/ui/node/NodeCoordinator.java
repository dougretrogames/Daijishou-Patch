package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: NodeCoordinator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b#\b \u0018\u0000 \u0092\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u0092\u0002\u0093\u0002B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\u0089\u0001\u001a\u00020\u001d2\u0007\u0010\u008a\u0001\u001a\u00020\u00002\u0007\u0010\u008b\u0001\u001a\u00020\u000b2\u0007\u0010\u008c\u0001\u001a\u00020#H\u0002J)\u0010\u0089\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u00002\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001d\u0010\u0091\u0001\u001a\u00020T2\u0006\u0010S\u001a\u00020TH\u0004ø\u0001\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J'\u0010\u0094\u0001\u001a\u00020\u00172\b\u0010\u0095\u0001\u001a\u00030\u008d\u00012\u0006\u0010S\u001a\u00020TH\u0004ø\u0001\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0010\u0010\u0098\u0001\u001a\u00020\u001d2\u0007\u0010\u0099\u0001\u001a\u00020\u001cJ\u001c\u0010\u009a\u0001\u001a\u00020\u001d2\u0007\u0010\u0099\u0001\u001a\u00020\u001c2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0004J\u0012\u0010\u009d\u0001\u001a\u00020\u001d2\u0007\u0010\u0099\u0001\u001a\u00020\u001cH\u0002J\t\u0010\u009e\u0001\u001a\u00020\u001dH&J\u0018\u0010\u009f\u0001\u001a\u00020\u00002\u0007\u0010 \u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b¡\u0001J\u001f\u0010¢\u0001\u001a\u00030\u008d\u00012\u0007\u0010e\u001a\u00030\u008d\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b£\u0001\u0010\u0093\u0001J\u001b\u0010¤\u0001\u001a\u00020\u001d2\u0007\u0010¥\u0001\u001a\u00020\u000b2\u0007\u0010\u008c\u0001\u001a\u00020#H\u0002J#\u0010¦\u0001\u001a\u00020#2\f\u0010§\u0001\u001a\u0007\u0012\u0002\b\u00030¨\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b©\u0001\u0010ª\u0001J#\u0010«\u0001\u001a\u0004\u0018\u00010z2\f\u0010§\u0001\u001a\u0007\u0012\u0002\b\u00030¨\u0001ø\u0001\u0000¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J\u0014\u0010®\u0001\u001a\u0004\u0018\u00010z2\u0007\u0010¯\u0001\u001a\u00020#H\u0002JC\u0010°\u0001\u001a\u00020\u001d2\b\u0010±\u0001\u001a\u00030²\u00012\b\u0010\u0095\u0001\u001a\u00030\u008d\u00012\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010µ\u0001\u001a\u00020#2\u0007\u0010¶\u0001\u001a\u00020#ø\u0001\u0000¢\u0006\u0006\b·\u0001\u0010¸\u0001JE\u0010¹\u0001\u001a\u00020\u001d2\b\u0010±\u0001\u001a\u00030²\u00012\b\u0010\u0095\u0001\u001a\u00030\u008d\u00012\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010µ\u0001\u001a\u00020#2\u0007\u0010¶\u0001\u001a\u00020#H\u0016ø\u0001\u0000¢\u0006\u0006\bº\u0001\u0010¸\u0001J\t\u0010»\u0001\u001a\u00020\u001dH\u0016J\u001f\u0010¼\u0001\u001a\u00020#2\b\u0010\u0095\u0001\u001a\u00030\u008d\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u0007\u0010¿\u0001\u001a\u00020#J\u001c\u0010À\u0001\u001a\u00030Á\u00012\u0007\u0010Â\u0001\u001a\u00020\u00032\u0007\u0010\u008c\u0001\u001a\u00020#H\u0016J)\u0010Ã\u0001\u001a\u00030\u008d\u00012\u0007\u0010Â\u0001\u001a\u00020\u00032\b\u0010Ä\u0001\u001a\u00030\u008d\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J \u0010Ç\u0001\u001a\u00030\u008d\u00012\b\u0010È\u0001\u001a\u00030\u008d\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÉ\u0001\u0010\u0093\u0001J \u0010Ê\u0001\u001a\u00030\u008d\u00012\b\u0010È\u0001\u001a\u00030\u008d\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bË\u0001\u0010\u0093\u0001J \u0010Ì\u0001\u001a\u00030\u008d\u00012\b\u0010\u0095\u0001\u001a\u00030\u008d\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bÍ\u0001\u0010\u0093\u0001J\u000f\u0010Î\u0001\u001a\u00020\u001dH\u0000¢\u0006\u0003\bÏ\u0001J\t\u0010Ð\u0001\u001a\u00020\u001dH\u0016J\u0007\u0010Ñ\u0001\u001a\u00020\u001dJ\u001b\u0010Ò\u0001\u001a\u00020\u001d2\u0007\u0010Ó\u0001\u001a\u00020Y2\u0007\u0010Ô\u0001\u001a\u00020YH\u0014J\u0007\u0010Õ\u0001\u001a\u00020\u001dJ\u0007\u0010Ö\u0001\u001a\u00020\u001dJ\u0007\u0010×\u0001\u001a\u00020\u001dJ\u0012\u0010Ø\u0001\u001a\u00020\u001d2\u0007\u0010\u0099\u0001\u001a\u00020\u001cH\u0016J2\u0010Ù\u0001\u001a\u00030Ú\u00012\u0007\u0010Û\u0001\u001a\u0002002\u0010\b\u0004\u0010Ü\u0001\u001a\t\u0012\u0005\u0012\u00030Ú\u00010'H\u0084\bø\u0001\u0000¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001JA\u0010ß\u0001\u001a\u00020\u001d2\u0006\u0010e\u001a\u00020d2\u0007\u0010\u0085\u0001\u001a\u00020\u00172\u0019\u00109\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b8H\u0014ø\u0001\u0000¢\u0006\u0006\bà\u0001\u0010á\u0001JA\u0010â\u0001\u001a\u00020\u001d2\u0006\u0010e\u001a\u00020d2\u0007\u0010\u0085\u0001\u001a\u00020\u00172\u0019\u00109\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b8H\u0002ø\u0001\u0000¢\u0006\u0006\bã\u0001\u0010á\u0001J?\u0010ä\u0001\u001a\u00020\u001d2\u0006\u0010e\u001a\u00020d2\u0007\u0010\u0085\u0001\u001a\u00020\u00172\u0019\u00109\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b8ø\u0001\u0000¢\u0006\u0006\bå\u0001\u0010á\u0001J,\u0010æ\u0001\u001a\u00020\u001d2\u0007\u0010¥\u0001\u001a\u00020\u000b2\u0007\u0010\u008c\u0001\u001a\u00020#2\t\b\u0002\u0010ç\u0001\u001a\u00020#H\u0000¢\u0006\u0003\bè\u0001J\u000f\u0010é\u0001\u001a\u00020\u001dH\u0010¢\u0006\u0003\bê\u0001J\u0007\u0010ë\u0001\u001a\u00020#J\u001f\u0010ì\u0001\u001a\u00030\u008d\u00012\u0007\u0010e\u001a\u00030\u008d\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bí\u0001\u0010\u0093\u0001J\b\u0010î\u0001\u001a\u00030Á\u0001J(\u0010ï\u0001\u001a\u00020\u001d2\u0007\u0010Â\u0001\u001a\u00020\u00032\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bò\u0001\u0010ó\u0001J(\u0010ô\u0001\u001a\u00020\u001d2\u0007\u0010\u008a\u0001\u001a\u00020\u00002\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bõ\u0001\u0010ö\u0001J(\u0010÷\u0001\u001a\u00020\u001d2\u0007\u0010\u008a\u0001\u001a\u00020\u00002\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bø\u0001\u0010ö\u0001J-\u0010ù\u0001\u001a\u00020\u001d2\u0019\u00109\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b82\t\b\u0002\u0010ú\u0001\u001a\u00020#J\u0014\u0010û\u0001\u001a\u00020\u001d2\t\b\u0002\u0010ü\u0001\u001a\u00020#H\u0002JF\u0010ý\u0001\u001a\u00020\u001d\"\u0007\b\u0000\u0010þ\u0001\u0018\u00012\u000f\u0010§\u0001\u001a\n\u0012\u0005\u0012\u0003Hþ\u00010¨\u00012\u0014\u0010Ü\u0001\u001a\u000f\u0012\u0005\u0012\u0003Hþ\u0001\u0012\u0004\u0012\u00020\u001d0\u001bH\u0086\bø\u0001\u0000¢\u0006\u0006\bÿ\u0001\u0010\u0080\u0002J1\u0010ý\u0001\u001a\u00020\u001d2\u0007\u0010\u0081\u0002\u001a\u00020Y2\u0007\u0010¯\u0001\u001a\u00020#2\u0013\u0010Ü\u0001\u001a\u000e\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u001d0\u001bH\u0086\bJ \u0010\u0082\u0002\u001a\u00030\u008d\u00012\b\u0010\u0083\u0002\u001a\u00030\u008d\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0084\u0002\u0010\u0093\u0001J(\u0010\u0085\u0002\u001a\u00020\u001d2\u0007\u0010\u0099\u0001\u001a\u00020\u001c2\u0013\u0010Ü\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bH\u0084\bJ\u001f\u0010\u0086\u0002\u001a\u00020#2\b\u0010\u0095\u0001\u001a\u00030\u008d\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\b\u0087\u0002\u0010¾\u0001JK\u0010\u0088\u0002\u001a\u00020\u001d*\u0004\u0018\u00010z2\b\u0010±\u0001\u001a\u00030²\u00012\b\u0010\u0095\u0001\u001a\u00030\u008d\u00012\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010µ\u0001\u001a\u00020#2\u0007\u0010¶\u0001\u001a\u00020#H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0089\u0002\u0010\u008a\u0002JT\u0010\u008b\u0002\u001a\u00020\u001d*\u0004\u0018\u00010z2\b\u0010±\u0001\u001a\u00030²\u00012\b\u0010\u0095\u0001\u001a\u00030\u008d\u00012\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010µ\u0001\u001a\u00020#2\u0007\u0010¶\u0001\u001a\u00020#2\u0007\u0010\u008c\u0002\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0006\b\u008d\u0002\u0010\u008e\u0002JT\u0010\u008f\u0002\u001a\u00020\u001d*\u0004\u0018\u00010z2\b\u0010±\u0001\u001a\u00030²\u00012\b\u0010\u0095\u0001\u001a\u00030\u008d\u00012\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010µ\u0001\u001a\u00020#2\u0007\u0010¶\u0001\u001a\u00020#2\u0007\u0010\u008c\u0002\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0090\u0002\u0010\u008e\u0002J\r\u0010\u0091\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010%R\u000e\u0010)\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010%R\u000e\u0010+\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020#2\u0006\u0010,\u001a\u00020#@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u001a\u0010/\u001a\u0002008@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b1\u00102R\"\u00104\u001a\u0004\u0018\u0001032\b\u0010,\u001a\u0004\u0018\u000103@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u00106RD\u00109\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b82\u0019\u0010,\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b¢\u0006\u0002\b8@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\u00020?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR&\u0010H\u001a\u0004\u0018\u00010G2\b\u0010,\u001a\u0004\u0018\u00010G@dX¦\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010N\u001a\u00020\t2\u0006\u0010M\u001a\u00020\t8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0017\u0010S\u001a\u00020T8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bU\u00102R\u001c\u0010V\u001a\u0010\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020Y\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Z\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0012R\u0013\u0010\\\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b]\u0010\u0015R\u0016\u0010^\u001a\u0004\u0018\u00010_8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0013\u0010b\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bc\u0010\u0015R,\u0010e\u001a\u00020d2\u0006\u0010,\u001a\u00020d@TX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010i\u001a\u0004\bf\u00102\"\u0004\bg\u0010hR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020X0k8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020\u000b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u000e\u0010q\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010r\u001a\u00020s8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bt\u00102R\u0014\u0010u\u001a\u00020v8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0012\u0010y\u001a\u00020zX¦\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R\u001e\u0010}\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R \u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u007f\"\u0006\b\u0084\u0001\u0010\u0081\u0001R(\u0010\u0085\u0001\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0017@DX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0019\"\u0006\b\u0087\u0001\u0010\u0088\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0094\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "getDrawBlock$annotations", "()V", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValidOwnerScope", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "()J", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "released", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "zIndex", "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "ancestorToLocal-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "ensureLookaheadDelegateCreated", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-MK-Hz9U", "fromParentRect", "bounds", "hasNode", "type", "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", "head", "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "headNode", "includeTail", "hitTest", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-YqVAtuI", "invalidateLayer", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onCoordinatesUsed", "onCoordinatesUsed$ui_release", "onLayoutModifierNodeChanged", "onLayoutNodeAttach", "onMeasureResultChanged", "width", "height", "onMeasured", "onPlaced", "onRelease", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeSelf", "placeSelf-f8xVGno", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset-f8xVGno", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "replace", "replace$ui_release", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-MK-Hz9U", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "updateLayerBlock", "forceUpdateLayerParameters", "updateLayerParameters", "invokeOnLayoutChange", "visitNodes", ExifInterface.GPS_DIRECTION_TRUE, "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-1hIXUjU", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitNear", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "speculativeHit", "speculativeHit-JHbHoSQ", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope {
    public static final int $stable = 0;
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private boolean isClipping;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = NodeCoordinator$Companion$onCommitAffectingLayerParams$1.INSTANCE;
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = NodeCoordinator$Companion$onCommitAffectingLayer$1.INSTANCE;
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m762constructorimpl$default(null, 1, null);
    private static final HitTestSource PointerInputSource = new NodeCoordinator$Companion$PointerInputSource$1();
    private static final HitTestSource SemanticsSource = new NodeCoordinator$Companion$SemanticsSource$1();
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    private float lastLayerAlpha = 0.8f;
    private long position = IntOffset.INSTANCE.m3022getZeronOccac();
    private final Function1<Canvas, Unit> drawBlock = new NodeCoordinator$drawBlock$1(this);
    private final Function0<Unit> invalidateParentLayer = new NodeCoordinator$invalidateParentLayer$1(this);

    /* JADX INFO: compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H&ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface HitTestSource {
        /* JADX INFO: renamed from: childHitTest-YqVAtuI */
        void mo2029childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer);

        /* JADX INFO: renamed from: entityType-OLwlOKw */
        int mo2030entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode parentLayoutNode);
    }

    private static /* synthetic */ void getDrawBlock$annotations() {
    }

    public abstract void ensureLookaheadDelegateCreated();

    public abstract LookaheadDelegate getLookaheadDelegate();

    public abstract Modifier.Node getTail();

    protected abstract void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate);

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
    }

    /* JADX INFO: renamed from: getWrapped$ui_release, reason: from getter */
    public final NodeCoordinator getWrapped() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    /* JADX INFO: renamed from: getWrappedBy$ui_release, reason: from getter */
    public final NodeCoordinator getWrappedBy() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node headNode(boolean includeTail) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes().getHead();
        }
        if (includeTail) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null) {
                return null;
            }
            return tail.getChild();
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            return nodeCoordinator2.getTail();
        }
        return null;
    }

    public final void visitNodes(int mask, boolean includeTail, Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node tail = getTail();
        if (!includeTail && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(includeTail); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & mask) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & mask) != 0) {
                block.invoke(nodeHeadNode);
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: visitNodes-aLcG6gQ, reason: not valid java name */
    public final /* synthetic */ <T> void m2027visitNodesaLcG6gQ(int type, Function1<? super T, Unit> block) {
        boolean zM2043getIncludeSelfInTraversalH91voCI = NodeKindKt.m2043getIncludeSelfInTraversalH91voCI(type);
        Modifier.Node tail = getTail();
        if (!zM2043getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM2043getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & type) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & type) != 0) {
                Modifier.Node nodePop = nodeHeadNode;
                MutableVector mutableVector = null;
                while (nodePop != null) {
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    if (nodePop instanceof Object) {
                        block.invoke(nodePop);
                    } else if ((nodePop.getKindSet() & type) != 0 && (nodePop instanceof DelegatingNode)) {
                        int i = 0;
                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                            if ((delegate$ui_release.getKindSet() & type) != 0) {
                                i++;
                                if (i == 1) {
                                    nodePop = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (nodePop != null) {
                                        if (mutableVector != null) {
                                            mutableVector.add(nodePop);
                                        }
                                        nodePop = null;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                            }
                        }
                        if (i == 1) {
                        }
                    }
                    nodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: hasNode-H91voCI, reason: not valid java name */
    private final boolean m2007hasNodeH91voCI(int type) {
        Modifier.Node nodeHeadNode = headNode(NodeKindKt.m2043getIncludeSelfInTraversalH91voCI(type));
        return nodeHeadNode != null && DelegatableNodeKt.m1929has64DMado(nodeHeadNode, type);
    }

    /* JADX INFO: renamed from: head-H91voCI, reason: not valid java name */
    public final Modifier.Node m2020headH91voCI(int type) {
        boolean zM2043getIncludeSelfInTraversalH91voCI = NodeKindKt.m2043getIncludeSelfInTraversalH91voCI(type);
        Modifier.Node tail = getTail();
        if (!zM2043getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return null;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM2043getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & type) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & type) != 0) {
                return nodeHeadNode;
            }
            if (nodeHeadNode == tail) {
                return null;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public final long mo1831getSizeYbymL2g() {
        return getMeasuredSize();
    }

    protected final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        mo1825placeAtf8xVGno(getPosition(), this.zIndex, this.layerBlock);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getTail().getIsAttached();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    public void setMeasureResult$ui_release(MeasureResult measureResult) {
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (measureResult2 == null || measureResult.get$width() != measureResult2.get$width() || measureResult.get$height() != measureResult2.get$height()) {
                onMeasureResultChanged(measureResult.get$width(), measureResult.get$height());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if (((map == null || map.isEmpty()) && measureResult.getAlignmentLines().isEmpty()) || Intrinsics.areEqual(measureResult.getAlignmentLines(), this.oldAlignmentLines)) {
                return;
            }
            getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            LinkedHashMap linkedHashMap = this.oldAlignmentLines;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                this.oldAlignmentLines = linkedHashMap;
            }
            linkedHashMap.clear();
            linkedHashMap.putAll(measureResult.getAlignmentLines());
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        LinkedHashSet linkedHashSet = null;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrapped) {
            MeasureResult measureResult = nodeCoordinator._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.addAll(alignmentLines.keySet());
            }
        }
        return linkedHashSet == null ? SetsKt.emptySet() : linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6 */
    protected void onMeasureResultChanged(int width, int height) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo2085resizeozmzZPI(IntSizeKt.IntSize(width, height));
        } else {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.invalidateLayer();
            }
        }
        m1876setMeasuredSizeozmzZPI(IntSizeKt.IntSize(width, height));
        updateLayerParameters(false);
        int iM2034constructorimpl = NodeKind.m2034constructorimpl(4);
        boolean zM2043getIncludeSelfInTraversalH91voCI = NodeKindKt.m2043getIncludeSelfInTraversalH91voCI(iM2034constructorimpl);
        Modifier.Node tail = getTail();
        if (zM2043getIncludeSelfInTraversalH91voCI || (tail = tail.getParent()) != null) {
            for (Modifier.Node nodeHeadNode = headNode(zM2043getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM2034constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
                if ((nodeHeadNode.getKindSet() & iM2034constructorimpl) != 0) {
                    Modifier.Node nodePop = nodeHeadNode;
                    MutableVector mutableVector = null;
                    while (nodePop != 0) {
                        if (nodePop instanceof DrawModifierNode) {
                            ((DrawModifierNode) nodePop).onMeasureResultChanged();
                        } else if ((nodePop.getKindSet() & iM2034constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate();
                            int i = 0;
                            nodePop = nodePop;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet() & iM2034constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != 0) {
                                            if (mutableVector != null) {
                                                mutableVector.add(nodePop);
                                            }
                                            nodePop = 0;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild();
                                nodePop = nodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (nodeHeadNode == tail) {
                    break;
                }
            }
        }
        Owner owner = getLayoutNode().getOwner();
        if (owner != null) {
            owner.onLayoutChange(getLayoutNode());
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* JADX INFO: renamed from: getPosition-nOcc-ac, reason: from getter */
    public long getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: setPosition--gyyYBs, reason: not valid java name */
    protected void m2025setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    protected final void setZIndex(float f) {
        this.zIndex = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        if (!getLayoutNode().getNodes().m1997hasH91voCI$ui_release(NodeKind.m2034constructorimpl(64))) {
            return null;
        }
        getTail();
        kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        for (Modifier.Node tail = getLayoutNode().getNodes().getTail(); tail != null; tail = tail.getParent()) {
            if ((NodeKind.m2034constructorimpl(64) & tail.getKindSet()) != 0) {
                int iM2034constructorimpl = NodeKind.m2034constructorimpl(64);
                MutableVector mutableVector = null;
                Modifier.Node nodePop = tail;
                while (nodePop != 0) {
                    if (nodePop instanceof ParentDataModifierNode) {
                        objectRef.element = ((ParentDataModifierNode) nodePop).modifyParentData(getLayoutNode().getDensity(), objectRef.element);
                    } else if ((nodePop.getKindSet() & iM2034constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate();
                        int i = 0;
                        nodePop = nodePop;
                        while (delegate$ui_release != null) {
                            if ((delegate$ui_release.getKindSet() & iM2034constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    nodePop = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (nodePop != 0) {
                                        if (mutableVector != null) {
                                            mutableVector.add(nodePop);
                                        }
                                        nodePop = 0;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                            }
                            delegate$ui_release = delegate$ui_release.getChild();
                            nodePop = nodePop;
                        }
                        if (i == 1) {
                        }
                    }
                    nodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
        }
        return objectRef.element;
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        onCoordinatesUsed$ui_release();
        return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        onCoordinatesUsed$ui_release();
        return this.wrappedBy;
    }

    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* JADX INFO: renamed from: getLastMeasurementConstraints-msEJaDk$ui_release, reason: not valid java name */
    public final long m2018getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return getMeasurementConstraints();
    }

    /* JADX INFO: renamed from: performingMeasure-K40F9xA, reason: not valid java name */
    protected final Placeable m2023performingMeasureK40F9xA(long constraints, Function0<? extends Placeable> block) {
        m1877setMeasurementConstraintsBRTryo0(constraints);
        return block.invoke();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo1825placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        m2011placeSelff8xVGno(position, zIndex, layerBlock);
    }

    /* JADX INFO: renamed from: placeSelf-f8xVGno, reason: not valid java name */
    private final void m2011placeSelff8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        updateLayerBlock$default(this, layerBlock, false, 2, null);
        if (!IntOffset.m3011equalsimpl0(getPosition(), position)) {
            m2025setPositiongyyYBs(position);
            getLayoutNode().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo2084movegyyYBs(position);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner = getLayoutNode().getOwner();
            if (owner != null) {
                owner.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = zIndex;
    }

    /* JADX INFO: renamed from: placeSelfApparentToRealOffset-f8xVGno, reason: not valid java name */
    public final void m2024placeSelfApparentToRealOffsetf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        long j = getApparentToRealOffset();
        m2011placeSelff8xVGno(IntOffsetKt.IntOffset(IntOffset.m3012getXimpl(position) + IntOffset.m3012getXimpl(j), IntOffset.m3013getYimpl(position) + IntOffset.m3013getYimpl(j)), zIndex, layerBlock);
    }

    public final void draw(Canvas canvas) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas);
            return;
        }
        float fM3012getXimpl = IntOffset.m3012getXimpl(getPosition());
        float fM3013getYimpl = IntOffset.m3013getYimpl(getPosition());
        canvas.translate(fM3012getXimpl, fM3013getYimpl);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-fM3012getXimpl, -fM3013getYimpl);
    }

    public void performDraw(Canvas canvas) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas);
        }
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        nodeCoordinator.updateLayerBlock(function1, z);
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> layerBlock, boolean forceUpdateLayerParameters) {
        Owner owner;
        LayoutNode layoutNode = getLayoutNode();
        boolean z = (!forceUpdateLayerParameters && this.layerBlock == layerBlock && Intrinsics.areEqual(this.layerDensity, layoutNode.getDensity()) && this.layerLayoutDirection == layoutNode.getLayoutDirection()) ? false : true;
        this.layerBlock = layerBlock;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        if (layoutNode.isAttached() && layerBlock != null) {
            if (this.layer != null) {
                if (z) {
                    updateLayerParameters$default(this, false, 1, null);
                    return;
                }
                return;
            }
            OwnedLayer ownedLayerCreateLayer = LayoutNodeKt.requireOwner(layoutNode).createLayer(this.drawBlock, this.invalidateParentLayer);
            ownedLayerCreateLayer.mo2085resizeozmzZPI(getMeasuredSize());
            ownedLayerCreateLayer.mo2084movegyyYBs(getPosition());
            this.layer = ownedLayerCreateLayer;
            updateLayerParameters$default(this, false, 1, null);
            layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            return;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.destroy();
            layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            if (isAttached() && (owner = layoutNode.getOwner()) != null) {
                owner.onLayoutChange(layoutNode);
            }
        }
        this.layer = null;
        this.lastLayerDrawingWasSkipped = false;
    }

    static /* synthetic */ void updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        nodeCoordinator.updateLayerParameters(z);
    }

    private final void updateLayerParameters(boolean invokeOnLayoutChange) {
        Owner owner;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 == null) {
                throw new IllegalStateException("updateLayerParameters requires a non-null layerBlock".toString());
            }
            ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
            reusableGraphicsLayerScope.reset();
            reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
            reusableGraphicsLayerScope.m843setSizeuvyYCjk(IntSizeKt.m3064toSizeozmzZPI(mo1831getSizeYbymL2g()));
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new AnonymousClass1(function1));
            LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
            if (layerPositionalProperties == null) {
                layerPositionalProperties = new LayerPositionalProperties();
                this.layerPositionalProperties = layerPositionalProperties;
            }
            layerPositionalProperties.copyFrom(reusableGraphicsLayerScope);
            ownedLayer.updateLayerProperties(reusableGraphicsLayerScope, getLayoutNode().getLayoutDirection(), getLayoutNode().getDensity());
            this.isClipping = reusableGraphicsLayerScope.getClip();
            this.lastLayerAlpha = reusableGraphicsLayerScope.getAlpha();
            if (!invokeOnLayoutChange || (owner = getLayoutNode().getOwner()) == null) {
                return;
            }
            owner.onLayoutChange(getLayoutNode());
            return;
        }
        if (this.layerBlock != null) {
            throw new IllegalStateException("null layer with a non-null layerBlock".toString());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1, reason: invalid class name */
    /* JADX INFO: compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Function1<GraphicsLayerScope, Unit> $layerBlock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super GraphicsLayerScope, Unit> function1) {
            super(0);
            this.$layerBlock = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$layerBlock.invoke(NodeCoordinator.graphicsLayerScope);
        }
    }

    /* JADX INFO: renamed from: getLastLayerDrawingWasSkipped$ui_release, reason: from getter */
    public final boolean getLastLayerDrawingWasSkipped() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return (this.layer == null || this.released || !getLayoutNode().isAttached()) ? false : true;
    }

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m2019getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo1786toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo1961getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* JADX INFO: renamed from: hitTest-YqVAtuI, reason: not valid java name */
    public final void m2021hitTestYqVAtuI(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Modifier.Node nodeM2020headH91voCI = m2020headH91voCI(hitTestSource.mo2030entityTypeOLwlOKw());
        if (!m2028withinLayerBoundsk4lQ0M(pointerPosition)) {
            if (isTouchEvent) {
                float fM2016distanceInMinimumTouchTargettz77jQw = m2016distanceInMinimumTouchTargettz77jQw(pointerPosition, m2019getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(fM2016distanceInMinimumTouchTargettz77jQw) || Float.isNaN(fM2016distanceInMinimumTouchTargettz77jQw) || !hitTestResult.isHitInMinimumTouchTargetBetter(fM2016distanceInMinimumTouchTargettz77jQw, false)) {
                    return;
                }
                m2009hitNearJHbHoSQ(nodeM2020headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, false, fM2016distanceInMinimumTouchTargettz77jQw);
                return;
            }
            return;
        }
        if (nodeM2020headH91voCI == null) {
            mo1952hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        if (m2022isPointerInBoundsk4lQ0M(pointerPosition)) {
            m2008hit1hIXUjU(nodeM2020headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        float fM2016distanceInMinimumTouchTargettz77jQw2 = !isTouchEvent ? Float.POSITIVE_INFINITY : m2016distanceInMinimumTouchTargettz77jQw(pointerPosition, m2019getMinimumTouchTargetSizeNHjbRc());
        if (!Float.isInfinite(fM2016distanceInMinimumTouchTargettz77jQw2) && !Float.isNaN(fM2016distanceInMinimumTouchTargettz77jQw2) && hitTestResult.isHitInMinimumTouchTargetBetter(fM2016distanceInMinimumTouchTargettz77jQw2, isInLayer)) {
            m2009hitNearJHbHoSQ(nodeM2020headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, fM2016distanceInMinimumTouchTargettz77jQw2);
        } else {
            m2012speculativeHitJHbHoSQ(nodeM2020headH91voCI, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, fM2016distanceInMinimumTouchTargettz77jQw2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hit-1hIXUjU, reason: not valid java name */
    public final void m2008hit1hIXUjU(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        if (node == null) {
            mo1952hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hit(node, z2, new NodeCoordinator$hit$1(this, node, hitTestSource, j, hitTestResult, z, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hitNear-JHbHoSQ, reason: not valid java name */
    public final void m2009hitNearJHbHoSQ(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2, float f) {
        if (node == null) {
            mo1952hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hitInMinimumTouchTarget(node, f, z2, new NodeCoordinator$hitNear$1(this, node, hitTestSource, j, hitTestResult, z, z2, f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: speculativeHit-JHbHoSQ, reason: not valid java name */
    public final void m2012speculativeHitJHbHoSQ(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2, float f) {
        if (node == null) {
            mo1952hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (!hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            m2012speculativeHitJHbHoSQ(NodeCoordinatorKt.m2032nextUntilhw7D004(node, hitTestSource.mo2030entityTypeOLwlOKw(), NodeKind.m2034constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
        } else {
            hitTestResult.speculativeHit(node, f, z2, new NodeCoordinator$speculativeHit$1(this, node, hitTestSource, j, hitTestResult, z, z2, f));
        }
    }

    /* JADX INFO: renamed from: hitTestChild-YqVAtuI */
    public void mo1952hitTestChildYqVAtuI(HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m2021hitTestYqVAtuI(hitTestSource, nodeCoordinator.m2017fromParentPositionMKHz9U(pointerPosition), hitTestResult, isTouchEvent, isInLayer);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.INSTANCE.getZero();
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long jM2015calculateMinimumTouchTargetPaddingE7KxVPU = m2015calculateMinimumTouchTargetPaddingE7KxVPU(m2019getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m358getWidthimpl(jM2015calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setTop(-Size.m355getHeightimpl(jM2015calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setRight(getMeasuredWidth() + Size.m358getWidthimpl(jM2015calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setBottom(getMeasuredHeight() + Size.m355getHeightimpl(jM2015calculateMinimumTouchTargetPaddingE7KxVPU));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != layoutCoordinatesFindRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public long mo1836windowToLocalMKHz9U(long relativeToWindow) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return mo1832localPositionOfR5De75A(layoutCoordinatesFindRootCoordinates, Offset.m293minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo2087calculateLocalPositionMKHz9U(relativeToWindow), LayoutCoordinatesKt.positionInRoot(layoutCoordinatesFindRootCoordinates)));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public long mo1834localToWindowMKHz9U(long relativeToLocal) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo2088calculatePositionInWindowMKHz9U(mo1833localToRootMKHz9U(relativeToLocal));
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates != null && (coordinator = lookaheadLayoutCoordinates.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public long mo1832localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        if (sourceCoordinates instanceof LookaheadLayoutCoordinates) {
            return Offset.m298unaryMinusF1C5BW0(sourceCoordinates.mo1832localPositionOfR5De75A(this, Offset.m298unaryMinusF1C5BW0(relativeToSource)));
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui_release) {
            relativeToSource = coordinator.m2026toParentPositionMKHz9U(relativeToSource);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m2006ancestorToLocalR5De75A(nodeCoordinatorFindCommonAncestor$ui_release, relativeToSource);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformFrom-EL8BTi8 */
    public void mo1835transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m771resetimpl(matrix);
        coordinator.m2014transformToAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui_release, matrix);
        m2013transformFromAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui_release, matrix);
    }

    /* JADX INFO: renamed from: transformToAncestor-EL8BTi8, reason: not valid java name */
    private final void m2014transformToAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        NodeCoordinator nodeCoordinator = this;
        while (!Intrinsics.areEqual(nodeCoordinator, ancestor)) {
            OwnedLayer ownedLayer = nodeCoordinator.layer;
            if (ownedLayer != null) {
                ownedLayer.mo2086transform58bKbWc(matrix);
            }
            long position = nodeCoordinator.getPosition();
            if (!IntOffset.m3011equalsimpl0(position, IntOffset.INSTANCE.m3022getZeronOccac())) {
                float[] fArr = tmpMatrix;
                Matrix.m771resetimpl(fArr);
                Matrix.m782translateimpl$default(fArr, IntOffset.m3012getXimpl(position), IntOffset.m3013getYimpl(position), 0.0f, 4, null);
                Matrix.m779timesAssign58bKbWc(matrix, fArr);
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
    }

    /* JADX INFO: renamed from: transformFromAncestor-EL8BTi8, reason: not valid java name */
    private final void m2013transformFromAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        if (Intrinsics.areEqual(ancestor, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        Intrinsics.checkNotNull(nodeCoordinator);
        nodeCoordinator.m2013transformFromAncestorEL8BTi8(ancestor, matrix);
        if (!IntOffset.m3011equalsimpl0(getPosition(), IntOffset.INSTANCE.m3022getZeronOccac())) {
            float[] fArr = tmpMatrix;
            Matrix.m771resetimpl(fArr);
            Matrix.m782translateimpl$default(fArr, -IntOffset.m3012getXimpl(getPosition()), -IntOffset.m3013getYimpl(getPosition()), 0.0f, 4, null);
            Matrix.m779timesAssign58bKbWc(matrix, fArr);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo2081inverseTransform58bKbWc(matrix);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        if (!sourceCoordinates.isAttached()) {
            throw new IllegalStateException(("LayoutCoordinates " + sourceCoordinates + " is not attached!").toString());
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight(IntSize.m3054getWidthimpl(sourceCoordinates.mo1831getSizeYbymL2g()));
        rectCache.setBottom(IntSize.m3053getHeightimpl(sourceCoordinates.mo1831getSizeYbymL2g()));
        NodeCoordinator nodeCoordinator = coordinator;
        while (nodeCoordinator != nodeCoordinatorFindCommonAncestor$ui_release) {
            boolean z = clipBounds;
            rectInParent$ui_release$default(nodeCoordinator, rectCache, z, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            clipBounds = z;
        }
        ancestorToLocal(nodeCoordinatorFindCommonAncestor$ui_release, rectCache, clipBounds);
        return MutableRectKt.toRect(rectCache);
    }

    /* JADX INFO: renamed from: ancestorToLocal-R5De75A, reason: not valid java name */
    private final long m2006ancestorToLocalR5De75A(NodeCoordinator ancestor, long offset) {
        if (ancestor == this) {
            return offset;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator == null || Intrinsics.areEqual(ancestor, nodeCoordinator)) {
            return m2017fromParentPositionMKHz9U(offset);
        }
        return m2017fromParentPositionMKHz9U(nodeCoordinator.m2006ancestorToLocalR5De75A(ancestor, offset));
    }

    private final void ancestorToLocal(NodeCoordinator ancestor, MutableRect rect, boolean clipBounds) {
        if (ancestor == this) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.ancestorToLocal(ancestor, rect, clipBounds);
        }
        fromParentRect(rect, clipBounds);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public long mo1833localToRootMKHz9U(long relativeToLocal) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        onCoordinatesUsed$ui_release();
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            relativeToLocal = nodeCoordinator.m2026toParentPositionMKHz9U(relativeToLocal);
        }
        return relativeToLocal;
    }

    protected final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> block) {
        float fM3012getXimpl = IntOffset.m3012getXimpl(getPosition());
        float fM3013getYimpl = IntOffset.m3013getYimpl(getPosition());
        canvas.translate(fM3012getXimpl, fM3013getYimpl);
        block.invoke(canvas);
        canvas.translate(-fM3012getXimpl, -fM3013getYimpl);
    }

    /* JADX INFO: renamed from: toParentPosition-MK-Hz9U, reason: not valid java name */
    public long m2026toParentPositionMKHz9U(long position) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            position = ownedLayer.mo2083mapOffset8S9VItk(position, false);
        }
        return IntOffsetKt.m3026plusNvtHpc(position, getPosition());
    }

    /* JADX INFO: renamed from: fromParentPosition-MK-Hz9U, reason: not valid java name */
    public long m2017fromParentPositionMKHz9U(long position) {
        long jM3024minusNvtHpc = IntOffsetKt.m3024minusNvtHpc(position, getPosition());
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo2083mapOffset8S9VItk(jM3024minusNvtHpc, true) : jM3024minusNvtHpc;
    }

    protected final void drawBorder(Canvas canvas, Paint paint) {
        canvas.drawRect(new Rect(0.5f, 0.5f, IntSize.m3054getWidthimpl(getMeasuredSize()) - 0.5f, IntSize.m3053getHeightimpl(getMeasuredSize()) - 0.5f), paint);
    }

    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        if (this.layer != null) {
            updateLayerBlock$default(this, null, false, 2, null);
        }
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
    }

    public final void rectInParent$ui_release(MutableRect bounds, boolean clipBounds, boolean clipToMinimumTouchTargetSize) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (clipToMinimumTouchTargetSize) {
                    long jM2019getMinimumTouchTargetSizeNHjbRc = m2019getMinimumTouchTargetSizeNHjbRc();
                    float fM358getWidthimpl = Size.m358getWidthimpl(jM2019getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    float fM355getHeightimpl = Size.m355getHeightimpl(jM2019getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    bounds.intersect(-fM358getWidthimpl, -fM355getHeightimpl, IntSize.m3054getWidthimpl(mo1831getSizeYbymL2g()) + fM358getWidthimpl, IntSize.m3053getHeightimpl(mo1831getSizeYbymL2g()) + fM355getHeightimpl);
                } else if (clipBounds) {
                    bounds.intersect(0.0f, 0.0f, IntSize.m3054getWidthimpl(mo1831getSizeYbymL2g()), IntSize.m3053getHeightimpl(mo1831getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(bounds, false);
        }
        float fM3012getXimpl = IntOffset.m3012getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() + fM3012getXimpl);
        bounds.setRight(bounds.getRight() + fM3012getXimpl);
        float fM3013getYimpl = IntOffset.m3013getYimpl(getPosition());
        bounds.setTop(bounds.getTop() + fM3013getYimpl);
        bounds.setBottom(bounds.getBottom() + fM3013getYimpl);
    }

    private final void fromParentRect(MutableRect bounds, boolean clipBounds) {
        float fM3012getXimpl = IntOffset.m3012getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() - fM3012getXimpl);
        bounds.setRight(bounds.getRight() - fM3012getXimpl);
        float fM3013getYimpl = IntOffset.m3013getYimpl(getPosition());
        bounds.setTop(bounds.getTop() - fM3013getYimpl);
        bounds.setBottom(bounds.getBottom() - fM3013getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(bounds, true);
            if (this.isClipping && clipBounds) {
                bounds.intersect(0.0f, 0.0f, IntSize.m3054getWidthimpl(mo1831getSizeYbymL2g()), IntSize.m3053getHeightimpl(mo1831getSizeYbymL2g()));
                bounds.isEmpty();
            }
        }
    }

    /* JADX INFO: renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m2028withinLayerBoundsk4lQ0M(long pointerPosition) {
        if (!OffsetKt.m306isFinitek4lQ0M(pointerPosition)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer == null || !this.isClipping || ownedLayer.mo2082isInLayerk4lQ0M(pointerPosition);
    }

    /* JADX INFO: renamed from: isPointerInBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m2022isPointerInBoundsk4lQ0M(long pointerPosition) {
        float fM289getXimpl = Offset.m289getXimpl(pointerPosition);
        float fM290getYimpl = Offset.m290getYimpl(pointerPosition);
        return fM289getXimpl >= 0.0f && fM290getYimpl >= 0.0f && fM289getXimpl < ((float) getMeasuredWidth()) && fM290getYimpl < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator other) {
        LayoutNode layoutNode = other.getLayoutNode();
        LayoutNode layoutNode2 = getLayoutNode();
        if (layoutNode == layoutNode2) {
            Modifier.Node tail = other.getTail();
            Modifier.Node tail2 = getTail();
            int iM2034constructorimpl = NodeKind.m2034constructorimpl(2);
            if (!tail2.getNode().getIsAttached()) {
                throw new IllegalStateException("visitLocalAncestors called on an unattached node".toString());
            }
            for (Modifier.Node parent = tail2.getNode().getParent(); parent != null; parent = parent.getParent()) {
                if ((parent.getKindSet() & iM2034constructorimpl) != 0 && parent == tail) {
                    return other;
                }
            }
            return this;
        }
        while (layoutNode.getDepth() > layoutNode2.getDepth()) {
            layoutNode = layoutNode.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode);
        }
        while (layoutNode2.getDepth() > layoutNode.getDepth()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode != layoutNode2) {
            layoutNode = layoutNode.getParent$ui_release();
            layoutNode2 = layoutNode2.getParent$ui_release();
            if (layoutNode == null || layoutNode2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        if (layoutNode2 != getLayoutNode()) {
            if (layoutNode != other.getLayoutNode()) {
                return layoutNode.getInnerCoordinator$ui_release();
            }
            return other;
        }
        return this;
    }

    /* JADX INFO: renamed from: offsetFromEdge-MK-Hz9U, reason: not valid java name */
    private final long m2010offsetFromEdgeMKHz9U(long pointerPosition) {
        float fM289getXimpl = Offset.m289getXimpl(pointerPosition);
        float fMax = Math.max(0.0f, fM289getXimpl < 0.0f ? -fM289getXimpl : fM289getXimpl - getMeasuredWidth());
        float fM290getYimpl = Offset.m290getYimpl(pointerPosition);
        return OffsetKt.Offset(fMax, Math.max(0.0f, fM290getYimpl < 0.0f ? -fM290getYimpl : fM290getYimpl - getMeasuredHeight()));
    }

    /* JADX INFO: renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    protected final long m2015calculateMinimumTouchTargetPaddingE7KxVPU(long minimumTouchTargetSize) {
        return SizeKt.Size(Math.max(0.0f, (Size.m358getWidthimpl(minimumTouchTargetSize) - getMeasuredWidth()) / 2.0f), Math.max(0.0f, (Size.m355getHeightimpl(minimumTouchTargetSize) - getMeasuredHeight()) / 2.0f));
    }

    /* JADX INFO: renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    protected final float m2016distanceInMinimumTouchTargettz77jQw(long pointerPosition, long minimumTouchTargetSize) {
        if (getMeasuredWidth() >= Size.m358getWidthimpl(minimumTouchTargetSize) && getMeasuredHeight() >= Size.m355getHeightimpl(minimumTouchTargetSize)) {
            return Float.POSITIVE_INFINITY;
        }
        long jM2015calculateMinimumTouchTargetPaddingE7KxVPU = m2015calculateMinimumTouchTargetPaddingE7KxVPU(minimumTouchTargetSize);
        float fM358getWidthimpl = Size.m358getWidthimpl(jM2015calculateMinimumTouchTargetPaddingE7KxVPU);
        float fM355getHeightimpl = Size.m355getHeightimpl(jM2015calculateMinimumTouchTargetPaddingE7KxVPU);
        long jM2010offsetFromEdgeMKHz9U = m2010offsetFromEdgeMKHz9U(pointerPosition);
        if ((fM358getWidthimpl > 0.0f || fM355getHeightimpl > 0.0f) && Offset.m289getXimpl(jM2010offsetFromEdgeMKHz9U) <= fM358getWidthimpl && Offset.m290getYimpl(jM2010offsetFromEdgeMKHz9U) <= fM355getHeightimpl) {
            return Offset.m288getDistanceSquaredimpl(jM2010offsetFromEdgeMKHz9U);
        }
        return Float.POSITIVE_INFINITY;
    }

    /* JADX INFO: compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6 */
    public final void onMeasured() {
        Modifier.Node parent;
        if (m2007hasNodeH91voCI(NodeKind.m2034constructorimpl(128))) {
            Snapshot snapshotCreateNonObservableSnapshot = Snapshot.INSTANCE.createNonObservableSnapshot();
            try {
                Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                try {
                    int iM2034constructorimpl = NodeKind.m2034constructorimpl(128);
                    boolean zM2043getIncludeSelfInTraversalH91voCI = NodeKindKt.m2043getIncludeSelfInTraversalH91voCI(iM2034constructorimpl);
                    if (!zM2043getIncludeSelfInTraversalH91voCI) {
                        parent = getTail().getParent();
                        if (parent == null) {
                        }
                        Unit unit = Unit.INSTANCE;
                        snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                        snapshotCreateNonObservableSnapshot.dispose();
                    }
                    parent = getTail();
                    for (Modifier.Node nodeHeadNode = headNode(zM2043getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM2034constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
                        if ((nodeHeadNode.getKindSet() & iM2034constructorimpl) != 0) {
                            Modifier.Node nodePop = nodeHeadNode;
                            MutableVector mutableVector = null;
                            while (nodePop != 0) {
                                if (nodePop instanceof LayoutAwareModifierNode) {
                                    ((LayoutAwareModifierNode) nodePop).mo1916onRemeasuredozmzZPI(getMeasuredSize());
                                } else if ((nodePop.getKindSet() & iM2034constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate();
                                    int i = 0;
                                    nodePop = nodePop;
                                    while (delegate$ui_release != null) {
                                        if ((delegate$ui_release.getKindSet() & iM2034constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != 0) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(nodePop);
                                                    }
                                                    nodePop = 0;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                        delegate$ui_release = delegate$ui_release.getChild();
                                        nodePop = nodePop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        if (nodeHeadNode == parent) {
                            break;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    snapshotCreateNonObservableSnapshot.dispose();
                } catch (Throwable th) {
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            } catch (Throwable th2) {
                snapshotCreateNonObservableSnapshot.dispose();
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        Modifier.Node nodeM2020headH91voCI = m2020headH91voCI(NodeKind.m2034constructorimpl(4));
        if (nodeM2020headH91voCI == null) {
            performDraw(canvas);
        } else {
            getLayoutNode().getMDrawScope$ui_release().m1967drawx_KDEd0$ui_release(canvas, IntSizeKt.m3064toSizeozmzZPI(mo1831getSizeYbymL2g()), this, nodeM2020headH91voCI);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    public final void onPlaced() {
        int iM2034constructorimpl = NodeKind.m2034constructorimpl(128);
        boolean zM2043getIncludeSelfInTraversalH91voCI = NodeKindKt.m2043getIncludeSelfInTraversalH91voCI(iM2034constructorimpl);
        Modifier.Node tail = getTail();
        if (!zM2043getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM2043getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM2034constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & iM2034constructorimpl) != 0) {
                Modifier.Node nodePop = nodeHeadNode;
                MutableVector mutableVector = null;
                while (nodePop != 0) {
                    if (nodePop instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) nodePop).onPlaced(this);
                    } else if ((nodePop.getKindSet() & iM2034constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate();
                        int i = 0;
                        nodePop = nodePop;
                        while (delegate$ui_release != null) {
                            if ((delegate$ui_release.getKindSet() & iM2034constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    nodePop = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (nodePop != 0) {
                                        if (mutableVector != null) {
                                            mutableVector.add(nodePop);
                                        }
                                        nodePop = 0;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                            }
                            delegate$ui_release = delegate$ui_release.getChild();
                            nodePop = nodePop;
                        }
                        if (i == 1) {
                        }
                    }
                    nodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.getSVar()" because "result" is null
        	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:118)
        	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:85)
        */
    public final boolean shouldSharePointerInputWithSiblings() {
        /*
            r11 = this;
            r0 = 16
            int r1 = androidx.compose.ui.node.NodeKind.m2034constructorimpl(r0)
            boolean r1 = androidx.compose.ui.node.NodeKindKt.m2043getIncludeSelfInTraversalH91voCI(r1)
            androidx.compose.ui.Modifier$Node r1 = r11.headNode(r1)
            r2 = 0
            if (r1 != 0) goto L12
            return r2
        L12:
            boolean r3 = r1.getIsAttached()
            if (r3 == 0) goto La9
            androidx.compose.ui.node.DelegatableNode r1 = (androidx.compose.ui.node.DelegatableNode) r1
            int r3 = androidx.compose.ui.node.NodeKind.m2034constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r4 = r1.getNode()
            boolean r4 = r4.getIsAttached()
            if (r4 == 0) goto L9d
            androidx.compose.ui.Modifier$Node r1 = r1.getNode()
            int r4 = r1.getAggregateChildKindSet()
            r4 = r4 & r3
            if (r4 == 0) goto La9
            androidx.compose.ui.Modifier$Node r1 = r1.getChild()
        L37:
            if (r1 == 0) goto La9
            int r4 = r1.getKindSet()
            r4 = r4 & r3
            if (r4 == 0) goto L98
            r4 = 0
            r5 = r1
            r6 = r4
        L43:
            if (r5 == 0) goto L98
            boolean r7 = r5 instanceof androidx.compose.ui.node.PointerInputModifierNode
            r8 = 1
            if (r7 == 0) goto L53
            androidx.compose.ui.node.PointerInputModifierNode r5 = (androidx.compose.ui.node.PointerInputModifierNode) r5
            boolean r5 = r5.sharePointerInputWithSiblings()
            if (r5 == 0) goto L93
            return r8
        L53:
            int r7 = r5.getKindSet()
            r7 = r7 & r3
            if (r7 == 0) goto L93
            boolean r7 = r5 instanceof androidx.compose.ui.node.DelegatingNode
            if (r7 == 0) goto L93
            r7 = r5
            androidx.compose.ui.node.DelegatingNode r7 = (androidx.compose.ui.node.DelegatingNode) r7
            androidx.compose.ui.Modifier$Node r7 = r7.getDelegate()
            r9 = r2
        L66:
            if (r7 == 0) goto L90
            int r10 = r7.getKindSet()
            r10 = r10 & r3
            if (r10 == 0) goto L8b
            int r9 = r9 + 1
            if (r9 != r8) goto L75
            r5 = r7
            goto L8b
        L75:
            if (r6 != 0) goto L7e
            androidx.compose.runtime.collection.MutableVector r6 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r0]
            r6.<init>(r10, r2)
        L7e:
            if (r5 == 0) goto L86
            if (r6 == 0) goto L85
            r6.add(r5)
        L85:
            r5 = r4
        L86:
            if (r6 == 0) goto L8b
            r6.add(r7)
        L8b:
            androidx.compose.ui.Modifier$Node r7 = r7.getChild()
            goto L66
        L90:
            if (r9 != r8) goto L93
            goto L43
        L93:
            androidx.compose.ui.Modifier$Node r5 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r6)
            goto L43
        L98:
            androidx.compose.ui.Modifier$Node r1 = r1.getChild()
            goto L37
        L9d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "visitLocalDescendants called on an unattached node"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator.shouldSharePointerInputWithSiblings():boolean");
    }
}
