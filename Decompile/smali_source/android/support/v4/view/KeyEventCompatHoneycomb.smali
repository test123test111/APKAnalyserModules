.class Landroid/support/v4/view/KeyEventCompatHoneycomb;
.super Ljava/lang/Object;
.source "KeyEventCompatHoneycomb.java"


# direct methods
.method public static metaStateHasModifiers(II)Z
    .registers 3
    .param p0, "metaState"    # I
    .param p1, "modifiers"    # I

    .prologue
    .line 30
    invoke-static {p0, p1}, Landroid/view/KeyEvent;->metaStateHasModifiers(II)Z

    move-result v0

    return v0
.end method

.method public static metaStateHasNoModifiers(I)Z
    .registers 2
    .param p0, "metaState"    # I

    .prologue
    .line 34
    invoke-static {p0}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v0

    return v0
.end method

.method public static normalizeMetaState(I)I
    .registers 2
    .param p0, "metaState"    # I

    .prologue
    .line 26
    invoke-static {p0}, Landroid/view/KeyEvent;->normalizeMetaState(I)I

    move-result v0

    return v0
.end method
