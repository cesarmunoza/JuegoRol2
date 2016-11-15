package Componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends JPanel {

    Pelota pelota = new Pelota(this);
    Raqueta2 raqueta = new Raqueta2(this);
    Raqueta raqueta2 = new Raqueta(this);
    int aceleracion = 1;
    int puntos1 = -1;
    int puntos2 = 0;
        
    public int getPuntos1() {
        return puntos1;
    }

    public int getPuntos2() {
        return puntos2;
    }
    
    
    
    public Juego(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                raqueta.keyPressed(e);
                raqueta2.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                raqueta.keyReleased(e);
                raqueta2.keyReleased(e);
            }
        });
        setFocusable(true);
    }
    
    private void moverse() {
        pelota.moverse();
        raqueta.moverse();
        raqueta2.moverse();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pelota.paint(g2d);
        raqueta.paint(g2d);
        raqueta2.paint(g2d);
        
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(""+getPuntos1(), 10, 30);
        g2d.drawString(""+getPuntos2(), 640, 30);
    }
    
    public void gameOver(){
        JOptionPane.showMessageDialog(this, "Game over", "Game over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame lienzo = new JFrame("Telebolito");
        Juego juego = new Juego();
        lienzo.add(juego);
        lienzo.setSize(700, 400);
        lienzo.setBackground(Color.GREEN);
        lienzo.setVisible(true);
        lienzo.setResizable(false);
        lienzo.setLocationRelativeTo(null);
        lienzo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            juego.moverse();
            juego.repaint();
            Thread.sleep(10);
        }
    }
}
