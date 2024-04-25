package com.mycompany.russian.roulette;
import java.util.Random;
import java.util.Scanner;
public class RussianRoulette {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vidas = 7;
        int nxt = 1;
        int shield = 1;
        int LUCK = 1;
        int bullet = 3;
        int recharge = 1;
        Random random = new Random();
        System.out.println("¡Bienvenido a la Ruleta Rusa!");
        while(vidas>0){
            System.out.println("tienes " + vidas + " vidas");
            System.out.println("quieres seguir jugando?");
            String question = scanner.next();
            switch(question){
                case "s":
                    try{
                    nxt = random.nextInt(100);
                    System.out.println("El numero generado fue: " + nxt);
                            recharge = random.nextInt(6)+1;
                            if(recharge>4){
                                System.out.println("mala suerte, el repartidor ha ganado +1 bala");
                                bullet+=1;
                            }
                            System.out.println(bullet);
                        if(nxt%2==0 && bullet>0){
                            bullet -= 1;
                            LUCK = random.nextInt(100);
                            if(LUCK==0 | LUCK ==100){
                                System.out.println("La suerte Te sonríe, has sobrevivido a la ruleta!");
                            }else if(LUCK==50){
                                System.out.println("Pero aún hay más!");
                                System.out.println("VIDA EXTRA!");
                                vidas+=1;
                            }else if(LUCK == 75 || LUCK == 25 || LUCK == 90 ||LUCK == 10 ||LUCK == 2 || LUCK == 7 || LUCK == 19 || LUCK == 40 ||LUCK == 27 || LUCK == 99){
                                System.out.println("BONUS!!!, ahora tienes escudo + 1");
                                shield += 1;
                                System.out.println("tu numero de escudos ahora es: " + shield);
                            }else{
                                if(shield>0){
                                    System.out.println("Se cuidadoso ahora...");
                                    System.out.println("Te quitaron un escudo");
                                    shield -=1;
                                    System.out.println("tu numero de escudos ahora es: " + shield);
                            }else{
                                if(bullet>0){
                    System.out.println("numero de balas actual: " + bullet);
                    throw new Exception("Estás muerto!");
                            }else if(bullet==0){
                                    System.out.println("Salvado! el repartidor no tiene mas balas!");
                                }
                            }
                            }
                        }else{
                        System.out.println("Sobreviviste");
                        System.out.println("numero de balas actual: " + bullet);
                            }
                    }
                    catch(Exception exception){
                        System.out.println(exception.getMessage());
                        vidas-=1;
                    }
                    break;
                case "n":
                vidas-=7;
                break;
                default:
                System.out.println("escriba s o n correctamente");
                    break;
            }
        }
            System.out.println("GAME OVER");
    }
}
