import android.content.Intent;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.transfile.ShortVideoUploadABTest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class moh
  implements Runnable
{
  Intent jdField_a_of_type_AndroidContentIntent;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  boolean jdField_a_of_type_Boolean;
  
  public moh(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if (paramIntent != null) {}
    for (jdField_a_of_type_AndroidContentIntent = paramIntent;; jdField_a_of_type_AndroidContentIntent = jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent())
    {
      jdField_a_of_type_Boolean = jdField_a_of_type_AndroidContentIntent.getExtras().getBoolean("send_in_background");
      return;
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, "#SendTask# run(): start");
    }
    SendVideoActivity.a(jdField_a_of_type_AndroidContentIntent);
    CodecParam.B = jdField_a_of_type_AndroidContentIntent.getIntExtra("sv_total_frame_count", 0);
    CodecParam.A = jdField_a_of_type_AndroidContentIntent.getIntExtra("sv_total_record_time", 0);
    long l1 = jdField_a_of_type_AndroidContentIntent.getLongExtra("ab_test_send_btn_click_time", 0L);
    long l2 = jdField_a_of_type_AndroidContentIntent.getLongExtra("ab_test_generate_thumb_cost_time", 0L);
    if (ShortVideoUploadABTest.a())
    {
      ShortVideoUploadABTest.b = l1;
      ShortVideoUploadABTest.c = CodecParam.A;
      ShortVideoUploadABTest.d = l2;
    }
    com.tencent.mobileqq.transfile.ShortVideoPresendStats.b = l1;
    String str = jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_send_path");
    if (FileUtils.b(str))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(new File(str), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).downloadImediatly();
      if (((URLDrawable)localObject).getStatus() == 1) {
        jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new moi(this));
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendVideoActivity", 2, "#SendTask# run(): UrlDrawable status not success, path=" + str);
        }
      } while (jdField_a_of_type_Boolean);
      jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new moj(this));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SendVideoActivity", 2, "#SendTask# run(): thumb not exist, path=" + str);
      }
    } while (jdField_a_of_type_Boolean);
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new mok(this));
  }
}