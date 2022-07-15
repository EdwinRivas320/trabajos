import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
public class buscador {
   public static void main(String[] args) throws Exception {
        
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
        if (texto.equals("key"))
        {
        existe=true;
        System.out.print("El significado de "+"key"+"en ingles es "+ texto);
        break;
        }
        else if(texto1.equals("key"))
        {
        existe=true;
        System.out.print("El significado de "+"key"+"en español es "+ texto1);
        break;
        }
        else
        {texto = br.readLine();
        texto1=br1.readLine();
        
        }
         
        }
        if (existe==false){
        System.out.print("La palabra "+"key"+"no existe ni en españo ni en ingles\nPor favor agregela ");
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
        if(br != null) {
            br.close();
        }
   }
    catch (Exception ex) {
        System.out.println("Error al cerrar el fichero");
        ex.printStackTrace();
   }}}}
