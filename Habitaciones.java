import java.util.ArrayList;
import java.util.Arrays;

public class Habitaciones {
    private int[] precios = {50, 150, 300}; // Regular, Frecuente, VIP
    private final float[] max_personas = {2, 4, 6}; // Regular, Frecuente, VIP
    public ArrayList<Integer> habitacionesR = new ArrayList<>(Arrays.asList(100, 101, 102, 103, 104, 105, 106, 107, 108, 109));
    public ArrayList<Integer> habitacionesF = new ArrayList<>(Arrays.asList(200, 201, 202, 203, 204, 205, 206, 207, 208, 209));
    public ArrayList<Integer> habitacionesV = new ArrayList<>(Arrays.asList(300, 301, 302, 303, 304, 305, 306, 307, 308, 309));

    public int[] habitaciones = {10, 10, 10}; // Regular, Frecuente, VIP

    public int getHabitacionesRegulares() {
        return habitaciones[0];
    }

    public int getHabitacionesFrecuentes() {
        return habitaciones[1];
    }

    public int getHabitacionesVIP() {
        return habitaciones[2];
    }

    public ArrayList<String> asignarHabitacion(int cantidad_visitas, int acompanantes){

        ArrayList<String> habitaciones = new ArrayList<>();

        if (cantidad_visitas <= 5 && this.habitaciones[0] > 0){
            habitaciones.add("Regular");

        }
        if (cantidad_visitas > 5 && cantidad_visitas <= 10 &&  this.habitaciones[1] > 0){
            habitaciones.add("Regular");
            habitaciones.add("Frecuente");

        }
        if (cantidad_visitas > 10 && this.habitaciones[2] > 0){
            habitaciones.add("Regular");
            habitaciones.add("Frecuente");
            habitaciones.add("VIP");
        }
        

        return habitaciones;

    }


    public void nuevaReserva(int option_room, int acompanantes, ArrayList<String> tipo_de_cuarto, Cliente cliente){

        // Este segmento verifica que el cliente pueda comprar una habitación basado en su historial
        String chosen_room = "";
        switch(option_room){
            case 1:
                chosen_room = "Regular";
                break;
            case 2:
                chosen_room = "Frecuente";
                break;
            case 3:
                chosen_room = "VIP";
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        // Este segmento verifica que el cliente pueda comprar una habitación basado en su historial
        if (tipo_de_cuarto.contains(chosen_room)){
            // Acá se asigna la habitación Regular
            if (chosen_room.equals("Regular")){ //  Acá se asigna la habitación
                float valor_ceiling = acompanantes / this.max_personas[0]; // Se calcula la cantidad de habitaciones que se necesitan
                double cantidad_cuartos = Math.ceil(valor_ceiling); // Se redondea hacia arriba
                if (cantidad_cuartos > this.habitaciones[0]) { // Se verifica que haya suficientes habitaciones
                    cantidad_cuartos = this.habitaciones[0];
                    System.out.println("No hay suficientes habitaciones regulares, se asignarán " + cantidad_cuartos + " habitaciones");
                }else{
                    System.out.println("Se asignarán " + cantidad_cuartos + " habitaciones");
                }

                for (int i = 0; i < cantidad_cuartos; i++) { // Se asignan las habitaciones
                    System.out.println("Habitación asignada: " + this.habitacionesR.get(0)); // Se imprime la habitación asignada
                    this.habitacionesR.remove(0); // Se elimina la habitación asignada de la lista de habitaciones disponibles
                    habitaciones[0] =- 1; // Se actualiza la cantidad de habitaciones disponibles
                }
                System.out.println("El total es: Q" + this.precios[0] * cantidad_cuartos); // Se imprime el total a pagar
                cliente.setcanBuy(true); // Se actualiza la variable canBuy del cliente
                
            // Acá se asigna la habitación Frecuente
            } else if (chosen_room.equals("Frecuente")){ // Acá se asigna la habitación Frecuente
                float valor_ceiling = acompanantes / this.max_personas[1]; // Se calcula la cantidad de habitaciones que se necesitan
                double cantidad_cuartos = Math.ceil(valor_ceiling);
                if (cantidad_cuartos > this.habitaciones[1]) {
                    cantidad_cuartos = this.habitaciones[1];
                    System.out.println("No hay suficientes habitaciones frecuentes, se asignarán " + cantidad_cuartos + " habitaciones");
                }else{
                    System.out.println("Se asignarán " + cantidad_cuartos + " habitaciones");
                }
                for (int i = 0; i < cantidad_cuartos; i++) {
                    System.out.println("Habitación asignada: " + this.habitacionesF.get(0));
                    this.habitacionesF.remove(0);
                    habitaciones[1] =- 1;
                }
                System.out.println("El total es: Q" + this.precios[1] * cantidad_cuartos);
                cliente.setcanBuy(true);

            // Acá se asigna la habitación VIP
            } else if (chosen_room.equals("VIP")){
                float valor_ceiling = acompanantes / this.max_personas[2];
                double cantidad_cuartos = Math.ceil(valor_ceiling);
                if (cantidad_cuartos > this.habitaciones[2]) {
                    cantidad_cuartos = this.habitaciones[2];
                    System.out.println("No hay suficientes habitaciones VIP, se asignarán " + cantidad_cuartos + " habitaciones");
                }else{
                    System.out.println("Se asignarán " + cantidad_cuartos + " habitaciones");
                }
                for (int i = 0; i < cantidad_cuartos; i++) {
                    System.out.println("Habitación asignada: " + this.habitacionesV.get(0));
                    this.habitacionesV.remove(0);
                    habitaciones[2] =- 1;
                }
                System.out.println("El total es: Q" + this.precios[2] * cantidad_cuartos);
                cliente.setcanBuy(true);
            } else {
                System.out.println("No hay habitaciones disponibles");
                cliente.setcanBuy(false);
            }
        } else {
            System.out.println("No es apto a esta habitación.");
            cliente.setcanBuy(false);
        }
    }
    

    public void verHabitaciones(){
        System.out.println("Habitaciones regulares: " + habitaciones[0]);
        System.out.println("Habitaciones frecuentes: " + habitaciones[1]);
        System.out.println("Habitaciones VIP: " + habitaciones[2]);
    }
    
}
