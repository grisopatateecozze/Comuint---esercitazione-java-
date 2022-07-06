//import comunita.java;
//import persona.java;

public class SimpleRunner implements Runnable  {
    String nome = "";
    Thread tred;

    SimpleRunner(String nome){
        this.nome = nome;
        tred = new Thread(this,nome);
        System.out.println("New thread: "+ tred);
        tred.start();
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

    /**public void run()
     * {
     *     //nel metodo run di un runnable va messo il codice che vui venga eseguito su un thread separato
     *       Comunita a = new Comunita();
     *       a.add(new persona("giuse", 21, "email_no"));
     *       a.add(new persona("giuse", 21, "email_no"));
     *       a.add(new persona("giuse", 21, "email_no"));
     *
     *       int i = 0;
     *           while (i<a.lista.size())  {
     *               System.out.println("Persona---> ");
     *               a.lista.get(i).printPersona();
     *               i++;
     *           }
     *   }
     */

}






























    







