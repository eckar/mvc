/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

/**
 *
 * @author Edgar Rodriguez Arias
 */
public class carros {
    private String codigo;
    private String descripcion;
    private int valor;

    public carros(String codigo, String descripcion, int valor) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
