package _160300531chapter9;
public class QuickSort{
public static void quickSort(int[] a, int low, int high){
	int i, j;
	int temp;

	i = low;
	j = high;
	temp = a[low]; 					//ȡ��һ��Ԫ��Ϊ��׼����Ԫ��

	while(i < j){
	//��������Ҷ�ɨ��
		while(i < j && temp <= a[j]) j--;
		if(i < j){
			a[i] = a[j];
			i++;
		}

	//����������ɨ��
		while(i < j && a[i] < temp) i++;
		if(i < j){
			a[j] = a[i];
			j--;
		}
	}
	a[i] = temp;
	
	if(low < i) quickSort(a, low, i-1); 			//������Ӽ��ϵݹ�
	if(i < high) quickSort(a, j+1, high); 		//���Ҷ��Ӽ��ϵݹ�
}
	
	public static void main(String[] args){
		int[] test = {60,55,48,37,10,90,84,36};
		int n = 8;
		
		quickSort(test, 0, 7);
		for(int i = 0; i < n; i++)
			System.out.print(test[i] + "  ");
	}
}