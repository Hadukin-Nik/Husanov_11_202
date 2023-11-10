package org.example;

import lombok.AllArgsConstructor;
import org.example.configuration.BotConfig;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {
    private final BotConfig botConfig;
    private final Set<String> commands;

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        String currency = "";

        if(update.hasMessage() && update.getMessage().hasText()){

            long chatId = update.getMessage().getChatId();
            String[] afterSplit = update.getMessage().getText().split(" ");
            String command = afterSplit[0];
            List<Integer> pars = new ArrayList<>();
            if(afterSplit.length > 1) {
                pars = Arrays.stream(afterSplit).filter(m -> m.charAt(0) != '/').map(m -> Integer.parseInt(m)).toList();
            }
            switch (command){
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;
                case "/info":
                    infoCommandReceived(chatId);
                    break;
                case "/second_urn_model":
                    if(pars.size() != 4) {currency += "wrong parameters"; break;}
                    if(pars.get(0) < pars.get(1)) {currency += "wrong parameters"; break;}
                    if(pars.get(1) >= pars.get(2)) {currency += "wrong parameters"; break;}

                    currency += MathCalculator.second_urn_model(pars.get(0), pars.get(1), pars.get(2), pars.get(3));
                    break;
                case "/first_urn_model":
                    if(pars.size() != 3) {currency += "wrong parameters"; break;}
                    if(pars.get(0) < pars.get(1)) {currency += "wrong parameters"; break;}
                    if(pars.get(1) >= pars.get(2)) {currency += "wrong parameters"; break;}

                    currency += MathCalculator.first_urn_model(pars.get(0), pars.get(1), pars.get(2));
                    break;
                case "/placements_no_repetitions":
                    if(pars.size() != 2) {currency += "wrong parameters"; break;}
                    currency += MathCalculator.placements_no_repetitions(pars.get(0), pars.get(1));
                    break;
                case "/combinations_with_repetitions":
                    if(pars.size() != 2) {currency += "wrong parameters"; break;}
                    currency += MathCalculator.combinations_with_repetitions(pars.get(0), pars.get(1));
                    break;
                case "/placements_with_repetitions":
                    if(pars.size() != 2) {currency += "wrong parameters"; break;}
                    currency += MathCalculator.placements_with_repetitions(pars.get(0), pars.get(1));
                    break;
                case "/permutations_no_repetitions":
                    if(pars.size() != 1) {currency += "wrong parameters"; break;}
                    currency += MathCalculator.permutations_no_repetitions(pars.get(0));
                    break;
                case "/combinations_no_repetitions":
                    if(pars.size() != 2) {currency += "wrong parameters"; break;}

                    currency += MathCalculator.combinations_no_repetitions(pars.get(0), pars.get(1));
                    break;
                case "/permutations_with_repetitions":
                    if(pars.size() < 1) {currency += "wrong parameters"; break;}

                    currency += MathCalculator.permutations_with_repetitions(pars);
                    break;
            }

            sendMessage(chatId, currency);

        }

    }

    private void startCommandReceived(Long chatId, String name) {
        String answer = "Hi, " + name + ", nice to meet you!" + "\n" + "Type /info if you want to see commands";
        sendMessage(chatId, answer);
    }
    private void infoCommandReceived(Long chatId) {
        String answer = "";

        Method[] methods = MathCalculator.class.getMethods();

        for(Method m : methods) {
            if(m.getName().equals("equals")) break;
            answer += "/" + m.getName();

            if(m.getParameters().length == 1) {
                if(m.getName().equals("permutations_no_repetitions")) {
                    answer += " n";
                } else {
                    answer += " elem1 elem2 elem3 ... elem_n";
                }
            } else {
                switch (m.getParameters().length) {
                    case 2:
                        answer += " n k";
                        break;
                    case 3:
                        answer += " n k m";
                        break;
                    case 4:
                        answer += " n k m r";
                        break;
                    default:
                        answer += "error";
                }
            }

            answer+= "\n";
        }

        sendMessage(chatId, answer);
    }
    private void sendMessage(Long chatId, String textToSend){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}