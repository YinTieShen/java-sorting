package _160300531chapter9;

import java.util.Random;

public class Exam9_17 {
	
	//ֱ�Ӳ�������
	public static void insertSort(int[] a){
		int i, j, temp;
		int n = a.length;
		
		for(i = 0; i < n - 1; i ++){
		temp = a[i + 1];
		j = i;
		while(j > -1 && temp <= a[j]){
			a[j + 1] = a[j];
			j --;
		}
		a[j + 1] = temp;
		}
	}
	
	//ϣ������
	public static void shellSort(int[] a, int[] d, int numOfD){
		int i, j, k, m, span;
		int temp;
		int n = a.length;

		for(m = 0; m < numOfD; m ++){				//��numOfD��ѭ��
			span = d[m]; 							//ȡ���ε�����ֵ
			for(k = 0; k < span; k ++){				//��span��С��
				for(i = k; i < n-span; i = i + span){
					temp = a[i+span];
					j = i;
					while(j > -1 && temp <= a[j]){
						a[j + span] = a[j];
						j = j - span;
					}
					a[j + span] = temp;
				}
			}
		}
	}
	
	//ֱ��ѡ������
	public static void selectSort2(int a[]){
		int i,j,small;
		int temp;
		int n = a.length;
		
		for(i = 0; i < n-1; i++){
			small = i;
			for(j = i+1; j < n; j++){				//Ѱ����С������Ԫ��
				if(a[j] < a[small]) small = j; 		//��ס��СԪ�ص��±�
			}
			
			if(small != i){
				temp = a[small];
				for(j = small; j > i; j--) 			//�Ѹ�������δ����Ԫ�����κ���
					a[j] = a[j-1];
				a[i] = temp;						//�����ҳ�����СԪ��
			}
		}
	}
	
	//������
	public static void createHeap(int[] a, int n, int h){
		int i, j, flag;
		int temp;
		
		i = h; 		        					// iΪҪ���ѵĶ�����������±�
		j = 2 * i + 1; 						// jΪi�������ӽ����±�
		temp = a[i];
		flag = 0;

		//�����Һ�����ֵ�ϴ����ظ�����ɸѡ
		while(j < n && flag != 1){
			//Ѱ�����Һ��ӽ���еĽϴ���,jΪ���±�
			if(j < n - 1 && a[j] < a[j + 1]) j++;

			if (temp > a[j]) 					//a[i]>a[j]
				flag = 1; 					//��ǽ���ɸѡ����
			else{							//�����a[j]����
				a[i] = a[j];
				i = j;
				j = 2 * i + 1;
			}	
		}
		a[i] = temp; 							//�������a[i]��������a[j]
	}
		
		public static void initCreateHeap(int[] a){
			int n = a.length;
			for(int i = (n - 1) / 2; i >= 0; i --)
				createHeap(a, n, i);
		}
		
	public static void heapSort(int[] a){
		int temp;
		int n = a.length;
			
		initCreateHeap(a); 				//��ʼ����������
			
		for(int i = n - 1; i > 0; i --){	//��ǰ���Ѹ���ÿ�εݼ�1
			//�ѶѶ�a[0]Ԫ�غ͵�ǰ���ѵ����һ��Ԫ�ؽ���
			temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			createHeap(a,i, 0); 			//�����������������
		}
	}
		
