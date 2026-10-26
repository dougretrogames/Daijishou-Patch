package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableMultimap;

/* INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
interface ServiceManagerBridge {
    ImmutableMultimap<Service.State, Service> servicesByState();
}
