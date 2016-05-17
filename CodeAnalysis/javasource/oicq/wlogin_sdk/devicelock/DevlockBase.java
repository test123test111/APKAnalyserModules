package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.util;

public class DevlockBase
{
  private static int _seq = 0;
  public static DevlockRst rst = new DevlockRst();
  public int Role = 505;
  private int _head_len = 110;
  protected int _msgType = 0;
  private int _version = 32;
  
  public DevlockBase() {}
  
  public byte[] _get_request(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[_head_len + 1 + paramArrayOfByte.length + 1];
    util.int8_to_buf(arrayOfByte, 0, 2);
    util.int16_to_buf(arrayOfByte, 1, arrayOfByte.length);
    util.int64_to_buf32(arrayOfByte, 3, paramLong1);
    util.int16_to_buf(arrayOfByte, 9, _msgType);
    util.int64_to_buf32(arrayOfByte, 11, paramLong2);
    int i = _seq;
    _seq = i + 1;
    util.int32_to_buf(arrayOfByte, 27, i);
    util.int16_to_buf(arrayOfByte, 39, u.s);
    util.int16_to_buf(arrayOfByte, 43, _version);
    util.int8_to_buf(arrayOfByte, 45, 0);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 111, paramArrayOfByte.length);
    i = paramArrayOfByte.length + 111;
    util.int8_to_buf(arrayOfByte, i, 3);
    return arrayOfByte;
  }
  
  public int get_msgType()
  {
    return _msgType;
  }
  
  public int parse_rsp(byte[] paramArrayOfByte)
  {
    int j;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < _head_len + 2)) {
      j = 64527;
    }
    int i;
    label76:
    do
    {
      return j;
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - _head_len - 2];
      System.arraycopy(paramArrayOfByte, _head_len + 1, arrayOfByte, 0, arrayOfByte.length);
      if (2 > arrayOfByte.length) {
        return 64527;
      }
      int n = util.buf_to_int16(arrayOfByte, 0);
      int k = 0;
      j = 2;
      i = 0;
      if (k < n)
      {
        paramArrayOfByte = pickup_TLV(arrayOfByte, j);
        if (paramArrayOfByte == null) {
          return 64527;
        }
        int m = j + paramArrayOfByte.length;
        switch (util.buf_to_int16(paramArrayOfByte, 0))
        {
        case 2: 
        case 5: 
        case 7: 
        case 9: 
        case 10: 
        case 12: 
        case 13: 
        case 15: 
        case 16: 
        case 17: 
        default: 
          i = 0;
        }
        for (;;)
        {
          j = i;
          if (i != 0) {
            break;
          }
          k += 1;
          j = m;
          break label76;
          i = rstcommRsp.set_buf(paramArrayOfByte, paramArrayOfByte.length);
          continue;
          i = rstdevSetupInfo.set_buf(paramArrayOfByte, paramArrayOfByte.length);
          continue;
          i = rstmbGuideInfo.set_buf(paramArrayOfByte, paramArrayOfByte.length);
          continue;
          i = rstmbMobileInfo.set_buf(paramArrayOfByte, paramArrayOfByte.length);
          continue;
          i = rstquerySig.set_buf(paramArrayOfByte, paramArrayOfByte.length);
          continue;
          i = rstsppKey.set_buf(paramArrayOfByte, paramArrayOfByte.length);
          continue;
          i = rstsmsInfo.set_buf(paramArrayOfByte, paramArrayOfByte.length);
          continue;
          i = rstdevGuideInfo.set_buf(paramArrayOfByte, paramArrayOfByte.length);
          continue;
          i = rsttransferInfo.set_buf(paramArrayOfByte, paramArrayOfByte.length);
        }
      }
      j = i;
    } while (i != 0);
    return rstcommRsp.RetCode;
  }
  
  public byte[] pickup_TLV(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < paramInt + 4)) {}
    int i;
    do
    {
      return null;
      i = util.buf_to_int16(paramArrayOfByte, paramInt + 2) + 4;
    } while (paramArrayOfByte.length < paramInt + i);
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public static final class a
  {
    public static int a = 5;
    public static int b = 7;
    public static int c = 8;
  }
}