	//ð������
	public static void bubbleSort(int[] a){
		int i, j, flag=1;
		int temp;
		int n = a.length;

		for(i = 1; i < n && flag == 1; i++){
			flag = 0;
			for(j = 0; j < n-i; j++){
				if(a[j] > a[j+1]){
					flag = 1;
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	//��������
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
	
	//��·�鲢����
	public static void merge(int[] a, int[] swap, int k){
		int n = a.length;
		int m = 0, u1,l2,i,j,u2;
		int l1 = 0;								//��һ�������������½�Ϊ0
		while(l1 + k <= n-1){
			l2 = l1 + k; 							//����ڶ��������������½�
			u1 = l2 - 1; 							//�����һ�������������Ͻ�
			u2 = (l2+k-1 <= n-1)? l2+k-1: n-1;		//����ڶ��������������Ͻ�

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

			//������2�ѹ鲢�꣬��������1��ʣ���Ԫ�ش�ŵ�����swap��
			while(i <= u1){
				swap[m] = a[i];
				m ++;
				i ++;
			}

			//������1�ѹ鲢�꣬��������2��ʣ���Ԫ�ش�ŵ�����swap��
			while(j <= u2){
				swap[m] = a[j];
				m ++;
				j ++;
			}

			l1 = u2 + 1;
		}

		//��ԭʼ������ֻ��һ�������Ԫ��˳���ŵ�����swap��
		for(i = l1; i < n; i ++, m ++) 
			swap[m] = a[i];
	}
		
	public static void mergeSort(int[] a){
		int i;
		int n = a.length;
		int k = 1; 									//�鲢���ȴ�1��ʼ	
		int[] swap = new int[n];		

		while(k < n){
			merge(a, swap, k); 						//���ú���merge()

			for(i = 0; i < n; i++) 
				a[i] = swap[i]; 			//��Ԫ�ش���ʱ����swap�Ż�����a��

			k = 2 * k; 								//�鲢���ȼӱ�
		}
	}
		
	
	//��������
	public static void radixSort(int[] a, int m, int d) throws Exception{
		// aΪҪ���������Ԫ�أ�dΪ���ƵĻ�����mΪ����Ԫ�ص����λ��
			int n = a.length;
			int i, j, k, l, power = 1;
			LinQueue[] myQueue = new LinQueue[d];
					
			//������ʽ�����������
			for(i = 0; i < d; i++){
				LinQueue temp = new LinQueue();
				myQueue[i] = temp;
			}
				
			//����m������
			for(i = 0; i < m; i++){
				if(i == 0) power = 1;
				else power = power * d;
				
				//���ν�n������Ԫ�ذ���kλ�Ĵ�С�ŵ���Ӧ�Ķ�����
				for(j = 0; j < n; j++){
					k = a[j] / power - (a[j] / (power * d)) * d;	//����kֵ
					myQueue[k].append(new Integer(a[j]));			// a[j]�����k
				}

				//˳����ո������е�����Ԫ�ص�����a��
				l = 0;
				for(j = 0; j < d; j++){
					while(myQueue[j].notEmpty()){
						a[l] = ((Integer)myQueue[j].delete()).intValue();
						l++;
					}
				}
			}
		}

	//����
	public static void main(String[] args) throws Exception {
		int arr[] = new int[100000];
		int arr1[] = new int[100000];
		int arr2[] = new int[100000];
		int arr3[] = new int[100000];
		int arr4[] = new int[100000];
		int arr5[] = new int[100000];
		int arr6[] = new int[100000];
		int arr7[] = new int[100000];
		
		for (int i = 0; i < arr.length; i++) {
			
			arr[i] = (int)(Math.random()*100000);
			arr1[i] = (int)(Math.random()*100000);
			arr2[i] = (int)(Math.random()*100000);
			arr3[i] = (int)(Math.random()*100000);		
			arr4[i] = (int)(Math.random()*100000);
			arr5[i] = (int)(Math.random()*100000);
			arr6[i] = (int)(Math.random()*100000);		
			arr7[i] = (int)(Math.random()*100000);
		}
		
		long startTime = System.currentTimeMillis();
		insertSort(arr);
		long endTime = System.currentTimeMillis();
		System.out.println("ֱ�Ӳ����������е�ʱ���ǣ�"+(endTime - startTime)+"����" );
		
		long startTime1 = System.currentTimeMillis();	
		int d[] = {4,2,1};
		shellSort(arr1, d, 3);
		long endTime1 = System.currentTimeMillis();
		System.out.println("ϣ���������е�ʱ���ǣ�"+(endTime1 - startTime1)+"����" );
		
		long startTime2 = System.currentTimeMillis();
		selectSort2(arr2);
		long endTime2 = System.currentTimeMillis();
		System.out.println("ֱ��ѡ���������е�ʱ���ǣ�"+(endTime2 - startTime2)+"����" );
		
		long startTime3 = System.currentTimeMillis();
		heapSort(arr3);
		long endTime3 = System.currentTimeMillis();
		System.out.println("���������е�ʱ���ǣ�"+(endTime3 - startTime3)+"����" );
		
		long startTime4 = System.currentTimeMillis();
		bubbleSort(arr4);
		long endTime4 = System.currentTimeMillis();
		System.out.println("ð���������е�ʱ���ǣ�"+(endTime4 - startTime4)+"����" );
		
		long startTime5 = System.currentTimeMillis();
		quickSort(arr5, 0,arr.length-1 );
		long endTime5 = System.currentTimeMillis();
		System.out.println("�����������е�ʱ���ǣ�"+(endTime5 - startTime5)+"����" );
		
		long startTime6 = System.currentTimeMillis();
		mergeSort(arr6);
		long endTime6 = System.currentTimeMillis();
		System.out.println("��·�鲢�������е�ʱ���ǣ�"+(endTime6 - startTime6)+"����" );
		
		long startTime7 = System.currentTimeMillis();
		radixSort(arr7, 5, 10);
		long endTime7 = System.currentTimeMillis();
		System.out.println("�����������е�ʱ���ǣ�"+(endTime7 - startTime7)+"����" );

		
	}
}
