package javaConcepts2;

public class VersionCompareClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] arrayOfVersion = {"1.11.2","2.1.08","1.1.12","2.10.8","2.2.10"};
		int size = arrayOfVersion.length;
		int a=0;
		int b=0;
		int c=0;
		
		for(int i=0;i<size;i++) {
			String str = arrayOfVersion[i].replace(".", "-");
			String[] newStr = str.split("-");
			int temp1 = Integer.parseInt(newStr[0]);
			int temp2 = Integer.parseInt(newStr[1]);
			int temp3 = Integer.parseInt(newStr[2]);
			
			if(!(temp1<a||temp1==a)) {
				a=temp1;
				b=temp2;
				c=temp3;
				if(!(temp2<b||temp2==b)) {
					b=temp2;
					c=temp3;
					if(!(temp3<c||temp3==c)) {
						c=temp3;
					}
				}
			}
			System.out.println(a+","+b+","+c);
		}
		System.out.println("\n"+a+"."+b+"."+c);
		
	}

}
