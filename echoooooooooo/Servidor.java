import java.io.*;
import java.net.*;
import java.util.*;
public class Servidor {
private ServerSocket sServidor;
private Socket sCliente;
private Scanner entrada;
private PrintStream salida;
private int puerto;
private String mensaje="";
public Servidor (int p){puerto = p; }
public void iniciar(){ 
try{
sServidor=new ServerSocket(puerto);
System.out.println(" -SERVIDOR INICIADO -");
System.out.println(" -Esperando Cliente -");
sCliente=sServidor.accept();
entrada=new Scanner(sCliente.getInputStream());
salida= new PrintStream(sCliente.getOutputStream());
//Se reenvíalos mensajes que van llegando hasta q el cliente introduzca la palabra //”bye”, 
while(!mensaje.equals("bye"))
{mensaje=entrada.next();
System.out.println("Mensaje cliente: "+mensaje);
salida.println("Eco:_"+mensaje);
}finalizar();
}catch(Exception e){
e.printStackTrace();
finalizar();
}
}
public void finalizar(){
try{salida.close();
entrada.close();
sCliente.close();
sServidor.close();
System.out.print("Conexion Finalizada!!");
}catch(Exception e){e.printStackTrace();}
}
}
