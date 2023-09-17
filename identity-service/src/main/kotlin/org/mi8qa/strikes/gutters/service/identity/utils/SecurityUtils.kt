//package org.mi8qa.strikes.gutters.service.identity.utils
//
//import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//import org.springframework.stereotype.Service
//import java.util.*
//import javax.crypto.spec.SecretKeySpec
//import javax.xml.bind.DatatypeConverter
//import io.jsonwebtoken.Jwts
//import io.jsonwebtoken.SignatureAlgorithm
//import jakarta.xml.bind.DatatypeConverter
//import java.security.Key
//
//@Service
//class SecurityUtils {
//    private val secretKey = "yourSecretKey"
//    private val passwordEncoder = BCryptPasswordEncoder()
//
//    fun generateToken(username: String): String {
//        val signatureAlgorithm = SignatureAlgorithm.HS256
//        val nowMillis = System.currentTimeMillis()
//        val now = Date(nowMillis)
//
//        val apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey)
//        val signingKey = SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.jcaName)
//
//        return Jwts.builder()
//            .setIssuedAt(now)
//            .setSubject(username)
//            .signWith(signingKey, signatureAlgorithm)
//            .compact()
//    }
//
//    fun validateToken(token: String, username: String): Boolean {
//        val claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey)).parseClaimsJws(token).body
//        return claims.subject == username && !isTokenExpired(claims.expiration)
//    }
//
//    private fun isTokenExpired(expiration: Date): Boolean = expiration.before(Date())
//}
