package androidx.compose.ui.graphics;

import android.graphics.Shader;
import kotlin.Metadata;

/* JADX INFO: compiled from: Brush.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"ShaderBrush", "Landroidx/compose/ui/graphics/ShaderBrush;", "shader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BrushKt {

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.BrushKt$ShaderBrush$1, reason: invalid class name */
    /* JADX INFO: compiled from: Brush.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, d2 = {"androidx/compose/ui/graphics/BrushKt$ShaderBrush$1", "Landroidx/compose/ui/graphics/ShaderBrush;", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends ShaderBrush {
        final /* synthetic */ Shader $shader;

        AnonymousClass1(Shader shader) {
            this.$shader = shader;
        }

        @Override // androidx.compose.ui.graphics.ShaderBrush
        /* JADX INFO: renamed from: createShader-uvyYCjk, reason: not valid java name */
        public Shader mo499createShaderuvyYCjk(long size) {
            return this.$shader;
        }
    }

    public static final ShaderBrush ShaderBrush(Shader shader) {
        return new AnonymousClass1(shader);
    }
}
