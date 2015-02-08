public class Recursion{

    public static String name(){
	return "Zheng,Andy";
    }

    public static int fact(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	if (n==0){
	    return 1;
	}
	return n * fact(n-1);
    }

    public static int fib(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	if (n == 0){
	    return 0;
	}else {
	    if (n==1){
		return 1;
	    }
	}
	return fib(n-1) + fib(n-2);
    }

    public static double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	return sqrth(n, 1);
    }

    public static double sqrth(double n, double guess){
	if (Math.abs((n/guess+guess)/2 - guess) < .00001){
	    return guess;
	}
	return sqrth(n, ((n/guess+guess)/2));
    }

    public static void main(String[] args){
	System.out.println(fib(5));
	System.out.println(fib(10));
	System.out.println(fact(4));
	System.out.println(sqrt(169));
    }
}
