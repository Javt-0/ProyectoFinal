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
import javax.validation.constraints.Size;

/**
 *
 * @author jonat
 */
@Entity
@Table(name = "media")
@NamedQueries({
    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m"),
    @NamedQuery(name = "Media.findById", query = "SELECT m FROM Media m WHERE m.id = :id"),
    @NamedQuery(name = "Media.findByUrlmedia", query = "SELECT m FROM Media m WHERE m.urlmedia = :urlmedia"),
    @NamedQuery(name = "Media.findByTipo", query = "SELECT m FROM Media m WHERE m.tipo = :tipo")})
public class Media implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "urlmedia")
    private String urlmedia;
    @Size(max = 50)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "id_videojuego", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Videojuegos idVideojuego;

    public Media() {
    }

    public Media(String urlmedia, String tipo, Videojuegos idVideojuego) {
        this.urlmedia = urlmedia;
        this.tipo = tipo;
        this.idVideojuego = idVideojuego;
    }
    
    public Media(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlmedia() {
        return urlmedia;
    }

    public void setUrlmedia(String urlmedia) {
        this.urlmedia = urlmedia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Media{" + "id=" + id + ", urlmedia=" + urlmedia + ", tipo=" + tipo + ", idVideojuego=" + idVideojuego + '}';
    }

    
    
}
