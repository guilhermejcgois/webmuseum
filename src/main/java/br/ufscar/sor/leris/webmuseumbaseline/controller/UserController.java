package br.ufscar.sor.leris.webmuseumbaseline.controller;

import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.service.MuseumService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Guilherme Gois
 */
@Controller
public class UserController {

    @RequestMapping("Login")
    public ModelAndView doLogin(String username, String password) {
        ModelAndView mav = null;

        if (username.equals(password)) {
            if (username.equals("student")) {
                List<Museum> museums = new MuseumService().listMuseum();
                if (museums == null || museums.isEmpty()) {
                    mav = new ModelAndView("user/withoutMuseum");
                    mav.addObject("museums", museums);
                    mav.setViewName("Com museu");
                } else {
                    mav = new ModelAndView("user/withMuseum");
                    mav.setViewName("Sem museu");
                }
            } else {
                mav = new ModelAndView("management/home");
            }
        }

        return mav;
    }

}
