import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
public class Servidor {


    public static void main(String[] args) throws Exception {
        new Servidor().iniciar();
    }

    // Definir el número de puerto udp
    public static  int PORT = 30000;
    // Cada datagrama es de hasta 4K
    private static  int DATA_LEN = 4096;
    // Matriz de bytes para recibir datos de la red
    byte[] buff_in = new byte[DATA_LEN];
    // Cree un objeto DatagramPacket listo para aceptar datos con la matriz de bytes especificada
    private DatagramPacket packet_in = new DatagramPacket(buff_in, buff_in.length);

    // Definir un objeto DatagramPacket para enviar
    private DatagramPacket packet_out;

    public void iniciar() throws Exception {
        try(DatagramSocket socket = new DatagramSocket(PORT)){
            String key = null;  // Palabras inglesas ingresadas por el cliente
            String value=null;  // Contenido chino traducido por el servidor
            SocketAddress address=null; // Obtener el objeto del cliente y escribir datos a la otra parte a través del objeto, de lo contrario no hay destino
            byte[] reviceData=null; // Datos devueltos al cliente
            System.out.println("El servidor ha iniciado");
            while (true){
                // Lee los datos en el socket y luego encapsula los datos en packet_in
                socket.receive(packet_in);
                // Obtener los datos ingresados ​​por el cliente
                buff_in=packet_in.getData();
                // Para convertir la matriz de bytes en una cadena, debe eliminar los espacios finales
                key=new String(buff_in,0,buff_in.length).trim();

                // Obtenga el valor de acuerdo con la clave del mapa
                
               
                address=packet_in.getSocketAddress();
                // verifica las condiciones de salida
                if("down".equals(key)){
                    System.out.println("La entrada del cliente es:"+key);
                    reviceData="El servidor está inactivo, por favor intente nuevamente".getBytes();
                    packet_out=new DatagramPacket(reviceData,reviceData.length,address);
                    socket.send(packet_out);
                    break;
                }else {
                    String result;
                    
                    ////////////////////////////
                    boolean existe=false;
        String texto="",texto1="";
   
   
   String nombreFichero = "/home/edwin/Desktop/traductor udp/Espaniol.txt";
   String nombreFichero1 = "/home/edwin/Desktop/traductor udp/English.txt";
// Declarar una variable BufferedReader
BufferedReader br = null;
BufferedReader br1= null;
try {
    // Crear un objeto BufferedReader al que se le pasa 
    //   un objeto FileReader con el nombre del fichero
    br = new BufferedReader(new FileReader(nombreFichero));
    br1 = new BufferedReader(new FileReader(nombreFichero1));
    // Leer la primera línea, guardando en un String
     texto = br.readLine();
     texto1= br1.readLine();
    // Repetir mientras no se llegue al final del fichero
    while(texto != null) {
        // Hacer lo que sea con la línea leída
        if (texto.equals(key))
        {
        existe=true;
        reviceData=("El significado de "+key+" en ingles es "+ texto1).getBytes();
        packet_out=new DatagramPacket(reviceData,reviceData.length,address);
                    socket.send(packet_out);
        break;
        }
        else if(texto1.equals(key))
        {
        existe=true;
       reviceData=("El significado de "+key+" en español es "+ texto).getBytes();
       packet_out=new DatagramPacket(reviceData,reviceData.length,address);
                    socket.send(packet_out);
        break;
        }
        else
        {texto = br.readLine();
        texto1=br1.readLine();
        
        }
         
        }
        if (existe==false){
        reviceData=("La palabra "+ key +" no existe ni en españo ni en ingles\nPor favor agregela ").getBytes();
        packet_out=new DatagramPacket(reviceData,reviceData.length,address);
                    socket.send(packet_out);
        }
        
        // Leer la siguiente línea
        
        
    
    
    
}

// Captura de excepción por fichero no encontrado
catch (FileNotFoundException ex) {
    System.out.println("Error: Fichero no encontrado");
    ex.printStackTrace();
}
// Captura de cualquier otra excepción
catch(Exception ex) {
    System.out.println("Error de lectura del fichero");
    ex.printStackTrace();
}
// Asegurar el cierre del fichero en cualquier caso
finally { 
    try {
        // Cerrar el fichero si se ha podido abrir
        if(br != null || br1!=null) {
            br.close();
            br1.close();
        }
   }
    catch (Exception ex) {
        System.out.println("Error al cerrar el fichero");
        ex.printStackTrace();
   }}}}

                    ////////////////////////////
                  
                    // Construye packet_out para enviar datos
                    packet_out=new DatagramPacket(reviceData,reviceData.length,address);
                    socket.send(packet_out);
                }
            }
        
    }

   
    

 
