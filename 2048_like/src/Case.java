/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Romain
 */
public class Case {
    private int valeur;
    private int x;
    private int y;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.valeur = 0;
    }

    
    
    public int getValeur() {
        return valeur;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
