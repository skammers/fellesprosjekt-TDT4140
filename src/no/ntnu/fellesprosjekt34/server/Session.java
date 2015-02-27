package no.ntnu.fellesprosjekt34.server;

import no.ntnu.fellesprosjekt34.User;

import java.time.LocalDateTime;

public class Session {
    private LocalDateTime created;
    private User user;

    public Session(LocalDateTime created, User user) {
        this.created = created;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
