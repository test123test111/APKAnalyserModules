package com.tencent.feedback.eup;

import android.os.Bundle;

public abstract interface ProcessMoniterHandler
{
  public abstract void onOtherAppProcessCrash(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2, long paramLong3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, long paramLong4, Bundle paramBundle);
  
  public abstract void onOtherAppProcessLaunched(String paramString1, String paramString2, boolean paramBoolean, Bundle paramBundle);
}
