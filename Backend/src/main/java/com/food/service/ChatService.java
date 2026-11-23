package com.food.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public String getReply(String message) {

        if (message == null || message.trim().isEmpty()) {
            return "Please enter a message so I can help you.";
        }

        String msg = message.toLowerCase().trim();

        // Greetings
        if (msg.contains("hello") || msg.contains("hi")
                || msg.contains("hey")) {

            return "Hello! Welcome to Beyond Ways. "
                    + "How can I help you today?";
        }

        // About the project
        if (msg.contains("what is beyond ways")
                || msg.contains("about")
                || msg.contains("purpose")) {

            return "Beyond Ways is a food redistribution and reuse "
                    + "platform designed to connect food donors with "
                    + "organizations or people in need, helping reduce "
                    + "food waste.";
        }

        // Food donation
        if (msg.contains("donate")
                || msg.contains("donation")
                || msg.contains("donor")) {

            return "To donate food, log in using your donor account, "
                    + "open the donation section, enter the food details, "
                    + "quantity and required information, and submit "
                    + "your donation.";
        }

        // Food receiver
        if (msg.contains("request food")
                || msg.contains("receive food")
                || msg.contains("receiver")
                || msg.contains("need food")) {

            return "If you are a receiver, log in using your receiver "
                    + "account and check the available food donations. "
                    + "You can submit a request for food according to "
                    + "the availability shown on the platform.";
        }

        // Volunteer
        if (msg.contains("volunteer")
                || msg.contains("delivery")
                || msg.contains("pickup")
                || msg.contains("pick up")) {

            return "Volunteers help with food collection and delivery. "
                    + "Log in using your volunteer account to check "
                    + "the tasks and delivery details available to you.";
        }

        // Registration
        if (msg.contains("register")
                || msg.contains("registration")
                || msg.contains("sign up")
                || msg.contains("signup")) {

            return "To register, open the Register page on Beyond Ways, "
                    + "fill in the required information, choose your "
                    + "appropriate role, and submit the form.";
        }

        // Login
        if (msg.contains("login")
                || msg.contains("log in")
                || msg.contains("password")) {

            return "Go to the Login page and enter your registered "
                    + "email and password. If you forgot your password, "
                    + "use the Forgot Password option.";
        }

        // Food waste
        if (msg.contains("waste")
                || msg.contains("environment")
                || msg.contains("biogas")
                || msg.contains("reuse")) {

            return "Beyond Ways aims to reduce food waste by redistributing "
                    + "surplus edible food and supporting reuse of food "
                    + "waste that cannot be consumed, where appropriate.";
        }

        // Contact/help
        if (msg.contains("help")
                || msg.contains("support")
                || msg.contains("contact")) {

            return "I'm the Beyond Ways virtual assistant. I can help "
                    + "with registration, donations, food requests, "
                    + "volunteers, login and information about the project.";
        }

        // Default response
        return "I'm still learning! I can help you with Beyond Ways, "
                + "food donations, food requests, registration, login, "
                + "volunteers and food waste reduction. "
                + "Please try asking me about one of these topics.";
    }
}