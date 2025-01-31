package com.dancing_orangutan.ukkikki.global.security;

import com.dancing_orangutan.ukkikki.entity.member.Member;
import com.dancing_orangutan.ukkikki.global.oauth.ProviderUserMapper;
import com.dancing_orangutan.ukkikki.global.oauth.ProviderUserMapperFactory;
import com.dancing_orangutan.ukkikki.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauth2User = new DefaultOAuth2UserService().loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        ProviderUserMapper mapper = ProviderUserMapperFactory.getMapper(registrationId);
        Map<String, Object> attributes = mapper.mapAttributes(oauth2User);

        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");
        String profileImageUrl = (String) attributes.get("profileImageUrl");

        // 회원이 존재하지 않으면 새로 저장
        Member member = memberRepository.findByEmail(email)
                .orElseGet(() -> memberRepository.save(
                        Member.builder()
                                .email(email)
                                .name(name)
                                .password("")
                                .profileImageUrl(profileImageUrl)
                                .provider(registrationId)
                                .build()
                ));

        return new OAuth2UserDetails(member);
    }

}
