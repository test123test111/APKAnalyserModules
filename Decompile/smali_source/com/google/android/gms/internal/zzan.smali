.class public Lcom/google/android/gms/internal/zzan;
.super Ljava/lang/Object;


# instance fields
.field private zznA:Ljava/lang/String;

.field private zznB:[Ljava/lang/String;

.field private zznC:Lcom/google/android/gms/internal/zzaj;

.field private zzny:Ljava/lang/String;

.field private zznz:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzaj;)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "googleads.g.doubleclick.net"

    iput-object v0, p0, Lcom/google/android/gms/internal/zzan;->zzny:Ljava/lang/String;

    const-string v0, "/pagead/ads"

    iput-object v0, p0, Lcom/google/android/gms/internal/zzan;->zznz:Ljava/lang/String;

    const-string v0, "ad.doubleclick.net"

    iput-object v0, p0, Lcom/google/android/gms/internal/zzan;->zznA:Ljava/lang/String;

    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, ".doubleclick.net"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, ".googleadservices.com"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, ".googlesyndication.com"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/google/android/gms/internal/zzan;->zznB:[Ljava/lang/String;

    iput-object p1, p0, Lcom/google/android/gms/internal/zzan;->zznC:Lcom/google/android/gms/internal/zzaj;

    return-void
.end method

.method private zza(Landroid/net/Uri;Landroid/content/Context;Ljava/lang/String;Z)Landroid/net/Uri;
    .registers 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/android/gms/internal/zzao;
        }
    .end annotation

    :try_start_0
    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzan;->zza(Landroid/net/Uri;)Z

    move-result v1

    if-eqz v1, :cond_23

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v2, "dc_ms="

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_33

    new-instance v0, Lcom/google/android/gms/internal/zzao;

    const-string v1, "Parameter already exists: dc_ms"

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzao;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1a
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_1a} :catch_1a

    :catch_1a
    move-exception v0

    new-instance v0, Lcom/google/android/gms/internal/zzao;

    const-string v1, "Provided Uri is not in a valid state"

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzao;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_23
    :try_start_23
    const-string v0, "ms"

    invoke-virtual {p1, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_33

    new-instance v0, Lcom/google/android/gms/internal/zzao;

    const-string v1, "Query parameter already exists: ms"

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzao;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_33
    if-eqz p4, :cond_44

    iget-object v0, p0, Lcom/google/android/gms/internal/zzan;->zznC:Lcom/google/android/gms/internal/zzaj;

    invoke-interface {v0, p2, p3}, Lcom/google/android/gms/internal/zzaj;->zzb(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_3b
    if-eqz v1, :cond_4b

    const-string v1, "dc_ms"

    invoke-direct {p0, p1, v1, v0}, Lcom/google/android/gms/internal/zzan;->zzb(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    :goto_43
    return-object v0

    :cond_44
    iget-object v0, p0, Lcom/google/android/gms/internal/zzan;->zznC:Lcom/google/android/gms/internal/zzaj;

    invoke-interface {v0, p2}, Lcom/google/android/gms/internal/zzaj;->zzb(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    goto :goto_3b

    :cond_4b
    const-string v1, "ms"

    invoke-direct {p0, p1, v1, v0}, Lcom/google/android/gms/internal/zzan;->zza(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    :try_end_50
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_23 .. :try_end_50} :catch_1a

    move-result-object v0

    goto :goto_43
.end method

.method private zza(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    .registers 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation

    const/4 v2, -0x1

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v0, "&adurl"

    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    if-ne v0, v2, :cond_13

    const-string v0, "?adurl"

    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    :cond_13
    if-eq v0, v2, :cond_48

    new-instance v2, Ljava/lang/StringBuilder;

    const/4 v3, 0x0

    add-int/lit8 v4, v0, 0x1

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "&"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    add-int/lit8 v0, v0, 0x1

    invoke-virtual {v1, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    :goto_47
    return-object v0

    :cond_48
    invoke-virtual {p1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0, p2, p3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    goto :goto_47
.end method

.method private zzb(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    .registers 10

    const/4 v5, 0x0

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, ";adurl"

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_40

    new-instance v2, Ljava/lang/StringBuilder;

    add-int/lit8 v3, v1, 0x1

    invoke-virtual {v0, v5, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    :goto_3f
    return-object v0

    :cond_40
    invoke-virtual {p1}, Landroid/net/Uri;->getEncodedPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    add-int/2addr v4, v2

    invoke-virtual {v0, v5, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, ";"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ";"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_3f
.end method


# virtual methods
.method public zza(Landroid/net/Uri;Landroid/content/Context;)Landroid/net/Uri;
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/android/gms/internal/zzao;
        }
    .end annotation

    :try_start_0
    const-string v0, "ai"

    invoke-virtual {p1, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/google/android/gms/internal/zzan;->zza(Landroid/net/Uri;Landroid/content/Context;Ljava/lang/String;Z)Landroid/net/Uri;
    :try_end_a
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_a} :catch_c

    move-result-object v0

    return-object v0

    :catch_c
    move-exception v0

    new-instance v0, Lcom/google/android/gms/internal/zzao;

    const-string v1, "Provided Uri is not in a valid state"

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/zzao;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public zza(Landroid/view/MotionEvent;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/zzan;->zznC:Lcom/google/android/gms/internal/zzaj;

    invoke-interface {v0, p1}, Lcom/google/android/gms/internal/zzaj;->zza(Landroid/view/MotionEvent;)V

    return-void
.end method

.method public zza(Landroid/net/Uri;)Z
    .registers 4

    if-nez p1, :cond_8

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_8
    :try_start_8
    invoke-virtual {p1}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/zzan;->zznA:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_11
    .catch Ljava/lang/NullPointerException; {:try_start_8 .. :try_end_11} :catch_13

    move-result v0

    :goto_12
    return v0

    :catch_13
    move-exception v0

    const/4 v0, 0x0

    goto :goto_12
.end method

.method public zzab()Lcom/google/android/gms/internal/zzaj;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/internal/zzan;->zznC:Lcom/google/android/gms/internal/zzaj;

    return-object v0
.end method

.method public zzb(Landroid/net/Uri;)Z
    .registers 8

    const/4 v0, 0x0

    if-nez p1, :cond_9

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_9
    :try_start_9
    invoke-virtual {p1}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gms/internal/zzan;->zznB:[Ljava/lang/String;

    array-length v4, v3

    move v1, v0

    :goto_11
    if-ge v1, v4, :cond_1c

    aget-object v5, v3, v1

    invoke-virtual {v2, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z
    :try_end_18
    .catch Ljava/lang/NullPointerException; {:try_start_9 .. :try_end_18} :catch_20

    move-result v5

    if-eqz v5, :cond_1d

    const/4 v0, 0x1

    :cond_1c
    :goto_1c
    return v0

    :cond_1d
    add-int/lit8 v1, v1, 0x1

    goto :goto_11

    :catch_20
    move-exception v1

    goto :goto_1c
.end method

.method public zzc(Landroid/net/Uri;)Z
    .registers 4

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/zzan;->zzb(Landroid/net/Uri;)Z

    move-result v0

    if-eqz v0, :cond_14

    invoke-virtual {p1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    const-string v1, "/aclk"

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_14

    const/4 v0, 0x1

    :goto_13
    return v0

    :cond_14
    const/4 v0, 0x0

    goto :goto_13
.end method
