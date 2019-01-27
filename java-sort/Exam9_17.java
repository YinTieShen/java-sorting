package _160300531chapter9;

import java.util.Random;

public class Exam9_17 {
	
	//直接插入排序
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
	
	//希尔排序
	public static void shellSort(int[] a, int[] d, int numOfD){
		int i, j, k, m, span;
		int temp;
		int n = a.length;

		for(m = 0; m < numOfD; m ++){				//共numOfD次循环
			span = d[m]; 							//取本次的增量值
			for(k = 0; k < span; k ++){				//共span个小组
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
	
	//直接选择排序
	public static void selectSort2(int a[]){
		int i,j,small;
		int temp;
		int n = a.length;
		
		for(i = 0; i < n-1; i++){
			small = i;
			for(j = i+1; j < n; j++){				//寻找最小的数据元素
				if(a[j] < a[small]) small = j; 		//记住最小元素的下标
			}
			
			if(small != i){
				temp = a[small];
				for(j = small; j > i; j--) 			//把该区段尚未排序元素依次后移
					a[j] = a[j-1];
				a[i] = temp;						//插入找出的最小元素
			}
		}
	}
	
	//堆排序
	public static void createHeap(int[] a, int n, int h){
		int i, j, flag;
		int temp;
		
		i = h; 		        					// i为要建堆的二叉树根结点下标
		j = 2 * i + 1; 						// j为i结点的左孩子结点的下标
		temp = a[i];
		flag = 0;

		//沿左右孩子中值较大者重复向下筛选
		while(j < n && flag != 1){
			//寻找左右孩子结点中的较大者,j为其下标
			if(j < n - 1 && a[j] < a[j + 1]) j++;

			if (temp > a[j]) 					//a[i]>a[j]
				flag = 1; 					//标记结束筛选条件
			else{							//否则把a[j]上移
				a[i] = a[j];
				i = j;
				j = 2 * i + 1;
			}	
		}
		a[i] = temp; 							//把最初的a[i]赋予最后的a[j]
	}
		
		public static void initCreateHeap(int[] a){
			int n = a.length;
			for(int i = (n - 1) / 2; i >= 0; i --)
				createHeap(a, n, i);
		}
		
	public static void heapSort(int[] a){
		int temp;
		int n = a.length;
			
		initCreateHeap(a); 				//初始化创建最大堆
			
		for(int i = n - 1; i > 0; i --){	//当前最大堆个数每次递减1
			//把堆顶a[0]元素和当前最大堆的最后一个元素交换
			temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			createHeap(a,i, 0); 			//调整根结点满足最大堆
		}
	}
		
	//冒泡排序
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
	
	//快速排序
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
	
	//二路归并排序
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
		
	
	//基数排序
	public static void radixSort(int[] a, int m, int d) throws Exception{
		// a为要排序的数据元素，d为进制的基数，m为数据元素的最大位数
			int n = a.length;
			int i, j, k, l, power = 1;
			LinQueue[] myQueue = new LinQueue[d];
					
			//创建链式队列数组对象
			for(i = 0; i < d; i++){
				LinQueue temp = new LinQueue();
				myQueue[i] = temp;
			}
				
			//进行m次排序
			for(i = 0; i < m; i++){
				if(i == 0) power = 1;
				else power = power * d;
				
				//依次将n个数据元素按第k位的大小放到相应的队列中
				for(j = 0; j < n; j++){
					k = a[j] / power - (a[j] / (power * d)) * d;	//计算k值
					myQueue[k].append(new Integer(a[j]));			// a[j]入队列k
				}

				//顺序回收各队列中的数据元素到数组a中
				l = 0;
				for(j = 0; j < d; j++){
					while(myQueue[j].notEmpty()){
						a[l] = ((Integer)myQueue[j].delete()).intValue();
						l++;
					}
				}
			}
		}

	//测试
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
		System.out.println("直接插入排序运行的时间是："+(endTime - startTime)+"毫秒" );
		
		long startTime1 = System.currentTimeMillis();	
		int d[] = {4,2,1};
		shellSort(arr1, d, 3);
		long endTime1 = System.currentTimeMillis();
		System.out.println("希尔排序运行的时间是："+(endTime1 - startTime1)+"毫秒" );
		
		long startTime2 = System.currentTimeMillis();
		selectSort2(arr2);
		long endTime2 = System.currentTimeMillis();
		System.out.println("直接选择排序运行的时间是："+(endTime2 - startTime2)+"毫秒" );
		
		long startTime3 = System.currentTimeMillis();
		heapSort(arr3);
		long endTime3 = System.currentTimeMillis();
		System.out.println("堆排序运行的时间是："+(endTime3 - startTime3)+"毫秒" );
		
		long startTime4 = System.currentTimeMillis();
		bubbleSort(arr4);
		long endTime4 = System.currentTimeMillis();
		System.out.println("冒泡排序运行的时间是："+(endTime4 - startTime4)+"毫秒" );
		
		long startTime5 = System.currentTimeMillis();
		quickSort(arr5, 0,arr.length-1 );
		long endTime5 = System.currentTimeMillis();
		System.out.println("快速排序运行的时间是："+(endTime5 - startTime5)+"毫秒" );
		
		long startTime6 = System.currentTimeMillis();
		mergeSort(arr6);
		long endTime6 = System.currentTimeMillis();
		System.out.println("二路归并排序运行的时间是："+(endTime6 - startTime6)+"毫秒" );
		
		long startTime7 = System.currentTimeMillis();
		radixSort(arr7, 5, 10);
		long endTime7 = System.currentTimeMillis();
		System.out.println("基数排序运行的时间是："+(endTime7 - startTime7)+"毫秒" );

		
	}
}
