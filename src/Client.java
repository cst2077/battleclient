

import java.net.*;
import java.util.Scanner;
import java.io.*;

import javax.swing.SwingUtilities;



public class Client implements Runnable{
	volatile int playerX = 3001;
	volatile int playerY = 300;
	Craft crObj=null;
	public Client(){
		crObj = new Craft();
	}
	public Client( Craft newcrObj){
		crObj = newcrObj;
	}
   public void run() {

	  // Craft crObj = null;

       String serverName = "127.0.0.1";
       int port = 6789;
       int port1 = 6788;
       Socket client = null, client1 = null;
       System.out.println("Connecting to " + serverName + " on port " + port);
       OutputStream outsetup = null, out1setup = null;
       
       
 	   try {
       client = new Socket(serverName, port);
	   client1 = new Socket(serverName, port1);
 	   } catch (IOException e) {
 		   System.out.println(e);
 	   }
	   System.out.println("Connected");
	   
	   Scanner test = new Scanner(System.in);
	   try {
		    outsetup = client.getOutputStream();
		    out1setup = client1.getOutputStream();
	   } catch(IOException e) {
		   System.out.println(e);
	   }
 	   DataOutputStream out = new DataOutputStream(outsetup);
 	   DataOutputStream out1 = new DataOutputStream(out1setup);
          
      
       while(true) {
       	   playerX = crObj.x;
    	   playerY = crObj.y;
     	   try{
     		   Thread.sleep(10);
        	   System.out.println(playerY);
     		   out.writeInt(playerX);
     		   out.flush();
	     	   out1.writeInt(playerY);
	     	   out1.flush();
	     	   
     	   } catch (IOException e) {
			e.printStackTrace();
     	   } catch (InterruptedException e) {
			e.printStackTrace();
		}
      }
      //client.close();
     //client1.close();
   }
}

