import CiaoApp.*;          // The package containing our stubs
import org.omg.CosNaming.*; // HelloClient will use the naming service.
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;     // All CORBA applications need these classes.
import org.omg.PortableServer.*;   
import org.omg.PortableServer.POA;
import java.util.Scanner;


 
class CiaoCallbackServant extends CiaoCallbackPOA
{
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    public void callback(String notification)
    {
        System.out.println(notification);
    }
}

public class CiaoClient
{
    static Ciao ciaoImpl;
    
    public static void main(String args[])
    {
	try {
	    ORB orb = ORB.init(args, null);
	    POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

	    org.omg.CORBA.Object objRef = 
                     orb.resolve_initial_references("NameService");
	    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

	    String name = "Ciao";
	    ciaoImpl = CiaoHelper.narrow(ncRef.resolve_str(name));
	    
	    CiaoCallbackServant ciaoCallbackImpl = new CiaoCallbackServant();
	    ciaoCallbackImpl.setORB(orb);

	    org.omg.CORBA.Object ref = rootpoa.servant_to_reference(ciaoCallbackImpl);
	    CiaoCallback cref = CiaoCallbackHelper.narrow(ref);
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your UserName: ");
		String id = in.nextLine();
        boolean exit=false;
		while(!exit){
		System.out.print(id+ ": ");
		String msg = in.nextLine();

	    String ciao = ciaoImpl.say(cref,id,msg);
	    //System.out.println(ciao);
		
		}

	} catch(Exception e){
	    System.out.println("ERROR : " + e);
	    e.printStackTrace(System.out);
	}
    }
}