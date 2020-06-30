package controller;

import dao.SectorImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Sector;

@Named(value = "sectorC")
@RequestScoped
public class SectorC {

    private final SectorImpl dao;
    private Sector model;
    private List<Sector> lista;

    public SectorC() {
        dao = new SectorImpl();
        model = new Sector();
    }

    @PostConstruct
    public void init() {
        lista_Sector();
    }

    public void lista_Sector() {
        try {
            lista = dao.list();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public Sector getModel() {
        return model;
    }

    public void setModel(Sector model) {
        this.model = model;
    }

    public List<Sector> getLista() {
        return lista;
    }

    public void setLista(List<Sector> lista) {
        this.lista = lista;
    }

}
