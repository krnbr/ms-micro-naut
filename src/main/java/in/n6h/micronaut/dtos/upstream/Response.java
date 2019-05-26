package in.n6h.micronaut.dtos.upstream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static in.n6h.micronaut.utils.JSONUtils.OBJECT_MAPPER;
import static in.n6h.micronaut.utils.JSONUtils.SDF;

/**
 * Created by Karanbir Singh on 5/25/2019.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    @JsonProperty(value = "co-relation-id")
    private String coRelationID;

    // the body of the request
    private JsonNode data;

    // the header(s) in the request
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String[] headers;

    private String timestamp;

    private Long uuidTimestamp;

    @JsonIgnore
    private HttpRequest httpRequest;

    @JsonIgnore
    private HttpResponse httpResponse;

    @JsonIgnoreProperties({"password"})
    private Request request;

    private HttpStatus status = HttpStatus.OK;

    private int code = HttpStatus.OK.getCode();

    @JsonProperty(value = "errors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ErrorDto> errorDtos = new ArrayList<>();

    public String getCoRelationID() {
        return coRelationID;
    }

    public Response(){
        super();
    }

    public Response(JsonNode data){
        super();
        this.data = data;
    }

    public Response(Object data){
        super();
        ObjectMapper objectMapper = new ObjectMapper();
        this.data = objectMapper.valueToTree(data);
    }

    public Response(Request request){
        super();
        this.request = request;
        Calendar currentCalendar = Calendar.getInstance();
        this.timestamp = SDF.format(currentCalendar.getTime());
        this.coRelationID = this.request.getCoRelationID();
        this.uuidTimestamp = this.request.getUuidTimestamp();
    }

    public Object getData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        if(this.data != null) {
            Object data = objectMapper.treeToValue(this.data, Object.class);
            return data;
        }else {
            return null;
        }
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public void setData(Object object) {
        ObjectMapper objectMapper = OBJECT_MAPPER;
        JsonNode data = objectMapper.convertValue(object, JsonNode.class);
        this.data = data;
    }

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
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
    }

    public Request getRequest() {
        return request;
    }

    public void setHttpResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public void setRequest(Request request) {
        this.request = request;
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

    public List<ErrorDto> getErrorDtos() {
        return errorDtos;
    }

    public void setErrorDtos(List<ErrorDto> errorDtos) {
        this.errorDtos = errorDtos;
    }
}
