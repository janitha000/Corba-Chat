package CiaoApp;


/**
* CiaoApp/CiaoPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Ciao.idl
* Monday, 11 August 2014 17:53:42 o'clock IST
*/

public abstract class CiaoPOA extends org.omg.PortableServer.Servant
 implements CiaoApp.CiaoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("say", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CiaoApp/Ciao/say
       {
         CiaoApp.CiaoCallback objref = CiaoApp.CiaoCallbackHelper.read (in);
         String id = in.read_string ();
         String message = in.read_string ();
         String $result = null;
         $result = this.say (objref, id, message);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CiaoApp/Ciao:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Ciao _this() 
  {
    return CiaoHelper.narrow(
    super._this_object());
  }

  public Ciao _this(org.omg.CORBA.ORB orb) 
  {
    return CiaoHelper.narrow(
    super._this_object(orb));
  }


} // class CiaoPOA
