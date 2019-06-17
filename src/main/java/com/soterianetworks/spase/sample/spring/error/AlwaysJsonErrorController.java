package com.soterianetworks.spase.sample.spring.error;

import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//un-comment this out to render the web browser response format to json
//and disable the default basic-error-controller from spring boot
@Controller
public class AlwaysJsonErrorController extends AbstractErrorController {

    public AlwaysJsonErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> handleError(HttpServletRequest request) {
        return super.getErrorAttributes(request, true);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
