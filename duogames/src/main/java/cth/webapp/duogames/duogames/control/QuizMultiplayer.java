/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author latiif
 */
@ServerEndpoint("/quizmultiplayer/{gameid}")
public class QuizMultiplayer {

    private static final Map<String, List<Session>> sessions = new HashMap<String, List<Session>>();

    @OnOpen
    public void connect(@PathParam("gameid") String gameid, Session session) {
        List<Session> sessions_ = sessions.getOrDefault(gameid, new LinkedList<Session>());

        if (sessions_.contains(session)) {
            //Already in the game
        } else {
            //Add it to the game
            sessions_.add(session);
            sessions.put(gameid, sessions_);
        }
    }

    @OnMessage
    public void onMessage(final String message, @PathParam("gameid") String gameid, final Session client) {
        List<Session> sessions_ = sessions.getOrDefault(gameid, new LinkedList<Session>());

        sessions_.stream().forEach((sess) -> {
            try {

                sess.getBasicRemote().sendText(message);

            } catch (IOException ex) {
            }
        });

    }

    @OnClose
    public void close(@PathParam("gameid") String gameid, Session session) {
        List<Session> sessions_ = sessions.getOrDefault(gameid, new LinkedList<Session>());

        if (sessions_.contains(session)) {
            sessions_.remove(session);
            sessions.put(gameid, sessions_);

        } else {
            // already not in game
        }
    }

}
