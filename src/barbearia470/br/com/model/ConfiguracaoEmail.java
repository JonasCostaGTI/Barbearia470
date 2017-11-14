package barbearia470.br.com.model;
 
/**
 * @author jonascosta
 * @date   23/10/2017
 *
 */
public class ConfiguracaoEmail {

    private int id;
    private String email;
    private String senha;
    private boolean habilitaEnvio;
    private String diaSemana;
    private String horario;

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the habilitaEnvio
     */
    public boolean isHabilitaEnvio() {
        return habilitaEnvio;
    }

    /**
     * @param habilitaEnvio the habilitaEnvio to set
     */
    public void setHabilitaEnvio(boolean habilitaEnvio) {
        this.habilitaEnvio = habilitaEnvio;
    }

    /**
     * @return the diaSemana
     */
    public String getDiaSemana() {
        return diaSemana;
    }

    /**
     * @param diaSemana the diaSemana to set
     */
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
