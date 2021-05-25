package sort;
import java.lang.Math;
import java.util.Arrays;
import java.lang.reflect.Method;
public class Solution {
    final static int list_size = 20000;
    public static void main (String[] args) {
        int[] ini_list = new int[list_size];
        int[] test_list = null;
        long start_time = 0, end_time = 0;
        for (int i = 0; i < list_size; ++i)
        {
            ini_list[i] = (int)(Math.random() * 100);
        }

        test_list = Arrays.copyOf(ini_list, list_size);
        start_time = System.currentTimeMillis();
        sort.insertionSort(test_list, 0, test_list.length - 1);
        end_time = System.currentTimeMillis();
        System.out.println("Insertion Sort , size is :" +list_size + "  time is : " + (end_time - start_time));

        test_list = Arrays.copyOf(ini_list, list_size);
        start_time = System.currentTimeMillis();
        sort.mergeSort(test_list, 0, test_list.length - 1);
        end_time = System.currentTimeMillis();
        System.out.println("Merge Sort , size is :" +list_size + "  time is : " + (end_time - start_time));

        test_list = Arrays.copyOf(ini_list, list_size);
        start_time = System.currentTimeMillis();
        sort.bubbleSort(test_list, 0, test_list.length - 1);
        end_time = System.currentTimeMillis();
        System.out.println("Bubble Sort , size is :" +list_size + "  time is : " + (end_time - start_time));

        test_list = Arrays.copyOf(ini_list, list_size);
        start_time = System.currentTimeMillis();
        sort.optimizeBubbleSort(test_list, 0, test_list.length - 1);
        end_time = System.currentTimeMillis();
        System.out.println("Optimized Bubble Sort , size is :" +list_size + "  time is : " + (end_time - start_time));

        test_list = Arrays.copyOf(ini_list, list_size);
        start_time = System.currentTimeMillis();
        sort.selectSort(test_list, 0, test_list.length - 1);
        end_time = System.currentTimeMillis();
        System.out.println("Select Sort , size is :" +list_size + "  time is : " + (end_time - start_time));

        test_list = Arrays.copyOf(ini_list, list_size);
        start_time = System.currentTimeMillis();
        sort.quickSort(test_list, 0, test_list.length - 1);
        end_time = System.currentTimeMillis();
        System.out.println("Quick Sort , size is :" +list_size + "  time is : " + (end_time - start_time));

        test_list = Arrays.copyOf(ini_list, list_size);
        start_time = System.currentTimeMillis();
        Arrays.sort(test_list);
        end_time = System.currentTimeMillis();
        System.out.println("Standard Sort , size is :" +list_size + "  time is : " + (end_time - start_time));
    }
}
class sort {
    // pseudocode: insertionSort(A, start, end)
    // for i = start to end do
    //     key = A[i]
    //     j = i - 1
    //     while j > start - 1 and A[j] > key do
    //         A[j + 1] = A[j]
    //         j = j - 1
    //     end while
    //     A[j + 1] = key
    // end for
    public static void insertionSort (int[] list, int start, int end) {
        int key = 0, i = start, j= start;

        for (i = start; i <= end; ++i)
        {
            key = list[i];
            j = i - 1;
            while (j > start - 1 && list[j] > key)
            {
                list[j + 1] = list[j];
                --j;
            }

            list[j + 1] = key;
        }
    }
    
    // pseudocode: mergeSort(A, start, end)
    // if (start == end)
    //     return;
    // mid = ⌊(start + end) / 2⌋
    // mergeSort(A, start, mid)
    // mergeSort(A, mid + 1, end)
    // merge(A, start, end, mid)

    // pseudocode: merge(A, start, end, mid)
    // L = A[left, mid]
    // R = A[mid + 1, right]
    // Maintain two pointers pl pr, initialized to point to the
    // first elements of L, R, respectively
    // while both lists are non empty do
    //     Let x, y be the elements pointed to by pl, pr
    //     Compare x, y and append the smaller to the ouput
    //     Advance the pointer in the list with the smaller of x, y
    // end while
    // Append the reaminder of the non-empty list to the output.

