package isi.died.tp.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import isi.died.tp.estructuras.ArbolBinarioBusqueda;
import isi.died.tp.estructuras.Arista;
import isi.died.tp.estructuras.Grafo;
import isi.died.tp.estructuras.Vertice;

public class Mapa extends Grafo<Planta> {
	private ArbolBinarioBusqueda<Insumo> insumos;
	private HashSet<Pedido> pedidos;
	private HashSet<Vehiculo> vehiculos;

	public Mapa() {
		super();
		this.insumos = null;
		this.pedidos = new HashSet<Pedido>();
		this.vehiculos = new HashSet<Vehiculo>();
	}
	
	public ArrayList<Planta> getPlantas(){
		List<Vertice<Planta>> vertices = getVertices();
		ArrayList<Planta> al = new ArrayList<Planta>();
		for (Vertice<Planta> vertice : vertices) {
			al.add((Planta) vertice.getValor());
		}
		return al;
	}
	
	public ArrayList<Ruta> getRutas(){
		List<Arista<Planta>> aristas = getAristas();
		ArrayList<Ruta> al = new ArrayList<Ruta>();
		for (Arista<Planta> arista : aristas) {
			al.add((Ruta) arista);
		}
		return al;
	}
	
	public ArbolBinarioBusqueda<Insumo> getInsumos() {
		return insumos;
	}

	public ArrayList<Vehiculo> getVehiculosAL(){
		return new ArrayList<>(vehiculos);
	}
	
	public void eliminarVehiculo(Vehiculo v) {
		this.vehiculos.remove(v);
	}
	
	public void borrarInsumo(Insumo i) {
		this.insumos = (ArbolBinarioBusqueda<Insumo>) this.insumos.borrarElemento(i);
	}

	public void borrarRuta(Ruta r) {
		if (this.aristas.contains(r)) {
			this.aristas.remove(r);
		}
	}

	public void borrarPlanta(Planta p) {
		for (Vertice<Planta> actual : this.vertices) {
			if (actual.getValor().equals(p)) {
				this.vertices.remove(actual);
			}
		}
		List<Arista<Planta>> re = new ArrayList<Arista<Planta>>();
		for (Arista<Planta> arista : aristas) {
			if (arista.getInicio().getValor().equals(p) || arista.getFin().getValor().equals(p)){}else {re.add(arista);}
		}
		this.aristas = re;
	}

	public void nuevaRuta(Planta ori, Planta dest, Double dist, Double dur, Double peso) {
		this.nuevaRuta(new Ruta(this.getNodo(ori), this.getNodo(dest), dist, dur, peso));
	}

	public void nuevaRuta(Ruta r) {
		if (!this.aristas.contains(r)) {
			this.aristas.add(r);
		}
	}


	public void agregarInsumo(Insumo i) {
		if (this.insumos == null) {
			this.insumos = new ArbolBinarioBusqueda<Insumo>(i);
		} else {
			if (!this.insumos.contiene(i)) {
				this.insumos.agregar(i);
				this.insumos = this.insumos.equilibrar();
			}
		}
	}

	public void agregarPedido(Pedido p) {
		this.pedidos.add(p);
	}

	public void agregarVehiculo(Vehiculo v) {
		if (!this.vehiculos.contains(v)) {
			this.vehiculos.add(v);
		}
	}

	public Planta buscarPlanta(Planta inicial, Insumo i, Integer saltos) {
		Planta result = null;
		List<Planta> marcados = new ArrayList<Planta>();
		Queue<Planta> pendientes = new LinkedList<Planta>();
		Queue<Planta> pendientes2 = new LinkedList<Planta>();
		marcados.add(inicial);
		pendientes.add(inicial);
		while (saltos != 0) {
			while (!pendientes.isEmpty()) {
				Planta actual = pendientes.poll();
				List<Planta> aby = this.getAdyacentes(actual);
				for (Planta planta : aby) {
					if (!marcados.contains(planta) && !pendientes.contains(planta)) {
						pendientes2.add(planta);
					}
				}
				if (actual.necesitaInsumo(i)) {
					result = actual;
				} else {
					if (!marcados.contains(actual)) {
						marcados.add(actual);
					}
				}

			}
			pendientes.addAll(pendientes2);
			pendientes2.clear();
			saltos--;
		}
		return result;
	}

	public Planta buscarPlanta(Planta inicial, Insumo i) {
		Integer dist = Integer.MAX_VALUE;
		Planta result = null;
		Map<Planta, Integer> distancias = this.caminosMinimoDikstra(inicial);
		List<Planta> plantas = this.recorridoTopologico();
		plantas.remove(inicial);
		plantas = plantas.stream().filter(s -> s.necesitaInsumo(i)).collect(Collectors.toList());
		for (Planta planta : plantas) {
			if (planta.necesitaInsumo(i)) {
				if (distancias.get(planta) < dist) {
					dist = distancias.get(planta);
					result = planta;
				}
			}
		}
		return result;
	}

