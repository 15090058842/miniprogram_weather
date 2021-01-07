package com.zy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notepad")
public class NotePad {
    //记事本
    @Id
    private Integer noteId;
    private String title;
    private String content;
    private String img;

    public NotePad() {
    }

    public NotePad(Integer noteId, String title, String content, String img) {
        this.noteId = noteId;
        this.title = title;
        this.content = content;
        this.img = img;
    }

    @Override
    public String toString() {
        return "NotePad{" +
                "noteId=" + noteId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
