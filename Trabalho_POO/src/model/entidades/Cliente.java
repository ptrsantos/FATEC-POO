
package model.entidades;

public class Cliente {
   private int idCliente;
   private String nomeDoCliente;
   private String Rg;
   private String Email;
   private String Telefone;

    public Cliente() {
    }

    public Cliente(String nomeDoCliente, String Rg, String Email, String Telefone) {
        this.nomeDoCliente = nomeDoCliente;
        this.Rg = Rg;
        this.Email = Email;
        this.Telefone = Telefone;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
   
   @Override
   public String toString(){
       return this.getNomeDoCliente();
   }
}
