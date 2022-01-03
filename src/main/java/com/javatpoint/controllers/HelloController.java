package com.javatpoint.controllers;
import com.javatpoint.dao.TeacherDao;
import com.javatpoint.models.Teacher;
import com.javatpoint.parser.LogBookParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private TeacherDao teacherDao;

    @RequestMapping("/hello")
    public String redirect()
    {
        return "viewpagw";
    }


    @RequestMapping("/helloagain")
    public String displayHello()
    {
        return "final";
    }

    @RequestMapping(path = "/parseUsers", method = RequestMethod.POST)
    public ModelAndView ParserUsers() {

        LogBookParser logBookParser = new LogBookParser();
        logBookParser.Init();

        List<Teacher> teachArray = logBookParser.ParserTeachers();

        for (Teacher tmpTeacher : teachArray)
        {
            teacherDao.save(tmpTeacher);
        }

        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("usersFromServer", teachArray);

        logBookParser.ParserInfo(145);

        return modelAndView;
    }

    @RequestMapping(path = "/parseInfo", method = RequestMethod.POST)
    public ModelAndView ParserInfo() {

        LogBookParser logBookParser = new LogBookParser();
        logBookParser.Init();

        logBookParser.ParserInfo(145);

        List<Teacher> teachArray = new ArrayList<>();

        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("usersFromServer", teachArray);

        return modelAndView;
    }

}