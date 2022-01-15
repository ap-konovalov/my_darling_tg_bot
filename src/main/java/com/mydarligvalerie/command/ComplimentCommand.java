package com.mydarligvalerie.command;

import com.mydarligvalerie.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class ComplimentCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public ComplimentCommand(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), getRandomCompliment());
    }

    private List<String> createComplimentsList(){
        return asList("умна", "красива", "богата", "солнечна", "жизнерадостна", "привлекательна", "весела",
                "сообразительна", "активна", "профессиональна", "спокойна", "не агрессивна", "сильна", "интеллигентна",
                "хорошо воспитана", "пластична", "скромна", "гибка", "хитра", "сексуальна", "стройна", "заботлива",
                "хороша собой", "вежлива", "рассудительна", "не банальна", "хозяйственна", "проворна", "начитана",
                "образована", "лингвистична", "здорова");
    }

    private List<String> createIntroductionsList(){
        return asList("Дорогая Лера", "Любимая Лера", "Птичка моя", "Лерочка", "Уважаемая Валерия", "Радость моя", "Лера",
                "Свет моих очей", "Солнце мое", "Моя ненаглядная", "Принцесса моя");
    }

    private String getRandomCompliment(){
        Random random = new Random();
        List<String> compliments = createComplimentsList();
        List<String> introductions = createIntroductionsList();
        return introductions.get(random.nextInt(introductions.size())) + ", ты " + compliments.get(random.nextInt(compliments.size()));
    }
}
