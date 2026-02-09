package com.thrive;

import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.server.application.*;
import io.ktor.server.response.ApplicationResponseFunctionsKt;
import io.ktor.server.routing.RoutingKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public class Routing {

    public static void configureRouting(Application app) {
        RoutingKt.routing(app, routing -> {
            RoutingKt.get(routing, "/hello", route -> {
                ApplicationResponseFunctionsKt.respondText(
                    route,
                    "Hello World!",
                    ContentType.Text.Plain.INSTANCE,
                    HttpStatusCode.Companion.getOK(),
                    (Continuation<? super Unit>) null
                );
                return Unit.INSTANCE;
            });
            return Unit.INSTANCE;
        });
    }
}
