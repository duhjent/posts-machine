package com.duhjent.postsmachine.entities.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class CommandReader {
    public static List<Command> read(Path path) {
        List<Command> commandList = new ArrayList<Command>();
        try{
			File file = path.toFile();
			Scanner s = new Scanner(file);
			while(s.hasNext()) {
				switch(s.next()) {
					case "V":
						commandList.add(new MarkCommand(s.nextInt()));
						break;
					case "X":
						commandList.add(new EraseCommand(s.nextInt()));
						break;
					case "<":
						commandList.add(new LeftCommand(s.nextInt()));
						break;
					case ">":
						commandList.add(new RightCommand(s.nextInt()));
						break;
					case "?":
						commandList.add(new IfCommand(s.nextInt(), s.nextInt()));
						break;
					case "!":
						commandList.add(new StopCommand());
						break;
				}
			}
			s.close();
		}
		catch(IOException e){}
		return commandList;
    }
}