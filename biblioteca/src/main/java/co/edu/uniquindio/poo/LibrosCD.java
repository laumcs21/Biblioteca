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
import java.util.Collection;

public class LibrosCD extends Libros {
     private final String tamaño;
     private final String formato;

    public LibrosCD(String nombre, Autor autor, Editorial editorial, LocalDate añoPublicacion, 
    int cantidadPaginas, String tamaño, String formato) {
        super(nombre, autor, editorial, añoPublicacion, cantidadPaginas);

        assert tamaño != null;
        assert formato != null;

        this.tamaño = tamaño;
        this.formato = formato;
    }

    public String getTamaño() {
        return tamaño;
    }

    public String getFormato() {
        return formato;
    }
}
