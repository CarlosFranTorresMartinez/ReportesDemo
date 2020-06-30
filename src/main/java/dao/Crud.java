package dao;

import java.util.List;

public interface Crud<Global> {

    void add(Global model) throws Exception;

    void update(Global model) throws Exception;

    void delete(Global model) throws Exception;

    List<Global> list() throws Exception;

}
