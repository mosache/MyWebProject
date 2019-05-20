package com.yd.web.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yd.web.beans.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "yd.config")
public class TokenUtils {

    private String USER_ID = "USER_ID";

    private String secret;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;

    }

    private JWTVerifier verifier;

    private JWTVerifier getVerifier(){
        if (this.verifier == null){
            Algorithm algorithm = Algorithm.HMAC256(secret);
            this.verifier = JWT.require(algorithm).withIssuer("web").build();
        }
        return this.verifier;
    }

    /**
     * 生成Token
     * */
    public String createToken(Integer userId){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        Map<String ,Object> map = new HashMap<>();
        map.put(USER_ID,userId);
        String token = JWT.create().withIssuer("web").withHeader(map).sign(algorithm);
        return token;
    }

    public boolean isValidToken(String token, User user){
        try {
            getVerifier().verify(token);
        }catch (JWTVerificationException e){
            return false;
        }

        try{
            DecodedJWT jwt = JWT.decode(token);
            Claim userIdClaim = jwt.getClaim(USER_ID);
            if (userIdClaim.isNull()){
                return false;
            }else {
                if (user != null){
                    String userID = userIdClaim.asString();
                    if (user.getId().equals(userID)){
                        return false;
                    }                }

            }
        }catch (JWTDecodeException e){
            return false;
        }
        return false;
    }

}
