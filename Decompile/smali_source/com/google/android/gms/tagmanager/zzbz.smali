.class Lcom/google/android/gms/tagmanager/zzbz;
.super Lcom/google/android/gms/tagmanager/zzak;


# static fields
.field private static final ID:Ljava/lang/String;

.field private static final zzaQV:Lcom/google/android/gms/internal/zzag$zza;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    sget-object v0, Lcom/google/android/gms/internal/zzad;->zzbA:Lcom/google/android/gms/internal/zzad;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/zzad;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/tagmanager/zzbz;->ID:Ljava/lang/String;

    const-string v0, "Android"

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/zzdf;->zzK(Ljava/lang/Object;)Lcom/google/android/gms/internal/zzag$zza;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/tagmanager/zzbz;->zzaQV:Lcom/google/android/gms/internal/zzag$zza;

    return-void
.end method

.method public constructor <init>()V
    .registers 3

    sget-object v0, Lcom/google/android/gms/tagmanager/zzbz;->ID:Ljava/lang/String;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcom/google/android/gms/tagmanager/zzak;-><init>(Ljava/lang/String;[Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public zzG(Ljava/util/Map;)Lcom/google/android/gms/internal/zzag$zza;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/internal/zzag$zza;",
            ">;)",
            "Lcom/google/android/gms/internal/zzag$zza;"
        }
    .end annotation

    sget-object v0, Lcom/google/android/gms/tagmanager/zzbz;->zzaQV:Lcom/google/android/gms/internal/zzag$zza;

    return-object v0
.end method

.method public zzzx()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method