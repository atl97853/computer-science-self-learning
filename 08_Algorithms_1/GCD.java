/** 
* Compute the greatest common divisor of two nonnegative integers p and q. 
* If q is 0, the answer is p. If not, divide p by q and  take the 
* remainder r. The answer is the greatest common divisor of q and r. 
*
* 56s + 15t = gcd(56, 15) 
* 4 = 3(1) + (1), 1 is the greatest common divisor. 
*
* epubcfi(/6/14!/4/26,/9:495,/9:589)
* Reference: Loc. 22 of 1401 
*/

public class GCD {
  public static int gcd(int p, int q) {
    if (q == 0) return p;
    int r = p % q;
    System.out.println(r);
    return gcd(q, r);
  }
  public static void main(String[] args) {
    System.out.println("gcd is: " + gcd(56, 15));
  }
} 
