

public class Grille {

    private Case[][] grille;
    private int taille;
    private boolean bouge;

    public Grille(int taille) {
        this.taille = taille;
        this.grille = new Case[taille][taille];
        for (int i = 0; i < this.taille; i++) {
            for (int j = 0; j < this.taille; j++) {
                this.grille[i][j] = new Case(i, j);
            }
        }
        this.aleat();
        this.aleat();
    }

    public int getGrilleInt(int x, int y) {
        return grille[x][y].getValeur();
    }

    public Case getGrille(int x, int y) {
        return grille[x][y];
    }

    public int getTaille() {
        return taille;
    }

    public void setGrille(int x, int y, int v) {
        this.grille[x][y].setValeur(v);
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public void reset() {
        for (int i = 0; i < this.taille; i++) {
            for (int j = 0; j < this.taille; j++) {
                this.grille[i][j].setValeur(0);
            }
        }
        this.aleat();
        this.aleat();
    }

    public void aleat() {
        if (!this.fini()) {
            int i, j;
            int val;
            do {
                i = (int) (Math.random() * 100 % this.taille);
                j = (int) (Math.random() * 100 % this.taille);
                if (Math.random() < 0.5) {
                    val = 2;
                } else {
                    val = 4;
                }
            } while (this.grille[i][j].getValeur() != 0);

            this.grille[i][j].setValeur(val);
        }
    }

    public void poussG() {
        if (!this.fini()) {
            fusionG();
            for (int i = 0; i < this.taille; i++) {
                for (int j = 0; j < this.taille; j++) {
                    if (this.grille[i][j].getValeur() == 0) {
                        for (int x = j + 1; x < this.taille; x++) {
                            if (this.grille[i][x].getValeur() != 0) {
                                this.grille[i][j].setValeur(this.grille[i][x].getValeur());
                                this.grille[i][x].setValeur(0);
                                j = 0;
                                x = this.taille;
                                bouge = true;
                            }
                        }
                    }
                }
            }
        }
        if (bouge) this.aleat();
        bouge = false;
    }

    public void fusionG() {
        for (int i = 0; i < this.taille; i++) {
            for (int j = 0; j < this.taille - 1; j++) {
                if (this.grille[i][j].getValeur() != 0) {
                    for (int x = j + 1; x < this.taille; x++) {
                        if (this.grille[i][j].getValeur() == this.grille[i][x].getValeur()) {
                            this.grille[i][j].setValeur(this.grille[i][j].getValeur() * 2);
                            this.grille[i][x].setValeur(0);
                            j = x;
                            x = this.taille;
                        } else if (this.grille[i][x].getValeur() != 0) {
                            j = x - 1;
                            x = this.taille;
                        }
                    }
                }
            }
        }
    }

    public void poussD() {
        fusionD();
        for (int i = this.taille - 1; i >= 0; i--) {
            for (int j = this.taille - 1; j >= 1; j--) {
                if (this.grille[i][j].getValeur() == 0) {
                    for (int x = j - 1; x >= 0; x--) {
                        if (this.grille[i][x].getValeur() != 0) {
                            this.grille[i][j].setValeur(this.grille[i][x].getValeur());
                            this.grille[i][x].setValeur(0);
                            j = this.taille - 1;
                            x = -1;
                            bouge = true;
                        }
                    }
                }
            }
        }
        if (bouge) this.aleat();
        bouge = false;
    }

    public void fusionD() {
        for (int i = this.taille - 1; i >= 0; i--) {
            for (int j = this.taille - 1; j >= 1; j--) {
                if (this.grille[i][j].getValeur() != 0) {
                    for (int x = j - 1; x >= 0; x--) {
                        if (this.grille[i][j].getValeur() == this.grille[i][x].getValeur()) {
                            this.grille[i][j].setValeur(this.grille[i][j].getValeur() * 2);
                            this.grille[i][x].setValeur(0);
                            j = x;
                            x = -1;
                        } else if (this.grille[i][x].getValeur() != 0) {
                            j = x + 1;
                            x = -1;
                        }
                    }
                }
            }
        }
    }

    public void poussH() {
        fusionH();
        for (int j = 0; j < this.taille; j++) {
            for (int i = 0; i < this.taille - 1; i++) {
                if (this.grille[i][j].getValeur() == 0) {
                    for (int x = i + 1; x < this.taille; x++) {
                        if (this.grille[x][j].getValeur() != 0) {
                            this.grille[i][j].setValeur(this.grille[x][j].getValeur());
                            this.grille[x][j].setValeur(0);
                            i = 0;
                            x = this.taille;
                            bouge = true;
                        }
                    }
                }
            }
        }
        if (bouge) this.aleat();
        bouge = false;
    }

    public void fusionH() {
        for (int j = 0; j < this.taille; j++) {
            for (int i = 0; i < this.taille - 1; i++) {
                if (this.grille[i][j].getValeur() != 0) {
                    for (int x = i + 1; x < this.taille; x++) {
                        if (this.grille[i][j].getValeur() == this.grille[x][j].getValeur()) {
                            this.grille[i][j].setValeur(this.grille[i][j].getValeur() * 2);
                            this.grille[x][j].setValeur(0);
                            i = x;
                            x = this.taille;
                        } else if (this.grille[x][j].getValeur() != 0) {
                            i = x - 1;
                            x = this.taille;
                        }
                    }
                }
            }
        }
    }

    public void poussB() {
        fusionB();
        for (int j = this.taille - 1; j >= 0; j--) {
            for (int i = this.taille - 1; i >= 1; i--) {
                if (this.grille[i][j].getValeur() == 0) {
                    for (int x = i - 1; x >= 0; x--) {
                        if (this.grille[x][j].getValeur() != 0) {
                            this.grille[i][j].setValeur(this.grille[x][j].getValeur());
                            this.grille[x][j].setValeur(0);
                            i = this.taille;
                            x = -1;
                            bouge = true;
                        }
                    }
                }
            }
        }
        if (bouge) this.aleat();
        bouge = false;
    }

    public void fusionB() {
        for (int j = this.taille - 1; j >= 0; j--) {
            for (int i = this.taille - 1; i >= 1; i--) {
                if (this.grille[i][j].getValeur() != 0) {
                    for (int x = i - 1; x >= 0; x--) {
                        if (this.grille[i][j].getValeur() == this.grille[x][j].getValeur()) {
                            this.grille[i][j].setValeur(this.grille[i][j].getValeur() * 2);
                            this.grille[x][j].setValeur(0);
                            i = x;
                            x = -1;
                        } else if (this.grille[x][j].getValeur() != 0) {
                            i = x + 1;
                            x = -1;
                        }
                    }
                }
            }
        }
    }

    public void affiche() {
        for (int i = 0; i < this.taille; i++) {
            for (int j = 0; j < this.taille - 1; j++) {
                System.out.print("---");
            }
            System.out.println();
            for (int j = 0; j < this.taille; j++) {
                System.out.print("|" + this.grille[i][j].getValeur());
            }
            System.out.println("|");
        }
        for (int j = 0; j < this.taille - 1; j++) {
            System.out.print("---");
        }
        System.out.println();
    }

    public boolean gagne() {
        for (int i = 0; i < this.taille; i++) {
            for (int j = 0; j < this.taille; j++) {
                if (this.getGrilleInt(i, j) == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean fini() {
        for (int i = 0; i < this.taille; i++) {
            for (int j = 0; j < this.taille; j++) {
                if (this.getGrilleInt(i, j) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
