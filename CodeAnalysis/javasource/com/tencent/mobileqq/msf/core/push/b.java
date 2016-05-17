package com.tencent.mobileqq.msf.core.push;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.b.m;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.pb.ImMqPullup.MsgReq;
import com.tencent.msf.service.protocol.pb.ImMqPullup.MsgRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class b
{
  private static final String b = "PCActiveEchoManager";
  private static final int c = 10000;
  private static final long d = 600000L;
  private static final long e = 60000L;
  private static final int g = 1;
  private static final int h = 2;
  private static final String j = "0";
  private static final String n = "key_pcactive_opened_uins";
  final long a = 30000L;
  private long f = 600000L;
  private long i = 0L;
  private AtomicBoolean k = new AtomicBoolean(false);
  private String l = "0";
  private MsfCore m;
  private Handler o = new c(this);
  
  public b(MsfCore paramMsfCore)
  {
    m = paramMsfCore;
    paramMsfCore = MsfStore.getNativeConfigStore().getConfig("0");
    if ((!TextUtils.isEmpty(paramMsfCore)) && (!"0".equals(paramMsfCore)))
    {
      l = paramMsfCore;
      o.sendEmptyMessageDelayed(10000, 60000L);
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 53533) || (paramInt == 210) || (paramInt == 55535) || (paramInt == 55533) || (paramInt == 55532) || (paramInt == 55530) || (paramInt == 55430) || (paramInt == 55531) || (paramInt == 55433) || (paramInt == 55527);
  }
  
  private boolean b()
  {
    long l1 = SystemClock.elapsedRealtime();
    if (i > 0L)
    {
      l1 -= i;
      if (l1 <= 0L) {
        break label182;
      }
      if (l1 <= f + 30000L) {
        break label190;
      }
    }
    label182:
    label190:
    for (boolean bool = true;; bool = false)
    {
      m.getStatReporter().a("dim.Msf.PCActiveEcho", bool, l1, 0L, null, false, false);
      for (;;)
      {
        ToServiceMsg localToServiceMsg = new ToServiceMsg("MessageSvc.QueryPullUp", l, "MessageSvc.QueryPullUp");
        localToServiceMsg.setRequestSsoSeq(MsfSdkUtils.getNextAppSeq());
        localToServiceMsg.getAttributes().put("send_mode", Integer.valueOf(1));
        localToServiceMsg.getAttributes().put("RequestEcho", Boolean.valueOf(true));
        byte[] arrayOfByte1 = new ImMqPullup.MsgReq().toByteArray();
        l1 = arrayOfByte1.length;
        byte[] arrayOfByte2 = new byte[(int)l1 + 4];
        com.tencent.qphone.base.util.e.a(arrayOfByte2, 0, 4L + l1);
        com.tencent.qphone.base.util.e.a(arrayOfByte2, 4, arrayOfByte1, (int)l1);
        localToServiceMsg.putWupBuffer(arrayOfByte2);
        m.lightSender.a(localToServiceMsg);
        return true;
        i = 0L;
      }
    }
  }
  
  public void a()
  {
    try
    {
      o.removeMessages(10000);
      l = "0";
      MsfStore.getNativeConfigStore().removeConfig("0");
      m.lightSender.a();
      m.lightSender.b();
      i = 0L;
      QLog.d("PCActiveEchoManager", 1, "stopEcho succ");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("PCActiveEchoManager", 1, "stopEcho fail", localException);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult");
    boolean bool = ((Boolean)paramToServiceMsg.getAttribute("RequestEcho", Boolean.valueOf(false))).booleanValue();
    if (paramFromServiceMsg.getServiceCmd().equals("ConfigPushSvc.PushReq")) {
      QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult ssolist changed");
    }
    while (bool)
    {
      QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult succ, continue at " + f + " later");
      i = SystemClock.elapsedRealtime();
      o.sendEmptyMessageDelayed(10000, f);
      return;
      if (paramFromServiceMsg != null)
      {
        int i1;
        try
        {
          if ((!paramFromServiceMsg.isSuccess()) || (paramFromServiceMsg.getWupBuffer() == null) || (paramFromServiceMsg.getWupBuffer().length <= 4)) {
            break label411;
          }
          paramToServiceMsg = new byte[paramFromServiceMsg.getWupBuffer().length - 4];
          System.arraycopy(paramFromServiceMsg.getWupBuffer(), 4, paramToServiceMsg, 0, paramToServiceMsg.length);
          ImMqPullup.MsgRsp localMsgRsp = new ImMqPullup.MsgRsp();
          localMsgRsp.mergeFrom(paramToServiceMsg);
          if (command.get() != 1) {
            continue;
          }
          i1 = uint32_ret.get();
          int i2 = uint32_itv.get();
          if (i2 > 0) {
            f = (i2 * 1000);
          }
          QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult ret: " + i1 + " interval: " + f);
          if (i1 != 1) {
            break label377;
          }
          paramToServiceMsg = new HashMap();
          com.tencent.mobileqq.msf.service.c.a(paramToServiceMsg);
          paramToServiceMsg.put("account", paramFromServiceMsg.getUin());
          if (!bool) {
            break label348;
          }
          QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult succ, stop poll and active qq");
          a();
          m.pushManager.c(paramFromServiceMsg.getUin());
          m.getStatReporter().a("dim.Msf.PCActiveSuccResult", true, 0L, 0L, paramToServiceMsg, false, false);
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
        }
        continue;
        label348:
        m.getStatReporter().a("dim.Msf.PCActiveSuccResult", false, 0L, 0L, paramToServiceMsg, false, false);
        QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult failed, need active, ToServiceMsg's RequestEcho Flag is false");
        return;
        label377:
        if (i1 == 2)
        {
          if (bool)
          {
            QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult succ, force stop poll");
            a();
            return;
          }
          QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult failed, need stop, ToServiceMsg's RequestEcho Flag is false");
          return;
          label411:
          if (bool)
          {
            if (a(paramFromServiceMsg.getBusinessFailCode()))
            {
              QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult failed, tokenExpired");
              a();
            }
          }
          else {
            QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult failed, need stop1, ToServiceMsg's RequestEcho Flag is false");
          }
        }
      }
    }
    QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult failed, need continue, ToServiceMsg's RequestEcho Flag is false");
  }
  
  public void a(String paramString)
  {
    try
    {
      if (k.get())
      {
        QLog.d("PCActiveEchoManager", 1, "startEcho failed, reason: echo still running");
        return;
      }
      QLog.d("PCActiveEchoManager", 1, "startEcho succ");
      k.set(true);
      o.removeMessages(10000);
      i = 0L;
      m.lightSender.a();
      m.lightSender.b();
      l = paramString;
      MsfStore.getNativeConfigStore().setConfig("0", paramString);
      o.sendEmptyMessageDelayed(10000, 60000L);
      k.set(false);
      if (m.getStatReporter() != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("account", paramString);
        m.getStatReporter().a("dim.Msf.PCActiveDidStartEvent", true, 0L, 0L, localHashMap, false, false);
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("PCActiveEchoManager", 1, "startEcho fail", paramString);
      return;
    }
    QLog.d("msfCore", 1, "stop try report PCActiveDidStartEvent by reporter null");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    String[] arrayOfString = MsfStore.getNativeConfigStore().getConfig("key_pcactive_opened_uins").split(",");
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = arrayOfString[i1];
      if (!str.equals(paramString)) {
        localStringBuilder.append(str);
      }
      i1 += 1;
    }
    if (paramBoolean) {
      localStringBuilder.append(paramString);
    }
    MsfStore.getNativeConfigStore().setConfig("key_pcactive_opened_uins", localStringBuilder.toString());
  }
  
  public boolean b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = MsfStore.getNativeConfigStore().getConfig("key_pcactive_opened_uins").split(",");
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (arrayOfString[i1].equals(paramString)) {
          return true;
        }
        i1 += 1;
      }
    }
  }
}
