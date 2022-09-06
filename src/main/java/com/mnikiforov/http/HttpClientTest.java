package com.mnikiforov.http;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.util.TimeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(HttpClientTest.class);

    public static void main(String[] args) {
        withoutRetries();
        LOG.info("--------------------------------------------------------------------");
        withRetries();
    }

    private static void withRetries() {
        try (CloseableHttpClient httpClient = withRetryClient()) {
            HttpGet get = new HttpGet("http://aaaaaaaaa");

            CloseableHttpResponse resp = httpClient.execute(get);
            System.out.println(resp);
        } catch (IOException e) {
            LOG.error("+WITH RETRY ALARM!!! {}", e.getMessage());
        }
    }

    private static void withoutRetries() {
        try (CloseableHttpClient httpClient = withoutRetryClient()) {
            HttpGet get = new HttpGet("http://aaaaaaaaaa");

            CloseableHttpResponse resp = httpClient.execute(get);
            System.out.println(resp);
        } catch (IOException e) {
            LOG.error("-WITHOUT RETRY ALARM!!! {}", e.getMessage());
        }
    }

    private static CloseableHttpClient withRetryClient() {
        // default is this(1, TimeValue.ofSeconds(1L)); in HttpClientBuilder
        DefaultHttpRequestRetryStrategy retryStrategy = new DefaultHttpRequestRetryStrategy(20, TimeValue.ofSeconds(1L));

        // hack
        try {
            Field nonRetriableIOExceptionClasses = retryStrategy.getClass().getDeclaredField("nonRetriableIOExceptionClasses");
            nonRetriableIOExceptionClasses.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);

            nonRetriableIOExceptionClasses.set(retryStrategy, new HashSet<IOException>());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            LOG.error("HACK ALAAAAARM!!!");
        }

        return HttpClients.custom()
                .setRetryStrategy(retryStrategy)
                .build();
    }

    private static CloseableHttpClient withoutRetryClient() {
        return HttpClients.custom()
                .disableAutomaticRetries()
                .build();
    }

}
