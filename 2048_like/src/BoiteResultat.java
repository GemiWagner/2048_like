/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Romain
 */
public class BoiteResultat extends JDialog implements ActionListener {

    private JLabel label;
    private JButton ok;
    private JButton bilboquet;
    private boolean gagne;
    private boolean reset;
    
    
    public BoiteResultat(Fenetre owner, boolean gagne){
        super(owner, true);
        this.gagne = gagne;
        reset = false;
        init();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok){
            this.setVisible(false);
        }
        if(e.getSource() == bilboquet){
            reset = true;
            this.setVisible(false);
        }
    }

    private void init() {
        JPanel Paneau = new JPanel();
        if(gagne)
            label = new JLabel("Gagné !!!");
        else
            label = new JLabel("Perdu !");
        ok = new JButton("OK");
        bilboquet = new JButton("Reset");
        
        Paneau.setLayout(new GridBagLayout());
        GridBagConstraints contrainte = new GridBagConstraints();
        contrainte.fill = GridBagConstraints.BOTH;
        
        contrainte.gridx = 0;
        contrainte.gridy = 0;
        Paneau.add(label, contrainte);
        contrainte.gridy = 1;
        Paneau.add(ok, contrainte);
        contrainte.gridx = 1;
        Paneau.add(bilboquet, contrainte);
        
        ok.addActionListener(this);
        bilboquet.addActionListener(this);
        
        this.setContentPane(Paneau);
        this.pack();
    }
    
    public boolean showDialog() {
        this.setVisible(true);
        return reset;
    }
}
