package com.adobe.creativesdk.foundation.auth;

import java.util.HashMap;
import java.util.Map;

public enum AdobeAuthErrorCode
{
  private static Map<Integer, AdobeAuthErrorCode> _map;
  private final int value;
  
  static
  {
    int i = 0;
    ADOBE_AUTH_ERROR_AUTH_MODULE_NOT_INITIALIZED = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_AUTH_MODULE_NOT_INITIALIZED", 0, 1);
    ADOBE_AUTH_ERROR_CODE_OFFLINE = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_OFFLINE", 1, 2);
    ADOBE_AUTH_ERROR_CODE_NO_ERROR = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_NO_ERROR", 2, 3);
    ADOBE_AUTH_ERROR_CODE_USER_CANCELLED = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_USER_CANCELLED", 3, 4);
    ADOBE_AUTH_ERROR_CODE_USER_INTERACTION_REQUIRED = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_USER_INTERACTION_REQUIRED", 4, 5);
    ADOBE_AUTH_ERROR_CODE_USERNAME_AND_PASSWORD_REQUIRED = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_USERNAME_AND_PASSWORD_REQUIRED", 5, 6);
    ADOBE_AUTH_ERROR_CODE_DEVICE_ID_REQUIRED = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_DEVICE_ID_REQUIRED", 6, 7);
    ADOBE_AUTH_ERROR_CODE_CLIENT_ID_REQUIRED = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_CLIENT_ID_REQUIRED", 7, 8);
    ADOBE_AUTH_ERROR_CODE_CLIENT_SECRET_REQUIRED = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_CLIENT_SECRET_REQUIRED", 8, 9);
    ADOBE_AUTH_ERROR_CODE_INVALID_ARGUMENT = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_INVALID_ARGUMENT", 9, 10);
    ADOBE_AUTH_ERROR_CODE_UNKNOWN_ERROR = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_UNKNOWN_ERROR", 10, 11);
    ADOBE_AUTH_ERROR_CODE_NETWORK_ERROR = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_NETWORK_ERROR", 11, 12);
    ADOBE_AUTH_ERROR_CODE_USER_NOT_ENTITLED = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_USER_NOT_ENTITLED", 12, 13);
    ADOBE_AUTH_ERROR_CODE_USER_CREDENTIALS_REQUIRED = new AdobeAuthErrorCode("ADOBE_AUTH_ERROR_CODE_USER_CREDENTIALS_REQUIRED", 13, 14);
    $VALUES = new AdobeAuthErrorCode[] { ADOBE_AUTH_ERROR_AUTH_MODULE_NOT_INITIALIZED, ADOBE_AUTH_ERROR_CODE_OFFLINE, ADOBE_AUTH_ERROR_CODE_NO_ERROR, ADOBE_AUTH_ERROR_CODE_USER_CANCELLED, ADOBE_AUTH_ERROR_CODE_USER_INTERACTION_REQUIRED, ADOBE_AUTH_ERROR_CODE_USERNAME_AND_PASSWORD_REQUIRED, ADOBE_AUTH_ERROR_CODE_DEVICE_ID_REQUIRED, ADOBE_AUTH_ERROR_CODE_CLIENT_ID_REQUIRED, ADOBE_AUTH_ERROR_CODE_CLIENT_SECRET_REQUIRED, ADOBE_AUTH_ERROR_CODE_INVALID_ARGUMENT, ADOBE_AUTH_ERROR_CODE_UNKNOWN_ERROR, ADOBE_AUTH_ERROR_CODE_NETWORK_ERROR, ADOBE_AUTH_ERROR_CODE_USER_NOT_ENTITLED, ADOBE_AUTH_ERROR_CODE_USER_CREDENTIALS_REQUIRED };
    _map = new HashMap();
    AdobeAuthErrorCode[] arrayOfAdobeAuthErrorCode = values();
    int j = arrayOfAdobeAuthErrorCode.length;
    while (i < j)
    {
      AdobeAuthErrorCode localAdobeAuthErrorCode = arrayOfAdobeAuthErrorCode[i];
      _map.put(Integer.valueOf(value), localAdobeAuthErrorCode);
      i += 1;
    }
  }
  
  private AdobeAuthErrorCode(int paramInt)
  {
    value = paramInt;
  }
  
  static AdobeAuthErrorCode fromInt(int paramInt)
  {
    return (AdobeAuthErrorCode)_map.get(Integer.valueOf(paramInt));
  }
  
  public int getValue()
  {
    return value;
  }
}
