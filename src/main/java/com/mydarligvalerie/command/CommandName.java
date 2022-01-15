package com.mydarligvalerie.command;

public enum CommandName {

    COMPLIMENT("/saash");

    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return commandName;
    }
}
