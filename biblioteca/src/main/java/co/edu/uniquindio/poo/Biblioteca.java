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
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Biblioteca{
   private String nombre;
   private String direccion;
   private int cantidadLibros;
   private LocalDate fechaCreacion;
   private final Collection<LibrosImpresos> LibrosImpresosList;
   private final Collection<LibrosCD> LibrosCDList;
   private final Collection<LibrosDigitales> LibrosDigitalesList;

    public  Biblioteca(String nombre, String direccion, int cantidadLibros,
        LocalDate fechaCreacion) {
         
        assert nombre != null;
        assert direccion != null;
        assert cantidadLibros >=0;
        assert fechaCreacion != null;         
        
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantidadLibros = cantidadLibros;
        this.fechaCreacion = fechaCreacion;
        this.LibrosImpresosList = new LinkedList<>();
        this.LibrosCDList = new LinkedList<>();
        this.LibrosDigitalesList = new LinkedList<>();        
    }
  
     public String getnombre() {
        return this.nombre;
     }
  
     public String getdireccion() {
        return this.direccion;
     }
  
     public int getcantidadLibros() {
        return this.cantidadLibros;
     }
  
     public LocalDate getfechaCreacion() {
        return this.fechaCreacion;
     }

    /*Listado libros Impresos */

     public void registrarLibrosImpresos(LibrosImpresos libro) {
       validarLibroImpresoExiste(libro); 
       LibrosImpresosList.add(libro);
     }

     private void validarLibroImpresoExiste(LibrosImpresos libro) {
       boolean existeLibro = buscarLibrosImpresosPorNombre(libro.getNombre()).isPresent();
       assert !existeLibro:"El libro ya esta registrado";
      }

      public Optional<LibrosImpresos> buscarLibrosImpresosPorNombre(String nombre){
         Predicate<LibrosImpresos> condicion = libro->libro.getNombre().equals(nombre);
         return LibrosImpresosList.stream().filter(condicion).findAny();
     }

      public Collection<LibrosImpresos> getLibrosImpresos() {
        return Collections.unmodifiableCollection(LibrosImpresosList);
        
    }
      
    /*Listado libros CD */
      public void registrarLibrosCD(LibrosCD libro) {
       validarLibroCDExiste(libro); 
       LibrosCDList.add(libro);
     }

      private void validarLibroCDExiste(LibrosCD libro) {
       boolean existeLibro = buscarLibroCDPorNombre(libro.getNombre()).isPresent();
       assert !existeLibro:"El libro ya esta registrado";
      }

      public Optional<LibrosCD> buscarLibroCDPorNombre(String nombre){
         Predicate<LibrosCD> condicion = libro->libro.getNombre().equals(nombre);
         return LibrosCDList.stream().filter(condicion).findAny();
     }

      public Collection<LibrosCD> getLibrosCD() {
        return Collections.unmodifiableCollection(LibrosCDList);
        
    }

   /*Listado libros Digitales*/
      public void registrarLibrosDigitales(LibrosDigitales libro) {
       validarLibroDigitalExiste(libro); 
       LibrosDigitalesList.add(libro);
     }

      private void validarLibroDigitalExiste(LibrosDigitales libro) {
       boolean existeLibro = buscarLibroDigitalesPorNombre(libro.getNombre()).isPresent();
       assert !existeLibro:"El libro ya esta registrado";
      }

      public Optional<LibrosDigitales> buscarLibroDigitalesPorNombre(String nombre){
         Predicate<LibrosDigitales> condicion = libro->libro.getNombre().equals(nombre);
         return LibrosDigitalesList.stream().filter(condicion).findAny();
     }

      public Collection<LibrosDigitales> getLibrosDigitales() {
        return Collections.unmodifiableCollection(LibrosDigitalesList);
        
    }
    
      public List<Libros> buscarLibrosPorAutor1(String nombreAutor) {
       Predicate<LibrosDigitales> nombreDigital = librosDigitales -> librosDigitales.getNombre().equals(nombreAutor);
       Predicate<LibrosImpresos> nombreImpreso = librosImpresos -> librosImpresos.getNombre().equals(nombreAutor);
       Predicate<LibrosCD> nombreCD = librosCD -> librosCD.getNombre().equals(nombreAutor);

       List<Libros> LibrosporAutor = Stream.of(
            LibrosDigitalesList.stream()
                    .filter(nombreDigital)
                    .collect(Collectors.toList()),
            LibrosImpresosList.stream()
                    .filter(nombreImpreso)
                    .collect(Collectors.toList()),
            LibrosCDList.stream()
                    .filter(nombreCD)
                    .collect(Collectors.toList()))
         .flatMap(List::stream)
         .collect(Collectors.toList());

       return LibrosporAutor;
      }

      public Optional<LibrosCD> buscarLibrosCD(String nombreLibro, String formatoLibro) {
         Predicate<LibrosCD> nombreCD = librosCD -> librosCD.getNombre().equals(nombreLibro);
         Predicate<LibrosCD> formatoCD = librosCD -> librosCD.getFormato().equals(formatoLibro);
         Optional<LibrosCD> LibroCDEncontrado = LibrosCDList.stream()
         .filter(nombreCD.and(formatoCD))
         .findAny();

       return LibroCDEncontrado;
      }


    public List<Libros> buscarLibrosPorAutor(String nombreAutor) {
      List<Libros> librosAutor = new ArrayList<>();

      for (Libros libro : LibrosCDList) {
         if (libro.getAutor().getnombre().equals(nombreAutor)) {
             librosAutor.add(libro);
         }
     }
 
     for (Libros libro : LibrosDigitalesList) {
         if (libro.getAutor().getnombre().equals(nombreAutor)) {
             librosAutor.add(libro);
         }
     }
 
     for (Libros libro : LibrosImpresosList) {
         if (libro.getAutor().getnombre().equals(nombreAutor)) {
             librosAutor.add(libro);
         }
     }
 
     if (librosAutor.isEmpty()) {
         System.out.println("No se encuentran libros con el nombre del autor");
     }
 
     return librosAutor;
 }

// 5. Dado el nombre de un autor indicar cuantos tipos tiene (retornar lista con 3 valores) metodo que busque cantidad por tipo
    
    public int contarTiposLibrosPorAutor(String nombreAutor) {
        long cantidadImpresos = libros.stream()
                .filter(libro -> libro.getAutor().getNombre().equals(nombreAutor) && libro.esImpreso())
                .count();

        long cantidadDigitales = libros.stream()
                .filter(libro -> libro.getAutor().getNombre().equals(nombreAutor) && libro.esDigital())
                .count();

        long cantidadCD = libros.stream()
                .filter(libro -> libro.getAutor().getNombre().equals(nombreAutor) && libro.esCD())
                .count();

        
         List<Integer> resultado = new ArrayList<>();
         resultado.add((int) cantidadImpresos);
         resultado.add((int) cantidadDigitales);
         resultado.add((int) cantidadCD);
      
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




