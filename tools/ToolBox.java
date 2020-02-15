import java.util.ArrayList;

class ToolBox {

    private static String ssnTarkistusmerkit = "0123456789ABCDEFHJKLMNPRSTUVWXY";

    public ToolBox(){}

    public static void main(String[] args){
        String ssn = args[0];
        print("Is hetu valid: " + (isHetuValid(ssn) == null ? "Yes" : "No: " + isHetuValid(ssn)));
        print("Deduce hetu: " + detuceHetu(ssn.substring(0,6), ssn.substring(ssn.length()-1, ssn.length()), true));
    }

    public static String isHetuValid(String ssn){
        if (isEmpty(ssn) || ssn.length() != 11){
            return "Pituus";
        }
        if (Integer.parseInt(ssn.substring(0,2)) > 31 || Integer.parseInt(ssn.substring(2,4)) > 12){
            return "Date";
        }
        if (ssn.charAt(6) != '-' && ssn.charAt(6) != '+' && ssn.charAt(6) != '0'){
            return "Välimerkki";
        }
        if (ssnTarkistusmerkit.indexOf(ssn.charAt(10)) == -1){
            return "Tarkistusmerkki";
        }
        try{
            int hetuAsInt = Integer.parseInt(ssn.substring(0,6))*1000;
            int checkPart = Integer.parseInt(ssn.substring(7,10));
            if (checkPart < 2 || checkPart > 899){
                return "Checksum";
            }
            int ssnModulo = (hetuAsInt + checkPart) % 31;
            if (ssnTarkistusmerkit.charAt(ssnModulo) == ssn.charAt(10)){
                return null;
            }
            return "Tarkistusmerkki";
        } catch (Exception e){
            return "Poikkeus";
        }
    }

    public static ArrayList<String> detuceHetu(String birthDate, String tarkistusmerkki, boolean male){
        ArrayList<String> result = new ArrayList<>();
        try{
            int hetuAsInt = Integer.parseInt(birthDate)*1000;
            int checkCharAsInt = ssnTarkistusmerkit.indexOf(tarkistusmerkki);
            if (Integer.parseInt(birthDate.substring(0,2)) > 31 || Integer.parseInt(birthDate.substring(2,4)) > 12){
                return null;
            }
            for (int i = 2 ; i < 900 ; i++){
                if (male && i%2 == 0){continue;}
                if ((hetuAsInt + i) % 31 == checkCharAsInt){
                    String nollat = "";
                    int k = Integer.toString(i).length();
                    if(k < 3){
                        for (int j = k; j < 3; j++){
                            nollat += "0";
                        }
                    }
                    result.add(birthDate+"-"+nollat+i+tarkistusmerkki);
                }
            }
        } catch (Exception e){
            return null;
        }
        return result;
    }

    public static boolean isEmpty(String s){
        if (s == null){return true;}
        if (s.isEmpty()){return true;}
        if (s.charAt(0) == ' '){return true;}
        return false;
    }

    public static void print(Object o){
        System.out.println(o);
    }
}