package com.mydarligvalerie.service;

import com.mydarligvalerie.bot.MyDarlingValerieBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final MyDarlingValerieBot myDarlingValerieBot;

    @Autowired
    public SendBotMessageServiceImpl(MyDarlingValerieBot myDarlingValerieBot) {
        this.myDarlingValerieBot = myDarlingValerieBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try{
            myDarlingValerieBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
