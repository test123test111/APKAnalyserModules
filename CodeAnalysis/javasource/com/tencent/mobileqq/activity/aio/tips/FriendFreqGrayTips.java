package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.Time;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FriendFreqGrayTips
  implements GrayTipsTask
{
  private static final String jdField_a_of_type_JavaLangString = FriendFreqGrayTips.class.getSimpleName();
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FriendFreqGrayTips(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, SessionInfo paramSessionInfo, ChatAdapter1 paramChatAdapter1)
  {
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
  }
  
  public int a()
  {
    return 1000;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(64522);
    long l = MessageCache.a();
    String str = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramVarArgs.init(str, jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", l, 64522, jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
    isread = true;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1001) {}
    int i;
    boolean bool1;
    label261:
    int j;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    for (;;)
    {
      return;
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent(): TYPE_ON_MSG_SENT_RECV ===>");
          }
          if (jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
            return;
          }
          localObject1 = QQOperateManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((QQOperateManager)localObject1).b(jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2)) {
            return;
          }
          localList = jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
          if (localList == null) {
            return;
          }
          i = localList.size();
          paramInt = i - 1;
        }
        finally
        {
          Object localObject1;
          List localList;
          long l1;
          SharedPreferences localSharedPreferences;
          Object localObject2;
          String str;
          int k;
          int m;
          int n;
          long l2;
          long l3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "step is:" + "");
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "findExcludeMsg :" + bool1);
        }
        if (!bool1) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "step is:" + "findExcludeMsg, just return");
        return;
        if (getmsgtype != 64493) {
          break label1625;
        }
        bool1 = true;
      }
      if (localList.size() < 10)
      {
        paramVarArgs = "aioMsgList msg num = " + localList.size();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "step is:" + paramVarArgs);
        }
      }
      else
      {
        l1 = MessageCache.a() * 1000L;
        if (jdField_a_of_type_AndroidTextFormatTime == null) {
          jdField_a_of_type_AndroidTextFormatTime = new Time();
        }
        jdField_a_of_type_AndroidTextFormatTime.set(l1);
        paramInt = jdField_a_of_type_AndroidTextFormatTime.year;
        i = jdField_a_of_type_AndroidTextFormatTime.month;
        j = jdField_a_of_type_AndroidTextFormatTime.monthDay;
        paramVarArgs = "voice_chat_freq_tip_msg_insert_time" + jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
        localObject2 = localSharedPreferences.getString(paramVarArgs, "");
        if (QLog.isColorLevel())
        {
          str = paramInt + "-" + i + "-" + j;
          QLog.d(jdField_a_of_type_JavaLangString, 2, "currDate is:" + str + ",curr hour is:" + jdField_a_of_type_AndroidTextFormatTime.hour + ",chatFreqTipMsgInsertTime is:" + (String)localObject2);
        }
        if ((localObject2 != null) && (((String)localObject2).trim().length() > 0))
        {
          jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong((String)localObject2));
          k = jdField_a_of_type_AndroidTextFormatTime.year;
          m = jdField_a_of_type_AndroidTextFormatTime.month;
          n = jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((paramInt == k) && (i == m) && (j == n))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "step is:" + "already insert chat frequent tip msg this day when insert chat frequent tip msg");
            return;
          }
        }
        localObject2 = localSharedPreferences.getString("voice_keyword_tip_msg_insert_time" + jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "");
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "multiKeywordTipMsgInsertTime is:" + (String)localObject2);
        }
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localObject2 = ((String)localObject2).split("\\|");
          jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong(localObject2[(localObject2.length - 1)]));
          k = jdField_a_of_type_AndroidTextFormatTime.year;
          m = jdField_a_of_type_AndroidTextFormatTime.month;
          n = jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((paramInt == k) && (i == m) && (j == n))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "step is:" + "already insert keyword tip msg this day");
            return;
          }
        }
        if (!NetworkUtil.h(BaseApplication.getContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "step is:" + "network is not wifi");
          }
        }
        else
        {
          localObject2 = ((FriendsManager)jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (localObject2 == null)
          {
            paramVarArgs = "can not obtain friend by uin " + jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "step is:" + paramVarArgs);
            }
          }
          else if ((abilityBits & 1L) == 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "step is:" + "friend's qq version<4.6 or friend online status is not online or network that friend use is not wifi or 3g or 4g");
            }
          }
          else
          {
            k = ((Friends)localObject2).getNetWorkType();
            if (k == 2)
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "step is:" + "");
              }
            }
            else
            {
              jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 20, j, i, paramInt);
              l2 = jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
              jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 23, j, i, paramInt);
              l3 = jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
              if ((l1 < l2) || (l1 > l3))
              {
                paramVarArgs = "current time not in " + 20 + "-" + 23;
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "step is:" + paramVarArgs);
                }
              }
              else
              {
                l2 = (l1 - 600000L) / 1000L;
                paramInt = localList.size();
                i = 0;
                bool2 = false;
                bool3 = false;
                bool1 = false;
                paramInt -= 1;
                if (paramInt >= 0)
                {
                  localObject2 = (ChatMessage)localList.get(paramInt);
                  if (time >= l2)
                  {
                    bool4 = bool3;
                    bool5 = bool2;
                    j = i;
                    if (MsgProxyUtils.l(msgtype))
                    {
                      bool4 = bool3;
                      bool5 = bool2;
                      j = i;
                      if (extraflag == 0)
                      {
                        if (((ChatMessage)localObject2).isSend()) {
                          break label1666;
                        }
                        bool2 = true;
                        break label1632;
                      }
                    }
                    label1331:
                    if (!MsgProxyUtils.n(msgtype)) {
                      break;
                    }
                    bool1 = true;
                    break;
                  }
                }
                if ((i >= 10) && (bool2) && (bool3) && (!bool1))
                {
                  if (!jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0])) {
                    break label1592;
                  }
                  ((QQOperateManager)localObject1).a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2);
                  localObject1 = localSharedPreferences.edit();
                  ((SharedPreferences.Editor)localObject1).putString(paramVarArgs, String.valueOf(l1));
                  ((SharedPreferences.Editor)localObject1).commit();
                  ReportController.b(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Msg_call_tips", 0, 0, "", "", "", "");
                  paramVarArgs = "insert friend chat frequent tip msg success";
                }
                while (QLog.isColorLevel())
                {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "step is:" + paramVarArgs);
                  return;
                  paramVarArgs = "sendRecvMsgNum is:" + i + ",hasOneRecv is:" + bool2 + ",hasOneSend is:" + bool3 + ",hasVideoMsg is:" + bool1;
                  continue;
                  label1592:
                  paramVarArgs = "";
                }
              }
            }
          }
        }
      }
    }
    break label1648;
    label1625:
    label1630:
    for (;;)
    {
      bool1 = false;
      break;
      for (;;)
      {
        if (paramInt < 0) {
          break label1630;
        }
        if (paramInt >= i - 10) {
          break label261;
        }
        bool1 = false;
        break;
        paramInt -= 1;
      }
    }
    for (;;)
    {
      label1632:
      j = i + 1;
      bool4 = bool3;
      bool5 = bool2;
      break label1331;
      label1648:
      paramInt -= 1;
      bool3 = bool4;
      bool2 = bool5;
      i = j;
      break;
      label1666:
      bool3 = true;
    }
  }
  
  public int[] a()
  {
    return new int[] { 5 };
  }
}
