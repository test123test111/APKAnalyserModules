package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzcr
  extends zzak
{
  private static final String ID = zzad.zzbF.toString();
  
  public zzcr()
  {
    super(ID, new String[0]);
  }
  
  public zzag.zza zzG(Map<String, zzag.zza> paramMap)
  {
    return zzdf.zzK(Integer.valueOf(Build.VERSION.SDK_INT));
  }
  
  public boolean zzzx()
  {
    return true;
  }
}
