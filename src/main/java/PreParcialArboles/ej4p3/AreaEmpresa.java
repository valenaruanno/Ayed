/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej4p3;

/**
 *
 * @author valen
 */
public class AreaEmpresa {
    private String area;
    private int tardanza;

    public AreaEmpresa(String area, int tardanza) {
        this.area = area;
        this.tardanza = tardanza;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getTardanza() {
        return tardanza;
    }

    public void setTardanza(int tardanza) {
        this.tardanza = tardanza;
    }
    
    
}
