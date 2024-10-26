package org.example.MiddleJava2Sem;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    public String name;
    public int age;
    public String state = "start";
    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        checkText(text);
        if (state.equals("start")){
            sendMessageBot(update,"Hello everyone, what is your name?");
            state = "name";
            return;

        }
        if (state.equals("name")){
            sendMessageBot(update,"Good, please, enter your age");
            state = "age";
            return;
        }
        if (state.equals("age")){
            sendMessageBot(update,"Well, send your data in database");
            System.out.println(name);
            System.out.println(age);
            WriteData.WriteD(name,age);
        }
    }

    @Override
    public String getBotUsername() {
        return "Les18_1OpenCv_Radchuk_bot";
    }
    public String getBotToken(){
        return "6567440090:AAGC0oKTz-R9jKOxQUDmevEmvKc7r_RT8m0";
    }
    public void sendMessageBot(Update update,String msg){
        SendMessage sendMessage = new SendMessage();
        long id = update.getMessage().getChatId();

        sendMessage.setChatId(id);
        sendMessage.setText(msg);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    public  void checkText(String msg){
        if (state.equals("name")){
            name = msg;
            return;
        }
        if (state.equals("age")){
            age = Integer.parseInt(msg);
            return;
        }

    }
}
