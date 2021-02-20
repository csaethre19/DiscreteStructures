package project1;



public class Multiset {
	public int[] elements;
	public int[] multiplicities;
	/**
	 * @param bitString
	 * @param multiplicities
	 */
	public Multiset(int[] elements, int[] multiplicities) {
		this.elements = elements;
		this.multiplicities = multiplicities;
	}
	@Override
	public String toString() {
		String s = "{" + multiplicities[0] +"*"+elements[0];		
		for(int i = 1; i < elements.length; i++) {
			s = s + "," + multiplicities[i] +"*"+elements[i];
		}
		s += "}";
		
		return s;
	}
	
	
}
