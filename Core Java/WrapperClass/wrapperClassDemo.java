package WrapperClass;
import java.util.*;
class wrapperClassDemo{
  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<>();
    nums.add(77);
    nums.add(90);
    nums.add(89);
    nums.add(100);
    nums.add(95);
    int total = 0;

    for(int n : nums){
        total = total + n;
    }

    System.out.println("Total marks   : "+(total));
    System.out.println("Average marks : "+(total/nums.size()));
  }
}