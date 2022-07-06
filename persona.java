import java.io.Serializable;

public class persona implements Serializable{
    //ATTRIBUTI_________________________________________________________________________________________________________________
    private String nome;
    private int eta;
    private transient String indEmail;

    //METODI____________________________________________________________________________________________________________________
    public persona(String nome, int eta, String indEmail) {
        this.nome=nome;
        this.eta=eta;   
        this.indEmail=indEmail;
    }

    public int getEta() { 
        return eta; 
    }
    public String getNome(){ 
        return nome;
    }
    public void printPersona() { 
        System.out.println("NOME:"+nome+ "  ETA':"+ eta+ "  EMAIL:"+ indEmail); 
    }
}
    