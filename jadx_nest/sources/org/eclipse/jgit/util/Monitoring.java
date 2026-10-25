package org.eclipse.jgit.util;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.lib.ConfigConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class Monitoring {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) Monitoring.class);

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.MalformedObjectNameException */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Nullable
    public static ObjectInstance registerMBean(Object obj, String str) {
        try {
            boolean z = false;
            for (Class<?> cls : obj.getClass().getInterfaces()) {
                z = SystemReader.getInstance().getUserConfig().getBoolean(ConfigConstants.CONFIG_JMX_SECTION, cls.getSimpleName(), false);
                if (z) {
                    break;
                }
            }
            if (!z) {
                return null;
            }
            MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
            try {
                ObjectName objectName = objectName(obj.getClass(), str);
                if (platformMBeanServer.isRegistered(objectName)) {
                    platformMBeanServer.unregisterMBean(objectName);
                }
                return platformMBeanServer.registerMBean(obj, objectName);
            } catch (NotCompliantMBeanException | MBeanRegistrationException | InstanceAlreadyExistsException | InstanceNotFoundException | MalformedObjectNameException e) {
                LOG.error(e.getMessage(), e);
                return null;
            }
        } catch (IOException | ConfigInvalidException e2) {
            LOG.error(e2.getMessage(), (Throwable) e2);
            return null;
        }
    }

    private static ObjectName objectName(Class cls, String str) throws MalformedObjectNameException {
        return new ObjectName(String.format("org.eclipse.jgit/%s:type=%s", str, cls.getSimpleName()));
    }
}
