import java.util.Scanner;
import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private int CUI;
    private int visita_sHotel;
    private ArrayList<String> tipo_de_cuarto = new ArrayList<>();
    private int acompanantes;
    private boolean canBuy;

    public Cliente(String nombre, int CUI, int visita_sHotel, int acompanantes) {
        this.nombre = nombre;
        this.CUI = CUI;
        this.visita_sHotel = visita_sHotel;
        this.acompanantes = acompanantes;
    }

    public void ingresarData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        this.nombre = sc.nextLine();
        System.out.println("Ingrese su CUI: ");
        this.CUI = sc.nextInt();
        sc.nextLine();  // Consumir el carácter de nueva línea pendiente
        System.out.println("Ingrese el número de veces que ha visitado el hotel: ");
        this.visita_sHotel = sc.nextInt();
        sc.nextLine();  // Consumir el carácter de nueva línea pendiente
        System.out.println("Ingrese la cantidad de personas que lo acompañan: ");
        this.acompanantes = sc.nextInt();
        Habitaciones habitaciones = new Habitaciones();
        this.tipo_de_cuarto = habitaciones.asignarHabitacion(this.visita_sHotel, this.acompanantes);


    }
    public String getNombre() {
        return nombre;
    }

    public int getCUI() {
        return CUI;
    }

    public int getVisita_sHotel() {
        return visita_sHotel;
    } 
    
    public ArrayList<String> getTipo_de_cuarto() {
        return tipo_de_cuarto;
    }

    public int getAcompanantes() {
        return acompanantes;
    }

    public boolean setcanBuy(boolean canBuy) {
        this.canBuy = canBuy;
        return canBuy;
    }

    public boolean getcanBuy() {
        return canBuy;
    }
}
