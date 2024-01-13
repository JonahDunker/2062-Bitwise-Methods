import java.util.Scanner;

public class BitwiseMethods {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    System.out.println(binarySum(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine())));
    /*int limit = Integer.parseInt(in.nextLine());
    for(int i = 0; i < limit; i++) {
      int sum = binarySum(i, i+1);
      if(sum != (i + (i+1))) {
        System.out.println(sum+" does not equal "+i+" "+(i+1));
      }
    }*/
  }

  public static int binaryRepresentations1(int num) {
    int count = 0;
    while(num > 0) {
      count += num & 1;
      num >>= 1;
    }
    return count;
  }

  public static int binarySum(int num1, int num2) {
    int sum = 0;
    int increase = 0;
    while((num1 & num2) > 0) {
      increase = num1 & num2;
      //System.out.println("Increase "+increase);
      num1 = increase ^ num1;
      num2 = increase ^ num2;
      increase <<= 1;
      increase = increase | num1 | num2;
      //System.out.println("Num1 "+num1);
      //System.out.println("Num2 "+num2);
    }
    sum = increase | num1 | num2;
    return sum;
  }

  public static boolean isOddBinary(int num) {
    int odd = num & 1;
    boolean isOdd = odd == 1;
    return isOdd;
  }
}

// 0011 3
// 0101 5

// 0001 1
// 0010 2 (3)
// 0100 4 (5)

// 0010