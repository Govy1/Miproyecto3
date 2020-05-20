package com.example.miproyecto2;

public class Contacto {
    String nombre = "";
    String alias = "";
    int idcontacto = 0;
    String codigo = "";

    public Contacto(){}
    public Contacto(String nombre, String alias, int idContacto){
        this.nombre = nombre;
        this.alias = alias;
        this.idcontacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getIdcontacto() {
        return idcontacto;
    }

    public void setIdcontacto(int idcontacto) {
        this.idcontacto = idcontacto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
