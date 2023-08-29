import java.util.ArrayList;
import java.util.Scanner;

public class DriverUI {

    public static int contadorClientes = 0;
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static boolean continueProgram = true;
    public static boolean continueEmployee = true;

    public static void main(String[] args) {
        // iniciar con 3 objetos en el arraylist de clientes
        clientes.add(new Cliente("Juan", 123456789, 3, 2));
        clientes.add(new Cliente("Pedro", 987654321, 7, 1));
        clientes.add(new Cliente("María", 123456789, 11, 3));
        


        Scanner sc = new Scanner(System.in);
        while (continueProgram) {
            System.out.println("-------------------------------");
            System.out.println("¡Bienvenido a Hoteles La Quinta!");
            System.out.println("¿Cómo desea ingresar?");
            System.out.println("1. Cliente");
            System.out.println("2. Empleado");
            System.out.println("3. Salir");
            System.out.println("-------------------------------");
            
            try {
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        Cliente client = new Cliente(null, 0, 0, 0 );
                        client.ingresarData();
                        clientes.add(client);
                        contadorClientes++;
                        System.out.println("¡Gracias por tu reserva " + client.getNombre() + "!");
                        break;
                    case 2:
                        continueEmployee = true;

                        System.out.println("-------------------------------");

                        Empleado empleado = new Empleado();
                        System.out.println("Ingrese su contraseña: ");
                        sc.nextLine();
                        String key_word = sc.nextLine();

                        if (empleado.password(key_word)) {
                            while (continueEmployee) {
                                System.out.println("-------------------------------");
                                System.out.println("MODO ADMINISTRADOR");
                                System.out.println("¿Qué desea hacer?");
                                System.out.println("1. Ver clientes");
                                System.out.println("2. Ver habitaciones");
                                System.out.println("3. Salir de modo administrador");
                                System.out.println("-------------------------------");

                                try {
                                    int opcion2 = sc.nextInt();
                                    switch (opcion2) {
                                        case 1:
                                            try {
                                                empleado.accederClientes(clientes);
                                                System.out.println("Ingrese el ID del cliente al cual desea asignar una habitación: ");
                                                int id = sc.nextInt();
                                                System.out.println("Ha seleccionado a " + clientes.get(id).getNombre());
                                                System.out.println("¿A qué habitación desea asignarlo?");
                                                System.out.println("1. Regular");
                                                System.out.println("2. Frecuente");
                                                System.out.println("3. VIP");
                                                int opcion3 = sc.nextInt();
                                                Habitaciones habitaciones = new Habitaciones();
                                                habitaciones.nuevaReserva(opcion3, clientes.get(id).getAcompanantes(), clientes.get(id).getTipo_de_cuarto(), clientes.get(id));
                                                
                                                if (clientes.get(id).getcanBuy()) {
                                                    clientes.remove(id);
                                                }
                                                

                                            } catch (IndexOutOfBoundsException e) {
                                                System.out.println("No hay clientes registrados");
                                            }
                                            break;
                                        case 2:
                                            Habitaciones habitaciones = new Habitaciones();
                                            habitaciones.verHabitaciones();
                                            break;
                                        case 3:
                                            continueEmployee = false;
                                            break;
                                        default:
                                            System.out.println("Opción inválida");
                                            break;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Entrada inválida. Ingrese un número válido.");
                                    sc.nextLine(); // Limpiar el búfer de entrada
                                }
                            }
                        } else {
                            System.out.println("Contraseña incorrecta");
                        }
                        break;
                    case 3:
                        System.out.println("¡Gracias por su visita!");
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Ingrese un número válido.");
                sc.nextLine(); // Limpiar el búfer de entrada
            }
        }
    }
}
