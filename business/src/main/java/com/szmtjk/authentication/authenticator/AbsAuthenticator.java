package com.szmtjk.authentication.authenticator;

import javax.annotation.PostConstruct;

public abstract class AbsAuthenticator implements Authenticator {

    @PostConstruct
    protected void init() {
        AuthenticateChainFactory.addAuthenticator(this);
    }
}
