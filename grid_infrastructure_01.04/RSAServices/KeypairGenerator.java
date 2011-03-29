/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RSAServices;

import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


/**
 *
 * @author admin
 */
@WebService()
public class KeypairGenerator {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GenerateKeypair")
    public ArrayList<Long> GenerateKeypair(@WebParam(name = "p")
    long p, @WebParam(name = "q")
    long q) {
        
            long n;
            long phi;
            long e;
            long d;
            n = p * q;
            phi = (p - 1) * (q - 1);
            do{
                e = coprime(n);
                d = modularMultiplicativeInverse(e,phi);
            } while (d==e);
            ArrayList<Long> result=new ArrayList<Long>();
            result.add(n);
            result.add(e);
            result.add(d);

            return result;
    }
    private long modularMultiplicativeInverse(long a,long mod)
    {
        for(long i=0; i<mod; i++)
            if(i*a%mod==1)
                return i;
        return a;
    }
    private long greatestCommonDivisor(long x, long y)
    {
        if(y==0)
            return x;
        return greatestCommonDivisor(y,x%y);
    }
    private long coprime(long x)
    {
        long max=x;
        long base=(long)(Math.random()*max);
        long y;
        for(long i=0;i<max;i++)
        {
            y=base+i;
            if (greatestCommonDivisor(x, y) == 1)
                if(y<max)
                    return y;
            y=base-i;
            if(greatestCommonDivisor(x, y) == 1)
                if(y>1)
                    return y;
        }
        return 1;
    }
}
