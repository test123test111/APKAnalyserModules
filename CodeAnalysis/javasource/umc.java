import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QlinkShareJumpActivity;

public class umc
  implements DialogInterface.OnClickListener
{
  public umc(QlinkShareJumpActivity paramQlinkShareJumpActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    a.finish();
  }
}
