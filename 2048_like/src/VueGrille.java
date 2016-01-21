


import java.awt.BasicStroke;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;


public class VueGrille extends JComponent{
    private Grille grille;
    
    public VueGrille(Grille g){
        grille = g;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        int v;
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(white);
        g.setFont(new Font("Impact", Font.PLAIN, 10));
        g.fillRect(0, 0, grille.getTaille()*40, grille.getTaille()*40);
        for (int i = 0; i < grille.getTaille(); i++){
            for(int j = 0; j < grille.getTaille(); j++){
                if(grille.getGrilleInt(i, j) == 0) g.setColor(white);
                else{ 
                    v = (int) (Math.log(grille.getGrilleInt(i, j)) / Math.log(2)) * 75;
                    if(v < 256)
                        g.setColor(new Color(v, 0, 0));
                    else if(v > 255 && v < 512)
                        g.setColor(new Color(255, v - 256, 0));
                    else if(v > 511 && v < 766)
                        g.setColor(new Color(125, 125, v - 512));
                    else if(v > 765)
                        g.setColor(new Color(v-765, 125, v - 765));
                }
                g.fillRect(j*40, i*40, (j+1)*40, (i+1)*40);
                g.setColor(black);
                if(grille.getGrilleInt(i, j) != 0) g.drawString(Integer.toString(grille.getGrilleInt(i, j)), j*40 + 5, i*40 + 25);
            }
        }
        
        g.setColor(black);
        g2.setStroke(new BasicStroke(3));
        for (int i = 0; i < grille.getTaille() + 1; i++)
            g2.drawLine(0, 40*i, grille.getTaille()*40, 40*i);
        for(int j = 0; j < grille.getTaille() + 1; j++)
            g2.drawLine(40*j, 0, 40*j, grille.getTaille()*40);
        
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(grille.getTaille()*40+1, grille.getTaille()*40+1);
    }
}
