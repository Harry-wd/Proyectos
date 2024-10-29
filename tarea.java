import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pedido {
    private String nombreCliente;
    private String productos;

    public Pedido(String nombreCliente, String productos) {
        this.nombreCliente = nombreCliente;
        this.productos = productos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombreCliente + ", Productos: " + productos;
    }
}

public class Cafeteria {
    private Queue<Pedido> pedidos;

    public Cafeteria() {
        this.pedidos = new LinkedList<>();
    }

    public void registrarPedido(String nombreCliente, String productos) {
        Pedido nuevoPedido = new Pedido(nombreCliente, productos);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido registrado: " + nuevoPedido);
    }

    public void atenderPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en espera.");
        } else {
            Pedido pedidoAtendido = pedidos.poll();
            System.out.println("Atendiendo pedido: " + pedidoAtendido);
        }
    }

    public void verificarEstadoPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            System.out.println("Pedidos pendientes:");
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }

    public static void main(String[] args) {
        Cafeteria cafeteria = new Cafeteria();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Registrar Pedido");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Verificar Estado de Pedidos Pendientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese los productos (separados por comas): ");
                    String productos = scanner.nextLine();
                    cafeteria.registrarPedido(nombreCliente, productos);
                    break;
                case 2:
                    cafeteria.atenderPedido();
                    break;
                case 3:
                    cafeteria.verificarEstadoPedidos();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
