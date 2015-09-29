package org.moserp.common.rest;

import android.util.Base64;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

class BasicAuthorizationInterceptor implements ClientHttpRequestInterceptor {

    private final String username;

    private final String password;

    public BasicAuthorizationInterceptor(String username, String password) {
        this.username = username;
        this.password = (password == null ? "" : password);
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        byte[] token = Base64.encode((this.username + ":" + this.password).getBytes(), Base64.DEFAULT);
        request.getHeaders().add("Authorization", "Basic " + new String(token));
        return execution.execute(request, body);
    }

}
