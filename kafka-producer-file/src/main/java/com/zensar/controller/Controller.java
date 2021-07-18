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

    //kafka topic
    private static final String topic = "person-json-file-topic";
    
    //file path and filename
    private static final String filePath = "../data/Person.json";
    
    @PostMapping(value="/send")
    public String sendFileData() throws IOException {
    	
    	//read file from the path 
    	String fileContent = FileContent.readFileContent(filePath);
                
        //Send the file content
        kafkaTemplate.send(topic, fileContent);

        return "Json file published successfully...";
    }
}
