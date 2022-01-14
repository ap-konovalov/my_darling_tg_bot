package com.mydarligvalerie.command;

import com.google.common.collect.ImmutableMap;
import com.mydarligvalerie.service.SendBotMessageService;

import static com.mydarligvalerie.command.CommandName.COMPLIMENT;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;

    public CommandContainer(SendBotMessageService sendBotMessageService){
        commandMap = new ImmutableMap.Builder<String, Command>()
                .put(COMPLIMENT.getCommandName(), new ComplimentCommand(sendBotMessageService))
                .build();
    }

    public Command retrieveCommand(String commandIdentifier){
        return commandMap.get(commandIdentifier);
    }
}
