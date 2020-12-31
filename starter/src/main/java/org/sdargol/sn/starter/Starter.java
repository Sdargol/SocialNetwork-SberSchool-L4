package org.sdargol.sn.starter;

import org.sdargol.api.message.IMessage;
import org.sdargol.api.message.Message;
import org.sdargol.api.service.IService;
import org.sdargol.sn.client.Client;
import org.sdargol.sn.posts.PostManager;
import org.sdargol.sn.server.Server;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        Client client = new Client();
        Server server = new Server();
        IMessage message = new Message();
        Scanner scanner = new Scanner(System.in);

        String input;

        System.out.println("[STARTER]: Starter run!");

        //IService posts = new PostManager();
        //posts.add(0, "Это пост из Java");
        //System.out.println(posts.getById(0));

        while(true){
            System.out.print("Enter header(or exit): ");
            input = scanner.nextLine();
            if(input.equals("exit")){
                System.out.println("[STARTER]: Exit from loop.");
                break;
            }
            message.setHeader(input);

            System.out.print("Enter body: ");
            input = scanner.nextLine();
            message.setBody(input);

            client.sendMessage(server,message);
            client.render(server);

        }

        scanner.close();
        System.out.println("[STARTER]: Starter finish!");
    }
}
