package com.google.gradle.osdetector;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/* INFO: loaded from: classes4.dex */
public class OsDetectorPlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.getExtensions().create("osdetector", OsDetector.class, new Object[]{project});
    }
}
