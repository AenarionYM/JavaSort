import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        int[] numbersToSort = new int[10];

        //Random
        Random random = new Random();
        for (int i = 0; i < numbersToSort.length; i++)
        {
            numbersToSort[i] = random.nextInt(0, 101);
        }

        //Print array
        for (int number: numbersToSort){
            System.out.print(number + ", ");
        }
        System.out.println("");

        HeapSort(numbersToSort);
        //BubbleSort(numbersToSort);

        //Print array
        for (int number: numbersToSort){
            System.out.print(number + ", ");
        }
    }

    public static void BubbleSort(int[] arrayToSort)
    {
        for (int j = 0; j < arrayToSort.length-1; j++)
        {
            for (int i = 0; i < arrayToSort.length - (1 + j);i ++)
            {
                int temp;
                if (arrayToSort[i] > arrayToSort[i+1]){
                    temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i+1];
                    arrayToSort[i+1] = temp;
                }
            }
        }
    }

    public static void HeapSort(int[] arrayToSort)
    {
        for (int i = arrayToSort.length/ 2 - 1; i >= 0; i--){
            heapify(arrayToSort,arrayToSort.length,i);
        }

        for (int i = arrayToSort.length - 1; i > 0; i--){
            int temp = arrayToSort[0];
            arrayToSort[0] = arrayToSort[i];
            arrayToSort[i] = temp;

            heapify(arrayToSort, i, 0);
        }
    }

    private static void heapify(int arr[], int arrayLenght, int i)
    {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if (left < arrayLenght && arr[left]> arr[largest]){
            largest = left;
        }

        if (right < arrayLenght && arr[right]> arr[largest]){
            largest = right;
        }

        if (largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, arrayLenght, largest);
        }

    }

}