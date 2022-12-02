import java.util.concurrent.Semaphore;

public class Bar extends Thread{
    public static void main(String[] args) throws Exception {
    
        Semaphore beanAccess = new Semaphore(1);
        Semaphore cervezaWait = new Semaphore(0);

        BarBean barb = new BarBean();
        Barman barman1 = new Barman(barb, beanAccess, cervezaWait);
        Cliente c1 = new Cliente(barb, beanAccess, cervezaWait);
        Cliente c2 = new Cliente(barb, beanAccess, cervezaWait);
        Cliente c3 = new Cliente(barb, beanAccess, cervezaWait);
        Cliente c4 = new Cliente(barb, beanAccess, cervezaWait);

        barman1.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        
    
    }
}
