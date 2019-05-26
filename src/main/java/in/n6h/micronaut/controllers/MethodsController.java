package in.n6h.micronaut.controllers;

import in.n6h.micronaut.dtos.upstream.Request;
import in.n6h.micronaut.dtos.upstream.Response;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Calendar;

import static in.n6h.micronaut.constants.WebConstants.BASE_PATH_URI;
import static in.n6h.micronaut.utils.WebUtils.getMessage;
import static in.n6h.micronaut.utils.WebUtils.handleRequestObject;

/**
 * Created by Karanbir Singh on 5/25/2019.
 **/
@Controller(value = BASE_PATH_URI)
public class MethodsController {

    private final Logger logger = LoggerFactory.getLogger(MethodsController.class);

    @Get("get")
    public Response get(@QueryValue(defaultValue = "Hello World") String message, HttpRequest httpRequest){
        logger.info("Started for get");
        long start = Calendar.getInstance().getTimeInMillis();
        MDC.put("getStart", start+"");
        Request request = handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        MDC.put("getEnd", Calendar.getInstance().getTimeInMillis()+"");
        MDC.put("getTotal", Calendar.getInstance().getTimeInMillis()-start+"");
        logger.info("Ended for get");
        return response;
    }

    @Post("post")
    public Response post(@QueryValue(defaultValue = "Hello World") String message, @Body Request request, HttpRequest httpRequest){
        handleRequestObject(request, httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

    @Put("put")
    public Response put(@QueryValue(defaultValue = "Hello World") String message, @Body Request request, HttpRequest httpRequest){
        handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

    @Delete("delete")
    public Response delete(@QueryValue(defaultValue = "Hello World") String message, HttpRequest httpRequest){
        Request request = handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

    @Patch("patch")
    public Response patch(@QueryValue(defaultValue = "Hello World") String message, HttpRequest httpRequest){
        Request request = handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

    @Trace("trace")
    public Response trace(@QueryValue(defaultValue = "Hello World") String message, HttpRequest httpRequest){
        Request request = handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

    @Head("head")
    public Response head(HttpRequest httpRequest){
        Request request = handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(getMessage(null));
        return response;
    }

    @Options("options")
    public Response options(@QueryValue String message, HttpRequest httpRequest){
        Request request = handleRequestObject(httpRequest);
        Response response = new Response(request);
        response.setData(message);
        return response;
    }

}