package com.sample;


public class Mes {
	private int[] data = new int[3];
	

	public void setData(int[] data) {
		this.data = data;
	}

	public int getDia() {
		return data[0];
	}
	
	public int getMes() {
		return data[1];
	}
	
	public int getAno() {
		return data[2];
	}
	

	public String getData() {
		return data[0] + "-" + data[1] + "-" + data[2];
	}
	
	public void adicionaMes(int mes) {
		data[1] += mes;
		while(data[1] > 12){
			data[1] = data[1] - 12;
			data[2]++;
		}
		
		
	}
	
	public Mes(int[] data) {
		super();
		this.data = data;
	}
	
}
