.class Landroid/support/v4/widget/EdgeEffectCompatLollipop;
.super Ljava/lang/Object;
.source "EdgeEffectCompatLollipop.java"


# direct methods
.method public static onPull(Ljava/lang/Object;FF)Z
    .registers 4
    .param p0, "edgeEffect"    # Ljava/lang/Object;
    .param p1, "deltaDistance"    # F
    .param p2, "displacement"    # F

    .prologue
    .line 24
    check-cast p0, Landroid/widget/EdgeEffect;

    .end local p0    # "edgeEffect":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Landroid/widget/EdgeEffect;->onPull(FF)V

    .line 25
    const/4 v0, 0x1

    return v0
.end method
