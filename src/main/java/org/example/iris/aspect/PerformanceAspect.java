package org.example.iris.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

@Aspect
@Component
public class PerformanceAspect {
    private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);
    private final AtomicLong totalCalls = new AtomicLong(0);
    private final AtomicLong totalTime = new AtomicLong(0);
    private final AtomicLong errorCount = new AtomicLong(0);

    @Around("execution(* org.example.iris.service..*(..))")
    public Object monitorMethods(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().toShortString();
        long startTime = System.nanoTime();

        logger.info("[AOP-LOG] Başladı: {}", methodName);

        try {
            Object result = joinPoint.proceed();

            long elapsedTime = System.nanoTime() - startTime;

            totalCalls.incrementAndGet();
            totalTime.addAndGet(elapsedTime);

            logger.info("[AOP-LOG] Başarılı: {}", methodName);
            logger.info("[AOP-PERFORMANCE] Süre: {} ms",
                    elapsedTime / 1_000_000.0);

            return result;

        } catch (Throwable error) {

            long elapsedTime = System.nanoTime() - startTime;

            errorCount.incrementAndGet();
            totalCalls.incrementAndGet();
            totalTime.addAndGet(elapsedTime);

            logger.error("[AOP-ERROR] {} hata verdi", methodName, error);

            throw error;

        }
    }

    public void printPerformanceReport() {

        logger.info("===== AOP PERFORMANS RAPORU =====");
        logger.info("Toplam metot çağrısı: {}", totalCalls.get());
        logger.info("Toplam çalışma süresi: {} ms",
                totalTime.get() / 1_000_000.0);
        logger.info("Toplam hata sayısı: {}", errorCount.get());

        if (totalCalls.get() > 0) {
            logger.info("Ortalama süre: {} ms",
                    (totalTime.get() / totalCalls.get()) / 1_000_000.0);
        }

        logger.info("=================================");
    }
}