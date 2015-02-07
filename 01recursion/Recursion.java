public class Recursion{

    public String name(){
	return "Zheng,Andy";
    }

    public int fact(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	if (n==0){
	    return 1;
	}
	return n * fact(n-1);
    }

    public int fib(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	if (n == 1){
	    return 0;
	}
	if (n == 2){
	    return 1;
	}
	return fib(n-1)+fib(n-2);
    }

    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	return sqrth(n, 1);
    }

    public double sqrth(doule n, double guess){
	if ((n/guess+guess)/2 - guess < .00001){
	    return guess;
	}
	return sqrth(n, ((n/guess+guess)/2));
    }
}
