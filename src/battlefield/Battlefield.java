package battlefield;

import java.util.Random;


public class Battlefield
{

    public static void main(String[] args) throws InterruptedException
    {
        Random generator= new Random();
        int chance;
        chance = generator.nextInt(2);
        
        Fighter[] fighters =
        {
            new Fighter("Korys", 10, 1, 200,2),
            new Fighter("Lenoe", 20, 2, 100,2),
            new Fighter("Ha'ut", 30, 4, 20),
            new Fighter("Mokas", 7, 6, 350)
    
        };
        
        for(Fighter war: fighters)
        {
            System.out.print(war + " " + war.havePotions() + "\n");

        }
        
        
        
        System.out.println("|||||||||||| Battlefield ||||||||||||||||");
        
       fighters[0].strength =  fighters[0].calculateTheImpactPower();
       fighters[1].strength = fighters[1].calculateTheImpactPower();
       
       fighters[0].fight(fighters[1]);
 
     
    }
    
}
