.class Lcom/google/android/gms/ads/internal/formats/zzh$5;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/zzdg;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/ads/internal/formats/zzh;->zzdy()Lcom/google/android/gms/internal/zzip;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic zzwk:Lcom/google/android/gms/ads/internal/formats/zzh;


# direct methods
.method constructor <init>(Lcom/google/android/gms/ads/internal/formats/zzh;)V
    .registers 2

    iput-object p1, p0, Lcom/google/android/gms/ads/internal/formats/zzh$5;->zzwk:Lcom/google/android/gms/ads/internal/formats/zzh;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public zza(Lcom/google/android/gms/internal/zzip;Ljava/util/Map;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/zzip;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    :try_start_5
    invoke-interface {p2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_d
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_28

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v1, v0, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_20
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_20} :catch_21

    goto :goto_d

    :catch_21
    move-exception v0

    const-string v1, "Unable to dispatch sendMessageToNativeJs event"

    invoke-static {v1, v0}, Lcom/google/android/gms/ads/internal/util/client/zzb;->zzb(Ljava/lang/String;Ljava/lang/Throwable;)V

    :goto_27
    return-void

    :cond_28
    :try_start_28
    const-string v0, "id"

    iget-object v2, p0, Lcom/google/android/gms/ads/internal/formats/zzh$5;->zzwk:Lcom/google/android/gms/ads/internal/formats/zzh;

    invoke-static {v2}, Lcom/google/android/gms/ads/internal/formats/zzh;->zzc(Lcom/google/android/gms/ads/internal/formats/zzh;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    iget-object v0, p0, Lcom/google/android/gms/ads/internal/formats/zzh$5;->zzwk:Lcom/google/android/gms/ads/internal/formats/zzh;

    invoke-static {v0}, Lcom/google/android/gms/ads/internal/formats/zzh;->zzd(Lcom/google/android/gms/ads/internal/formats/zzh;)Lcom/google/android/gms/internal/zzbb;

    move-result-object v0

    const-string v2, "sendMessageToNativeJs"

    invoke-interface {v0, v2, v1}, Lcom/google/android/gms/internal/zzbb;->zzb(Ljava/lang/String;Lorg/json/JSONObject;)V
    :try_end_3e
    .catch Lorg/json/JSONException; {:try_start_28 .. :try_end_3e} :catch_21

    goto :goto_27
.end method
