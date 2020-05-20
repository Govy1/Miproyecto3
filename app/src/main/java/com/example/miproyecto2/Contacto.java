package com.example.miproyecto2;

public class Contacto {
    String nombre = "";
    String alias = "";
    int idcontacto = 0;
    String codigo = "";
    int imagen = 0;

    public Contacto(){}
    public Contacto(String nombre, String alias, int idContacto, int direccion){
        this.nombre = nombre;
        this.alias = alias;
        this.idcontacto = idContacto;
        this.imagen = direccion;
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int direccion) {
        this.imagen = direccion;
    }
}
