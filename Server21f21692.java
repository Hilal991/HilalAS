
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server21f21692 implements Runnable
{
   public void run()
   {
     try{
          //DataH conactedH  
            String Hhost="jdbc:derby://localhost:1527/HILAL123";
            String Huname="HILAL";
            String Hpass="12345";
            
            Connection HIconn=DriverManager.getConnection(Hhost, Huname, Hpass);
            
            ServerSocket Hilalsas = new ServerSocket (5510);
            System.out.println("Server is fine ");
            System.out.println("----------------------------------");
                    
            
             while(true){
                Socket HilalSoc = Hilalsas.accept();


                DataInputStream Hdiss = new DataInputStream(HilalSoc.getInputStream());
                int HilalCode = Hdiss.readInt();
                int Hilalreq = Hdiss.readInt();
                
                 System.out.println("The code is:"+HilalCode);
                System.out.println("The required quantity is"+Hilalreq);
              
                 Statement Hilalsk=HIconn.createStatement();
            String Htab="SELECT * FROM BEVERAGE WHERE BEVERAGECODE="+HilalCode;
            
            
            ResultSet Hilalrs=Hilalsk.executeQuery(Htab);
          
            
//send to Hilal cl 
            DataOutputStream Hdooss = new DataOutputStream(HilalSoc.getOutputStream());
                while(Hilalrs.next()){
                 
                    
                   //show the table in output
                    int HILALCode1=Hilalrs.getInt(1);
                     String HILALName2=Hilalrs.getString(2);
                     double Hilalprice2 = Hilalrs.getDouble(3);
                
                     

                   
                    
                    //solv the problme
                    
                    String Hilalna=Hilalrs.getString("BEVERAGENAME");
                    
                    
                    double hilalnp=Hilalrs.getDouble("BEVERAGEPRICE");      
                    
                    double Hpr=Hilalrs.getDouble("BEVERAGEPRICE");
                    double Hilalprice= Hilalreq*Hpr;
                    
                   
                    Hdooss.writeUTF(Hilalna);
                    Hdooss.writeDouble(Hilalprice);
                    Hdooss.writeDouble(hilalnp);
                  
                    
                    System.out.println("---------------------------");
                    
                    System.out.println(HILALCode1+"  "+HILALName2+"  "+Hilalprice2);
                    System.out.println("-----------------------------");
                    
                    System.out.println("Send to the cliet");
                    System.out.println("--------------------------------");
                    
                    Hdooss.flush();
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                }  
                }

             }
             catch(SQLException e)
            
                        {
                        System.out.println(e);
   }   catch (IOException ex) {
           Logger.getLogger(Server21f21692.class.getName()).log(Level.SEVERE, null, ex);
       }
}
}

