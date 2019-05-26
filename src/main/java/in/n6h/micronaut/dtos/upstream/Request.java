package in.n6h.micronaut.dtos.upstream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static in.n6h.micronaut.constants.Constants.Messages.PASSWORD_ENCODE;
import static in.n6h.micronaut.utils.JSONUtils.OBJECT_MAPPER;
import static in.n6h.micronaut.utils.JSONUtils.SDF;

/**
 * Created by Karanbir Singh on 5/25/2019.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request<T> {

    @JsonProperty(value = "co-relation-id")
    private String coRelationID;

    // the path of the request
    private String path;

    // the body of the request
    //@NotNull(message = "The request body object should be present")
    @Valid
    @JsonProperty("data")
    @JsonIgnoreProperties({"password"})
    private JsonNode data = JsonNodeFactory.instance.objectNode();

    // the http method of the request
    private String method;

    // the header(s) in the request
    private String[] headers;

    // the parameter(s) in the request
    private Map<String, List<String>> params;

    private String timestamp;

    private Long uuidTimestamp;

    // HTTP Status
    @JsonIgnore
    private HttpStatus status = HttpStatus.OK;

    @JsonIgnore
    private int code = HttpStatus.OK.getCode();

    @JsonIgnore
    private HttpRequest httpRequest;

    public String getCoRelationID() {
        return coRelationID;
    }

    public Request(){
        Calendar currentCalendar = Calendar.getInstance();
        long timeInMilliSecs = currentCalendar.getTimeInMillis();
        this.timestamp = SDF.format(currentCalendar.getTime());
        UUID uuid = UUID.randomUUID();
        this.coRelationID = uuid.toString();
        this.uuidTimestamp = timeInMilliSecs;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // this will give linked hash map, and is very painful
    public JsonNode getData() {
        if(this.data.has("password")){
            ObjectNode node = (ObjectNode) data;
            node.put("password", PASSWORD_ENCODE);
            this.data = node;
        }
        return this.data;
    }

    public T getData(Class c) throws IOException {
        return this.getData(c, OBJECT_MAPPER);
    }

    private T getData(Class c, ObjectMapper objectMapper) throws IOException {
        // objectMapper.readValue(new JSONObject((Map)data).toString(), c);
        // (new JSONObject((Map)data).toString()
        return (T)objectMapper.treeToValue(this.data, c);
    }

    public void setData(JsonNode data) throws IOException {
        /*String jsonString = new JSONObject((Map)data).toString();
        this.data = (T)OBJECT_MAPPER.readValue(jsonString, data.getClass());*/
        this.data = data;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public Map<String, List<String>> getParams() {
        return params;
    }

    public void setParams(Map<String, List<String>> params) {
        this.params = params;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Long getUuidTimestamp() {
        return uuidTimestamp;
    }

    public void setCoRelationID(String coRelationID) {
        this.coRelationID = coRelationID;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setUuidTimestamp(Long uuidTimestamp) {
        this.uuidTimestamp = uuidTimestamp;
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
        this.path = httpRequest.getPath();
        this.method = httpRequest.getMethod().name();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}