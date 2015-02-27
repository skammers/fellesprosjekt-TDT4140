package no.ntnu.fellesprosjekt34.server;

import no.ntnu.fellesprosjekt34.User;

public class RequestData {

    private Session session;

    public boolean isLoggedIn(User u){
        return (session != null && session.getUser() != null && session.getUser().getId() == u.getId());
    }
}
