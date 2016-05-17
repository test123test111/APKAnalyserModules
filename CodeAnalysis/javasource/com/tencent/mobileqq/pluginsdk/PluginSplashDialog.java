package com.tencent.mobileqq.pluginsdk;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;

public class PluginSplashDialog
  extends Dialog
{
  private Handler a = new a(this);
  private BroadcastReceiver b = null;
  private int c;
  private String d;
  private String e;
  
  public PluginSplashDialog(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    super(paramContext, paramInt1);
    c = paramInt2;
    d = paramString1;
    e = paramString2;
  }
  
  public void dismiss()
  {
    if (b != null) {}
    try
    {
      getContext().unregisterReceiver(b);
      b = null;
      a.removeMessages(0);
      super.dismiss();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
  
  public void show()
  {
    a.sendEmptyMessageDelayed(0, c);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_launch_completed");
    b = new b(d, e);
    try
    {
      getContext().registerReceiver(b, localIntentFilter);
      if (DebugHelper.sDebug) {
        DebugHelper.log("plugin_tag", "PluginSplashDialog RegisterReceiver");
      }
      super.show();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static class LaunchCompletedIntent
    extends Intent
  {
    public static final String ACTION_LAUNCH_COMPLETED = "action_launch_completed";
    public static final String PARAM_PLUGIN_APK = "plugin_apk";
    public static final String PARAM_PLUGIN_NAME = "plugin_name";
    
    public LaunchCompletedIntent() {}
  }
  
  private static class a
    extends Handler
  {
    public static final int a = 0;
    private Dialog b = null;
    
    public a(Dialog paramDialog)
    {
      b = paramDialog;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        return;
      }
      try
      {
        b.dismiss();
        return;
      }
      catch (Exception paramMessage) {}
    }
  }
  
  private class b
    extends BroadcastReceiver
  {
    private String b;
    private String c;
    
    public b(String paramString1, String paramString2)
    {
      b = paramString1;
      c = paramString2;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getStringExtra("plugin_apk");
      paramIntent = paramIntent.getStringExtra("plugin_name");
      if ((c.equalsIgnoreCase(paramContext)) && (b.equalsIgnoreCase(paramIntent))) {}
      try
      {
        dismiss();
        return;
      }
      catch (Exception paramContext) {}
    }
  }
}
