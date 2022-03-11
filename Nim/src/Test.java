import java.util.Scanner; 

/* 

Brody Boucher 

Period 7 

11/21/18 

*/ 

import java.util.Random; 

public class Test  

{ 

     

    public static void main(String[]args) 

    { 

        Scanner in = new Scanner(System.in); 

        Random rand = new Random(); 

        Marbles pile=new Marbles(); 

         

        int count; 

        int num; 

         

        System.out.println("Would you like to play against the computer:     (Y or N)"); 

        String ans=in.nextLine(); 

        if (ans.equalsIgnoreCase("y")) 

        { 

            System.out.println("Player VS Computer"); 

            //if(rand.nextInt() == 0)  

            //{ 

                //dumbMode(in, rand, pile); 

            //} 

            //else 

            //{ 

                smartMode(in, rand, pile); 

            //} 

        } 

         

        else 

        { 

            System.out.println("Player VS Player"); 

            while(true) 

            { 

                System.out.println("There are "+pile.getMarbs()+" marbles in the pile"); 

                while(true) 

                { 

                    System.out.println("Player 1: How many marbles would you like to take?"); 

                    num=in.nextInt(); 

                    if(pile.isvalid(num)==true) 

                    { 

                        break; 

                    } 

                    else 

                    { 

                        System.out.println("Chose another number"); 

                    } 

                } 

                count=1; 

                pile.takeMarbs(num); 

                if(pile.last()==true) 

                { 

                    break; 

                } 

                System.out.println("There are "+pile.getMarbs()+" marbles in the pile"); 

                while(true) 

                { 

                    System.out.println("Player 2: How many marbles would you like to take?"); 

                    num=in.nextInt(); 

                    if(pile.isvalid(num)==true) 

                    { 

                        break; 

                    } 

                    else 

                    { 

                        System.out.println("Chose another number"); 

                    } 

                } 

                count=1; 

                pile.takeMarbs(num); 

                if(pile.last()==true) 

                { 

                    break; 

                } 

            } 

            if(count==1) 

            { 

                System.out.print("Player 2 wins"); 

            } 

            else 

            { 

                System.out.print("Player 1 wins"); 

            } 

         

        } 

     

  

     

    } 

     

    private static void dumbMode(Scanner in, Random rand, Marbles pile) { 

         

        int count; 

        int num; 

        while(true) 

        { 

            System.out.println("There are "+pile.getMarbs()+" marbles in the pile"); 

            while(true) 

            { 

                System.out.println("How many marbles would you like to take?"); 

                num=in.nextInt(); 

                if(pile.isvalid(num)==true) 

                { 

                    break; 

                } 

                else 

                { 

                    System.out.println("Chose another number"); 

                } 

            } 

            count=1; 

            pile.takeMarbs(num); 

            if(pile.last()==true) 

            { 

                break; 

            } 

            System.out.println("Computer Goes..."); 

            System.out.println("There are "+pile.getMarbs()+" marbles in the pile"); 

            int i=(int)(pile.getMarbs()/2); 

            int num1=rand.nextInt(i)+1;  //maybe +1 

            count =-1; 

            pile.takeMarbs(num1); 

            System.out.println("The computer choses "+num1+" marbles"); 

             

            if(pile.last()==true) 

            { 

                break; 

            } 

        } 

        if(count==1) 

        { 

            System.out.print("You Win"); 

        } 

        else 

        { 

            System.out.print("The computer Wins"); 

        } 

    } 

     

    private static void smartMode(Scanner in, Random rand, Marbles pile) 

    { 

        int count; 

        //int num; 

        while(true) 

        { 

            System.out.println("There are "+pile.getMarbs()+" marbles in the pile"); 

             

             

            pile.takeMarbs(playerGoes(pile, in)); 

            count=1; 

             

            if(pile.last()==true) 

            { 

                break; 

            } 

            System.out.println("Computer Goes..."); 

            System.out.println("There are "+pile.getMarbs()+" marbles in the pile"); 

            //int i=(int)(pile.getMarbs()/2); 

            //int num1=rand.nextInt(i)+1;  //maybe +1 

            count =-1; 

            int num1 = compGoes(pile, rand); 

            pile.takeMarbs(num1); 

            System.out.println("The computer choses "+num1+" marbles"); 

             

            if(pile.last()==true) 

            { 

                break; 

            } 

        } 

        if(count==1) 

        { 

            System.out.print("You Win"); 

        } 

        else 

        { 

            System.out.print("The computer Wins"); 

        } 

    } 

     

     

     

     

     

    private static int compGoes(Marbles pile, Random rand) { 

        int goodNums[] = { 

                3, 7, 15, 31, 63 

        }; 

         int pos;
         int tr;

        for(int i = goodNums.length - 1; i >= 0 ; i--) { 
        	
        	if(pile.getMarbs() <= 3) {
        		pos = 1;
        	}
        	else {
        		pos = pile.getMarbs() - goodNums[i];
        	}
        	
        	
        	
        	

             

        	

            if( pile.getMarbs() == goodNums[i]) 

            { 

            	tr = rand.nextInt(pile.getMarbs()/2) + 1;
            	if(pile.isvalid(tr)) {
            		return tr;
            	}

            	else {
            		return 1;
            	}

                         

            } 

            

            else if(pile.isvalid(pos)) 

            { 

                return pos; 

            } 

        } 

        return 1000; 

    } 

    private static int playerGoes(Marbles pile, Scanner in) { 

        int num; 

        while(true) 

        { 

            System.out.println("How many marbles would you like to take?"); 

            num=in.nextInt(); 

            if(pile.isvalid(num)==true) 

            { 

                break; 

            } 

            else 

            { 

                System.out.println("Chose another number"); 

            } 

        } 

        return num; 

    } 

} 

 