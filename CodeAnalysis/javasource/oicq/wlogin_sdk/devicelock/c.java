package oicq.wlogin_sdk.devicelock;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<DevlockInfo>
{
  c() {}
  
  public DevlockInfo a(Parcel paramParcel)
  {
    return new DevlockInfo(paramParcel, null);
  }
  
  public DevlockInfo[] a(int paramInt)
  {
    return new DevlockInfo[paramInt];
  }
}
