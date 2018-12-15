import java.io.*;
import java.net.*;
import java.util.*;
public class Client
{
  public static void main(String[] args)
  {
    
    Scanner in=new Scanner(System.in);
    try
    {
      Socket s=new Socket("192.168.1.34",50000);
      DataInputStream din=new DataInputStream(s.getInputStream());
      DataOutputStream dout=new DataOutputStream(s.getOutputStream());
      System.out.println("At any point enter XO to terminate chat");
      while(true)
      {
        System.out.println("Enter Message:");
        String s1=in.nextLine();
        if(s1=="XO")
        {
          break;
        }
        dout.writeUTF(s1);
        dout.flush();
        String s2=din.readUTF();
        System.out.println("Bhai ka sandesh aaya hai:"+s2);
      }
      dout.close();
      s.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}
