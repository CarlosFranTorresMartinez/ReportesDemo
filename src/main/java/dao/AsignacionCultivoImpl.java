package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.AsignacionCultivo;

public class AsignacionCultivoImpl extends Conexion implements Crud<AsignacionCultivo> {

    @Override
    public void add(AsignacionCultivo model) throws Exception {
        this.conectar();
        try {
            String sql = "INSERT INTO DBO.ASIGNACION_CULTIVO(IDCUL,IDSEC,FECASIG) VALUES(?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, model.getIDCUL());
            ps.setInt(2, model.getIDSEC());
            ps.setDate(3, new java.sql.Date(model.getFECASIG().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error dao AsignacionCultivoImpl: " + e);
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void update(AsignacionCultivo model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(AsignacionCultivo model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AsignacionCultivo> list() throws Exception {
        List<AsignacionCultivo> lista = null;
        AsignacionCultivo model;
        this.conectar();
        try {
            lista = new ArrayList();
            String sql = "SELECT IDASIGCUL, NOMCUL, TIPCUL, NOMSEC\n"
                    + "FROM DBO.ASIGNACION_CULTIVO as AC\n"
                    + "    INNER JOIN DBO.CULTIVO AS P ON AC.IDCUL = P.IDCUL\n"
                    + "    INNER JOIN DBO.SECTOR AS S ON AC.IDSEC = S.IDSEC\n"
                    + "ORDER BY \n"
                    + "NOMSEC,\n"
                    + "CASE WHEN TIPCUL = 'PM' THEN 1\n"
                    + "WHEN TIPCUL = 'SP' THEN 2\n"
                    + "WHEN TIPCUL = 'TS' THEN 3\n"
                    + "WHEN TIPCUL = 'HT' THEN 4\n"
                    + " WHEN TIPCUL = 'OT' THEN 5\n"
                    + "END,\n"
                    + "NOMCUL";
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                model = new AsignacionCultivo();
                model.setIDASIGPRO(rs.getInt("IDASIGCUL"));
                model.setNOMCUL(rs.getString("NOMCUL"));
                model.setTIPCUL(rs.getString("TIPCUL"));
                model.setNOMSEC(rs.getString("NOMSEC"));
                lista.add(model);
            }
        } catch (SQLException e) {
            System.out.println("Error lista dao AsignacionCultivo: " + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public String sector(int IDSEC) {
        this.conectar();
        String sector = null;
        String sql = "select NOMSEC from SECTOR where IDSEC=" + IDSEC + "";
        try {
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                sector = rs.getString("NOMSEC");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return sector;
    }

}
