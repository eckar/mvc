/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Gangster
 */
@Entity
@Table(name = "prestamo_libro")
@NamedQueries({
    @NamedQuery(name = "PrestamoLibro.findAll", query = "SELECT p FROM PrestamoLibro p"),
    @NamedQuery(name = "PrestamoLibro.findByIdPrestamo", query = "SELECT p FROM PrestamoLibro p WHERE p.idPrestamo = :idPrestamo"),
    @NamedQuery(name = "PrestamoLibro.findByFechaInicio", query = "SELECT p FROM PrestamoLibro p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "PrestamoLibro.findByFechaFin", query = "SELECT p FROM PrestamoLibro p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "PrestamoLibro.findByTiempoPrestamo", query = "SELECT p FROM PrestamoLibro p WHERE p.tiempoPrestamo = :tiempoPrestamo")})
public class PrestamoLibro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prestamo")
    private Integer idPrestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo_prestamo")
    private int tiempoPrestamo;
    @JoinColumn(name = "id_usuario", referencedColumnName = "Id_usuario")
    @OneToOne(optional = false)
    private Usuarios idUsuario;
    @JoinColumn(name = "codigo_libro", referencedColumnName = "codigo_libro")
    @OneToOne(optional = false)
    private Libros codigoLibro;

    public PrestamoLibro() {
    }

    public PrestamoLibro(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public PrestamoLibro(Integer idPrestamo, Date fechaInicio, Date fechaFin, int tiempoPrestamo) {
        this.idPrestamo = idPrestamo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tiempoPrestamo = tiempoPrestamo;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTiempoPrestamo() {
        return tiempoPrestamo;
    }

    public void setTiempoPrestamo(int tiempoPrestamo) {
        this.tiempoPrestamo = tiempoPrestamo;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Libros getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Libros codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestamo != null ? idPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestamoLibro)) {
            return false;
        }
        PrestamoLibro other = (PrestamoLibro) object;
        if ((this.idPrestamo == null && other.idPrestamo != null) || (this.idPrestamo != null && !this.idPrestamo.equals(other.idPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PrestamoLibro[ idPrestamo=" + idPrestamo + " ]";
    }
    
}
