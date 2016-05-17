package com.tencent.image;

import android.graphics.Bitmap;
import java.net.URL;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;

public class DownloadParams
{
  public CookieStore cookies;
  public long downloaded;
  public Header[] headers;
  public boolean mAutoScaleByDensity;
  public DecodeHandler mDecodeHandler;
  public Object mExtraInfo;
  public float mGifRoundCorner;
  public int mImgType;
  public int outHeight;
  public int outOrientation = 0;
  public int outWidth;
  public int reqHeight;
  public int reqWidth;
  public Object tag;
  public URL url;
  public String urlStr;
  public boolean useExifOrientation;
  public boolean useGifAnimation;
  
  public DownloadParams() {}
  
  public Header getHeader(String paramString)
  {
    if (headers != null)
    {
      Header[] arrayOfHeader = headers;
      int j = arrayOfHeader.length;
      int i = 0;
      while (i < j)
      {
        Header localHeader = arrayOfHeader[i];
        if ((paramString != null) && (paramString.equals(localHeader.getName()))) {
          return localHeader;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static abstract interface DecodeHandler
  {
    public abstract Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap);
  }
}
