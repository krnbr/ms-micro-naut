package in.n6h.micronaut.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Singleton;

import static in.n6h.micronaut.utils.JSONUtils.BCRYPT_PASSWORD_ENCODER;

/**
 * Created by Karanbir Singh on 5/25/2019.
 **/
@Singleton
public class BcryptPasswordEncoderService implements PasswordEncoder {

    private BCryptPasswordEncoder bCryptPasswordEncoder = BCRYPT_PASSWORD_ENCODER;

    @Override
    public String encode(CharSequence rawPassword) {
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }

}