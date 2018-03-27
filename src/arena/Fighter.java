package arena;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Fighter 
{
    int chance;
    int round=1;
    Random generator= new Random();
    Scanner in = new Scanner(System.in);
    
    public String name;
    public int strength;
    public int dexterity;
    public int health;
    public int potions;
   
    private Fighter()
    {
      this.potions = 2;
    
    }

    public Fighter(String imie, int sila, int zrecznosc, int zycie)
    {
        this();
        this.name = imie;
        this.strength = sila;
        this.dexterity = zrecznosc; 
        this.health = zycie;
    }
    
    public Fighter(String imie, int sila, int zrecznosc, int zycie, int potki)
    {
        
        this.name = imie;
        this.strength = sila;
        this.dexterity = zrecznosc; 
        this.health = zycie;
        this.potions = potki;
    }
    
    
    public int calculateTheImpactPower()
    {
        return this.strength = (this.strength/2)*this.dexterity;
    }
    
    public boolean havePotions()
    {
        return potions != 0; 
    
    }
    
    public void fight(Fighter f) throws InterruptedException
    {
 
        while(this.health >0 && f.health>0)
        {
            chance = generator.nextInt(2);
     
           System.out.println("Chance " + chance);
           System.out.printf("Round %d",round);
            System.out.println();
            if (chance==1 || chance ==2)
            {
              System.out.printf("%s hits for %d ", f.name, f.strength);
              System.out.println();
              TimeUnit.SECONDS.sleep(1);
              this.health -= f.strength;
              
              escape:
              if(this.health <=20)
              {
                  System.out.println(this.name + "...do You want a potion (1-yes/2-no)? +10hp");
                  this.havePotions();
                  int wybor = in.nextInt();
                  if(wybor==1 && potions >0)
                  {
                      this.health+=10;
                      this.potions--;
                      System.out.println(this.potions + " potions left");
                  }
                  else if(this.potions == 0 )
                  {
                      System.out.println("Your backpack with potions is empty!");
                      break escape;
                  }
                  else if(wybor==2)
                  {
                      break escape;
                  
                  }
             
              }
        
            }
           else if (chance ==0)
            {
             System.out.printf("%s hits for %d", this.name, this.strength);
             System.out.println();
             TimeUnit.SECONDS.sleep(1);
             f.health -= this.strength;
             
             escape2:
              if(f.health <=20)
              {
                  System.out.println(f.name + "...do You want a potion (1-y/2-n)? +10hp");
                  int wybor = in.nextInt();
                  if(wybor==1)
                  {
                      f.health+=10;
                      f.potions--;
                      System.out.println(f.potions + " potions left");
                
                      
                  }
                  
                  else if (f.potions <=0)
                  {
                      System.out.println("Your backpack with potions is empty!");
                      break escape2;
                  
                  }
                  else if(wybor==2)
                  {
                      break escape2;
                  
                  }
              }
        
            }
 
            System.out.println(this);
            System.out.println(f);
            round++;

            
        }

        if(this.health <=0)
        {
            System.out.println("Winner: " +f.name);
        }
        else if(f.health <=0)
        {
            System.out.println("Winner: "+this.name);
        }

    }
 
    @Override
    public String toString()
    {
        return "Name: "+this.name+ " - Health: "+this.health;
    }
   
}
