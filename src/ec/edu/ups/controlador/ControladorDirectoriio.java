package ec.edu.ups.controlador;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiantes
 */
public class ControladorDirectoriio {
    
    private String ruta;
    private File archivo;
    private File[] archivos;

    public ControladorDirectoriio(String string) {
        this.ruta = ruta;
    }
    
    public List<String> listarArchivos(){
        archivo = new File(ruta);
        archivos = archivo.listFiles();
        
        List<String> listaArchivos = new ArrayList<>();
        
        for (File archivo : archivos) {
            if(!archivo.isHidden() && archivo.isFile()){
                listaArchivos.add(archivo.getName());
            }
        }
        if(!listaArchivos.isEmpty()){
            
            return listaArchivos;
            
        }else{
            return null;
        }
    }
    
    public  List<String> listarDirectorios(){
        archivo = new File(ruta);
        archivos = archivo.listFiles();
        
        List<String> listaDirectorios = new ArrayList<>();
        
        for (File directorio : archivos) {
            if(!directorio.isHidden() && directorio.isDirectory()){
                listaDirectorios.add(directorio.getName());
            }
        }
        
        if(!listaDirectorios.isEmpty()){
            
            return listaDirectorios;
            
        }else{
            return null;
        }        
    }
    
    public List<String> listarArchivosOcultos(){
        
        archivo = new File(ruta);
        archivos = archivo.listFiles();
        
        List<String> listaArchivosOcultos = new ArrayList<>();
        
        for (File archivo : archivos) {
            if(archivo.isHidden() && archivo.isFile()){
                listaArchivosOcultos.add(archivo.getName());
            }
        }
        
        if(!listaArchivosOcultos.isEmpty()){
            
            return listaArchivosOcultos;
            
        }else{
            return null;
        }
    }
    
    public List<String> listarDirectoriosOcultos(){
        archivo = new File(ruta);
        archivos = archivo.listFiles();
        
        List<String> listaDirectoriosOcultos = new ArrayList<>();
        
        for (File directorio : archivos) {
            if(directorio.isHidden() && directorio.isDirectory()){
                listaDirectoriosOcultos.add(directorio.getName());
            }
        }
        
        if(!listaDirectoriosOcultos.isEmpty()){
            
            return listaDirectoriosOcultos;
            
        }else{
            return null;
        }
    }
    
}
