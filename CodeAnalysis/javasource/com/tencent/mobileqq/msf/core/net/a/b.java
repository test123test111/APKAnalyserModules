package com.tencent.mobileqq.msf.core.net.a;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.net.g;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  public static final String a = "HeratbeatProxy";
  public static byte[] b = null;
  public static byte[] c = null;
  public static final String d = "OS.Hello";
  public static boolean e = false;
  private static int f = -1;
  private static boolean g = false;
  
  public b() {}
  
  public static void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      QLog.d("HeratbeatProxy", 1, "rsp length:" + paramArrayOfByte.length);
      c = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, c, 0, c.length);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.d("HeratbeatProxy", 1, "set response byte failed " + paramArrayOfByte.toString());
    }
  }
  
  public static boolean a()
  {
    ToServiceMsg localToServiceMsg;
    try
    {
      com.tencent.mobileqq.msf.core.push.a localA = d();
      if (localA == null)
      {
        QLog.d("HeratbeatProxy", 1, "encap heartbeat proxy failed to get appPushInfo");
        return false;
      }
      localToServiceMsg = new ToServiceMsg("", k.uin, "OS.Hello");
      localToServiceMsg.setAppId(a);
      localToServiceMsg.setTimeout(30000L);
      localToServiceMsg.setMsfCommand(MsfCommand.msf_oshello);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      if (!b(localToServiceMsg))
      {
        QLog.d("HeratbeatProxy", 1, "encap heartbeat failed");
        return false;
      }
    }
    catch (Exception localException)
    {
      QLog.d("HeratbeatProxy", 1, "encap heartbeat proxy failed " + localException.toString());
      return false;
    }
    if (!a(localToServiceMsg))
    {
      QLog.d("HeratbeatProxy", 1, "failed to send heartbeat request");
      return false;
    }
    return true;
  }
  
  private static boolean a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    try
    {
      paramFromServiceMsg.getWupBuffer();
      return true;
    }
    catch (Exception paramFromServiceMsg)
    {
      QLog.d("HeratbeatProxy", 1, "encap fromservicemsg failed " + paramFromServiceMsg.toString());
    }
    return false;
  }
  
  public static boolean a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      QLog.d("HeratbeatProxy", 1, "send heartbeat os.hello");
      if (!coresender.a.o().b())
      {
        h.s = SystemClock.elapsedRealtime();
        coresender.a.g();
      }
      int i = coresender.a.o().a(MsfService.core.getMsfAppid(), 0, paramToServiceMsg.getRequestSsoSeq(), paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd(), "", paramToServiceMsg.getMsfCommand(), b, null);
      if (i <= 0) {
        return false;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.d("HeratbeatProxy", 1, "failed to send ok.hello " + paramToServiceMsg.toString());
      return false;
    }
    f = paramToServiceMsg.getRequestSsoSeq();
    g = true;
    return true;
  }
  
  public static boolean b()
  {
    return g;
  }
  
  private static boolean b(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      int i = "OS.Hello".getBytes().length + 13 + 1 + 0 + 4;
      int j = (int)(Long.parseLong(paramToServiceMsg.getUin()) & 0xFFFFFFFFFFFFFFFF);
      byte b1 = (byte)("OS.Hello".getBytes().length + 1);
      paramToServiceMsg = ByteBuffer.allocate(i);
      paramToServiceMsg.putInt(i).putInt(20140601).putInt(j).put(b1).put("OS.Hello".getBytes()).put((byte)1).putInt(0);
      paramToServiceMsg = paramToServiceMsg.array();
      b = new byte[paramToServiceMsg.length];
      System.arraycopy(paramToServiceMsg, 0, b, 0, paramToServiceMsg.length);
      return true;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.d("HeratbeatProxy", 1, "encap toservicemsg failed " + paramToServiceMsg.toString());
    }
    return false;
  }
  
  public static boolean b(byte[] paramArrayOfByte)
  {
    QLog.d("HeratbeatProxy", 1, "recv heartbeat os.hello");
    g = false;
    a(paramArrayOfByte);
    a.l();
    return true;
  }
  
  public static int c()
  {
    return f;
  }
  
  private static com.tencent.mobileqq.msf.core.push.a d()
  {
    Iterator localIterator = corepushManager.h.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (com.tencent.mobileqq.msf.core.push.a)corepushManager.h.get(localObject);
      if ((localObject != null) && (k != null) && (c != 0L)) {
        try
        {
          if ((k.uin != null) && (c > 0L))
          {
            QLog.d("HeratbeatProxy", 1, "get pushinfo uin:" + k.uin + ", pushid:" + c);
            return localObject;
          }
        }
        catch (Exception localException)
        {
          QLog.d("HeratbeatProxy", 1, "failed to get pushinfo", localException);
        }
      }
    }
    return null;
  }
}
