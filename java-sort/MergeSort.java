package _160300531chapter9;
public class MergeSort{
public static void merge(int[] a, int[] swap, int k){
	int n = a.length;
	int m = 0, u1,l2,i,j,u2;
	int l1 = 0;								//第一个有序子数组下界为0
	while(l1 + k <= n-1){
		l2 = l1 + k; 							//计算第二个有序子数组下界
		u1 = l2 - 1; 							//计算第一个有序子数组上界
		u2 = (l2+k-1 <= n-1)? l2+k-1: n-1;		//计算第二个有序子数组上界

		for(i = l1, j = l2; i <= u1 && j <= u2; m ++){
			if(a[i] <= a[j]){
				swap[m] = a[i];
				i ++;
			}
			else{
				swap[m] = a[j];
				j++;
			}
		}

		//子数组2已归并完，将子数组1中剩余的元素存放到数组swap中
		while(i <= u1){
			swap[m] = a[i];
			m ++;
			i ++;
		}

		//子数组1已归并完，将子数组2中剩余的元素存放到数组swap中
		while(j <= u2){
			swap[m] = a[j];
			m ++;
			j ++;
		}

		l1 = u2 + 1;
	}

	//将原始数组中只够一组的数据元素顺序存放到数组swap中
	for(i = l1; i < n; i ++, m ++) 
		swap[m] = a[i];
	
	for(int z=0;z<a.length;z++) {
		System.out.print(a[z]+" ");
	}
	System.out.println();
}
	
public static void mergeSort(int[] a){
	int i;
	int n = a.length;
	int k = 1; 									//归并长度从1开始	
	int[] swap = new int[n];		

	while(k < n){
		merge(a, swap, k); 						//调用函数merge()

		for(i = 0; i < n; i++) 
			a[i] = swap[i]; 			//将元素从临时数组swap放回数组a中

		k = 2 * k; 								//归并长度加倍
	}
}
	
	public static void main(String[] args){
		int[] test = {72, 73, 71, 23, 94, 16, 5, 68, 46};;
		int n = test.length;
		
		mergeSort(test);
		for(int i = 0; i < n; i++)
			System.out.print(test[i] + "  ");
	}	
}