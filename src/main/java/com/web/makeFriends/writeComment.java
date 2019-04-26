package com.web.makeFriends;

import com.dao.MomentDao;
import com.entity.Moment;
import com.service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/writeMoment")
public class writeComment {
    @Autowired
    private MomentDao momentDao;
    @RequestMapping(value = "/words")
    public void words (HttpServletRequest request, HttpServletResponse response){
//        String pareas=request.getParameter("words");
//        Date currentTime = new Date();
//        long times=currentTime.getTime();

        List<Moment> list= momentDao.getId();
        System.out.println(list);

    }
}
