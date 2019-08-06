package isi.died.tp.grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import isi.died.tp.dominio.Planta;

public class PlantaG {
	private Planta p;
	public int x;
	public int y;
	public Color cr;
	public final int rad = 45;
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PlantaG) {
			if(this.hashCode()== obj.hashCode()) {
				if(this.getP().equals(((PlantaG) obj).getP())) {
					return true;
				}
			}
		}
		return false;
	}
	public PlantaG(int xs, int ys, Planta pa) {
		this.cr = Color.BLUE;
		this.x = xs;
		this.y = ys;
		this.p= pa;
	}
    public void paintComponent(Graphics g) {
        g.setColor(cr);
    	g.fillOval(x-20, y-20,rad ,rad);
    	g.setColor(Color.BLACK);
    	g.drawOval(x-20, y-20,rad ,rad);
        g.drawString(p.getNombre(), x-20, y-25);
    }
    public void movePlanta(int dx,int dy) {
        this.x+=dx;
        this.y+=dy;
    }
    public boolean movimiento(Point d) {
        if(d.distance(x, y)<=15) {
            return true;
        }
         else {
             return false;
         }
    }
	public void desmarcar() {
		this.cr= Color.BLUE;
	}
	public void marcar() {
		this.cr= Color.RED;
	}
	public boolean clickDentro(int xi, int yi) {
		return (xi >= x && xi <= x + rad && yi >= rad && yi <= y + rad);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Planta getP() {
		return p;
	}
	public int getRad() {
		return rad;
	}
}
