package org.eclipse.jgit.transport;

import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.lib.Config;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteConfig implements Serializable {
    private static final boolean DEFAULT_MIRROR = false;
    public static final String DEFAULT_RECEIVE_PACK = "git-receive-pack";
    public static final String DEFAULT_UPLOAD_PACK = "git-upload-pack";
    private static final String KEY_FETCH = "fetch";
    private static final String KEY_MIRROR = "mirror";
    private static final String KEY_PUSH = "push";
    private static final String KEY_PUSHURL = "pushurl";
    private static final String KEY_RECEIVEPACK = "receivepack";
    private static final String KEY_TAGOPT = "tagopt";
    private static final String KEY_TIMEOUT = "timeout";
    private static final String KEY_UPLOADPACK = "uploadpack";
    private static final String KEY_URL = "url";
    private static final String SECTION = "remote";
    private static final long serialVersionUID = 1;
    private List<RefSpec> fetch;
    private boolean mirror;
    private String name;
    private List<RefSpec> push;
    private List<URIish> pushURIs;
    private String receivepack;
    private TagOpt tagopt;
    private int timeout;
    private String uploadpack;
    private List<URIish> uris;

    public static List<RemoteConfig> getAllRemoteConfigs(Config config) throws URISyntaxException {
        ArrayList arrayList = new ArrayList(config.getSubsections("remote"));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new RemoteConfig(config, (String) it.next()));
        }
        return arrayList2;
    }

    public RemoteConfig(Config config, String str) throws URISyntaxException {
        this.name = str;
        String[] stringList = config.getStringList("remote", str, "url");
        UrlConfig urlConfig = new UrlConfig(config);
        this.uris = new ArrayList(stringList.length);
        for (String str2 : stringList) {
            this.uris.add(new URIish(urlConfig.replace(str2)));
        }
        String[] stringList2 = config.getStringList("remote", this.name, KEY_PUSHURL);
        this.pushURIs = new ArrayList(stringList2.length);
        for (String str3 : stringList2) {
            this.pushURIs.add(new URIish(str3));
        }
        if (this.pushURIs.isEmpty() && urlConfig.hasPushReplacements()) {
            for (String str4 : stringList) {
                String strReplacePush = urlConfig.replacePush(str4);
                if (!str4.equals(strReplacePush)) {
                    this.pushURIs.add(new URIish(strReplacePush));
                }
            }
        }
        this.fetch = config.getRefSpecs("remote", this.name, "fetch");
        this.push = config.getRefSpecs("remote", this.name, "push");
        String string = config.getString("remote", this.name, KEY_UPLOADPACK);
        this.uploadpack = string == null ? DEFAULT_UPLOAD_PACK : string;
        String string2 = config.getString("remote", this.name, KEY_RECEIVEPACK);
        this.receivepack = string2 == null ? DEFAULT_RECEIVE_PACK : string2;
        try {
            this.tagopt = TagOpt.fromOption(config.getString("remote", this.name, KEY_TAGOPT));
        } catch (IllegalArgumentException unused) {
            this.tagopt = TagOpt.AUTO_FOLLOW;
        }
        this.mirror = config.getBoolean("remote", this.name, KEY_MIRROR, false);
        this.timeout = config.getInt("remote", this.name, KEY_TIMEOUT, 0);
    }

    public void update(Config config) {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        Iterator<URIish> it = getURIs().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toPrivateString());
        }
        config.setStringList("remote", getName(), "url", arrayList);
        arrayList.clear();
        Iterator<URIish> it2 = getPushURIs().iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().toPrivateString());
        }
        config.setStringList("remote", getName(), KEY_PUSHURL, arrayList);
        arrayList.clear();
        Iterator<RefSpec> it3 = getFetchRefSpecs().iterator();
        while (it3.hasNext()) {
            arrayList.add(it3.next().toString());
        }
        config.setStringList("remote", getName(), "fetch", arrayList);
        arrayList.clear();
        Iterator<RefSpec> it4 = getPushRefSpecs().iterator();
        while (it4.hasNext()) {
            arrayList.add(it4.next().toString());
        }
        config.setStringList("remote", getName(), "push", arrayList);
        set(config, KEY_UPLOADPACK, getUploadPack(), DEFAULT_UPLOAD_PACK);
        set(config, KEY_RECEIVEPACK, getReceivePack(), DEFAULT_RECEIVE_PACK);
        set(config, KEY_TAGOPT, getTagOpt().option(), TagOpt.AUTO_FOLLOW.option());
        set(config, KEY_MIRROR, this.mirror, false);
        set(config, KEY_TIMEOUT, this.timeout, 0);
    }

    private void set(Config config, String str, String str2, String str3) {
        if (str3.equals(str2)) {
            unset(config, str);
        } else {
            config.setString("remote", getName(), str, str2);
        }
    }

    private void set(Config config, String str, boolean z, boolean z2) {
        if (z2 == z) {
            unset(config, str);
        } else {
            config.setBoolean("remote", getName(), str, z);
        }
    }

    private void set(Config config, String str, int i, int i2) {
        if (i2 == i) {
            unset(config, str);
        } else {
            config.setInt("remote", getName(), str, i);
        }
    }

    private void unset(Config config, String str) {
        config.unset("remote", getName(), str);
    }

    public String getName() {
        return this.name;
    }

    public List<URIish> getURIs() {
        return Collections.unmodifiableList(this.uris);
    }

    public boolean addURI(URIish uRIish) {
        if (this.uris.contains(uRIish)) {
            return false;
        }
        return this.uris.add(uRIish);
    }

    public boolean removeURI(URIish uRIish) {
        return this.uris.remove(uRIish);
    }

    public List<URIish> getPushURIs() {
        return Collections.unmodifiableList(this.pushURIs);
    }

    public boolean addPushURI(URIish uRIish) {
        if (this.pushURIs.contains(uRIish)) {
            return false;
        }
        return this.pushURIs.add(uRIish);
    }

    public boolean removePushURI(URIish uRIish) {
        return this.pushURIs.remove(uRIish);
    }

    public List<RefSpec> getFetchRefSpecs() {
        return Collections.unmodifiableList(this.fetch);
    }

    public boolean addFetchRefSpec(RefSpec refSpec) {
        if (this.fetch.contains(refSpec)) {
            return false;
        }
        return this.fetch.add(refSpec);
    }

    public void setFetchRefSpecs(List<RefSpec> list) {
        this.fetch.clear();
        this.fetch.addAll(list);
    }

    public void setPushRefSpecs(List<RefSpec> list) {
        this.push.clear();
        this.push.addAll(list);
    }

    public boolean removeFetchRefSpec(RefSpec refSpec) {
        return this.fetch.remove(refSpec);
    }

    public List<RefSpec> getPushRefSpecs() {
        return Collections.unmodifiableList(this.push);
    }

    public boolean addPushRefSpec(RefSpec refSpec) {
        if (this.push.contains(refSpec)) {
            return false;
        }
        return this.push.add(refSpec);
    }

    public boolean removePushRefSpec(RefSpec refSpec) {
        return this.push.remove(refSpec);
    }

    public String getUploadPack() {
        return this.uploadpack;
    }

    public String getReceivePack() {
        return this.receivepack;
    }

    public TagOpt getTagOpt() {
        return this.tagopt;
    }

    public void setTagOpt(TagOpt tagOpt) {
        if (tagOpt == null) {
            tagOpt = TagOpt.AUTO_FOLLOW;
        }
        this.tagopt = tagOpt;
    }

    public boolean isMirror() {
        return this.mirror;
    }

    public void setMirror(boolean z) {
        this.mirror = z;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }
}
