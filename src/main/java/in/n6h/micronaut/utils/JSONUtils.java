package in.n6h.micronaut.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;

/**
 * Created by Karanbir Singh on 5/25/2019.
 **/
public class JSONUtils {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MMM-dd|HH:mm:ss");

    public static final BCryptPasswordEncoder BCRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();

}