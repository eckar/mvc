/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gangster
 */
@Entity
@Table(name = "libros")
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l"),
    @NamedQuery(name = "Libros.findByCodigoLibro", query = "SELECT l FROM Libros l WHERE l.codigoLibro = :codigoLibro"),
    @NamedQuery(name = "Libros.findByCodigoIsbn", query = "SELECT l FROM Libros l WHERE l.codigoIsbn = :codigoIsbn"),
    @NamedQuery(name = "Libros.findByNombreLibro", query = "SELECT l FROM Libros l WHERE l.nombreLibro = :nombreLibro"),
    @NamedQuery(name = "Libros.findByAutor", query = "SELECT l FROM Libros l WHERE l.autor = :autor"),
    @NamedQuery(name = "Libros.findByCantPaginas", query = "SELECT l FROM Libros l WHERE l.cantPaginas = :cantPaginas"),
    @NamedQuery(name = "Libros.findByAreaConocimiento", query = "SELECT l FROM Libros l WHERE l.areaConocimiento = :areaConocimiento")})
public class Libros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_libro")
    private Integer codigoLibro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_isbn")
    private int codigoIsbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_libro")
    private String nombreLibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_paginas")
    private int cantPaginas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "area_conocimiento")
    private String areaConocimiento;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "codigoLibro")
    private PrestamoLibro prestamoLibro;

    public Libros() {
    }

    public Libros(Integer codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public Libros(Integer codigoLibro, int codigoIsbn, String nombreLibro, String autor, int cantPaginas, String areaConocimiento) {
        this.codigoLibro = codigoLibro;
        this.codigoIsbn = codigoIsbn;
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.cantPaginas = cantPaginas;
        this.areaConocimiento = areaConocimiento;
    }

    public Integer getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Integer codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public int getCodigoIsbn() {
        return codigoIsbn;
    }

    public void setCodigoIsbn(int codigoIsbn) {
        this.codigoIsbn = codigoIsbn;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getAreaConocimiento() {
        return areaConocimiento;
    }

    public void setAreaConocimiento(String areaConocimiento) {
        this.areaConocimiento = areaConocimiento;
    }

    public PrestamoLibro getPrestamoLibro() {
        return prestamoLibro;
    }

    public void setPrestamoLibro(PrestamoLibro prestamoLibro) {
        this.prestamoLibro = prestamoLibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLibro != null ? codigoLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.codigoLibro == null && other.codigoLibro != null) || (this.codigoLibro != null && !this.codigoLibro.equals(other.codigoLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Libros[ codigoLibro=" + codigoLibro + " ]";
    }
    
}
