/**
 * Registro que agrupa los datos de una biblioteca
 *
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

public class Autor {
   private String nombre;
   private String identificacion;
   private String nacionalidad;

   public Autor(String nombre, String identificacion, String nacionalidad) {

      assert nombre != null;
      assert identificacion != null;
      assert nacionalidad != null;

      this.nombre = nombre;
      this.identificacion = identificacion;
      this.nacionalidad = nacionalidad;
   }

   public String getnombre() {
      return this.nombre;
   }

   public String getidentificacion() {
      return this.identificacion;
   }

   public String getnacionalidad() {
      return this.nacionalidad;
   }

}