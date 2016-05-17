package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentMsgBoxItem
  extends RecentBaseData
{
  MessageRecord a;
  public boolean a;
  
  public RecentMsgBoxItem(MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = false;
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentDatingBoxItem data is null");
    }
    jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    if (a() == 7100) {
      M |= 0x200000;
    }
  }
  
  public int a()
  {
    return jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
  }
  
  public long a()
  {
    return jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
  }
  
  public String a()
  {
    return jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject1 = null;
    Object localObject3 = paramQQAppInterface.a();
    Object localObject2 = paramQQAppInterface.a();
    if (localObject3 != null) {
      localObject1 = ((QQMessageFacade)localObject3).a(a(), a());
    }
    int k;
    int m;
    int j;
    int i;
    if (localObject1 != null)
    {
      jdField_b_of_type_Long = time;
      if (localObject2 != null)
      {
        H = ((ConversationFacade)localObject2).a(frienduin, istroop);
        if ((localObject1 != null) && (MsgProxyUtils.c((MessageRecord)localObject1))) {
          G = 3;
        }
        localObject3 = a();
        jdField_a_of_type_Boolean = false;
        k = 0;
        m = 0;
        j = m;
        i = k;
        if (localObject2 == null) {
          break label831;
        }
        j = m;
        i = k;
        if (localObject1 == null) {
          break label831;
        }
        if (((QQMessageFacade.Message)localObject1).isSend()) {
          break label567;
        }
        m = ((ConversationFacade)localObject2).e(a(), 1001);
        j = m;
        i = k;
        if (m != 0) {
          break label831;
        }
        k = ((ConversationFacade)localObject2).d(a(), 1001);
        j = m;
        i = k;
        if (k > 0) {
          break label831;
        }
        j = ((ConversationFacade)localObject2).a((MessageRecord)localObject1);
        i = m;
      }
    }
    for (;;)
    {
      label213:
      if (i > 0)
      {
        jdField_c_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131371653);
        K = paramContext.getResources().getColor(2131428234);
        jdField_b_of_type_JavaLangCharSequence = ((ConversationFacade)localObject2).a(a(), 1001, paramContext.getResources().getString(2131371654), 0);
        label270:
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_boxitem", 2, "boxUin" + a() + ",boxType" + a() + ",unreadNum:" + H + ",unReadGiftCount:" + k + ",lastMsgReadedGiftCount:" + j + ",unReadRedPacketCount:" + i);
        }
        localObject2 = ContactUtils.o(paramQQAppInterface, a());
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = ContactUtils.b(paramQQAppInterface, a(), false);
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = a();
        }
        jdField_a_of_type_JavaLangString = ((String)localObject2);
        if (a() != 7100) {
          break label756;
        }
        I = 2130838643;
        label430:
        a(paramQQAppInterface);
        a(paramQQAppInterface, (MsgSummary)localObject3);
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        if (!AppSetting.i) {
          break;
        }
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(jdField_a_of_type_JavaLangString);
        if (H != 0) {
          break label764;
        }
      }
      for (;;)
      {
        if (jdField_c_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(jdField_c_of_type_JavaLangCharSequence + ",");
        }
        paramQQAppInterface.append(jdField_b_of_type_JavaLangCharSequence).append(' ').append(jdField_b_of_type_JavaLangString);
        jdField_c_of_type_JavaLangString = paramQQAppInterface.toString();
        return;
        H = 0;
        break;
        H = 0;
        jdField_b_of_type_Long = 0L;
        break;
        label567:
        j = ((ConversationFacade)localObject2).a((MessageRecord)localObject1);
        i = 0;
        k = 0;
        break label213;
        if ((k > 0) || (j > 0))
        {
          if (k > 0)
          {
            jdField_a_of_type_Boolean = true;
            jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131371713, new Object[] { "", Integer.valueOf(k) });
            K = paramContext.getResources().getColor(2131428234);
            break label270;
          }
          if (j <= 0) {
            break label270;
          }
          jdField_a_of_type_Boolean = true;
          if (!((QQMessageFacade.Message)localObject1).isSend()) {}
          for (jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131371713, new Object[] { "", Integer.valueOf(j) });; jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131371715, new Object[] { Integer.valueOf(j) }))
          {
            K = paramContext.getResources().getColor(2131428212);
            break;
          }
        }
        jdField_c_of_type_JavaLangCharSequence = "";
        a((QQMessageFacade.Message)localObject1, a(), paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        break label270;
        label756:
        I = 0;
        break label430;
        label764:
        if (H == 1) {
          paramQQAppInterface.append("有一条未读");
        } else if (H == 2) {
          paramQQAppInterface.append("有两条未读");
        } else if (H > 0) {
          paramQQAppInterface.append("有").append(H).append("条未读");
        }
      }
      label831:
      m = 0;
      k = i;
      i = j;
      j = m;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {}
    long l;
    do
    {
      do
      {
        do
        {
          return;
          jdField_a_of_type_Boolean = false;
          d = null;
          paramQQAppInterface = paramQQAppInterface.a();
        } while (paramQQAppInterface == null);
        paramQQAppInterface = paramQQAppInterface.a(a(), a());
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
      l = paramQQAppInterface.getTime();
    } while (jdField_b_of_type_Long > l);
    jdField_b_of_type_Long = l;
    jdField_a_of_type_Boolean = true;
    d = new QQText(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public long b()
  {
    return 0L;
  }
}
