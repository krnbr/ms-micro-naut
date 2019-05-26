package in.n6h.micronaut.utils;

import in.n6h.micronaut.dtos.upstream.Request;
import io.micronaut.http.HttpRequest;

/**
 * Created by Karanbir Singh on 5/25/2019.
 **/
public class WebUtils {

    public static void handleRequestObject(Request request,
                                           HttpRequest httpRequest){
        if(request == null){
            request = new Request();
        }
        request.setHttpRequest(httpRequest);
        request.setParams(httpRequest.getParameters().asMap());
    }

    public static Request handleRequestObject(HttpRequest httpRequest){
        Request request = new Request();
        request.setHttpRequest(httpRequest);
        request.setParams(httpRequest.getParameters().asMap());
        return request;
    }

    public static String getMessage(String message){
        return message!=null ? message.trim().length() != 0 ? message : "Hello World" : "Hello World";
    }

}
