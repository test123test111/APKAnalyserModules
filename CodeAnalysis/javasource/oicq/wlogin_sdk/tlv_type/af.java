package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class af
  extends a
{
  int h = 0;
  
  public af()
  {
    g = 296;
  }
  
  public byte[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    paramArrayOfByte2 = paramArrayOfByte3;
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte2 = new byte[0];
    }
    int k = c(arrayOfByte, 32);
    int j = c(paramArrayOfByte1, 16);
    int i = c(paramArrayOfByte2, 16);
    h = (k + 11 + 2 + j + 2 + i);
    paramArrayOfByte3 = new byte[h];
    util.int16_to_buf(paramArrayOfByte3, 0, 0);
    util.int8_to_buf(paramArrayOfByte3, 2, paramInt1);
    util.int8_to_buf(paramArrayOfByte3, 3, paramInt2);
    util.int8_to_buf(paramArrayOfByte3, 4, paramInt3);
    util.int32_to_buf(paramArrayOfByte3, 5, paramInt4);
    util.int16_to_buf(paramArrayOfByte3, 9, k);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte3, 11, k);
    paramInt1 = k + 11;
    util.int16_to_buf(paramArrayOfByte3, paramInt1, j);
    paramInt1 += 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, paramInt1, j);
    paramInt1 += j;
    util.int16_to_buf(paramArrayOfByte3, paramInt1, i);
    paramInt1 += 2;
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt1, i);
    a(g);
    b(paramArrayOfByte3, h);
    d();
    return a();
  }
}
