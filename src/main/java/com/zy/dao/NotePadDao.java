package com.zy.dao;

import com.zy.entity.NotePad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotePadDao extends JpaSpecificationExecutor<NotePad>, JpaRepository<NotePad,String> {
    void deleteByNoteId(Integer noteId);
    NotePad findByTitleAndContent(String a,String n);
    NotePad findByNoteId(Integer noteId);
}
