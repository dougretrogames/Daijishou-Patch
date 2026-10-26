package org.eclipse.jgit.revwalk;

/* INFO: loaded from: classes5.dex */
class EndGenerator extends Generator {
    static final EndGenerator INSTANCE = new EndGenerator();

    @Override // org.eclipse.jgit.revwalk.Generator
    RevCommit next() {
        return null;
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    int outputType() {
        return 0;
    }

    private EndGenerator() {
        super(false);
    }
}
