import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;

public class ndq
  extends FriendListObserver
{
  public ndq(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QQAppInterface.jdField_a_of_type_JavaLangString + "_friendListObserver", 2, "onUpdateFriendInfo uin:" + paramString + ",isSuccess:" + paramBoolean);
    }
    if (a.jdField_a_of_type_JavaUtilSet.contains(paramString))
    {
      if ((a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b() == 1) && (paramString != null) && (paramString.equals(a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().get(0)).frienduin)) && (a.isBackground_Pause) && (a.f()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(QQAppInterface.jdField_a_of_type_JavaLangString + "_friendListObserver", 2, "update notifcation");
        }
        QQAppInterface.a(a, (QQMessageFacade.Message)a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().get(0), false);
      }
      a.jdField_a_of_type_JavaUtilSet.remove(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d(QQAppInterface.jdField_a_of_type_JavaLangString + "_friendListObserver", 2, "removeObserver");
    }
    a.b(this);
  }
}
