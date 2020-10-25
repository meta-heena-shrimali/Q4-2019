import java.net.*;
import java.io.*;

class Client{
    public static void main(String args[]) throws Exception{
        try{     
            Socket socket=new Socket("localhost",777);
            DataOutputStream dout= new DataOutputStream(socket.getOutputStream());
            dout.writeUTF("Client Active Now");
            System.out.println("Connection Established...");
            //InputStream in=socket.getInputStream();
            //int x=0;
            //while((x=in.read())!=-1)
            //    System.out.println((char)x);
            
            DataInputStream din=new DataInputStream(socket.getInputStream());  
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
            
            String msgFromClient="",rpyFromServer="";  
            while(!msgFromClient.equalsIgnoreCase("BBye")){  
                msgFromClient=br.readLine();  
                dout.writeUTF(msgFromClient);  
                dout.flush();  
                //if(din.available()>0)
                //{
                    rpyFromServer=din.readUTF();  
                    System.out.println("Server :: "+rpyFromServer);  
               // } 
            }
        }
        catch(Exception e){
            System.out.println(e);
        } 
        finally{
            din.close();
            dout.close();
            socket.close();
        } 
    }
}