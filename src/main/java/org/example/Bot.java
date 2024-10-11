package org.example;

import org.example.Pixabay.GetData;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        long id = update.getMessage().getChatId();
        String msg = update.getMessage().getText();
        System.out.println(msg);
        SendMessage sendMessage = new SendMessage();
        SendPhoto sendPhoto = new SendPhoto();

        try {
            String img =  GetData.getDataFromPixabay();

            sendPhoto.setChatId(id);
            sendPhoto.setPhoto(new InputFile(img));
            execute(sendPhoto);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (msg.equals("hello")){
            sendMessage.setChatId(id);
            sendMessage.setText("Hello my bot!!!");
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getBotUsername() {
        return "Les18_1OpenCv_Radchuk_bot";
    }
    public String getBotToken(){
        return "6567440090:AAGC0oKTz-R9jKOxQUDmevEmvKc7r_RT8m0";
    }
}
