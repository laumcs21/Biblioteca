/**
 * Registro que agrupa los datos de una biblioteca
 *
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */

package co.edu.uniquindio.poo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Biblioteca {
    private String nombre;
    private String direccion;
    private int cantidadLibros;
    private LocalDate fechaCreacion;
    private final Collection<Libros> libros;
    private final List<LibrosImpresos> librosImpresosList;
    private final List<LibrosCD> librosCDList;
    private final List<LibrosDigitales> librosDigitalesList;

    public Biblioteca(String nombre, String direccion, int cantidadLibros, LocalDate fechaCreacion) {
        assert nombre != null;
        assert direccion != null;
        assert cantidadLibros >= 0;
        assert fechaCreacion != null;

        this.nombre = nombre;
        this.direccion = direccion;
        this.cantidadLibros = cantidadLibros;
        this.fechaCreacion = fechaCreacion;
        this.libros = new LinkedList<>();
        this.librosImpresosList = new ArrayList<>();
        this.librosCDList = new ArrayList<>();
        this.librosDigitalesList = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public int getCantidadLibros() {
        return this.cantidadLibros;
    }

    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void registrarLibrosImpresos(LibrosImpresos libro) {
        validarLibroImpresoExiste(libro);
        librosImpresosList.add(libro);
    }

    private void validarLibroImpresoExiste(LibrosImpresos libro) {
        boolean existeLibro = librosImpresosList.stream()
                .anyMatch(l -> l.getNombre().equals(libro.getNombre()));
        assert !existeLibro : "El libro ya está registrado";
    }

    public List<LibrosImpresos> getLibrosImpresos() {
        return Collections.unmodifiableList(librosImpresosList);
    }

    public void registrarLibrosCD(LibrosCD libro) {
        validarLibroCDExiste(libro);
        librosCDList.add(libro);
    }

    private void validarLibroCDExiste(LibrosCD libro) {
        boolean existeLibro = librosCDList.stream()
                .anyMatch(l -> l.getNombre().equals(libro.getNombre()));
        assert !existeLibro : "El libro ya está registrado";
    }

    public List<LibrosCD> getLibrosCD() {
        return Collections.unmodifiableList(librosCDList);
    }

    public void registrarLibrosDigitales(LibrosDigitales libro) {
        validarLibroDigitalExiste(libro);
        librosDigitalesList.add(libro);
    }

    private void validarLibroDigitalExiste(LibrosDigitales libro) {
        boolean existeLibro = librosDigitalesList.stream()
                .anyMatch(l -> l.getNombre().equals(libro.getNombre()));
        assert !existeLibro : "El libro ya está registrado";
    }

    public List<LibrosDigitales> getLibrosDigitales() {
        return Collections.unmodifiableList(librosDigitalesList);
    }

    public List<Libros> buscarLibrosPorAutor(String nombreAutor) {
        List<Libros> librosAutor = new ArrayList<>();

        librosAutor.addAll(librosCDList.stream()
                .filter(libro -> libro.getAutor().getNombre().equals(nombreAutor))
                .collect(Collectors.toList()));

        librosAutor.addAll(librosDigitalesList.stream()
                .filter(libro -> libro.getAutor().getNombre().equals(nombreAutor))
                .collect(Collectors.toList()));

        librosAutor.addAll(librosImpresosList.stream()
                .filter(libro -> libro.getAutor().getNombre().equals(nombreAutor))
                .collect(Collectors.toList()));

        if (librosAutor.isEmpty()) {
            System.out.println("No se encuentran libros con el nombre del autor");
        }

        return librosAutor;
    }

    public Collection<String> buscarLibrosDigitalesConVersionCD() {
        List<String> librosConVersionCD = new LinkedList<>();

        for (Libros libroDigital : libros) {
            for (Libros libroCD : libros) {
                if (libroDigital.getNombre().equals(libroCD.getNombre()) && libroDigital instanceof LibrosDigitales && libroCD instanceof LibrosCD) {
                    librosConVersionCD.add(libroDigital.getNombre());
                    break;  // No es necesario seguir buscando para este libro digital
                }
            }
        }

        return librosConVersionCD;
    }

    public Optional<LibrosCD> buscarLibrosCD(String nombreLibro, String formatoLibro) {
        return libros.stream()
                .filter(libros -> libros instanceof LibrosCD)
                .map(libros -> (LibrosCD) libros)
                .filter(libroCD -> libroCD.getNombre().equals(nombreLibro) && libroCD.getFormato().equals(formatoLibro))
                .findAny();
    }

    public List<Integer> contarTiposLibrosPorAutor(String nombreAutor) {
        int cantidadImpresos = (int) libros.stream()
                .filter(libro -> libro.getAutor().getNombre().equals(nombreAutor) && libro instanceof LibrosImpresos)
                .count();

        int cantidadDigitales = (int) libros.stream()
                .filter(libro -> libro.getAutor().getNombre().equals(nombreAutor) && libro instanceof LibrosDigitales)
                .count();

        int cantidadCD = (int) libros.stream()
                .filter(libro -> libro.getAutor().getNombre().equals(nombreAutor) && libro instanceof LibrosCD)
                .count();

        List<Integer> resultado = new ArrayList<>();
        resultado.add(cantidadImpresos);
        resultado.add(cantidadDigitales);
        resultado.add(cantidadCD);

        return resultado;
    }
}
/*
   public List<Libros> buscarLibrosDigitalesEImpresos(String nombreLibro){
    Predicate<Libros> nombreDigital = librosDigitales->librosDigitales.getNombre().equals(nombreLibro);
    Predicate<Libros> nombreImpreso = librosImpresos->librosImpresos.getNombre().equals(nombreLibro);
   
    List<Libros> LibrosDigitalesEImpresos = LibrosList.stream().filter(nombreDigital.and(nombreImpreso)).collect(Collectors.toList());

    return LibrosDigitalesEImpresos;
   }
   
   public List<Libros> buscarLibrosCD(String nombreLibro, String formatoLibro){
    Predicate<Libros> nombreCD = LibrosCD->LibrosCD.getNombre().equals(nombreLibro);
    Predicate<Libros> formatoCD = librosCD->librosCD.getLibrosCD().getFormato().equals(formatoLibro);
   
    List<Libros> LibrosDigitalesEImpresos = LibrosList.stream().filter(nombreDigital.and(nombreImpreso)).collect(Collectors.toList());

    return LibrosDigitalesEImpresos;
   }
*/




