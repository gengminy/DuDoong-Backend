package band.gosrock.infrastructure.outer.api.client;


import band.gosrock.infrastructure.outer.api.dto.OauthAccessTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "KakaoAuthClient", url = "https://kauth.kakao.com")
public interface KakaoOauthClient {

    @PostMapping(
            "/oauth/token?grant_type=authorization_code&client_id={CLIENT_ID}&redirect_uri={REDIRECT_URI}&code={CODE}&client_secret={CLIENT_SECRET}")
    OauthAccessTokenResponse kakaoAuth(
            @PathVariable("CLIENT_ID") String clientId,
            @PathVariable("REDIRECT_URI") String redirectUri,
            @PathVariable("CODE") String code,
            @PathVariable("CLIENT_SECRET") String client_secret);

    //    @Cacheable(cacheNames = "KakaoOICD", cacheManager = "oidcCacheManager")
    //    @GetMapping("/.well-known/jwks.json")
    //    OIDCPublicKeysResponse getKakaoOIDCOpenKeys();
}
