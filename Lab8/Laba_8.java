class Lava_8{
  public static void main(String[] args){
    System.out.println(replace("abccbaf"));
  }


  public static String replace(String text){
    int len;		
    do{
      len = text.length();
      text = text.replaceAll("([a-z])\\1", "");
    }while(len != text.length());

    return text;
  }
}


