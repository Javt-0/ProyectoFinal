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

/**
 *
 * @author jonat
 */
@Entity
@Table(name = "videojuego_plataforma")
@NamedQueries({
    @NamedQuery(name = "VideojuegoPlataforma.findAll", query = "SELECT v FROM VideojuegoPlataforma v"),
    @NamedQuery(name = "VideojuegoPlataforma.findById", query = "SELECT v FROM VideojuegoPlataforma v WHERE v.id = :id")})
public class VideojuegoPlataforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_videojuego", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Videojuegos idVideojuego;
    @JoinColumn(name = "id_plataforma", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Plataforma idPlataforma;

    public VideojuegoPlataforma() {
    }

    public VideojuegoPlataforma(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Videojuegos getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(Videojuegos idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public Plataforma getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Plataforma idPlataforma) {
        this.idPlataforma = idPlataforma;
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
        if (!(object instanceof VideojuegoPlataforma)) {
            return false;
        }
        VideojuegoPlataforma other = (VideojuegoPlataforma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.dominio.VideojuegoPlataforma[ id=" + id + " ]";
    }
    
}
