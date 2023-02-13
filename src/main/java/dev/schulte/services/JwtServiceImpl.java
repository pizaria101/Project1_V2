package dev.schulte.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService{

    private Algorithm algorithm = Algorithm.HMAC256("super secret string");

    @Override
    public String createJwtWithUsernameAndRole(String username, String role) {
        return JWT.create().withClaim("username",username).withClaim("role",role).sign(algorithm);
    }

    @Override
    public boolean validateJwt(String jwt) {
        JWTVerifier verifier = JWT.require(algorithm).build();

        try{
            verifier.verify(jwt);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
