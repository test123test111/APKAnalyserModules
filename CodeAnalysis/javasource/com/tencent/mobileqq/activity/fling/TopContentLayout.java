package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import lun;

public class TopContentLayout
  extends RelativeLayout
{
  private static final int jdField_a_of_type_Int = 350;
  private static final String jdField_a_of_type_JavaLangString = TopContentLayout.class.getSimpleName();
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private ContentWrapView jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView;
  private TopContentLayout.OnOutScreenListener jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout$OnOutScreenListener;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TopContentLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TopContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopContentLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new lun(this, paramContext));
    jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  public void computeScroll()
  {
    if (jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      int i = jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      int j = jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      movingViewTrans(i, j);
      if (jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout$OnOutScreenListener != null) {
        jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout$OnOutScreenListener.outing(i, j, this);
      }
      invalidate();
    }
  }
  
  public float getMovingViewTransX()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView != null) {
      return jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView.getTransX();
    }
    return 0.0F;
  }
  
  public int getMovingViewWidth()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView != null) {
      return jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView.getWidth();
    }
    return getWidth();
  }
  
  public TopContentLayout.OnOutScreenListener getOnOutScreenListener()
  {
    return jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout$OnOutScreenListener;
  }
  
  public void movingViewTrans(float paramFloat1, float paramFloat2)
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView != null)
    {
      jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView.transX(paramFloat1);
      jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView.transY(paramFloat2);
    }
  }
  
  public void movingViewTransBy(float paramFloat1, float paramFloat2)
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView != null)
    {
      jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView.transXBy(paramFloat1);
      jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView.transYBy(paramFloat2);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    int i;
    int j;
    if ((paramMotionEvent.getAction() == 1) && (jdField_a_of_type_Boolean))
    {
      jdField_a_of_type_Boolean = false;
      i = getMovingViewWidth();
      j = (int)Math.abs(getMovingViewTransX());
      if (j <= i / 2) {
        break label80;
      }
      i -= j;
    }
    for (;;)
    {
      jdField_a_of_type_AndroidWidgetScroller.startScroll((int)getMovingViewTransX(), 0, i, 0, 350);
      invalidate();
      return bool;
      label80:
      i = -j;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    int j;
    if ((i == 1) && (jdField_a_of_type_Boolean))
    {
      jdField_a_of_type_Boolean = false;
      i = getMovingViewWidth();
      j = (int)Math.abs(getMovingViewTransX());
      if (j <= i / 2) {
        break label80;
      }
      i -= j;
    }
    for (;;)
    {
      jdField_a_of_type_AndroidWidgetScroller.startScroll((int)getMovingViewTransX(), 0, i, 0, 350);
      invalidate();
      return true;
      label80:
      i = -j;
    }
  }
  
  public void setContent(ContentWrapView paramContentWrapView)
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView != null) {
      removeView(jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView);
    }
    jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView = paramContentWrapView;
    addView(jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView);
  }
  
  public void setOnOutScreenListener(TopContentLayout.OnOutScreenListener paramOnOutScreenListener)
  {
    jdField_a_of_type_ComTencentMobileqqActivityFlingTopContentLayout$OnOutScreenListener = paramOnOutScreenListener;
  }
}
