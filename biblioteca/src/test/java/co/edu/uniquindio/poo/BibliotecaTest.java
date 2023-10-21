/**
 * Clase para probar el funcionamiento de una biblioteca
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class BibliotecaTest {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(Biblioteca.class.getName());
    
    /**
     * Verificar que la clase Biblioteca almacene y recupere los datos 
     * 
     */
    @Test
    public void datosCompletos() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba La magia del saber |carrera 15 #18 norte-35|36000|2023-08-28
        Biblioteca biblioteca = new Biblioteca("La Magia del Saber","carrera 15 #18 norte-35", (int)36000, LocalDate.of(2023, 8, 28));


        // Recuperación y verificación de datos
        assertEquals("La Magia del Saber",biblioteca.getNombre());
        assertEquals("carrera 15 #18 norte-35",biblioteca.getDireccion());
        assertEquals((int)36000,biblioteca.getCantidadLibros());
        assertEquals(LocalDate.of(2023, 8, 28),biblioteca.getFechaCreacion());
        
        LOG.info("Fin de prueba datos completos...");}

    @Test
    public void RegistrarLibrosImpresoCorrecto() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba La magia del saber |carrera 15 #18 norte-35|36000|2023-08-28
        Biblioteca biblioteca = new Biblioteca("La Magia del Saber","carrera 15 #18 norte-35", (int)36000, LocalDate.of(2023, 8, 28));
        Autor autor = new Autor ("Juan Perez", "123", "colombiano");
        Editorial editorial = new Editorial ("Libros volando", "345", "456");
        LibrosImpresos libro = new LibrosImpresos ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, (byte)4); 
        
        biblioteca.registrarLibrosImpresos(libro);

        
        assertTrue(biblioteca.getLibrosImpresos().contains(libro));
        assertEquals(1, biblioteca.getLibrosImpresos().size());
        LOG.info("Fin de prueba registrarEquipo...");
    
    }
    
    @Test
    public void RegistrarLibroMismoNombreImpresos() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba La magia del saber |carrera 15 #18 norte-35|36000|2023-08-28
        Biblioteca biblioteca = new Biblioteca("La Magia del Saber","carrera 15 #18 norte-35", (int)36000, LocalDate.of(2023, 8, 28));
        Autor autor = new Autor ("Juan Perez", "123", "colombiano");
        Editorial editorial = new Editorial ("Libros volando", "345", "456");
        LibrosImpresos libro = new LibrosImpresos ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, (byte)4); 
        LibrosImpresos libro1 = new LibrosImpresos ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, (byte)4); 
        
        biblioteca.registrarLibrosImpresos(libro);
        assertThrows(Throwable.class,()->biblioteca.registrarLibrosImpresos(libro1));

        LOG.info("Fin de prueba registrarEquipo...");
    } 

    @Test
    public void RegistrarLibrosCDCorrecto() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba La magia del saber |carrera 15 #18 norte-35|36000|2023-08-28
        Biblioteca biblioteca = new Biblioteca("La Magia del Saber","carrera 15 #18 norte-35", (int)36000, LocalDate.of(2023, 8, 28));
        Autor autor = new Autor ("Juan Perez", "123", "colombiano");
        Editorial editorial = new Editorial ("Libros volando", "345", "456");
        LibrosCD libro = new LibrosCD ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, "123","PDF"); 
        
        biblioteca.registrarLibrosCD(libro);

        
        assertTrue(biblioteca.getLibrosCD().contains(libro));
        assertEquals(1, biblioteca.getLibrosCD().size());
        LOG.info("Fin de prueba registrarEquipo...");
    
    }
    
    @Test
    public void RegistrarLibroMismoNombreCD() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba La magia del saber |carrera 15 #18 norte-35|36000|2023-08-28
        Biblioteca biblioteca = new Biblioteca("La Magia del Saber","carrera 15 #18 norte-35", (int)36000, LocalDate.of(2023, 8, 28));
        Autor autor = new Autor ("Juan Perez", "123", "colombiano");
        Editorial editorial = new Editorial ("Libros volando", "345", "456");
        LibrosCD libro = new LibrosCD ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, "123","PDF"); 
        LibrosCD libro1 = new LibrosCD ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, "123","PDF"); 
        
        biblioteca.registrarLibrosCD(libro);
        assertThrows(Throwable.class,()->biblioteca.registrarLibrosCD(libro1));

        LOG.info("Fin de prueba registrarEquipo...");
    } 

    @Test
    public void RegistrarLibrosDigitalesCorrecto() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba La magia del saber |carrera 15 #18 norte-35|36000|2023-08-28
        Biblioteca biblioteca = new Biblioteca("La Magia del Saber","carrera 15 #18 norte-35", (int)36000, LocalDate.of(2023, 8, 28));
        Autor autor = new Autor ("Juan Perez", "123", "colombiano");
        Editorial editorial = new Editorial ("Libros volando", "345", "456");
        LibrosDigitales libro = new LibrosDigitales ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, "123"); 
        
        biblioteca.registrarLibrosDigitales(libro);

        
        assertTrue(biblioteca.getLibrosDigitales().contains(libro));
        assertEquals(1, biblioteca.getLibrosDigitales().size());
        LOG.info("Fin de prueba registrarEquipo...");
    
    }
    
    @Test
    public void RegistrarLibroMismoNombreDigitales() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba La magia del saber |carrera 15 #18 norte-35|36000|2023-08-28
        Biblioteca biblioteca = new Biblioteca("La Magia del Saber","carrera 15 #18 norte-35", (int)36000, LocalDate.of(2023, 8, 28));
        Autor autor = new Autor ("Juan Perez", "123", "colombiano");
        Editorial editorial = new Editorial ("Libros volando", "345", "456");
        LibrosDigitales libro = new LibrosDigitales ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, "123");
        LibrosDigitales libro1 = new LibrosDigitales ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, "123");
        
        biblioteca.registrarLibrosDigitales(libro);
        assertThrows(Throwable.class,()->biblioteca.registrarLibrosDigitales(libro1));

        LOG.info("Fin de prueba registrarEquipo...");
    } 

    @Test
    public void BuscarLibroPorAutorCorrecto() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba La magia del saber |carrera 15 #18 norte-35|36000|2023-08-28
        Biblioteca biblioteca = new Biblioteca("La Magia del Saber","carrera 15 #18 norte-35", (int)36000, LocalDate.of(2023, 8, 28));
        Autor autor = new Autor ("Juan", "123", "colombiano");
        Editorial editorial = new Editorial ("Libros volando", "345", "456");
        LibrosImpresos libro = new LibrosImpresos ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, (byte)4); 
        LibrosCD libro1 = new LibrosCD ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, "123","PDF"); 
        LibrosDigitales libro2 = new LibrosDigitales ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, "123"); 

        biblioteca.registrarLibrosImpresos(libro);
        biblioteca.registrarLibrosCD(libro1);
        biblioteca.registrarLibrosDigitales(libro2);

        assertEquals(3, biblioteca.buscarLibrosPorAutor("Juan").size());
        assertEquals("solos", biblioteca.buscarLibrosPorAutor("Juan").get(0).getNombre());
        LOG.info("Fin de prueba registrarEquipo...");
    
    }

    @Test
    public void BuscarLibrosCDPorNombreYFormatoCorrecto() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba La magia del saber |carrera 15 #18 norte-35|36000|2023-08-28
        Biblioteca biblioteca = new Biblioteca("La Magia del Saber","carrera 15 #18 norte-35", (int)36000, LocalDate.of(2023, 8, 28));
        Autor autor = new Autor ("Juan Perez", "123", "colombiano");
        Editorial editorial = new Editorial ("Libros volando", "345", "456");
        LibrosCD libro = new LibrosCD ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, "123","PDF"); 
        
        biblioteca.registrarLibrosCD(libro);

        assertEquals(libro, biblioteca.buscarLibrosCDPorNombreYFormato("solos","PDF").get(0));
        LOG.info("Fin de prueba registrarEquipo...");
    
    }
    @Test
    public void buscarLibrosDigitalesConVersionCDCorrecto() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba La magia del saber |carrera 15 #18 norte-35|36000|2023-08-28
        Biblioteca biblioteca = new Biblioteca("La Magia del Saber","carrera 15 #18 norte-35", (int)36000, LocalDate.of(2023, 8, 28));
        Autor autor = new Autor ("Juan", "123", "colombiano");
        Editorial editorial = new Editorial ("Libros volando", "345", "456");
        LibrosCD libro1 = new LibrosCD ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, "123","PDF"); 
        LibrosDigitales libro2 = new LibrosDigitales ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, "123"); 
        
        biblioteca.registrarLibrosCD(libro1);
        biblioteca.registrarLibrosDigitales(libro2);
    
        assertEquals(1, biblioteca.buscarLibrosDigitalesConVersionCD().size());
        LOG.info("Fin de prueba buscarLibrosDigitalesConVersionCD...");
    }

    @Test
    public void testContarTiposLibrosPorAutor() {
        // Crea una biblioteca
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "Dirección", 100, LocalDate.now());
        Autor autor = new Autor ("Juan Perez", "123", "colombiano");
        Editorial editorial = new Editorial ("Libros volando", "345", "456");
        // Agrega algunos libros a la biblioteca (Impresos, Digitales y CDs)
        biblioteca.registrarLibrosImpresos(new LibrosImpresos("Libro1", autor, editorial, LocalDate.now(), 200, (byte) 10));
        biblioteca.registrarLibrosDigitales(new LibrosDigitales("Libro2", autor, editorial, LocalDate.now(), 300, "URL1"));
        biblioteca.registrarLibrosCD(new LibrosCD("Libro3", autor, editorial, LocalDate.now(), 150, "700MB", "CD"));


        // Comprueba los resultados
        assertEquals(1, biblioteca.contarTiposLibrosPorAutor("Juan Perez").get(0)); // Cantidad de libros impresos
        assertEquals(1, biblioteca.contarTiposLibrosPorAutor("Juan Perez").get (1)); // Cantidad de libros digitales
        assertEquals(1, biblioteca.contarTiposLibrosPorAutor("Juan Perez").get(2)); // Cantidad de libros CD
    }
}

 /*
    @Test
    public void buscarLibrosDigitalesEImpresosCorrecto() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba La magia del saber |carrera 15 #18 norte-35|36000|2023-08-28
        Biblioteca biblioteca = new Biblioteca("La Magia del Saber","carrera 15 #18 norte-35", (int)36000, LocalDate.of(2023, 8, 28));
        Autor autor = new Autor ("Juan Perez", "123", "colombiano");
        Editorial editorial = new Editorial ("Libros volando", "345", "456");
        Libros libro = new LibrosDigitales ("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, "la madre pal que hable"); 
        Libros libro1 = new LibrosImpresos("solos", autor, editorial, LocalDate.of(2005,9,10), (int)198, (byte)2); 
        
        biblioteca.registrarLibro(libro);
        biblioteca.registrarLibro(libro1);

        assertEquals(1, biblioteca.buscarLibrosDigitalesEImpresos("solos").size());
       /*assertEquals("solos", biblioteca.buscarLibrosPorAutor("Juan Perez").get(0).getNombre());
        LOG.info("Fin de prueba registrarEquipo...");
    
    }
    */
