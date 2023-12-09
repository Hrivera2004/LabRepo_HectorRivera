
package labrepo_hectorrivera1;

import java.util.Random;
import java.util.Scanner;
public class LabRepo_HectorRivera1 {
    
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Random rd = new Random(); 
        System.out.println();
        System.out.println("-------------Menu-------------");
        System.out.println("Ejercicio práctico 1 – Dungeons and Dragons (6.75 puntos)");
        System.out.println("Ejercicio práctico 2 – Laberinto (2)");
        int opc = sc.nextInt();
        while(opc>0&&opc<3){
            switch(opc){
                case 1:
                    System.out.println(" [-------Dungeos and Dragons-------]");
                    DungeonsAndDragons DND = new DungeonsAndDragons(Seleccion());
                    DND.game();
                    break;
                case 2:{
                    System.out.println("-------MAZE-------");
                    char[][] Juego = {
                        {'#','#','#','#','#','#','#','#','#','#'},
                        {'#','C','#',' ',' ',' ','#','#',' ','#'},
                        {'#',' ','#',' ','#','#','#',' ',' ',' '},
                        {'#',' ','#',' ',' ',' ','#',' ','#','#'},
                        {'#',' ',' ',' ','#',' ','#',' ',' ','#'},
                        {'#',' ','#',' ','#',' ','#',' ',' ','#'},
                        {'#',' ','#',' ','#',' ',' ',' ',' ','#'},
                        {'#','#','#','#','#','#','#','#','#','#'}
                        };
                    int[] xy={1,1};
                    while(xy[0]!=9 || xy[1]!=2){
                        print(Juego);
                        Juego[xy[1]][xy[0]]=' ';
                        System.out.println("Ingrese un movimiento (w/a/s/d)");
                        char movement = sc.next().charAt(0);
                        xy = maze(movement,xy,Juego);
                        Juego[xy[1]][xy[0]]='C';
                    }
                    print(Juego);
                    System.out.println("A ganado!!");
                }
                    break;
            }
            System.out.println("-------------Menu-------------");
            System.out.println("Ejercicio práctico 1 – Dungeons and Dragons (6.75 puntos)");
            System.out.println("Ejercicio práctico 2 – Laberinto (2)");
            opc = sc.nextInt();
        }
        
    }
    public static char Seleccion(){
        char Character=' ';
        boolean chose = false;
        while(chose==false){
            System.out.println("--------Selecion--------");
            System.out.println("1.Caballero\nPuntos de vida: 250\nEnergia:50");
            System.out.println("");
            System.out.println("2.Mago\nPuntos de vida: 150\nEnergia:230");
            int opc = sc.nextInt();
            switch(opc){
                case 1:
                    Character='C';
                    chose=true;
                    break;
                case 2:
                    Character='M';
                    chose=true;
                    break;
                default:
                    System.out.println("Ingrese una de las 2 opciones");
            }
        }
        return Character;
    }
    public static int[] maze(char movement,int[] xy,char[][] Juego){
        if (movement=='w'||movement=='W') {
            if (Juego[xy[1]-1][xy[0]]!='#') {
                xy[1]-=1;
            }else{
                System.out.println("Movimiento No es valido");
            }
        }else if (movement=='a'||movement=='A'){
            if (Juego[xy[1]][xy[0]-1]!='#') {
                xy[0]-=1;
            }else{
                System.out.println("Movimiento No es valido");
            }
        }else if (movement=='S'||movement=='s'){
            if (Juego[xy[1]+1][xy[0]]!='#') {
                xy[1]+=1;
            }else{
                System.out.println("Movimiento No es valido");
            }
        }else if (movement=='d'||movement=='D'){
            if (Juego[xy[1]][xy[0]+1]!='#') {
                xy[0]+=1;
            }else{
                System.out.println("Movimiento No es valido");
            }
        }else{
            System.out.println("Ingrese movimiento valido");
        }
        return xy;
    }
    
    public static void print(char[][] x){
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j]+" ");
            }
            System.out.println();
        }
    }
}
