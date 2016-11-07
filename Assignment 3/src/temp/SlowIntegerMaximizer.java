package temp;

public class SlowIntegerMaximizer implements Maximizer<Integer>{

	@Override
	public Integer getMax(Integer t1, Integer t2) {
		  if(t1.compareTo(t2) > 0){
			  return t1;
		  } else {
			  return t2;
		  }
	}

	@Override
	public Integer getGlobalMin() {
		return Integer.MIN_VALUE;
	}

}
