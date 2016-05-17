package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract interface IServerMsgPushHandler
  extends IMsfHandler
{
  public abstract void onConnClose(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onConnOpened(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onOpenConnAllFailed(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onReceFirstResp(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRecvServerConfigPush(FromServiceMsg paramFromServiceMsg);
}
