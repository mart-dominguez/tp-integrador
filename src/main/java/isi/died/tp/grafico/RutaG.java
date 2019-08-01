package isi.died.tp.grafico;

import java.awt.Color;
import java.awt.Graphics;

import isi.died.tp.dominio.Ruta;

public class RutaG {
	private Ruta rut;
	public Color cr;
	private PlantaG origen;
	private PlantaG destino;
	
	public RutaG(Ruta r,PlantaG origen, PlantaG destino) {
		this.origen = origen;
		this.destino = destino;
		this.rut = r;
		this.cr = Color.DARK_GRAY;
	}
    public Ruta getRut() {
		return rut;
	}
	public Color getCr() {
		return cr;
	}
	public void paintComponent(Graphics g) {
    	g.setColor(Color.BLACK);
//    	g.drawString("**El lugar de las Plantas es elegido aleatoriamente, arrastelos para cambiarlo**", 10, 20);
    	int x = destino.getX()-origen.getX();
    	int y = destino.getY()-origen.getY();
    	g.setColor(cr);
    	g.drawString("PesoM: "+ rut.pesoMax.toString() +" ; Dur: "+rut.duracion.toString()+"; Dist: "+rut.distancia.toString(),origen.getX()+(x)/2,origen.getY()+(y)/2);
        g.drawLine(origen.getX(), origen.getY(), destino.getX(), destino.getY());
        
    }

    public void setColor(Color color) {
        this.cr = color;
    }
    
	public void desmarcar() {
		this.cr= Color.BLACK;
	}
	public void marcar() {
		this.cr= Color.MAGENTA;
	}

    public PlantaG getFfinal() {
        return this.destino;
    }

    public PlantaG getInicial() {
        return this.origen;
    }
    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof RutaG) {
    		if(obj.hashCode() == this.hashCode()) {
    			if(this.getInicial().equals(((RutaG) obj).getInicial())&& this.getFfinal().equals(((RutaG) obj).getFfinal())) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
}
