package com.google.protobuf.gradle;

import javax.inject.Inject;
import org.gradle.api.Action;
import org.gradle.api.Project;
import org.gradle.api.file.CopySpec;
import org.gradle.api.file.DeleteSpec;
import org.gradle.api.file.FileSystemOperations;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.tasks.WorkResult;
import org.gradle.util.GradleVersion;

/* JADX INFO: loaded from: classes4.dex */
interface CopyActionFacade {
    WorkResult copy(Action<? super CopySpec> action);

    WorkResult delete(Action<? super DeleteSpec> action);

    public static final class Loader {
        public static CopyActionFacade create(Project project, ObjectFactory objectFactory) {
            if (GradleVersion.current().compareTo(GradleVersion.version("6.0")) >= 0) {
                return (CopyActionFacade) objectFactory.newInstance(FileSystemOperationsBased.class, new Object[0]);
            }
            return new ProjectBased(project);
        }
    }

    public static class ProjectBased implements CopyActionFacade {
        private final Project project;

        public ProjectBased(Project project) {
            this.project = project;
        }

        @Override // com.google.protobuf.gradle.CopyActionFacade
        public WorkResult copy(Action<? super CopySpec> action) {
            return this.project.copy(action);
        }

        @Override // com.google.protobuf.gradle.CopyActionFacade
        public WorkResult delete(Action<? super DeleteSpec> action) {
            return this.project.delete(action);
        }
    }

    public static abstract class FileSystemOperationsBased implements CopyActionFacade {
        @Inject
        public abstract FileSystemOperations getFileSystemOperations();

        @Override // com.google.protobuf.gradle.CopyActionFacade
        public WorkResult copy(Action<? super CopySpec> action) {
            return getFileSystemOperations().copy(action);
        }

        @Override // com.google.protobuf.gradle.CopyActionFacade
        public WorkResult delete(Action<? super DeleteSpec> action) {
            return getFileSystemOperations().delete(action);
        }
    }
}
