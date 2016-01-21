/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements KeyListener {
    private JPanel pan;
    private JButton reset;
    private VueGrille compo;
    private Grille gr;
    
    public Fenetre() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gr = new Grille(4);
        compo = new VueGrille(gr);
        this.addKeyListener(this);
        init();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == '+'){
            int t = this.gr.getTaille();
            if (t < 16) {
                t = this.gr.getTaille() + 1;
                gr = new Grille(t);
                compo = new VueGrille(gr);
                init();
            }
        }
        if(e.getKeyChar() == '-'){
            int t = this.gr.getTaille() - 1;
            if (t < 4) t = 4;
            gr = new Grille(t);
            compo = new VueGrille(gr);
            init();
        }
        if(e.getKeyChar() == ' '){
            gr.poussB();
            gr.poussG();
            compo.repaint();
        }
        if(e.getKeyChar() == 'r'){
            gr.reset();
            compo.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == VK_UP){
            gr.poussH();
            compo.repaint();
        }
        else if(e.getKeyCode() == VK_DOWN){
            gr.poussB();
            compo.repaint();
        }
        else if(e.getKeyCode() == VK_LEFT){
            gr.poussG();
            compo.repaint();
        }
        else if(e.getKeyCode() == VK_RIGHT){
            gr.poussD();
            compo.repaint();
        }
        if(gr.gagne()){
            BoiteResultat b = new BoiteResultat(this, true);
            if(b.showDialog()){
                gr.reset();
                compo.repaint();
            }
            else
                this.dispose();
        }
        if(gr.fini()){
            BoiteResultat b = new BoiteResultat(this, false);
            if(b.showDialog()){
                gr.reset();
                compo.repaint();
            }
            else
                this.dispose();
        }
        if(e.getKeyCode() == VK_ESCAPE)
            this.dispose();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public final void init(){
        pan = new JPanel();
        reset = new JButton("Reset");
        
        pan.setLayout(new GridBagLayout());
        GridBagConstraints pos = new GridBagConstraints();
        pos.fill = GridBagConstraints.BOTH;
        
        pos.gridx = 0;
        pos.gridy = 0;
        pan.add(compo, pos);
        
        this.setContentPane(pan);
        this.pack();
    }

}
