package com.behance.sdk.asynctask.listeners;

import com.behance.sdk.asynctasks.result.BehanceSDKRetrieveAccessTokenFromTwitterTaskResult;

public abstract interface IBehanceSDKRetrieveAccessTokenFromTwitterTaskListener
{
  public abstract void onRetrieveAccessTokenFromTwitterFailure(BehanceSDKRetrieveAccessTokenFromTwitterTaskResult paramBehanceSDKRetrieveAccessTokenFromTwitterTaskResult);
  
  public abstract void onRetrieveAccessTokenFromTwitterSuccess(BehanceSDKRetrieveAccessTokenFromTwitterTaskResult paramBehanceSDKRetrieveAccessTokenFromTwitterTaskResult);
}