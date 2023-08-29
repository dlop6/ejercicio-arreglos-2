import java.lang.reflect.Array;
import java.util.ArrayList;

public class Empleado {

    private String key = "H073L2023$";

    public boolean validarCliente(int visitas_Hotel, String tipo_de_cuarto) {

        if (visitas_Hotel <=5 && tipo_de_cuarto.equals("Regular")) {
            return true;
        } else if (visitas_Hotel <=10 && tipo_de_cuarto.equals("Frecuente")) {
            return true;
        } else if (visitas_Hotel >10 && tipo_de_cuarto.equals("VIP")) {
            return true;
        } else {
            return false;
        }  
    }

    public boolean password(String password) {
        if (password.equals(this.key)) {
            return true;
        } else {
            return false;
        }
    }

    public void accederClientes(ArrayList<Cliente> clientList) {
        for (int i = 0; i < clientList.size(); i++) {
            Cliente client = clientList.get(i);
            System.out.println("-------------------------------");
            System.out.println("ID: " + i);
            System.out.println("Nombre: " + client.getNombre());
            System.out.println("CUI: " + client.getCUI());
            System.out.println("Visitas al hotel: " + client.getVisita_sHotel());
            System.out.println("Habitaciones aptas para el cliente: " + client.getTipo_de_cuarto());
            System.out.println("Acompañantes: " + client.getAcompanantes());
            System.out.println("-------------------------------");
        }
    }
    
}
