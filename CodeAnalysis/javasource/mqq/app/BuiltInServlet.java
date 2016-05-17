package mqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.NotifyRegisterInfo;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;
import mqq.observer.CheckConErroObserver;
import mqq.observer.SSOAccountObserver;
import mqq.observer.ServerConfigObserver;
import mqq.observer.SubAccountObserver;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WtloginMsfListener;
import protocol.KQQConfig.GetResourceRespV2;

public class BuiltInServlet
  extends MSFServlet
  implements Constants.Action
{
  private boolean isRegist;
  
  BuiltInServlet() {}
  
  static boolean isQQUin(String paramString)
  {
    boolean bool2 = false;
    try
    {
      long l = Long.parseLong(paramString);
      boolean bool1 = bool2;
      if (l > 9999L)
      {
        bool1 = bool2;
        if (l < 4000000000L) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = -1;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("action", 0);
    }
    Bundle localBundle = new Bundle();
    Object localObject6;
    Object localObject4;
    Object localObject1;
    int j;
    Object localObject7;
    long l1;
    long l2;
    Object localObject5;
    switch (i)
    {
    default: 
      return;
    case 1001: 
      if (QLog.isColorLevel()) {
        QLog.d("BuiltInServlet", 2, "login in back from msf build servlets start");
      }
      getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      localBundle.putString("uin", paramFromServiceMsg.getUin());
      localBundle.putString("alias", paramIntent.getStringExtra("account"));
      localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
      localObject6 = paramFromServiceMsg.getAttribute("resp_login_url");
      localObject4 = "";
      localObject1 = localObject4;
      if (localObject6 != null)
      {
        localObject1 = localObject4;
        if ((localObject6 instanceof String)) {
          localObject1 = (String)localObject6;
        }
      }
      localObject4 = paramFromServiceMsg.getAttribute("resp_logini_ret");
      j = 0;
      i = j;
      if (localObject4 != null)
      {
        i = j;
        if ((localObject4 instanceof Integer)) {
          i = ((Integer)localObject4).intValue();
        }
      }
      localObject7 = paramFromServiceMsg.getAttribute("resp_login_lhsig");
      localObject6 = null;
      localObject4 = localObject6;
      if (localObject7 != null)
      {
        localObject4 = localObject6;
        if ((localObject7 instanceof byte[])) {
          localObject4 = (byte[])localObject7;
        }
      }
      localBundle.putString("errorurl", (String)localObject1);
      localBundle.putInt("loginret", i);
      localBundle.putInt("code", paramFromServiceMsg.getResultCode());
      localBundle.putByteArray("lhsig", (byte[])localObject4);
      if (paramFromServiceMsg.isSuccess())
      {
        MsfSdkUtils.addLoginSimpleAccount(paramFromServiceMsg.getUin(), true);
        localObject1 = paramIntent.getStringExtra("account");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject1);
        }
      }
      for (;;)
      {
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        notifyObserver(paramIntent, 1001, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BuiltInServlet", 2, "login in back from msf build servlets end");
        return;
        MsfSdkUtils.updateSimpleAccountNotCreate(paramFromServiceMsg.getUin(), false);
      }
    case 1035: 
      if (QLog.isColorLevel()) {
        QLog.d("BuiltInServlet", 2, "sub account login in back from msf build servlets start");
      }
      getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      localBundle.putString("uin", paramFromServiceMsg.getUin());
      localBundle.putString("alias", paramIntent.getStringExtra("subaccount"));
      localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
      localBundle.putInt("code", paramFromServiceMsg.getResultCode());
      if (paramFromServiceMsg.isSuccess())
      {
        MsfSdkUtils.addLoginSimpleAccount(paramFromServiceMsg.getUin(), true);
        localObject1 = paramIntent.getStringExtra("subaccount");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = (String)paramFromServiceMsg.getAttribute("mainaccount");
        localBundle.putString("submainaccount", (String)localObject1);
        localObject4 = getAppRuntime().getApplication().getFirstSimpleAccount();
        long l3 = System.currentTimeMillis();
        l1 = l3;
        if (localObject4 != null) {
          l2 = l3;
        }
        try
        {
          long l4 = getAppRuntime().getApplication().string2Long(getAppRuntime().getApplication().getProperty(((SimpleAccount)localObject4).getUin() + Constants.Key._logintime));
          l1 = l3;
          if (l3 <= l4)
          {
            l3 = l4 + 1L;
            l1 = l3;
            l2 = l3;
            if (QLog.isColorLevel())
            {
              l2 = l3;
              QLog.d("mqq", 2, "CNR account savetime => system time is error..shit");
              l1 = l3;
            }
          }
        }
        catch (Exception localException8)
        {
          for (;;)
          {
            localException8.printStackTrace();
            l1 = l2;
          }
        }
        if (paramFromServiceMsg.getUin() != null) {
          getAppRuntime().getApplication().setProperty(paramFromServiceMsg.getUin() + Constants.Key._logintime, String.valueOf(l1));
        }
        if (localObject1 != null) {
          getAppRuntime().getApplication().setProperty((String)localObject1 + Constants.Key._logintime, String.valueOf(1L + l1));
        }
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "builtInservice onreceiver ACTION_SUBACCOUNT_LOGIN");
        }
        notifyObserver(paramIntent, 1035, paramFromServiceMsg.isSuccess(), localBundle, SubAccountObserver.class);
        return;
        MsfSdkUtils.updateSimpleAccountNotCreate(paramFromServiceMsg.getUin(), false);
      }
    case 1100: 
      if (QLog.isColorLevel()) {
        QLog.d("onReceive", 2, "builtInServlet action_sso_login_account...");
      }
      localBundle.putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
      if (paramFromServiceMsg.isSuccess())
      {
        localBundle.putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
        localBundle.putParcelable("lastError", (Parcelable)paramFromServiceMsg.getAttribute("lastError"));
        localBundle.putInt("targetTicket", paramIntent.getIntExtra("targetTicket", 4096));
        localBundle.putByteArray("st_temp", (byte[])paramFromServiceMsg.getAttribute("st_temp"));
        localBundle.putByteArray("st_temp_key", (byte[])paramFromServiceMsg.getAttribute("st_temp_key"));
      }
      localObject1 = paramFromServiceMsg.getAttribute("ret");
      if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
        localBundle.putInt("ret", ((Integer)localObject1).intValue());
      }
      for (;;)
      {
        localBundle.putInt("code", paramFromServiceMsg.getResultCode());
        localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
        notifyObserver(paramIntent, 1100, paramFromServiceMsg.isSuccess(), localBundle, SSOAccountObserver.class);
        return;
        localBundle.putInt("ret", -1);
      }
    case 1101: 
      if (QLog.isColorLevel()) {
        QLog.d("onReceive", 2, "builtInServlet action_sso_login_no_passwd...");
      }
      localBundle.putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
      if (paramFromServiceMsg.isSuccess())
      {
        localBundle.putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
        localBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.getAttribute("userSigInfo"));
        localBundle.putParcelable("lastError", (Parcelable)paramFromServiceMsg.getAttribute("lastError"));
        localBundle.putInt("targetTicket", paramIntent.getIntExtra("targetTicket", 4096));
        localBundle.putByteArray("st_temp", (byte[])paramFromServiceMsg.getAttribute("st_temp"));
        localBundle.putByteArray("st_temp_key", (byte[])paramFromServiceMsg.getAttribute("st_temp_key"));
      }
      localBundle.putInt("code", paramFromServiceMsg.getResultCode());
      localBundle.putParcelable("errMsg", (Parcelable)paramFromServiceMsg.getAttribute("errMsg"));
      localObject1 = paramFromServiceMsg.getAttribute("ret");
      if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
        localBundle.putInt("ret", ((Integer)localObject1).intValue());
      }
      for (;;)
      {
        localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
        notifyObserver(paramIntent, 1101, paramFromServiceMsg.isSuccess(), localBundle, SSOAccountObserver.class);
        return;
        localBundle.putInt("ret", -1);
      }
    case 1102: 
      localBundle.putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
      if (paramFromServiceMsg.isSuccess())
      {
        localObject1 = paramFromServiceMsg.getAttribute("dwSrcAppid");
        if ((localObject1 != null) && ((localObject1 instanceof Long))) {
          localBundle.putLong("dwSrcAppid", ((Long)localObject1).longValue());
        }
        localObject1 = paramFromServiceMsg.getAttribute("dwMainSigMap");
        if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
          localBundle.putInt("dwMainSigMap", ((Integer)localObject1).intValue());
        }
        localObject1 = paramFromServiceMsg.getAttribute("dwSubSrcAppid");
        if ((localObject1 != null) && ((localObject1 instanceof Long))) {
          localBundle.putLong("dwSubSrcAppid", ((Long)localObject1).longValue());
        }
        localBundle.putByteArray("dstAppName", (byte[])paramFromServiceMsg.getAttribute("dstAppName"));
        localObject1 = paramFromServiceMsg.getAttribute("dwDstSsoVer");
        if ((localObject1 != null) && ((localObject1 instanceof Long))) {
          localBundle.putLong("dwDstSsoVer", ((Long)localObject1).longValue());
        }
        localObject1 = paramFromServiceMsg.getAttribute("dwDstAppid");
        if ((localObject1 != null) && ((localObject1 instanceof Long))) {
          localBundle.putLong("dwDstAppid", ((Long)localObject1).longValue());
        }
        localObject1 = paramFromServiceMsg.getAttribute("dwSubDstAppid");
        if ((localObject1 != null) && ((localObject1 instanceof Long))) {
          localBundle.putLong("dwSubDstAppid", ((Long)localObject1).longValue());
        }
        localBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.getAttribute("userSigInfo"));
        localBundle.putParcelable("fastLoginInfo", (Parcelable)paramFromServiceMsg.getAttribute("fastLoginInfo"));
        localBundle.putByteArray("dstAppVer", (byte[])paramFromServiceMsg.getAttribute("dstAppVer"));
        localBundle.putByteArray("dstAppSign", (byte[])paramFromServiceMsg.getAttribute("dstAppSign"));
        localBundle.putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
      }
      localBundle.putInt("code", paramFromServiceMsg.getResultCode());
      localBundle.putParcelable("errMsg", (Parcelable)paramFromServiceMsg.getAttribute("errMsg"));
      localObject1 = paramFromServiceMsg.getAttribute("ret");
      if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
        localBundle.putInt("ret", ((Integer)localObject1).intValue());
      }
      for (;;)
      {
        notifyObserver(paramIntent, 1102, paramFromServiceMsg.isSuccess(), localBundle, SSOAccountObserver.class);
        return;
        localBundle.putInt("ret", -1);
      }
    case 1037: 
      localObject7 = (String)paramFromServiceMsg.getAttribute("MSF.getKey");
      localObject6 = paramFromServiceMsg.getUin();
      localObject5 = null;
      localObject1 = localObject5;
      if (localObject7 != null)
      {
        localObject7 = ((String)localObject7).split(";");
        localObject1 = localObject5;
        if (localObject7 != null) {
          localObject1 = localObject5;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        if (localObject7.length > 0)
        {
          i = 0;
          localObject1 = localObject5;
          if (i < localObject7.length)
          {
            localObject1 = localObject7[i];
            if ((localObject1 == null) || (((String)localObject1).length() == 0) || (!((String)localObject1).startsWith("UIN=" + (String)localObject6 + ","))) {
              break label4038;
            }
            j = ((String)localObject1).indexOf("A2=");
            if (j < 0) {
              break label4038;
            }
            localObject1 = ((String)localObject1).substring(j);
            if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
              break label4038;
            }
            localObject1 = ((String)localObject1).split(",");
            if ((localObject1 == null) || (localObject1.length <= 0) || (localObject1[0] == null) || (localObject1[0].length() <= "A2=".length() + 1)) {
              break label4038;
            }
            localObject1 = localObject1[0].substring("A2=".length());
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        localObject2 = localObject5;
        continue;
      }
      localBundle.putString("uin", (String)localObject6);
      localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
      localBundle.putInt("code", paramFromServiceMsg.getResultCode());
      localBundle.putString("subaccountA2", (String)localObject1);
      localBundle.putString("mainaccount", (String)paramFromServiceMsg.getAttribute("mainaccount"));
      notifyObserver(paramIntent, 1037, paramFromServiceMsg.isSuccess(), localBundle, SubAccountObserver.class);
      return;
      notifyObserver(paramIntent, 1040, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
      return;
      if ((!"push.register".equals(paramFromServiceMsg.getServiceCmd())) && (!"push.unRegister".equals(paramFromServiceMsg.getServiceCmd()))) {
        break;
      }
      if (paramFromServiceMsg.isSuccess())
      {
        localObject5 = (AppRuntime.Status)paramIntent.getSerializableExtra("onlineStatus");
        boolean bool1 = false;
        l2 = 0L;
        boolean bool2 = false;
        boolean bool3;
        boolean bool4;
        if (localObject5 == AppRuntime.Status.offline)
        {
          bool3 = bool1;
          bool4 = bool2;
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.i("mqq", 2, paramFromServiceMsg.getUin() + " is offline.");
            l1 = l2;
            bool4 = bool2;
            bool3 = bool1;
          }
        }
        for (;;)
        {
          localBundle.putSerializable("onlineStatus", (Serializable)localObject5);
          localBundle.putBoolean("isChanged", bool3);
          localBundle.putLong("timeStamp", l1);
          localBundle.putBoolean("isLargeChanged", bool4);
          notifyObserver(paramIntent, 1002, true, localBundle, AccountObserver.class);
          return;
          localObject2 = null;
          if ((paramFromServiceMsg.getWupBuffer() != null) && (paramFromServiceMsg.getWupBuffer().length > 0))
          {
            localObject2 = (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
            QLog.i("mqq", 1, paramFromServiceMsg.getUin() + ", " + localObject5 + ", " + timeStamp + ", " + false + ", " + false);
            label2563:
            bool3 = bool1;
            bool4 = bool2;
            l1 = l2;
            if (localObject2 == null) {
              continue;
            }
            bool3 = bool1;
            bool4 = bool2;
            l1 = l2;
            if (cReplyCode != 0) {
              continue;
            }
            if (bUpdateFlag != 1) {
              break label2733;
            }
            bool1 = true;
            label2612:
            if (bLargeSeqUpdate != 1) {
              break label2739;
            }
          }
          label2733:
          label2739:
          for (bool2 = true;; bool2 = false)
          {
            if (timeStamp != 0L) {
              break label2745;
            }
            bool3 = bool1;
            bool4 = bool2;
            l1 = l2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("mqq", 2, paramFromServiceMsg.getUin() + " respPush, flist server error , skip.");
            bool3 = bool1;
            bool4 = bool2;
            l1 = l2;
            break;
            QLog.d("mqq", 1, paramFromServiceMsg.getUin() + ", " + localObject5);
            break label2563;
            bool1 = false;
            break label2612;
          }
          label2745:
          l1 = timeStamp;
          bool3 = bool1;
          bool4 = bool2;
        }
      }
      Object localObject2 = (AppRuntime.Status)paramIntent.getSerializableExtra("old");
      if (QLog.isColorLevel()) {
        QLog.w("mqq", 2, paramFromServiceMsg.getUin() + " set " + getAppRuntime().getOnlineStatus() + " failed,revert to a previous status=" + localObject2);
      }
      getAppRuntime().setOnlineStatus((AppRuntime.Status)localObject2);
      localBundle.putSerializable("onlineStatus", (Serializable)localObject2);
      notifyObserver(paramIntent, 1002, false, localBundle, AccountObserver.class);
      return;
      localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
      if (paramFromServiceMsg.isSuccess()) {}
      try
      {
        localBundle.putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
        if (QLog.isColorLevel()) {
          QLog.d("queryMobile", 2, "BuiltInServlet.startQueryAccount callback");
        }
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
      localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
      if (paramFromServiceMsg.isSuccess()) {}
      try
      {
        j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
        byte[] arrayOfByte1 = (byte[])paramFromServiceMsg.getAttribute("to_register_cr_mobile", new byte[0]);
        localBundle.putInt("code", j);
        localBundle.putByteArray("mobile", arrayOfByte1);
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          localException3.printStackTrace();
        }
      }
      localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
      if (paramFromServiceMsg.isSuccess()) {}
      int k;
      int m;
      try
      {
        j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
        k = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shNextResendTime", Integer.valueOf(-1))).intValue();
        m = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shTotalTimeOver", Integer.valueOf(-1))).intValue();
        localBundle.putInt("code", j);
        localBundle.putInt("next_chk_time", k);
        localBundle.putInt("total_time_over", m);
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          localException4.printStackTrace();
        }
      }
      localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
      if (paramFromServiceMsg.isSuccess()) {}
      try
      {
        localBundle.putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
      }
      catch (Exception localException5)
      {
        for (;;)
        {
          localException5.printStackTrace();
        }
      }
      localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
      if (paramFromServiceMsg.isSuccess()) {}
      try
      {
        j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
        k = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shNextResendTime", Integer.valueOf(-1))).intValue();
        m = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shTotalTimeOver", Integer.valueOf(-1))).intValue();
        String str = (String)paramFromServiceMsg.getAttribute("res_register_errmsg", "");
        localBundle.putInt("code", j);
        localBundle.putInt("next_chk_time", k);
        localBundle.putInt("total_time_over", m);
        localBundle.putString("errmsg", str);
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
      }
      catch (Exception localException6)
      {
        for (;;)
        {
          localException6.printStackTrace();
        }
      }
      localBundle.putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
      if (paramFromServiceMsg.isSuccess()) {}
      try
      {
        j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
        byte[] arrayOfByte2 = (byte[])paramFromServiceMsg.getAttribute("resp_register_contactssig", new byte[0]);
        localObject5 = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
        localBundle.putInt("code", j);
        localBundle.putByteArray("promptInfo", arrayOfByte2);
        localBundle.putString("uin", (String)localObject5);
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
      }
      catch (Exception localException7)
      {
        for (;;)
        {
          localException7.printStackTrace();
        }
      }
      notifyObserver(paramIntent, 1007, paramFromServiceMsg.isSuccess(), null, AccountObserver.class);
      return;
      localBundle.putSerializable("map", attributes);
      notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
      return;
      localBundle.putString("key", (String)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd()));
      notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
      return;
      Object localObject3 = paramIntent.getStringExtra("uin");
      localObject5 = paramIntent.getStringExtra("cmd");
      l1 = paramIntent.getLongExtra("wtsdkseq", -1L);
      paramIntent = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      paramIntent.order(ByteOrder.BIG_ENDIAN);
      i = paramIntent.getInt();
      localObject6 = new byte[i - 4];
      paramIntent.get((byte[])localObject6, 0, i - 4);
      if (paramFromServiceMsg.isSuccess())
      {
        WtloginMsfListener.onAsyncReceive((String)localObject3, (String)localObject5, l1, (byte[])localObject6);
        return;
      }
      WtloginMsfListener.onAsyncReceiveFail((String)localObject3, (String)localObject5, l1, paramFromServiceMsg.getBusinessFailCode());
      return;
      if (paramFromServiceMsg.isSuccess())
      {
        localObject3 = new UniPacket(true);
        ((UniPacket)localObject3).setEncodeName("utf-8");
        ((UniPacket)localObject3).decode(paramFromServiceMsg.getWupBuffer());
        localBundle.putSerializable("jce", (GetResourceRespV2)((UniPacket)localObject3).getByClass("GetResourceRespV2", new GetResourceRespV2()));
      }
      localBundle.putInt("iPluginType", paramIntent.getIntExtra("iPluginType", 64));
      notifyObserver(paramIntent, 1018, paramFromServiceMsg.isSuccess(), localBundle, ServerConfigObserver.class);
      return;
      paramIntent = paramFromServiceMsg.getUin();
      paramFromServiceMsg = (HashMap)paramFromServiceMsg.getAttributes().get("keyMap");
      if ((TextUtils.isEmpty(paramIntent)) || (getAppRuntime() == null) || (!paramIntent.equals(getAppRuntime().getAccount()))) {
        break;
      }
      ((TicketManager)getAppRuntime().getManager(2)).setAlterTicket(paramFromServiceMsg);
      return;
      localObject3 = paramFromServiceMsg.getUin();
      localObject5 = (byte[])paramFromServiceMsg.getAttributes().get("da2");
      localBundle.putString("account", (String)localObject3);
      localBundle.putString("da2", new String((byte[])localObject5));
      notifyObserver(paramIntent, 1046, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
      return;
      localBundle.putString("msf_con_erro", (String)paramFromServiceMsg.getAttribute("msf_con_erro", ""));
      notifyObserver(paramIntent, 2201, paramFromServiceMsg.isSuccess(), localBundle, CheckConErroObserver.class);
      return;
      label4038:
      i += 1;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void service(Intent paramIntent)
  {
    super.service(paramIntent);
    Object localObject2;
    label1384:
    boolean bool;
    switch (paramIntent.getIntExtra("action", 0))
    {
    default: 
    case 1001: 
    case 2201: 
    case 1035: 
    case 2123: 
    case 1100: 
    case 1101: 
    case 1102: 
    case 1037: 
    case 1040: 
    case 1002: 
    case 1025: 
    case 1026: 
    case 1041: 
    case 1003: 
    case 1020: 
    case 1004: 
    case 1022: 
    case 1005: 
    case 1007: 
    case 1030: 
    case 2203: 
    case 1032: 
    case 1012: 
    case 1018: 
    case 1042: 
    case 1043: 
    case 1044: 
    case 2124: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject1 = paramIntent.getStringExtra("account");
                localObject2 = paramIntent.getByteArrayExtra("password");
                if (isQQUin((String)localObject1)) {}
                for (localObject1 = getAppRuntimegetServicemsfSub.getLoginMsg((String)localObject1, (byte[])localObject2);; localObject1 = getAppRuntimegetServicemsfSub.getChangeUinAndLoginMsg((String)localObject1, (byte[])localObject2))
                {
                  ((ToServiceMsg)localObject1).setTimeout(40000L);
                  sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                  return;
                }
                localObject1 = getAppRuntimegetServicemsfSub.getCheckMsfConErroMsg();
                ((ToServiceMsg)localObject1).setTimeout(10000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                return;
                localObject1 = paramIntent.getStringExtra("subaccount");
                localObject3 = paramIntent.getStringExtra("subpassword");
                localObject2 = paramIntent.getStringExtra("mainaccount");
                if (isQQUin((String)localObject1)) {}
                for (localObject1 = getAppRuntimegetServicemsfSub.getLoginMsg((String)localObject1, MD5.toMD5Byte((String)localObject3));; localObject1 = getAppRuntimegetServicemsfSub.getChangeUinAndLoginMsg((String)localObject1, MD5.toMD5Byte((String)localObject3)))
                {
                  ((ToServiceMsg)localObject1).addAttribute("from_where", "subaccount");
                  ((ToServiceMsg)localObject1).addAttribute("mainaccount", localObject2);
                  ((ToServiceMsg)localObject1).setTimeout(40000L);
                  sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                  return;
                }
                localObject1 = paramIntent.getStringExtra("uin");
                sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getRefreshTicketsMsg((String)localObject1));
                return;
                localObject2 = paramIntent.getStringExtra("process");
                localObject1 = paramIntent.getStringExtra("ssoAccount");
                localObject3 = paramIntent.getStringExtra("ssoPassword");
                if (isQQUin((String)localObject1)) {}
                for (localObject1 = getAppRuntimegetServicemsfSub.getLoginMsg((String)localObject1, MD5.toMD5Byte((String)localObject3));; localObject1 = getAppRuntimegetServicemsfSub.getChangeUinAndLoginMsg((String)localObject1, MD5.toMD5Byte((String)localObject3)))
                {
                  ((ToServiceMsg)localObject1).setTimeout(40000L);
                  ((ToServiceMsg)localObject1).addAttribute("from_where", "ssoAccountAction");
                  ((ToServiceMsg)localObject1).addAttribute("targetTicket", Integer.valueOf(paramIntent.getIntExtra("targetTicket", 4096)));
                  ((ToServiceMsg)localObject1).addAttribute("process", localObject2);
                  sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                  return;
                }
                localObject1 = paramIntent.getStringExtra("process");
                localObject3 = paramIntent.getStringExtra("ssoAccount");
                localObject2 = paramIntent.getStringExtra("from_where");
                localObject3 = getAppRuntimegetServicemsfSub.getLoginWithoutPasswdMsg((String)localObject3);
                ((ToServiceMsg)localObject3).addAttribute("targetTicket", Integer.valueOf(paramIntent.getIntExtra("targetTicket", 4096)));
                ((ToServiceMsg)localObject3).addAttribute("process", localObject1);
                if ((localObject2 != null) && (((String)localObject2).length() > 0))
                {
                  ((ToServiceMsg)localObject3).addAttribute("from_where", localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("builtInservert", 2, "ACTION_GET_TICKET_NO_PASSWD from_where is no null");
                  }
                }
                ((ToServiceMsg)localObject3).setTimeout(40000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject3);
                return;
                Object localObject4 = paramIntent.getStringExtra("ssoAccount");
                localObject1 = paramIntent.getByteArrayExtra("dstAppName");
                l1 = paramIntent.getLongExtra("dwDstSsoVer", 0L);
                long l2 = paramIntent.getLongExtra("dwDstAppid", 0L);
                long l3 = paramIntent.getLongExtra("dwSubDstAppid", 0L);
                localObject2 = paramIntent.getByteArrayExtra("dstAppVer");
                localObject3 = paramIntent.getByteArrayExtra("dstAppSign");
                localObject4 = getAppRuntimegetServicemsfSub.getA1WithA1((String)localObject4);
                ((ToServiceMsg)localObject4).addAttribute("dstAppName", localObject1);
                ((ToServiceMsg)localObject4).addAttribute("dwDstSsoVer", Long.valueOf(l1));
                ((ToServiceMsg)localObject4).addAttribute("dwDstAppid", Long.valueOf(l2));
                ((ToServiceMsg)localObject4).addAttribute("dwSubDstAppid", Long.valueOf(l3));
                ((ToServiceMsg)localObject4).addAttribute("dstAppVer", localObject2);
                ((ToServiceMsg)localObject4).addAttribute("dstAppSign", localObject3);
                ((ToServiceMsg)localObject4).addAttribute("fastLoginInfo", new WFastLoginInfo());
                ((ToServiceMsg)localObject4).setTimeout(40000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject4);
                return;
                localObject2 = paramIntent.getStringExtra("subaccountuin");
                localObject1 = paramIntent.getStringExtra("mainaccount");
                localObject2 = getAppRuntimegetServicemsfSub.getKeyMsg((String)localObject2);
                ((ToServiceMsg)localObject2).setTimeout(10000L);
                ((ToServiceMsg)localObject2).addAttribute("from_where", "subaccount");
                ((ToServiceMsg)localObject2).addAttribute("mainaccount", localObject1);
                sendToMSF(paramIntent, (ToServiceMsg)localObject2);
                return;
                localObject1 = new CommandCallbackerInfo();
                uin = getAppRuntime().getAccount();
                localObject2 = paramIntent.getStringArrayExtra("pushCommands");
                localObject3 = new ArrayList();
                int j = localObject2.length;
                i = 0;
                while (i < j)
                {
                  ((ArrayList)localObject3).add(localObject2[i]);
                  i += 1;
                }
                cmds = ((ArrayList)localObject3);
                sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getRegisterCmdCallMsg((CommandCallbackerInfo)localObject1));
                return;
                if (!isRegist)
                {
                  localObject1 = new CommandCallbackerInfo();
                  uin = getAppRuntime().getAccount();
                  localObject2 = paramIntent.getStringArrayExtra("pushCommands");
                  localObject3 = new ArrayList();
                  j = localObject2.length;
                  i = 0;
                  while (i < j)
                  {
                    ((ArrayList)localObject3).add(localObject2[i]);
                    i += 1;
                  }
                  cmds = ((ArrayList)localObject3);
                  sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getRegisterCmdCallMsg((CommandCallbackerInfo)localObject1));
                  isRegist = true;
                }
                localObject2 = new PushRegisterInfo();
                if (paramIntent.getBooleanExtra("kick", false))
                {
                  b = 1;
                  bKikPC = b;
                  bKikWeak = 0;
                  localObject3 = (AppRuntime.Status)paramIntent.getSerializableExtra("onlineStatus");
                  switch (1.$SwitchMap$mqq$app$AppRuntime$Status[localObject3.ordinal()])
                  {
                  default: 
                    localObject1 = new ArrayList();
                    ((ArrayList)localObject1).add(Long.valueOf(1L));
                    ((ArrayList)localObject1).add(Long.valueOf(2L));
                    ((ArrayList)localObject1).add(Long.valueOf(4L));
                    pushIds = ((ArrayList)localObject1);
                    timeStamp = getAppRuntime().getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
                    iLargeSeq = paramIntent.getLongExtra("K_SEQ", 0L);
                    uin = getAppRuntime().getAccount();
                    if (localObject3 != AppRuntime.Status.offline) {
                      break;
                    }
                  }
                }
                for (localObject1 = getAppRuntimegetServicemsfSub.getUnRegisterPushMsg((PushRegisterInfo)localObject2);; localObject1 = getAppRuntimegetServicemsfSub.getRegisterPushMsg((PushRegisterInfo)localObject2))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.contacts.", 2, "BuiltInServlet.ACTION_REGIST_MESSAGE_PUSH " + localObject3 + ", " + timeStamp + ", " + iLargeSeq);
                  }
                  sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                  return;
                  b = 0;
                  break;
                  iStatus = 11;
                  break label1384;
                  iStatus = 21;
                  break label1384;
                  iStatus = 31;
                  break label1384;
                  iStatus = 41;
                  break label1384;
                  iStatus = 95;
                  break label1384;
                }
                j = paramIntent.getIntExtra("appid", 0);
                localObject1 = paramIntent.getStringExtra("processName");
                localObject2 = paramIntent.getStringExtra("broadcastName");
                localObject4 = paramIntent.getStringArrayExtra("commands");
                localObject3 = new ArrayList();
                int k = localObject4.length;
                i = 0;
                while (i < k)
                {
                  ((ArrayList)localObject3).add(localObject4[i]);
                  i += 1;
                }
                localObject4 = new NotifyRegisterInfo();
                uin = getAppRuntime().getAccount();
                notifyIds = new ArrayList();
                notifyProperties = new HashMap();
                CommandCallbackerInfo localCommandCallbackerInfo = new CommandCallbackerInfo();
                uin = getAppRuntime().getAccount();
                cmds = ((ArrayList)localObject3);
                sendToMSF(paramIntent, MsfServiceSdk.get().getRegisterProxyMsg(j, getAppRuntime().getAccount(), (String)localObject1, (String)localObject2, (NotifyRegisterInfo)localObject4, localCommandCallbackerInfo));
                return;
                i = paramIntent.getIntExtra("appid", 0);
                sendToMSF(paramIntent, MsfServiceSdk.get().getUnRegisterProxyMsg(i, getAppRuntime().getAccount(), paramIntent.getStringExtra("processName")));
                return;
                localObject1 = paramIntent.getStringExtra("countryCode");
                localObject2 = paramIntent.getStringExtra("phoneNumber");
                localObject1 = (String)localObject1 + "-" + (String)localObject2;
                sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getRegQueryAccountMsg((String)localObject1));
              } while (!QLog.isColorLevel());
              QLog.d("queryMobile", 2, "BuiltInServlet.startQueryAccount");
              return;
              localObject2 = paramIntent.getStringExtra("countryCode");
              Object localObject3 = paramIntent.getStringExtra("phoneNumber");
              long l1 = paramIntent.getLongExtra("appid", 0L);
              localObject1 = paramIntent.getStringExtra("verifySig");
              localObject2 = (String)localObject2 + "-" + (String)localObject3;
              byte b = paramIntent.getByteExtra("language", (byte)2);
              sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getRegisterCommitMobileMsg((String)localObject1, (byte)0, b, (byte)0, "", "", (String)localObject2, Long.valueOf(l1)));
              return;
              sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getRegisterSendReSendSmsMsg());
              return;
              localObject1 = paramIntent.getStringExtra("code");
              sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getRegisterCommitSmsCodeMsg((String)localObject1));
              return;
              sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getRegisterQueryUpSmsStatMsg());
              return;
              localObject1 = paramIntent.getStringExtra("password");
              localObject2 = paramIntent.getStringExtra("nick");
              localObject3 = paramIntent.getStringExtra("code");
              bool = true;
              if (paramIntent.hasExtra("bindMobile")) {
                bool = paramIntent.getBooleanExtra("bindMobile", true);
              }
              sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getRegisterCommitPassMsg((String)localObject3, (String)localObject1, (String)localObject2, bool));
              return;
              localObject1 = paramIntent.getStringExtra("uin");
              sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getDelLoginedAccount(getAppRuntime().getAccount(), (String)localObject1));
              return;
              sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getKeyMsg(getAppRuntime().getAccount()));
              return;
              localObject1 = paramIntent.getStringExtra("uin");
              localObject2 = paramIntent.getStringExtra("cmd");
              localObject3 = paramIntent.getByteArrayExtra("busBuf");
              i = paramIntent.getIntExtra("timeout", 30000);
              l1 = paramIntent.getLongExtra("wtsdkseq", -1L);
              sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getSendWtPkgMsg((String)localObject1, l1, (String)localObject2, (byte[])localObject3, i));
              return;
              localObject1 = (HashMap)paramIntent.getSerializableExtra("mapSt");
              sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getChangeTokenAfterLoginMsg(getAppRuntime().getAccount(), 9, (HashMap)localObject1));
              return;
              b = paramIntent.getByteExtra("type", (byte)0);
              localObject1 = paramIntent.getStringExtra("content");
              sendToMSF(paramIntent, getAppRuntimegetServicemsfSub.getReportMsg(b, (String)localObject1));
              return;
              localObject1 = getAppRuntimegetServicemsfSub.getPluginConfigMsg(getAppRuntime().getAccount());
              ((ToServiceMsg)localObject1).putWupBuffer(paramIntent.getByteArrayExtra("buffer"));
              ((ToServiceMsg)localObject1).setTimeout(10000L);
              sendToMSF(paramIntent, (ToServiceMsg)localObject1);
              return;
              i = paramIntent.getIntExtra("value", 1);
              localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), "Msf.NetException");
              ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand._msf_NetException);
              ((ToServiceMsg)localObject1).addAttribute("NetExceptionType", Integer.valueOf(i));
              ((ToServiceMsg)localObject1).setNeedCallback(false);
            } while (localObject1 == null);
            if (QLog.isColorLevel()) {
              QLog.d("MSFServlet", 2, "ACTION_NET_EXCEPTION_EVENT send msgnow " + ((ToServiceMsg)localObject1).getServiceCmd());
            }
            sendToMSF(paramIntent, (ToServiceMsg)localObject1);
            return;
            if (QLog.isDevelopLevel()) {
              QLog.d("MSFServlet", 4, "WIRELESS_PSWREQ:");
            }
            i = paramIntent.getIntExtra("cmd", 1);
            localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), "KsidTrans.Trans");
            ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.SEND_WIRELESS_PSWREQ);
            ((ToServiceMsg)localObject1).addAttribute("cmd", Integer.valueOf(i));
            ((ToServiceMsg)localObject1).setNeedCallback(false);
          } while (localObject1 == null);
          if (QLog.isColorLevel()) {
            QLog.d("MSFServlet", 2, "ACTION_SEND_WIRELESS_PSWREQ send msgnow " + ((ToServiceMsg)localObject1).getServiceCmd());
          }
          sendToMSF(paramIntent, (ToServiceMsg)localObject1);
          return;
          int i = paramIntent.getIntExtra("cmd", 1);
          localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), "PwdProtect.DataUpload");
          ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.SEND_WIRELESS_MEIBAOREQ);
          ((ToServiceMsg)localObject1).addAttribute("cmd", Integer.valueOf(i));
          ((ToServiceMsg)localObject1).setNeedCallback(false);
        } while (localObject1 == null);
        if (QLog.isColorLevel()) {
          QLog.d("MSFServlet", 2, "ACTION_SEND_WIRELESS_MEIBAOREQ send msgnow " + ((ToServiceMsg)localObject1).getServiceCmd());
        }
        sendToMSF(paramIntent, (ToServiceMsg)localObject1);
        return;
        localObject1 = paramIntent.getStringExtra("uin");
        localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject1, "");
        ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.getAlterTickets);
        ((ToServiceMsg)localObject1).setNeedCallback(true);
      } while (localObject1 == null);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    case 2200: 
      if (QLog.isColorLevel()) {
        QLog.d("MSFServlet", 2, "ACTION_UNGUARD_APP send now");
      }
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), null, "");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.gm_GuardEvent);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      ((ToServiceMsg)localObject1).addAttribute("k_event", Integer.valueOf(paramIntent.getIntExtra("k_event", 0)));
      ((ToServiceMsg)localObject1).addAttribute("k_arg0", Long.valueOf(paramIntent.getLongExtra("k_arg0", 0L)));
      ((ToServiceMsg)localObject1).addAttribute("k_arg1", Long.valueOf(paramIntent.getLongExtra("k_arg1", 0L)));
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    case 2126: 
      localObject2 = paramIntent.getStringExtra("uin");
      localObject1 = paramIntent.getStringExtra("src");
      localObject2 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject2, "");
      ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.startPCActivePolling);
      ((ToServiceMsg)localObject2).getAttributes().put("src", localObject1);
      ((ToServiceMsg)localObject2).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject2);
      return;
    case 2127: 
      localObject2 = paramIntent.getStringExtra("uin");
      localObject1 = paramIntent.getStringExtra("src");
      localObject2 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject2, "");
      ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.stopPCActivePolling);
      ((ToServiceMsg)localObject2).getAttributes().put("src", localObject1);
      ((ToServiceMsg)localObject2).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject2);
      return;
    case 2128: 
      localObject2 = paramIntent.getStringExtra("uin");
      localObject1 = paramIntent.getStringExtra("src");
      bool = paramIntent.getBooleanExtra("opened", false);
      localObject2 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject2, "");
      ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.openPCActive);
      ((ToServiceMsg)localObject2).getAttributes().put("src", localObject1);
      ((ToServiceMsg)localObject2).getAttributes().put("opened", Boolean.valueOf(bool));
      ((ToServiceMsg)localObject2).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject2);
      return;
    case 2202: 
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_msgsignal);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    }
    Object localObject1 = paramIntent.getStringExtra("account");
    localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject1, "login.chgTok_DA2");
    ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_refreshDA2);
    ((ToServiceMsg)localObject1).setNeedCallback(true);
    sendToMSF(paramIntent, (ToServiceMsg)localObject1);
  }
}
