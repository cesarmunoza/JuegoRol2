package Componentes;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Raqueta {
    private static final int X = 50;
    private static final int ANCHO = 15;
    private static final int ALTO = 70;
    int y = 0;
    int ya = 0;    
    private Juego juego;
    
    public Raqueta(Juego juego){
        this.juego = juego;
    }
    
    public void moverse(){
        if(y + ya > 0 && y + ya < juego.getHeight()-ALTO)
            y = y+ya;
    }
    
    public void paint (Graphics2D g){
        g.fillRect(X, y, ANCHO, ALTO);
    }
    
    public void keyReleased(KeyEvent e){
        ya = 0;
    }
    
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_W)
            ya = -juego.aceleracion;
        if(e.getKeyCode()==KeyEvent.VK_X)
            ya = juego.aceleracion;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(X, y, ANCHO, ALTO);
    }
    
    public int getTopX(){
        return X + ANCHO;
    }
}
