/**merge two arrays that are already sorted**/
package alreadySortedMerge;

public class AlreadySortedMerge {

	public static void main(String[] args) {
		int[] nums1 = {1,3};
		int[] nums2 = {2,6,22};
		int[] merged = new int[nums1.length + nums2.length];
		int c1 = 0;
		int c2 = 0;
		
		for(int i = 0; i < merged.length; i++){
			if(c1 < nums1.length && c2 < nums2.length){
				if(nums1[c1] <= nums2[c2]){
					merged[i] = nums1[c1];
					c1++;
				} else if (nums1[c1] > nums2[c2]){
					merged[i] = nums2[c2];
					c2++;
				}
			} else if(c1 == nums1.length){ //if c1 is used up to capacity and c2 isnt, fill the remaining slots in the final merged array
				merged[i] = nums2[c2];
				c2++;
			} else if (c2 == nums2.length){
				merged[i] = nums1[c1];
				c1++;
			}
		}
		
		for(int i = 0; i < merged.length; i++) System.out.printf("[%d] ", merged[i]);
	}

}
