/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labrepo_hectorrivera1;
import java.util.Random;
import java.util.Scanner;

public class DungeonsAndDragons {
    Random rd = new Random(); 
    Scanner sc = new Scanner(System.in);
    char Caracter;
    int HP;
    int NRG;
    int[] Dragones={0,0,0,0}; 
    int x=0;
    int y=0;
    private char[][] Tablero = {//H = ♡ y T = ▲
        {'-','H','-','H','-','-','H','-','-','H'},//verde
        {'-','T','-','-','-','-','-','-','T','-'},
        {'-','H','T','H','-','-','H','T','-','H'},
        {'-','-','-','T','-','-','T','-','-','-'},//amarillo
        {'-','H','-','H','T','T','H','-','-','H'},
        {'-','-','-','-','T','T','-','-','-','-'},
        {'-','H','-','H','-','-','H','-','-','H'},//naranja
        {'-','-','T','-','-','-','-','T','-','-'},
        {'-','H','-','H','-','-','H','-','T','H'},
        {'T','-','-','-','-','-','-','-','-','-'}//rojo
    };
    char[][] Juego = {//H = ♡ y T = ▲
        {'-','H','-','H','-','-','H','-','-','H'},//verde
        {'-','T','-','-','-','-','-','-','T','-'},
        {'-','H','T','H','-','-','H','T','-','H'},
        {'-','-','-','T','-','-','T','-','-','-'},//amarillo
        {'-','H','-','H','T','T','H','-','-','H'},
        {'-','-','-','-','T','T','-','-','-','-'},
        {'-','H','-','H','-','-','H','-','-','H'},//naranja
        {'-','-','T','-','-','-','-','T','-','-'},
        {'-','H','-','H','-','-','H','-','T','H'},
        {'T','-','-','-','-','-','-','-','-','-'}//rojo
    };
    
    public DungeonsAndDragons() {
    }

    public DungeonsAndDragons(char Caracter) {
        this.Caracter = Caracter;
    }

    public char getCaracter() {
        return Caracter;
    }
    public int getHP() {
        return HP;
    }
    public int getNRG() {
        return NRG;
    }
    
    public void setCaracter(char Caracter) {
        this.Caracter = Caracter;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public void setNRG(int NRG) {
        this.NRG = NRG;
    }
    
    public void game(){
        System.out.println(Caracter);
        CharacterSelection();
        Juego[y][x]=Caracter;
        print(Juego);
        boolean win = false;
        while(win == false){
            int dice = rd.nextInt(16-1) + 1;
            win = Avanzar(dice,win);
            print(Juego);
            
            if (win==false&&HP>0) {
                powerUp(y,x);
                if (dice%2!=0) {
                    pelea();
                }
                System.out.println("Vida: "+HP);
                System.out.println("Energia: "+NRG);
                System.out.println("Ingrese enter si desea continuar");
                String opc=sc.nextLine();  
            }else if (win==true){
                System.out.println("En hora buena a escapado");
            }else{
                System.out.println("A perdido");
            }
            
        }
    }
    public boolean Avanzar(int dice,boolean win){

        System.out.println("Se han rodado los dados: "+dice);
        Juego[y][x] = Tablero[y][x];
        
        for (int i = 0; i < dice && win == false; i++) {
            if (y==Juego.length-1 && x==Juego.length-1) {
                win=true;
                x=9;
                y=9;
            }else{
                x++;
                if (x==Juego.length) {
                    y++;
                    x=0;
                } 
            }
            
        }
        Juego[y][x]=Caracter;
        return win;
    }
    public void pelea(){
        boolean found = false;
        if (y<3&&Dragones[0]<3) {
            Dragones[0]++;
            found= true;
        }else if(y<6&&Dragones[1]<4){
            Dragones[1]++;
            found= true;
        }else if(y<9&&Dragones[2]<5){
            Dragones[2]++;
            found= true;
        }else if(y==9&&Dragones[3]<6){
            Dragones[3]++;
            found= true;
        }
        
        if (found==true) {
            System.out.println("Se a encontrado con un dragon: ");
            int chance = rd.nextInt(100-1) + 1;
            if (chance%2==0) {
                System.out.println("Ha derotado al dragon");
                NRG-=5;
            }else{
                System.out.println("Ha huido del dragon");
                HP-=25;
            }
        }
    }
    public void CharacterSelection(){
        if (Caracter=='C') {
            HP = 250;
            NRG = 50;
        }else if(Caracter=='M'){
            HP = 150;
            NRG = 230;
        }
    }
    public void powerUp(int y,int x){
        if (Tablero[y][x]=='H') {
            System.out.println("Bonificacion +20 HP");
            HP+=20;
        }else if (Tablero[y][x]=='T') {
            System.out.println("Bonificacion +5 Energia");
        }
    }
    public void print(char[][] x){
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
