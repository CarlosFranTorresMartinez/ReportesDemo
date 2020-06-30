package model;

import java.util.Date;

public class AsignacionCultivo {

    private int IDASIGPRO;
    private int IDCUL;
    private int IDSEC;
    private Date FECASIG;

    /*Alguna varibles para hacer la nuestra consulta*/
    private String NOMCUL;
    private String TIPCUL;
    private String NOMSEC;

    public int getIDASIGPRO() {
        return IDASIGPRO;
    }

    public void setIDASIGPRO(int IDASIGPRO) {
        this.IDASIGPRO = IDASIGPRO;
    }

    public int getIDCUL() {
        return IDCUL;
    }

    public void setIDCUL(int IDCUL) {
        this.IDCUL = IDCUL;
    }

    public int getIDSEC() {
        return IDSEC;
    }

    public void setIDSEC(int IDSEC) {
        this.IDSEC = IDSEC;
    }

    public Date getFECASIG() {
        return FECASIG;
    }

    public void setFECASIG(Date FECASIG) {
        this.FECASIG = FECASIG;
    }

    public String getNOMCUL() {
        return NOMCUL;
    }

    public void setNOMCUL(String NOMCUL) {
        this.NOMCUL = NOMCUL;
    }

    public String getTIPCUL() {
        return TIPCUL;
    }

    public void setTIPCUL(String TIPCUL) {
        this.TIPCUL = TIPCUL;
    }

    public String getNOMSEC() {
        return NOMSEC;
    }

    public void setNOMSEC(String NOMSEC) {
        this.NOMSEC = NOMSEC;
    }

}
