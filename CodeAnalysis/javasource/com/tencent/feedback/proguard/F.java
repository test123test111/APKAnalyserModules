package com.tencent.feedback.proguard;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class F
  implements H
{
  private String a = null;
  
  public F() {}
  
  public final void a(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.length();
      while (i < 16)
      {
        paramString = paramString + "0";
        i += 1;
      }
      a = paramString.substring(0, 16);
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
    throws Exception
  {
    int j = 0;
    if ((a == null) || (paramArrayOfByte == null))
    {
      paramArrayOfByte = null;
      return paramArrayOfByte;
    }
    Object localObject1 = new StringBuffer();
    int k = paramArrayOfByte.length;
    int i = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      ((StringBuffer)localObject1).append(m + " ");
      i += 1;
    }
    localObject1 = new SecretKeySpec(a.getBytes(), "AES");
    Object localObject2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
    ((Cipher)localObject2).init(2, (Key)localObject1, new IvParameterSpec(a.getBytes()));
    localObject1 = ((Cipher)localObject2).doFinal(paramArrayOfByte);
    localObject2 = new StringBuffer();
    k = localObject1.length;
    i = j;
    for (;;)
    {
      paramArrayOfByte = (byte[])localObject1;
      if (i >= k) {
        break;
      }
      j = localObject1[i];
      ((StringBuffer)localObject2).append(j + " ");
      i += 1;
    }
  }
  
  public final byte[] b(byte[] paramArrayOfByte)
    throws Exception, NoSuchAlgorithmException
  {
    int j = 0;
    if ((a == null) || (paramArrayOfByte == null))
    {
      paramArrayOfByte = null;
      return paramArrayOfByte;
    }
    Object localObject1 = new StringBuffer();
    int k = paramArrayOfByte.length;
    int i = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      ((StringBuffer)localObject1).append(m + " ");
      i += 1;
    }
    localObject1 = new SecretKeySpec(a.getBytes(), "AES");
    Object localObject2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
    ((Cipher)localObject2).init(1, (Key)localObject1, new IvParameterSpec(a.getBytes()));
    localObject1 = ((Cipher)localObject2).doFinal(paramArrayOfByte);
    localObject2 = new StringBuffer();
    k = localObject1.length;
    i = j;
    for (;;)
    {
      paramArrayOfByte = (byte[])localObject1;
      if (i >= k) {
        break;
      }
      j = localObject1[i];
      ((StringBuffer)localObject2).append(j + " ");
      i += 1;
    }
  }
}