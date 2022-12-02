import java.util.concurrent.Semaphore;

public class Cliente extends Thread{
 
    Semaphore beanAccess;
    Semaphore cervezaWait;
    // int cervezasBebidas = 0;
    BarBean b;

    public Cliente(BarBean b, Semaphore beanAccess, Semaphore cervezaWait){
        super();
        this.b = b;
        this.beanAccess = beanAccess;
        this.cervezaWait = cervezaWait;
    }

    public void run(){
        try {
            //pide y espera
            //bebe cerveza sleep()
            //Cuando beba tres cervezas se va
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getId()+" Quiero cerveza");
                cervezaWait.acquire();
                System.out.println(Thread.currentThread().getId()+" Bebo cerveza "+i);
                beanAccess.acquire();
                Thread.sleep((long)Math.random()*5000);
                b.setnCervezas(b.getnCervezas()+1);
                beanAccess.release();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            beanAccess.acquire();
            b.setnClientes(b.getnClientes()+1);
            beanAccess.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(Thread.currentThread().getId()+" Me voy");
    }


}
