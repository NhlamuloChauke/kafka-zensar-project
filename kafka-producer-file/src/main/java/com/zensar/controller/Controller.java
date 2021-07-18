package com.zensar.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.utils.FileContent;

@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String topic = "output-xml-file-topic";
    private static final String filePath = "src/main/resources/data/Person.json";
    
    @PostMapping(value="/trigger")
    public String sendFileData() throws IOException {
    	
    	//read file from the path 
    	String fileContent = FileContent.readFileContent(filePath);
                
        //Send the file content
        kafkaTemplate.send(topic, fileContent);

        return "Json file published successfully...";
    }
}
