package com.example.demowebsocketpushmessages.config;

import com.sun.security.auth.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

public class UserHandShakeHandler extends DefaultHandshakeHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(UserHandShakeHandler.class);

    @Override
    protected Principal determineUser(ServerHttpRequest serverHttpRequest,
                                      WebSocketHandler webSocketHandler,
                                      Map<String, Object> stringObjectMap
    ) {
//        return super.determineUser(request, wsHandler, attributes);
        String randomId = UUID.randomUUID().toString();
        LOGGER.info("user with id '{}' opened the page", randomId);
        return new UserPrincipal(randomId);
    }
}
