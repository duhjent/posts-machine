package com.duhjent.postsmachine.entities.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class CommandReader {
    public static List<Command> read(MultipartFile multipartFile) {
        List<Command> commandList = new ArrayList<Command>();
        try{
			Scanner s = new Scanner(multipartFile.getInputStream());
			String str;
			while(s.hasNext()) {
				switch(str = s.next()) {
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
					default:
						if(str.contains("#")){
							s.nextLine();
						} else{
						break;
				}
			}
			s.close();
		}
		catch(IOException e){}
		return commandList;
    }
}