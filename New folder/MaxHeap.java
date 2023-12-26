public class Solution {
    
    static int sz;
    
    static int left(int k) {
        return 2*k + 1;
    }
    
    static int right(int k) {
        return 2*k + 2;
    }
    
    static int parent(int k) {
        return (k-1)/2;
    }
    
    static void heapify(int []heap,int id,int n) {
        int l = left(id);
        int r = right(id);
        int smallest = id;
        if (l < n && heap[l] < heap[id]) {
            smallest = l;
        }
        if (r < n && heap[r] < heap[smallest]) {
            smallest = r;
        }
        if (smallest != id) {
            int tempp = heap[id];
            heap[id] = heap[smallest];
            heap[smallest] = tempp;
            heapify(heap, smallest, n);
        }
    }
    
    static void insert(int val,int[] heap) {
        heap[sz] = val;
        int i = sz;
        sz += 1;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            int tmp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = tmp;
            i = parent(i);
        }
    }
    
    static int extractMin(int []heap) {
        if(sz == 1) {
            sz -= 1;
            return heap[0];
        }
        int val = heap[0];
        heap[0] = heap[sz-1];
        sz -= 1;
        heapify(heap,0,sz);
        return val;
    }
    
    

    // minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        // Write your code here.
        int size = 0;
        int cnt = 0;
        int heap[] = new int[n];
        for(int i=0;i<n;i++) {
            if(q[i][0] == 1) {
                cnt += 1;
            }
        }
        int index = 0;
        int ans[] = new int[cnt];
        for(int i=0;i<n;i++) {
            if(q[i][0] == 1) {
                sz = size;
                ans[index++] = extractMin(heap);
                size = sz;
            }
            else {
                sz = size;
                insert(q[i][1],heap);
                size = sz;
            }
        }
        return ans;
    }
}