	public Planta buscarPlanta(Insumo i) {
		Planta resultado = null;
		Integer necesita = Integer.MIN_VALUE;
		Queue<Planta> topo = new LinkedList<Planta>(this.recorridoTopologico());
		while (!topo.isEmpty()) {
			Planta actualPlanta = topo.poll();
			if (actualPlanta.necesitaInsumo(i)) {
				List<Stock> actualStocks = actualPlanta.getAlmacen().stream()
						.filter(s -> s.getInsumo().getId() == i.getId()).collect(Collectors.toList());
				Stock actualStock = actualStocks.get(0);
				if (actualStock.getPuntoPedido() - actualStock.getCantidad() > necesita) {
					necesita = actualStock.getPuntoPedido() - actualStock.getCantidad();
					resultado = actualPlanta;
				}
			}
		}
		return resultado;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public List<Planta> necesitaInsumo(Insumo i) {
		List<Planta> resultado = new ArrayList<Planta>();
		for (Vertice<Planta> planta : this.vertices) {
			Planta actual = planta.getValor();
			if (actual.necesitaInsumo(i)) {
				resultado.add(actual);
			}
		}
		return resultado;
	}

	public Insumo buscarInsumoNombre(String nomb) {
		Queue<Insumo> insumos = new LinkedList<Insumo>(this.insumos.posOrden());
		Insumo actual;
		do {
			actual = insumos.poll();
		} while (actual.nombre.compareTo(nomb)!=0 && !insumos.isEmpty());
		if (actual.nombre.compareTo(nomb)==0) {
			return actual;
		}
		return null;
//		for (Insumo actual : this.insumos.posOrden()) {
//			if(actual.getNombre().compareTo(nomb)==0) {
//				return actual;
//			}
//		}
//		return null;
	}

	private PriorityQueue<Insumo> ListaAux(Comparator<Insumo> p) {
		PriorityQueue<Insumo> insumos = new PriorityQueue<Insumo>(p);
		insumos.addAll(this.insumos.inOrden());
		return insumos;
	}

	public PriorityQueue<Insumo> listarXnombreDec() {
		Comparator<Insumo> compraradorInsumos = (i1, i2) -> {
			return -i1.nombre.compareTo(i2.nombre);
		};
		return this.ListaAux(compraradorInsumos);
	}

	public PriorityQueue<Insumo> listarXnombreAce() {
		Comparator<Insumo> compraradorInsumos = (i1, i2) -> {
			return i1.nombre.compareTo(i2.nombre);
		};
		return this.ListaAux(compraradorInsumos);
	}

	public PriorityQueue<Insumo> listarXprecioAce() {
		Comparator<Insumo> compraradorInsumos = (i1, i2) -> {
			return i1.costo.compareTo(i2.costo);
		};
		return this.ListaAux(compraradorInsumos);
	}

	public PriorityQueue<Insumo> listarXprecioDec() {
		Comparator<Insumo> compraradorInsumos = (i1, i2) -> {
			return -i1.costo.compareTo(i2.costo);
		};
		return this.ListaAux(compraradorInsumos);
	}

	public PriorityQueue<Insumo> listarXcantidadStockAce() {
		Comparator<Insumo> compraradorInsumos = (i1, i2) -> {
			return i1.stock.compareTo(i2.stock);
		};
		return this.ListaAux(compraradorInsumos);
	}

	public PriorityQueue<Insumo> listarXcantidadStockDec() {
		Comparator<Insumo> compraradorInsumos = (i1, i2) -> {
			return -i1.stock.compareTo(i2.stock);
		};
		return this.ListaAux(compraradorInsumos);
	}

	public Insumo costoMinimo() {
		return this.listarXprecioAce().poll();
	}

	public Insumo costoMax() {
		return this.listarXprecioDec().poll();
	}

	public List<Planta> caminoMenorDistancia(Insumo i) {
		List<List<Planta>> caminos = this.camino(i);
		List<Planta> result = new ArrayList<Planta>();
		Double dist = Double.MAX_VALUE;
		for (List<Planta> list : caminos) {
			if (dist > this.distCamino(list)) {
				dist = this.distCamino(list);
				result = list;
			}
		}
		return result;
	}

	public List<List<Planta>> camino(Insumo i) {
		List<List<Planta>> listas = new ArrayList<List<Planta>>();
		List<Planta> marcados = new ArrayList<Planta>();
		Planta inicial = this.recorridoTopologico().get(0);
		marcados.add(inicial);
		List<Planta> necesitanInsumo = this.necesitaInsumo(i);
		if(!necesitanInsumo.isEmpty()) {
			if(necesitanInsumo.contains(inicial)) {
				necesitanInsumo.remove(inicial);
			}
			this.camino(inicial, marcados, necesitanInsumo, listas);
		}
		return listas;
	}

	private void camino(Planta ini, List<Planta> marcados, List<Planta> buscados, List<List<Planta>> resultado) {
		List<Planta> aby = this.getAdyacentes(ini);
		List<Planta> marcopia = null;
		List<Planta> buscopia = null;
		if (!buscados.isEmpty()) {
			if (!aby.isEmpty()) {
				for (Planta planta : aby) {
					marcopia = marcados.stream().collect(Collectors.toList());
					buscopia = buscados.stream().collect(Collectors.toList());
					if (buscados.contains(planta)) {
						marcopia.add(planta);
						buscopia.remove(planta);
						this.camino(planta, marcopia, buscopia, resultado);
					} else {
						marcopia.add(planta);
						this.camino(planta, marcopia, buscopia, resultado);
					}
				}
			}
		} else {
			resultado.add(marcados);
		}
	}

	public Double distCamino(List<Planta> camino) {
		Double resultado = 0.0;
		Queue<Planta> camino1 = new LinkedList<Planta>(camino);
		Planta ini = camino1.poll();
		Planta ot;
		Ruta r;
		while (!camino1.isEmpty()) {
			ot = camino1.poll();
			r = (Ruta) this.buscarArista(ini, ot);
			resultado += r.distancia;
			ini = ot;
		}
		return resultado;
	}

	public Double durCamino(List<Planta> camino) {
		Double resultado = 0.0;
		Queue<Planta> camino1 = new LinkedList<Planta>(camino);
		Planta ini = camino1.poll();
		Planta ot;
		Ruta r;
		while (!camino1.isEmpty()) {
			ot = camino1.poll();
			r = (Ruta) this.buscarArista(ini, ot);
			resultado += r.duracion;
			ini = ot;
		}
		return resultado;
	}

	public Double pesoCamino(List<Planta> camino) {
		Double resultado = Double.MIN_VALUE;
		Queue<Planta> camino1 = new LinkedList<Planta>(camino);
		Planta ini = camino1.poll();
		Planta ot;
		Ruta r;
		while (!camino1.isEmpty()) {
			ot = camino1.poll();
			r = (Ruta) this.buscarArista(ini, ot);
			if (resultado < r.pesoMax) {
				resultado = r.pesoMax;
			}
			ini = ot;
		}
		return resultado;
	}

	public List<Planta> caminoMenorDuracion(Insumo i) {
		List<List<Planta>> caminos = this.camino(i);
		List<Planta> result = null;
		Double dur = Double.MAX_VALUE;
		for (List<Planta> list : caminos) {
			if (dur > this.durCamino(list)) {
				dur = this.durCamino(list);
				result = list;
			}
		}
		return result;
	}

	public List<Planta> pageRank() {
		return this.recorridoTopologico();
	}

	public Double capacidadMax() {
		Double resultado = Double.MAX_VALUE;
		for (Arista<Planta> arista : aristas) {
			if (resultado > ((Ruta) arista).pesoMax) {
				resultado = ((Ruta) arista).pesoMax;
			}
		}
		return resultado;
	}

	public List<List<Planta>> buscarCaminoEntre(Planta a, Planta b) {
		List<List<Planta>> salida = new ArrayList<List<Planta>>();
		List<Planta> marcados = new ArrayList<Planta>();
		marcados.add(a);
		this.buscarCaminosAux(a, b, salida, marcados);
		return salida;

	}

	private void buscarCaminosAux(Planta a, Planta b, List<List<Planta>> salida, List<Planta> marcados) {
		Queue<Planta> abyacentes = new LinkedList<Planta>(this.getAdyacentes(a));
		List<Planta> marcopia = null; // Juego de palabras muy malo
		while (!abyacentes.isEmpty()) {
			Planta actual = abyacentes.poll();
			marcopia = new ArrayList<Planta>(marcados);
			if (actual.equals(b)) {
				marcopia.add(b);
				salida.add(marcopia);
			} else {
				if (!marcados.contains(actual)) {
					marcopia.add(actual);
					this.buscarCaminosAux(actual, b, salida, marcopia);
				}
			}
		}
	}

	public Map<Planta, Map<Insumo, Integer>> necesidades() {
		Map<Planta, Map<Insumo, Integer>> result = new HashMap<Planta, Map<Insumo, Integer>>();
		List<Planta> plantas = this.vertices.stream().map(Vertice::getValor).collect(Collectors.toList());
		for (Planta actual : plantas) {
			Map<Insumo, Integer> datos = actual.nececidadStock();
			result.put(actual, datos);
		}
		return result;
	}

	public List<Pedido> vehiculoOptimo(Vehiculo v) {
		Planta distribuidora = this.recorridoTopologico().get(0);
		Map<Planta, Map<Insumo, Integer>> necesidades = this.necesidades();
		List<Pedido> posiblesEnvios = new ArrayList<Pedido>();
		Set<Planta> plantas = necesidades.keySet();
		Set<Insumo> insumos = null;
		for (Planta plantaActual : plantas) {
			Map<Insumo, Integer> plantaNecedidad = necesidades.get(plantaActual);
			insumos = plantaNecedidad.keySet();
			for (Insumo insumoActual : insumos) {
				posiblesEnvios.add(new Pedido(insumoActual, plantaNecedidad.get(insumoActual), distribuidora, plantaActual));
			}
		}
		posiblesEnvios = posiblesEnvios.stream().filter(s -> s.getPeso()<v.pesoMax).collect(Collectors.toList());
		return v.vehiculoOptimo(posiblesEnvios);
	}
}