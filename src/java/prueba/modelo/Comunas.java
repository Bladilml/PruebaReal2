package prueba.modelo;
// Generated 10-11-2017 6:27:48 by Hibernate Tools 4.3.1



/**
 * Comunas generated by hbm2java
 */
public class Comunas  implements java.io.Serializable {


     private Integer comunaId;
     private String comunaNombre;
     private int provinciaId;

    public Comunas() {
    }

    public Comunas(String comunaNombre, int provinciaId) {
       this.comunaNombre = comunaNombre;
       this.provinciaId = provinciaId;
    }
   
    public Integer getComunaId() {
        return this.comunaId;
    }
    
    public void setComunaId(Integer comunaId) {
        this.comunaId = comunaId;
    }
    public String getComunaNombre() {
        return this.comunaNombre;
    }
    
    public void setComunaNombre(String comunaNombre) {
        this.comunaNombre = comunaNombre;
    }
    public int getProvinciaId() {
        return this.provinciaId;
    }
    
    public void setProvinciaId(int provinciaId) {
        this.provinciaId = provinciaId;
    }




}


