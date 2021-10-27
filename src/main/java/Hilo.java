import java.util.Random;

public class Hilo extends Thread {

    Random r = new Random();

    public final int numero;
    public int repeticiones;


    public Hilo(int numero, int repeticiones){
        this.numero = numero;
        this.repeticiones=repeticiones;
    }

    @Override
    public void run() {

        try {
            repeticiones=0;
            Thread.sleep(1000);
            repeticiones++;
            int i=r.nextInt(2);
            while(i==0) {
                Thread.sleep(1000);
                repeticiones++;
                i=r.nextInt(2);
                }
 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Main.listaHilosOrdenada.add(this);

        System.out.println("Soy el hilo nº " + numero + " y he dormido: " + repeticiones);
    }


}
