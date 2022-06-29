//package cn.louiswu.util;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//
//
//@Component
//public class JwtUtil {
//
//    @Resource
//    RedisUtils redisUtils;
//
//    static final String SECRET = "I have a pen ,I have a apple. en -- Apple Pen";
//
//    public static String generateToken(String username) {
//        HashMap<String, Object> map = new HashMap<>();
//        //you can put any data in the map
//        map.put("username", username);
//        String jwt = Jwts.builder()
//                .setClaims(map)
//                .setExpiration(new Date(System.currentTimeMillis() + 3600_000_000L))// 1000 hour
//                .signWith(SignatureAlgorithm.HS512, SECRET)
//                .compact();
//        return "Bearer "+jwt; //jwt前面一般都会加Bearer
//    }
//
//    public static Map<String, Object> validateToken(String token) {
//        try {
//            // parse the token.
//            Map<String, Object> body = Jwts.parser()
//                    .setSigningKey(SECRET)
//                    .parseClaimsJws(token.replace("Bearer ",""))
//                    .getBody();
//            return body;
//        }catch (Exception e){
//            throw new IllegalStateException("Invalid Token. "+e.getMessage());
//        }
//    }
//
//    public String getToken(User user) {
//        String token="";
//        token= JWT.create().withAudience(user.getUserId().toString())
//                .sign(Algorithm.HMAC256(user.getUserPwd()));
//        redisUtils.set("token",token,7200L);
//        return redisUtils.get("token").toString();
//    }
//}
