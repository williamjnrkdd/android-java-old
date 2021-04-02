public class Sum1{
    public static void main(String[] args){
        int num =0;
        int i;
        String spaces="     ";
        String currentSpace="";
        for(i = 1; i<=10; i++){
            if(i>1 && i<6){
                currentSpace += spaces;
            }
            else{
                currentSpace += "\b\b\b\b\b";
            }
            num +=i;
            System.out.println(currentSpace+num);
        }
    }
}