package prueba.modelo;
// Generated 10-11-2017 6:27:48 by Hibernate Tools 4.3.1



/**
 * Provincias generated by hbm2java
 */
public class Provincias  implements java.io.Serializable {


     private Integer provinciaId;
     private String provinciaNombre;
     private int regionId;

    public Provincias() {
    }

    public Provincias(String provinciaNombre, int regionId) {
       this.provinciaNombre = provinciaNombre;
       this.regionId = regionId;
    }
   
    public Integer getProvinciaId() {
        return this.provinciaId;
    }
    
    public void setProvinciaId(Integer provinciaId) {
        this.provinciaId = provinciaId;
    }
    public String getProvinciaNombre() {
        return this.provinciaNombre;
    }
    
    public void setProvinciaNombre(String provinciaNombre) {
        this.provinciaNombre = provinciaNombre;
    }
    public int getRegionId() {
        return this.regionId;
    }
    
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }




}


