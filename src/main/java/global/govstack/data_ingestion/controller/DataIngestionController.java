package global.govstack.data_ingestion.controller;

import global.govstack.data_ingestion.dto.DemoDto;
import global.govstack.data_ingestion.service.DataIngestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/")
public class DataIngestionController {
    private final DataIngestionService dataIngestionService;

    public DataIngestionController(DataIngestionService dataIngestionService) {
        this.dataIngestionService = dataIngestionService;
    }

    @PostMapping(path = "/emitMessage")
    public ResponseEntity<String> send(@RequestBody DemoDto message) {
        return this.dataIngestionService.emitMessage(message);
    }
}