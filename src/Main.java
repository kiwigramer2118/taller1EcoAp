import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	
	int pantalla;
	int contador;
	int a1,a2;
	float ty , vel;
	boolean ac1,ac2;
	boolean dead1, dead2;
	PImage carro1,carro2,track,oil1,oil2, meta, inicio, iniciar, reiniciar, pfinal, instrucciones;
	
	int posxc1, posyc1;
	int posxc2, posyc2;
	int acx1,acy1;
	int acx2,acy2;
	
	int posymeta;
	
	boolean lc1,lc2;
	
	int posxo1,posyo1;
	int posxo2,posyo2;
	
	String ganador;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());

	}
	public void settings() {
		size(850,700);					
	}
	
	public void setup() {
		pantalla =0;
		
		contador=11;
		
		a1=25;
		a2=825;
		ac1 =false;
		ac2 = false;
		ty=-700;
		vel=1;
		
		posxc1=300;
		posxc2=500;
		posyc1=500;
		posyc2=500;
		
		dead1 =false;
		dead2= false;
		
		acx1=0;
		acx2=0;
		acy1=0;
		acy2=0;
		lc1=false;
		lc2=false;
		
		posxo1 =0;
		posyo1=-700;
		posxo2=0;
		posyo2 =-700;
		
		posymeta=-700;
		
		ganador="";
		
		carro1 = loadImage("./imagenes/car1.png");
		carro2 = loadImage("./imagenes/car2.png");
		track = loadImage("./imagenes/track.png");
		oil1 = loadImage("./imagenes/oil1.png");
		oil2 = loadImage("./imagenes/oil2.png");
		meta = loadImage("./imagenes/meta.png");
		inicio = loadImage("./imagenes/inicio.png");
		iniciar = loadImage("./imagenes/iniciar.png");
		reiniciar = loadImage("./imagenes/reiniciar.png");
		pfinal = loadImage("./imagenes/final.png");
		instrucciones = loadImage("./imagenes/intrucciones.png");
		
		
		
		
	}
	
	public void draw() {
		
		//////////////////////////////
		switch(pantalla) {
		case 0:
			
			image(inicio, 0, 0,850,700);
			image(iniciar, 300, 500,200,70);
			
			
			break;
			
		case 1: 
			
			System.out.println(posxo1);
			System.out.println(posxc1);
			
			
			background(255);
			//////////////////////////////
			image(track, 0, ty,850,1405);
			image(meta, 0, posymeta,850,100);
			image(oil2, posxo1, posyo1,100,150);
			image(oil2, posxo2, posyo2,100,150);
			image(carro1, posxc1, posyc1,100,180);
			image(carro2, posxc2, posyc2,100,180);
					
			//////////////////////////////
			if(contador>0) {
			fill(200,200,30);
			rect(25,25,250,70);
			
			fill(30,200,30);
			rect(275,25,30,70);
			
			fill(200,30,30);
			rect(305,25,50,70);
			
			fill(10,10,10);
			rect(a1,20,10,80);}
			
			if( ac1 == false && a1>25){
				a1-=3;
			}
			if(keyPressed && a1<355){
				if (key == 'a') {
				     a1+=3;
				     ac1=true;
				    }}else { ac1=false; }
			
			
if(a1>275 && a1<305 && contador ==0  ) {
				
				lc1=true;
			}
			
			if(lc1==true) {
				posyc1-=0.8;
			}
			
			if(posyc1<450) {
				lc1=false;}
				
			
			//////////////////////////////
			if(contador>0) {
			fill(200,200,30);
			rect(575,25,250,70);
			
			fill(30,200,30);
			rect(545,25,30,70);
			
			fill(200,30,30);
			rect(495,25,50,70);
			
			fill(10,10,10);
			rect(a2,20,10,80);}
			
			if( ac2 == false && a2<825){
				a2+=3;
			}
			
			if(a2>545 && a2<575 && contador ==0  ) {
				
				lc2=true;
			}
			
			if(lc2==true) {
				posyc2-=0.8;
			}
			
			if(posyc2<450) {
				lc2=false;
			}
			if(keyPressed && a2>495){
				if (key == 'd') {
				     a2-=3;
				     ac2=true;
				    }
			}else { ac2=false; }
			
			
		
			
		     //////////////////////////////
					if(frameCount %30 ==0) {				
						contador-=1;
					}
					
					if(contador<=0) {
						ty+=vel;
					}
					
					if( ty>-700) {
						
						vel+=0.1;
						
					}
					
					if(ty >0) {
						ty=-700;
					}
					textSize(45); 
					fill(60,230,0);
					if(contador >=0) {
					text(contador,400,80);}
					
		            //////////////////////////////
					
					if(keyPressed  ){
						if (key == 'q') {
							 posxc1=50 ;
						   
						    }
					}
					
					if(keyPressed ){
						if (key == 'e') {
							 posxc1=300;
						   
						    }
					}
					
				    //////////////////////////////
					
					if(keyPressed  ){
						if (key == 'z') {
							 posxc2=500 ;
						   
						    }
					}
					
					if(keyPressed ){
						if (key == 'c') {
							 posxc2=740;
						   
						    }
					}
					
				
					
				 //////////////////////////////
					
					if(contador ==0 || posyo1 >1400) {
						posxo1=(int)random(0,2);
						
						posyo1=-700;
					}
					
					if(posxo1 ==0) {
						posxo1=50;
					}
					if(posxo1==1) {
						posxo1=300;
					}
					if(contador <0 ) {
						posyo1+=vel;
					}
					
					if(posxo1 == posxc1 && posyc1<posyo1+100 && posyc1>posyo1) {
						
						dead1=true;
					}
					if(dead1==true) {
						posxc1-=8;
						posyc1+=8;
						
					}
					
					
					
					
				//////////////////////////////
					
					
					
					if(contador ==0 || posyo2 >1400) {
						posxo2=(int)random(0,2);
						
						posyo2=-700;
					}
					
					if(posxo2 ==0) {
						posxo2=500;
					}
					if(posxo2==1) {
						posxo2=740;
					}
					if(contador <0 ) {
						posyo2+=vel;
					}
					
					if(posxo2 == posxc2 && posyc2<posyo2+100 && posyc2>posyo2) {
						
						dead2=true;
					}
					if(dead2==true) {
						posxc2+=8;
						posyc2+=8;
						
					}
					
					
					if(contador <-15) {
						posymeta+=vel;
					}
					if(dead1==true && dead2 == true) {
						pantalla=3;
					}
					
					if (posymeta>500) {
						
						if(posyc1<posyc2) {
							ganador="AZUL";
							pantalla=2;
						}
						
						if(posyc1>posyc2) {
							ganador="ROJO";
							pantalla=2;
						}
					
						
						
					}
					
					
					
					//////////////////////////////
					
	
		
					break;
					
		case 2:
			image(pfinal, 0, 0,850,700);
			image(reiniciar, 300, 500,200,70);
			textSize(40); 
			fill(0);
			text("el ganador es " +ganador,50,300);
			
			
			break;
			
		case 3:
			image(pfinal, 0, 0,850,700);
			image(reiniciar, 300, 500,200,70);
			textSize(80); 
			fill(0);
			text("EMPATE",100,400);
			
			
			break;
		case 4:
			image(instrucciones, 0, 0,850,700);
			image(iniciar, 300, 500,200,70);
			
			break;
		
		}}
	public void mousePressed() {
		if(pantalla==0 && mouseX<500 && mouseX>300 && mouseY<570 && mouseY>200 ) {
			pantalla=4;
			
		}
		if(pantalla==4 && mouseX<500 && mouseX>300 && mouseY<570 && mouseY>200 ) {
			pantalla=1;
			
		}
		
		if(pantalla==2 && mouseX<500 && mouseX>300 && mouseY<570 && mouseY>200 ) {
			contador=11;
			
			a1=25;
			a2=825;
			ac1 =false;
			ac2 = false;
			ty=-700;
			vel=1;
			
			posxc1=300;
			posxc2=500;
			posyc1=500;
			posyc2=500;
			
			dead1 =false;
			dead2= false;
			
			acx1=0;
			acx2=0;
			acy1=0;
			acy2=0;
			lc1=false;
			lc2=false;
			
			posxo1 =0;
			posyo1=-700;
			posxo2=0;
			posyo2 =-700;
			
			ganador="";
			posymeta=-700;
			
			
			
			
			pantalla=1;
			
		}
		if(pantalla==3 && mouseX<500 && mouseX>300 && mouseY<570 && mouseY>200 ) {
			
			contador=11;
			
			a1=25;
			a2=825;
			ac1 =false;
			ac2 = false;
			ty=-700;
			vel=1;
			
			posxc1=300;
			posxc2=500;
			posyc1=500;
			posyc2=500;
			
			dead1 =false;
			dead2= false;
			
			acx1=0;
			acx2=0;
			acy1=0;
			acy2=0;
			lc1=false;
			lc2=false;
			
			posxo1 =0;
			posyo1=-700;
			posxo2=0;
			posyo2 =-700;
			
			ganador="";
			posymeta=-700;
			
			
			pantalla=1;
			
		}
		
		
		if(pantalla ==1 && mouseX<475 && contador <=0) {
			posyc1-=1;
		}
		if(pantalla ==1 && mouseX>475 && contador <=0) {
			posyc2-=1;
		}
		
		
		
	}

}
