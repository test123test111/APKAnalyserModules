import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder.EncodeHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class lap
  extends AsyncTask
{
  MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  String jdField_b_of_type_JavaLangString;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  
  public lap(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    paramVarArgs = null;
    if ((jdField_a_of_type_JavaLangRefWeakReference == null) || (jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return Integer.valueOf(7);
    }
    Object localObject = (Context)jdField_a_of_type_JavaLangRefWeakReference.get();
    if (jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
      return Integer.valueOf(7);
    }
    MessageForShortVideo localMessageForShortVideo = jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if (FileUtils.b(videoFileName))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPTVItemBuilder", 2, "mr.videoFileName is not null...");
      }
      return Integer.valueOf(5);
    }
    LogTag.a();
    localObject = new EncodeThread((Context)localObject, new ShortVideoPTVItemBuilder.EncodeHandler(Looper.getMainLooper()), mVideoFileSourceDir, null, null);
    ((EncodeThread)localObject).run();
    String str2 = jdField_a_of_type_JavaLangString;
    LogTag.a("ShortVideoPTVItemBuilder", "EncodeThread");
    if (!FileUtils.b(str2)) {
      return Integer.valueOf(8);
    }
    localObject = new File(str2);
    long l = ((File)localObject).length();
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPTVItemBuilder", 2, "mVideoSize = 0");
      }
      return Integer.valueOf(8);
    }
    try
    {
      localObject = new FileInputStream((File)localObject);
      if (localObject != null)
      {
        localObject = HexUtil.bytes2HexStr(MD5.toMD5Byte((InputStream)localObject, l));
        paramVarArgs = (Void[])localObject;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoPTVItemBuilder", 2, "processThumb: mVideoMd5 is empty, " + (String)localObject);
          }
          return Integer.valueOf(5);
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      if (0 != 0)
      {
        str1 = HexUtil.bytes2HexStr(MD5.toMD5Byte(null, l));
        paramVarArgs = str1;
        if (TextUtils.isEmpty(str1))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoPTVItemBuilder", 2, "processThumb: mVideoMd5 is empty, " + str1);
          }
          return Integer.valueOf(5);
        }
      }
    }
    finally
    {
      String str1;
      if (0 != 0)
      {
        str1 = HexUtil.bytes2HexStr(MD5.toMD5Byte(null, l));
        if (TextUtils.isEmpty(str1))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoPTVItemBuilder", 2, "processThumb: mVideoMd5 is empty, " + str1);
          }
          return Integer.valueOf(5);
        }
      }
    }
    jdField_a_of_type_JavaLangString = paramVarArgs;
    jdField_b_of_type_JavaLangString = str2;
    videoFileSize = ((int)l);
    if (FileUtils.b(mThumbFilePath))
    {
      paramVarArgs = ShortVideoUtils.a(thumbMD5, "jpg");
      if (!paramVarArgs.equals(mThumbFilePath))
      {
        if (!FileUtils.c(paramVarArgs, mThumbFilePath)) {
          return Integer.valueOf(5);
        }
        mThumbFilePath = paramVarArgs;
      }
    }
    return Integer.valueOf(1);
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    switch (paramInteger.intValue())
    {
    }
    do
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "Error code " + paramInteger);
        }
        return;
      } while (jdField_b_of_type_JavaLangRefWeakReference == null);
      paramInteger = (QQAppInterface)jdField_b_of_type_JavaLangRefWeakReference.get();
      if (paramInteger != null)
      {
        Object localObject1 = jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
        md5 = jdField_a_of_type_JavaLangString;
        Object localObject2 = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
        if (!jdField_b_of_type_JavaLangString.equals(localObject2))
        {
          FileUtils.c(jdField_b_of_type_JavaLangString, (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "onPostExecute destVideoPath " + (String)localObject2);
          }
        }
        videoFileName = ((String)localObject2);
        ((MessageForShortVideo)localObject1).serial();
        paramInteger.a().a(frienduin, istroop, uniseq, msgData);
        localObject2 = ShortVideoBusiManager.a(0, 3);
        localObject1 = ShortVideoBusiManager.a(localObject1, (ShortVideoReq)localObject2);
        b = false;
        ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
        ShortVideoBusiManager.a((ShortVideoReq)localObject2, paramInteger);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoPTVItemBuilder", 2, "QQAppInterface is null...");
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}
