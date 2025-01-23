public class App {
    public static void main(String[] args) throws Exception {
        Inventario inventario = new Inventario();
        inventario.agregarProducto("Mouse", 10);
        inventario.agregarProducto("Teclado", 5);
        inventario.buscarProducto("Mouse");
        inventario.eliminarProducto("Mouse");
        inventario.actualizarCantidad("Teclado", 7);
        inventario.buscarProducto("Mouse");
    }
}
