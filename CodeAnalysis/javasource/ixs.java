import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.report.ReportCenter;

public class ixs
  implements View.OnClickListener
{
  public ixs(ForwardRecentActivity paramForwardRecentActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString("uin", String.valueOf(AppConstants.at));
    paramView.putInt("uintype", -1);
    paramView.putBoolean("forward_report_confirm", true);
    paramView.putString("forward_report_confirm_action_name", "0X8005A13");
    paramView.putString("forward_report_confirm_reverse2", "2");
    a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.g.intValue(), paramView);
    if (a.jdField_a_of_type_Boolean) {
      ReportCenter.a().a(a.app.getAccount(), "", a.k, "1000", "35", "0", false);
    }
  }
}
