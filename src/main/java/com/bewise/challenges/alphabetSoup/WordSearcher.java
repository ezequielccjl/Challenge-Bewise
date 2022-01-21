package com.bewise.challenges.alphabetSoup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class WordSearcher {

	private char soup[][];

	public WordSearcher(char soup[][]) {
		this.soup = soup;
	}

	private String noIr="";
	
	private char[] palabraChar;
	
	private Posicion posicion;

	public boolean isPresent(String word) {
		setPalabraChar(word.toCharArray());
		ArrayList<Posicion> ubicacionPrimerasLetras = buscarPrimerasLetras();

		for (Posicion posicionPrimeraLetra : ubicacionPrimerasLetras) {
			noIr="";
			setPalabraChar(word.toCharArray());
			posicion = posicionPrimeraLetra;
			palabraChar = Arrays.copyOfRange(palabraChar, 1, palabraChar.length);
			while(buscarEnDireccion(palabraChar[0])){
				if(palabraChar.length==0) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean buscarEnDireccion(char letraBuscar) {
		//Buscar abajo
		if(posicion.getI()<29 && soup[posicion.getI() + 1][posicion.getJ()] == letraBuscar && noIr!="abajo") {
			palabraChar = Arrays.copyOfRange(palabraChar, 1, palabraChar.length);
			noIr = "arriba";
			posicion.setI(posicion.getI()+1);
			return true;
		}
		//Buscar arriba
		if(posicion.getI()!=0 && soup[posicion.getI() -1][posicion.getJ()] == letraBuscar && noIr!="arriba") {
			palabraChar = Arrays.copyOfRange(palabraChar, 1, palabraChar.length);
			noIr = "abajo";
			posicion.setI(posicion.getI()-1);
			return true;
		}
		//Buscar a la derecha
		if(posicion.getJ()<29 && soup[posicion.getI()][posicion.getJ()+1] == letraBuscar && noIr!="derecha") {
			palabraChar = Arrays.copyOfRange(palabraChar, 1, palabraChar.length);
			noIr = "izquierda";
			posicion.setJ(posicion.getJ()+1);
			return true;
		}
		//Buscar a la izquierda
		if(posicion.getJ()!=0 && soup[posicion.getI()][posicion.getJ()-1] == letraBuscar && noIr!="izquierda") {
			palabraChar = Arrays.copyOfRange(palabraChar, 1, palabraChar.length);
			noIr = "derecha";
			posicion.setJ(posicion.getJ()-1);
			return true;
		}
		return false;
	}	
		
	public ArrayList<Posicion> buscarPrimerasLetras(){
		ArrayList<Posicion> primerasUbicaciones = new ArrayList<Posicion>();
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				if (soup[i][j] == palabraChar[0]) {
					primerasUbicaciones.add(new Posicion(i, j));
				}
			}
		}
		return primerasUbicaciones;
	}

	public void setPalabraChar(char[] palabraChar) {
		this.palabraChar = palabraChar;
	}
	
}
