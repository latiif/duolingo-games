/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var websocketSession;

var standings;

var currQuestion;

function f_onmessage(evt) {
    websocketMessages = document.getElementById('standings');
    
    var info = JSON.parse(evt.data);
    
    var html = ''
    
    console.log(info)
    
    standings[`${info.username}`] = info;
    
    for (var user in standings){
        if (standings.hasOwnProperty(`${user}`)){
            userinfo = standings[`${user}`];
            html += `<p>${user}</p><div class="progress"><div class="progress-bar progress-bar-success" role="progressbar" style="width:${userinfo.numCorrect*10}%"></div><div class="progress-bar progress-bar-warning" role="progressbar" style="width:${(userinfo.currQuestion-userinfo.numCorrect) * 10}%"></div></div></br>`
        }
    }
    
    websocketMessages.innerHTML = html;
}

function open(gameid) {
    if (!websocketSession) {
        websocketSession = new WebSocket('ws://' + document.location.host  +`/duogames/quizmultiplayer/${gameid}`);
        websocketSession.onmessage = f_onmessage;
        standings = {}
        currQuestion = 1;
    }
}

function close() {
    if (websocketSession) {
        websocketSession.close();
    }
}

function sendMessage(userName,numberCorrect) {
    msg = {
        username: userName,
        currQuestion: currQuestion++,
        numCorrect: numberCorrect
    };
    
    websocketSession.send(JSON.stringify(msg));
}