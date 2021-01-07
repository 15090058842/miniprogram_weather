package com.zy.service;

import com.zy.dao.NotePadDao;
import com.zy.entity.WXResult;
import com.zy.entity.NotePad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class NotePadService {
    @Autowired
    NotePadDao notePadDao;

    public WXResult save(NotePad notePad){
        if (notePad.getNoteId()==null||notePad.getNoteId().equals("")){
            notePad.setNoteId((int)(Math.random()*100000));
            System.out.println("id"+notePad.getNoteId());
        }
        NotePad save = notePadDao.save(notePad);
        System.out.println(save.toString());
        return WXResult.ok(save);
    }
    public WXResult delete(Integer noteId){
        notePadDao.deleteByNoteId(noteId);
        return WXResult.ok();
    }
    public WXResult findAll(){
        List<NotePad> all = notePadDao.findAll();
        return WXResult.ok(all);
    }
    public WXResult find(Integer noteId){
        NotePad notePad = notePadDao.findByNoteId(noteId);
        return WXResult.ok(notePad);
    }


}
