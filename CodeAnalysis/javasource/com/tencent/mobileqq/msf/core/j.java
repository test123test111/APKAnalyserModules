package com.tencent.mobileqq.msf.core;

import java.io.File;
import java.util.Comparator;

class j
  implements Comparator
{
  j(i paramI) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() > paramFile2.lastModified()) {
      return 1;
    }
    return 0;
  }
}
