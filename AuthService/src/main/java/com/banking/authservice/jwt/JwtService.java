package com.banking.authservice.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.banking.authservice.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	private String secretKey = null;

	public String generateToken(User user) {
		Map<String, Object> claims=new HashMap<>();
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(user.getUserName())
				.issuer("DCB")
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 60*10*1000))
				.and()
				.signWith(generateKey())
				.compact();
	}

	public String getSecretKey() {
		return secretKey = "02fc18bbd1ef1e9f88cb51a29e2f7e8f12e7609e41ecc2c7eb76912237800909aa08f59d0be07ed0c6969ae331f86fa9bb14b5b1f4993565dfc3ed78f8471f1a";
	}
	
	private SecretKey generateKey() {
		byte[] decode=Decoders.BASE64.decode(getSecretKey());
		return Keys.hmacShaKeyFor(decode);
	}
	//important 
	public String extractUserName(String token) {
		return extractClaim(token,Claims::getSubject);
	}
	
	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		Claims claim=extractClaim(token);
		return claimResolver.apply(claim);
	}
	
	private Claims extractClaim(String token) {
		return Jwts
				.parser()
				.verifyWith(generateKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String userName=extractUserName(token);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
}
