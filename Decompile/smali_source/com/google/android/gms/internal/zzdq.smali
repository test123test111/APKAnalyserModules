.class public Lcom/google/android/gms/internal/zzdq;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Iterable;


# annotations
.annotation runtime Lcom/google/android/gms/internal/zzgk;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Iterable",
        "<",
        "Lcom/google/android/gms/internal/zzdp;",
        ">;"
    }
.end annotation


# instance fields
.field private final zzxu:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/internal/zzdp;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/zzdq;->zzxu:Ljava/util/List;

    return-void
.end method

.method private zzc(Lcom/google/android/gms/internal/zzip;)Lcom/google/android/gms/internal/zzdp;
    .registers 5

    invoke-static {}, Lcom/google/android/gms/ads/internal/zzp;->zzbK()Lcom/google/android/gms/internal/zzdq;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzdq;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_8
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_19

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/zzdp;

    iget-object v2, v0, Lcom/google/android/gms/internal/zzdp;->zzoL:Lcom/google/android/gms/internal/zzip;

    if-ne v2, p1, :cond_8

    :goto_18
    return-object v0

    :cond_19
    const/4 v0, 0x0

    goto :goto_18
.end method


# virtual methods
.method public iterator()Ljava/util/Iterator;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lcom/google/android/gms/internal/zzdp;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/zzdq;->zzxu:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public zza(Lcom/google/android/gms/internal/zzdp;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/zzdq;->zzxu:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public zza(Lcom/google/android/gms/internal/zzip;)Z
    .registers 3

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzdq;->zzc(Lcom/google/android/gms/internal/zzip;)Lcom/google/android/gms/internal/zzdp;

    move-result-object v0

    if-eqz v0, :cond_d

    iget-object v0, v0, Lcom/google/android/gms/internal/zzdp;->zzxr:Lcom/google/android/gms/internal/zzdr;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzdr;->abort()V

    const/4 v0, 0x1

    :goto_c
    return v0

    :cond_d
    const/4 v0, 0x0

    goto :goto_c
.end method

.method public zzb(Lcom/google/android/gms/internal/zzdp;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/zzdq;->zzxu:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public zzb(Lcom/google/android/gms/internal/zzip;)Z
    .registers 3

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/zzdq;->zzc(Lcom/google/android/gms/internal/zzip;)Lcom/google/android/gms/internal/zzdp;

    move-result-object v0

    if-eqz v0, :cond_8

    const/4 v0, 0x1

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method
