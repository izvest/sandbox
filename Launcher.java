public class Launcher{

    public static void main(Sring[] args){
        String ssn = args[0];
        ToolBox.print("Is hetu valid: "+ ToolBox.isHetuValid(ssn));
    }
}