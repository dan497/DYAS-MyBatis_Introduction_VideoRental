package edu.unisabana.dyas.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.unisabana.dyas.samples.entities.Cliente;

public interface ClienteMapper {

    public Cliente consultarCliente(@Param("idcli") int id);

    public void agregarItemRentadoACliente(int id,
                                           int idit,
                                           Date fechainicio,
                                           Date fechafin);

    public List<Cliente> consultarClientes();
}