import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;



public class quiz{

  public static void main(String [] args) throws IOException{
    
      System.out.println("Goodluck on this killer quiz!!!");
      System.out.println("");

      for (int v = 0; v<5; v++){
       
        int g = v+1;

        Scanner s = new Scanner(System.in);

   
       // turning file into an array


        Scanner inFile1 = new Scanner(new File("question"+g+".txt"));

        ArrayList<String> questions = new ArrayList<String>();

    
        while (inFile1.hasNextLine()) {
      
          questions.add(inFile1.nextLine());
        }
      
        inFile1.close();

    
        String[] questionArray = questions.toArray(new String[0]);


        // doing actual quiz things now
        System.out.println(questionArray[0]);
      

        String numberoptions = questionArray[1];
        int N = Integer.parseInt(numberoptions);
        N +=2;

        int D = N - 1;

        for (int i = 2; i<N; i++){
          System.out.println(questionArray[i]);
        }

        int K = N;
        String spot = questionArray[K];
        int answer = Integer.parseInt(spot);


        System.out.print("Your Answer?   ");
        int ans = s.nextInt();


        int A = ans+1;

        int T = K+1;
        int C = K+2;
      
        String trycounter = questionArray[T] ;
        double tc = Double.parseDouble(trycounter);

        String correctcounter = questionArray[C] ;
        double cc = Double.parseDouble(correctcounter);


        if (ans == answer)
        {
          cc++;
          tc++;

          String tried = Double.toString(cc);
          questionArray[T] = tried;

          FileWriter writer = new FileWriter("question"+g+".txt"); 
        
          for(String str: questionArray) {
            writer.write(str + "\r\n");
          }
        
         writer.close();

          double qs = (cc/tc) * 100;
          System.out.println("");
          System.out.println("Your answer was CORRECT! GOODJOB");
          System.out.println("Average amount of people who got this question correct: %"+ qs);
          System.out.println("");
        }





        else{
        
          tc++;
          String tried = Double.toString(tc);
          questionArray[T] = tried;

          FileWriter writer = new FileWriter("question"+g+".txt"); 
        
          for(String str: questionArray) {
            writer.write(str + "\r\n");
          }


          double qs = (cc/tc) * 100;
          System.out.println("");
          System.out.println("Your answer was INCORRECT!");
          System.out.println("You said..." + questionArray[A]);
          System.out.println("The correct answer was... "+ questionArray[D]);
          System.out.println("Average amount of people who got this question correct: %"+ qs);
          System.out.println("");
        
        
          writer.close();

        }

      }
      public void stats() throws IOException

  } 


}







