package com.jeanneeetjean.jej.controller.api;

import com.jeanneeetjean.jej.dto.auth.AuthenticationRequest;
import com.jeanneeetjean.jej.dto.auth.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.jeanneeetjean.jej.utils.Constants.AUTHENTICATION_ENDPOINT;

public interface AuthenticationApi {

    @PostMapping(AUTHENTICATION_ENDPOINT + "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);
}
