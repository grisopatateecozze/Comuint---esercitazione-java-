public class threadd extends Thread {
    
    threadd(String name){
        super(name);
    }

    public void run(){
        Comunita a = new Comunita();
        a.add(new persona("giuse", 21, "email_no"));
        a.add(new persona("giuse", 21, "email_no"));
        a.add(new persona("giuse", 21, "email_no"));
     
        int i = 0;
        while (i<a.lista.size())  {
            System.out.println("Persona---> ");
            a.lista.get(i).printPersona();
            i++;
        }
    
    }

    // synchelabora è eseguito solo quando run non è in esecuzione 
	//nello stesso Thread e viceversa


	public synchronized void synchelabora(Comunita a) {
		a.elaboraPersone(p ->p.getEta() >= 18 && p.getEta() <= 25, p->p.getNome(),nomeX->System.out.println(nomeX));
	}
}
