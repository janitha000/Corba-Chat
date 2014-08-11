
import CiaoApp.*;          // The package containing our stubs. 
import java.util.ArrayList;
import java.util.HashMap;
import org.omg.CosNaming.*; // HelloServer will use the naming service. 
import org.omg.CosNaming.NamingContextPackage.*; // ..for exceptions. 
import org.omg.CORBA.*;     // All CORBA applications need these classes. 
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

class CiaoServant extends CiaoPOA {

    private ORB orb;
    private ArrayList<String> chatList;
    public ArrayList<CiaoCallback> usersList;

    public void setORB(ORB orb_val) {
        orb = orb_val;
		usersList= new ArrayList<>();
    }
	
	public void register(CiaoCallback callobj){
		usersList.add(callobj);
	}

    public String say( String id, String msg) {
	String msgToPrint;
		System.out.println(usersList.size());
        //if (chatList == null) {
        //    chatList = new ArrayList<>();
        //}
		//for(CiaoCallback obj : usersList){
		for (int i = 0; i < usersList.size(); i++){
		CiaoCallback obj= usersList.get(i);
				System.out.println(id);

        obj.callback(id + ": " + msg);
         msgToPrint = id + ": " + msg;
		}
		return "YEEEPPEEEE";
        //return "\n Ciao Mondo!! \n";
    }
}

public class CiaoServer {

    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);

            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            CiaoServant ciaoImpl = new CiaoServant();
            ciaoImpl.setORB(orb);

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(ciaoImpl);
            Ciao cref = CiaoHelper.narrow(ref);

            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Ciao";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, cref);

		    
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}