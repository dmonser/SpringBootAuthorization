package ru.netology.SpringBootAuthorization.excetion;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}
