public class BooleanSets {

    public static Boolean[] Union(Boolean[] set1, Boolean[] set2){
    // perform a union operation on set1 and 2 and return the output
    	Boolean[] union = new Boolean[set1.length];
    	
    	for (int i = 0; i < union.length; i++) {
			if(set1[i] == true || set2[i] == true) { union[i] = true;}
			else {union[i] = false;}
		}
        return union;
    }

    public static Boolean[] Intersection(Boolean[] set1, Boolean[] set2){
        // perform a Intersection operation on set1 and 2 and return the output
    	Boolean[] intersection = new Boolean[set1.length];
    	
    	for (int i = 0; i < intersection.length; i++) {
			if(set1[i] == true && set2[i] == true) { intersection[i] = true;}
			else {intersection[i] = false;}
		}
        return intersection;
    }
    public static Boolean[] Complement(Boolean[] set){
        //return the complement of the input set
    	Boolean[] complement = new Boolean[set.length];

    	for (int i = 0; i < set.length; i++) {
			complement[i] = !set[i];
		}
        return complement;
    }
  
    public static Boolean[] Subtract(Boolean[] set1, Boolean[] set2){
        // perform a subtraction operation on set1 and 2 and return the output
    	Boolean[] subtract = new Boolean[set1.length];
    	
    	for (int i = 0; i < subtract.length; i++) {
			if(set1[i] == true && set2[i] == true) { subtract[i] = false;}
			else {subtract[i] = set1[i];}
			
		}
        return subtract;
    }
    public static Boolean[] Xor(Boolean[] set1, Boolean[] set2){
        // perform a Xor operation on set1 and 2 and return the output
    	Boolean[] Xor = new Boolean[set1.length];
    	
    	for (int i = 0; i < Xor.length; i++) {
			if(set1[i] == !set2[i]) { Xor[i] = true;}
			else {Xor[i] = false;}
		}
        return Xor;
    }

}
