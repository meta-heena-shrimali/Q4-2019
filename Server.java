import java.net.*;
import java.io.*;

class Server{
    public static void main(String args[]) throws Exception{
        try{  
            ServerSocket serverSocket= new ServerSocket(777);
            System.out.println("Server Active...");
            Socket socket=serverSocket.accept();
            DataInputStream din= new DataInputStream(socket.getInputStream());
            DataOutputStream dout= new DataOutputStream(socket.getOutputStream());
            
            //System.out.println(din.readUTF());
            //din.close();
            //OutputStream obj=socket.getOutputStream();
            //String str="Hello Client";
            //byte b[]=str.getBytes();
            //obj.write(b);

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
    
            String msgFromClient="",rpyFromServer="";  
            while(!msgFromClient.equalsIgnoreCase("BBye")){  
               // if(din.available()>0)
                //{
                    msgFromClient=din.readUTF();  
                    System.out.println("client :: "+msgFromClient);  
                //}
                rpyFromServer=br.readLine();  
                dout.writeUTF(rpyFromServer);  
                dout.flush();  
            }        
        }
        catch(Exception e){
            System.out.println(e);
        } 
        finally{
            din.close();
            dout.close();
            socket.close();
            serverSocket.close();
        }   
    }
}