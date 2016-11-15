package Componentes;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pelota {
    private static final int DIAMETRO =30;
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Juego juego;
    
    public Pelota(Juego juego){
        this.juego = juego;
    }
    
    void moverse(){
        if(x+xa <0)
            juego.gameOver();
        else if(x+xa > juego.getWidth()- DIAMETRO)
            juego.gameOver();
        else if(y+ya <0)
            ya=1;
        if(y+ya > juego.getHeight()-DIAMETRO)
            ya=-1;
        
        if(colision()){
            xa = -juego.aceleracion;
            x = juego.raqueta.getTopX()-DIAMETRO;
            juego.aceleracion++;
            juego.puntos2++;
        }
        
        if(colision2()){
            xa = juego.aceleracion;
            x = juego.raqueta2.getTopX();            
            juego.aceleracion++;
            juego.puntos1++;
        }
        
        x=x+xa;
        y=y+ya;
    }
    
    private boolean colision(){
        return juego.raqueta.getBounds().intersects(getBounds());
    }
    
    private boolean colision2(){
        return juego.raqueta2.getBounds().intersects(getBounds());
    }
    
    public void paint(Graphics2D g){
        g.fillOval(x, y, DIAMETRO, DIAMETRO);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETRO, DIAMETRO);
    }
}
