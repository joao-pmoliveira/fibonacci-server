package org.dellent.app;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LabseqService {

    private Map<Long, BigInteger> syncMemo = Collections.synchronizedMap(new HashMap<Long, BigInteger>());

    public BigInteger calculate(Long n) {
        BigInteger nBig = BigInteger.valueOf(n);
        if (nBig == BigInteger.ZERO || nBig == BigInteger.TWO)
            return BigInteger.ZERO;
        else if (nBig == BigInteger.ONE || nBig == BigInteger.valueOf(3))
            return BigInteger.ONE;

        if (syncMemo.containsKey(n))
            return syncMemo.get(n);

        for (Long i = 4l; i <= (long) n; i++) {
            BigInteger result = calculate(i - 4).add(calculate(i - 3));
            syncMemo.put(i, result);
        }

        return syncMemo.get(n);
    }
}
