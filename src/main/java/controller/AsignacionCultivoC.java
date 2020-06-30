package controller;

import dao.AsignacionCultivoImpl;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import model.AsignacionCultivo;

@Named(value = "asignacionCultivoC")
@RequestScoped
public class AsignacionCultivoC implements Serializable {

    private final AsignacionCultivoImpl dao;
    private AsignacionCultivo model;
    private List<AsignacionCultivo> lista_AsignacionCultivo;

    public AsignacionCultivoC() {
        dao = new AsignacionCultivoImpl();
        lista_AsignacionCultivo = new ArrayList();
        model = new AsignacionCultivo();
    }

    @PostConstruct
    public void init() {
        list_AsignacionCultivo();
    }

    public void list_AsignacionCultivo() {
        try {
            lista_AsignacionCultivo = dao.list();
        } catch (Exception e) {
            System.out.println("Error list_AsignacionCultivo controller AsignacionCultivo: " + e);
        }
    }

    public AsignacionCultivo getModel() {
        return model;
    }

    public void setModel(AsignacionCultivo model) {
        this.model = model;
    }

    public List<AsignacionCultivo> getLista_AsignacionCultivo() {
        return lista_AsignacionCultivo;
    }

    public void setLista_AsignacionCultivo(List<AsignacionCultivo> lista_AsignacionCultivo) {
        this.lista_AsignacionCultivo = lista_AsignacionCultivo;
    }

}
