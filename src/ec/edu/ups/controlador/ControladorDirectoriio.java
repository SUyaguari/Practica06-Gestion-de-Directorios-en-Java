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
    
    public List<String> listarArchivos(String ruta){
        try {
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
        } catch (NullPointerException e) {
            return null;
        }
    }
    
    public  List<String> listarDirectorios(String ruta){
        try {
            archivo = new File(ruta);
            archivos = archivo.listFiles();

            List<String> listaDirectorios = new ArrayList<>();

            for (File directorio : archivos) {
                if (!directorio.isHidden() && directorio.isDirectory()) {
                    listaDirectorios.add(directorio.getName());
                }
            }

            if (!listaDirectorios.isEmpty()) {

                return listaDirectorios;

            } else {
                return null;
            }
        } catch (NullPointerException e) {
            
            return null;
        
        }
    }
    
    public List<String> listarArchivosOcultos(String ruta){
        
        try {
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
        } catch (NullPointerException e) {
            return null;
        }
    }
    
    public List<String> listarDirectoriosOcultos(String ruta){
        try {
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
        } catch (NullPointerException e) {
            return null;
        }
    }
    
    public void crearDirectorio(String ruta, String nombre){
        try{
            archivo = new File(ruta+"/"+nombre);
            if(archivo.exists()==false){
                archivo.mkdir();
            }
        }catch(Exception e){
            System.out.println("Error"+e); 
       }
    }
    
    public void eliminarDirectorio(String ruta, String nombre){
        archivo = new File(ruta + "/" + nombre);
        if (archivo.isDirectory()) {

            archivos = archivo.listFiles();
            for (int i = 0; i < archivos.length; i++) {
                if (archivos[i].isDirectory()) {
                    eliminarSubDirectorios(archivos[i]);
                } else {
                    archivos[i].delete();
                }
            }
            archivo.delete();
        } else {
            
            archivo.delete();
            
        }
    }
    
    public void eliminarSubDirectorios(File archivo) {
        File[] files = archivo.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                eliminarSubDirectorios(files[i]);
            } else {
                files[i].delete();
            }
        }
        archivo.delete();
    }
    
    public void renombrarDirectorio(String ruta, String actual, String nuevo){
        
        archivo = new File(ruta + "/" + actual);
        File renombrado = new File(ruta + "/" + nuevo);
        archivo.renameTo(renombrado);

    }
    
    public void mostrarInformacion(){
        
    }
}
