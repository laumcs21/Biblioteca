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

public class LibrosImpresos extends Libros {
     private final byte cantidadEjemplares;

    public LibrosImpresos(String nombre, Autor autor, Editorial editorial, LocalDate añoPublicacion, 
    int cantidadPaginas, byte cantidadEjemplares) {
        super(nombre, autor, editorial, añoPublicacion, cantidadPaginas);
        assert cantidadEjemplares >0;
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public byte  getCantidadEjemplares() {
        return cantidadEjemplares;
    }
    
}   
