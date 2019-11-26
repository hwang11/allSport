var stompClient = null;
var roomId = 20;
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame); 
        //파라미터값으로 채팅방id를 전달하고 싶은데 어떻게 전달? 
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
        stompClient.subscribe('/topic/chat', function (chat) {
        	showChat(JSON.parse(chat.body));
        });
    });
}

//function getParameterByName(name) {
//	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
//	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
//	results = regex.exec(location.search);
//	return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
//	}
//
//function getParam(sname) {
//
//    var params = location.search.substr(location.search.indexOf("?") + 1);
//
//    var sval = "";
//
//    params = params.split("&");
//
//    for (var i = 0; i < params.length; i++) {
//
//        temp = params[i].split("=");
//
//        if ([temp[0]] == sname) { sval = temp[1]; }
//
//    }
//
//    return sval;
//
//}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'chatMessage_writer': $("#chatMessage_writer").val()}));
}

function sendChat() {
	stompClient.send("/app/chat", {}, JSON.stringify({'chatMessage_writer': $("#chatMessage_writer").val(), 
		'chatMessage_message': $("#chatMessage_message").val(), 'idChatRoom':roomId }));
}
//stringify 문자열화 시키는거 

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}
function showChat(chat) {
    $("#greetings").append("<tr><td>" + chat.chatMessage_writer + " : " + chat.chatMessage_message + "</td></tr>");
}
$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    $( "#chatSend" ).click(function(){ sendChat(); });
});
