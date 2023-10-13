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

public class LibrosDigitales extends Libros {
     private final String url;

    public LibrosDigitales(String nombre, Autor autor, Editorial editorial, LocalDate añoPublicacion, 
    int cantidadPaginas, String url) {
        super(nombre, autor, editorial, añoPublicacion, cantidadPaginas);
        assert url != null;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
