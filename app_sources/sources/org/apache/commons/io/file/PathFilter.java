package org.apache.commons.io.file;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface PathFilter {
    FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes);
}
