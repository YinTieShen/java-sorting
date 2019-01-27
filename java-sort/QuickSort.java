package _160300531chapter9;
public class QuickSort{
public static void quickSort(int[] a, int low, int high){
	int i, j;
	int temp;

	i = low;
	j = high;
	temp = a[low]; 					//取第一个元素为标准数据元素

	while(i < j){
	//在数组的右端扫描
		while(i < j && temp <= a[j]) j--;
		if(i < j){
			a[i] = a[j];
			i++;
		}

	//在数组的左端扫描
		while(i < j && a[i] < temp) i++;
		if(i < j){
			a[j] = a[i];
			j--;
		}
	}
	a[i] = temp;
	
	if(low < i) quickSort(a, low, i-1); 			//对左端子集合递归
	if(i < high) quickSort(a, j+1, high); 		//对右端子集合递归
}
	
	public static void main(String[] args){
		int[] test = {60,55,48,37,10,90,84,36};
		int n = 8;
		
		quickSort(test, 0, 7);
		for(int i = 0; i < n; i++)
			System.out.print(test[i] + "  ");
	}
}