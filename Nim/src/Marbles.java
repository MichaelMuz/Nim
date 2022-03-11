import java.util.Random; 

/* 

Brody Boucher 

Period 7 

11/21/18 

*/ 

public class Marbles  

{ 

    Random rand = new Random(); 

    private int marbs; 

    public Marbles()  

    { 

        marbs=rand.nextInt(90)+10; 

    } 

    public void takeMarbs(int num) 

    { 

        marbs=marbs-num; 

    } 

    public int getMarbs() 

    { 

        return marbs; 

    } 

    public boolean isvalid(int num) 

    { 

        if((marbs/2)>=num && (num > 0)) 

        { 

            return true; 

        } 

        else 

        { 

            return false; 

        } 

    } 

    public boolean last() 

    { 

        if(marbs==1) 

        { 

            return true; 

        } 

        else 

        { 

            return false; 

        } 

    } 

}