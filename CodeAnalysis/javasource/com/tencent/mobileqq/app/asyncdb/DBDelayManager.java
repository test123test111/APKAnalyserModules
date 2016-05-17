package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;

public class DBDelayManager
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = "Q.db.Cache";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Vector jdField_a_of_type_JavaUtilVector;
  boolean jdField_a_of_type_Boolean;
  
  public DBDelayManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_a_of_type_Boolean = false;
  }
  
  private void a(EntityManager paramEntityManager)
  {
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      BaseDBQueueItem localBaseDBQueueItem;
      String str;
      ProxyListener localProxyListener;
      synchronized (jdField_a_of_type_JavaUtilVector)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "transSaveToDatabase writeRunable msgQueue size:" + jdField_a_of_type_JavaUtilVector.size());
        }
        if (jdField_a_of_type_JavaUtilVector.isEmpty()) {
          return;
        }
        Object localObject3 = (List)jdField_a_of_type_JavaUtilVector.clone();
        jdField_a_of_type_JavaUtilVector.clear();
        if (localObject3 == null) {
          break label477;
        }
        localObject2 = null;
        ??? = null;
        try
        {
          localEntityTransaction = paramEntityManager.a();
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localEntityTransaction.a();
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localObject3 = ((List)localObject3).iterator();
        }
        catch (Exception paramEntityManager)
        {
          localObject2 = ???;
          paramEntityManager.printStackTrace();
          localObject2 = ???;
          if (!QLog.isColorLevel()) {
            break label351;
          }
          localObject2 = ???;
          QLog.w("Q.db.Cache", 2, "writeRunable write exception: " + paramEntityManager.getMessage());
          if (??? == null) {
            break label477;
          }
          ((EntityTransaction)???).b();
          return;
          paramEntityManager = finally;
          throw paramEntityManager;
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          paramEntityManager.a(jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
          if (localProxyListener == null) {
            continue;
          }
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localProxyListener.a(str, 1);
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            break label414;
          }
          localObject2.b();
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (!((Iterator)localObject3).hasNext()) {
          break label456;
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localBaseDBQueueItem = (BaseDBQueueItem)((Iterator)localObject3).next();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        str = jdField_a_of_type_ComTencentMobileqqPersistenceEntity.getTableName();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener = jdField_a_of_type_ComTencentMobileqqAppAsyncdbProxyListener;
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (QLog.isColorLevel())
        {
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          QLog.d("Q.db.Cache", 2, "writeRunable QueueItem.action: " + g);
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        switch (g)
        {
        case 0: 
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          paramEntityManager.b(jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
          if (localProxyListener == null) {
            continue;
          }
          ??? = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localProxyListener.a(str);
        }
      }
      label351:
      label414:
      ??? = localEntityTransaction;
      Object localObject2 = localEntityTransaction;
      paramEntityManager.b(jdField_a_of_type_ComTencentMobileqqPersistenceEntity);
      if (localProxyListener != null)
      {
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localProxyListener.b(str, 1);
        continue;
        label456:
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.c();
        if (localEntityTransaction != null) {
          localEntityTransaction.b();
        }
        label477:
        return;
      }
    }
  }
  
  public Vector a()
  {
    return jdField_a_of_type_JavaUtilVector;
  }
  
  public void a() {}
  
  public void a(Entity paramEntity, int paramInt)
  {
    a(paramEntity, paramInt, 0, null);
  }
  
  public void a(Entity paramEntity, int paramInt1, int paramInt2)
  {
    a(paramEntity, paramInt1, paramInt2, null);
  }
  
  public void a(Entity arg1, int paramInt1, int paramInt2, ProxyListener paramProxyListener)
  {
    paramProxyListener = new BaseDBQueueItem(???, paramInt1, paramInt2, paramProxyListener);
    do
    {
      synchronized (jdField_a_of_type_JavaUtilVector)
      {
        jdField_a_of_type_JavaUtilVector.add(paramProxyListener);
        if (jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache", 2, "addQueue after destroy");
          }
          b();
          return;
        }
      }
      switch (paramInt2)
      {
      case 2: 
      default: 
        return;
      }
    } while (!jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause);
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "addMsgQueue write notify");
    }
    b();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "addMsgQueue write notify");
    }
    b();
  }
  
  public void a(Entity paramEntity, int paramInt, ProxyListener paramProxyListener)
  {
    a(paramEntity, paramInt, 0, paramProxyListener);
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "transSaveToDatabase");
    }
    EntityManager localEntityManager = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    a(localEntityManager);
    localEntityManager.a();
  }
  
  public void d()
  {
    synchronized (jdField_a_of_type_JavaUtilVector)
    {
      jdField_a_of_type_JavaUtilVector.clear();
      return;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      jdField_a_of_type_Boolean = true;
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}
