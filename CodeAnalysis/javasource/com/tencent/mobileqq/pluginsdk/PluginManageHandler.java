package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

public class PluginManageHandler
{
  private static volatile PluginManageHandler a;
  private IPluginManagerProvider b;
  private RemotePluginManager.Stub c;
  private PluginManageWrapper d;
  
  private PluginManageHandler() {}
  
  private boolean a()
  {
    if (c == null) {}
    try
    {
      if ((c == null) && (b != null)) {
        c = b.onGetPluginManager();
      }
      if (c != null) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public static final PluginManageHandler getInstance()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new PluginManageHandler();
      }
      return a;
    }
    finally {}
  }
  
  public IBinder getBinder()
  {
    if (d == null)
    {
      d = new PluginManageWrapper();
      a();
    }
    return d;
  }
  
  public void setPluginManagerProvider(IPluginManagerProvider paramIPluginManagerProvider, boolean paramBoolean)
  {
    b = paramIPluginManagerProvider;
    if (b == null)
    {
      d = null;
      c = null;
    }
    while (!paramBoolean) {
      return;
    }
    a();
  }
  
  public static abstract interface IPluginManagerProvider
  {
    public abstract RemotePluginManager.Stub onGetPluginManager();
  }
  
  public class PluginManageWrapper
    extends RemotePluginManager.Stub
  {
    public PluginManageWrapper() {}
    
    public void cancelInstall(String paramString)
    {
      if (PluginManageHandler.a(PluginManageHandler.this) == null)
      {
        PluginManageHandler.b(PluginManageHandler.this);
        if (PluginManageHandler.a(PluginManageHandler.this) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
          return;
        }
      }
      try
      {
        PluginManageHandler.a(PluginManageHandler.this).cancelInstall(paramString);
        return;
      }
      catch (RemoteException paramString) {}
    }
    
    public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("plugin_tag", 4, "installPlugin " + PluginManageHandler.a(PluginManageHandler.this));
      }
      if (PluginManageHandler.a(PluginManageHandler.this) == null)
      {
        PluginManageHandler.b(PluginManageHandler.this);
        if (PluginManageHandler.a(PluginManageHandler.this) == null) {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
        }
      }
      do
      {
        for (;;)
        {
          return;
          try
          {
            PluginManageHandler.a(PluginManageHandler.this).installPlugin(paramString, paramOnPluginInstallListener);
            if (QLog.isDevelopLevel())
            {
              QLog.i("plugin_tag", 4, "installPlugin done");
              return;
            }
          }
          catch (RemoteException paramString) {}
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("plugin_tag", 4, "installPlugin", paramString);
    }
    
    public boolean isPlugininstalled(String paramString)
      throws RemoteException
    {
      if (PluginManageHandler.a(PluginManageHandler.this) == null)
      {
        PluginManageHandler.b(PluginManageHandler.this);
        if (PluginManageHandler.a(PluginManageHandler.this) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
          return false;
        }
      }
      return PluginManageHandler.a(PluginManageHandler.this).isPlugininstalled(paramString);
    }
    
    public boolean isReady()
    {
      if (PluginManageHandler.a(PluginManageHandler.this) == null)
      {
        PluginManageHandler.b(PluginManageHandler.this);
        if (PluginManageHandler.a(PluginManageHandler.this) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
          return false;
        }
      }
      try
      {
        boolean bool = PluginManageHandler.a(PluginManageHandler.this).isReady();
        return bool;
      }
      catch (RemoteException localRemoteException) {}
      return false;
    }
    
    public PluginBaseInfo queryPlugin(String paramString)
    {
      if (PluginManageHandler.a(PluginManageHandler.this) == null)
      {
        PluginManageHandler.b(PluginManageHandler.this);
        if (PluginManageHandler.a(PluginManageHandler.this) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
          }
          return null;
        }
      }
      try
      {
        paramString = PluginManageHandler.a(PluginManageHandler.this).queryPlugin(paramString);
        return paramString;
      }
      catch (RemoteException paramString) {}
      return null;
    }
  }
}
