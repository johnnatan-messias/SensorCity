var ws = null;

function connect() {
    if (window.location.protocol === "https:") {
        wsProtocol = "wss://";
    } else {
        wsProtocol = "ws://";
    }
    contextPath = location.pathname.split('/')[1];
    url = wsProtocol + window.location.host + '/' + contextPath + '/websocket';

    if ('WebSocket' in window) {
        ws = new WebSocket(url);
    } else if ('MozWebSocket' in window) {
        ws = new MozWebSocket(url);
    } else {
        log('WebSocket is not supported by this browser.');
        return;
    }
    
    ws.onopen = function () {
        log('Conexao aberta.');
    };
    
    ws.onmessage = function (event) {
        msg = event.data;
        log(msg);
        //se servidor notificou a alteracao de estado do dispositivo:
        if (msg.indexOf('updateDeviceValue') !== -1) { 
            values = msg.split("|"); //ex: updateDeviceValue|Luz|1
            updateDeviceValue(values[1], values[2], true);   
        }
    };
    
    ws.onclose = function () {
        log('Conexao fechada.');
    };
}

function send() {
    if (ws !== null) {
        var message = document.getElementById('message').value;
        log('Enviado: ' + message);
        ws.send(message);
    } else {
        log('Connection not established, please connect.');
    }
}

function log(message) {
    now = new Date(); 
    fmtDate = 
        formatField(now.getHours(), 2) + ':' + 
        formatField(now.getMinutes(), 2) + ':' + 
        formatField(now.getSeconds(), 2) + ':' + 
        formatField(now.getMilliseconds(), 3); 
        
    line = fmtDate + ' WebSocket: ' +  message;               
    console.log(line);
    document.getElementById('log').innerHTML = line;
}

function formatField(value, len) {
    s = String(value);
    while (s.length < len) {
        s = '0' + s;
    }
    return s;
}
