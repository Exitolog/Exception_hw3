import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class ValidFacade {


    private Validable validable;

    public ValidFacade(String string) {
        this.validable = new Valid(string.split("\\s"));
    }

   public boolean validAll() {
        boolean[] bool = {validable.validStr(),validable.validDate(),  validable.validNumber(),validable.validSexual()};
       for (int i = 0; i <bool.length ; i++) {
           if(bool[i] == false) {
               return false;
           }
       }
        return true;
       }
   }

//    Andreev Andrei 321321 21.10.2000 номерелефона fm
//    Andreev Andrei Andu 32.10.2000 11 f
//    Andreev Marat Sergeevich 01.09.1992 21001 m
