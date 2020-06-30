package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Sector;

public class SectorImpl extends Conexion implements Crud<Sector> {

    @Override
    public void add(Sector model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Sector model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Sector model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sector> list() throws Exception {
        List<Sector> lista = null;
        Sector model;
        this.conectar();
        try {
            lista = new ArrayList();
            String sql = "SELECT * FROM DBO.SECTOR AS S\n"
                    + "WHERE EXISTS(SELECT *\n"
                    + "FROM DBO.ASIGNACION_CULTIVO AS AC\n"
                    + "WHERE AC.IDSEC = S.IDSEC)\n"
                    + "ORDER BY S.NOMSEC";
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                model = new Sector();
                model.setIDSEC(rs.getInt("IDSEC"));
                model.setNOMSEC(rs.getString("NOMSEC"));
                lista.add(model);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }
}
