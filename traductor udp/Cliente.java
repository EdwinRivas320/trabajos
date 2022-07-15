

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class Cliente {
    // Definir el destino para enviar el datagrama
    public static final int DEST_PORT = 30000;

    public static final String DEST_IP = "127.0.0.1";
    // Define el tamaño máximo de cada datagrama como 4K
    private static final int DATA_LEN = 4096;
    // Definir la matriz de bytes para recibir datos de la red.
    byte[] inBuff = new byte[DATA_LEN];


    // Cree un objeto DatagramPacket que acepte datos de respuesta
    private DatagramPacket packet_in = new DatagramPacket(inBuff, inBuff.length);

    // Definir un objeto DatagramPacket para enviar
    private DatagramPacket packet_out = null;

  

    public void iniciar() throws IOException {
        try (DatagramSocket socket = new DatagramSocket()) {
            // Inicializa DatagramSocket para enviar
            InetAddress ip = InetAddress.getByName(DEST_IP);
            packet_out = new DatagramPacket(new byte[0], 0, ip, DEST_PORT);
            // Crear secuencia de entrada de teclado
            Scanner sc = new Scanner(System.in);
            Scanner num = new Scanner(System.in);
            System.out.println("Bienvenido al menu del traductor.\nPor favor ingrese una opcion.\n1) Traducir de Español a Ingles\n2) Traducir de Ingles a Español\n 3)Salir ");
            // Constantemente lee la entrada del teclado
            String key =null;
            String opc =null;
            // Matriz de bytes correspondiente a los caracteres de entrada del teclado
            byte[] keyBuff = null;
            while (num.hasNextLine()) {
                opc = num.nextLine();
                if ("3".equals(opc)) {
                    break;
                }
                else {
                
             System.out.println("Bienvenido al menu del traductor.\nPor favor ingrese una opcion.\n1) Traducir de Español a Ingles\n2) Traducir de Ingles a Español\n 3)Salir ");
               if ("1".equals(opc))
   {
   System.out.println("Ingrese la palabra en Español para traducir :");
   
   key= sc.nextLine();
   // cadena de entrada → matriz de bytes
                //TODO
                keyBuff= key.getBytes("UTF-8");
                //keyBuff = key.getBytes();
                // Establecer los datos de bytes en el DatagramPacket para enviar
                packet_out.setData(keyBuff);
                // enviar datagrama
                socket.send(packet_out);
                // Lee los datos en el Socket, y los datos leídos se colocan en la matriz de bytes encapsulada por inPacket.
                socket.receive(packet_in);
                System.out.println(new String(inBuff, 0, packet_in.getLength()));
   }
   else if("2".equals(opc))
   {
   System.out.println("Ingrese la palabra en Ingles para traducir :");
   key= sc.nextLine();
   // cadena de entrada → matriz de bytes
                //TODO
                keyBuff= key.getBytes("UTF-8");
                //keyBuff = key.getBytes();
                // Establecer los datos de bytes en el DatagramPacket para enviar
                packet_out.setData(keyBuff);
                // enviar datagrama
                socket.send(packet_out);
                // Lee los datos en el Socket, y los datos leídos se colocan en la matriz de bytes encapsulada por inPacket.
                socket.receive(packet_in);
                System.out.println(new String(inBuff, 0, packet_in.getLength()));
   }
   }
            }
            System.out.println("=== Fin del programa ===");
        }
    }

    public static void main(String[] args) throws IOException {
        new Cliente().iniciar();
    }
}
