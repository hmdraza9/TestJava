package javaConcepts;

public class GCCallFinalize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GCCallFinalize nc = new GCCallFinalize();
		System.out.println("nc.hashCode: "+nc.hashCode());
		System.out.println("nc.hashCode: "+nc);
		System.out.println("nc.hashCode: "+nc.toString());
		nc = null;
		System.gc();
	}
	public void finalize() {
		System.out.println("Finalze called!");
	}
	
	public int hashCode() {
		return 100;
	}

}


class newClass{
	
	public void announceMethod(String str) {
		System.out.println("Announcement: "+str);
	}
}