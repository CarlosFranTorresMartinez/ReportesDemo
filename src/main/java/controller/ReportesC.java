package controller;

import dao.ReporteD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Named(value = "reportC")
@SessionScoped
public class ReportesC implements Serializable {

    private final Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public void reportCultivoxTipo() {
        ReporteD report = new ReporteD();
        try {
            Map<String, Object> parameters = new HashMap();
            report.exportarPDFGlobal(parameters,
                    "Lista_de_Cultivos_por_tipo.jasper", "Cultivos por tipo.pdf");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void reportCultivoAsignados(int IDSEC) {
        ReporteD report = new ReporteD();
        try {
            Map<String, Object> parameters = new HashMap();
            parameters.put("IDSEC", IDSEC);
            report.exportarPDFGlobal(parameters,
                    "Lista_de_cultivos_Asignados.jasper", "Cultivos asignados.pdf");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void reporteCultivoFecha(Date Fecha) {
        ReporteD report = new ReporteD();
        try {
            Map<String, Object> parameters = new HashMap();
            parameters.put("Fecha", Fecha);
            System.out.println("Parametros: " + parameters);
            report.exportarPDFGlobal(parameters,
                    "CantidadPorDiaPorTipoSeleccionadoPorUsuario.jasper",
                    "Cultivos asignados por tipo por fecha.pdf");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
