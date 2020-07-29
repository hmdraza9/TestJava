package javaConcepts;

public class Hello {
	   String name;
	   //Constructor
	   Hello(){
	      this.name = "BeginnersBook.com";
	   }
	   public static void main(String[] args) {
	      Hello obj = new Hello();
	      System.out.println(obj.name);
//	      DataTable arg1 = null;
//	      List<String> data = arg1.
//	      list of functional interfaces
//	      Comparable f = new Comparable();
//	      Runnable er
//	      ActionListener cc
	      String str1="AH e l l  o";
	      String str2="AAH e l l o";
	      System.out.println(str1.compareTo(str2));
	   }
	}