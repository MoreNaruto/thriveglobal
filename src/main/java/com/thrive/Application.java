package com.thrive;

import io.ktor.server.application.*;
import io.ktor.server.engine.ApplicationEngine;
import io.ktor.server.engine.ApplicationEngineKt;
import io.ktor.server.netty.Netty;

public class Application {

    public static void main(String[] args) {
        ApplicationEngine server = ApplicationEngineKt.embeddedServer(
            Netty.INSTANCE,
            8080,
            Application::module
        );
        server.start(true);
    }

    public static void module(io.ktor.server.application.Application app) {
        Routing.configureRouting(app);
    }
}
