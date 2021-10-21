import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        ArrayList<Hilo> listaHilos = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            Hilo h = new Hilo(i);
            h.start();
            listaHilos.add(h);
        }

        for (Hilo h : listaHilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mostraListado(listaHilos);
    }

    private static void mostraListado(ArrayList<Hilo> listaHilos) {
        for (Hilo hilo : listaHilos){
            System.out.println("El hilo " + hilo.numero + " ha finalizado en el milisegundo " + hilo.tiempoFinalizacion);
        }
    }

}
