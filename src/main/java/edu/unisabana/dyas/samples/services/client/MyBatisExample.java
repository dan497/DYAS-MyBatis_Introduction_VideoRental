package edu.unisabana.dyas.samples.services.client;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.unisabana.dyas.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.unisabana.dyas.samples.entities.Item;
import edu.unisabana.dyas.samples.entities.TipoItem;

public class MyBatisExample {

    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    public static void main(String args[]) {
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();

        ItemMapper im = sqlss.getMapper(ItemMapper.class);
        Item newItem = new Item();
        newItem.setNombre("Nuevo Item");
        newItem.setDescripcion("Descripción del nuevo item");
        newItem.setFechaLanzamiento(new java.util.Date());
        newItem.setTarifaxDia(5000);
        newItem.setFormatoRenta("Diario");
        newItem.setGenero("Electrónica");

        TipoItem tipoItem = new TipoItem();
        tipoItem.setId(1);
        tipoItem.setDescripcion("Electrónico");
        newItem.setTipo(tipoItem);

        System.out.println("Insertando el siguiente Item:");
        System.out.println(newItem);

        im.insertarItem(newItem);
        System.out.println("Item insertado correctamente.");

        System.out.println("ID generado para el nuevo item: " + newItem.getId());

        sqlss.commit();

        Item insertedItem = im.consultarItem(newItem.getId());
        System.out.println("Item recuperado desde la base de datos:");
        System.out.println(insertedItem);

        sqlss.close();
    }
}