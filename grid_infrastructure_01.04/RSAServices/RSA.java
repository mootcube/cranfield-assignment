/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RSAServices;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author admin
 */
@WebService()
public class RSA {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "encrypt")
    public long process( @WebParam(name = "message")
    long message,@WebParam(name = "keyN") long
    n, @WebParam(name = "keyK") long k) {
        long result=message;
        for(int i=1;i<k;i++)
        {
            result = message * result;
            result = result % n;
        }
        return result;
    }
}
