package Arrays;

public class SquaresOfDigits {

    static long squareOfDigits(int number){
        int temp = 0;
        int result = 0;
        while (number>0){
            temp = number%10;
            number = number/10;
            result+= temp*temp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(squareOfDigits(2345));
    }
}
