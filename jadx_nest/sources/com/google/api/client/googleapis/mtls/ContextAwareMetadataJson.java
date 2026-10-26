package com.google.api.client.googleapis.mtls;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* INFO: loaded from: classes3.dex */
public class ContextAwareMetadataJson extends GenericJson {

    @Key("cert_provider_command")
    private List<String> commands;

    public final List<String> getCommands() {
        return this.commands;
    }
}
