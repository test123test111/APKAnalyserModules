package mqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.Action;

public abstract class SubAccountObserver
  implements BusinessObserver, Constants.Action
{
  public SubAccountObserver() {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3) {}
  
  protected void onGetSidBack(String paramString1, String paramString2, String paramString3) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onLoginSuccess(String paramString1, String paramString2, String paramString3) {}
  
  protected void onLoginTimeout(String paramString1, String paramString2, String paramString3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    case 1036: 
    default: 
      return;
    case 1035: 
      paramInt = paramBundle.getInt("code");
      str1 = paramBundle.getString("alias");
      str2 = paramBundle.getString("uin");
      String str3 = paramBundle.getString("submainaccount");
      QLog.d("mqq", 2, "SubAccountObserver onReceive ACTION_SUBACCOUNT_LOGIN  isSuccess = " + paramBoolean);
      if (paramBoolean)
      {
        onLoginSuccess(str3, str2, str1);
        return;
      }
      if ((paramInt == 1002) || (paramInt == 1013))
      {
        onLoginTimeout(str3, str2, str1);
        return;
      }
      if (paramInt == 2006)
      {
        onUserCancel(str3, str2, str1);
        return;
      }
      onLoginFailed(str3, str2, str1, paramBundle.getString("error"));
      return;
    }
    String str1 = paramBundle.getString("uin");
    paramBundle.getString("error");
    paramBundle.getInt("code");
    String str2 = paramBundle.getString("subaccountA2");
    onGetKeyBack(paramBundle.getString("mainaccount"), str1, str2);
  }
  
  protected void onUserCancel(String paramString1, String paramString2, String paramString3) {}
}
