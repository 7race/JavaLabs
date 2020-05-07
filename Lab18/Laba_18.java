import java.math.*;

class Main{

    public static void main(String[] args) {
      BigInteger a = new BigInteger("9000000000000000000");
      BigInteger b = new BigInteger("8444444444444444444");

      BigInteger result = a.add(b).divide(BigInteger.valueOf(2));

      System.out.println(result);

    }
}

