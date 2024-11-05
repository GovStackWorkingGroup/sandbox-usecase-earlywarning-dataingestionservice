package global.govstack.data_ingestion.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import global.govstack.data_ingestion.dto.DemoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class DataIngestionService {
    private static final String TOPIC = "threats-topic";
    private static final Integer PARTITION = 0;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;

    public DataIngestionService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    public ResponseEntity<String> emitMessage(DemoDto message) {
        try {
            this.kafkaTemplate.send(TOPIC, PARTITION, message.key(), mapper.writeValueAsString(message.threat()));
            return ResponseEntity.ok("Message processed from ICPAC");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
