.class public final Lcom/facebook/model/OpenGraphObject$Factory;
.super Ljava/lang/Object;
.source "OpenGraphObject.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/model/OpenGraphObject;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Factory"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 259
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createForPost(Ljava/lang/Class;Ljava/lang/String;)Lcom/facebook/model/OpenGraphObject;
    .registers 8
    .param p1, "type"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lcom/facebook/model/OpenGraphObject;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .local p0, "graphObjectClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const/4 v2, 0x0

    .line 278
    move-object v0, p0

    move-object v1, p1

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    invoke-static/range {v0 .. v5}, Lcom/facebook/model/OpenGraphObject$Factory;->createForPost(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/model/OpenGraphObject;

    move-result-object v0

    return-object v0
.end method

.method public static createForPost(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/model/OpenGraphObject;
    .registers 10
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "imageUrl"    # Ljava/lang/String;
    .param p4, "url"    # Ljava/lang/String;
    .param p5, "description"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lcom/facebook/model/OpenGraphObject;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .local p0, "graphObjectClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const/4 v3, 0x1

    .line 294
    invoke-static {p0}, Lcom/facebook/model/GraphObject$Factory;->create(Ljava/lang/Class;)Lcom/facebook/model/GraphObject;

    move-result-object v0

    check-cast v0, Lcom/facebook/model/OpenGraphObject;

    .line 296
    .local v0, "object":Lcom/facebook/model/OpenGraphObject;, "TT;"
    if-eqz p1, :cond_c

    .line 297
    invoke-interface {v0, p1}, Lcom/facebook/model/OpenGraphObject;->setType(Ljava/lang/String;)V

    .line 299
    :cond_c
    if-eqz p2, :cond_11

    .line 300
    invoke-interface {v0, p2}, Lcom/facebook/model/OpenGraphObject;->setTitle(Ljava/lang/String;)V

    .line 302
    :cond_11
    if-eqz p3, :cond_1f

    .line 303
    new-array v1, v3, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/facebook/model/OpenGraphObject;->setImageUrls(Ljava/util/List;)V

    .line 305
    :cond_1f
    if-eqz p4, :cond_24

    .line 306
    invoke-interface {v0, p4}, Lcom/facebook/model/OpenGraphObject;->setUrl(Ljava/lang/String;)V

    .line 308
    :cond_24
    if-eqz p5, :cond_29

    .line 309
    invoke-interface {v0, p5}, Lcom/facebook/model/OpenGraphObject;->setDescription(Ljava/lang/String;)V

    .line 312
    :cond_29
    invoke-interface {v0, v3}, Lcom/facebook/model/OpenGraphObject;->setCreateObject(Z)V

    .line 313
    invoke-static {}, Lcom/facebook/model/GraphObject$Factory;->create()Lcom/facebook/model/GraphObject;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/facebook/model/OpenGraphObject;->setData(Lcom/facebook/model/GraphObject;)V

    .line 315
    return-object v0
.end method

.method public static createForPost(Ljava/lang/String;)Lcom/facebook/model/OpenGraphObject;
    .registers 2
    .param p0, "type"    # Ljava/lang/String;

    .prologue
    .line 267
    const-class v0, Lcom/facebook/model/OpenGraphObject;

    invoke-static {v0, p0}, Lcom/facebook/model/OpenGraphObject$Factory;->createForPost(Ljava/lang/Class;Ljava/lang/String;)Lcom/facebook/model/OpenGraphObject;

    move-result-object v0

    return-object v0
.end method
