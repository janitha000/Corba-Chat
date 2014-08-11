package CiaoApp;


/**
* CiaoApp/_CiaoStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Ciao.idl
* Monday, 11 August 2014 14:30:09 o'clock IST
*/

public class _CiaoStub extends org.omg.CORBA.portable.ObjectImpl implements CiaoApp.Ciao
{

  public String say (CiaoApp.CiaoCallback objref, String id, String message)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("say", true);
                CiaoApp.CiaoCallbackHelper.write ($out, objref);
                $out.write_string (id);
                $out.write_string (message);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return say (objref, id, message        );
            } finally {
                _releaseReply ($in);
            }
  } // say

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CiaoApp/Ciao:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _CiaoStub
