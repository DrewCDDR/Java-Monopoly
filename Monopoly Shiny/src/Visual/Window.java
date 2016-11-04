/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author demarchenac
 */
public class Window implements WindowListener, ActionListener{
    //VARIABLES...
    private final int width, height;
    private String title;
    
    JFrame window;
    Canvas canvas;
    
    public Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        newDisplay();
    }
    
    private void newDisplay(){
        window = new JFrame();
        window.setTitle(title);
        window.setSize(width, height);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        
        window.add(canvas);
        window.pack();
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
    public JFrame getJFrame(){
        return window;
    }
    
    //ALL ABSTRACT METHODS...
    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
