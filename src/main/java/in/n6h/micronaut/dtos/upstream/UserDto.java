package in.n6h.micronaut.dtos.upstream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static in.n6h.micronaut.constants.Constants.Messages.PASSWORD_ENCODE;
import static in.n6h.micronaut.utils.JSONUtils.BCRYPT_PASSWORD_ENCODER;

/**
 * Created by Karanbir Singh on 1/27/2019.
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserDto extends AbstractDto<Long>{

    private String username;

    /**
     * Ignoring it so that it is not returned in response but only available to be part of request wherever applicable
     * Allowed only while writing
     */
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnore
    private String password;

    private String roleName;

    private String roleId;

    @JsonIgnore
    private String encodedPassword;

    private boolean checkPasswordHistory;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String getPassword() {
        return PASSWORD_ENCODE;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
        if(password!=null) {
            this.encodedPassword = BCRYPT_PASSWORD_ENCODER.encode(password);
        }
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public boolean passwordMatches(){
        return BCRYPT_PASSWORD_ENCODER.matches(this.password, this.encodedPassword);
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public boolean isCheckPasswordHistory() {
        return checkPasswordHistory;
    }

    public void setCheckPasswordHistory(boolean checkPasswordHistory) {
        this.checkPasswordHistory = checkPasswordHistory;
    }
}