package gen;

public class Password {
    String value;
    int len;
    public Password (String s){
        value=s;
        len = s.length();
    }

    public int CharType (char c){
        int val = 0;
        int parsedChar = (int) c;

        if (parsedChar >= 65  && parsedChar<=90)
            val = 1;

        else if (parsedChar>=97 && parsedChar<=122)
            val = 2;

        else if (parsedChar >= 60 && parsedChar <= 71)
            val = 3;

        return val;
    }

    public int PasswordStrength (){
        String s = this.value;
        int strength = 0;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        int type=0;

        for (int i = 0; i<s.length(); i++){
            char c = s.charAt( i );
            type = CharType( c );


            if(type == 1) hasUpper = true;
            if(type == 2) hasLower = true;
            if(type == 3) hasDigit = true;
            if(type == 4) hasSymbol = true;

        }

        if(hasUpper) strength++;
        if(hasLower) strength++;
        if(hasDigit) strength++;
        if(hasSymbol) strength++;

        if(s.length()>8) strength++;
        if(s.length()>16) strength++;

        return  strength;
    }

    public String CalculatePasswordStrength(){
        int strength = this.PasswordStrength();

        if(strength>6){
            return "Good password";
        }
        else if(strength>=4){
            return "Keep working on it";
        }

        else if(strength<3){
            return "That password isn't good enough";
        }

        else
            return "DEFINITELY NOT";

        }
    @Override
    public String toString (){
        return value;
    }

}
