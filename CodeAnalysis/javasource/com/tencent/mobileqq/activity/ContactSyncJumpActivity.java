package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.contactsync.SimplePhoneContact;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import ipo;
import ipp;
import ipq;
import ipr;
import ips;
import java.util.ArrayList;

public class ContactSyncJumpActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a = "key_req_by_contact_sync";
  public static final String b = "key_uin_to_login";
  private static final int c = 1000;
  public static final String c = "key_req_from_switch_account";
  private static final int d = 4;
  public static final String d = "key_req_from_lock_screen";
  private static final int e = 0;
  public static final String e = "key_orginal_intent";
  private static final int f = 1;
  public static final String f = "key_change";
  private static final int jdField_g_of_type_Int = 2;
  private static final String jdField_g_of_type_JavaLangString = "ContactSync.JumpActivity";
  public int a;
  public Dialog a;
  private DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private ContactSyncManager jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private int b;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  
  public ContactSyncJumpActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidOsHandler$Callback = new ipo(this);
    jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ipp(this);
    jdField_a_of_type_AndroidOsHandler = new ipq(this);
    jdField_a_of_type_AndroidAppDialog = null;
    jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new ipr(this);
    jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new ips(this);
  }
  
  private Dialog a()
  {
    Dialog localDialog = new Dialog(this, 2131558942);
    localDialog.setContentView(2130904048);
    Object localObject2 = (ImageView)localDialog.findViewById(2131301064);
    if (k.equals("0")) {}
    for (Object localObject1 = FaceDrawable.a(app, 11, i + j);; localObject1 = FaceDrawable.a(app, 1, k))
    {
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      Object localObject3 = (TextView)localDialog.findViewById(2131301065);
      localObject1 = (TextView)localDialog.findViewById(2131301066);
      TextView localTextView = (TextView)localDialog.findViewById(2131301062);
      localObject2 = (TextView)localDialog.findViewById(2131301063);
      ((TextView)localObject3).setText(l);
      localTextView.setText(2131370827);
      localTextView.setOnClickListener(this);
      ((TextView)localObject2).setText(String.format(getResources().getString(2131370835), new Object[] { "" }));
      if (!NetworkUtil.e(this)) {
        break;
      }
      localObject3 = getResources().getDrawable(2130838193);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject3, null, null, null);
      ((TextView)localObject1).setCompoundDrawablePadding(10);
      ((Animatable)localObject3).start();
      ((TextView)localObject2).setOnClickListener(this);
      return localDialog;
    }
    ((TextView)localObject1).setText(2131370837);
    ((TextView)localObject2).setTextColor(getResources().getColor(2131427490));
    ((TextView)localObject2).setEnabled(false);
    return localDialog;
  }
  
  private Dialog a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Dialog localDialog = new Dialog(this, 2131558942);
    localDialog.setContentView(2130904047);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131301060);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131301061);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131301062);
    TextView localTextView4 = (TextView)localDialog.findViewById(2131301063);
    localTextView1.setText(paramInt1);
    localTextView2.setText(paramString);
    if (paramInt2 == 0) {
      localTextView3.setVisibility(8);
    }
    for (;;)
    {
      localTextView4.setText(paramInt3);
      localTextView3.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      return localDialog;
      localTextView3.setText(paramInt2);
    }
  }
  
  private void a()
  {
    ReportController.b(app, "CliOper", "", "", "System_contact", "Contact_msg", 0, 0, "", "", "", "");
    if (!k.equals("0"))
    {
      localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtra("uin", k);
      localObject = (FriendsManager)app.getManager(50);
      if (localObject != null)
      {
        localObject = ((FriendsManager)localObject).c(k);
        if (localObject != null)
        {
          localIntent.putExtra("cSpecialFlag", cSpecialFlag);
          localIntent.putExtra("uinname", ContactUtils.a((Friends)localObject));
          if (cSpecialFlag == 1)
          {
            localIntent.setClass(this, SplashActivity.class);
            localIntent.putExtra("chat_subType", 1);
          }
        }
      }
      localIntent.putExtra("entrance", 0);
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("key_req_by_contact_sync", true);
      startActivity(localIntent);
      finish();
      return;
    }
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("entrance", 0);
    localIntent.putExtra("uin", i + j);
    localIntent.putExtra("uintype", 1006);
    localIntent.putExtra("uinname", l);
    Object localObject = new ProfileActivity.AllInOne(i + j, 31);
    a = new ArrayList();
    k = l;
    a.add(new ProfileActivity.CardContactInfo(l, j, i));
    d = b;
    g = 59;
    localIntent.putExtra("AIO_INFO", (Parcelable)localObject);
    localIntent.putExtra("key_req_by_contact_sync", true);
    startActivity(localIntent);
    finish();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.JumpActivity", 2, "showAlertDialog | type = " + paramInt + " | current type = " + jdField_a_of_type_Int);
    }
    if (jdField_a_of_type_AndroidAppDialog != null)
    {
      jdField_a_of_type_AndroidAppDialog.dismiss();
      jdField_a_of_type_AndroidAppDialog = null;
    }
    jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (jdField_a_of_type_AndroidAppDialog != null)
      {
        jdField_a_of_type_AndroidAppDialog.setOnCancelListener(jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
        jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
      jdField_a_of_type_AndroidAppDialog = a(2131370823, paramString, 2131370827, 2131370828);
      continue;
      jdField_a_of_type_AndroidAppDialog = a(2131370830, paramString, 0, 2131370832);
      continue;
      jdField_a_of_type_AndroidAppDialog = a();
    }
  }
  
  private boolean a(int paramInt)
  {
    String str2 = jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a();
    String str3 = app.a();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.JumpActivity", 2, "dealWithUnbind | syncUin = " + ContactSyncManager.b(str2) + " | loginUin = " + ContactSyncManager.b(str3) + " | bindState = " + paramInt);
    }
    if ((paramInt == 2) || (paramInt == 1) || (paramInt == 0)) {}
    for (String str1 = getResources().getString(2131370824);; str1 = getResources().getString(2131370825))
    {
      a(0, String.format(str1, new Object[] { ContactSyncManager.d(str3), ContactSyncManager.d(str2) }));
      return true;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = getIntent();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.JumpActivity", 2, "doJump | intent = " + localObject);
    }
    if (localObject != null) {
      try
      {
        if ((!TextUtils.isEmpty(((Intent)localObject).getAction())) || (((Intent)localObject).getBooleanExtra("key_req_from_switch_account", false)) || (((Intent)localObject).getBooleanExtra("key_req_from_lock_screen", false))) {
          if (((Intent)localObject).getBooleanExtra("key_req_from_switch_account", false))
          {
            if (!((Intent)localObject).getBooleanExtra("key_change", false))
            {
              finish();
              return false;
            }
            localObject = getIntent().getParcelableExtra("key_orginal_intent");
            if ((localObject == null) || (!(localObject instanceof Intent)))
            {
              finish();
              return false;
            }
            setIntent((Intent)localObject);
          }
        }
        while ((paramBoolean) && (!app.isLogin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.JumpActivity", 2, "doJump | check user is not login");
          }
          localObject = new Intent(this, LoginActivity.class);
          ((Intent)localObject).putExtra("key_req_by_contact_sync", true);
          ((Intent)localObject).putExtra("key_orginal_intent", getIntent());
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).addFlags(536870912);
          startActivity((Intent)localObject);
          finish();
          return false;
          if (((Intent)localObject).getBooleanExtra("key_req_from_lock_screen", false))
          {
            localObject = getIntent().getParcelableExtra("key_orginal_intent");
            if ((localObject == null) || (!(localObject instanceof Intent)))
            {
              finish();
              return false;
            }
            setIntent((Intent)localObject);
            continue;
            return false;
          }
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump", localException1);
        }
      }
    }
    if ((GesturePWDUtils.getJumpLock(this, app.a())) && (!GesturePWDUtils.getAppForground(this)))
    {
      Intent localIntent = new Intent(this, GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_req_by_contact_sync", true);
      localIntent.putExtra("key_orginal_intent", getIntent());
      startActivity(localIntent);
      finish();
      return false;
    }
    jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)app.getManager(10));
    jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager = ((ContactSyncManager)app.getManager(40));
    int n;
    String str;
    try
    {
      m = jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a(getIntent().getData());
      if ((m == null) || ((!m.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat")) && (!m.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.voicecall.profile"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump | error mimeType = " + m);
        }
        finish();
        return false;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump | e = ", localException2);
        }
      }
      h = jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.b(getIntent().getData());
      n = jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
      str = jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.JumpActivity", 2, "doJump | check user is login | bind state is " + n + " | currentUin = " + ContactSyncManager.b(app.a()) + " | syncUin = " + ContactSyncManager.b(str));
      }
      if (n != 0) {
        break label657;
      }
    }
    if (str.equals(app.a())) {
      return b();
    }
    for (;;)
    {
      return a(n);
      label657:
      do
      {
        if ((jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c()) || (str.equals(app.a()))) {
          return b();
        }
        paramBoolean = a(n);
        return paramBoolean;
        if ((n == 2) || (n == 1)) {
          break;
        }
      } while (n != 0);
    }
  }
  
  private void b()
  {
    String str;
    if (!k.equals("0"))
    {
      n = 1;
      QQAppInterface localQQAppInterface = app;
      if (n == 0) {
        break label125;
      }
      str = "0";
      label26:
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "16", str, "", "");
      if (n == 0) {
        break label132;
      }
    }
    label125:
    label132:
    for (int n = 0;; n = 1006)
    {
      str = i + j;
      if (ChatActivityUtils.a(app, this, n, k, l, str, true, null, true, true, jdField_a_of_type_AndroidOsHandler$Callback, "from_app_contact")) {
        finish();
      }
      return;
      n = 0;
      break;
      str = "3";
      break label26;
    }
  }
  
  private boolean b()
  {
    boolean bool2 = true;
    app.registObserver(jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    Uri localUri = getIntent().getData();
    if (!TextUtils.isEmpty(h)) {}
    for (Object localObject = jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(h);; localObject = null)
    {
      boolean bool1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("dealWithBindOK | getTargetPhoneContact | uri = ").append(localUri).append(" | mobileNo = ").append(ContactSyncManager.c(h)).append(" | pc = ");
        if (localObject != null)
        {
          bool1 = true;
          QLog.d("ContactSync.JumpActivity", 2, bool1);
        }
      }
      else
      {
        if (localObject == null) {
          break label215;
        }
        k = uin;
        i = nationCode;
        j = mobileCode;
        l = name;
        b = ability;
        label157:
        if (((TextUtils.isEmpty(k)) || (k.equals("0"))) && (TextUtils.isEmpty(j))) {
          break label371;
        }
        if (!m.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat")) {
          break label302;
        }
        a();
        bool1 = false;
      }
      label215:
      label302:
      do
      {
        return bool1;
        bool1 = false;
        break;
        localObject = jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a(localUri);
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "dealWithBindOK | pc is null | simplePc = " + localObject);
        }
        if (localObject == null) {
          break label157;
        }
        k = "0";
        i = b;
        j = c;
        l = jdField_a_of_type_JavaLangString;
        b = jdField_a_of_type_Int;
        break label157;
        a(2, null);
        bool1 = bool2;
      } while (!NetworkUtil.e(this));
      localObject = (FriendListHandler)app.a(1);
      app.a(jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((FriendListHandler)localObject).c(i + j, true);
      return true;
      label371:
      localObject = String.format(getResources().getString(2131370831), new Object[] { l });
      jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a(h);
      a(1, (String)localObject);
      return true;
    }
  }
  
  public boolean a()
  {
    return ((KeyguardManager)getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(new ListView(this));
    return a(true);
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    app.b(jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    app.unRegistObserver(jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    app.unRegistObserver(jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    setIntent(paramIntent);
    a(true);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    finish();
  }
  
  public void finish()
  {
    if ((jdField_a_of_type_AndroidAppDialog != null) && (jdField_a_of_type_AndroidAppDialog.isShowing()) && (jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131301062: 
      do
      {
        return;
        if (jdField_a_of_type_Int == 0)
        {
          jdField_a_of_type_AndroidAppDialog.dismiss();
          finish();
          return;
        }
      } while (jdField_a_of_type_Int != 2);
      finish();
      return;
    }
    if (jdField_a_of_type_Int == 0)
    {
      jdField_a_of_type_AndroidAppDialog.dismiss();
      paramView = new Intent();
      paramView.setPackage(getPackageName());
      paramView.setClass(this, LoginActivity.class);
      paramView.putExtra("IS_ADD_ACCOUNT", true);
      paramView.putExtra("key_req_by_contact_sync", true);
      paramView.putExtra("key_uin_to_login", jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a());
      paramView.putExtra("key_orginal_intent", getIntent());
      paramView.addFlags(67108864);
      paramView.addFlags(536870912);
      startActivity(paramView);
      finish();
      return;
    }
    if (jdField_a_of_type_Int == 2)
    {
      b();
      return;
    }
    finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}
