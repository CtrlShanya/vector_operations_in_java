
import java.util.*;
import java.util.Scanner;
import java.lang.Math;


class Vector_Operations 
{
    double[] answer;
    double[] vect;
    Vector_Operations(double[] vec, int n)
    {
        vect = new double[n];
        for(int i=0;i<n;i++)
        {
            vect[i]=vec[i];
        }
    }
    //Addition
    public double[] add(double[] vec2, int n)
    {
        answer=new double[n];
        int i=0;
        for(i=0;i<n;i++)
        {
            answer[i]=vect[i]+vec2[i];
        }
        return answer;
    }
    //Scalar Multiplication
    public double[] scalar_multiply(int n)
    {
        answer = new double[n];
        Scanner s = new Scanner(System.in);
        System.out.println("\nEnter the scalar you want to multiply: ");
        double t = s.nextDouble();
        int i=0;
        for(i=0;i<n;i++)
        {
            answer[i] = t*vect[i];
        }
        return answer;
    }
    //Dot Product
    public double dot_product(double[] vec2, int n)
    {
        double ans=0, pro;
        int i=0;
        for(i=0;i<n;i++)
        {
            pro=vect[i]*vec2[i];
            ans=ans+pro;
        }
        return ans;
    }
    //Magnitude
    public double mag(int n)
    {
       double m=0, mul;
       int i=0;
       for(i=0;i<n;i++)
       {
           mul=vect[i]*vect[i];
           m=m+mul;
       }
       try
       {
           m=Math.sqrt(m);
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
       return m;
    }
    //Direction
    public double[] direction(int n)
    {
        answer = new double[n];
        double m=mag(n);
        if(m==0)
        {
            System.out.println("m=0");
            answer[0]=m;
            return answer;
        }
        int i=0;
        for(i=0;i<n;i++)
        {
            answer[i]=vect[i]/m;
        }
        return answer;
    }
    public String toString(int n)
    {
        String vecto="(";
        for(int i=0;i<n;i++)
        {
            vecto=vecto+vect[i];
            if(i<(n-1))
            {
                vecto=vecto+",";
            }
        }
        vecto=vecto+")";
        return vecto;
    }
    public void Print(int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(vect[i]+" ");
        }
        System.out.print("\n");
    }
}
public class VectorFunctions
{
    public static void printin(double[] v, int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(v[i]+" ");
        }
    }
    public static void main(String args[])
    {
        int n=0, i;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter value of n: ");
        n = s.nextInt();
        double[] vec_tor = new double[n]; 
        double[] vec1 = new double[n];
        System.out.println("Enter 1st input array: ");
        for(i=0;i<n;i++)
        {
            if(s.hasNext())
            {
                vec_tor[i] = s.nextDouble();
            }
                
            else
            {
                System.out.println("You didn't provide enough numbers!");
                break;
            }
        }
        System.out.println("Enter 2nd input array: ");
        for(i=0;i<n;i++)
        {
            if(s.hasNext())
            {
                vec1[i] = s.nextDouble();
            }
                
            else
            {
                System.out.println("You didn't provide enough numbers!");
                break;
            }
        }
        double[] add1=new double[n];
        double[] scale=new double[n];
        double dot=0, mag=0;
        double[] dir= new double[n];
        Vector_Operations v1 = new Vector_Operations(vec_tor, n);
        add1=v1.add(vec1, n);
        System.out.println("Addition: ");
        printin(add1, n);
        scale = v1.scalar_multiply(n);
        System.out.println("Scalar product is: ");
        printin(scale, n);
        
        dot=v1.dot_product(vec1, n);
        System.out.println("Dot Product is: "+dot);
        mag = v1.mag(n);
        System.out.println("Magnitude is: "+mag);
        dir = v1.direction(n);
        System.out.println("Direction is: ");
        printin(dir, n);
        String vec = v1.toString(n);
        System.out.println("\nString representation: "+vec);
    }
    
}
