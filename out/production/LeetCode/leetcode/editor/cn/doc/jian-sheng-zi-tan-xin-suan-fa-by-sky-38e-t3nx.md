 public int cuttingRope(int n) {
		
		 if (n<2) {
			 return 0;
			
		}
		 if (n==2) {
			 return 1;
			
		}
		 if (n==3) {
			 return 2;
			
		}
		int a=n/3;
		int b=n%3;
		
		/**
		 * n 除 3 的结果为 a，余数是 b
	如果 b 为 0，直接将 a 个 3 相乘
	如果 b 为 1，将（a-1）个 3 相乘，再乘以 2*2相当于*4
	如果 b 为 2，将 a 个 3 相乘，再乘以 2
		 * 
		 * */
		if (b==0) {
			return (int) Math.pow(3, a);}
			if (b==1) {
				return (int) (Math.pow(3, a - 1) * 4);
			}		 
return (int) (Math.pow(3, a) * 2);
	    }
