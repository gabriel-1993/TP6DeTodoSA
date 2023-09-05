package tp6detodosa;
//Para poder ordenar los productos en el treeset deben poder compararse (implements <Comparable> Producto)
public class Producto implements Comparable<Producto> {
    
    private int codigo;
    
    private String descripcion;
    
    private double precio;
    
    private int stock;
    
    private Categoria rubro;
    
    public Producto(int codigo, String descripcion, double precio,int stock, Categoria rubro) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.rubro = rubro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getRubro() {
        return rubro;
    }

    public void setRubro(Categoria rubro) {
        this.rubro = rubro;
    }

    // implements compareto: recibe producto devuelve un entero.
    @Override
    public int compareTo(Producto t) {
        if(codigo== t.codigo){ 
            return 0;
        }else if( codigo > t.codigo){
            return 1;
        }else {
        return -1;
        }
    }
}
