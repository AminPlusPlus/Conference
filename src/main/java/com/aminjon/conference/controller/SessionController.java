package com.aminjon.conference.controller;

import com.aminjon.conference.models.Session;
import com.aminjon.conference.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session){
        return  sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id,HttpServletResponse response) {

        if (!sessionRepository.existsById(id)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session, HttpServletResponse response){
        if (!sessionRepository.existsById(id)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        Session existSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session,existSession,"session_id");

        return sessionRepository.saveAndFlush(existSession);

    }


}
