package com.example.urshopmiddleware.security.token;

import com.example.urshopmiddleware.model.User;
import com.example.urshopmiddleware.security.SecurityUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;

@Component
public class JwtTokenService implements TokenService {

    private static final String CLAIMS_USER = "user";
    private final JwtProperties jwtProperties;
    private final JwtEncoder jwtEncoder;
    private final JwsHeader jwsHeader;
    private final ObjectMapper objectMapper;

    public JwtTokenService(
            final JwtProperties jwtProperties,
            final JwtEncoder jwtEncoder,
            final ObjectMapper objectMapper) {
        this.jwtProperties = jwtProperties;
        this.jwtEncoder = jwtEncoder;
        jwsHeader = JwsHeader.with(jwtProperties::getAlgorithm).build();
        this.objectMapper = objectMapper;
    }

    @Override
    public String createToken(final SecurityUser securityUser) {
        final var claims = createClaims(securityUser);
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).getTokenValue();
    }

    private JwtClaimsSet createClaims(final SecurityUser securityUser) {
        final var now = Instant.now();
        final var expiresAt = now.plus(jwtProperties.getExpiration());
        return JwtClaimsSet.builder()
                .issuer(jwtProperties.getIssuer())
                .issuedAt(now)
                .expiresAt(expiresAt)
                .subject(securityUser.toString())
                .claim(CLAIMS_USER, securityUser)
                .build();
    }

    @Override
    public User getUser(final Object source) {
        final var claims = ((Jwt) source).getClaims();
        final var userClaims = (Map<String, Object>) claims.get(CLAIMS_USER);

        User user = null;
        if (userClaims != null) {
            user = User.builder()
                    .id((Integer) userClaims.get("id"))
                    .name((String) userClaims.get("name"))
                    .email((String) userClaims.get("email"))
                    .password((String) userClaims.get("password"))
                    .creationDate((String) userClaims.get("creationDate"))
                    .authority((String) userClaims.get("authority"))
                    .build();
        }

        return user;
    }

}
