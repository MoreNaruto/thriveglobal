package com.thrive;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.HttpStatusCode;
import io.ktor.server.testing.ApplicationTestBuilder;
import io.ktor.server.testing.ApplicationTestBuilderKt;
import kotlin.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {

    @Test
    public void testRoot() {
        ApplicationTestBuilderKt.testApplication(testBuilder -> {
            testBuilder.application(app -> {
                Application.module(app);
                return Unit.INSTANCE;
            });

            HttpResponse response = HttpRequestKt.get(
                testBuilder.getClient(),
                "/hello",
                (HttpRequestBuilder) null
            );
            assertEquals(HttpStatusCode.Companion.getOK(), response.getStatus());
            return Unit.INSTANCE;
        });
    }
}
