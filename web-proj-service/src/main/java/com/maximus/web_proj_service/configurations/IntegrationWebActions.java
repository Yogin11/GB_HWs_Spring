package com.maximus.web_proj_service.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationWebActions {
    @Bean
    public MessageChannel textInputChanel() {
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInputChanel", outputChannel = "fileWriterChanel")
    public GenericTransformer<String, String> mainTransformer() {

        return text -> {
               String newTextPart1 = text.substring(0, text.lastIndexOf("в"));
                String newTextPart2 = text.substring(text.lastIndexOf("в") + 2, text.lastIndexOf("T"));
                String newTextPart3 = text.substring(text.lastIndexOf("T") + 1, text.lastIndexOf("."));
            return "(" + newTextPart2 + ") " + newTextPart3 + " " + newTextPart1;
        };
    }

    @Bean
    public MessageChannel fileWriterChanel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChanel")
    public FileWritingMessageHandler messageHandler() {

        FileWritingMessageHandler handler = new FileWritingMessageHandler(
                new File(
                        "./files"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }

}
