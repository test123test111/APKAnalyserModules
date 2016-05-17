package com.tencent.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.Executor;

public abstract class URLDrawableParams
{
  public static final int TASK_TYPE_ASYNC_TASK = 0;
  public static final int TASK_TYPE_SWING_WORKER = 1;
  public boolean mAutoScaleByDensity = true;
  public Bitmap.Config mConfig = Bitmap.Config.ARGB_8888;
  int mDeviceDensity = 160;
  private Hashtable<String, ProtocolDownloader> mDownLoaderMap = new Hashtable();
  public boolean mFadeInImage = true;
  HashMap<String, String> mLocalFileMap = new HashMap();
  public MQLruCache<String, Object> mMemoryCache = null;
  int mMemoryCacheSize = 5242880;
  public int mReqHeight;
  public int mReqWidth;
  public Executor mURLDrawableExecutor;
  public Executor mURLDrawableFileExecutor;
  public Executor mURLDrawableSubExecutor;
  public boolean mUseGifAnimation = true;
  
  public URLDrawableParams(Context paramContext)
  {
    mDeviceDensity = getResourcesgetDisplayMetricsdensityDpi;
    mReqWidth = getResourcesgetDisplayMetricswidthPixels;
    mReqHeight = getResourcesgetDisplayMetricsheightPixels;
  }
  
  protected abstract ProtocolDownloader doGetDownloader(String paramString);
  
  protected abstract String doGetLocalFilePath(String paramString);
  
  protected abstract Drawable getDefaultLoadingDrawable();
  
  protected abstract Drawable getDefualtFailedDrawable();
  
  ProtocolDownloader getDownloader(String paramString)
  {
    Object localObject1 = (ProtocolDownloader)mDownLoaderMap.get(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = doGetDownloader(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if ("file".equalsIgnoreCase(paramString)) {
          localObject1 = new LocaleFileDownloader();
        }
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        mDownLoaderMap.put(paramString, localObject1);
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  String getLocalFilePath(String paramString)
  {
    String str2 = (String)mLocalFileMap.get(paramString);
    String str1 = str2;
    if (str2 == null)
    {
      str2 = doGetLocalFilePath(paramString);
      str1 = str2;
      if (str2 != null)
      {
        mLocalFileMap.put(paramString, str2);
        str1 = str2;
      }
    }
    return str1;
  }
}
