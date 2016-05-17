package com.tencent.common.config.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class QZConfigSqliteManager
  implements QZoneConfigConst
{
  private static final String z = "QZConfigSqliteManager";
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private QZoneConfigSQLiteHelper jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigSQLiteHelper;
  private SQLiteDatabase b;
  
  public QZConfigSqliteManager(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigSQLiteHelper = new QZoneConfigSQLiteHelper(paramContext, "config_db", null, 8);
  }
  
  public int a()
  {
    int i = 0;
    if (a())
    {
      i = jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_cookie", null, null);
      a();
    }
    return i;
  }
  
  /* Error */
  public int a(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: invokevirtual 39	com/tencent/common/config/provider/QZConfigSqliteManager:a	()Z
    //   6: ifeq +118 -> 124
    //   9: aload_2
    //   10: arraylength
    //   11: istore_3
    //   12: aload_0
    //   13: getfield 41	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   16: invokevirtual 57	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   19: aload_2
    //   20: arraylength
    //   21: istore 5
    //   23: iconst_0
    //   24: istore 4
    //   26: iload 4
    //   28: iload 5
    //   30: if_icmpge +109 -> 139
    //   33: aload_2
    //   34: iload 4
    //   36: aaload
    //   37: astore 6
    //   39: aload_0
    //   40: getfield 41	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   43: ldc 59
    //   45: ldc 61
    //   47: aload 6
    //   49: invokevirtual 65	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   52: lconst_0
    //   53: lcmp
    //   54: ifgt +72 -> 126
    //   57: new 54	android/database/SQLException
    //   60: dup
    //   61: new 67	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   68: ldc 70
    //   70: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 84	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //   84: astore_1
    //   85: ldc 10
    //   87: iconst_1
    //   88: new 67	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   95: ldc 86
    //   97: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 89	android/database/SQLException:getMessage	()Ljava/lang/String;
    //   104: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_0
    //   114: getfield 41	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   117: invokevirtual 98	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   120: aload_0
    //   121: invokevirtual 51	com/tencent/common/config/provider/QZConfigSqliteManager:a	()V
    //   124: iload_3
    //   125: ireturn
    //   126: iload 4
    //   128: iconst_1
    //   129: iadd
    //   130: istore 4
    //   132: iload_3
    //   133: iconst_1
    //   134: iadd
    //   135: istore_3
    //   136: goto -110 -> 26
    //   139: aload_0
    //   140: getfield 41	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   143: invokevirtual 101	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   146: aload_0
    //   147: getfield 41	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   150: invokevirtual 98	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   153: goto -33 -> 120
    //   156: astore_1
    //   157: aload_0
    //   158: getfield 41	com/tencent/common/config/provider/QZConfigSqliteManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   161: invokevirtual 98	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   164: aload_1
    //   165: athrow
    //   166: astore_1
    //   167: goto -82 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	QZConfigSqliteManager
    //   0	170	1	paramUri	Uri
    //   0	170	2	paramArrayOfContentValues	ContentValues[]
    //   1	135	3	i	int
    //   24	107	4	j	int
    //   21	10	5	k	int
    //   37	11	6	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   39	84	84	android/database/SQLException
    //   139	146	84	android/database/SQLException
    //   12	23	156	finally
    //   39	84	156	finally
    //   85	113	156	finally
    //   139	146	156	finally
    //   12	23	166	android/database/SQLException
  }
  
  public int a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (a())
    {
      i = jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_configs", paramString, paramArrayOfString);
      a();
    }
    return i;
  }
  
  public Cursor a(String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_cookie", paramArrayOfString, null, null, null, null, null);
      a();
    }
    return localCursor;
  }
  
  public Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_navigator_bar", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      a();
    }
    return localCursor;
  }
  
  public Uri a(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_configs", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(jdField_a_of_type_AndroidNetUri, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public void a() {}
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1;
    if (jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      bool1 = bool2;
      if (jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {
        break label53;
      }
    }
    try
    {
      jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigSQLiteHelper.getWritableDatabase();
      if (jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
      {
        bool1 = bool2;
        if (jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {}
      }
      else
      {
        bool1 = false;
      }
      label53:
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigSqliteManager", 2, "provider获取数据库出错", localException);
        }
      }
    }
  }
  
  public int b()
  {
    int i = 0;
    if (a())
    {
      i = jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_check_time", null, null);
      a();
    }
    return i;
  }
  
  public int b(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (a())
    {
      i = jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_isp_config", paramString, paramArrayOfString);
      a();
    }
    return i;
  }
  
  public Cursor b(String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_check_time", paramArrayOfString, null, null, null, null, null);
      a();
    }
    return localCursor;
  }
  
  public Cursor b(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_configs", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      a();
    }
    return localCursor;
  }
  
  public Uri b(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_navigator_bar", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(g, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    boolean bool1;
    if (jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
    {
      bool1 = bool2;
      if (jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {
        break label53;
      }
    }
    try
    {
      jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase = jdField_a_of_type_ComTencentCommonConfigProviderQZoneConfigSQLiteHelper.getReadableDatabase();
      if (jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase != null)
      {
        bool1 = bool2;
        if (jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen()) {}
      }
      else
      {
        bool1 = false;
      }
      label53:
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigSqliteManager", 2, "provider获取数据库出错", localException);
        }
      }
    }
  }
  
  public int c()
  {
    int i = 0;
    if (a()) {
      i = jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_update", null, null);
    }
    return i;
  }
  
  public int c(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (a())
    {
      i = jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("qz_navigator_bar", paramString, paramArrayOfString);
      a();
    }
    return i;
  }
  
  public Cursor c(String[] paramArrayOfString)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_update", paramArrayOfString, null, null, null, null, null);
      a();
    }
    return localCursor;
  }
  
  public Cursor c(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Cursor localCursor = null;
    if (b())
    {
      localCursor = jdField_b_of_type_AndroidDatabaseSqliteSQLiteDatabase.query("qz_isp_config", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      a();
    }
    return localCursor;
  }
  
  public Uri c(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_isp_config", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(e, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public boolean c()
  {
    return jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null;
  }
  
  public int d()
  {
    return 0 + a() + a(null, null) + c() + b() + b(null, null) + c(null, null);
  }
  
  public Uri d(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_cookie", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(jdField_b_of_type_AndroidNetUri, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public Uri e(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_check_time", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(f, l);
      a();
      return paramUri;
    }
    return null;
  }
  
  public Uri f(Uri paramUri, ContentValues paramContentValues)
  {
    if (a())
    {
      long l = jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("qz_update", "", paramContentValues);
      if (l <= 0L) {
        throw new SQLException("failed to insert row into " + paramUri);
      }
      paramUri = ContentUris.withAppendedId(c, l);
      a();
      return paramUri;
    }
    return null;
  }
}
