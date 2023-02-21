/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jonat
 */
@Entity
@Table(name = "valoraciones")
@NamedQueries({
    @NamedQuery(name = "Valoraciones.findAll", query = "SELECT v FROM Valoraciones v"),
    @NamedQuery(name = "Valoraciones.findById", query = "SELECT v FROM Valoraciones v WHERE v.id = :id"),
    @NamedQuery(name = "Valoraciones.findByComentario", query = "SELECT v FROM Valoraciones v WHERE v.comentario = :comentario"),
    @NamedQuery(name = "Valoraciones.findByPuntuacion", query = "SELECT v FROM Valoraciones v WHERE v.puntuacion = :puntuacion")})
public class Valoraciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1000)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntuacion")
    private int puntuacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @JoinColumn(name = "id_videojuego", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Videojuegos idVideojuego;

    public Valoraciones() {
    }

    public Valoraciones(Integer id) {
        this.id = id;
    }

    public Valoraciones(Integer id, int puntuacion) {
        this.id = id;
        this.puntuacion = puntuacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Videojuegos getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(Videojuegos idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoraciones)) {
            return false;
        }
        Valoraciones other = (Valoraciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.dominio.Valoraciones[ id=" + id + " ]";
    }
    
}
