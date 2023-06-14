package com.example.apigateway.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*")
public class ContaController {

    @RequestMapping(method = RequestMethod.GET, value = "/detail/{id}")
    public Map<String, Object> getContaDetail(
            @PathVariable("id") Long id,
            Authentication authentication,
            @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient auth2AuthorizedClient) {

        Map<String, Object> response = new HashMap<>();
        response.put("principalAuthorities", authentication.getAuthorities());
        response.put("id_account", id);
        response.put("auth2AuthorizedClient", auth2AuthorizedClient);
        response.put("clientName", auth2AuthorizedClient.getClientRegistration().getClientName());
        response.put("accessToken", auth2AuthorizedClient.getAccessToken());
        response.put("authentication", authentication);
        return response;
    }
}
