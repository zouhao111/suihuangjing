package com.erich.saleticket.controllers.admin.tdht; 
 
import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.Socket; 
 
public class Client { 
	
	
    public static final String IP_ADDR = "192.168.1.141";//服务器地址  
    public static final int PORT = 8080;//服务器端口号   
     
    public void connect(int i){   
        System.out.println("客户端启动...");   
        System.out.println("当接收到服务器端字符为 \"OK\" 的时候, 客户端将终止\n");  
          
            Socket socket = null; 
            try { 
                //创建一个流套接字并将其连接到指定主机上的指定端口号 
                socket = new Socket(IP_ADDR, PORT);   
                   
                //读取服务器端数据   
                DataInputStream input = new DataInputStream(socket.getInputStream());   
                //向服务器端发送数据   
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());   
                String str = i+""; 
               // byte[]b={0x35,0x19,0x00,0x00,0x00,0x06,0x01,0x06,0x01,0x10,0x00,0x01,0x48,0x33 };
                 
    			//socket.getOutputStream().write(b, 0, b.length);
               // byte[]b={0x35,0x19,0x00,0x00,0x00,0x06,0x01,0x06,0x01,0x10,0x00,0x00,0xF3,0x89 };
                // 35 19 00 00 00 06 01 06 01 10 00 00 F3 89  
              //  System.out.println(str);
                if("1".equals(str)){
                	System.out.println(str);
                	 byte[]b={0x35,0x19,0x00,0x00,0x00,0x06,0x01,0x06,0x01,0x10,0x00,0x01,0x48,0x33 };
        			socket.getOutputStream().write(b, 0, b.length); 
                }else if("0".equals(str)){
                	 byte[]b={0x35,0x19,0x00,0x00,0x00,0x06,0x01,0x06,0x01,0x10,0x00,0x00,(byte) 0xF3,(byte)0x89 };
        			socket.getOutputStream().write(b, 0, b.length);
                }
                  
                 
                out.close(); 
                input.close(); 
            } catch (Exception e) { 
                System.out.println("客户端异常:" + e.getMessage());  
            } finally { 
                if (socket != null) { 
                    try { 
                        socket.close(); 
                    } catch (IOException e) { 
                        socket = null;  
                        System.out.println("客户端 finally 异常:" + e.getMessage());  
                    } 
                } 
            }
        }
       
}   