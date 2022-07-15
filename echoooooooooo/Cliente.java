import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Cliente {
private Socket sCliente; 
private Scanner entrada;
private PrintStream salida;
private String host; 
//IP delservidorconel queme voya conectar
private int puerto;
private String mensaje="";
public Cliente(String h, int p){host=h;puerto=p;}
public void iniciar(){ 
try{
//Estableciendoconexionconel servidor
sCliente=new Socket(host,puerto);
System.out.println("CONEXION INICIADA");
System.out.println("Conectado a : "+ sCliente.getRemoteSocketAddress());
//referencia losflujos de datosdeentraday salida
salida=new PrintStream(sCliente.getOutputStream());
entrada=new Scanner(sCliente.getInputStream());
//Este bloque de códigose encarga de enviar mensajes hasta que ponga bye “bye”
Scanner lectura=new Scanner(System.in);
while(!mensaje.equals("cerrar")){
System.out.print("\nDigite mensaje :");
mensaje=lectura.next();
salida.println(mensaje);
System.out.print(entrada.next());
}
finalizar();
}catch(Exception e){
e.printStackTrace();
finalizar();
}}
public void finalizar(){
try{
salida.close();
entrada.close();
sCliente.close();
}catch(Exception e){e.printStackTrace();}}}
