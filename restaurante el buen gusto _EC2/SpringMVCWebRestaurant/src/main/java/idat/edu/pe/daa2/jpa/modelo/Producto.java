package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT c FROM Producto c"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT c FROM Producto c WHERE c.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT c FROM Producto c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT c FROM Producto c WHERE c.precio = :precio"),
    @NamedQuery(name = "Producto.findByStock", query = "SELECT c FROM Producto c WHERE c.stock = :stock")

})

public class Producto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	@Basic(optional = false)
	@Column(name = "precio")
	private String precio;
	@Basic(optional = false)
	@Column(name = "stock")
	private String stock;
	
	 public Producto() {
	 }

	public Producto(Integer idProducto) {
	        this.idProducto = idProducto;
	}

	public Producto(Integer idProducto, String nombre, String precio, String stock) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
	
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Producto[ idSede=" + idProducto + " ]";
    }
	
	
	
	
}
