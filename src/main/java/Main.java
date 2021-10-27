import java.util.ArrayList;

public class Main {


    static ArrayList<Hilo> listaHilosOrdenada = new ArrayList<>();


    public static void main(String[] args) {

        ArrayList<Hilo> listaHilos = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            int repeticiones=0;
            Hilo h = new Hilo(i,repeticiones);
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


        mostraListado();
        mostrarGanadores(mostraListado());
        mostrarSubGanadores(mostraListado());


    }

    private static int mostraListado() {
        int cont=0;
        for (Hilo hilo : listaHilosOrdenada){
            if(hilo.repeticiones>cont)
                cont=hilo.repeticiones;
        }
        return cont;
    }

    public static void mostrarGanadores(int i){
        for (Hilo hilo : listaHilosOrdenada)
            if(hilo.repeticiones==i)
                System.out.println("El hilo " + hilo.numero + " se ha ejecutado " + hilo.repeticiones+" campeon");

    }

    public static void mostrarSubGanadores(int i){
        int j=0;
        for (Hilo hilo : listaHilosOrdenada){
            if(hilo.repeticiones<i){
                j=hilo.repeticiones;
            }
        }
        for (Hilo hilo : listaHilosOrdenada)
            if(hilo.repeticiones==j)
                System.out.println("El hilo " + hilo.numero + " se ha ejecutado " + hilo.repeticiones+" subcampeon");

    }
}
