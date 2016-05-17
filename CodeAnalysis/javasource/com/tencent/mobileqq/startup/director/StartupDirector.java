package com.tencent.mobileqq.startup.director;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShortcutUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import rdn;
import rdo;
import rdp;

public class StartupDirector
  implements Handler.Callback
{
  private static final int A = 11;
  private static final int B = 12;
  private static final int C = 13;
  public static final int a = 8;
  public static final long a = 550L;
  public static final String a = "AutoMonitor";
  public static final boolean a = false;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static int b = 0;
  public static final String b = "com.tencent.mobileqq";
  public static final boolean b = false;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  public static int c = 0;
  public static final String c = "k_start_mode";
  public static final boolean c = true;
  private static final int[] c;
  private static final int jdField_d_of_type_Int = -1;
  private static final String jdField_d_of_type_JavaLangString = "suicide_count";
  public static boolean d = false;
  private static final int[] jdField_d_of_type_ArrayOfInt;
  private static final int jdField_e_of_type_Int = 0;
  public static boolean e = false;
  private static final int[] jdField_e_of_type_ArrayOfInt;
  private static final int jdField_f_of_type_Int = 1;
  private static final long jdField_f_of_type_Long = 1000L;
  private static final boolean jdField_f_of_type_Boolean = false;
  private static final int[] jdField_f_of_type_ArrayOfInt;
  private static final int jdField_g_of_type_Int = 2;
  private static final int[] jdField_g_of_type_ArrayOfInt;
  private static final int jdField_h_of_type_Int = 3;
  private static long jdField_h_of_type_Long = 0L;
  private static final int[] jdField_h_of_type_ArrayOfInt;
  private static final int jdField_i_of_type_Int = 4;
  private static final int[] jdField_i_of_type_ArrayOfInt;
  private static final int jdField_j_of_type_Int = 5;
  private static final int[] jdField_j_of_type_ArrayOfInt;
  private static final int jdField_k_of_type_Int = 6;
  private static final int[] jdField_k_of_type_ArrayOfInt;
  private static final int jdField_l_of_type_Int = 101;
  private static final int[] jdField_l_of_type_ArrayOfInt;
  private static final int jdField_m_of_type_Int = 201;
  private static final int[] jdField_m_of_type_ArrayOfInt;
  private static final int jdField_n_of_type_Int = 1000;
  private static final int[] jdField_n_of_type_ArrayOfInt;
  private static final int jdField_o_of_type_Int;
  private static final int[] jdField_o_of_type_ArrayOfInt;
  private static final int[] jdField_p_of_type_ArrayOfInt;
  private static final int q = 1;
  private static final int r = 2;
  private static final int s = 3;
  private static final int t = 4;
  private static final int u = 5;
  private static final int v = 6;
  private static final int w = 7;
  private static final int x = 8;
  private static final int y = 9;
  private static final int z = 10;
  private int D = 0;
  private int E;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public AppActivity a;
  public long b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public long c;
  public long d;
  private long jdField_e_of_type_Long = 0L;
  private long jdField_g_of_type_Long;
  private int jdField_p_of_type_Int = -1;
  
  static
  {
    if (Build.MODEL.toLowerCase().startsWith("coolpad 80")) {}
    for (int i1 = 1;; i1 = 3)
    {
      jdField_o_of_type_Int = i1;
      jdField_a_of_type_ArrayOfInt = new int[] { 1, 7, 6, 13 };
      jdField_b_of_type_ArrayOfInt = new int[] { 4, 5, 17 };
      jdField_c_of_type_ArrayOfInt = new int[] { 10 };
      jdField_d_of_type_ArrayOfInt = new int[] { 9, 10, 15, 16 };
      jdField_e_of_type_ArrayOfInt = new int[] { 9, 10, 15 };
      f = new int[] { 5, 17 };
      jdField_g_of_type_ArrayOfInt = new int[] { 9, 15 };
      jdField_h_of_type_ArrayOfInt = f;
      i = new int[] { 4, 9, 12, 8 };
      j = new int[] { 9, 12 };
      k = new int[] { 4, 8, 18 };
      l = new int[] { 11, 4 };
      m = new int[] { 11, 4, 12, 10, 8 };
      n = new int[] { 11, 4, 12, 10, 19 };
      jdField_o_of_type_ArrayOfInt = new int[] { 11, 4, 12, 10 };
      jdField_p_of_type_ArrayOfInt = new int[] { 27, 31 };
      jdField_d_of_type_Boolean = false;
      jdField_e_of_type_Boolean = false;
      jdField_b_of_type_Int = 0;
      jdField_c_of_type_Int = 0;
      jdField_h_of_type_Long = 0L;
      return;
    }
  }
  
  public StartupDirector()
  {
    jdField_c_of_type_Long = 0L;
    jdField_d_of_type_Long = 0L;
  }
  
  /* Error */
  private final int a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: iconst_0
    //   13: istore_2
    //   14: new 161	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 167	android/content/Context:getFilesDir	()Ljava/io/File;
    //   22: ldc 35
    //   24: invokespecial 170	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore 9
    //   29: iload 4
    //   31: istore_3
    //   32: aload 9
    //   34: invokevirtual 174	java/io/File:exists	()Z
    //   37: ifeq +49 -> 86
    //   40: new 176	java/io/BufferedInputStream
    //   43: dup
    //   44: new 178	java/io/FileInputStream
    //   47: dup
    //   48: aload 9
    //   50: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 184	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore 5
    //   58: aload 5
    //   60: astore_1
    //   61: aload 5
    //   63: invokevirtual 188	java/io/BufferedInputStream:read	()I
    //   66: istore_3
    //   67: iload_3
    //   68: iconst_m1
    //   69: if_icmpne +228 -> 297
    //   72: iload_2
    //   73: istore_3
    //   74: aload 5
    //   76: ifnull +10 -> 86
    //   79: aload 5
    //   81: invokevirtual 191	java/io/BufferedInputStream:close	()V
    //   84: iload_2
    //   85: istore_3
    //   86: iload_3
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: aload 8
    //   92: astore_1
    //   93: new 193	java/io/FileOutputStream
    //   96: dup
    //   97: aload 9
    //   99: invokespecial 194	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   102: astore 5
    //   104: aload 5
    //   106: iload_2
    //   107: invokevirtual 198	java/io/FileOutputStream:write	(I)V
    //   110: aload 5
    //   112: ifnull +8 -> 120
    //   115: aload 5
    //   117: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   120: iload_2
    //   121: ireturn
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   127: iload_2
    //   128: istore_3
    //   129: goto -43 -> 86
    //   132: astore 6
    //   134: aconst_null
    //   135: astore 5
    //   137: aload 5
    //   139: astore_1
    //   140: aload 6
    //   142: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   145: iload 4
    //   147: istore_3
    //   148: aload 5
    //   150: ifnull -64 -> 86
    //   153: aload 5
    //   155: invokevirtual 191	java/io/BufferedInputStream:close	()V
    //   158: iload 4
    //   160: istore_3
    //   161: goto -75 -> 86
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   169: iload 4
    //   171: istore_3
    //   172: goto -86 -> 86
    //   175: astore_1
    //   176: aload 6
    //   178: astore 5
    //   180: aload 5
    //   182: ifnull +8 -> 190
    //   185: aload 5
    //   187: invokevirtual 191	java/io/BufferedInputStream:close	()V
    //   190: aload_1
    //   191: athrow
    //   192: astore 5
    //   194: aload 5
    //   196: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   199: goto -9 -> 190
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   207: iload_2
    //   208: ireturn
    //   209: astore 6
    //   211: aload 7
    //   213: astore 5
    //   215: aload 5
    //   217: astore_1
    //   218: aload 6
    //   220: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   223: aload 5
    //   225: ifnull -105 -> 120
    //   228: aload 5
    //   230: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   233: iload_2
    //   234: ireturn
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   240: iload_2
    //   241: ireturn
    //   242: astore 6
    //   244: aload_1
    //   245: astore 5
    //   247: aload 6
    //   249: astore_1
    //   250: aload 5
    //   252: ifnull +8 -> 260
    //   255: aload 5
    //   257: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   260: aload_1
    //   261: athrow
    //   262: astore 5
    //   264: aload 5
    //   266: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   269: goto -9 -> 260
    //   272: astore_1
    //   273: goto -23 -> 250
    //   276: astore 6
    //   278: goto -63 -> 215
    //   281: astore 6
    //   283: aload_1
    //   284: astore 5
    //   286: aload 6
    //   288: astore_1
    //   289: goto -109 -> 180
    //   292: astore 6
    //   294: goto -157 -> 137
    //   297: iload_3
    //   298: istore_2
    //   299: goto -227 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	StartupDirector
    //   0	302	1	paramContext	android.content.Context
    //   13	286	2	i1	int
    //   31	267	3	i2	int
    //   10	160	4	i3	int
    //   56	130	5	localObject1	Object
    //   192	3	5	localIOException1	java.io.IOException
    //   213	43	5	localObject2	Object
    //   262	3	5	localIOException2	java.io.IOException
    //   284	1	5	localContext	android.content.Context
    //   7	1	6	localObject3	Object
    //   132	45	6	localException1	Exception
    //   209	10	6	localIOException3	java.io.IOException
    //   242	6	6	localObject4	Object
    //   276	1	6	localIOException4	java.io.IOException
    //   281	6	6	localObject5	Object
    //   292	1	6	localException2	Exception
    //   1	211	7	localObject6	Object
    //   4	87	8	localObject7	Object
    //   27	71	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   79	84	122	java/io/IOException
    //   40	58	132	java/lang/Exception
    //   153	158	164	java/io/IOException
    //   40	58	175	finally
    //   185	190	192	java/io/IOException
    //   115	120	202	java/io/IOException
    //   93	104	209	java/io/IOException
    //   228	233	235	java/io/IOException
    //   93	104	242	finally
    //   218	223	242	finally
    //   255	260	262	java/io/IOException
    //   104	110	272	finally
    //   104	110	276	java/io/IOException
    //   61	67	281	finally
    //   140	145	281	finally
    //   61	67	292	java/lang/Exception
  }
  
  public static StartupDirector a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onApplicationCreate ");
    }
    paramBaseApplicationImpl = new StartupDirector();
    paramBaseApplicationImpl.a(0);
    Step.AmStepFactory.b(0, paramBaseApplicationImpl, jdField_a_of_type_ArrayOfInt).c();
    if (BaseApplicationImpl.i == 1)
    {
      paramBaseApplicationImpl.a(1);
      return paramBaseApplicationImpl;
    }
    if (BaseApplicationImpl.i == 3)
    {
      Step.AmStepFactory.b(29, paramBaseApplicationImpl, null).c();
      Step.AmStepFactory.b(11, paramBaseApplicationImpl, null).c();
      Step.AmStepFactory.b(9, paramBaseApplicationImpl, null).c();
      paramBaseApplicationImpl.a(1);
      return paramBaseApplicationImpl;
    }
    if (BaseApplicationImpl.i == 6)
    {
      jdField_d_of_type_Boolean = false;
      return paramBaseApplicationImpl;
    }
    jdField_d_of_type_Boolean = false;
    Step.AmStepFactory.b(11, paramBaseApplicationImpl, null).c();
    if (BaseApplicationImpl.i == 2)
    {
      Thread localThread = new Thread(Step.AmStepFactory.b(0, paramBaseApplicationImpl, k));
      localThread.setPriority(10);
      localThread.start();
      Step.AmStepFactory.b(0, paramBaseApplicationImpl, j).c();
    }
    label233:
    label326:
    label339:
    for (;;)
    {
      return null;
      if (BaseApplicationImpl.i == 5)
      {
        Step.AmStepFactory.b(6, paramBaseApplicationImpl, null).c();
        Step.AmStepFactory.b(0, paramBaseApplicationImpl, i).c();
        Step.AmStepFactory.b(10, paramBaseApplicationImpl, null).c();
      }
      else
      {
        int i1;
        if (BaseApplicationImpl.processName.endsWith(":MSF"))
        {
          i1 = 4;
          BaseApplicationImpl.i = i1;
          if (!BaseApplicationImpl.processName.endsWith(":troopbar")) {
            break label326;
          }
          Step.AmStepFactory.b(10, paramBaseApplicationImpl, null).c();
          Step.AmStepFactory.b(9, paramBaseApplicationImpl, null).c();
          Step.AmStepFactory.b(12, paramBaseApplicationImpl, null).c();
        }
        for (;;)
        {
          if ((BaseApplicationImpl.processName.endsWith(":picture")) || (BaseApplicationImpl.processName.endsWith(":qzonevideo"))) {
            break label339;
          }
          ThreadManager.a(Step.AmStepFactory.b(0, paramBaseApplicationImpl, jdField_p_of_type_ArrayOfInt), 8, null, false);
          break;
          i1 = -1;
          break label233;
          Step.AmStepFactory.b(0, paramBaseApplicationImpl, i).c();
        }
      }
    }
  }
  
  private void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.i("AutoMonitor", 2, "realCreateActivity " + jdField_p_of_type_Int + ", " + jdField_a_of_type_JavaUtilArrayList);
      QLog.d("AutoMonitor", 2, "realCreateActivity time=" + System.currentTimeMillis());
    }
    if (jdField_p_of_type_Int == 3) {
      a(4);
    }
    if (jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i1 = jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (i1 >= 0)
      {
        Object localObject = (WeakReference)jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (localObject != null) {}
        for (localObject = (AppActivity)((WeakReference)localObject).get();; localObject = null)
        {
          if (localObject != null) {
            ((AppActivity)localObject).realOnCreate();
          }
          i1 -= 1;
          break;
        }
      }
    }
    long l1;
    if (BaseApplicationImpl.jdField_a_of_type_Long > 0L)
    {
      l1 = SystemClock.uptimeMillis();
      jdField_d_of_type_Long = (l1 - BaseApplicationImpl.jdField_a_of_type_Long);
      Log.d("AutoMonitor", "ActionLoginA, cost=" + jdField_d_of_type_Long);
      if (!NetworkUtil.e(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl)) {
        break label257;
      }
    }
    label257:
    for (BaseApplicationImpl.jdField_a_of_type_Long = -l1;; BaseApplicationImpl.jdField_a_of_type_Long = 0L)
    {
      a(5);
      a(2, 0, 3000L);
      if (BaseApplicationImpl.i == 1) {
        b(12, 0, 10000L);
      }
      return;
    }
  }
  
  private void a(int paramInt)
  {
    long l1;
    if (jdField_d_of_type_Boolean)
    {
      if (jdField_p_of_type_Int == -1) {
        break label106;
      }
      l1 = SystemClock.uptimeMillis();
      Log.i("AutoMonitor", "STATE_" + jdField_p_of_type_Int + ", cost=" + (l1 - jdField_h_of_type_Long) + " then " + paramInt);
    }
    for (;;)
    {
      if (paramInt != 1000)
      {
        if (jdField_p_of_type_Int == -1) {
          l1 = SystemClock.uptimeMillis();
        }
        if (l1 != 0L) {
          jdField_h_of_type_Long = l1;
        }
      }
      jdField_p_of_type_Int = paramInt;
      return;
      label106:
      l1 = 0L;
    }
  }
  
  private void a(AppActivity paramAppActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramAppActivity == null) {
      return;
    }
    TextView localTextView = new TextView(paramAppActivity);
    paramAppActivity.getWindow().setBackgroundDrawableResource(17170446);
    localTextView.setGravity(17);
    localTextView.setBackgroundColor(-16777216);
    localTextView.setTextColor(-1);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (!paramBoolean1) {
      if (InjectUtils.a) {
        localTextView.setText(2131367058);
      }
    }
    for (;;)
    {
      paramAppActivity.setContentView(localTextView);
      QLog.flushLog();
      InjectUtils.a(paramAppActivity, "SuicideFailed", Integer.toString(jdField_c_of_type_Int));
      jdField_b_of_type_AndroidOsHandler.postDelayed(new rdp(this, paramAppActivity), 8000L);
      return;
      localTextView.setText(2131367057);
      continue;
      localTextView.setText("程序启动失败，请稍候重试.");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onEndStep with " + paramBoolean + ", when " + jdField_p_of_type_Int);
    }
    if (paramBoolean)
    {
      ThreadManager.b().post(Step.AmStepFactory.b(8, this, null));
      if (jdField_b_of_type_Int == 1) {
        ThreadManager.b().post(Step.AmStepFactory.b(20, this, null));
      }
    }
    jdField_a_of_type_AndroidOsHandler = null;
    if (jdField_b_of_type_AndroidOsHandler != null) {
      jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    a(1000);
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    if (paramBoolean)
    {
      l1 = SystemClock.uptimeMillis();
      l2 = jdField_c_of_type_Long;
      l3 = jdField_c_of_type_Long;
      l4 = BaseApplicationImpl.jdField_b_of_type_Long;
      l5 = BaseApplicationImpl.jdField_b_of_type_Long;
      if ((BaseApplicationImpl.jdField_b_of_type_Long <= 0L) || (!NetworkUtil.g(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl))) {
        break label249;
      }
    }
    label249:
    for (BaseApplicationImpl.jdField_b_of_type_Long = -l1;; BaseApplicationImpl.jdField_b_of_type_Long = 0L)
    {
      long l6 = jdField_b_of_type_Long;
      long l7 = jdField_d_of_type_Long;
      ThreadManager.b().postDelayed(new rdn(this, l7, l6, l2, l1 - l3, l4, l1 - l5), 10000L);
      ThreadManager.b().postDelayed(new rdo(this), 3000L);
      ThreadManager.b().postDelayed(Step.AmStepFactory.b(27, this, null), 5000L);
      BaseApplicationImpl.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector = null;
      return;
    }
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    D = 1;
    paramArrayOfInt1 = Step.AmStepFactory.b(0, this, paramArrayOfInt1);
    if (paramArrayOfInt2 != null)
    {
      D = 2;
      E = paramInt;
      paramArrayOfInt1.a(jdField_b_of_type_AndroidOsHandler, 10);
      paramArrayOfInt2 = Step.AmStepFactory.b(0, this, paramArrayOfInt2);
      paramArrayOfInt2.a(jdField_b_of_type_AndroidOsHandler, 10);
      ThreadManager.a().post(paramArrayOfInt2);
    }
    for (;;)
    {
      paramArrayOfInt1.c();
      return;
      paramArrayOfInt1.a(jdField_b_of_type_AndroidOsHandler, paramInt);
    }
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong)
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {
      jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    }
    jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt1);
    Message localMessage = jdField_b_of_type_AndroidOsHandler.obtainMessage(paramInt1, paramInt2, 0);
    jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    if (jdField_b_of_type_AndroidOsHandler == null) {
      jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    jdField_b_of_type_AndroidOsHandler.removeMessages(paramInt1);
    Message localMessage = jdField_b_of_type_AndroidOsHandler.obtainMessage(paramInt1, paramInt2, 0);
    jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onActivityFocusChanged when " + jdField_p_of_type_Int + ", " + paramAppActivity + ", " + paramBoolean);
    }
    if (!paramBoolean) {}
    do
    {
      return;
      jdField_b_of_type_AndroidOsHandler.removeMessages(2);
      if (jdField_p_of_type_Int == 2)
      {
        a(11, 1, 5L);
        a(3);
        return;
      }
      if (jdField_p_of_type_Int == 101)
      {
        a(11, 7, 5L);
        a(3);
        return;
      }
      if (jdField_p_of_type_Int == 201)
      {
        a(11, 8, 5L);
        a(3);
        return;
      }
      if ((jdField_p_of_type_Int == 5) || (jdField_p_of_type_Int == 6))
      {
        a(true);
        return;
      }
    } while (jdField_p_of_type_Int == 3);
  }
  
  public boolean a(Object paramObject, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    QLog.i("AutoMonitor", 1, "onActivityCreate" + paramObject);
    if ((paramObject instanceof AppActivity)) {}
    for (paramObject = (AppActivity)paramObject;; paramObject = null)
    {
      long l1 = SystemClock.uptimeMillis();
      if ((jdField_p_of_type_Int == 1) && (Math.abs(l1 - BaseApplicationImpl.jdField_c_of_type_Long) > 4000L))
      {
        BaseApplicationImpl.jdField_b_of_type_Long = 0L;
        BaseApplicationImpl.jdField_a_of_type_Long = 0L;
        BaseApplicationImpl.jdField_c_of_type_Long = 0L;
      }
      int i1;
      if (paramObject == null) {
        if (jdField_p_of_type_Int == 1)
        {
          BaseApplicationImpl.jdField_b_of_type_Boolean = true;
          BaseApplicationImpl.jdField_b_of_type_Long = 0L;
          BaseApplicationImpl.jdField_a_of_type_Long = 0L;
          if (paramIntent != null) {
            jdField_b_of_type_Int = paramIntent.getIntExtra("k_start_mode", 0);
          }
          QLog.i("AutoMonitor", 1, "onActivityCreate" + jdField_p_of_type_Int + ", " + jdField_b_of_type_Int);
          paramObject = m;
          if (jdField_b_of_type_Int == 1)
          {
            paramObject = n;
            Step.AmStepFactory.b(0, this, paramObject).c();
            if (GuardManager.a != null)
            {
              paramObject = GuardManager.a;
              if (jdField_b_of_type_Int != 2) {
                break label258;
              }
              i1 = 1;
              label208:
              paramObject.a(i1, null);
            }
            a(201);
            label221:
            bool2 = false;
          }
        }
      }
      for (;;)
      {
        return bool2;
        if (jdField_b_of_type_Int == 2)
        {
          paramObject = jdField_o_of_type_ArrayOfInt;
          BaseApplicationImpl.jdField_c_of_type_Long = 0L;
          break;
        }
        if (jdField_b_of_type_Int != 0) {
          break;
        }
        paramObject = m;
        break;
        label258:
        i1 = 6;
        break label208;
        if (jdField_p_of_type_Int == 2)
        {
          Step.AmStepFactory.b(0, this, l).c();
          a(101);
          break label221;
        }
        if ((jdField_p_of_type_Int != 201) || (jdField_b_of_type_Int != 2) || (paramIntent == null)) {
          break label221;
        }
        i1 = paramIntent.getIntExtra("k_start_mode", 2);
        QLog.i("AutoMonitor", 1, "onActivityCreate" + jdField_p_of_type_Int + ", " + i1);
        if ((i1 != 3) && (i1 != 0) && (i1 != 1)) {
          break label221;
        }
        Step.AmStepFactory.b(8, this, null).c();
        break label221;
        if ((jdField_p_of_type_Int != 1) && (jdField_p_of_type_Int != 2) && (jdField_p_of_type_Int != 101) && (jdField_p_of_type_Int != 201)) {
          break label816;
        }
        if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) && (!(paramObject instanceof InstallActivity)))
        {
          paramIntent = new Intent(paramObject, InstallActivity.class);
          paramIntent.addFlags(603979776);
          Intent localIntent = paramObject.getIntent();
          localIntent.addFlags(67108864);
          paramIntent.putExtra("NT_AY", localIntent);
          try
          {
            paramObject.superStartActivityForResult(paramIntent, -1, null);
          }
          catch (Exception paramIntent)
          {
            try
            {
              for (;;)
              {
                paramObject.superFinish();
                jdField_c_of_type_Int = a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
                bool2 = bool1;
                if (jdField_c_of_type_Int > jdField_o_of_type_Int) {
                  break;
                }
                System.exit(-1);
                return true;
                paramIntent = paramIntent;
                QLog.e("AutoMonitor", 1, "", paramIntent);
              }
            }
            catch (Exception paramObject)
            {
              for (;;)
              {
                QLog.e("AutoMonitor", 1, "", paramObject);
              }
            }
          }
        }
      }
      jdField_a_of_type_MqqAppAppActivity = paramObject;
      if ((paramObject instanceof InstallActivity)) {}
      try
      {
        new File(jdField_a_of_type_MqqAppAppActivity.getFilesDir(), "suicide_count").delete();
        if (!(paramObject instanceof SplashActivity))
        {
          BaseApplicationImpl.jdField_a_of_type_Long = 0L;
          BaseApplicationImpl.jdField_b_of_type_Long = 0L;
        }
        if ((BaseApplicationImpl.i == 3) && (jdField_p_of_type_Int == 201))
        {
          if (jdField_a_of_type_JavaUtilArrayList == null) {
            jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
          }
          jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramObject));
          jdField_p_of_type_Int = 5;
          if (jdField_b_of_type_AndroidOsHandler == null) {
            jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
          }
          return false;
        }
      }
      catch (Throwable paramIntent)
      {
        for (;;)
        {
          QLog.e("AutoMonitor", 1, "", paramIntent);
        }
        Step.AmStepFactory.b(2, this, null).c();
        a(2, 0, 1000L);
        if ((jdField_p_of_type_Int == 201) || ((jdField_p_of_type_Int == 1) && (jdField_b_of_type_Int == 2))) {
          jdField_c_of_type_Long = l1;
        }
        bool1 = bool2;
        if (jdField_p_of_type_Int == 1)
        {
          a(2);
          bool1 = bool2;
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        if (jdField_a_of_type_JavaUtilArrayList == null) {
          jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
        }
        jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramObject));
        return bool1;
        label816:
        if ((jdField_p_of_type_Int == 5) || (jdField_p_of_type_Int == 6))
        {
          BaseApplicationImpl.jdField_a_of_type_Long = 0L;
          BaseApplicationImpl.jdField_b_of_type_Long = 0L;
          jdField_a_of_type_MqqAppAppActivity = paramObject;
          a(6);
          a(2, 0, 1000L);
          bool1 = false;
        }
        else
        {
          bool1 = bool2;
          if (jdField_p_of_type_Int == 3) {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "handleMessage when " + jdField_p_of_type_Int + ", what=" + what);
    }
    switch (what)
    {
    default: 
    case 1: 
    case 7: 
    case 8: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                a(4, 0, 300L);
                bool1 = Step.AmStepFactory.b(11, this, null).c();
                if ((bool1) && (jdField_c_of_type_Int <= jdField_o_of_type_Int))
                {
                  a(5, 0, 0L);
                  if (BaseApplicationImpl.i == 3) {
                    a(jdField_c_of_type_ArrayOfInt, null, 6);
                  }
                  for (;;)
                  {
                    b(9, 0, 300L);
                    return true;
                    a(jdField_b_of_type_ArrayOfInt, jdField_d_of_type_ArrayOfInt, 6);
                  }
                }
                if (bool1) {
                  i1 = 1;
                }
                a(3, i1, 0L);
                return true;
                b(9, 0, 300L);
                a(jdField_e_of_type_ArrayOfInt, f, 6);
                return true;
                a(jdField_g_of_type_ArrayOfInt, jdField_h_of_type_ArrayOfInt, 6);
                return true;
                a(jdField_a_of_type_MqqAppAppActivity, true);
                return true;
              } while (jdField_a_of_type_MqqAppAppActivity == null);
              AppActivity localAppActivity = jdField_a_of_type_MqqAppAppActivity;
              if (arg1 > 0) {}
              for (bool1 = true;; bool1 = false)
              {
                if (jdField_c_of_type_Int < jdField_o_of_type_Int) {
                  bool2 = true;
                }
                a(localAppActivity, bool1, bool2);
                return true;
              }
            } while (jdField_a_of_type_MqqAppAppActivity == null);
            ShortcutUtils.a(jdField_a_of_type_MqqAppAppActivity, "com.tencent.mobileqq.activity.MainActivity");
            ShortcutUtils.a(jdField_a_of_type_MqqAppAppActivity, SplashActivity.class.getName());
            return true;
            if (!jdField_b_of_type_AndroidOsHandler.hasMessages(4)) {
              ShortcutUtils.a(jdField_a_of_type_MqqAppAppActivity.getApplicationContext(), SplashActivity.class.getName());
            }
            jdField_b_of_type_AndroidOsHandler.removeMessages(4);
            return true;
            if (arg1 == 0)
            {
              if (jdField_b_of_type_Long > 0L) {
                jdField_e_of_type_Long = (jdField_g_of_type_Long + jdField_b_of_type_Long - SystemClock.uptimeMillis());
              }
              if (BaseApplicationImpl.jdField_c_of_type_Boolean)
              {
                System.gc();
                System.runFinalization();
                jdField_e_of_type_Long = 2000L;
              }
              if ((jdField_e_of_type_Long > 0L) && (jdField_e_of_type_Long < 6000L))
              {
                a(6, 1, jdField_e_of_type_Long);
                return true;
              }
              a();
              return true;
            }
            a();
            return true;
            Step.AmStepFactory.b(12, this, null).c();
          } while (BaseApplicationImpl.i != 3);
          a(13, 0, 0L);
          return true;
          i1 = D - 1;
          D = i1;
        } while (i1 != 0);
        a(E, 0, 0L);
        return true;
        if (jdField_b_of_type_Long > 0L) {
          jdField_g_of_type_Long = SystemClock.uptimeMillis();
        }
        b(arg1, 0, 0L);
        return true;
      } while (GuardManager.a == null);
      paramMessage = GuardManager.a;
      if (jdField_b_of_type_Int == 2) {
        bool1 = true;
      }
      paramMessage.c(bool1);
      return true;
    }
    Step.AmStepFactory.b(26, this, null).c();
    return true;
  }
}
