/**
 * Registro que agrupa los datos de una biblioteca
 *
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

public class Editorial {   
    
    private String nombre;
    private String identificacion;
    private String telefono;
 
     public  Editorial (String nombre, String identificacion, String telefono) {
          
         assert nombre != null;
         assert identificacion != null;
         assert telefono != null;      
         
         this.nombre = nombre;
         this.identificacion = identificacion;
         this.telefono = telefono;   
     }
   
      public String getnombre() {
         return this.nombre;
      }
   
      public String getidentificacion() {
         return this.identificacion;
      }
   
      public String getnacionalidad() {
         return this.telefono;
      }
    
}
