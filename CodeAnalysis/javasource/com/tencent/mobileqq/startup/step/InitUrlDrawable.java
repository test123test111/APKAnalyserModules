package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import rdx;
import rdy;

public class InitUrlDrawable
  extends Step
{
  public static DiskCache a;
  public static final String a = "URLDrawable_AutoTest";
  
  public InitUrlDrawable() {}
  
  private static String b(Exception paramException)
  {
    int j = 0;
    if (paramException == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramException = paramException.getStackTrace();
    ArrayList localArrayList = new ArrayList(8);
    int m = paramException.length;
    int i = 0;
    Object localObject;
    int k;
    if (i < m)
    {
      localObject = paramException[i];
      String str = localObject.getClassName();
      k = j;
      if (!str.contains("com.tencent.image.URLDrawable"))
      {
        k = j;
        if (!str.startsWith("android."))
        {
          k = j;
          if (!str.startsWith("java."))
          {
            k = j;
            if (!str.startsWith("com.android."))
            {
              if (!str.startsWith("dalvik.")) {
                break label127;
              }
              k = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      j = k;
      break;
      label127:
      k = j + 1;
      if (k >= 8)
      {
        i = localArrayList.size() - 1;
        while (i >= 0)
        {
          localStringBuffer.append((String)localArrayList.get(i)).append(",");
          i -= 1;
        }
      }
      localArrayList.add(localObject.toString());
    }
    return localStringBuffer.toString();
  }
  
  protected boolean a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    URLDrawable.DEBUG = false;
    File localFile;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      localFile = new File(AppConstants.bd);
    }
    try
    {
      for (;;)
      {
        URLDrawable.init(localBaseApplicationImpl, new rdy(localBaseApplicationImpl));
        if (Build.VERSION.SDK_INT >= 11) {
          URLDrawable.setDebuggableCallback(new rdx());
        }
        localFile = new File(localFile, "diskcache");
        if (localFile != null) {
          break;
        }
        localFile = Utils.getExternalCacheDir(localBaseApplicationImpl);
        a = new DiskCache(localFile);
        com.tencent.mobileqq.transfile.URLDrawableHelper.a = localFile;
        return true;
        localFile = localBaseApplicationImpl.getCacheDir();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AutoMonitor", 1, "", localThrowable);
      }
    }
  }
}
