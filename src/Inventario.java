import java.util.ArrayList;

public class Inventario {
    // ARRAYLIST PARA AGREGAR, ELIMINAR, BUSCAR PRODUCTOS
    private ArrayList<String> productos = new ArrayList<>();
    private ArrayList<Integer> cantidades = new ArrayList<>();

    public void agregarProducto(String producto, int cantidad) throws CantidadInvalidaException {
        try {
            if (cantidad <= 0) {
                throw new CantidadInvalidaException("La cantidad debe ser mayor a 0.");
            }
            productos.add(producto);
            System.out.println("Se ha agregado " + cantidad + " " + producto + " al inventario.");
            cantidades.add(cantidad);
        } catch (CantidadInvalidaException e) {
            System.out.println(e.getMessage());
        }
        
    }

    public void eliminarProducto(String producto){
        try {
            if (productos.isEmpty()) {
                System.out.println("No hay productos en el inventario.");
            } else if (!productos.contains(producto)) {
                throw new ProductoNoEncontradoException("El producto " + producto + " no se encuentra en el inventario.");
            }
            productos.remove(producto);
            System.out.println("Se ha eliminado el producto " + producto + " del inventario.");
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
        
    }

    /*
     * Método buscarProducto(String nombre) que lance ProductoNoEncontradoException 
     * si el producto no existe y devuelva la cantidad disponible.
     */

    public int buscarProducto(String producto) {
        try{
            if (!productos.contains(producto)) {
                throw new ProductoNoEncontradoException("El producto " + producto + " no se encuentra en el inventario.");
            } else {
                return cantidades.get(productos.indexOf(producto));
            }
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    } 
    

    // actualizar cantidad
    public void actualizarCantidad(String producto, int nuevaCantidad) throws CantidadInvalidaException {
        try{
            if (nuevaCantidad <= 0) {
                throw new CantidadInvalidaException("La cantidad debe ser mayor a 0.");
            } else if (!productos.contains(producto)) {
                throw new ProductoNoEncontradoException("El producto " + producto + " no se encuentra en el inventario.");
            } else {
                int indice = productos.indexOf(producto);
                cantidades.set(indice, nuevaCantidad);
                System.out.println("Se ha actualizado la cantidad de " + producto + " en el inventario.\nCantidad actual: " + nuevaCantidad);
            } 
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (CantidadInvalidaException e) {
            System.out.println(e.getMessage());
        }

    }

    
}
