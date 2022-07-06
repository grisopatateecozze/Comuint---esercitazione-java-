import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
//import java.util.function.Consumer;
//import java.util.function.Predicate;
import java.util.function.*;


class Comunita implements Serializable {
    //ATTRIBUTI_________________________________________________________________________________________________________________
    public List<persona> lista=new LinkedList<>(); 

    //METODI____________________________________________________________________________________________________________________
    public void add(persona p){
        lista.add(p);
    }

    //FUNZIONE CHE SELEZIONA PERSONE CON PIU' DI TOT ANNI PASSATI IN INPUT (IN INPUT INTERO)
    public void printPersoneConPiuDi(int eta) {
        for (persona p : lista) { 
            if (p.getEta() >= eta) p.printPersona(); 
        }
    }

    //FUNZIONE CHE SELEZIONA PERSONE CHE SODDISFANO IL REQUISITO DEL PREDICATO PASSATO IN INPUT (IN INPUT UNA LAMBDA EXPRESSION)
    public void printPersoneConPredicato(Predicate<persona> pred) {
        for (persona p : lista) { 
            if (pred.test(p)) //UNICO METODO DELL'INTERFACCIA FUNZIONALE Predicate
                p.printPersona(); 
        }
    }   

    //FUNZIONE CHE SELEZIONA PERSONE CHE SODDISFANO IL REQUISITO DEL PREDICATO PASSATO IN INPUT, E STAMPA CONSUMER (IN INPUT UNA LAMBDA EXPRESSION)
    public void elaboraPersone(Predicate<persona> pred, Consumer<persona> blocco){
        for (persona p : lista){
            if(pred.test(p))
                blocco.accept(p);
        }
    }

    //FUNZIONE CHE SELEZIONA PERSONE CHE SODDISFANO IL REQUISITO DEL PREDICATO PASSATO IN INPUT, FUNCTION RESTITUISCE UNA STRINGA APPARTENENTE A PERSONA, E STAMPA CONSUMER (IN INPUT UNA LAMBDA EXPRESSION)
    public void elaboraPersoneConFunction(Predicate<persona> pred, Function<persona, String> mapper, Consumer<String> blocco) {
        for (persona p : lista) {
            if (pred.test(p)) {
                String dati = mapper.apply(p);
                blocco.accept(dati);
            }
        }
    }

    //FUNZIONE PIU' ELABORATA PER SELEZIONARE PERSONE IN BASE A REQUISITI (OPERAZIONI AGGREGATE)
    public void elaboraPersone(Predicate<persona> pred,Function<persona, String> mapper,Consumer<String> blocco) {
        lista
        .stream() // ottiene lo stream
        .filter(pred) // filtra in base a un predicato
        .map (mapper) // mappa un oggetto su un valore specifico
        .forEach(blocco); // esegue la azione su ogni oggetto mappato
        }

    
    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        Comunita c=new Comunita();
        
        c.add(new persona("PINO", 22, "email_1")); 
        c.add(new persona("FRANCO", 12, "email_2"));
        c.add(new persona("CARLO", 21, "email_3")); 
        c.add(new persona("ALBERTO", 29, "email_4"));

                
        //c.printPersoneConPredicato( p -> p.getEta() >= 18 && p.getEta() <= 25 );
        //c.elaboraPersoneConFunction(p -> p.getEta() >= 18 && p.getEta() <= 25, p -> p.getNome(), nomex -> System.out.println(nomex.toLowerCase()));
        c.elaboraPersone(p ->p.getEta() >= 18 && p.getEta() <= 25, p->p.getNome(),nomeX->System.out.println(nomeX));

        //PROVA RTTI
        System.out.println(c.getClass());


        //SERIALIZZAZIONE OGGETTO 'PERSONA'

        //salvataggio
        String filename = "persona.txt";
        persona gianni = new persona("gianni", 23, "giannil@ibero.it");
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(gianni);
        out.close();

        //caricamento
        persona caricamento = null;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        caricamento = (persona) in.readObject();
        in.close();

        System.out.println("persona caricata da file :"+ caricamento);

        //uso thread per fare un pezzo di codice
        //thread realizzato estendendo classe runnable e passando un istanza di questa al costruttore di THREAD 
        SimpleRunner runner = new SimpleRunner("t1"); //simplerunner è un runnable che crea un thread e gli da un nome e nel metodo run ha il codice da eseguire in parallelo
        Thread mythread = new Thread(runner);
        mythread.start();

        
        //uso thread per fare un pezzo di codice
        //thread realizzato estendendo la classe thread 
        Thread mythread1 = new Thread();
        mythread1.start();
        
        //mythread1.synchelabora(c);

    }
}