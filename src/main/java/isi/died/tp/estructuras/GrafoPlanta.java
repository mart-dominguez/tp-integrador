package isi.died.tp.estructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import isi.died.tp.dominio.Insumo;
import isi.died.tp.dominio.Planta;
import isi.died.tp.dominio.Stock;

public class GrafoPlanta extends Grafo<Planta> {
	public void imprimirDistanciaAdyacentes(Planta inicial) {
		List<Planta> adyacentes = super.getAdyacentes(inicial);
		for (Planta unAdyacente : adyacentes) {
			Arista<Planta> camino = super.buscarArista(inicial, unAdyacente);
			System.out.println("camino de " + inicial.getNombre() + " a " + unAdyacente.getNombre() + " tiene valor de "
					+ camino.getValor());
		}
	}

	// a
	public Planta buscarPlanta(Planta inicial, Insumo i, Integer saltos) {
		Planta result = null;
		List<Planta> marcados = new ArrayList<Planta>();
		Queue<Planta> pendientes = new LinkedList<Planta>();
		Queue<Planta> pendientes2 = new LinkedList<Planta>();
		marcados.add(inicial);
		pendientes.add(inicial);
		// agrego el inicial al pendiente y al marcado
		while (saltos != 0) {
			while (!pendientes.isEmpty()) {
				// quito uno de pendientes
				Planta actual = pendientes.poll();
				// Si los abyacentes no estan marcados y no estan en los pendientes quiere decir
				// que son de otro nivel
				// Asi que los agrego a una linda de pendientes diferentes
				List<Planta> aby = this.getAdyacentes(actual);
				for (Planta planta : aby) {
					if (!marcados.contains(planta) && !pendientes.contains(planta)) {
						pendientes2.add(planta);
					}
				}
				// Si el actual necesita el insumo lo retorno
				if (actual.necesitaInsumo(i)) {
					result = actual;
				} else {
					// marco al actual
					if (!marcados.contains(actual)) {
						marcados.add(actual);
					}
				}

			}
			// termine de analizar los pendientes
			// ahora los abyacentes de los nodos son los prox pendientes
			pendientes.addAll(pendientes2);
			pendientes2.clear();
			saltos--;
			// resto el salto;
		}
		// retorno null si nunca encontre una planta que necesite el insumo i en menos
		// de n saltos
		return result;
	}

	// b
	public Planta buscarPlanta(Planta inicial, Insumo i) {
		Integer dist = Integer.MAX_VALUE;
		Planta result = null;
		Map<Planta, Integer> distancias = this.caminosMinimoDikstra(inicial);
		List<Planta> plantas = this.recorridoTopologico();
		plantas.remove(inicial);
		plantas = plantas.stream().filter(s -> s.necesitaInsumo(i)).collect(Collectors.toList());
		System.out.print(plantas);
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

	// c
	public Planta buscarPlanta(Insumo i) {
		Planta resultado = null;
		Integer necesita = Integer.MIN_VALUE;
		// Tomo una lista con todas las plantas
		Queue<Planta> topo = new  LinkedList<Planta>(this.recorridoTopologico());;
		while(!topo.isEmpty()) {
			Planta actualPlanta = topo.poll();
			// para cada planta
			if (actualPlanta.necesitaInsumo(i)) {
				// si necesita el insumo la evaluo
				// tomo todo su stock
				List<Stock> actualStocks = actualPlanta.getStock();
				for (Stock sto : actualStocks) {
					// busco el stock i
					if (sto.getInsumo() == i) {
						// si el la cantidad que necesita - la cantidad que tiene es mayor al encontrado
						// anteriormente lo guardo siendo el con mayor diferencia;
						if (sto.getPuntoPedido() - sto.getCantidad() > necesita) {
							necesita = sto.getPuntoPedido() - sto.getCantidad();
							resultado = actualPlanta;
						}
					}
				}
			}
		}
		return resultado;
	}
	@Override
	public String toString() {
		return super.toString();
	}
}