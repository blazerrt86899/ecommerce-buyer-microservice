package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.config.JwtTokenUtil;
import com.ecommerce.model.ApiResponse;
import com.ecommerce.model.AuthToken;
import com.ecommerce.model.Buyer;
import com.ecommerce.model.User;
import com.ecommerce.service.BuyerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody User user) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        final Buyer authenticateBuyer = buyerService.findOne(user.getUsername());
        final String token = jwtTokenUtil.generateToken(authenticateBuyer);
        return new ApiResponse<>(200, "success",new AuthToken(token, user.getUsername(),authenticateBuyer.getBuyerId()));
    }

}
