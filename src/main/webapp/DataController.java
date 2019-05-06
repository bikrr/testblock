package main.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class DataController {

    @RequestMapping(value = "/commandStartStopAjax", method = RequestMethod.POST)
    @ResponseBody
    public String getCommandAjax(@RequestParam(value = "ajaxcommand", required = false) String commandtext) throws IOException {

        return "hello  1";
    }


    @RequestMapping(value = "/commandStartStopAjax2", method = RequestMethod.POST)
    @ResponseBody
    public String getCommandAjax2(@RequestParam(value = "ajaxcommand2", required = false) String commandtext2) throws IOException {

        return "hello  2";
    }


}
