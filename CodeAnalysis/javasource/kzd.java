import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.TransFileController.OnCancelListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class kzd
  implements TransFileController.OnCancelListener
{
  public kzd(PicItemBuilder paramPicItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, false);
      if (QLog.isColorLevel()) {
        QLog.d("cancelpic", 2, "remove pic:" + uniseq);
      }
    }
    ((FragmentActivity)a.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a(196612);
  }
}