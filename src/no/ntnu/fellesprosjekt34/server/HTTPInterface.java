package no.ntnu.fellesprosjekt34.server;

import no.ntnu.fellesprosjekt34.User;

import java.sql.SQLException;

/**
 * Created by ludvig on 27.02.15.
 */
public class HTTPInterface {

    private Database db;

    public HTTPInterface(Database db){
        this.db = db;
    }

    @HTTPExport(url="user/from_email/[email]", method="GET")
    private User getUser(RequestData requestData, String email) throws SQLException, NotFoundInDBException {
        User u = User.getFromDB(db, email);
        if (requestData.isLoggedIn(u)){
            return u;
        } else {
            return u;
        }
    }
}
