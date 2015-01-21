package leetcode;
import java.util.*;


public class Solution {
	public static int[] twoSum(int[] numbers,int target ){
		Map<Integer,Integer> mmap= new HashMap<Integer,Integer>();
		int[] result = {-1,-1};
		for(int i=0;i<numbers.length;i++){
			if(mmap.containsKey(numbers[i])){
				result[0] = mmap.get(numbers[i]);
				result[1] = i + 1;
			}
			else{
				mmap.put(target - numbers[i], i+1);		
			}
		}
		return result;
	}
	
	
	
	public static int search(int[] A,int target){
		if(A.length == 0){
			return -1;
		}
		
		int low = 0;
		int high = A.length - 1;
		
		while(low < high){
			int mid = (low + high) >> 1;
			if(A[mid] < A[high]){
				if(A[mid] < target  && A[high] >= target){
					low = mid + 1;
				} else{
					high = mid -1;
				}
			} else{
                if (A[mid] > target && A[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
			}	
		}
		return -1;
	}
	
	
	public static void testString(String s){
		for(int i=0;i<5;i++){
			System.out.print(s.charAt(i));
		}
	}
	
	
	public static boolean isdigit(char c){
		return c>='0' && c<='9';
	} 
	
	
	public static int[] singleNumber(int[] A){
		Map<Integer,Integer> mmap = new HashMap<Integer,Integer>();
		for(int i=0;i<A.length;i++){
			if (mmap.containsKey(A[i])){
				mmap.remove(A[i]);
			}else{
				mmap.put(A[i], 0);
			}
		}
		int i=0;
		int res[] = new int[mmap.size()];
		for(int key:mmap.keySet()){
			res[i++] = key;
		}		
		return res;
	}
	
	
	public static int singleNumber_ox(int[] A){
		if( A == null || A.length == 0){
			return 0;
		}
		int result = A[0];
		for(int i=1;i<A.length;i++){
			result = result ^ A[i];
		}
		System.out.print(result);
		return result;
	}
	
	
	public int threeSumClosest(int[] num, int target){
		int res = 0;
		Arrays.sort(num);
		int min = Integer.MAX_VALUE;
		for(int i=0;i<num.length-2;i++){
			int left = i + 1;
			int right = num.length - 1;
			while(left < right){
				int sum = num[i] + num[left] + num[right];
				int dis = target - sum ;
				if (Math.abs(dis) < Math.abs(res)){
					res = dis;
				}
				if(dis == 0){
					return target;
				}else if(dis < 0){
					right -= 1;
				}else{
					left += 1;
				}
			}
		}
		return target-res;
	}
	
	
	public static void main(String [] args){
		int[] A = {1,2,3,4,5,1,3,4,5,6,7};
		int[] B = singleNumber(A);
		for(int i=0;i<B.length;i++){
			System.out.print(B[i]);
		}
	}
}

