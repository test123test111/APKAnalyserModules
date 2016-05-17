import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class kxv
  extends ClickableSpan
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference b;
  
  public kxv(GrayTipsItemBuilder paramGrayTipsItemBuilder, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    b = new WeakReference(paramContext);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (Context)b.get();
    if ((paramView == null) || (localObject == null)) {}
    long l;
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof Activity));
      if (!NetworkUtil.e((Context)localObject))
      {
        QQToast.a((Context)localObject, 2131366990, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131492908));
        return;
      }
      l = System.currentTimeMillis();
      if ((GrayTipsItemBuilder.a(jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder) == 0L) || (l <= GrayTipsItemBuilder.a(jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder)) || (l - GrayTipsItemBuilder.a(jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder) > 800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
    return;
    GrayTipsItemBuilder.a(jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder, l);
    if (NetworkUtil.h((Context)localObject))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(DownloadConstants.a, "100868074");
      localBundle.putString(DownloadConstants.i, "http://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
      localBundle.putString(DownloadConstants.e, "com.sohu.inputmethod.sogou");
      localBundle.putInt(DownloadConstants.j, 2);
      localBundle.putString(DownloadConstants.h, "ANDROIDQQ.MSG.SOUGOU");
      localBundle.putString(DownloadConstants.k, "搜狗输入法");
      localBundle.putBoolean(DownloadConstants.w, false);
      DownloadApi.a((Activity)localObject, localBundle, 0, null, 0);
    }
    for (;;)
    {
      ReportController.b(paramView, "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
      return;
      localObject = JumpParser.a(paramView, (Context)localObject, "qapp://detail?param=" + GrayTipsItemBuilder.a("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU"));
      if (localObject != null) {
        ((JumpAction)localObject).b();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}
