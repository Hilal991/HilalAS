import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client21f21692 implements Runnable
{
    
   
    public void run()
    
    {
       try{
            Socket HilalSoc=new Socket("localhost",5510);
           
            //scanner code
            Scanner Hilalscan=new Scanner(System.in);
            System.out.println("Enter BEVERAGE CODE 100*   1 to 7 ");
            
            int HilalCode=Hilalscan.nextInt();
           
            //scanner req
            System.out.println("Enter the required quantity");
            int Hilalreq=Hilalscan.nextInt();
            
            //send to Server 2 val
            
            DataOutputStream Hilaldos=new DataOutputStream(HilalSoc.getOutputStream());
            Hilaldos.writeInt(HilalCode); 
            Hilaldos.writeInt(Hilalreq);
            Hilaldos.flush();
            
            
            //receive the prise and name
            DataInputStream Hilaldis=new DataInputStream(HilalSoc.getInputStream());
            String Hilalna=Hilaldis.readUTF();
              double hilalnp=Hilaldis.readDouble();
            double Hilalprice=Hilaldis.readDouble();
            
            
            
            //disply 4 ans
            System.out.println("-------------------------------------");
            System.out.println("the code is "+HilalCode);
            System.out.println("The NAME IS:"+Hilalna);
            System.out.println("num of cup : "+Hilalreq);
            System.out.println("-------------------------------------");
            System.out.println("price for one pice is:OMR "+Hilalprice);
            System.out.println("Total pris is:OMR "+hilalnp);
            System.out.println("-------------------------------------");
           
            
          
            
        
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
} 
   
