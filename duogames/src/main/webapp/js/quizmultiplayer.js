/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var websocketSession;

var standings;



var currQuestion;

function f_onmessage(evt) {


    var info = JSON.parse(evt.data);

    switch (info.type) {
        case "ANSWER":
            handleANSWER(info);
            break;

        case "LOGIN":
            handleLOGIN(info);
            break;
    }

}


function handleANSWER(info) {
    websocketMessages = document.getElementById('standings');
    var html = ''

    console.log(info)

    standings[`${info.username}`] = info;

    for (var user in standings) {
        if (standings.hasOwnProperty(`${user}`)) {
            userinfo = standings[`${user}`];
            html += `<p>${user}</p><div class="progress"><div class="progress-bar progress-bar-success" role="progressbar" style="width:${userinfo.numCorrect * 10}%"></div><div class="progress-bar progress-bar-warning" role="progressbar" style="width:${(userinfo.currQuestion - userinfo.numCorrect) * 10}%"></div></div></br>`
        }
    }

    websocketMessages.innerHTML = html;
}

function handleLOGIN(info) {
    participantsLog = document.getElementById('participants');


   var html = `<div class="alert alert-info" role="alert">${info.username} just joined!</div></br>`

    participantsLog.innerHTML += html;
}



function open(gameid,userName) {
    if (!websocketSession) {
        websocketSession = new WebSocket('ws://' + document.location.host + `/duogames/quizmultiplayer/${gameid}`);
        websocketSession.onmessage = f_onmessage;
        websocketSession.onopen = () => login(userName)
        standings = {}
        currQuestion = 1;
    }
}

function close() {
    if (websocketSession) {
        websocketSession.close();
    }
}

function sendMessage(userName, numberCorrect) {
    msg = {
        type: "ANSWER",
        username: userName,
        currQuestion: currQuestion++,
        numCorrect: numberCorrect
    };

    websocketSession.send(JSON.stringify(msg));
}


function login(userName) {
    msg = {
        type: "LOGIN",
        username: userName
    };

    websocketSession.send(JSON.stringify(msg));
}