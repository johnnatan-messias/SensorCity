window.onload = initUser;

function initUser() {
    connect();
}

function drawCanvas(idEnvironment) {
    initCanvas(false, mouseUpDevice, idEnvironment);
}

//------------------------------------------------------------------------------

function mouseUpDevice() {
    if (devicePressed.switchable) {
        deviceName = devicePressed.name;
        $.getJSON(getUrl('rest/device/switch?name='+deviceName), null, function(data) {
            if (data !== 'OK') {
                alert(data);
            }
        }); 
    } else {
        alert(devicePressed.name + ' = ' + devicePressed.value);
    }
}
