package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;

public class AppUDP2 {

    public static void main(String[] args) throws SocketException {
        try{

            System.out.print("[ Alocando porta UDP                  ..................  ");
    	    DatagramSocket socket = new DatagramSocket(20000);
            System.out.println("[OK] ]");

            byte[] buf = new byte[20];
            DatagramPacket pack = new DatagramPacket(buf, buf.length);

            System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
            socket.receive(pack);
            System.out.println("[OK] ]");
            
            byte[] received_data = pack.getData();
            String received_msg = new String(received_data); 
            InetAddress origin_address = pack.getAddress();
            int origin_port = pack.getPort();
            
            System.out.println("  Mensagem:             "+received_msg);
            System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
            System.out.println("  Porta de origem:      "+origin_port);
            
            String msg = "Olá UDP 1!!!";
            
            byte[] msg_buf = msg.getBytes();
            int msg_size = msg_buf.length;
            InetAddress destination_address = InetAddress.getLocalHost();
            int destination_port = 10000; 

            System.out.print("[ Montando datagrama UDP  ..................  ");
            pack = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
            System.out.println("[OK] ]");
            
            System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(pack);
            System.out.println("[OK] ]");
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
        
        
        

    }
}