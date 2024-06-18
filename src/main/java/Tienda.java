import java.util.Scanner;

public class Tienda {

    //Scanner

    static Scanner sc = new Scanner(System.in);

    //Atributos o variables de clase
    static int init;

    //Arreglos y Matrices.
    static Object[][] productos = new Object[3][5];

    //Producto
    static int idProducto;
    static String nombreProducto;
    static double precio;
    static int cantidad;
    static String descripcion;

    //Metodos de Producto

    static public void registrarProducto(int i) {
        Object[] producto = new Object[5];

        System.out.println("id");
        idProducto = sc.nextInt();
        producto[0] = idProducto;
        sc.nextLine();

        System.out.println("Nombre producto");
        nombreProducto = sc.nextLine();
        producto[1] = nombreProducto;

        System.out.println("Precio");
        precio = sc.nextDouble();
        producto[2] = precio;
        sc.nextLine();

        System.out.println("Cantidad");
        cantidad = sc.nextInt();
        producto[3] = cantidad;
        sc.nextLine();

        System.out.println("Descripcion");
        descripcion = sc.nextLine();
        producto[4] = descripcion;

        productos[i] = producto;


    }

    static public void registrarProductos() {
        for (int i = 0; i < productos.length; i++) {
            registrarProducto(i);
        }
    }

    static public void verProductos() {
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos[i].length; j++)
                System.out.println(productos[i][j]);
        }
    }


    //metodo main
    public static void main(String[] args) {
        appTienda();
    }


    //Arreglos y Matrices.
    static Object[][] clientes = new Object[2][5];

    //cliente
    static int idcliente;
    static String nombrecliente;
    static int edad;
    static String ciudad;


    // Metodos de cliente
    static public void registrarcliente(int i) {
        Object[] cliente = new Object[5];

        System.out.println("id");
        idcliente = sc.nextInt();
        cliente[0] = idcliente;
        sc.nextLine();

        System.out.println("Nombre cliente");
        nombrecliente = sc.nextLine();
        cliente[1] = nombrecliente;


        System.out.println("edad");
        edad = sc.nextInt();
        cliente[3] = edad;
        sc.nextLine();

        System.out.println("ciudad");
        ciudad = sc.nextLine();
        cliente[4] = ciudad;
        clientes[i] = cliente;


    }

    static public void registrarcliente() {
        for (int i = 0; i < clientes.length; i++) {
            registrarcliente(i);
        }
    }

    static public void vercliente() {
        for (int i = 0; i < clientes.length; i++) {
            for (int j = 0; j < clientes[i].length; j++)
                System.out.println(clientes[i][j]);
        }
    }

    //Arreglos y Matrices.
    static Object[][] ventas = new Object[2][5];

    //Metodos de ventas
    static int Idcliente;
    static String producto;
    static int  cantidadventa;
    static double precioventa;
    static int totalventa;



    static public void registrarventas() {
        for (int i = 0; i < ventas.length; i++) {
            System.out.println("id cliente");
            Idcliente = sc.nextInt();
            sc.nextLine();

            System.out.println("producto");
            producto = sc.nextLine();

            System.out.println("cantidad");
            cantidadventa = sc.nextInt();
            sc.nextLine();

            System.out.println("precio");
            precioventa = sc.nextDouble();
            sc.nextLine();

            System.out.println(" total venta ");
            totalventa = sc.nextInt();
                    sc.nextLine();


            // resta de inventario
            for (int j = 0; j < productos.length; j++) {
                if (productos[j][1].equals(producto)) {
                    int cantidadActual = (int) productos[j][3];
                    if (cantidadActual > 0) {
                        productos[j][3] = cantidadActual - 1; //
                        System.out.println("Venta registrada. Quedan " + productos[j][3] + " unidades de " + producto);
                    } else {
                        System.out.println("No hay suficiente stock para realizar la venta.");
                    }
                    break;
                }
            }

            Object[] venta = new Object[5];
            venta[0] = idcliente;
            venta[1] = producto;
            venta[2] = cantidad;
            venta[3] = precio;
            venta[4] = totalventa;
            ventas[i] = venta;
        }
    }
    static public void verventas() {
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++)
                System.out.println(ventas[i][j]);
        }
    }

    //Metodos de sistema


    static public void appTienda() {
        System.out.println("Precione 1 para iniciar");

        init = sc.nextInt();
        sc.nextLine();

        while (init != 0) {

            menuApp();

        }
    }

    static public void menuApp() {
        System.out.println("Seleccione una opcion:\n" +
                "1.Productos\n" +
                "2.Clientes\n" +
                "3.Ventas\n" +
                "4.Salir");

        int opc = sc.nextInt();

        switch (opc) {

            case 1:
                System.out.println("Productos");
                menuProducto();
                break;
            case 2:
                System.out.println("Clientes");
                menucliente();
                break;
            case 3:
                System.out.println("Ventas");
                menuventas();
                break;
            case 4:
                System.out.println("Salir");
                init = 0;
                break;
            default:
                System.out.println("Seleccione una opcion correcta");

        }

    }

    static public void menuProducto() {
        System.out.println("Seleccione una opcion:\n" +
                "1.Registrar\n" +
                "2.ver\n");


        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                System.out.println("Registrar productos");
                registrarProductos();
                break;
            case 2:
                System.out.println("Ver productos");
                verProductos();
                break;
            default:
                System.out.println("Seleccione una opcion valida");
        }

    }

    static public void menucliente() {
        System.out.println("Seleccione una opcion:\n" +
                "1.Registrar\n" +
                "2.ver\n");


        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                System.out.println("Registrar cliente");
                registrarcliente();
                break;
            case 2:
                System.out.println("Ver cliente");
                vercliente();
                break;
            default:
                System.out.println("Seleccione una opcion valida");
        }

    }

    static public void menuventas() {
        System.out.println("Seleccione una opcion:\n" +
                "1.Registrar\n" +
                "2.ver\n");


        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                System.out.println("Registrar venta");
                registrarventas();
                break;
            case 2:
                System.out.println("Ver venta");
                verventas();
                break;
            default:
                System.out.println("Seleccione una opcion valida");
        }

    }
}