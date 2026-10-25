package org.apache.commons.io.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.Objects;
import org.apache.commons.io.build.AbstractSupplier;
import org.apache.commons.io.function.IOBiFunction;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SimplePathVisitor extends SimpleFileVisitor<Path> implements PathVisitor {
    private final IOBiFunction<Path, IOException, FileVisitResult> visitFileFailedFunction;

    protected static abstract class AbstractBuilder<T, B extends AbstractSupplier<T, B>> extends AbstractSupplier<T, B> {
        private IOBiFunction<Path, IOException, FileVisitResult> visitFileFailedFunction;

        IOBiFunction<Path, IOException, FileVisitResult> getVisitFileFailedFunction() {
            return this.visitFileFailedFunction;
        }

        public B setVisitFileFailedFunction(IOBiFunction<Path, IOException, FileVisitResult> iOBiFunction) {
            this.visitFileFailedFunction = iOBiFunction;
            return asThis();
        }
    }

    protected SimplePathVisitor() {
        this.visitFileFailedFunction = new SimplePathVisitor$$ExternalSyntheticLambda0(this);
    }

    /* JADX INFO: renamed from: lambda$new$0$org-apache-commons-io-file-SimplePathVisitor, reason: not valid java name */
    /* synthetic */ FileVisitResult m5572lambda$new$0$orgapachecommonsiofileSimplePathVisitor(Object obj, IOException iOException) throws IOException {
        return super.visitFileFailed(obj, iOException);
    }

    SimplePathVisitor(AbstractBuilder<?, ?> abstractBuilder) {
        this.visitFileFailedFunction = ((AbstractBuilder) abstractBuilder).visitFileFailedFunction != null ? ((AbstractBuilder) abstractBuilder).visitFileFailedFunction : new SimplePathVisitor$$ExternalSyntheticLambda1(this);
    }

    /* JADX INFO: renamed from: lambda$new$1$org-apache-commons-io-file-SimplePathVisitor, reason: not valid java name */
    /* synthetic */ FileVisitResult m5573lambda$new$1$orgapachecommonsiofileSimplePathVisitor(Object obj, IOException iOException) throws IOException {
        return super.visitFileFailed(obj, iOException);
    }

    protected SimplePathVisitor(IOBiFunction<Path, IOException, FileVisitResult> iOBiFunction) {
        this.visitFileFailedFunction = (IOBiFunction) Objects.requireNonNull(iOBiFunction, "visitFileFailedFunction");
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult visitFileFailed(Path path, IOException iOException) throws IOException {
        return this.visitFileFailedFunction.apply(path, iOException);
    }
}
