package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.antiphing.UinFraudInfo;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import lmt;
import lmv;
import mqq.os.MqqHandler;

public class FraudTipsBar
  implements TipsBarTask
{
  private static final String jdField_a_of_type_JavaLangString = FraudTipsBar.class.getSimpleName();
  private static final int b = 0;
  private static final int c = 1;
  private static final int d = 2;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FraudTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Context paramContext, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler)
  {
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    jdField_a_of_type_AndroidContentContext = paramContext;
    jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a(Object... paramVarArgs)
  {
    View localView = LayoutInflater.from(jdField_a_of_type_AndroidContentContext).inflate(2130904368, null);
    TextView localTextView = (TextView)localView.findViewById(2131302366);
    String str = (String)paramVarArgs[0];
    int i = ((Integer)paramVarArgs[1]).intValue();
    localTextView.setText(str);
    localView.setOnClickListener(new lmv(this, i));
    return localView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "check() : ");
    }
    if (jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {}
    for (;;)
    {
      return;
      if (jdField_a_of_type_Int != 0)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mAntiFraudTips is showing or has shown");
        return;
      }
      try
      {
        l = Long.parseLong(jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (l == 0L) {
          continue;
        }
        if (!jdField_a_of_type_Boolean)
        {
          jdField_a_of_type_Boolean = true;
          if (UinFraudInfo.a().a(l))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "uin cache is out of date, update it! ");
            }
            ((FriendListHandler)jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a("OidbSvc.0x476_146", (int)l, 146);
          }
        }
        int i = UinFraudInfo.a().a(l);
        if (i == 0) {
          continue;
        }
        AntiFraudConfigFileUtil.a().a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SecWarningCfg");
        Object localObject = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerWording", 146, i);
        if (localObject != null)
        {
          localObject = ((Bundle)localObject).getString("BannerWording");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          if (!jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[] { localObject, Integer.valueOf(i) })) {
            continue;
          }
          jdField_a_of_type_Int = 1;
          ReportController.b(null, "P_CliOper", "Safe_AntiFraud", jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "banner", "display", i, 0, "", "", "", "");
          Timer localTimer = new Timer();
          lmt localLmt = new lmt(this);
          localObject = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerTTL", 146, i);
          if (localObject != null)
          {
            localObject = ((Bundle)localObject).getString("BannerTTL");
            try
            {
              i = Integer.parseInt((String)localObject);
              l = i;
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                localThrowable2.printStackTrace();
                l = 15L;
              }
            }
            l *= 1000L;
            if (l <= 0L) {
              continue;
            }
            localTimer.schedule(localLmt, l);
            return;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localThrowable1.printStackTrace();
          long l = 0L;
          continue;
          String str = "0";
          continue;
          str = null;
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
    }
    a();
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 50;
  }
}
