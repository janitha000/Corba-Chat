package CiaoApp;

/**
* CiaoApp/CiaoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Ciao.idl
* Monday, 11 August 2014 14:17:45 o'clock IST
*/

public final class CiaoHolder implements org.omg.CORBA.portable.Streamable
{
  public CiaoApp.Ciao value = null;

  public CiaoHolder ()
  {
  }

  public CiaoHolder (CiaoApp.Ciao initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CiaoApp.CiaoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CiaoApp.CiaoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CiaoApp.CiaoHelper.type ();
  }

}
