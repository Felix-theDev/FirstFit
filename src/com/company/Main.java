package com.company;
/** This program implements a First Fit
 * memory allocation scheme, where memory is allocated to task on a basis of first come
 * first serve. As long as it fits into the computer memory
 * @author Felix Ogbonnaya
 * @since 2020-03-03
 */
public class Main {
    public static void FirstFit(int[] blockSize, int[] jobSize, int m, int n) {

        int[] allocation = new int[m];

        //Initialize values of block to be null
        for (int i = 0; i < allocation.length; i++) {
            allocation[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= jobSize[i] && allocation[j] == -1) {
                    // allocate block j to p[i] job
                    allocation[j] = i;

                    System.out.println("Job " + (i + 1) + " allocated to " + "Memory block " + (j + 1));
                    break;
                }
            }

        }

        System.out.println("\nBlock No " + "\t" + "Block Size " + "\t" + "Status " + "\t" + "Job Size " + "\t\t" + "Job No");
        for (int i = 0; i < n; i++) {
            System.out.print("\n" + (i + 1) + "\t\t\t" + blockSize[i] + "\t\t\t");
            if (allocation[i] != -1) {
                int jobIndex = allocation[i];
                System.out.print("Busy " + "\t" + (jobSize[jobIndex]) + "\t\t\t\t" + (jobIndex + 1));
            } else {
                System.out.print("Free " + "\t" + "Not Allocated" + "\t" + "Nil");
            }
        }

    }

    public static void main(String[] args) {
        int[] blockSize = {100, 500, 200, 300, 320, 800, 250, 400};
        int[] jobSize = {212, 417, 112, 426, 750, 100, 150};
        //n = size of the job
        //m = memory size
        int m = blockSize.length; //8
        int n = jobSize.length; //7
        FirstFit(blockSize, jobSize, m, n);
    }
}
