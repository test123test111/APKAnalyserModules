import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class kpn
  implements BluetoothProfile.ServiceListener
{
  public kpn(AudioPlayer paramAudioPlayer, String paramString, int paramInt, BluetoothAdapter paramBluetoothAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    Object localObject;
    if (paramInt == 1)
    {
      paramBluetoothProfile = (BluetoothHeadset)paramBluetoothProfile;
      localObject = paramBluetoothProfile.getConnectedDevices();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label87;
      }
      localObject = (BluetoothDevice)((List)localObject).get(0);
      if (localObject != null) {
        break label76;
      }
      paramInt = 0;
      AudioPlayer.a(paramInt);
    }
    for (;;)
    {
      AudioPlayer.a(jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int);
      jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, paramBluetoothProfile);
      return;
      label76:
      paramInt = ((BluetoothDevice)localObject).getBluetoothClass().getDeviceClass();
      break;
      label87:
      AudioPlayer.a(0);
    }
  }
  
  public void onServiceDisconnected(int paramInt) {}
}
