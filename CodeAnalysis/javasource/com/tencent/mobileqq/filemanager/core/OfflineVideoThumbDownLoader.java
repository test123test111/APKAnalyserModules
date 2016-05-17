package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import osz;

public class OfflineVideoThumbDownLoader
  extends BaseThumbDownloader
{
  private static final String jdField_a_of_type_JavaLangString = "OfflineVideoThumbDownLoader<FileAssistant>";
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  
  public OfflineVideoThumbDownLoader(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new osz(this);
    paramQQAppInterface.a().addObserver(jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  private OfflineVideoThumbDownLoader.VideoSession a(long paramLong, boolean paramBoolean)
  {
    BaseThumbDownloader.Session localSession = a(paramLong);
    if (localSession == null) {
      return null;
    }
    if ((localSession instanceof OfflineVideoThumbDownLoader.VideoSession)) {
      return (OfflineVideoThumbDownLoader.VideoSession)localSession;
    }
    QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + paramLong + "] no instance");
    return null;
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + nSessionId + "]");
    if (Uuid == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + nSessionId + "]");
      jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    int i = a(fileName);
    if (-1 == i)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  download. can not getThumb of file:" + fileName);
      jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    String str = Uuid.replace("/", "");
    a();
    str = FMSettings.a().d() + a(paramInt, str);
    if (FileUtils.b(str) == true) {
      return str;
    }
    paramFileManagerEntity = new OfflineVideoThumbDownLoader.VideoSession(paramFileManagerEntity);
    jdField_a_of_type_Int = paramInt;
    b = i;
    a(paramFileManagerEntity, str);
    return null;
  }
  
  public void a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
  
  public void a(long paramLong, HttpMsg paramHttpMsg)
  {
    e = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    OfflineVideoThumbDownLoader.VideoSession localVideoSession = a(paramLong, false);
    if (localVideoSession == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramString;
      jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramDownloadTask);
  }
  
  public boolean a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    paramDownloadTask = a(paramLong, false);
    if (paramDownloadTask == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
}