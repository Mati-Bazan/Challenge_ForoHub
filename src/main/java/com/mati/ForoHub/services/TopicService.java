package com.mati.ForoHub.services;

import com.mati.ForoHub.exceptions.ResourceNotFoundException;
import com.mati.ForoHub.models.Topic;
import com.mati.ForoHub.DTO.UpdateTopicDTO;
import com.mati.ForoHub.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Long id, UpdateTopicDTO updateTopicDTO) {
        // Buscar el tópico existente
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tópico no encontrado con el ID: " + id));

        // Actualizar los campos
        topic.setTitle(updateTopicDTO.getTitle());
        topic.setContent(updateTopicDTO.getContent());

        // Guardar los cambios
        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        // Verificar si el tópico existe
        if (!topicRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tópico no encontrado con el ID: " + id);
        }
        // Eliminar el tópico
        topicRepository.deleteById(id);
    }
}