    static void mergeSort (int[] list, int start, int end) {
        if (start == end) 
        {
            return ;
        }
        
        int mid = (start + end) / 2;
        mergeSort(list, start, mid);
        mergeSort(list, mid + 1, end);
        merge(list, start, end, mid);
    }
    static void merge(int[] list, int start, int end, int mid) {
        int[] result_list = new int[end - start + 1];
        int pl = start, pr = mid + 1;
        int index = 0;
        
        while (pl <= mid && pr <= end)
        {
            if (list[pl] < list[pr])
            {
                result_list[index++] = list[pl++];
            }
            else
            {
                result_list[index++] = list[pr++];
            }
        }

        if (pl > mid)
        {
            while (pr <= end)
            {
                result_list[index++] = list[pr++];
            }
        }
        else
        {
            while (pl <= mid)
            {
                result_list[index++] = list[pl++];
            }
        }

        for (int i = 0; i < index; ++i)
        {
            list[start + i] = result_list[i];
        }
    }

    // pseudocode: bubbleSort(A, start, end)
    // for i = start to end  do
    //     for j = end downto i + 1 do
    //         if A[j] < A[j - 1] do
    //             swap(A[j], A[j - 1])
    //         end if
    //     end for
    // end for
    static void bubbleSort(int[] list, int start, int end)
    {
        int temp = 0;

        for (int i = start; i < end; ++i)
        {
            for (int j = end; j > i; --j)
            {
                if (list[j] < list[j - 1])
                {
                    temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp; 
                }
            }
        }
    }

    // pseudocode: optimizeBubbleSort(A, start, end)
    // bool change_sig = false
    // for i = start to end  do
    //     change_sig = false
    //     for j = end downto i + 1 do
    //         if A[j] < A[j - 1] do
    //             swap(A[j], A[j - 1])
    //             change_sig = true
    //         end if
    //     end for
    //     if true == change_sig do
    //         break
    //     end if
    // end for
    static void optimizeBubbleSort(int[] list, int start, int end)
    {
        int temp = 0;
        boolean change_signal = false;

        for (int i = start; i < end; ++i)
        {
            change_signal = false;
            for (int j = end; j > i; --j)
            {
                if (list[j] < list[j - 1])
                {
                    temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp; 
                    change_signal = true;
                }
            }

            if (false == change_signal)
            {
                break;
            }
        }
    }

    // pseudocode: selectSort(A, start, end0)
    // for i = start to end -1 do
    //     for j = i + 1 to end do
    //         if A[i] > A[j] do
    //             swap(A[i], A[j])
    //         end if
    //     end for
    // end for
    static void selectSort(int[] list, int start, int end)
    {
        int temp = 0;

        for (int i = start; i < end; ++i)
        {
            for (int j = i + 1; j <= end; ++j)
            {
                if (list[i] > list[j])
                {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    // pseudocode: quickSort(A, start, end)
    // key = A[start]
    // i = start
    // j = end
    // if start >= end do
    // 	return 
    // end if
    // while i < j do
    // 	while i < j and A[j] >= key do
    // 		j--
    // 	end while
    // 	swap(A[i], A[j])
    // 	while i < j and A[i] < key do 
    // 		i++
    // 	end while
    // 	swap(A[i], A[j])
    // end while
    // 	A[i] = key
    // quickSort(A, start, i - 1)
    // quickSort(A, i + 1, end)
    static void quickSort(int[] list, int start, int end)
    {
        int key = list[start], i = start, j = end, temp = 0;

        if (start >= end)
        {
            return;
        }

        while (i < j)
        {
            while ( i < j && list[j] >= key)
            {
                j--;
            }
            temp = list[i];
            list[i] = list[j];
            list[j] = temp;

            while ( i < j && list[i] < key)
            {
                i++;
            }
            temp = list[i];
            list[i] = list[j];
            list[j] = temp;
        }

        list[i] = key;

        quickSort(list, start, i - 1);
        quickSort(list, i + 1, end);
    }

    static void printList (int[] list) {
        for (int i = 0; i < list.length; ++i) 
        {
            System.out.print(list[i] + " ");
        }
        System.out.println(" ");
    }
}