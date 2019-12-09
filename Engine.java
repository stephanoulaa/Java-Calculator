import java.text.DecimalFormat;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.script.*;


public class Engine {
        
    public static String calc(String input) {
        
       
       
       
       //possible regex expression, notes
       //^\\d+?([-/*+])$
       // ? is zero to any
       // + is one to any
       //this regex pattern will search for the correct operators
       if (Pattern.compile("\\d+(\\.\\d+)?[-+*/]+").matcher(input).matches()) {
           input = input.substring((0), (input.length()-1));
       }
       
       ScriptEngineManager mgr = new ScriptEngineManager();    
       ScriptEngine engine = mgr.getEngineByName("JavaScript"); 
       
       Pattern addition = Pattern.compile("[+]");
       Pattern subtraction = Pattern.compile("[-]");
       Pattern multiplication = Pattern.compile("[*]");
       Pattern division = Pattern.compile("[/]");
       
       Matcher a = addition.matcher(input);
       Matcher s = subtraction.matcher(input);
       Matcher m = multiplication.matcher(input);
       Matcher d = division.matcher(input);
       
       input = a.replaceAll(")+");
       input = s.replaceAll(")+");
       input = m.replaceAll(")+");
       input = d.replaceAll("/");
       
       
       for (int i=0; i<input.length(); i++) {
           if (input.charAt(i) == ')') {
               input = "(" + input;
           }
       }
       
       
       try {
           String temp = engine.eval(input).toString();
           if (temp.equals("Infinity")) {
               temp = "ERROR";
           } 
           
           double dbl = Double.parseDouble(temp);
           DecimalFormat temp2 = new DecimalFormat("0.####");
           temp = temp2.format(dbl);
           if (temp.equals("-0")) {
               temp = "0";
           }
           return temp;
       }catch(Exception e) {
           return "0";
        }
        
        //return "ERROR";
    }
    
    
    
}