package edu.unisabana.dyas.samples.entities;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {

    private int id;
    private String nombre;
    private String descripcion;
    private Date fechaLanzamiento;
    private long tarifaxDia;
    private String formatoRenta;
    private String genero;
    private TipoItem tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public long getTarifaxDia() {
        return tarifaxDia;
    }

    public void setTarifaxDia(long tarifaxDia) {
        this.tarifaxDia = tarifaxDia;
    }

    public String getFormatoRenta() {
        return formatoRenta;
    }

    public void setFormatoRenta(String formatoRenta) {
        this.formatoRenta = formatoRenta;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", tarifaxDia=" + tarifaxDia +
                ", formatoRenta='" + formatoRenta + '\'' +
                ", genero='" + genero + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}