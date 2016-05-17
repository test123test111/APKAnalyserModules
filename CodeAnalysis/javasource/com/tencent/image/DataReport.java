package com.tencent.image;

import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedList;

public class DataReport
{
  public static final int CONTINUOUS_DROP_TIMES = 5;
  public static final String EVENTCODE_SHORTVIDEO_PLAY = "ShortVideo.Play";
  public static final String PARAM_FRAM_DELAY_TIME = "param_framDelayTime";
  private final String TAG = "URLDrawable_DataReport";
  private LinkedList<Integer> mList = new LinkedList();
  
  public DataReport() {}
  
  private void doReport(LinkedList<Integer> paramLinkedList)
  {
    long l1 = System.currentTimeMillis();
    if ((paramLinkedList == null) || (paramLinkedList.size() < 5)) {}
    int i;
    long l2;
    do
    {
      return;
      int j = 0;
      int k = paramLinkedList.size();
      i = 0;
      while (i < k)
      {
        j += ((Integer)paramLinkedList.get(i)).intValue();
        i += 1;
      }
      i = (int)(j / k);
      paramLinkedList = new HashMap();
      paramLinkedList.put("param_framDelayTime", String.valueOf(i));
      UserAction.onUserAction("ShortVideo.Play", true, -1L, -1L, paramLinkedList, false);
      l2 = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d("URLDrawable_DataReport", 2, "doReport(), cost:" + (l2 - l1) + "ms, averageTime=" + i);
  }
  
  public void onVideoFrameDroped(boolean paramBoolean, int paramInt)
  {
    int i = mList.size();
    if (paramBoolean)
    {
      mList.add(Integer.valueOf(paramInt));
      if (i >= 5)
      {
        doReport(mList);
        mList.clear();
      }
      return;
    }
    if (i < 5)
    {
      mList.clear();
      return;
    }
    doReport(mList);
    mList.clear();
  }
}
