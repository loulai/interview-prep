package temp;

public class FastIntegerMaximizer implements Maximizer<Integer> {

		  @Override
		  public Integer getMax(Integer t1, Integer t2) {
			  /* returns the bigger value, or one of them if they are equal */
			  if(t1.compareTo(t2) > 0)
				  return t1;
			  else
				  return t2;
		  }
		  
		  public static boolean isLargerOrEqualTo(Integer topOfSourceStack, Integer topOfMaxStack){
			  boolean isLargerOrEqualTo = false;
			  if(topOfSourceStack.compareTo(topOfMaxStack) >= 0)
				  isLargerOrEqualTo = true;
			  
			  return isLargerOrEqualTo;
		  }

		  @Override
		  public Integer getGlobalMin() {
			  return Integer.MIN_VALUE;
		  }
		  

}
