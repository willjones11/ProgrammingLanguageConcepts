/*
In this problem you will be designing code that should be able to take in a file that is analyzed 
for lexical and syntactical correctness. This programming language should allow for the 
following type of statements:  
  
• switch  
• foreach 
• for  
• while 
• do-while 
• block  
• if  
• assignment 
• return 
*/
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;

public class lex {

    public static void main(String[] args) throws FileNotFoundException{
        File plc = new File("PLCpractical.txt"); //change depending on file location 
        FileReader p = null;
            try{
                p = new FileReader(plc);
                Scanner sc = new Scanner (plc);
                String statement = sc.nextLine();
                String[]  word = statement.split("\\s");
                for(int i = 0; i<word.length;i++){
                   if(word[i].equals("int") || word[i].equals("float") || word[i].equals("char") 
                        || word[i].equals("while") || word[i].equals("for") || word[i].equals("static")
                        || word[i].equals("void")  || word[i].equals("switch") || word[i].equals("double")
                        || word[i].equals("bool") || word[i].equals("class") || word[i].equals("if") 
                        || word[i].equals("long") || word[i].equals("else if") || word[i].equals("else") 
                        || word[i].equals("do") || word[i].equals("main") || word[i].equals("public") 
                        || word[i].equals("args")   )
                	System.out.println(word[i] + " keyword");  	
                   else if(word[i].equals("="))
                        System.out.println(word[i]+" assignment");
                   else if(word[i].equals("==") || word[i].equals("||") || word[i].equals("!="))
                        System.out.println(word[i]+" comparison");
                   else if(Pattern.matches("[/+*%]", word[i]))
                        System.out.println(word[i]+" operator");
                   else if(word[i].equals("{"))
                        System.out.println(word[i]+"open bracket");
                   else if(word[i].equals("}"))
                        System.out.println(word[i]+"closed bracket");
                   else if(word[i].equals("("))
                        System.out.println(word[i]+" open parentheses");
                   else if(word[i].equals(")") )
                        System.out.println(word[i]+" closed parentheses"); 
                   else if(word[i].equals(";") )
                        System.out.println(word[i]+" semicolon");     
                   else if(Pattern.matches("[a-zA-Z]*[0-9]*", word[i]))
                       	System.out.println(word[i]+" identifier");
                    else if(Pattern.matches("[0-9]*",word[i]))
                        System.out.println(word[i]+" integer");
                    else if(Pattern.matches("[0-9]*[.][0-9]*", word[i]))
                        System.out.println(word[i]+" float");
                }
                do { 
                if(statement.contains("if") && statement.contains("{") && statement.contains("}") && statement.contains("(") && statement.contains(")") && statement.contains(";")) {
                    System.out.println("\n IF STATEMENT- \n");
                    System.out.println(statement);  
               	}
             	if(statement.contains("for") && statement.contains("{") && statement.contains("}") && statement.contains("(") && statement.contains(")") && statement.contains(";")) {
                    System.out.println("\n FOR STATEMENT- \n");    
                    System.out.println(statement);           
               	}
             	if(statement.contains("for") && statement.contains("{") && statement.contains("}") && statement.contains("(") && statement.contains(")") && statement.contains(":")) {
                    System.out.println("\n FOR EACH STATEMENT- \n");                  
                    System.out.println(statement); 
               	}
            	if(statement.contains("do") && statement.contains("while") && statement.contains("{") && statement.contains("}") && statement.contains("(") && statement.contains(")") && statement.contains(";")) {
                    System.out.println("\n DO WHILE STATEMENT- \n");   
                    System.out.println(statement);
               	}
             	if(statement.contains("while") && !statement.contains("do") && statement.contains("{") && statement.contains("}") && statement.contains("(") && statement.contains(")") && statement.contains(";")) {
                    System.out.println("\n WHILE STATEMENT- \n");   
                    System.out.println(statement);
               	}
             	if(statement.contains("return") && statement.contains(";") ) {
                    System.out.println("\n RETURN STATEMENT- \n");
                    System.out.println(statement);
               	}
             	
             	if(statement.contains("{") && statement.contains("}") && !statement.contains("if")  && !statement.contains("for") && !statement.contains("switch") && !statement.contains("while") && !statement.contains("return") ) {
                    System.out.println("\n BLOCK STATEMENT- \n");
                    System.out.println(statement);    
               	}
             	if(statement.contains("switch") && statement.contains("case") && statement.contains("break") && statement.contains("{") && statement.contains("}") && statement.contains("(") && statement.contains(")") && statement.contains(";") && statement.contains(":")) {
                    System.out.println("\n SWITCH STATEMENT- \n");
                    System.out.println(statement);  
               	}
             		statement = sc.nextLine();
                } while(statement != null);

            }catch(Exception e){

            } 
            finally{
                try{
                    p.close();
                    

                }catch(Exception e){

                }
            }  
    }
}
