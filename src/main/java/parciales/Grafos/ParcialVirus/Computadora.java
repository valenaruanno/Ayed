public class Computadora {
    private boolean estaInfectado;
    private int compu;

    public Computadora (boolean esta, int compu){
        this.estaInfectado = esta;
        this.compu = compu;
    }

    public int getCompu (){
        return compu;
    }

    public boolean getEstaInfectado (){
        return estaInfectado;
    }

    public void setEstaInfectado (boolean estado){
        estaInfectado = estado;
    }
}