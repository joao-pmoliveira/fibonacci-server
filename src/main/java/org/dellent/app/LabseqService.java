package org.dellent.app;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LabseqService {

    private Map<Long, BigInteger> syncMemo = Collections.synchronizedMap(new HashMap<Long, BigInteger>());

    @CacheResult(cacheName = "labseq-cache")
    public BigInteger getSequenceResult(Long n) {

        if (n < 0)
            throw new IllegalArgumentException("Negative indexes are not allowed");

        return calculate(n);
    }

    private BigInteger calculate(Long n) {
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
