public class Sorts{

    public static int[] merge(int[] a, int[] b) {
	int[] c = new int[a.length + b.length];
	int aIndex = 0;
	int bIndex = 0;
	int cIndex = 0;
	while (aIndex < a.length && bIndex < b.length) {
	    if (a[aIndex] > b[bIndex]) {
		c[cIndex] = b[bIndex];
		bIndex++;
	    } else {
		c[cIndex] = a[aIndex];
		aIndex++;
	    }
	    cIndex++;
	}
	while (aIndex < a.length) {
	    c[cIndex] = a[aIndex];
	    aIndex++;
	    cIndex++;
	}
	while (bIndex < b.length) {
	    c[cIndex] = b[bIndex];
	    bIndex++;
	    cIndex++;
	}
	return c;
    }

    public static int[] sort(int[] a) {
	if (a.length <= 1) {
	    return a;
	}

	int length = a.length;
	
	int[] b = new int[length / 2];
	int[] c = new int[length - a.length / 2];
	int cIndex = 0;

        for (int aIndex = 0; aIndex < length; aIndex++) {
	    if (aIndex < length / 2) {
		b[aIndex] = a[aIndex];
	    } else {
		c[cIndex] = a[aIndex];
		cIndex++;
	    }
	}

	b = sort(b);
	c = sort(c);

	return merge(b, c);
    }

    public static void mergesort(int[] m){
	int[] msorted = new int[m.length];
	msorted = sort(m);
	for (int i = 0; i< m.length; i ++){
	    m[i] = msorted[i];
	}
    }

    public static void main(String[] args) {
	int[] d = {10, 5, 1, 3, 6, 2, 4, 7, 8, 9};
        mergesort(d);
	for (int i = 0; i<d.length; i++){
	    System.out.print(d[i]);
	    System.out.print(" ");
	}
    }    
}
