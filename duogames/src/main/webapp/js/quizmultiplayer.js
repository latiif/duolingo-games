/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var websocketSession;

function f_onmessage(evt) {
    websocketMessages = document.getElementById('eventlog');
    
    var info = JSON.parse(evt.data);
    
    var msg = `User ${info.username} is now at question nr ${info.currQuestion} out of which ${info.numCorrect} is/are correct`;
    
    websocketMessages.innerHTML = websocketMessages.innerHTML + msg + '<br/>';
}

function open(gameid) {
    if (!websocketSession) {
        websocketSession = new WebSocket('ws://' + document.location.host  +`/duogames/quizmultiplayer/${gameid}`);
        websocketSession.onmessage = f_onmessage;
    }
}

function close() {
    if (websocketSession) {
        websocketSession.close();
    }
}

function sendMessage(userName,currentQuestion,numberCorrect) {
    msg = {
        username: userName,
        currQuestion: currentQuestion,
        numCorrect: numberCorrect
    };
    
    websocketSession.send(JSON.stringify(msg));
}