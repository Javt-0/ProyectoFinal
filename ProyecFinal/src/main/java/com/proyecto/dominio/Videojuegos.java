/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author jonat
 */
@Entity
@Table(name = "videojuegos")
@NamedQueries({
    @NamedQuery(name = "Videojuegos.findAll", query = "SELECT v FROM Videojuegos v"),
    @NamedQuery(name = "Videojuegos.findById", query = "SELECT v FROM Videojuegos v WHERE v.id = :id"),
    @NamedQuery(name = "Videojuegos.findByNombre", query = "SELECT v FROM Videojuegos v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Videojuegos.findByPrecio", query = "SELECT v FROM Videojuegos v WHERE v.precio = :precio"),
    @NamedQuery(name = "Videojuegos.findByStock", query = "SELECT v FROM Videojuegos v WHERE v.stock = :stock"),
    @NamedQuery(name = "Videojuegos.findByDescripcion", query = "SELECT v FROM Videojuegos v WHERE v.descripcion = :descripcion")})
public class Videojuegos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Float precio;
    @Column(name = "stock")
    private Integer stock;
    @Size(max = 1000)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVideojuego")
    private List<Media> mediaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVideojuego")
    private List<Carrito> carritoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVideojuego")
    private List<VideojuegoPlataforma> videojuegoPlataformaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVideojuego")
    private List<Valoraciones> valoracionesList;

    public Videojuegos() {
    }

    public Videojuegos(Integer id) {
        this.id = id;
    }

    public Videojuegos(String nombre, Float precio, Integer stock, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    public List<Carrito> getCarritoList() {
        return carritoList;
    }

    public void setCarritoList(List<Carrito> carritoList) {
        this.carritoList = carritoList;
    }

    public List<VideojuegoPlataforma> getVideojuegoPlataformaList() {
        return videojuegoPlataformaList;
    }

    public void setVideojuegoPlataformaList(List<VideojuegoPlataforma> videojuegoPlataformaList) {
        this.videojuegoPlataformaList = videojuegoPlataformaList;
    }

    public List<Valoraciones> getValoracionesList() {
        return valoracionesList;
    }

    public void setValoracionesList(List<Valoraciones> valoracionesList) {
        this.valoracionesList = valoracionesList;
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
        if (!(object instanceof Videojuegos)) {
            return false;
        }
        Videojuegos other = (Videojuegos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Videojuegos{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", descripcion=" + descripcion + ", mediaList=" + mediaList + ", carritoList=" + carritoList + ", videojuegoPlataformaList=" + videojuegoPlataformaList + ", valoracionesList=" + valoracionesList + '}';
    }

    
    
}
