package com.tencent.mobileqq.msf.core.auth;

import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginMsfListener;

public class WtProvider
{
  static final String tag = "MSF.C.WtloginMsfProvider";
  
  public WtProvider() {}
  
  public static void cancel(int paramInt)
  {
    i.a(paramInt);
  }
  
  public static int sendData(WUserSigInfo paramWUserSigInfo, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, WtloginMsfListener paramWtloginMsfListener)
  {
    return i.a(paramWUserSigInfo, paramString1, paramString2, paramArrayOfByte, paramInt, paramBoolean, paramWtloginMsfListener);
  }
}