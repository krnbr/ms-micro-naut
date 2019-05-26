package in.n6h.micronaut.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.n6h.micronaut.dtos.upstream.Request;
import in.n6h.micronaut.dtos.upstream.Response;
import in.n6h.micronaut.dtos.upstream.UserDto;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import java.io.IOException;

import static in.n6h.micronaut.constants.WebConstants.BASE_PATH_URI;
import static in.n6h.micronaut.constants.WebConstants.USER_URI;

@Controller(value = BASE_PATH_URI)
public class UserController {

    /*@Inject
    UserService userService;*/

    @Inject
    ObjectMapper objectMapper;

    @Post(value = USER_URI)
    public Response createUser(@Body Request<UserDto> request, HttpRequest httpRequest) throws IOException {
        handleRequestObject(request, httpRequest);

        //UserDto userDto = userService.saveUser(request.getData(UserDto.class));
        Response response = new Response(request);
        //response.setData(userDto);
        return response;
    }

    /*@Post(value = USER_URI)
    public Single<Response> createUser(@Body Single<Request<UserDto>> request, HttpRequest httpRequest){

        return request.map(r -> {
            handleRequestObject(r, httpRequest);
            Response response = new Response(request);
            response.setData(userService.saveUser(r.getData()));
            return response;
        });
    }*/

    public void handleRequestObject(Request request,
                                       HttpRequest httpRequest){
        if(request == null){
            request = new Request();
        }
        request.setHttpRequest(httpRequest);
        request.setParams(httpRequest.getParameters().asMap());
    }

}