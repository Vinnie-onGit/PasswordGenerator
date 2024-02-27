package gen;

public class Alphabet {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWYXZ";
    private static final String LOWERCASE = "abcdefghijklmonpqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
    private final StringBuilder sb ;

    public Alphabet (boolean isUpperCase, boolean isLowerCase, boolean hasDigits, boolean hasSymbols){
        sb = new StringBuilder();
        if (isUpperCase) sb.append( UPPERCASE );
        if (isLowerCase) sb.append( LOWERCASE );
        if (hasDigits) sb.append( NUMBERS );
        if (hasSymbols) sb.append( SYMBOLS );
    }

    public String getAlphabet (){
        return sb.toString();
    }

}
