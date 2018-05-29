package com.holamundo.materialpersonas;

/**
 * Created by android on 30/04/2018.
 */

public class Computador {
    private String id;
    private int marca;
    private int color;
    private int tipo;
    private int so;
    private int ram;


    private int foto;

    public Computador(){

    }

    public Computador(String id) {
        this.id = id;
    }

    public Computador(String id, int marca, int color,int tipo, int so,int ram,int foto) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.tipo = tipo;
        this.so = so;
        this.ram = ram;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSo() {
        return so;
    }

    public void setSo(int so) {
        this.so = so;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void guardar(){
        Datos.guardar(this);
    }

    public void eliminar(){
        Datos.eliminarComputador(this);
    }
}
