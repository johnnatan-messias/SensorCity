//window.onload = initAdmin;

function initAdmin() {
    
}

function drawCanvas(idEnvironment) {
    initCanvas(true, mouseUpDevice, idEnvironment);
}

//------------------------------------------------------------------------------

function mouseUpDevice() {  
    $.getJSON(getUrl(
            'rest/device/move?id='+devicePressed.id+
            '&x='+devicePressed.x+
            '&y='+devicePressed.y), null, null); 
}
