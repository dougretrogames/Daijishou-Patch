package com.google.protobuf.gradle;

import javax.inject.Inject;
import org.gradle.api.Project;
import org.gradle.api.file.FileTree;
import org.gradle.api.internal.file.FileOperations;

/* INFO: loaded from: classes4.dex */
public interface ArchiveActionFacade {
    FileTree tarTree(Object obj);

    FileTree zipTree(Object obj);

    public static class ProjectBased implements ArchiveActionFacade {
        private final Project project;

        ProjectBased(Project project) {
            this.project = project;
        }

        @Override // com.google.protobuf.gradle.ArchiveActionFacade
        public FileTree zipTree(Object obj) {
            return this.project.zipTree(obj);
        }

        @Override // com.google.protobuf.gradle.ArchiveActionFacade
        public FileTree tarTree(Object obj) {
            return this.project.tarTree(obj);
        }
    }

    public static abstract class ServiceBased implements ArchiveActionFacade {
        @Inject
        public abstract FileOperations getFileOperations();

        @Override // com.google.protobuf.gradle.ArchiveActionFacade
        public FileTree zipTree(Object obj) {
            return getFileOperations().zipTree(obj);
        }

        @Override // com.google.protobuf.gradle.ArchiveActionFacade
        public FileTree tarTree(Object obj) {
            return getFileOperations().tarTree(obj);
        }
    }
}
