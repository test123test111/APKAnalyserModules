package org.apache.http.impl.execchain;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;

@Immutable
public class TunnelRefusedException
  extends HttpException
{
  private static final long serialVersionUID = -8646722842745617323L;
  private final HttpResponse response;
  
  public TunnelRefusedException(String paramString, HttpResponse paramHttpResponse)
  {
    super(paramString);
    response = paramHttpResponse;
  }
  
  public HttpResponse getResponse()
  {
    return response;
  }
}
