package com.tencent.mobileqq.pluginsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public abstract class PluginStatic
{
  public static final String PARAM_CLASS_STATISTICS_UPLOADER = "clsUploader";
  public static final String PARAM_CLEAR_TOP = "cleartop";
  public static final String PARAM_EXTRA_INFO = "pluginsdk_extraInfo";
  public static final String PARAM_LAUNCH_ACTIVITY = "pluginsdk_launchActivity";
  public static final String PARAM_LAUNCH_SERVICE = "pluginsdk_launchService";
  public static final String PARAM_PATH = "pluginsdk_pluginpath";
  public static final String PARAM_PLUGIN_GESTURELOCK = "param_plugin_gesturelock";
  public static final String PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY = "PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY";
  public static final String PARAM_PLUGIN_LOCATION = "pluginsdk_pluginLocation";
  public static final String PARAM_PLUGIN_NAME = "pluginsdk_pluginName";
  public static final String PARAM_PLUGIN_RECEIVER_CLASS_NAME = "pluginsdk_launchReceiver";
  public static final String PARAM_UIN = "pluginsdk_selfuin";
  public static final String PARAM_USE_QQ_RESOURCES = "userQqResources";
  public static final String PARAM_USE_SKIN_ENGINE = "useSkinEngine";
  public static final int USER_QQ_RESOURCES_BOTH = 2;
  public static final int USER_QQ_RESOURCES_NO = -1;
  public static final int USER_QQ_RESOURCES_YES = 1;
  static final String a = "com.tencent.mobileqq";
  static final String b = "pluginsdk_IsPluginActivity";
  static final ConcurrentHashMap c = new ConcurrentHashMap();
  static final ConcurrentHashMap d = new ConcurrentHashMap();
  private static final HashMap e = new HashMap();
  private static ArrayList f = new ArrayList();
  
  public PluginStatic() {}
  
  /* Error */
  static ClassLoader a(Context paramContext, String paramString1, String paramString2)
    throws Exception
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 83	com/tencent/mobileqq/pluginsdk/PluginStatic:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 99	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 101	dalvik/system/DexClassLoader
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: aload 4
    //   20: ifnonnull +118 -> 138
    //   23: aload_0
    //   24: invokestatic 107	com/tencent/mobileqq/pluginsdk/PluginUtils:getOptimizedDexPath	(Landroid/content/Context;)Ljava/io/File;
    //   27: invokevirtual 113	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   30: astore_3
    //   31: aload_0
    //   32: aload_1
    //   33: invokestatic 117	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginLibPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   36: invokevirtual 113	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   39: astore 4
    //   41: aload_2
    //   42: ldc 119
    //   44: invokevirtual 125	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   47: ifeq +96 -> 143
    //   50: new 127	com/tencent/commonsdk/soload/SoDexClassLoader
    //   53: dup
    //   54: aload_2
    //   55: aload_3
    //   56: aload 4
    //   58: aload_0
    //   59: invokevirtual 133	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   62: invokespecial 136	com/tencent/commonsdk/soload/SoDexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   65: astore_3
    //   66: getstatic 85	com/tencent/mobileqq/pluginsdk/PluginStatic:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: aload_2
    //   70: invokevirtual 99	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 138	android/content/pm/PackageInfo
    //   76: astore 5
    //   78: aload 5
    //   80: astore 4
    //   82: aload 5
    //   84: ifnonnull +33 -> 117
    //   87: aload_0
    //   88: aload_2
    //   89: sipush 129
    //   92: invokestatic 144	com/tencent/mobileqq/pluginsdk/ApkFileParser:getPackageInfo	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   95: astore 4
    //   97: aload 4
    //   99: ifnonnull +8 -> 107
    //   102: ldc -110
    //   104: invokestatic 152	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   107: getstatic 85	com/tencent/mobileqq/pluginsdk/PluginStatic:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   110: aload_2
    //   111: aload 4
    //   113: invokevirtual 156	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: aload 4
    //   119: ifnull +10 -> 129
    //   122: aload 4
    //   124: aload_1
    //   125: aload_3
    //   126: invokestatic 159	com/tencent/mobileqq/pluginsdk/PluginStatic:a	(Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   129: getstatic 83	com/tencent/mobileqq/pluginsdk/PluginStatic:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   132: aload_1
    //   133: aload_3
    //   134: invokevirtual 156	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: ldc 2
    //   140: monitorexit
    //   141: aload_3
    //   142: areturn
    //   143: new 101	dalvik/system/DexClassLoader
    //   146: dup
    //   147: aload_2
    //   148: aload_3
    //   149: aload 4
    //   151: aload_0
    //   152: invokevirtual 133	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   155: invokespecial 160	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   158: astore_3
    //   159: goto -93 -> 66
    //   162: astore_0
    //   163: ldc 2
    //   165: monitorexit
    //   166: aload_0
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramContext	Context
    //   0	168	1	paramString1	String
    //   0	168	2	paramString2	String
    //   17	142	3	localObject1	Object
    //   13	137	4	localObject2	Object
    //   76	7	5	localPackageInfo	PackageInfo
    // Exception table:
    //   from	to	target	type
    //   3	15	162	finally
    //   23	66	162	finally
    //   66	78	162	finally
    //   87	97	162	finally
    //   102	107	162	finally
    //   107	117	162	finally
    //   122	129	162	finally
    //   129	138	162	finally
    //   143	159	162	finally
  }
  
  static List a()
  {
    return f;
  }
  
  static void a(PackageInfo paramPackageInfo, String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      if ((IPluginLife)e.get(paramString) != null) {
        return;
      }
      if ((paramPackageInfo != null) && (applicationInfo != null) && (applicationInfo.metaData != null))
      {
        paramPackageInfo = applicationInfo.metaData.getString("PLUGIN_LIFE_CLASS");
        if (paramPackageInfo != null)
        {
          paramPackageInfo = (IPluginLife)paramClassLoader.loadClass(paramPackageInfo).newInstance();
          e.put(paramString, paramPackageInfo);
          paramPackageInfo.onLoad();
          return;
        }
      }
    }
    catch (Throwable paramPackageInfo) {}
  }
  
  static void a(IPluginActivity paramIPluginActivity)
  {
    
    synchronized (f)
    {
      f.add(new WeakReference(paramIPluginActivity));
      return;
    }
  }
  
  static boolean a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return false;
      try
      {
        String str = paramBundle.getString("pluginsdk_pluginLocation");
        if ((!TextUtils.isEmpty(str)) && (!str.substring(0, str.lastIndexOf(".")).contains(".")) && (!TextUtils.isEmpty(paramBundle.getString("pluginsdk_pluginName"))))
        {
          paramBundle = paramBundle.getString("pluginsdk_pluginpath");
          if (!TextUtils.isEmpty(paramBundle))
          {
            if (TextUtils.isEmpty(paramBundle)) {
              return true;
            }
            boolean bool = a(paramBundle);
            return bool;
          }
        }
      }
      catch (Throwable paramBundle) {}
    }
    return false;
  }
  
  static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (paramString.contains("..")) {
        return bool1;
      }
      if (paramString.endsWith(".so"))
      {
        String str = MobileQQ.getContext().getFilesDir().getParent();
        File localFile = new File(str + "/txlib/");
        if ((a(paramString, new File(str + "/lib/"))) || (!a(paramString, localFile))) {}
      }
      else
      {
        bool1 = bool2;
        if (!paramString.endsWith(".apk")) {
          return bool1;
        }
        bool1 = a(paramString, PluginUtils.getPluginInstallDir(MobileQQ.getContext()));
        return bool1;
      }
    }
    catch (Exception paramString)
    {
      return false;
    }
    bool1 = true;
    return bool1;
  }
  
  private static boolean a(String paramString, File paramFile)
    throws IOException
  {
    paramFile = paramFile.getCanonicalPath();
    String str = new File(paramString).getParentFile().getCanonicalPath();
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "path:" + paramString + "-> [" + str + ", " + paramFile + "]");
    }
    return str.equals(paramFile);
  }
  
  static ClassLoader b(String paramString)
  {
    try
    {
      paramString = (DexClassLoader)c.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static void b()
  {
    ArrayList localArrayList = f;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < f.size())
        {
          if (((WeakReference)f.get(i)).get() == null)
          {
            f.remove(i);
            i -= 1;
          }
        }
        else {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  static void b(IPluginActivity paramIPluginActivity)
  {
    b();
    c(paramIPluginActivity);
  }
  
  public static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar1 = new char[16];
    char[] tmp10_8 = arrayOfChar1;
    tmp10_8[0] = 48;
    char[] tmp16_10 = tmp10_8;
    tmp16_10[1] = 49;
    char[] tmp22_16 = tmp16_10;
    tmp22_16[2] = 50;
    char[] tmp28_22 = tmp22_16;
    tmp28_22[3] = 51;
    char[] tmp34_28 = tmp28_22;
    tmp34_28[4] = 52;
    char[] tmp40_34 = tmp34_28;
    tmp40_34[5] = 53;
    char[] tmp46_40 = tmp40_34;
    tmp46_40[6] = 54;
    char[] tmp53_46 = tmp46_40;
    tmp53_46[7] = 55;
    char[] tmp60_53 = tmp53_46;
    tmp60_53[8] = 56;
    char[] tmp67_60 = tmp60_53;
    tmp67_60[9] = 57;
    char[] tmp74_67 = tmp67_60;
    tmp74_67[10] = 65;
    char[] tmp81_74 = tmp74_67;
    tmp81_74[11] = 66;
    char[] tmp88_81 = tmp81_74;
    tmp88_81[12] = 67;
    char[] tmp95_88 = tmp88_81;
    tmp95_88[13] = 68;
    char[] tmp102_95 = tmp95_88;
    tmp102_95[14] = 69;
    char[] tmp109_102 = tmp102_95;
    tmp109_102[15] = 70;
    tmp109_102;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  private static boolean c(IPluginActivity paramIPluginActivity)
  {
    ArrayList localArrayList = f;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < f.size())
        {
          if (((WeakReference)f.get(i)).get() == paramIPluginActivity)
          {
            f.remove(i);
            return true;
          }
        }
        else {
          return false;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  /* Error */
  public static String encodeFile(String paramString)
  {
    // Byte code:
    //   0: new 109	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 264	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 344	java/io/File:exists	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 347	java/io/File:isFile	()Z
    //   20: ifne +25 -> 45
    //   23: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +13 -> 39
    //   29: ldc_w 287
    //   32: iconst_2
    //   33: ldc_w 349
    //   36: invokestatic 351	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: ldc_w 353
    //   42: astore_3
    //   43: aload_3
    //   44: areturn
    //   45: ldc_w 355
    //   48: invokestatic 361	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   51: astore 4
    //   53: new 363	java/io/FileInputStream
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 366	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore_2
    //   62: aload_2
    //   63: astore_0
    //   64: sipush 16384
    //   67: newarray byte
    //   69: astore_3
    //   70: aload_2
    //   71: astore_0
    //   72: aload_2
    //   73: aload_3
    //   74: invokevirtual 370	java/io/FileInputStream:read	([B)I
    //   77: istore_1
    //   78: iload_1
    //   79: iconst_m1
    //   80: if_icmpeq +81 -> 161
    //   83: aload_2
    //   84: astore_0
    //   85: aload 4
    //   87: aload_3
    //   88: iconst_0
    //   89: iload_1
    //   90: invokevirtual 374	java/security/MessageDigest:update	([BII)V
    //   93: goto -23 -> 70
    //   96: astore_3
    //   97: aload_2
    //   98: astore_0
    //   99: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +35 -> 137
    //   105: aload_2
    //   106: astore_0
    //   107: ldc_w 287
    //   110: iconst_2
    //   111: new 252	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 376
    //   121: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_3
    //   125: invokestatic 380	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   128: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 351	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_2
    //   138: ifnull +83 -> 221
    //   141: aload_2
    //   142: invokevirtual 383	java/io/FileInputStream:close	()V
    //   145: ldc_w 353
    //   148: areturn
    //   149: astore_0
    //   150: aload_2
    //   151: astore_0
    //   152: sipush 4096
    //   155: newarray byte
    //   157: astore_3
    //   158: goto -88 -> 70
    //   161: aload_2
    //   162: astore_0
    //   163: aload 4
    //   165: invokevirtual 387	java/security/MessageDigest:digest	()[B
    //   168: invokestatic 389	com/tencent/mobileqq/pluginsdk/PluginStatic:byteArrayToHex	([B)Ljava/lang/String;
    //   171: astore_3
    //   172: aload_3
    //   173: astore_0
    //   174: aload_0
    //   175: astore_3
    //   176: aload_2
    //   177: ifnull -134 -> 43
    //   180: aload_2
    //   181: invokevirtual 383	java/io/FileInputStream:close	()V
    //   184: aload_0
    //   185: areturn
    //   186: astore_2
    //   187: aload_0
    //   188: areturn
    //   189: astore_0
    //   190: ldc_w 353
    //   193: areturn
    //   194: astore_2
    //   195: aconst_null
    //   196: astore_0
    //   197: aload_0
    //   198: ifnull +7 -> 205
    //   201: aload_0
    //   202: invokevirtual 383	java/io/FileInputStream:close	()V
    //   205: aload_2
    //   206: athrow
    //   207: astore_0
    //   208: goto -3 -> 205
    //   211: astore_2
    //   212: goto -15 -> 197
    //   215: astore_3
    //   216: aconst_null
    //   217: astore_2
    //   218: goto -121 -> 97
    //   221: ldc_w 353
    //   224: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramString	String
    //   77	13	1	i	int
    //   61	120	2	localFileInputStream	java.io.FileInputStream
    //   186	1	2	localIOException	IOException
    //   194	12	2	localObject1	Object
    //   211	1	2	localObject2	Object
    //   217	1	2	localObject3	Object
    //   42	46	3	localObject4	Object
    //   96	29	3	localException1	Exception
    //   157	19	3	localObject5	Object
    //   215	1	3	localException2	Exception
    //   51	113	4	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   64	70	96	java/lang/Exception
    //   72	78	96	java/lang/Exception
    //   85	93	96	java/lang/Exception
    //   152	158	96	java/lang/Exception
    //   163	172	96	java/lang/Exception
    //   64	70	149	java/lang/OutOfMemoryError
    //   180	184	186	java/io/IOException
    //   141	145	189	java/io/IOException
    //   45	62	194	finally
    //   201	205	207	java/io/IOException
    //   64	70	211	finally
    //   72	78	211	finally
    //   85	93	211	finally
    //   99	105	211	finally
    //   107	137	211	finally
    //   152	158	211	finally
    //   163	172	211	finally
    //   45	62	215	java/lang/Exception
  }
  
  public static ClassLoader getOrCreateClassLoader(Context paramContext, String paramString)
    throws Exception
  {
    try
    {
      ClassLoader localClassLoader2 = (ClassLoader)c.get(paramString);
      ClassLoader localClassLoader1 = localClassLoader2;
      if (localClassLoader2 == null) {
        localClassLoader1 = a(paramContext, paramString, PluginUtils.getInstalledPluginPath(paramContext, paramString).getCanonicalPath());
      }
      return localClassLoader1;
    }
    finally {}
  }
  
  public static List isProcessesExist(Context paramContext, List paramList)
  {
    ArrayList localArrayList = null;
    if (paramList != null)
    {
      localArrayList = new ArrayList();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null)
      {
        int i = 0;
        while (i < paramList.size())
        {
          localArrayList.add(Boolean.FALSE);
          i += 1;
        }
      }
    }
    else
    {
      return localArrayList;
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Iterator localIterator = paramContext.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!str.equalsIgnoreCase(nextprocessName));
      for (boolean bool = true;; bool = false)
      {
        localArrayList.add(Boolean.valueOf(bool));
        break;
      }
    }
    return localArrayList;
  }
  
  public static abstract interface IPluginLife
  {
    public abstract void onLoad();
    
    public abstract void onUnload();
  }
}
