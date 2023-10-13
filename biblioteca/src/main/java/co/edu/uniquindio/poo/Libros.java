/**
 * Registro que agrupa los datos de un Libro
 *
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */

package co.edu.uniquindio.poo;

import java.time.LocalDate;


public abstract class Libros{

    private String nombre;
    private Autor autor;
    private Editorial editorial;
    private LocalDate añoPublicacion;
    private int cantidadPaginas;
    
    
    public Libros (String nombre, Autor autor, Editorial editorial, LocalDate añoPublicacion, 
        int cantidadPaginas){

            assert nombre != null;
            assert añoPublicacion != null;  

            this.nombre = nombre;
            this.autor = autor;
            this.editorial = editorial;
            this.añoPublicacion = añoPublicacion;
            this.cantidadPaginas = cantidadPaginas;
            
    }

    public String getNombre (){
        return this.nombre;
    }

    public Autor getAutor (){
        return this.autor;
    }


    public int getCantidadPaginas(){
        return this.cantidadPaginas;
    }

    public Editorial getEditorial (){
        return this.editorial;
    }

    public LocalDate getAñoPublicacion(){
        return this.añoPublicacion;
    }

    public static String obtenerLibroMasPaginas (Libros libro1, Libros libro2){

        String libroMasPaginas = "";

        if (libro1.getCantidadPaginas()>libro2.getCantidadPaginas()){
            libroMasPaginas = libro1.getNombre(); 
        }
        
        if (libro1.getCantidadPaginas()<libro2.getCantidadPaginas()){
            libroMasPaginas = libro2.getNombre();
        }

        else {
            libroMasPaginas = "Tienen la misma cantidad de Páginas"; 
        }

        return libroMasPaginas;
    }

}
