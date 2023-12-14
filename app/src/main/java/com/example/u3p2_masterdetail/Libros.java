package com.example.u3p2_masterdetail;

import androidx.room.Entity;

@Entity
public class Libros {
        private String title;
        private String author;
        private int coverImage;
        private String description;

        public Libros(String title, String author, /*int coverImage,*/ String description) {
                this.title = title;
                this.author = author;
               // this.coverImage = coverImage;
                this.description = description;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public int getCoverImage() {
                return coverImage;
        }

        public void setCoverImage(int coverImage) {
                this.coverImage = coverImage;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

}
