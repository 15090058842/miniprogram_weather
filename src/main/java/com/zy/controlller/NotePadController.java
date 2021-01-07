package com.zy.controlller;

import com.zy.entity.NotePad;
import com.zy.entity.WXResult;
import com.zy.service.NotePadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notepad")
public class NotePadController {
    @Autowired
    NotePadService notePadService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public WXResult save(@RequestBody NotePad notePad){
        return notePadService.save(notePad);
    }
    @RequestMapping(value = "/delete/{noteId}",method = RequestMethod.DELETE)
    public WXResult delete(@PathVariable Integer noteId){
        return notePadService.delete(noteId);
    }
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public WXResult findAll(){
        return notePadService.findAll();
    }
    @RequestMapping(value = "/find/{noteId}",method = RequestMethod.GET)
    public WXResult find(@PathVariable Integer noteId){
        return notePadService.find(noteId);
    }



}
