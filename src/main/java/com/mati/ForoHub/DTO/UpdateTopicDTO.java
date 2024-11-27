package com.mati.ForoHub.DTO;

import jakarta.validation.constraints.NotBlank;

public class UpdateTopicDTO {

    @NotBlank(message = "El título no puede estar vacío.")
    private String title;

    @NotBlank(message = "El contenido no puede estar vacío.")
    private String content;

    // Getters y setters
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
}
