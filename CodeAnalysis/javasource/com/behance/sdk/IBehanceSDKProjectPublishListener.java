package com.behance.sdk;

import com.behance.sdk.exception.BehanceSDKException;

public abstract interface IBehanceSDKProjectPublishListener
{
  public abstract void onFailure(BehanceSDKException paramBehanceSDKException);
  
  public abstract void onSuccess();
}
