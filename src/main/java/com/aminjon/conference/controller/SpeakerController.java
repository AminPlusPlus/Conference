package com.aminjon.conference.controller;

import com.aminjon.conference.models.Speaker;
import com.aminjon.conference.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    @PostMapping
    public Speaker create (@RequestBody final Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id, HttpServletResponse response){

        if (!speakerRepository.existsById(id))
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker,HttpServletResponse response) {
        if (!speakerRepository.existsById(id))
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        Speaker currentSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker,currentSpeaker,"speaker_id");

        return  currentSpeaker;
    }



}
