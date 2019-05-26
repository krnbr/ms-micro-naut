package in.n6h.micronaut.dtos.upstream;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Karanbir Singh on 5/25/2019.
 **/
public class Test {

    private String test;
    private int id;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}