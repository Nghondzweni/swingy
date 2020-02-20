package ExtraClasses;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Scanner {

        private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public static String readLine(){
            try{
                return reader.readLine();
            }
            catch (Exception e){
                System.out.println("Error reading input");
            }
            return null;
        }
}
