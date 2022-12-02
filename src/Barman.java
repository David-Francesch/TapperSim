import java.util.concurrent.Semaphore;

public class Barman extends Thread{
    
    Semaphore beanAccess;
    Semaphore cervezaWait;
    BarBean b;

    public Barman(BarBean b, Semaphore beanAccess, Semaphore cervezaWait){
        super();
        this.b = b;
        this.beanAccess = beanAccess;
        this.cervezaWait = cervezaWait;
    }

    public void run(){
        try {
            while(b.getnClientes()<4){
                System.out.println(Thread.currentThread().getId()+" Sirvo cerveza");
                cervezaWait.release();
                Thread.sleep((long)Math.random()*5000);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("cierro el bar");

    }

}
                                                                                                                                                                                                                                                                                                                         