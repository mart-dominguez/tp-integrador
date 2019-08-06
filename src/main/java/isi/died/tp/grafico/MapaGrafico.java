package isi.died.tp.grafico;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import isi.died.tp.dominio.Mapa;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Ruta;
import isi.died.tp.estructuras.Arista;
import isi.died.tp.estructuras.Vertice;

public class MapaGrafico extends JPanel implements MouseListener, MouseMotionListener {
	
	private Mapa grafoMapa;

	private boolean nodosMarc = false;
	private boolean rutMarc = false;

	public List<PlantaG> plantasG;

	public List<RutaG> rutasG;

	public PlantaG select;
	public int x, y;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		for (RutaG rutaG : rutasG) {
			rutaG.paintComponent(g2d);
		}
		for (PlantaG plantaG : plantasG) {
			plantaG.paintComponent(g2d);
		}
	}

	public MapaGrafico(Mapa m) {
		this.plantasG = new ArrayList<PlantaG>();
		this.rutasG = new ArrayList<RutaG>();
		this.setBounds(10, 40, 540, 455);
		this.armar(m);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.setVisible(true);
		this.setDoubleBuffered(true);
	}

	private PlantaG buscar(Planta p) {
		for (PlantaG plantaG : plantasG) {
			if (plantaG.getP().equals(p)) {
				return plantaG;
			}
		}
		return null;
	}
	
	public void agregarNodo(Planta p) {
		y = (int) (Math.random() * (499) + 30);
		x = (int) (Math.random() * (199) + 30);
		this.plantasG.add(new PlantaG(x, y, p));
		repaint();
	}
	
	public void nuevaRuta(Ruta r){
		PlantaG origen = this.buscar(r.getInicio().getValor());
		PlantaG destino = this.buscar(r.getFin().getValor());
		this.rutasG.add(new RutaG(((Ruta) r), origen, destino));
	}
	
	public void desmarcarNodos() {
		for (PlantaG plantaG : plantasG) {
			plantaG.desmarcar();
		}
		nodosMarc = false;
		repaint();
	}
	
	public void borrarNodo(Planta p) {
		for (PlantaG plantaG : plantasG) {
			if(plantaG.getP().equals(p)) {
				this.plantasG.remove(plantaG);
			}
		}
		List<RutaG> gl = new ArrayList<RutaG>();
		for (RutaG rutaG : rutasG) {
			if(rutaG.getInicial().getP().equals(p) || rutaG.getFfinal().getP().equals(p)) {}
			else {
				gl.add(rutaG);
			}
		}
		this.rutasG = gl;
		repaint();
	}
	
	public void borrarRuta(Ruta r1) {
		List<RutaG> gnueva = new ArrayList<RutaG>();
		for (RutaG rutaG : this.rutasG) {
			if(!rutaG.getRut().equals(r1)) {
				gnueva.add(rutaG);
			}
		}
		this.rutasG = gnueva;
		repaint();
	}
	public void borrarRuta(Planta p1 , Planta p2) {
		
	}
	
	public void remarcarNodos(List<Planta> l) {
		if(!l.isEmpty()) {
			if (nodosMarc) {
				this.desmarcarNodos();
				this.remarcarNodos(l);
			}
			else {
				for (PlantaG plantaG : this.plantasG) {
					if(l.contains(plantaG.getP())) {
						plantaG.marcar();
					}
				}
				nodosMarc = true;
			}
			repaint();
		}
	}
	
	public void desmarcarRutas() {
		for (RutaG rutaG : rutasG) {
			rutaG.desmarcar();
		}
		rutMarc = false;
		repaint();
	}
	
	public void remarcarRutas(List<Planta> p) {
		if(!p.isEmpty()) {
			if (rutMarc) {
				this.desmarcarRutas();
				this.remarcarRutas(p);
			} else {
				Queue<Planta> lista = new LinkedList<Planta>();
				lista.addAll(p);
				Planta inicio = null;
				Planta fin = null;
				while(!lista.isEmpty()) {
					fin = lista.poll();
					if(fin != null) {
						for (RutaG rutaG : rutasG) {
							if (rutaG.getInicial().getP().equals(inicio) && rutaG.getFfinal().getP().equals(fin)) {
								rutaG.marcar();
							}
						}
					}
					inicio = fin;
				}
				rutMarc = true;
			}
			repaint();
		}
	}

	private void armar(Mapa m) {
		PlantaG origen, destino;
		int x, y;
		this.grafoMapa = m;
		List<Arista<Planta>> rutas = m.getAristas();
		List<Planta> plantas = m.getVertices().stream().map(Vertice::getValor).collect(Collectors.toList());
		for (Planta planta : plantas) {
			y = (int) (Math.random() * (340) + 20);		//500		//640x385
			x = (int) (Math.random() * (550) + 20);		//800
			this.plantasG.add(new PlantaG(x, y, planta));
		}
		for (Arista<Planta> ruta : rutas) {
			origen = this.buscar(ruta.getInicio().getValor());
			destino = this.buscar(ruta.getFin().getValor());
			this.rutasG.add(new RutaG(((Ruta) ruta), origen, destino));
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (select == null) {
			for (PlantaG f : plantasG) {
				if (f.movimiento(e.getPoint())) {
					select = f;
				}
				x = e.getX();
				y = e.getY();
				repaint();
			}
		} else {
			select.movePlanta(e.getPoint().x - x, e.getPoint().y - y);
			x = e.getX();
			y = e.getY();
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		select = null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// select = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	public boolean isRutMarc() {
		return rutMarc;
	}

	public List<RutaG> getRutasG() {
		return rutasG;
	}

}
